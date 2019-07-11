/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.View;

import javax.swing.JOptionPane;
import pooii.utfpr.memory_game.Model.DAO.connectionHibernate;
import pooii.utfpr.memory_game.Model.RN.GenericRN;
import pooii.utfpr.memory_game.Model.VO.Player;

/**
 *
 * @author Jece Xavier
 */
public class TelaCadastro extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastro
     */
    public TelaCadastro() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNome = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        lblCadastrar = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        lblBarra = new javax.swing.JLabel();
        lblFechar = new javax.swing.JLabel();
        lblJogoRapido = new javax.swing.JLabel();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNome.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        txtNome.setBorder(null);
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 240, 40));

        txtEmail.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        txtEmail.setBorder(null);
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 240, 40));

        txtSenha.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        txtSenha.setBorder(null);
        getContentPane().add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 240, 30));

        lblCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCadastrarMouseClicked(evt);
            }
        });
        getContentPane().add(lblCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 415, 117, 30));

        lblLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLoginMouseClicked(evt);
            }
        });
        getContentPane().add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 455, 80, 10));
        getContentPane().add(lblBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 20));

        lblFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFecharMouseClicked(evt);
            }
        });
        getContentPane().add(lblFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 20, 20));
        getContentPane().add(lblJogoRapido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 120, 30));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Telas/telaCadastro.jpg"))); // NOI18N
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 470));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadastrarMouseClicked
        String senha = new String(this.txtSenha.getPassword());
        
//        if(txtEmail.getText().length() < 10){
////            JOptionPane.showMessageDialog(rootPane, "O email deve ter mais que 10 caracteres");
//        }else if(txtNome.getText().length() < 3){
////            JOptionPane.showMessageDialog(rootPane, "O nome deve ter mais que 3 caracteres");
//        }else if(senha.length() < 7){
////            JOptionPane.showMessageDialog(rootPane, "A senha deve ter mais que 7 caracteres");
//        }else{
//        
//        }
    
        GenericRN<Player> playerDAO = new GenericRN<>();

        Player player = new Player();

        player.setNickName(txtNome.getText());
        player.setPass(senha);
        player.setEmail(txtEmail.getText());

        if(playerDAO.cadastro(player)){
            JOptionPane.showMessageDialog(rootPane, "Cadastro feito com sucesso!");
            this.dispose();
            new TelaDefineModo(player).setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Dados Invalidos :`(", "ERRO :(", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_lblCadastrarMouseClicked

    private void lblFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFecharMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblFecharMouseClicked

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void lblLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseClicked
        this.dispose();
        new TelaLogin().setVisible(true);
    }//GEN-LAST:event_lblLoginMouseClicked

    
    
    
    
    
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
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblBarra;
    private javax.swing.JLabel lblCadastrar;
    private javax.swing.JLabel lblFechar;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblJogoRapido;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
