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
        datosJugador.CargarDatosJugador();
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
                String correo, String fecha, String contraseña, String club, String categoria, String elo, String torneo)
    {
        jugadorDAO = new DatosJugadorDAO();
        
        jugadorDAO.agregarUsuario(nombre, apellido, usuario, correo, contraseña, fecha, club, categoria, elo, torneo);
       
    }
    public void guardarDatosResponsable(String usuario, String nombre, String Apellido,
                String correo, String fecha)
            
    {
        jugadorDAO = new DatosJugadorDAO();
       
        jugadorDAO.añadirResponsableInfantil(usuario, nombre, Apellido, correo, fecha);
    }
    public void cargarDatosJugador()
    {
        datosJugador.CargarDatosJugador();
    }
    public boolean validarUsuario(String usuario)
    {
        jugadorDAO = new DatosJugadorDAO();
        
        return jugadorDAO.validarUsuario(usuario);
    }
    public void añadirUsuario(String nombre, String apellido, String usuario, String correo, String contraseña, 
            String fechaNacimiento, String club, String categoria, String elo)
    {
        datosJugador.añadirUsuario(nombre, apellido, usuario, correo, contraseña, fechaNacimiento, club,
                categoria, elo);
    }
    
    public boolean validarCuenta(String usuario, String contraseña)
    {
        jugadorDAO = new DatosJugadorDAO();
        
        return jugadorDAO.validarUsuario(usuario, contraseña);
    }
    public ArrayList<DatosJugador> getDatosJugador() 
    {
        return datosJugador.getDatosJugador();
    }
    public ArrayList<String> getTarjeta(String usuario)
    {
        jugadorDAO = new DatosJugadorDAO();
        
        return jugadorDAO.verTarjeta(usuario);
    }
    public void darDeBaja(String usuario) throws IOException
    {
        jugadorDAO = new DatosJugadorDAO();
        jugadorDAO.darBajaUsuario(usuario);

    }
}
