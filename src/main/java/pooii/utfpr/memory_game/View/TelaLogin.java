/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.View;

import java.awt.Color;
import static java.time.Clock.system;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import pooii.utfpr.memory_game.Model.DAO.GenericDAO;
import pooii.utfpr.memory_game.Model.RN.GenericRN;
import pooii.utfpr.memory_game.Model.RN.PlayerRN;
import pooii.utfpr.memory_game.Model.VO.Player;

/**
 *
 * @author Matheus_CRF
 */
public class TelaLogin extends javax.swing.JFrame {
    int mousePx, mousePy;
    
    public TelaLogin() {
        initComponents();
        //this.setBackground(new Color(0,0,0,0));
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
        txtSenha = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        lblEntrar = new javax.swing.JLabel();
        lblCriarConta = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        getContentPane().add(lblBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 20));

        txtSenha.setBorder(null);
        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 240, 30));

        txtUsuario.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        txtUsuario.setBorder(null);
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 240, 40));
        txtUsuario.getAccessibleContext().setAccessibleName("");

        lblEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEntrarMouseClicked(evt);
            }
        });
        getContentPane().add(lblEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 150, 40));

        lblCriarConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCriarContaMouseClicked(evt);
            }
        });
        getContentPane().add(lblCriarConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 60, 10));

        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });
        getContentPane().add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(444, 0, 10, 20));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Telas/telaLogin.jpg"))); // NOI18N
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, -1));

        pack();
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
    }//GEN-LAST:event_lblBarraMousePressed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
       System.exit(0);
    }//GEN-LAST:event_lblCloseMouseClicked

    private void lblEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEntrarMouseClicked
        GenericRN<Player> playerDAO = new GenericRN<>();
        
        String usuario = this.txtUsuario.getText();
        String senha = new String(this.txtSenha.getPassword());
        
        if(playerDAO.verificaLogin(usuario, senha)){
            JOptionPane.showMessageDialog(null, "Entrou!");
            this.dispose();
            TelaDefineModo tela = new TelaDefineModo(usuario);
            tela.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Nem vem!");
        }
        
    }//GEN-LAST:event_lblEntrarMouseClicked

    private void lblCriarContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCriarContaMouseClicked
        this.dispose();
        TelaCadastro telaCad = new TelaCadastro();
        telaCad.setVisible(true);
    }//GEN-LAST:event_lblCriarContaMouseClicked

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaLogin tela = new TelaLogin();
                tela.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblBarra;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblCriarConta;
    private javax.swing.JLabel lblEntrar;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
