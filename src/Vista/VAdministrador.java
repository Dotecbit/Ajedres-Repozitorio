/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Vista.VAdminDarDeBajaJugador;
import Vista.VAdminInResUltPar;
import Vista.VAsignarJugTor;
import Vista.VAsignarRespInf;
import Vista.VAsignarSedeTor;
import Vista.VCamGerClub;
import Vista.VCrearClub;
import Vista.VCrearEntrenador;
import Vista.VCrearGerente;
import Vista.VCrearTorneo;
import Vista.VDarBajaClub;
import Vista.añadirJugadoresSedes;
import Facade.Administrador;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author areba
 */
public class VAdministrador extends javax.swing.JFrame
{
    private static Administrador administrador;
    private JFrame ventanaAnterior;
    public VAdministrador(Administrador administrador, JFrame ventanaAnterior) {
        this.administrador = administrador;
        this.ventanaAnterior = ventanaAnterior;
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

        bCrearTorneo = new javax.swing.JButton();
        bDarDeBaja = new javax.swing.JButton();
        bCrearClub = new javax.swing.JButton();
        bBajaTorneo = new javax.swing.JButton();
        bRespInf = new javax.swing.JButton();
        bResUlt = new javax.swing.JButton();
        bBajaJugador = new javax.swing.JButton();
        bAsigJugTor = new javax.swing.JButton();
        bAsigSedTor = new javax.swing.JButton();
        bCambGerClub = new javax.swing.JButton();
        bCambGerClub1 = new javax.swing.JButton();
        jBCrearEntrenador = new javax.swing.JButton();
        jBCerrarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(null);

        bCrearTorneo.setText("Crear torneo");
        bCrearTorneo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bCrearTorneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCrearTorneoActionPerformed(evt);
            }
        });

        bDarDeBaja.setText("Dar de baja club");
        bDarDeBaja.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bDarDeBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDarDeBajaActionPerformed(evt);
            }
        });

        bCrearClub.setText("Crear Club");
        bCrearClub.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bCrearClub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCrearClubActionPerformed(evt);
            }
        });

        bBajaTorneo.setText("Dar de baja torneo");
        bBajaTorneo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bBajaTorneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBajaTorneoActionPerformed(evt);
            }
        });

        bRespInf.setText("Asignar responsables infantiles");
        bRespInf.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bRespInf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRespInfActionPerformed(evt);
            }
        });

        bResUlt.setText("Instroducir resultados última partida");
        bResUlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bResUltActionPerformed(evt);
            }
        });

        bBajaJugador.setText("Dar de baja jugador");
        bBajaJugador.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bBajaJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBajaJugadorActionPerformed(evt);
            }
        });

        bAsigJugTor.setText("Asignar jugadores a torneo");
        bAsigJugTor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bAsigJugTor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAsigJugTorActionPerformed(evt);
            }
        });

        bAsigSedTor.setText("Asignacion de sede de torneos");
        bAsigSedTor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bAsigSedTor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAsigSedTorActionPerformed(evt);
            }
        });

        bCambGerClub.setText("Cambiar gerente club");
        bCambGerClub.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bCambGerClub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCambGerClubActionPerformed(evt);
            }
        });

        bCambGerClub1.setText("Crear Gerente");
        bCambGerClub1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bCambGerClub1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCambGerClub1ActionPerformed(evt);
            }
        });

        jBCrearEntrenador.setText("Crear entrenador");
        jBCrearEntrenador.setMaximumSize(new java.awt.Dimension(137, 23));
        jBCrearEntrenador.setMinimumSize(new java.awt.Dimension(137, 23));
        jBCrearEntrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCrearEntrenadorActionPerformed(evt);
            }
        });

        jBCerrarSesion.setText("Cerrar Sesión");
        jBCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bCrearTorneo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bDarDeBaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bCrearClub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bBajaTorneo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bRespInf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bResUlt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bBajaJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bAsigJugTor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bAsigSedTor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bCambGerClub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bCambGerClub1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBCrearEntrenador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(bCrearTorneo)
                .addGap(18, 18, 18)
                .addComponent(bDarDeBaja)
                .addGap(18, 18, 18)
                .addComponent(bCrearClub)
                .addGap(18, 18, 18)
                .addComponent(bBajaTorneo)
                .addGap(18, 18, 18)
                .addComponent(bRespInf)
                .addGap(18, 18, 18)
                .addComponent(bResUlt)
                .addGap(18, 18, 18)
                .addComponent(bBajaJugador)
                .addGap(18, 18, 18)
                .addComponent(bAsigJugTor)
                .addGap(18, 18, 18)
                .addComponent(bAsigSedTor)
                .addGap(18, 18, 18)
                .addComponent(bCambGerClub1)
                .addGap(18, 18, 18)
                .addComponent(bCambGerClub)
                .addGap(18, 18, 18)
                .addComponent(jBCrearEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jBCerrarSesion)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCrearTorneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCrearTorneoActionPerformed
    añadirJugadoresSedes añadirJugador = new añadirJugadoresSedes(administrador);
    VCrearTorneo crearTorneo = new VCrearTorneo(this, administrador, añadirJugador);


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
    }//GEN-LAST:event_bCrearTorneoActionPerformed

    private void bDarDeBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDarDeBajaActionPerformed
    VDarBajaClub bajaCLub = new VDarBajaClub(this);
    this.setVisible(false); 
    bajaCLub.setVisible(true);
    bajaCLub.setLocationRelativeTo(null);
    bajaCLub.setResizable(false);
    bajaCLub.setTitle("Baja club");
    }//GEN-LAST:event_bDarDeBajaActionPerformed

    private void bCrearClubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCrearClubActionPerformed
        try {
            VCrearClub crearClub= new VCrearClub(this,administrador);
            this.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(VAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bCrearClubActionPerformed

    private void bBajaTorneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBajaTorneoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bBajaTorneoActionPerformed

    private void bRespInfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRespInfActionPerformed
    VAsignarRespInf asignarInfantil = new VAsignarRespInf(this);
    this.setVisible(false); 
    asignarInfantil.setVisible(true);
    asignarInfantil.setLocationRelativeTo(null);
    asignarInfantil.setResizable(false);
    asignarInfantil.setTitle("Introducir resultado"); 
    }//GEN-LAST:event_bRespInfActionPerformed

    private void bResUltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bResUltActionPerformed
    VAdminInResUltPar introducirResultado = new VAdminInResUltPar(this);
    this.setVisible(false); 
    introducirResultado.setVisible(true);
    introducirResultado.setLocationRelativeTo(null);
    introducirResultado.setResizable(false);
    introducirResultado.setTitle("Introducir resultado"); 
    }//GEN-LAST:event_bResUltActionPerformed

    private void bBajaJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBajaJugadorActionPerformed
    VAdminDarDeBajaJugador darBajaJugador = new VAdminDarDeBajaJugador(this);
    this.setVisible(false); 
    darBajaJugador.setVisible(true);
    darBajaJugador.setLocationRelativeTo(null);
    darBajaJugador.setResizable(false);
    darBajaJugador.setTitle("Baja jugador"); 
    }//GEN-LAST:event_bBajaJugadorActionPerformed

    private void bCambGerClubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCambGerClubActionPerformed
        try {
            VCamGerClub cambiarGerenteClub = new VCamGerClub(this,administrador);
            this.setVisible(false);
            cambiarGerenteClub.setVisible(true);
            cambiarGerenteClub.setLocationRelativeTo(null);
            cambiarGerenteClub.setResizable(false);
            cambiarGerenteClub.setTitle("Cambiar de club");
        } catch (SQLException ex) {
            Logger.getLogger(VAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bCambGerClubActionPerformed

    private void bAsigSedTorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAsigSedTorActionPerformed
    VAsignarSedeTor asignarJugadorTorneo = new VAsignarSedeTor(this);
    this.setVisible(false); 
    asignarJugadorTorneo.setVisible(true);
    asignarJugadorTorneo.setLocationRelativeTo(null);
    asignarJugadorTorneo.setResizable(false);
    asignarJugadorTorneo.setTitle("Asignar sede torneo");
    }//GEN-LAST:event_bAsigSedTorActionPerformed

    private void bAsigJugTorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAsigJugTorActionPerformed
    VAsignarJugTor asignarJugadorTorneo = new VAsignarJugTor(this);
    this.setVisible(false); 
    asignarJugadorTorneo.setVisible(true);
    asignarJugadorTorneo.setLocationRelativeTo(null);
    asignarJugadorTorneo.setResizable(false);
    asignarJugadorTorneo.setTitle("Asignar a torneo");
    }//GEN-LAST:event_bAsigJugTorActionPerformed

    private void bCambGerClub1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCambGerClub1ActionPerformed
    VCrearGerente VCrearGerente = new VCrearGerente(this,administrador);
    this.setVisible(false); 
    VCrearGerente.setVisible(true);
    VCrearGerente.setLocationRelativeTo(null);
    VCrearGerente.setResizable(false);
    VCrearGerente.setTitle("Crear Gerente");
    }//GEN-LAST:event_bCambGerClub1ActionPerformed

    private void jBCrearEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCrearEntrenadorActionPerformed
    VCrearEntrenador VCrearEntrenador = new VCrearEntrenador(this,administrador);
    this.setVisible(false); 
    VCrearEntrenador.setVisible(true);
    VCrearEntrenador.setLocationRelativeTo(null);
    VCrearEntrenador.setResizable(false);
    VCrearEntrenador.setTitle("Crear Entrneador");
    }//GEN-LAST:event_jBCrearEntrenadorActionPerformed

    private void jBCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCerrarSesionActionPerformed
    ventanaAnterior.setVisible(true); 
    this.setVisible(false);
    this.dispose();
    }//GEN-LAST:event_jBCerrarSesionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAsigJugTor;
    private javax.swing.JButton bAsigSedTor;
    private javax.swing.JButton bBajaJugador;
    private javax.swing.JButton bBajaTorneo;
    private javax.swing.JButton bCambGerClub;
    private javax.swing.JButton bCambGerClub1;
    private javax.swing.JButton bCrearClub;
    private javax.swing.JButton bCrearTorneo;
    private javax.swing.JButton bDarDeBaja;
    private javax.swing.JButton bResUlt;
    private javax.swing.JButton bRespInf;
    private javax.swing.JButton jBCerrarSesion;
    private javax.swing.JButton jBCrearEntrenador;
    // End of variables declaration//GEN-END:variables
}
