/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import controlador.Administrador;
import controlador.Jugador;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.DatosClub;
import model.DatosJugador;
import model.DatosEntrenador;
import model.DatosGerente;

/**
 *
 * @author Ayoub El Moussaoui
 */
public class Login extends javax.swing.JFrame 
{
    /**
     * Creates new form Login
     */
    private Jugador jugador;
    private Administrador administrador;
    private DatosGerente gerente; 
    private DatosJugador datJug;
    private DatosClub club;
    private DatosEntrenador entrenador;
 
    public Login() {
        jugador = new Jugador();
        administrador = new Administrador(jugador);
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

        iniciarSesión = new javax.swing.JButton();
        Usuario = new javax.swing.JTextField();
        Contraseña = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Registrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        iniciarSesión.setText("Iniciar sesión");
        iniciarSesión.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarSesiónActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuario");

        jLabel2.setText("Contraeña");

        Registrar.setText("Registrarse");
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iniciarSesión, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                        .addComponent(Contraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                    .addComponent(Registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(iniciarSesión)
                .addGap(18, 18, 18)
                .addComponent(Registrar)
                .addContainerGap(135, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarSesiónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarSesiónActionPerformed
        
        if(Usuario.getText().equals("") || Contraseña.getText().equals(""))
        {
            VAdministrador ventanaAdministrador= new VAdministrador(administrador, this);
            ventanaAdministrador.setVisible(true);
            this.setVisible(false);
            ventanaAdministrador.setSize(400, 580);
            ventanaAdministrador.setLocationRelativeTo(null);
            ventanaAdministrador.setResizable(false);
            ventanaAdministrador.setTitle("Administrador"); 
            //JOptionPane.showMessageDialog(null,"Ingresa su cuenta.");
        }
            
        
        else if(!jugador.validarCuenta(Usuario.getText(), Contraseña.getText()))
            JOptionPane.showMessageDialog(null, "El usuario o la contraseña que has introducido no coinciden con ninguna cuenta. Regístrate para crear una cuenta.", "¡Cuenta incorrecta!", JOptionPane.WARNING_MESSAGE);
        //Aqui iría la verificación de la cuenta.
        else 
        {
            ventanaPrincipal ventanaPrincipal = new ventanaPrincipal(this, Usuario.getText(), jugador);
            this.setVisible(false); 
            ventanaPrincipal.setVisible(true);
            ventanaPrincipal.setLocationRelativeTo(null);
            ventanaPrincipal.setResizable(false);
            ventanaPrincipal.setTitle("Principal");
            
        }

        
    }//GEN-LAST:event_iniciarSesiónActionPerformed

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
        Registrarse registrarse = new Registrarse(this, jugador);
        this.setVisible(false); 
        registrarse.setVisible(true);
        registrarse.setLocationRelativeTo(null);
        registrarse.setResizable(false);
        registrarse.setTitle("Registrarse");
        
    }//GEN-LAST:event_RegistrarActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login view = new Login();
                    view.setResizable(false);
                    view.setTitle("Login");
                    view.setVisible(true);
                    view.setLocationRelativeTo(null);
                } catch (Exception ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Contraseña;
    private javax.swing.JButton Registrar;
    private javax.swing.JTextField Usuario;
    private javax.swing.JButton iniciarSesión;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
