/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Facade.Administrador;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Ayoub El Moussaoui
 */
public class añadirJugadoresSedes extends javax.swing.JFrame {

    /**
     * Creates new form añadirJugadoresSedes
     */
    private Administrador administrador;
    private DefaultListModel modeloLista, modeloListaSede;
    private ArrayList<String> jugador;
    private ArrayList<String> sede;
    public añadirJugadoresSedes(Administrador administrador) {
        this.administrador = administrador;
        jugador = new ArrayList<>();
        sede = new ArrayList<>();
        initComponents();
        modeloLista = new DefaultListModel();
        modeloListaSede = new DefaultListModel();
        listaAñadirJugador.setModel(modeloLista);
        listaSede.setModel(modeloListaSede);
    }
    public void añadirJugador(Object añadir)
    {
        System.out.println(añadir);
        String aux = (String)añadir;
        int i = 0;
        boolean ok = false;
        while(i < jugador.size() && !ok) 
        {
            if(jugador.get(i).equals(aux))
                ok = true;
            i++;
        }
        if(!ok)
        {
            modeloLista.addElement((Object)aux);
            jugador.add(aux);
        }
            
    }
    public void añadirSede(Object añadir)
    {
        String aux = (String)añadir;
        int i = 0;
        boolean ok = false;
        while(i < sede.size() && !ok) 
        {
            if(sede.get(i).equals(aux))
                ok = true;
            i++;
        }
        if(!ok)
        {
            modeloListaSede.addElement((Object)aux);
            sede.add(aux);
        }
            
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaAñadirJugador = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaSede = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        aceptar = new javax.swing.JButton();
        eliminarSede = new javax.swing.JButton();
        eliminarJugador = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        nombreTorneo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(listaAñadirJugador);

        jScrollPane2.setViewportView(listaSede);

        jLabel1.setText("Jugadores");

        jLabel2.setText("Sedes");

        aceptar.setText("Crear torneo");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        eliminarSede.setText("Eliminar");
        eliminarSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarSedeActionPerformed(evt);
            }
        });

        eliminarJugador.setText("Eliminar");
        eliminarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarJugadorActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre");

        nombreTorneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTorneoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(aceptar)
                .addGap(238, 238, 238))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(eliminarJugador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(eliminarSede)
                .addGap(94, 94, 94))
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(131, 131, 131))
            .addGroup(layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(jLabel3)
                .addGap(27, 27, 27)
                .addComponent(nombreTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nombreTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eliminarSede)
                    .addComponent(eliminarJugador))
                .addGap(8, 8, 8)
                .addComponent(aceptar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eliminarSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarSedeActionPerformed
  
        Object aux = listaSede.getSelectedValue();
        if(aux != null)
        {
            String nombre  = (String)aux;
            sede.remove(nombre);
            modeloListaSede.removeElement(aux);
        }
        else
            JOptionPane.showMessageDialog(null, "Primero debe seleccionar una sede para eliminarlo.", "¡Sin seleccionar!", JOptionPane.WARNING_MESSAGE); 
    }//GEN-LAST:event_eliminarSedeActionPerformed

    private void eliminarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarJugadorActionPerformed
        Object aux = listaAñadirJugador.getSelectedValue();
        if(aux != null)
        {
            String nombre  = (String)aux;
            jugador.remove(nombre);
            modeloLista.removeElement(aux);
        }
        else
           JOptionPane.showMessageDialog(null, "Primero debe seleccionar un jugador para eliminarlo.", "¡Sin seleccionar!", JOptionPane.WARNING_MESSAGE); 
    }//GEN-LAST:event_eliminarJugadorActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        if(nombreTorneo.getText().equals("") || sede.size() == 0 || jugador.size() == 0)
            JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos para crear un torneo.", "¡Campos incompletos!", JOptionPane.WARNING_MESSAGE);
        else
        {
            administrador.guardarTorneo(nombreTorneo.getText(), jugador, sede);
            JOptionPane.showMessageDialog(null,"El torneo " + nombreTorneo.getText()+" ha sido creado"
                    + " correctamente.");
            nombreTorneo.setText("");
            
            for(int i = 0; i < jugador.size(); i++)
                jugador.remove(i);
            modeloLista.removeAllElements();
            for(int i = 0; i < sede.size(); i++)
                sede.remove(i);
            modeloListaSede.removeAllElements();
            
            
        }
    }//GEN-LAST:event_aceptarActionPerformed

    private void nombreTorneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTorneoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTorneoActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton eliminarJugador;
    private javax.swing.JButton eliminarSede;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaAñadirJugador;
    private javax.swing.JList<String> listaSede;
    private javax.swing.JTextField nombreTorneo;
    // End of variables declaration//GEN-END:variables
}
