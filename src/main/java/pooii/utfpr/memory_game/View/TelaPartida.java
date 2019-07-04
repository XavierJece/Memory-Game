/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
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
    
    
    /*Atributos*/
    private int WIDTH_BUTTON = 150;
    private int HEIGHT_BUTTON = 150;
    private int QUANTIDADE_LIMITE_JOGADAS = 2;
    private int quantidadejogadas = 0;
    
    
    private JPanel painel;
    
    private JButton btn1;
    private JButton btn2;
    
    private JButton btnA;
    private JButton btnB;
    
    private ControleBotoesSelecionados controle;
    private ControleBotoesSelecionados controleA;
    
    private List<ControleBotoesSelecionados> listaControle;
    private List<ControleBotoesSelecionados> listaControleSelecionados;
    
    /*Construtor*/
    public TelaPartida(String NomeTela){
        super("Partida " + NomeTela);
        
        
        /*Instacionando Lista Controle*/
        this.listaControle = new ArrayList<>();
        this.listaControleSelecionados = new ArrayList<>();
        
        /*criando icone*/
        Piece piece = new Piece();
        
        /*Criando ação no botão*/
        ActionListener acoesBtn = new ActionListener() {
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
        
        /*Criando o controle dos botões*/
        this.controle = new ControleBotoesSelecionados();
        this.controle.setImgFrenteBotao(PieceEnum.IMAGEM_27);
        
        this.controleA = new ControleBotoesSelecionados();
        this.controleA.setImgFrenteBotao(PieceEnum.IMAGEM_04);
        
        /*instacionado os componentes e add Não tela*/
        painel = new JPanel();
        painel.setLayout(null);
        this.add(painel);
        
        btn1 = new JButton("Botão 1");
        btn1.setBounds(20, 20, this.WIDTH_BUTTON, this.HEIGHT_BUTTON);
        btn1.setIcon(piece.createImg(PieceEnum.IMAGEM_COSTAS));
        
        btn2 = new JButton("Botão 2");
        btn2.setBounds(190, 20, this.WIDTH_BUTTON, this.HEIGHT_BUTTON);
        btn2.setIcon(piece.createImg(PieceEnum.IMAGEM_COSTAS));
        
        btnA = new JButton("Botão A");
        btnA.setBounds(20, 190, this.WIDTH_BUTTON, this.HEIGHT_BUTTON);
        btnA.setIcon(piece.createImg(PieceEnum.IMAGEM_COSTAS));
        
        btnB = new JButton("Botão B");
        btnB.setBounds(190, 190, this.WIDTH_BUTTON, this.HEIGHT_BUTTON);
        btnB.setIcon(piece.createImg(PieceEnum.IMAGEM_COSTAS));
        
        /*adicinando acao de Click*/
        btn1.addActionListener(acoesBtn);
        btn2.addActionListener(acoesBtn);
        
        btnA.addActionListener(acoesBtn);
        btnB.addActionListener(acoesBtn);
        
        /*Adicionando no painel*/
        painel.add(btn1);
        painel.add(btn2);
        painel.add(btnA);
        painel.add(btnB);
        
        /*Add os botões no controle*/
        this.controle.addBtn(btn1);
        this.controle.addBtn(btn2);
        
        this.controleA.addBtn(btnA);
        this.controleA.addBtn(btnB);
        
        /*Adicionando controles na lista*/
        this.listaControle.add(controle);
        this.listaControle.add(controleA);
        
        
        /*Posição e tamanho*/
        this.setBounds(550, 150, 700, 700);
        
        /*Para conseguir Fechar*/
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /*Para conseguir ver*/
        this.setVisible(true);
    }
    
    

    


}