package Vista;

import Facade.Administrador;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VCrearEntrenador extends javax.swing.JFrame {
VAdministrador vAnterior;
Administrador admin;

    public VCrearEntrenador(VAdministrador vAnterior, Administrador admin) {
        this.vAnterior = vAnterior; 
        this.admin = admin;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTexEdad = new javax.swing.JTextField();
        jTexAp1 = new javax.swing.JTextField();
        jTexAp2 = new javax.swing.JTextField();
        jTexNom = new javax.swing.JTextField();
        jBAceptar = new javax.swing.JButton();
        jBAtas = new javax.swing.JButton();
        jCoBoSexo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre");

        jLabel2.setText("Aplleido1");

        jLabel3.setText("Apellido2");

        jLabel4.setText("Sexo");

        jLabel5.setText("Edad");

        jTexNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTexNomActionPerformed(evt);
            }
        });

        jBAceptar.setText("Aceptar");
        jBAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAceptarActionPerformed(evt);
            }
        });

        jBAtas.setText("Atrás");
        jBAtas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAtasActionPerformed(evt);
            }
        });

        jCoBoSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "H", "M", "NB" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(jTexNom, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTexAp1, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                            .addComponent(jTexEdad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTexAp2)
                    .addComponent(jCoBoSexo, 0, 105, Short.MAX_VALUE))
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBAtas, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTexNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jTexAp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTexAp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jTexEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCoBoSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAceptar)
                    .addComponent(jBAtas))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTexNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTexNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTexNomActionPerformed

    private void jBAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAceptarActionPerformed
    if(jTexNom.getText().isEmpty() || jTexAp1.getText().isEmpty() || jTexAp2.getText().isEmpty() || jTexEdad.getText().isEmpty())
    {
        JOptionPane.showMessageDialog(null,"Rellene todos los campos.");
    }
    else
    {
        try {
            if(admin.entrenadorRepe(jTexNom.getText(),jTexAp1.getText(),jTexAp2.getText()))
            {
                JOptionPane.showMessageDialog(null,"El entrenador ya se encuentra en la base de datos.");
                jTexNom.setText("");
                jTexAp1.setText("");
                jTexAp2.setText("");
            }
            else
            {
                admin.guardarEntrenador(jTexNom.getText(),jTexAp1.getText(),jTexAp2.getText(),
                jCoBoSexo.getSelectedItem().toString(),jTexEdad.getText());
                JOptionPane.showMessageDialog(null,"Se ha añadidio el entrenador.");
                jTexNom.setText("");
                jTexAp1.setText("");
                jTexAp2.setText("");
                jTexEdad.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(VCrearEntrenador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }//GEN-LAST:event_jBAceptarActionPerformed

    private void jBAtasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAtasActionPerformed
    this.setVisible(false);
    vAnterior.setLocationRelativeTo(null);
    vAnterior.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_jBAtasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAceptar;
    private javax.swing.JButton jBAtas;
    private javax.swing.JComboBox<String> jCoBoSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTexAp1;
    private javax.swing.JTextField jTexAp2;
    private javax.swing.JTextField jTexEdad;
    private javax.swing.JTextField jTexNom;
    // End of variables declaration//GEN-END:variables
}
