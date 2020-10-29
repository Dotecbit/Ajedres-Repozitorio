/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import controlador.Administrador;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author donramon
 */
public class VentanaAdministrador extends javax.swing.JFrame
{
    private static Administrador administrador;
    private JFrame ventanaAnterior;
    public VentanaAdministrador(Administrador administrador, JFrame ventanaAnterior) {
        this.administrador = administrador;
        this.ventanaAnterior = ventanaAnterior;
        initComponents();
        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotDarBajaTorneo = new javax.swing.JButton();
        botCrearClub = new javax.swing.JButton();
        botCrearTorneo = new javax.swing.JButton();
        botBajaClub = new javax.swing.JButton();
        botAsigRespInf = new javax.swing.JButton();
        botSetResPart = new javax.swing.JButton();
        botSetSedeTorneo = new javax.swing.JButton();
        botDarBajJug = new javax.swing.JButton();
        botAsignTorneo = new javax.swing.JButton();
        botCamGerClub = new javax.swing.JButton();

        BotDarBajaTorneo.setText("Dar de baja torneo");
        BotDarBajaTorneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotDarBajaTorneoActionPerformed(evt);
            }
        });

        botCrearClub.setText("Crear club");
        botCrearClub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botCrearClubActionPerformed(evt);
            }
        });

        botCrearTorneo.setText("Crear torneo");
        botCrearTorneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botCrearTorneoActionPerformed(evt);
            }
        });

        botBajaClub.setText("Dar de baja club");
        botBajaClub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botBajaClubActionPerformed(evt);
            }
        });

        botAsigRespInf.setText("Asignar responsable infantiles");
        botAsigRespInf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAsigRespInfActionPerformed(evt);
            }
        });

        botSetResPart.setText("Introducir resultados última partida");
        botSetResPart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botSetResPartActionPerformed(evt);
            }
        });

        botSetSedeTorneo.setText("Asignacion de sede de torneos");
        botSetSedeTorneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botSetSedeTorneoActionPerformed(evt);
            }
        });

        botDarBajJug.setText("Dar baja jugador");
        botDarBajJug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botDarBajJugActionPerformed(evt);
            }
        });

        botAsignTorneo.setText("Asignar jugador a torneo");
        botAsignTorneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAsignTorneoActionPerformed(evt);
            }
        });

        botCamGerClub.setText("Cambiar gerente club");
        botCamGerClub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botCamGerClubActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(57, Short.MAX_VALUE)
                        .addComponent(botCrearTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botCrearClub, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(botBajaClub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BotDarBajaTorneo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botAsigRespInf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botSetResPart, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                                .addComponent(botSetSedeTorneo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                                .addComponent(botDarBajJug, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botAsignTorneo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botCamGerClub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(botCrearTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botBajaClub)
                .addGap(18, 18, 18)
                .addComponent(botCrearClub)
                .addGap(18, 18, 18)
                .addComponent(BotDarBajaTorneo)
                .addGap(18, 18, 18)
                .addComponent(botAsigRespInf)
                .addGap(18, 18, 18)
                .addComponent(botSetResPart)
                .addGap(18, 18, 18)
                .addComponent(botSetSedeTorneo)
                .addGap(18, 18, 18)
                .addComponent(botDarBajJug)
                .addGap(18, 18, 18)
                .addComponent(botAsignTorneo)
                .addGap(18, 18, 18)
                .addComponent(botCamGerClub)
                .addContainerGap(35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botCrearClubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botCrearClubActionPerformed
       
        VentanaCrearClub crearClub= new VentanaCrearClub(this,administrador);
        this.setVisible(false); 
        crearClub.setVisible(true);
        crearClub.setSize(500, 700);
        crearClub.setLocationRelativeTo(null);
        crearClub.setResizable(false);
        crearClub.setTitle("Crear club");
    }//GEN-LAST:event_botCrearClubActionPerformed

    private void botCrearTorneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botCrearTorneoActionPerformed
        añadirJugadoresSedes añadirJugador = new añadirJugadoresSedes(administrador);
        VentanaCrearTorneo crearTorneo = new VentanaCrearTorneo(this, administrador, añadirJugador);
        
        
        añadirJugador.setVisible(true);
        añadirJugador.setLocationRelativeTo(null);
        añadirJugador.setResizable(false);
        añadirJugador.setTitle("Añadir jugador");
        
        crearTorneo.setSize(500, 700);
        this.setVisible(false); 
        crearTorneo.setVisible(true);
        crearTorneo.setLocationRelativeTo(null);
        crearTorneo.setResizable(false);
        crearTorneo.setTitle("Crear torneo");
        
    }//GEN-LAST:event_botCrearTorneoActionPerformed

    private void botBajaClubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botBajaClubActionPerformed
        VentanaDarBajaClub bajaCLub = new VentanaDarBajaClub(this);
        this.setVisible(false); 
        bajaCLub.setVisible(true);
        bajaCLub.setLocationRelativeTo(null);
        bajaCLub.setResizable(false);
        bajaCLub.setTitle("Baja club");
    }//GEN-LAST:event_botBajaClubActionPerformed

    private void botDarBajJugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botDarBajJugActionPerformed
        VentanaDarDeBajaJugadorAdmin darBajaJugador = new VentanaDarDeBajaJugadorAdmin(this);
        this.setVisible(false); 
        darBajaJugador.setVisible(true);
        darBajaJugador.setLocationRelativeTo(null);
        darBajaJugador.setResizable(false);
        darBajaJugador.setTitle("Baja jugador");        
    }//GEN-LAST:event_botDarBajJugActionPerformed

    private void botCamGerClubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botCamGerClubActionPerformed
        VentanaCambiarGerenteClubAdmin cambiarGerenteClub = new VentanaCambiarGerenteClubAdmin(this,administrador);
        this.setVisible(false); 
        cambiarGerenteClub.setVisible(true);
        cambiarGerenteClub.setLocationRelativeTo(null);
        cambiarGerenteClub.setResizable(false);
        cambiarGerenteClub.setTitle("Cambiar de club");
    }//GEN-LAST:event_botCamGerClubActionPerformed

    private void botAsignTorneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAsignTorneoActionPerformed
        VentanaAsignarJugadorATorneoAdmin asignarJugadorTorneo = new VentanaAsignarJugadorATorneoAdmin(this);
        this.setVisible(false); 
        asignarJugadorTorneo.setVisible(true);
        asignarJugadorTorneo.setLocationRelativeTo(null);
        asignarJugadorTorneo.setResizable(false);
        asignarJugadorTorneo.setTitle("Asignar a torneo");
    }//GEN-LAST:event_botAsignTorneoActionPerformed

    private void botSetSedeTorneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botSetSedeTorneoActionPerformed
        VentanaAsignarSedeTorneoAdmin asignarJugadorTorneo = new VentanaAsignarSedeTorneoAdmin(this);
        this.setVisible(false); 
        asignarJugadorTorneo.setVisible(true);
        asignarJugadorTorneo.setLocationRelativeTo(null);
        asignarJugadorTorneo.setResizable(false);
        asignarJugadorTorneo.setTitle("Asignar sede torneo");       
    }//GEN-LAST:event_botSetSedeTorneoActionPerformed

    private void botSetResPartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botSetResPartActionPerformed
        VentanaIntroducirResultadoUltimaPartidaAdmin introducirResultado = new VentanaIntroducirResultadoUltimaPartidaAdmin(this);
        this.setVisible(false); 
        introducirResultado.setVisible(true);
        introducirResultado.setLocationRelativeTo(null);
        introducirResultado.setResizable(false);
        introducirResultado.setTitle("Introducir resultado");  
    }//GEN-LAST:event_botSetResPartActionPerformed

    private void botAsigRespInfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAsigRespInfActionPerformed
        VentanaAsignarResponsableInfantilAdmin asignarInfantil = new VentanaAsignarResponsableInfantilAdmin(this);
        this.setVisible(false); 
        asignarInfantil.setVisible(true);
        asignarInfantil.setLocationRelativeTo(null);
        asignarInfantil.setResizable(false);
        asignarInfantil.setTitle("Introducir resultado"); 
    }//GEN-LAST:event_botAsigRespInfActionPerformed

    private void BotDarBajaTorneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotDarBajaTorneoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotDarBajaTorneoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotDarBajaTorneo;
    private javax.swing.JButton botAsigRespInf;
    private javax.swing.JButton botAsignTorneo;
    private javax.swing.JButton botBajaClub;
    private javax.swing.JButton botCamGerClub;
    private javax.swing.JButton botCrearClub;
    private javax.swing.JButton botCrearTorneo;
    private javax.swing.JButton botDarBajJug;
    private javax.swing.JButton botSetResPart;
    private javax.swing.JButton botSetSedeTorneo;
    // End of variables declaration//GEN-END:variables
}
