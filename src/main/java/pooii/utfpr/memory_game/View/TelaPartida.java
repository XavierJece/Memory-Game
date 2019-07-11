/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.View;

import com.sun.org.glassfish.external.statistics.Statistic;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import pooii.utfpr.memory_game.Model.RN.MatchGame;
import pooii.utfpr.memory_game.Model.RN.ControleBotoesSelecionados;
import pooii.utfpr.memory_game.Model.RN.EstadoBotoes;
import pooii.utfpr.memory_game.Model.DAO.GenericDAO;
import pooii.utfpr.memory_game.Model.DAO.GenericDAOImpl;
import pooii.utfpr.memory_game.Model.VO.Piece;
import pooii.utfpr.memory_game.Model.VO.PieceEnum;
import pooii.utfpr.memory_game.Model.VO.Player;
import pooii.utfpr.memory_game.Model.VO.Statistics;
import pooii.utfpr.memory_game.Model.VO.modalidades.Difficulty;

/**
 *
 * @author Jece Xavier
 */
public class TelaPartida extends JFrame{

    /*Atritutos =>  Atributos de Controle*/
    private int ESPACAMENTO_BUTTON = 20;
    private int quantidadejogadas = 0;
    private Piece piece;
    private boolean comPlayer;
    private int indiceJogador = 0;
    private int sequencia = 0;
    private List<Integer> pontuacao;
    
    private int QUANTIDADE_LIMITE_JOGADAS;
    private int dimensaoBtn;
    private int quantidadeImg;
    private int quantidadeConminacao;
    private int quantidadeColumn;
    private int valorAcerto;
    private List<Player> gamers;
    private MatchGame mg;
    
    /*Atritutos => Conpodentes de Tela*/
    private List<JLabel> lbljogadores;
    private List<JLabel> lblpontuacao;
    private List<JLabel> lbljogando;
    
    private JPanel painelPiece;
    private JPanel painelDados;
   
    private List<ControleBotoesSelecionados> listaControle;
    private List<ControleBotoesSelecionados> listaControleSelecionados;
    
    /*Atritutos => Eventos...*/
    ActionListener acoesBtn;
    
    /*Construtor*/
    public TelaPartida(MatchGame mg){
        super("Partida da modalidade " + mg.getModallity().getName());
        
        this.QUANTIDADE_LIMITE_JOGADAS = mg.getModallity().getQuatityCombination();
        this.dimensaoBtn = mg.getModallity().getDimensionPiece();
        this.quantidadeImg = mg.getModallity().getQuantityPiece();
        this.quantidadeConminacao = mg.getModallity().getQuatityCombination();
        this.quantidadeColumn = mg.getModallity().getQuatityColumn();
        this.valorAcerto = mg.getModallity().getValorAcerto();
        this.gamers = mg.getGamers();
        this.mg = mg;
        this.comPlayer = Boolean.TRUE;
        
        /*Instacionando Lista Controle*/
        this.listaControle = new ArrayList<>();
        this.listaControleSelecionados = new ArrayList<>();
        
        /*Para conseguir Img*/
        this.piece = new Piece();
        
        /*Criando ação no botão*/
         this.acoesBtn = virarPiece();
        

        /*Criando botões dinamicas*/
        definirLayoutTela();
        
        
    }
    
//    public TelaPartida(MatchGame mg){
//        super("Partida da modalidade " + mg.getModallity().getName());
//        
//        this.QUANTIDADE_LIMITE_JOGADAS = mg.getModallity().getQuatityCombination();
//        this.dimensaoBtn = mg.getModallity().getDimensionPiece();
//        this.quantidadeImg = mg.getModallity().getQuantityPiece();
//        this.quantidadeConminacao = mg.getModallity().getQuatityCombination();
//        this.quantidadeColumn = mg.getModallity().getQuatityColumn();
//        this.valorAcerto = mg.getModallity().getValorAcerto();
//        this.comPlayer = Boolean.FALSE;
//        
//        /*Instacionando Lista Controle*/
//        this.listaControle = new ArrayList<>();
//        this.listaControleSelecionados = new ArrayList<>();
//        
//        /*Para conseguir Img*/
//        this.piece = new Piece();
//        
//        /*Criando ação no botão*/
//         this.acoesBtn = virarPiece();
//        
//        
//        definirLayoutTela();
//    }
    
