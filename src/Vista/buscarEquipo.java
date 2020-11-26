/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Facade.Administrador;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ayoub El Moussaoui
 */
public class buscarEquipo extends javax.swing.JFrame {

    private JFrame ventanaAnterior;
    private final Administrador admin;
    private final String usuario;
    
    public buscarEquipo(JFrame ventanaAnterior, Administrador admin, String usuario) throws IOException, SQLException {
        this.usuario = usuario;
        this.ventanaAnterior = ventanaAnterior;
        this.admin = admin;
        initComponents();
        this.comprobarDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listBuscarEquipo = new javax.swing.JList<>();
        atras = new javax.swing.JButton();
        apuntarse = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(listBuscarEquipo);

        atras.setText("Atras");
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });

        apuntarse.setText("Apuntarse");
        apuntarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apuntarseActionPerformed(evt);
            }
        });

        jLabel1.setText("Equipos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(atras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(apuntarse)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(jLabel1)
                .addContainerGap(194, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(atras)
                    .addComponent(apuntarse))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        this.setVisible(false);
        ventanaAnterior.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_atrasActionPerformed

    private void apuntarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apuntarseActionPerformed
    if(admin.jugClubRepe(usuario, listBuscarEquipo.getSelectedValue()))
        JOptionPane.showMessageDialog(null,"Ya perteneces a ese club", "Atención", JOptionPane.WARNING_MESSAGE);  
    else
    {
        try {
            admin.apuntarJugEquipo(usuario,listBuscarEquipo.getSelectedValue());
            JOptionPane.showMessageDialog(null,"Se ha inscrito en el club satifactoriamente");
        } catch (SQLException ex) {
            Logger.getLogger(buscarEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }//GEN-LAST:event_apuntarseActionPerformed
    public void comprobarDatos() throws IOException, SQLException
    {
        DefaultListModel modeloListaClub = new DefaultListModel();
        
        listBuscarEquipo.setModel(modeloListaClub);
        
        if(!admin.getClubs().isEmpty())
        {
            this.setSize(425, 325);
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            this.setTitle("Buscar equipo");
            this.setVisible(true);
                   
            for(Object club:admin.getClubs())
                modeloListaClub.addElement(club);
        }
        else
        {
            this.setVisible(false); 
            JOptionPane.showMessageDialog(null,"No existe ningún club, debe crearse antes de poder apuntarse", "Atención", JOptionPane.WARNING_MESSAGE);
            ventanaAnterior.setVisible(true);
            ventanaAnterior.setLocationRelativeTo(null);
            ventanaAnterior.setResizable(false);
            ventanaAnterior.setTitle("Crear Gerente");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton apuntarse;
    private javax.swing.JButton atras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listBuscarEquipo;
    // End of variables declaration//GEN-END:variables
}
