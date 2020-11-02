/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JFrame;

/**
 *
 * @author donramon
 */
public class VentanaAsignarJugadorATorneoAdmin extends javax.swing.JFrame {
    
    /**
     * Creates new customizer VentanaAsignarJugadorATorneoAdmin
     */
    private JFrame ventanaAnterior;
    public VentanaAsignarJugadorATorneoAdmin(JFrame ventanaAnterior) {
        this.ventanaAnterior = ventanaAnterior;
        initComponents();
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listJug = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listTorneo = new javax.swing.JList<>();
        labJug = new javax.swing.JLabel();
        labTorneo = new javax.swing.JLabel();
        butAtras = new javax.swing.JButton();
        butAceptar = new javax.swing.JButton();

        listJug.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listJug);

        listTorneo.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listTorneo);

        labJug.setText("Seleccionar jugador");

        labTorneo.setText("Seleccionar torneo");

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
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labJug))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labTorneo))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(butAtras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(butAceptar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labJug)
                    .addComponent(labTorneo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butAtras)
                    .addComponent(butAceptar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void butAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAceptarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_butAceptarActionPerformed

    private void butAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAtrasActionPerformed
        this.setVisible(false);
        ventanaAnterior.setVisible(true);
    }//GEN-LAST:event_butAtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAceptar;
    private javax.swing.JButton butAtras;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labJug;
    private javax.swing.JLabel labTorneo;
    private javax.swing.JList<String> listJug;
    private javax.swing.JList<String> listTorneo;
    // End of variables declaration//GEN-END:variables
}