    /*Funções de configuração de Layout*/
    private void configuracaoBotoes(){
        
        /*Variaveis*/
        int identificacaoImage = 0;                     //Referencia para escolher a foto
        int quantidadeBotoes = this.quantidadeImg * this.quantidadeConminacao;
        List<Rectangle> posicionamentosBtn = this.gerarPosicoes();
        Random rand = new Random();
        ControleBotoesSelecionados controle = null;
        
        for(int i = 0; i < quantidadeBotoes; i++){
            
            if( (i % this.quantidadeConminacao) == 0){
                //Quantidade de controladores
                identificacaoImage++;                                                   //Incrementando a referencia para a foto
                controle = new ControleBotoesSelecionados();                            //Instanciando um controle
                controle.setImgFrenteBotao("Img_" + identificacaoImage);                //Definindo a Imagem que estará oculta
                controle.setImgCostasBotao(PieceEnum.IMAGEM_COSTAS_PADRAO.getNameImg());       //Definindo a Imagem que estará nas costas da carta
                
                this.listaControle.add(controle);                                       //Adicionado o controle na lista dos Controles Ativos
            }
            
            JButton btn = new JButton(piece.createImg(controle.getImgCostasBotao(), this.dimensaoBtn)); //Criando o Objeto Botão já com o Icon            
            this.painelPiece.add(btn);                                                       // Adicionando o Botão na Tela
            btn.addActionListener(this.acoesBtn);                                       //Adicionando a Ação de Click no Botão
            
            
            
            
            //btn.setBounds(posX, posY, dimensaoBtn, dimensaoBtn);           //Defnindo posição dinanicamento dos botões
            int posicaoBtn = rand.nextInt( ( (posicionamentosBtn.size() - 1) > 0 ) ? (posicionamentosBtn.size() - 1) : 1);
            btn.setBounds(posicionamentosBtn.get(posicaoBtn));
            posicionamentosBtn.remove(posicaoBtn);
            
            controle.addBtn(btn);                                                       //Adicionando o Botão no controle
            
        }
        //Colocar os botões na tela
        //Adaptar o tamanho da tela
        //Randomizar o posicionamento dos botões

    }
    
    private List<Rectangle> gerarPosicoes(){
        int quantidadeBotoes = this.quantidadeImg * this.quantidadeConminacao;
        int posX = this.ESPACAMENTO_BUTTON;             //Cordenada X onde pode será colocado o Botão
        int posY = this.ESPACAMENTO_BUTTON;             //Cordenada Y onde pode será colocado o Botão
        List<Rectangle> posicionamentosBtn = new ArrayList<>();
        
        /*Randomizando Posicao*/
        for(int i = 0; i < quantidadeBotoes; i++){
            Rectangle posicaoBtn = new Rectangle(posX, posY, this.dimensaoBtn, this.dimensaoBtn);
            posicionamentosBtn.add(posicaoBtn);
            
            if( ( (i + 1) % this.quantidadeColumn) == 0){
                posY += this.ESPACAMENTO_BUTTON + this.dimensaoBtn;
                posX = this.ESPACAMENTO_BUTTON;
            }else{
                posX += this.ESPACAMENTO_BUTTON + this.dimensaoBtn;
            }
        }
        
        return posicionamentosBtn;
    }
    
    private void definirLayoutTela(){
        /*instacionado os componentes e add Não tela*/
        definirPanelPiece();
        definirPanelDados();
        
         /*Para conseguir Fechar*/
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /*Definico a dimenção da tela*/
        int tamanhoTelaWidth = (this.painelPiece.getWidth() + this.painelDados.getWidth());
        int tamanhoTelaHeight = this.painelPiece.getHeight();
                
        this.setBounds(new Rectangle(tamanhoTelaWidth, tamanhoTelaHeight));
        this.setLocationRelativeTo(null); //Para deixar centralizado
        this.setResizable(Boolean.FALSE); //Para não redimencionar
        
        /*Para conseguir ver*/
        this.setVisible(true);
    }
    
