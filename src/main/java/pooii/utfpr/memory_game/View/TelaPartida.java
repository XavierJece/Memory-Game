/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.View;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
    private final int widthButton = 150;
    private final int heightButton = 150;
    
    private JPanel painel;
    private JButton btn1;
    private JButton btn2;
    
    private ControleBotoesSelecionados controle;
    
    /*Construtor*/
    public TelaPartida(String NomeTela){
        super("Partida " + NomeTela);
        
        /*criando icone*/
        Piece piece = new Piece();
        
        /*Criando ação no botão*/
        ActionListener acoesBtn = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controle.executarAcaoBtn(((JButton) e.getSource()), EstadoBotoes.SELECIONADO);
                
            }
            
        };
        
        /*Criando o controle dos botões*/
        this.controle = new ControleBotoesSelecionados();
        this.controle.setImgFrenteBotao(PieceEnum.IMAGEM_27);
        
        /*instacionado os componentes e add Não tela*/
        painel = new JPanel();
        painel.setLayout(null);
        this.add(painel);
        
        btn1 = new JButton("Botão 1");
        btn1.setBounds(20, 20, this.widthButton, this.heightButton);
        btn1.setIcon(piece.createImg(PieceEnum.IMAGEM_COSTAS));
        
        btn2 = new JButton("Botão 2");
        btn2.setBounds(190, 20, this.widthButton, this.heightButton);
        btn2.setIcon(piece.createImg(PieceEnum.IMAGEM_COSTAS));
        
        /*adicinando acao de Click*/
        btn1.addActionListener(acoesBtn);
        btn2.addActionListener(acoesBtn);
        
        /*Adicionando no painel*/
        painel.add(btn1);
        painel.add(btn2);
        
        /*Add os botões no controle*/
        this.controle.addBtn(btn1);
        this.controle.addBtn(btn2);
        
        /*Posição e tamanho*/
        this.setBounds(550, 150, 700, 700);
        
        /*Para conseguir Fechar*/
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /*Para conseguir ver*/
        this.setVisible(true);
    }
    
    


}