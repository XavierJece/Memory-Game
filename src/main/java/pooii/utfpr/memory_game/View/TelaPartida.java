/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.View;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
    private JPanel painel;
   
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
        
        /*instacionado os componentes e add Não tela*/
        painel = new JPanel();
        painel.setLayout(null);
        this.add(painel);
        
        /*Para conseguir Fechar*/
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /*Criando botões dinamicas*/
        configuracaoBotoes();
        definirLayoutTela();
        
        /*Para conseguir ver*/
        this.setVisible(true);
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
        
        /*instacionado os componentes e add Não tela*/
        painel = new JPanel();
        painel.setLayout(null);
        this.add(painel);
        
        /*Para conseguir Fechar*/
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /*Criando botões dinamicas*/
        configuracaoBotoes();
        definirLayoutTela();
        
        /*Para conseguir ver*/
        this.setVisible(true);
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
                controle.setImgCostasBotao(PieceEnum.IMAGEM_COSTAS.getNameImg());       //Definindo a Imagem que estará nas costas da carta
                
                this.listaControle.add(controle);                                       //Adicionado o controle na lista dos Controles Ativos
            }
            
            JButton btn = new JButton(piece.createImg(controle.getImgCostasBotao(), this.dimensaoBtn)); //Criando o Objeto Botão já com o Icon            
            this.painel.add(btn);                                                       // Adicionando o Botão na Tela
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
        int tamanhoTelaWidth = 0;
        int tamanhoTelaHeight = 0;
        int quantidadeLinhas = (this.quantidadeImg * this.quantidadeConminacao) / this.quantidadeColumn;
            
        tamanhoTelaWidth = ( (this.dimensaoBtn * this.quantidadeColumn) + (this.ESPACAMENTO_BUTTON * (this.quantidadeColumn + 2) ) );
        tamanhoTelaHeight = ( (this.dimensaoBtn * quantidadeLinhas) + (this.ESPACAMENTO_BUTTON * (quantidadeLinhas + 3) ) );
        
        /*Definico a dimenção da tela*/
        this.setBounds(0, 0, tamanhoTelaWidth, tamanhoTelaHeight);
        this.setLocationRelativeTo(null); //Para deixar centralizado
        this.setResizable(Boolean.FALSE); //Para não redimencionar
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

}