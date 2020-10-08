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
public class VentanaAdministrador extends javax.swing.JPanel implements java.beans.Customizer {
    
    private Object bean;

    /**
     * Creates new customizer VentanaAdministrador
     */
    public VentanaAdministrador() {
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

        botSetResPart.setText("Introducir resultados última partida");

        botSetSedeTorneo.setText("Asignacion de sede de torneos");

        botDarBajJug.setText("Dar baja jugador");
        botDarBajJug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botDarBajJugActionPerformed(evt);
            }
        });

        botAsignTorneo.setText("Asignar jugador a torneo");

        botCamGerClub.setText("Cambiar gerente club");
        botCamGerClub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botCamGerClubActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(65, Short.MAX_VALUE)
                        .addComponent(botCrearTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(botBajaClub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(BotDarBajaTorneo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botAsigRespInf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botSetResPart, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE))
                            .addComponent(botSetSedeTorneo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                            .addComponent(botDarBajJug, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botAsignTorneo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botCamGerClub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(76, 76, 76))
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(botCrearClub, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(botCrearTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(botBajaClub)
                .addGap(35, 35, 35)
                .addComponent(botCrearClub, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(BotDarBajaTorneo)
                .addGap(33, 33, 33)
                .addComponent(botAsigRespInf)
                .addGap(28, 28, 28)
                .addComponent(botSetResPart)
                .addGap(39, 39, 39)
                .addComponent(botSetSedeTorneo)
                .addGap(36, 36, 36)
                .addComponent(botDarBajJug)
                .addGap(34, 34, 34)
                .addComponent(botAsignTorneo)
                .addGap(18, 18, 18)
                .addComponent(botCamGerClub)
                .addContainerGap(61, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botCrearClubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botCrearClubActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botCrearClubActionPerformed

    private void botCrearTorneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botCrearTorneoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botCrearTorneoActionPerformed

    private void botBajaClubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botBajaClubActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botBajaClubActionPerformed

    private void botDarBajJugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botDarBajJugActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botDarBajJugActionPerformed

    private void botCamGerClubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botCamGerClubActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botCamGerClubActionPerformed


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
