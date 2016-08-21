/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.gui;

import java.sql.Connection;
import javax.swing.JOptionPane;
import com.sil.dao.Conexion;
import com.sil.dao.Usuarios;

/**
 *
 * @author Adrian Floers
 */
public class Login extends javax.swing.JFrame {

    // Variables declaration - do not modify  
    private final MenuPrincipal menuPpal;
    private final Usuarios accesoUsuario;
    private final Conexion Conecta;
    private Connection Conector;

    /**
     * Creates new form Login
     */
    public Login() {

        this.Conecta = new Conexion();
        this.menuPpal = new MenuPrincipal();
        this.accesoUsuario = new Usuarios();
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

        jLabelUsuario = new javax.swing.JLabel();
        jTextUsuario = new javax.swing.JTextField();
        jLabelClave = new javax.swing.JLabel();
        jPasswordClave = new javax.swing.JPasswordField();
        jLabelOlvidoClave = new javax.swing.JLabel();
        jButtonAcceder = new javax.swing.JButton();
        jButtonProbar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Licoreria - Login");

        jLabelUsuario.setText("Usuario:");

        jTextUsuario.setColumns(10);

        jLabelClave.setText("Clave");

        jPasswordClave.setColumns(10);

        jLabelOlvidoClave.setText("¿Olvido clave?");

        jButtonAcceder.setText("Acceder");
        jButtonAcceder.setToolTipText("Accede al sistema");
        jButtonAcceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAccederActionPerformed(evt);
            }
        });

        jButtonProbar.setText("Probar");
        jButtonProbar.setToolTipText("Probar la conexion a la base de datos");
        jButtonProbar.setEnabled(false);
        jButtonProbar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProbarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelUsuario)
                    .addComponent(jTextUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelClave)
                    .addComponent(jPasswordClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelOlvidoClave)
                    .addComponent(jButtonAcceder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonProbar)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabelUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelClave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelOlvidoClave)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAcceder)
                    .addComponent(jButtonProbar))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAccederActionPerformed
        // Realiza el logeo al sistema.

        String login = jTextUsuario.getText();
        String clave = jPasswordClave.getText();
        Object[][] itemUsuario = accesoUsuario.AccedeUsuario(login, clave);

        if ((jTextUsuario.getText().equals("Soporte")) && (jPasswordClave.getText().equals("2374"))) {
            jButtonProbar.setEnabled(true);
        } else {
            itemUsuario[0][0].toString();
            String x_user = itemUsuario[0][1].toString();
            String x_pass = itemUsuario[0][2].toString();
            try {
                if ((!"".equals(x_user)) && (!"".equals(x_pass))) {
                    JOptionPane.showMessageDialog(null, "Bienvenido al sistema usuario: " + login
                            + ""/* , con id: " + x_iduser */, null, JOptionPane.INFORMATION_MESSAGE);
                    // logedUser.Consulta();
                    // usuarioOnline.usuarioOnline(jTextUsuario.getText());
                    menuPpal.setVisible(true);
                    this.dispose();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto", null,
                        JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_jButtonAccederActionPerformed

    private void jButtonProbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProbarActionPerformed
        // TODO add your handling code here: prueba la conexion a la base de
        // datos
        this.Conector = Conecta.Conectar();
        if (Conector != null) {
            JOptionPane.showMessageDialog(null, "Conectado!");
        }

    }//GEN-LAST:event_jButtonProbarActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
    @SuppressWarnings("unchecked")
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAcceder;
    private javax.swing.JButton jButtonProbar;
    private javax.swing.JLabel jLabelClave;
    private javax.swing.JLabel jLabelOlvidoClave;
    private javax.swing.JLabel jLabelUsuario;
    public static javax.swing.JPasswordField jPasswordClave;
    public static javax.swing.JTextField jTextUsuario;
    // End of variables declaration//GEN-END:variables
}