    private void definirPanelPiece(){
        this.painelPiece = new JPanel();
        
        /*Definindo Layout que podemos alterar*/
        this.painelPiece.setLayout(null);
        
        /*Definindo Dor de fundo*/
        this.painelPiece.setBackground(new Color(148, 207, 185));
        
        /*Add Evento no Panel*/
        this.painelPiece.addMouseListener(this.opcoesPartida());
        
        int tamanhoTelaWidth = 0;
        int tamanhoTelaHeight = 0;
        int quantidadeLinhas = (this.quantidadeImg * this.quantidadeConminacao) / this.quantidadeColumn;
            
        tamanhoTelaWidth = ( (this.dimensaoBtn * this.quantidadeColumn) + (this.ESPACAMENTO_BUTTON * (this.quantidadeColumn + 2) ) );
        tamanhoTelaHeight = ( (this.dimensaoBtn * quantidadeLinhas) + (this.ESPACAMENTO_BUTTON * (quantidadeLinhas + 3) ) );
        
        /*Definindo Tamanho do Panel*/
        this.painelPiece.setBounds(new Rectangle(tamanhoTelaWidth, tamanhoTelaHeight));
        
        /*add o Painel*/
        this.add(this.painelPiece);
        
        /*Criando botões dinamicas*/
        this.configuracaoBotoes();
    }
    
    private void definirPanelDados(){
        this.painelDados = new JPanel();
        
        /*Definindo Layout que podemos alterar*/
        this.painelDados.setLayout(null);
        
        /*Definindo Dor de fundo*/
        this.painelDados.setBackground(new Color(148, 207, 185));
        
        /*Chamando as label  dos Jogados*/
        this.configurandoPlayer();
        this.definirJogador();
        
        /*Setar posicao e dimensao do painel de dados*/ 
        this.painelDados.setBounds(this.painelPiece.getWidth(), 0, 400, this.painelPiece.getHeight());
        
        /*Adiciona um painel no form*/
        this.add(this.painelDados);
    }
    
    private void configurandoPlayer(){
        /*Instaciando as Listas*/
        this.lbljogadores = new ArrayList<>();
        this.lblpontuacao = new ArrayList<>();
        this.lbljogando = new ArrayList<>();
        
        /*Instaciando a font*/
        Font fontJogador = new Font("Hadassah Friedlaender", Font.CENTER_BASELINE, 18);//
        
        /*Criando a lbl*/
        JLabel lblJogador = null;
        
        /*Criador O Titulo Jogador*/
        lblJogador =  new JLabel("JOGADORES");
        lblJogador.setFont(fontJogador);
        lblJogador.setBounds(this.painelPiece.getWidth(), this.ESPACAMENTO_BUTTON, 150, 25);
        this.painelDados.add(lblJogador);
        
        /*Criador O Titulo Pontuação*/
        lblJogador = new JLabel("POTUAÇÃO");
        lblJogador.setFont(fontJogador);
        lblJogador.setBounds((this.painelPiece.getWidth() + 150 + this.ESPACAMENTO_BUTTON), this.ESPACAMENTO_BUTTON, 150, 25);
        this.painelDados.add(lblJogador);
        
        
        if(this.comPlayer){
            int i = 0;
            
            for(Player jogador : this.gamers){
                i += 2;
                
                lblJogador = new JLabel(jogador.getNickName());
                lblJogador.setFont(fontJogador);
                lblJogador.setBounds(this.painelPiece.getWidth(), (i * this.ESPACAMENTO_BUTTON + 25), 150, 25);

                this.lbljogadores.add(lblJogador);

                lblJogador = new JLabel(this.mg.getStatidtics().get(indiceJogador).getPontuacao() + " Pontos");
                lblJogador.setFont(fontJogador);
                lblJogador.setBounds((this.painelPiece.getWidth() + 150 + this.ESPACAMENTO_BUTTON), (i * this.ESPACAMENTO_BUTTON + 25), 150, 25);

                this.lblpontuacao.add(lblJogador);
                
                lblJogador = new JLabel("*");
                //lblJogador.setOpaque(false);
                lblJogador.setIcon(this.piece.ImgConfig("pokebola", 25));
                lblJogador.setBounds((this.painelPiece.getWidth()+ 250 + 2 * this.ESPACAMENTO_BUTTON), (i *this.ESPACAMENTO_BUTTON + 22), 30, 36);

                this.lbljogando.add(lblJogador);
                
                
            }
        }else{
            lblJogador = new JLabel("OOH JOVEM");
            lblJogador.setFont(fontJogador);
            lblJogador.setBounds(this.painelPiece.getWidth(), (2 * this.ESPACAMENTO_BUTTON + 25), 150, 25);
            
            this.lbljogadores.add(lblJogador);
            
            lblJogador = new JLabel("0 Pontos" );
            lblJogador.setFont(fontJogador);
            lblJogador.setBounds((this.painelPiece.getWidth() + 150 + this.ESPACAMENTO_BUTTON), (2 * this.ESPACAMENTO_BUTTON + 25), 150, 25);
            
            this.lblpontuacao.add(lblJogador);
        }
        
        for(int j = 0; j < this.lbljogadores.size(); j++){
            this.painelDados.add(this.lbljogadores.get(j));
            this.painelDados.add(this.lblpontuacao.get(j));
            this.painelDados.add(this.lbljogando.get(j));
        }
        
        this.gamers.get(0).setJogando(1);
    }
    
    
    private void pontuacao(){
        
        sequencia++;
        
        if(this.mg.getStatidtics().get(indiceJogador).getBiggerSequence() < sequencia){
            this.mg.getStatidtics().get(indiceJogador).setBiggerSequence(sequencia);
        }
        
        this.mg.getStatidtics().get(indiceJogador).setPontuacao(this.valorAcerto * this.sequencia);
        this.lblpontuacao.get(indiceJogador).setText(this.mg.getStatidtics().get(indiceJogador).getPontuacao() + " Pontos");
    }
    
    
    
