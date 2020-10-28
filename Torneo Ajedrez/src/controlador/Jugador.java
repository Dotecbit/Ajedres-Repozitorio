/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Date;
import model.*;

/**
 *
 * @author Ayoub El Moussaoui
 */
public class Jugador 
{
    private DatosJugador datosJugador;
    
    public Jugador()
    {
       datosJugador = new DatosJugador();
    }
    public boolean edadJugador(Date fecha)
    {
        return datosJugador.edadJugador(fecha);
    }
    public void guardarDatosJugador(String nombre, String apellido, String usuario,
                String correo, String fecha, String contraseña)
    {
        datosJugador.guardarDatosJugador(nombre, apellido, usuario, correo, fecha, contraseña);
    }
    public void guardarDatosResponsable(String usuario, String nombre, String Apellido,
                String correo, String fecha)
    {
        datosJugador.guardarDatosResponsable(usuario, nombre, Apellido, correo, fecha);
    }
    public void cargarDatosJugador()
    {
        datosJugador.CargarDatosJugador();
    }
    public boolean validarUsuario(String usuario)
    {
        return datosJugador.validarUsuario(usuario);
    }
    public void añadirUsuario(String nombre, String apellido, String usuario, String correo, String contraseña, String fechaNacimiento)
    {
        datosJugador.añadirUsuario(nombre, apellido, usuario, correo, contraseña, fechaNacimiento);
    }
    
    public boolean validarCuenta(String usuario, String contraseña)
    {
        return datosJugador.validarCuenta(usuario, contraseña);
    }
}
