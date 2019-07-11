/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.View;

import java.util.ArrayList;
import java.util.List;
import pooii.utfpr.memory_game.Control.MatchGame;
import pooii.utfpr.memory_game.Model.DAO.connectionHibernate;
import pooii.utfpr.memory_game.Model.VO.Player;
import pooii.utfpr.memory_game.Model.VO.modalidades.ModalityEnum;

/**
 *
 * @author Matheus_CRF
 */
public class TelaDificuldadeSinglePlayer extends javax.swing.JFrame {
    
    /*Atributos*/
    private int mousePx, mousePy;
    private MatchGame mg = null;
    private List<Player> players;
    
    public TelaDificuldadeSinglePlayer(Player p) {
        initComponents();
        
        this.players = new ArrayList<>();
        this.players.add(p);
        
    }
    
    public TelaDificuldadeSinglePlayer() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBarra = new javax.swing.JLabel();
        lblFechar = new javax.swing.JLabel();
        lblCalouros = new javax.swing.JLabel();
        lblMedio = new javax.swing.JLabel();
        lblFacil = new javax.swing.JLabel();
        lblDificil = new javax.swing.JLabel();
        lblSuperWagner = new javax.swing.JLabel();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lblBarra.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lblBarraMouseDragged(evt);
            }
        });
        lblBarra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblBarraMousePressed(evt);
            }
        });
        getContentPane().add(lblBarra);
        lblBarra.setBounds(0, 0, 440, 20);

        lblFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFecharMouseClicked(evt);
            }
        });
        getContentPane().add(lblFechar);
        lblFechar.setBounds(440, 0, 20, 20);

        lblCalouros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCalourosMouseClicked(evt);
            }
        });
        getContentPane().add(lblCalouros);
        lblCalouros.setBounds(140, 105, 150, 50);

        lblMedio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMedioMouseClicked(evt);
            }
        });
        getContentPane().add(lblMedio);
        lblMedio.setBounds(140, 260, 150, 48);

        lblFacil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFacilMouseClicked(evt);
            }
        });
        getContentPane().add(lblFacil);
        lblFacil.setBounds(140, 180, 150, 50);

        lblDificil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDificilMouseClicked(evt);
            }
        });
        getContentPane().add(lblDificil);
        lblDificil.setBounds(138, 330, 150, 45);

        lblSuperWagner.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSuperWagnerMouseClicked(evt);
            }
        });
        getContentPane().add(lblSuperWagner);
        lblSuperWagner.setBounds(138, 397, 151, 45);

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Telas/dificuldade.jpg"))); // NOI18N
        getContentPane().add(lblFundo);
        lblFundo.setBounds(0, 0, 458, 470);

        setSize(new java.awt.Dimension(478, 516));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblBarraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBarraMouseDragged
        int cordenadaX = evt.getXOnScreen();
        int cordenadaY = evt.getYOnScreen();

        this.setLocation(cordenadaX-mousePx, cordenadaY-mousePy);
    }//GEN-LAST:event_lblBarraMouseDragged

    private void lblBarraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBarraMousePressed
        mousePx = evt.getX();
        mousePy = evt.getY();
        // TODO add your handling code here:
    }//GEN-LAST:event_lblBarraMousePressed

    private void lblFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFecharMouseClicked
        connectionHibernate.close();
        System.exit(0);
    }//GEN-LAST:event_lblFecharMouseClicked

    private void lblCalourosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCalourosMouseClicked
        new TelaPartida(new MatchGame(ModalityEnum.FORFRESHMEN, this.players)).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblCalourosMouseClicked

    private void lblMedioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMedioMouseClicked
        new TelaPartida(new MatchGame(ModalityEnum.MIDDLE, this.players)).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblMedioMouseClicked

    private void lblFacilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFacilMouseClicked
        new TelaPartida(new MatchGame(ModalityEnum.EASY, this.players)).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblFacilMouseClicked

    private void lblDificilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDificilMouseClicked
        new TelaPartida(new MatchGame(ModalityEnum.HARD, this.players)).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblDificilMouseClicked

    private void lblSuperWagnerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSuperWagnerMouseClicked
        new TelaPartida(new MatchGame(ModalityEnum.SUPERWAGNER, this.players)).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblSuperWagnerMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaDificuldadeSinglePlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDificuldadeSinglePlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDificuldadeSinglePlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDificuldadeSinglePlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDificuldadeSinglePlayer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblBarra;
    private javax.swing.JLabel lblCalouros;
    private javax.swing.JLabel lblDificil;
    private javax.swing.JLabel lblFacil;
    private javax.swing.JLabel lblFechar;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblMedio;
    private javax.swing.JLabel lblSuperWagner;
    // End of variables declaration//GEN-END:variables
}