    private void definirJogador(){
        int i = 0;
        for(Player jogador : this.gamers){ 
            if(jogador.getJogando() == 1){
                this.lbljogando.get(i).setVisible(true);
                //lblJogador.setFont(fontJogador);
            }else{
//                this.lbljogadores.get(i).setVisible(false);
//                this.lblpontuacao.get(i).setVisible(false);
                  this.lbljogando.get(i).setVisible(false);
            }
            i++;
        }
    }
    
    
    private void alterandoJogador(){
        gamers.get(indiceJogador).setJogando(0);
                                
        if(indiceJogador == gamers.size() - 1){
            indiceJogador = -1;
        }
        indiceJogador++;
        gamers.get(indiceJogador).setJogando(1);

        definirJogador();
    }
    
    /*Funções de Eventos*/
    private ActionListener virarPiece(){
        ActionListener acao = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                JButton btn = ((JButton) e.getSource());
                
//                System.out.println("Jogadas: " + quantidadejogadas);
                
                for(ControleBotoesSelecionados cont : listaControle){
                    if( (cont.getReferenciaBotoes().get(btn) != null) && (cont.getReferenciaBotoes().get(btn) != EstadoBotoes.SELECIONADO) ){
                        
                        quantidadejogadas++;
                        cont.executarAcaoBtn(((JButton) e.getSource()), EstadoBotoes.SELECIONADO);
                        
                        //Controle de inclusão
                        if (!listaControleSelecionados.contains(cont)) {
                            listaControleSelecionados.add(cont);
                        }
                        
                        if( quantidadejogadas >= QUANTIDADE_LIMITE_JOGADAS ){
                            mg.getStatidtics().get(indiceJogador).setQuantidadeJogadas();
                            //Se os pares foram seleceionadas 
                            
                            if(listaControleSelecionados.size() > 1){
                                //Deixar os botões com estado OCULTO
                                for(ControleBotoesSelecionados cbs: listaControleSelecionados){
                                    cbs.zerarSelecoes();
                                }
                                
                                sequencia = 0;
                                alterandoJogador();
                            }else{
                                pontuacao();                                
                            }
                            
                            quantidadejogadas = 0;
                            listaControleSelecionados.clear();
                        }
                        break; //Economizar Processamento
                        
                    }
                }
                 endGame();
            }
        };
        
        return acao;
    }
    
    private void endGame(){
        
        int i = 0, j = 0;
        for(ControleBotoesSelecionados cont : listaControle){
            i++;
            if(cont.getReferenciaBotoes().values().contains(EstadoBotoes.OCULTO)){
                return;
            }
        }
        
         for(i=1; i < gamers.size(); i++){
            if(this.mg.getStatidtics().get(i).getPontuacao() > this.mg.getStatidtics().get(j).getPontuacao()){
                j = i;
            }
        }
        String caminhoImg = (getClass().getResource("/ImgConfig/youWin.png")).toString();
        String msg = "<html> <body font-family=\"Times New Roman\"> "
                + "<font size=\"6\"><center>"
                + "<b>Partida finalizada </b><br>"
                + " O <b>" + gamers.get(j).getNickName() + "</b> Foi o CAMPEÃO <br>"
                + "Somando " + this.mg.getStatidtics().get(indiceJogador).getPontuacao() + " Pontos"
                + "</center></font></body></html>";
        
       
        JOptionPane.showMessageDialog(null, msg, "Partida",0,piece.ImgConfig("youWin", 100));
        
        GenericDAO<MatchGame> mgDAO = new GenericDAOImpl<MatchGame>();
        
        mgDAO.save(mg);
        
        this.dispose();
        
        
    }
    
    private MouseAdapter opcoesPartida(){
        final JPopupMenu pm = new JPopupMenu();
        
        JMenuItem dica = new JMenuItem("Dica");
        JMenu trocasImgCostas = new JMenu("Trocas Imagem Costas Carta");
        JSeparator separador = new JSeparator();
        
        for(int i = 0; i < opcaoImgCostas().size(); i++){
            if( i  == (opcaoImgCostas().size() - 1) ){
             trocasImgCostas.add(separador);
            }
            trocasImgCostas.add(opcaoImgCostas().get(i));
        }
        
        pm.add(trocasImgCostas);
        pm.add(separador);
        pm.add(dica);
        
        
        MouseAdapter acao = new MouseAdapter() {
            
            public void mouseReleased(MouseEvent me){
                if(me.getButton() == 3){
                    pm.show(me.getComponent(), me.getX(), me.getY());
                }
            }
            
        };
        
        return acao;
    }
    
    private List<JMenu> opcaoImgCostas(){
        List<JMenu> opocoes = new ArrayList<>();
        JMenu opcao = null;
        
        opcao = new JMenu("Celebro");
        for (int i = 0; i < opcaoImgCostasCelebro().size(); i++) {
            opcao.add(opcaoImgCostasCelebro().get(i));
        }
        opocoes.add(opcao);
        
        opcao = new JMenu("Ideia");
        for (int i = 0; i < opcaoImgCostasIdeia().size(); i++) {
            opcao.add(opcaoImgCostasIdeia().get(i));
        }
        opocoes.add(opcao);
        
        opcao = new JMenu("Interrogação");
        for (int i = 0; i < opcaoImgCostasInterrogacao().size(); i++) {
            opcao.add(opcaoImgCostasInterrogacao().get(i));
        }
        opocoes.add(opcao);
        
        opcao = new JMenu("Mestre Ivad");
        for (int i = 0; i < opcaoImgCostasMestreIvad().size(); i++) {
            opcao.add(opcaoImgCostasMestreIvad().get(i));
        }
        opocoes.add(opcao);
        
        return opocoes;
    }
    
    private List<JMenuItem> opcaoImgCostasCelebro(){
        List<JMenuItem> opocoes = new ArrayList<>();
        JMenuItem opcao = null;
        
        opcao = new JMenuItem("Celebro 1");
        opcao.addActionListener(alterarCostas(PieceEnum.IMAGEM_COSTAS_CELEBRO_1));
        opocoes.add(opcao);
        
        opcao = new JMenuItem("Celebro 2");
        opcao.addActionListener(alterarCostas(PieceEnum.IMAGEM_COSTAS_CELEBRO_2));
        opocoes.add(opcao);
        
        opcao = new JMenuItem("Celebro 3");
        opcao.addActionListener(alterarCostas(PieceEnum.IMAGEM_COSTAS_CELEBRO_3));
        opocoes.add(opcao);
        
        opcao = new JMenuItem("Celebro 4");
        opcao.addActionListener(alterarCostas(PieceEnum.IMAGEM_COSTAS_CELEBRO_4));
        opocoes.add(opcao);
        
        opcao = new JMenuItem("Celebro 5");
        opcao.addActionListener(alterarCostas(PieceEnum.IMAGEM_COSTAS_CELEBRO_5));
        opocoes.add(opcao);
        
        opcao = new JMenuItem("Celebro 6");
        opcao.addActionListener(alterarCostas(PieceEnum.IMAGEM_COSTAS_CELEBRO_6));
        opocoes.add(opcao);
        
        return opocoes;
    }
    
    private List<JMenuItem> opcaoImgCostasIdeia(){
        List<JMenuItem> opocoes = new ArrayList<>();
        JMenuItem opcao = null;
        
        opcao = new JMenuItem("Ideia 1");
        opcao.addActionListener(alterarCostas(PieceEnum.IMAGEM_COSTAS_IDEIA_1));
        opocoes.add(opcao);
        
        opcao = new JMenuItem("Ideia 2");
        opcao.addActionListener(alterarCostas(PieceEnum.IMAGEM_COSTAS_IDEIA_2));
        opocoes.add(opcao);
        
        return opocoes;
    }
    
    private List<JMenuItem> opcaoImgCostasInterrogacao(){
        List<JMenuItem> opocoes = new ArrayList<>();
        JMenuItem opcao = null;
        
        opcao = new JMenuItem("Interrogação 1");
        opcao.addActionListener(alterarCostas(PieceEnum.IMAGEM_COSTAS_INTERROGACAO));
        opocoes.add(opcao);
        
        return opocoes;
    }
    
    private List<JMenuItem> opcaoImgCostasMestreIvad(){
        List<JMenuItem> opocoes = new ArrayList<>();
        JMenuItem opcao = null;
        
        opcao = new JMenuItem("Após Prova");
        opcao.addActionListener(alterarCostas(PieceEnum.IMAGEM_COSTAS_DAVI_APOS_PROVA));
        opocoes.add(opcao);
        
        opcao = new JMenuItem("Biólogo");
        opcao.addActionListener(alterarCostas(PieceEnum.IMAGEM_COSTAS_DAVI_BIOLOGO));
        opocoes.add(opcao);
        
        opcao = new JMenuItem("Comida Boa");
        opcao.addActionListener(alterarCostas(PieceEnum.IMAGEM_COSTAS_DAVI_COMIDA_BOA));
        opocoes.add(opcao);
        
        opcao = new JMenuItem("Cowboy");
        opcao.addActionListener(alterarCostas(PieceEnum.IMAGEM_COSTAS_DAVI_COWBOY));
        opocoes.add(opcao);
        
        opcao = new JMenuItem("Doente");
        opcao.addActionListener(alterarCostas(PieceEnum.IMAGEM_COSTAS_DAVI_DOENTE));
        opocoes.add(opcao);
        
        opcao = new JMenuItem("Fazendo PUM");
        opcao.addActionListener(alterarCostas(PieceEnum.IMAGEM_COSTAS_DAVI_FAZENDO_PUM));
        opocoes.add(opcao);
        
        opcao = new JMenuItem("Festa Junina");
        opcao.addActionListener(alterarCostas(PieceEnum.IMAGEM_COSTAS_DAVI_FESTA_JUNINA));
        opocoes.add(opcao);
        
        opcao = new JMenuItem("Matrix");
        opcao.addActionListener(alterarCostas(PieceEnum.IMAGEM_COSTAS_DAVI_MATRIX));
        opocoes.add(opcao);
        
        opcao = new JMenuItem("Saboreando Comida");
        opcao.addActionListener(alterarCostas(PieceEnum.IMAGEM_COSTAS_DAVI_SABOREANDO_COMIDA));
        opocoes.add(opcao);
        
        opcao = new JMenuItem("Segundos Intenções");
        opcao.addActionListener(alterarCostas(PieceEnum.IMAGEM_COSTAS_DAVI_SEGUNDAS_INTECOES));
        opocoes.add(opcao);
        
        opcao = new JMenuItem("Seguro");
        opcao.addActionListener(alterarCostas(PieceEnum.IMAGEM_COSTAS_DAVI_SEGURO));
        opocoes.add(opcao);
        
        opcao = new JMenuItem("Sério");
        opcao.addActionListener(alterarCostas(PieceEnum.IMAGEM_COSTAS_DAVI_SERIO));
        opocoes.add(opcao);
        
        opcao = new JMenuItem("Sóbrio");
        opcao.addActionListener(alterarCostas(PieceEnum.IMAGEM_COSTAS_DAVI_SOBRIO));
        opocoes.add(opcao);
        
        return opocoes;
    }
    
    private ActionListener alterarCostas(final PieceEnum img){
        ActionListener acao = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < listaControle.size(); i++) {
//                    System.out.println("img: " + img.getNameImg());
                    listaControle.get(i).setImgCostasBotao(img.getNameImg());
                    listaControle.get(i).alterarCostasBtn();
                    
//                    System.out.println("imgC: " + listaControle.get(i).getImgCostasBotao());;;
                }
            }
        };
        
        return acao;
    }
    

}