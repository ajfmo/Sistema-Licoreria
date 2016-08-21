/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.ui;

import com.sil.dao.Licorerias;

/**
 *
 * @author Adrian Floers
 */
public class OperacionesLicorerias extends javax.swing.JFrame {
    
    private final Licorerias licoreria;
    private final MenuPrincipal menuPrincipal;


    /**
     * Creates new form NewJFrame
     */
    public OperacionesLicorerias() {
        this.menuPrincipal = new MenuPrincipal();
        this.licoreria = new Licorerias();
        initComponents();
        licoreria.mostrarRegistros(jComboLicorerias);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblID = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextLicoreria = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jComboLicorerias = new javax.swing.JComboBox<>();
        jButtonRegistrar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonSelecciona = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mantenimiento Licorerias");

        lblID.setText("Descripcion:");

        jLabel1.setText("Seleccionar licoreria:");

        jTextLicoreria.setColumns(10);

        jComboLicorerias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboLicoreriasActionPerformed(evt);
            }
        });

        jButtonRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/grabar.gif"))); // NOI18N
        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });

        jButtonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.gif"))); // NOI18N
        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar.gif"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonSelecciona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/VER.gif"))); // NOI18N
        jButtonSelecciona.setText("Seleccionar");
        jButtonSelecciona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSeleccionaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboLicorerias, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSelecciona))
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonRegistrar)
                    .addComponent(lblID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonCancelar))
                    .addComponent(jTextLicoreria, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboLicorerias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSelecciona))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextLicoreria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonEliminar)
                    .addComponent(jButtonRegistrar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        // Agrega registros a la base de datos mediante el metodo RegistrarLicorerias

        // Registra la informacion recibida en el jTextLicoreria
        licoreria.registrarLicoreria(jTextLicoreria.getText());

        // Actualiza la lista de registros
        jComboLicorerias.removeAllItems();
        licoreria.mostrarRegistros(jComboLicorerias);
        jTextLicoreria.setText("");

        // Cierra las consultas y conexiones si estan abiertas
        licoreria.cerrarConsultas();
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        // TODO add your handling code here: Elimina un registro de la base de
        // datos y muestra en el combobox los registros actuales
        // Aplicamos el metodo EliminarLicoreria que elimina el registro
        // indicado en el jTextLicoreria
        licoreria.eliminarLicoreria(jTextLicoreria.getText());

        // Actualiza la lista de registros
        jComboLicorerias.removeAllItems();
        licoreria.mostrarRegistros(jComboLicorerias);
        jTextLicoreria.setText("");

        // Cierra las consultas y conexiones si estan abiertas
        licoreria.cerrarConsultas();
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here: cierra la ventana actual y llama al
        // menu principal.
        
        // Desechamos esta ventana  
        this.dispose();
        // Cierra las consultas y conexiones si estan abiertas
        licoreria.cerrarConsultas();
        // Mostramos el menu principal
        menuPrincipal.setVisible(true);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jComboLicoreriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboLicoreriasActionPerformed
        // TODO add your handling code here: Muestra en el jTextLicoreria la
        // seleccion que se haga en el jComboLicorerias
        jTextLicoreria.setText((String) jComboLicorerias.getSelectedItem());
    }//GEN-LAST:event_jComboLicoreriasActionPerformed

    private void jButtonSeleccionaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSeleccionaActionPerformed
        // TODO add your handling code here: Selecciona una licoreria para
        // marcarla como activa
        licoreria.seleccionarLicoreria((String) jComboLicorerias.getSelectedItem());
    }//GEN-LAST:event_jButtonSeleccionaActionPerformed

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
            java.util.logging.Logger.getLogger(OperacionesLicorerias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new OperacionesLicorerias().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JButton jButtonSelecciona;
    private javax.swing.JComboBox<String> jComboLicorerias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextLicoreria;
    private javax.swing.JLabel lblID;
    // End of variables declaration//GEN-END:variables
}