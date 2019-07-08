/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.View;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import pooii.utfpr.memory_game.Control.Regras.ControleBotoesSelecionados;
import pooii.utfpr.memory_game.Control.Regras.EstadoBotoes;
import pooii.utfpr.memory_game.Model.VO.Piece;
import pooii.utfpr.memory_game.Model.VO.PieceEnum;
import pooii.utfpr.memory_game.Model.VO.Player;
import pooii.utfpr.memory_game.Model.VO.modalidades.Difficulty;

/**
 *
 * @author Jece Xavier
 */
public class TelaPartida extends JFrame{
    
    
    /*Atritutos =>  Atributos de Controle*/
    private int ESPACAMENTO_BUTTON = 20;
    private int quantidadejogadas = 0;
    Piece piece; 
    
    private int QUANTIDADE_LIMITE_JOGADAS;
    private int dimensaoBtn;
    private int quantidadeImg;
    private int quantidadeConminacao;
    private int quantidadeColumn;
    private int valorAcerto;
    private List<Player> gamers;
    
    
    
    
    /*Atritutos => Conpodentes de Tela*/
    private JPanel painelPiece;
    private JPanel painelDados;
   
    private List<ControleBotoesSelecionados> listaControle;
    private List<ControleBotoesSelecionados> listaControleSelecionados;
    
    /*Atritutos => Eventos...*/
    ActionListener acoesBtn;
    
    /*Construtor*/
    public TelaPartida(Difficulty difficult, List<Player> gamers){
        super("Partida da modalidade " + difficult.getName());
        
        this.QUANTIDADE_LIMITE_JOGADAS = difficult.getQuatityCombination();
        this.dimensaoBtn = difficult.getDimensionPiece();
        this.quantidadeImg = difficult.getQuantityPiece();
        this.quantidadeConminacao = difficult.getQuatityCombination();
        this.quantidadeColumn = difficult.getQuatityColumn();
        this.valorAcerto = difficult.getValorAcerto();
        this.gamers = gamers;
        
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
    
    public TelaPartida(Difficulty difficult){
        super("Partida da modalidade " + difficult.getName());
        
        this.QUANTIDADE_LIMITE_JOGADAS = difficult.getQuatityCombination();
        this.dimensaoBtn = difficult.getDimensionPiece();
        this.quantidadeImg = difficult.getQuantityPiece();
        this.quantidadeConminacao = difficult.getQuatityCombination();
        this.quantidadeColumn = difficult.getQuatityColumn();
        this.valorAcerto = difficult.getValorAcerto();
        
        /*Instacionando Lista Controle*/
        this.listaControle = new ArrayList<>();
        this.listaControleSelecionados = new ArrayList<>();
        
        /*Para conseguir Img*/
        this.piece = new Piece();
        
        /*Criando ação no botão*/
         this.acoesBtn = virarPiece();
        
        
        definirLayoutTela();
    }
    
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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /*Definico a dimenção da tela*/
        int tamanhoTelaWidth = (this.painelPiece.getWidth() + this.painelDados.getWidth());
        int tamanhoTelaHeight = this.painelPiece.getHeight();
                
        this.setBounds(new Rectangle(tamanhoTelaWidth, tamanhoTelaHeight));
        this.setLocationRelativeTo(null); //Para deixar centralizado
//        this.setResizable(Boolean.FALSE); //Para não redimencionar
        
        /*Para conseguir ver*/
        this.setVisible(true);
    }
    
    private void definirPanelPiece(){
        this.painelPiece = new JPanel();
        
        /*Definindo Layout que podemos alterar*/
        this.painelPiece.setLayout(null);
        
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
        
        JLabel lbl = new JLabel("Professor Xavier");
        lbl.setBounds((this.painelPiece.getWidth()), this.ESPACAMENTO_BUTTON, (200 - 2*this.ESPACAMENTO_BUTTON), 25);
        this.painelDados.add(lbl);
        
        this.painelDados.setBounds(this.painelPiece.getWidth(), 0, 200, this.painelPiece.getHeight());
        
        System.out.println("painelDados.setBounds" + this.painelDados.getBounds());
        System.out.println("painelPiece.setBounds" + this.painelPiece.getBounds());
        this.add(this.painelDados);
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
                            //Se os pares foram seleceionadas 
                            
                            if(listaControleSelecionados.size() > 1){
                            //Deixar os botões com estado OCULTO
                                for(ControleBotoesSelecionados cbs: listaControleSelecionados){
                                    cbs.zerarSelecoes();
                                }
                            }
                            
                            quantidadejogadas = 0;
                            listaControleSelecionados.clear();
                        }
                        break; //Economicar Processamento
                        
                    }
                }
                 endGame();
            }
        };
        
        return acao;
    }
    
    private void endGame(){
        int i = 0;
        for(ControleBotoesSelecionados cont : listaControle){
            i++;
            if(cont.getReferenciaBotoes().values().contains(EstadoBotoes.OCULTO)){
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Partida Finalizada");
        
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