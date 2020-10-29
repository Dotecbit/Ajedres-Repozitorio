/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import controlador.Administrador;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author donramon
 */
public class VentanaCrearTorneo extends javax.swing.JFrame{
   
    /**
     * Creates new customizer VentanaCrearTorneo
     */
    private JFrame ventanaAnterior;
    private Administrador administrador;
    private DefaultListModel modeloLista, modeloListaJugador;
    private ArrayList<String> sedes;
    private ArrayList<String> jugadores;
    private Object sede, jugador;
    private añadirJugadoresSedes añadirJugador;
    
    public VentanaCrearTorneo(JFrame ventanaAnterior, Administrador administrador, añadirJugadoresSedes añadirJugador) {
        this.ventanaAnterior = ventanaAnterior;
        this.administrador = administrador;
        this.añadirJugador = añadirJugador;
        administrador.cargarSedes();
        sedes = administrador.getSedes();
        
        administrador.jugadores();
        jugadores = administrador.getJugadores();
        System.out.println("Jugadores: " + jugadores.size());
        initComponents();
        
        modeloLista = new DefaultListModel();
        modeloListaJugador = new DefaultListModel();
        listaSede.setModel(modeloLista);
        listaJugadores.setModel(modeloListaJugador);
       
       for (Object item : sedes) 
          modeloLista.addElement(item);
        
        for (Object item : jugadores) 
            modeloListaJugador.addElement(item);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaSede = new javax.swing.JList<>();
        labNom = new javax.swing.JLabel();
        nombreTorneo = new javax.swing.JTextField();
        labListSed = new javax.swing.JLabel();
        labListJug = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaJugadores = new javax.swing.JList<>();
        botAtras = new javax.swing.JButton();
        botAceptar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        añadirSede = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList1);

        jScrollPane1.setViewportView(listaSede);

        labNom.setText("Nombre del torneo:");

        nombreTorneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTorneoActionPerformed(evt);
            }
        });

        labListSed.setText("Selecciona la sede participantes en el torneo");

        labListJug.setText("Selecciona los jugadores participantes en el torneo");

        jScrollPane2.setViewportView(listaJugadores);

        botAtras.setText("Atrás");
        botAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAtrasActionPerformed(evt);
            }
        });

        botAceptar.setText("Aceptar");
        botAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAceptarActionPerformed(evt);
            }
        });

        jButton1.setText("Añadir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        añadirSede.setText("Añadir");
        añadirSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirSedeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botAtras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botAceptar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(labListSed)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(labNom)
                                .addGap(166, 166, 166)
                                .addComponent(nombreTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(añadirSede)
                                .addComponent(labListJug)))
                        .addGap(0, 73, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(236, 236, 236)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labNom)
                    .addComponent(nombreTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(labListSed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(añadirSede)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labListJug)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botAtras)
                    .addComponent(botAceptar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAtrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botAtrasActionPerformed

    private void botAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAceptarActionPerformed
        
        if(nombreTorneo.getText().equals("") || sede == null || jugador == null)
            JOptionPane.showMessageDialog(null,"Rellena todos los campos");
    }//GEN-LAST:event_botAceptarActionPerformed

    private void nombreTorneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTorneoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTorneoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       jugador = listaJugadores.getSelectedValue();
        if(jugador != null)
       {    
           System.out.println(jugador);
           añadirJugador.añadirJugador(jugador);
       }
       else
           JOptionPane.showMessageDialog(null,"Selecciona el jugador");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void añadirSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirSedeActionPerformed
        sede = listaSede.getSelectedValue();
        if(sede != null)
        {
           añadirJugador.añadirSede(sede);
        }
    }//GEN-LAST:event_añadirSedeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton añadirSede;
    private javax.swing.JButton botAceptar;
    private javax.swing.JButton botAtras;
    private javax.swing.JButton jButton1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labListJug;
    private javax.swing.JLabel labListSed;
    private javax.swing.JLabel labNom;
    private javax.swing.JList<String> listaJugadores;
    private javax.swing.JList<String> listaSede;
    private javax.swing.JTextField nombreTorneo;
    // End of variables declaration//GEN-END:variables
}
