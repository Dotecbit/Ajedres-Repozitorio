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
public class VAdminDarDeBajaJugador extends javax.swing.JFrame {
    
    
    private JFrame ventanaAnterior;
    public VAdminDarDeBajaJugador(JFrame ventanaAnterior) {
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

        labJug = new javax.swing.JLabel();
        listJug = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        botAtras = new javax.swing.JButton();
        botAceptar = new javax.swing.JButton();

        labJug.setText("Selecciona al jugador que quieres dar de baja");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listJug.setViewportView(jList1);

        botAtras.setText("Atrás");
        botAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAtrasActionPerformed(evt);
            }
        });

        botAceptar.setText("Aceptar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(labJug, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listJug, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botAtras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botAceptar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(labJug)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listJug, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botAtras)
                    .addComponent(botAceptar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAtrasActionPerformed
        this.setVisible(false);
        ventanaAnterior.setVisible(true);
    }//GEN-LAST:event_botAtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botAceptar;
    private javax.swing.JButton botAtras;
    private javax.swing.JList<String> jList1;
    private javax.swing.JLabel labJug;
    private javax.swing.JScrollPane listJug;
    // End of variables declaration//GEN-END:variables
}
