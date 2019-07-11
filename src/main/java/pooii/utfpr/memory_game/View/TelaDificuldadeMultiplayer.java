/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.View;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import pooii.utfpr.memory_game.Control.MatchGame;
import pooii.utfpr.memory_game.Model.VO.Player;
import pooii.utfpr.memory_game.Model.VO.modalidades.ModalityEnum;

/**
 *
 * @author Matheus_CRF
 */
public class TelaDificuldadeMultiplayer extends javax.swing.JFrame {
     
    /*Atributos*/
    private int mousePx, mousePy;
    private MatchGame mg = null;
    private List<Player> players;
    
    //construtor
    public TelaDificuldadeMultiplayer(Player player) {
        initComponents();
        
        this.players = new ArrayList<>();
        this.players.add(player);
    }
    
    public TelaDificuldadeMultiplayer() {
        initComponents();
    }

    public void verificaNome(){
        if(!txtPlayer3.getText().isEmpty()){
            Player play3 = new Player(txtPlayer3.getText());
            this.players.add(play3);
        }
        if(!txtPlayer2.getText().isEmpty()){
            Player play2 = new Player(txtPlayer2.getText());
            this.players.add(play2);
        }
        if(!txtPlayer4.getText().isEmpty()){
            Player play4 = new Player(txtPlayer4.getText());
            this.players.add(play4);
        }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDificuldadeMultiplayer().setVisible(true);
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPlayer2 = new javax.swing.JTextField();
        txtPlayer3 = new javax.swing.JTextField();
        txtPlayer4 = new javax.swing.JTextField();
        lblCalouro = new javax.swing.JLabel();
        lblFacil = new javax.swing.JLabel();
        lblMedio = new javax.swing.JLabel();
        lblDificil = new javax.swing.JLabel();
        lblSuper = new javax.swing.JLabel();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPlayer2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        txtPlayer2.setBorder(null);
        txtPlayer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlayer2ActionPerformed(evt);
            }
        });
        txtPlayer2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPlayer2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPlayer2KeyTyped(evt);
            }
        });
        getContentPane().add(txtPlayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 200, -1));

        txtPlayer3.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        txtPlayer3.setBorder(null);
        txtPlayer3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlayer3ActionPerformed(evt);
            }
        });
        txtPlayer3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPlayer3KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPlayer3KeyTyped(evt);
            }
        });
        getContentPane().add(txtPlayer3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 200, -1));

        txtPlayer4.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        txtPlayer4.setBorder(null);
        txtPlayer4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlayer4ActionPerformed(evt);
            }
        });
        txtPlayer4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPlayer4KeyTyped(evt);
            }
        });
        getContentPane().add(txtPlayer4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 200, 20));

        lblCalouro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCalouroMouseClicked(evt);
            }
        });
        getContentPane().add(lblCalouro, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 150, 40));

        lblFacil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFacilMouseClicked(evt);
            }
        });
        getContentPane().add(lblFacil, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 150, 50));

        lblMedio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMedioMouseClicked(evt);
            }
        });
        getContentPane().add(lblMedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 150, 40));

        lblDificil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDificilMouseClicked(evt);
            }
        });
        getContentPane().add(lblDificil, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 150, 40));

        lblSuper.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSuperMouseClicked(evt);
            }
        });
        getContentPane().add(lblSuper, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, 150, 40));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Telas/dificuldadeMulti.jpg"))); // NOI18N
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPlayer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlayer2ActionPerformed
        
    }//GEN-LAST:event_txtPlayer2ActionPerformed

    private void txtPlayer3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlayer3ActionPerformed
    }//GEN-LAST:event_txtPlayer3ActionPerformed

    private void txtPlayer4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlayer4ActionPerformed
    }//GEN-LAST:event_txtPlayer4ActionPerformed

    private void lblCalouroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCalouroMouseClicked
        verificaNome();
        new TelaPartida(new MatchGame(ModalityEnum.FORFRESHMEN, this.players)).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblCalouroMouseClicked

    private void txtPlayer2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlayer2KeyTyped
        
    }//GEN-LAST:event_txtPlayer2KeyTyped

    private void txtPlayer3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlayer3KeyTyped
        
    }//GEN-LAST:event_txtPlayer3KeyTyped

    private void txtPlayer4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlayer4KeyTyped
       
    }//GEN-LAST:event_txtPlayer4KeyTyped

    private void txtPlayer2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlayer2KeyPressed
        
    }//GEN-LAST:event_txtPlayer2KeyPressed

    private void txtPlayer3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlayer3KeyPressed
       
    }//GEN-LAST:event_txtPlayer3KeyPressed

    private void lblFacilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFacilMouseClicked
        verificaNome();
        new TelaPartida(new MatchGame(ModalityEnum.EASY, this.players)).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblFacilMouseClicked

    private void lblMedioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMedioMouseClicked
        verificaNome();
        new TelaPartida(new MatchGame(ModalityEnum.MIDDLE, this.players)).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblMedioMouseClicked

    private void lblDificilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDificilMouseClicked
        verificaNome();
        new TelaPartida(new MatchGame(ModalityEnum.HARD, this.players)).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblDificilMouseClicked

    private void lblSuperMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSuperMouseClicked
        verificaNome();
        new TelaPartida(new MatchGame(ModalityEnum.SUPERWAGNER, this.players)).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblSuperMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblCalouro;
    private javax.swing.JLabel lblDificil;
    private javax.swing.JLabel lblFacil;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblMedio;
    private javax.swing.JLabel lblSuper;
    private javax.swing.JTextField txtPlayer2;
    private javax.swing.JTextField txtPlayer3;
    private javax.swing.JTextField txtPlayer4;
    // End of variables declaration//GEN-END:variables
}
