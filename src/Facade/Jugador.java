/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import DAO.DatosJugadorDAO;
import Factory.Persona;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import model.*;

/**
 *
 * @author Ayoub El Moussaoui
 */
public class Jugador 
{
    private DatosJugador datosJugador;
    private DatosJugadorDAO jugadorDAO;
    
    public Jugador()
    {
        Persona personaJugador = new Persona();
        
        datosJugador = (DatosJugador) personaJugador.crearPersona(1);
        
        jugadorDAO = new DatosJugadorDAO();
        
        
    }
    public int edadJugador(Date fecha)
    {
        return datosJugador.edadJugador(fecha);
    }

    /**
     *
     * @param nombre
     * @param apellido
     * @param usuario
     * @param correo
     * @param fecha
     * @param contraseña
     * @param club
     * @param categoria
     * @param elo
     * @param torneo
     */
    public void guardarDatosJugador(String nombre, String apellido, String usuario,
                String correo, String fecha, String contraseña, String club, String categoria, String elo)
    {

        jugadorDAO.agregarUsuario(nombre, apellido, usuario, correo, contraseña, fecha, club, categoria, elo);
       
    }
    public void guardarDatosResponsable(String usuario, String nombre, String Apellido,
                String correo, String fecha)
            
    {
        jugadorDAO.añadirResponsableInfantil(usuario, nombre, Apellido, correo, fecha);
    }

    public boolean validarUsuario(String usuario)
    {
        return jugadorDAO.validarUsuario(usuario);
    }

    public boolean validarCuenta(String usuario, String contraseña)
    {
        
        return jugadorDAO.validarUsuario(usuario, contraseña);
    }

    public ArrayList<String> getTarjeta(String usuario)
    {

        return jugadorDAO.verTarjeta(usuario);
    }
    public void darDeBajaJugador(String usuario) throws IOException
    {
        jugadorDAO.darBajaUsuario(usuario);
    }
    
    public ArrayList<String> obtenerUsuarios()
    {
        return jugadorDAO.obtenerUsuarios();
    }
}
