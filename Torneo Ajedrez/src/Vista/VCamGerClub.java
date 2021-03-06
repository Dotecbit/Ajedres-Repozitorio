/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import controlador.Administrador;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//¿Este import se puede hacer?
import model.DatosGerente;

/**
 *
 * @author donramon
 */
public class VCamGerClub extends javax.swing.JFrame {
    
    /**
     * Creates new customizer VentanaCambiarGerenteClubAdmin
     */
    private DefaultListModel modeloListaClub;
    private DefaultListModel modeloListaGer;
    private Administrador administrador;
    private JFrame ventanaAnterior;
    
    public VCamGerClub(JFrame ventanaAnterior, Administrador administrador) {
        this.ventanaAnterior = ventanaAnterior;
        this.administrador = administrador;
        this.setVisible(true);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);        
        this.setTitle("Crear club");
        initComponents();
        
        modeloListaClub = new DefaultListModel();
        modeloListaGer = new DefaultListModel();
        lisC.setModel(modeloListaClub);
        lisG.setModel(modeloListaGer);
        
        
        
        for(Object item:administrador.getClubs())
            modeloListaClub.addElement(item);
        
        for(Object item:administrador.getGerentesConClub())
            modeloListaGer.addElement(item);
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labGer = new javax.swing.JLabel();
        labClub = new javax.swing.JLabel();
        listGeren = new javax.swing.JScrollPane();
        lisC = new javax.swing.JList<>();
        listClub = new javax.swing.JScrollPane();
        lisG = new javax.swing.JList<>();
        butAtras = new javax.swing.JButton();
        butAceptar = new javax.swing.JButton();

        labGer.setText("Gerente a cambiar");

        labClub.setText("Club a asignar");

        listGeren.setViewportView(lisC);

        listClub.setViewportView(lisG);

        butAtras.setText("Atrás");
        butAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAtrasActionPerformed(evt);
            }
        });

        butAceptar.setText("Aceptar");
        butAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(butAtras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(butAceptar)
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labGer)
                        .addGap(108, 108, 108)
                        .addComponent(labClub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(68, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listClub, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(listGeren, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 15, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labGer)
                    .addComponent(labClub))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listClub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listGeren, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butAtras)
                    .addComponent(butAceptar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void butAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAceptarActionPerformed
        administrador.getCambiaClub((Object)lisC.getSelectedValue(),(Object) lisG.getSelectedValue());
        JOptionPane.showMessageDialog(null,"Se ha cambiado al gerente.");
    }//GEN-LAST:event_butAceptarActionPerformed

    private void butAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAtrasActionPerformed
    this.setVisible(false);
    ventanaAnterior.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_butAtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAceptar;
    private javax.swing.JButton butAtras;
    private javax.swing.JLabel labClub;
    private javax.swing.JLabel labGer;
    private javax.swing.JList<String> lisC;
    private javax.swing.JList<String> lisG;
    private javax.swing.JScrollPane listClub;
    private javax.swing.JScrollPane listGeren;
    // End of variables declaration//GEN-END:variables
}
