/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Facade.Administrador;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author 34677
 */
public class VDarDeBajaTorneo extends javax.swing.JFrame {

    /**
     * Creates new form VDarDeBajaTorneo
     */
    private JFrame ventanaAnterior;
    private Administrador administrador;
    private ArrayList<String> torneos;
    private DefaultListModel modeloLista;
    private Object torneo;
    public VDarDeBajaTorneo(JFrame ventanaAnterior, Administrador administrador, ArrayList<String> torneos) 
    {
        this.administrador = administrador;
        this.ventanaAnterior = ventanaAnterior;
        this.torneos = torneos;
        
        initComponents();
        
        modeloLista = new DefaultListModel();
        listaBaja.setModel(modeloLista);

        for (Object item : torneos) 
            modeloLista.addElement(item);   
   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        darDeBaja = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaBaja = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        darDeBaja.setText("Dar de baja");
        darDeBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darDeBajaActionPerformed(evt);
            }
        });

        jButton2.setText("Atras");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listaBaja);

        jLabel1.setText("Seleccione un torneo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(darDeBaja)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(206, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(198, 198, 198))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(darDeBaja)
                    .addComponent(jButton2))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        ventanaAnterior.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void darDeBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darDeBajaActionPerformed
        torneo = listaBaja.getSelectedValue();
        
        if(torneo != null)
        {
            administrador.darDeBajaTorneo((String)torneo);
            torneos.remove((String)torneo);
            modeloLista.removeElement(torneo);
            JOptionPane.showMessageDialog(null,"El torneo " + (String)torneo + " ha sido dado de baja correctamente.");
            if(torneos.size() == 0)
            {
                JOptionPane.showMessageDialog(null, "No hay más torneos.", "¡torneos!", JOptionPane.WARNING_MESSAGE);
                this.setVisible(false);
                ventanaAnterior.setVisible(true);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Primero debe seleccionar a un usuario.", "¡Selecciona usuarios!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_darDeBajaActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton darDeBaja;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaBaja;
    // End of variables declaration//GEN-END:variables
}
