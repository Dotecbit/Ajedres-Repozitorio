/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author donramon
 */
public class VentanaIntroducirResultadoUltimaPartidaAdmin extends javax.swing.JPanel implements java.beans.Customizer {
    
    private Object bean;

    /**
     * Creates new customizer VentanaIntroducirResultadoUltimaPartidaAdmin
     */
    public VentanaIntroducirResultadoUltimaPartidaAdmin() {
        initComponents();
    }
    
    public void setObject(Object bean) {
        this.bean = bean;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labJug = new javax.swing.JLabel();
        listJugadores = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        butPerder = new javax.swing.JButton();
        butEmpatar = new javax.swing.JButton();
        butGanar = new javax.swing.JButton();
        botAtras = new javax.swing.JButton();
        botAceptar = new javax.swing.JButton();

        labJug.setText("Seleecione al jugador que desee registrar el resultado de su última partida");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listJugadores.setViewportView(jList1);

        butPerder.setText("Ha perdido");
        butPerder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butPerderActionPerformed(evt);
            }
        });

        butEmpatar.setText("Ha empatado");

        butGanar.setText("Ha ganado");

        botAtras.setText("Atrás");
        botAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAtrasActionPerformed(evt);
            }
        });

        botAceptar.setText("Aceptar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(butPerder)
                                .addGap(71, 71, 71)
                                .addComponent(butEmpatar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(butGanar))
                            .addComponent(listJugadores)
                            .addComponent(labJug, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE))
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botAtras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botAceptar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(labJug)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butPerder)
                    .addComponent(butEmpatar)
                    .addComponent(butGanar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botAtras)
                    .addComponent(botAceptar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void butPerderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butPerderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_butPerderActionPerformed

    private void botAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAtrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botAtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botAceptar;
    private javax.swing.JButton botAtras;
    private javax.swing.JButton butEmpatar;
    private javax.swing.JButton butGanar;
    private javax.swing.JButton butPerder;
    private javax.swing.JList<String> jList1;
    private javax.swing.JLabel labJug;
    private javax.swing.JScrollPane listJugadores;
    // End of variables declaration//GEN-END:variables
}