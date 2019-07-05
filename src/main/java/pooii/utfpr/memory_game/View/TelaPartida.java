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
import javax.swing.JPanel;
import pooii.utfpr.memory_game.Control.Regras.ControleBotoesSelecionados;
import pooii.utfpr.memory_game.Control.Regras.EstadoBotoes;
import pooii.utfpr.memory_game.Model.VO.Piece;
import pooii.utfpr.memory_game.Model.VO.PieceEnum;

/**
 *
 * @author Jece Xavier
 */
public class TelaPartida extends JFrame{
    
    
    /*Atritutos =>  Atributos de Controle*/
    private int WIDTH_BUTTON = 150;
    private int HEIGHT_BUTTON = 150;
    private int ESPACAMENTO_BUTTON = 20;
    private int QUANTIDADE_LIMITE_JOGADAS = 2;
    private int quantidadejogadas = 0;
    
    /*Atritutos => Conpodentes de Tela*/
    private JPanel painel;
   
    private List<ControleBotoesSelecionados> listaControle;
    private List<ControleBotoesSelecionados> listaControleSelecionados;
    
    /*Atritutos => Eventos...*/
    ActionListener acoesBtn;
    
    /*Construtor*/
    public TelaPartida(String NomeTela){
        super("Partida " + NomeTela);
        
        
        /*Instacionando Lista Controle*/
        this.listaControle = new ArrayList<>();
        this.listaControleSelecionados = new ArrayList<>();
        
        /*criando icone*/
        Piece piece = new Piece();
        
        /*Criando ação no botão*/
         this.acoesBtn = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = ((JButton) e.getSource());
                
                System.out.println("Jogadas: " + quantidadejogadas);
                
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
            }
            
        };
        
        /*instacionado os componentes e add Não tela*/
        painel = new JPanel();
        painel.setLayout(null);
        this.add(painel);
        
        
        /*Posição e tamanho*/
//        this.setBounds(550, 150, 700, 700);;
        
        /*Para conseguir Fechar*/
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /*Criando botões dinamicas*/
        createGame(4, 2, 150);
        
        /*Para conseguir ver*/
        this.setVisible(true);
    }
    
    
    private void createGame(int quantidadeImg, int quantidadeConminacao, int dimensaoBtn){
        
        /*Variaveis*/
        Piece piece = new Piece();                      //Variavel para criar ImagemIcon
        int identificacaoImage = 0;                     //Referencia para escolher a foto
        int posX = this.ESPACAMENTO_BUTTON;             //Cordenada X onde pode será colocado o Botão
        int posY = this.ESPACAMENTO_BUTTON;             //Cordenada Y onde pode será colocado o Botão
        int quantidadeBotoes = quantidadeImg * quantidadeConminacao;
        int tamanhoTelaWidth = 0;
        int tamanhoTelaHeight = 0;
        int i = 0, j = 0;
        List<Rectangle> posicionamentosBtn = new ArrayList<>();
        Random rand = new Random();
        //Quantidade de botões
        
        ControleBotoesSelecionados controle = null;
        
        /*Randomizando Posicao*/
        for(i = 0; i < quantidadeBotoes; i++){
            Rectangle posicaoBtn = new Rectangle(posX, posY, dimensaoBtn, dimensaoBtn);
            posicionamentosBtn.add(posicaoBtn);
            
            
            if(quantidadeBotoes == 8){
                
                if( ( (i + 1) % 4) == 0){
                    
                    posY += this.ESPACAMENTO_BUTTON + dimensaoBtn;
                    posX = this.ESPACAMENTO_BUTTON;
                }else{
                    posX += this.ESPACAMENTO_BUTTON + dimensaoBtn;
                }
                
            }else if(quantidadeBotoes == 24){
                
                if( ( (i + 1) % 6) == 0){
                    posY += this.ESPACAMENTO_BUTTON + dimensaoBtn;
                    posX = this.ESPACAMENTO_BUTTON;
                }else{
                    posX += this.ESPACAMENTO_BUTTON + dimensaoBtn;
                }
                
            }else if(quantidadeBotoes == 48){
                
                if( ( (i + 1) % 8) == 0){
                    posY += this.ESPACAMENTO_BUTTON + dimensaoBtn;
                    posX = this.ESPACAMENTO_BUTTON;
                }else{
                    posX += this.ESPACAMENTO_BUTTON + dimensaoBtn;
                }
                
            }else{
                if( ( (i + 1) % 10) == 0){
                    posY += this.ESPACAMENTO_BUTTON + dimensaoBtn;
                    posX = this.ESPACAMENTO_BUTTON;
                }else{
                    posX += this.ESPACAMENTO_BUTTON + dimensaoBtn;
                }
            }
        }
        
        
        for(i = 0; i < quantidadeBotoes; i++){
            
            if( (i % quantidadeConminacao) == 0){
                //Quantidade de controladores
                identificacaoImage++;                                                   //Incrementando a referencia para a foto
                controle = new ControleBotoesSelecionados();                            //Instanciando um controle
                controle.setImgFrenteBotao("Img_" + identificacaoImage);                //Definindo a Imagem que estará oculta
                this.listaControle.add(controle);                                       //Adicionado o controle na lista dos Controles Ativos
            }
            
            JButton btn = new JButton(piece.createImg(PieceEnum.IMAGEM_COSTAS, dimensaoBtn)); //Criando o Objeto Botão já com o Icon            
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
        
        if(quantidadeBotoes == 8){
            
            tamanhoTelaWidth = ( (dimensaoBtn * 4) + (this.ESPACAMENTO_BUTTON * 6) );
            tamanhoTelaHeight = ( (dimensaoBtn * 2) + (this.ESPACAMENTO_BUTTON * 5) );
                
        }else if(quantidadeBotoes == 24){
            
            tamanhoTelaWidth = ( (dimensaoBtn * 6) + (this.ESPACAMENTO_BUTTON * 8) );
            tamanhoTelaHeight = ( (dimensaoBtn * 4) + (this.ESPACAMENTO_BUTTON * 7) );

        }else if(quantidadeBotoes == 48){
            
            tamanhoTelaWidth = ( (dimensaoBtn * 8) + (this.ESPACAMENTO_BUTTON * 10) );
            tamanhoTelaHeight = ( (dimensaoBtn * 6) + (this.ESPACAMENTO_BUTTON * 9) );

        }else{
            tamanhoTelaWidth = ( (dimensaoBtn * 10) + (this.ESPACAMENTO_BUTTON * 12) );
            tamanhoTelaHeight = ( (dimensaoBtn * 9) + (this.ESPACAMENTO_BUTTON * 12) );
            this.QUANTIDADE_LIMITE_JOGADAS = quantidadeConminacao;
        }
        
        
        
        System.out.println("wi: " + tamanhoTelaWidth + " hei: " + tamanhoTelaHeight);
        
        
        /*Definico a dimenção da tela*/
        this.setBounds(0, 0, tamanhoTelaWidth, tamanhoTelaHeight);
        this.setLocationRelativeTo(null); //Para 
    }
    


}