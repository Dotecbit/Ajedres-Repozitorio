/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import DAO.DatosClubDAO;
import DAO.DatosGerenteDAO;
import DAO.DatosTorneoDAO;
import Factory.Persona;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DatosClub;
import model.DatosJugador;
import model.DatosEntrenador;
import model.DatosGerente;
import model.DatosTorneo;

/**
 *
 * @author areba
 */
public class Administrador {

    private Jugador jugador;
    private DatosGerente datosGerente;
    private ArrayList<DatosGerente> gerentes;
    private DatosGerenteDAO datosGerenteDAO;
    private DatosClubDAO datosClubDAO;
    private DatosEntrenador datosEntrenador;
    private DatosTorneo datosTorneo;
    private DatosTorneoDAO torneoDAO;
    public Administrador(Jugador jugador) throws SQLException 
    {
        datosClubDAO = new DatosClubDAO();
        datosGerenteDAO = new DatosGerenteDAO();
        this.jugador = jugador;
        
        torneoDAO = new DatosTorneoDAO();

        torneoDAO.cargarSede();
    }
   
    public ArrayList<DatosGerente> getGerentes() throws SQLException
    {
        return datosGerenteDAO.getGerentes();
    }
    
    public ArrayList<DatosGerente> getGerentesConClub() throws SQLException
    {
        ArrayList<DatosGerente> gerEnvio = new ArrayList();
        
        //Seleccionamos todos los gerentes que tengan club
        gerentes = datosGerenteDAO.getGerentes();
        for(DatosGerente i:gerentes)
        {
            if(i.getClubActual() != null)
                gerEnvio.add(i);
        }
        return gerEnvio;
    }
    
    public ArrayList<DatosGerente> getGerentesLibres() throws SQLException
    {
        ArrayList<DatosGerente> gerentesLibres = new ArrayList();
        gerentes = datosGerenteDAO.getGerentes();
        for(DatosGerente g:gerentes)
        {
            if(g.getClubActual() == null)
                gerentesLibres.add(g);
        }
        return gerentesLibres;
    }
    
    public void guardarGerente(String nombre, String ape1, String ap2, String sexo,String edad, String nomina, String IRPF ) throws SQLException
    {
        DatosGerente gerente = new DatosGerente(nombre, ape1+" "+ap2, sexo, Integer.parseInt(edad),
                Float.parseFloat(nomina), Float.parseFloat(IRPF));
    
        datosGerenteDAO.CrearGerentes(gerente);
    }
    
    public ArrayList<DatosClub> getClubs() throws SQLException
    {
        return datosClubDAO.getClub();
    }

    public void cargarSedes()
    {
        torneoDAO.cargarSede();
    }
    public ArrayList<String> getSedes()
    {
        return torneoDAO.getSedes();
    }
    public void jugadores()
    {
        datosTorneo.jugadores(jugador.getDatosJugador());
    }
    public ArrayList<String> getJugadores()
    {
        return datosTorneo.getJugadores();
    }

    public void guardarEntrenador(String nombre, String ap1, String ap2, String sexo, String edad) {
        datosEntrenador.guardarDatosEntrenador(nombre, ap1, ap2, sexo, edad);
        datosEntrenador.cargarDatosEntrenadores();
    }

    public boolean entrenadorRepe(String nombre, String ap1, String ap2) {
        boolean repe = false;
        datosEntrenador.cargarDatosEntrenadores();
        for(DatosEntrenador i:datosEntrenador.getEntrenadores())
        {
            if(i.getnCompleto().toLowerCase().equals((nombre+" "+ap1+" "+ap2).toLowerCase()))
                repe = true;
        }
        return repe;
    }
    
    public void guardarTorneo(String nombre, ArrayList<String> usuario, ArrayList<String> sede)
    {
        datosTorneo.GuardarTorneo(nombre, usuario, sede);
    }

    public boolean gerenteRepe(String nombre, String ap1, String ap2) throws SQLException {
        boolean repe = false;
        for(DatosGerente i:datosGerenteDAO.getGerentes())
        {
            if(i.getnCompleto().toLowerCase().equals((nombre+" "+ap1+" "+ap2).toLowerCase()))
                repe = true;
        }
        return repe;
    }

    public boolean clubRepe(String nombre) throws SQLException {
        boolean repe = false;
        for(DatosClub i:datosClubDAO.getClub())
        {
            if(i.getNombre().toLowerCase().equals((nombre).toLowerCase()))
                repe = true;
        }
        return repe;
    }

    public void crearClub(String nombre, String sede, String federacion, Object ger) throws FileNotFoundException, IOException, SQLException {
        DatosClub nuevoClub = new DatosClub(nombre,sede,federacion);
        ((DatosGerente) ger).setClubActual(nombre);
        
        datosClubDAO.CrearClub(nuevoClub);
        datosGerenteDAO.actualizarGerente((DatosGerente) ger);
    }

    public void getCambiaClub(Object club, Object ger ) throws SQLException {
        
        
        //Copiamos los datos de todos los gerentes excepto el nuevo que queremos añadir con la nueva informacion
        for(DatosGerente i:datosGerenteDAO.getGerentes())
        {
            //Cambiamos el club del gerente anterior a null
            //Si fuera el mismo no sería erróneo porque no lo añadiríamos en la lista, quedándose en el mismo club
            if(((DatosClub) club).getNombre().equals(i.getClubActual()))
            {
                i.setClubActual(null);
                datosGerenteDAO.actualizarGerente(i);
            }
        }
        ((DatosGerente) ger).setClubActual(((DatosClub) club).getNombre());
        datosGerenteDAO.actualizarGerente((DatosGerente) ger);
    }

    public Iterable<String> getFederaciones() throws SQLException {
        return datosClubDAO.getFederaciones();
    }
}
