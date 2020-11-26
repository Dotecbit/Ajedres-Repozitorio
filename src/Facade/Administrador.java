/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import DAO.DatosClubDAO;
import DAO.DatosGerenteDAO;
import DAO.DatosJugadorDAO;
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
    private DatosClub datosClub;
    private DatosEntrenador datosEntrenador;
    private DatosTorneo datosTorneo;
    private DatosTorneoDAO torneoDAO;
    public Administrador(Jugador jugador) throws SQLException 
    {
        datosGerenteDAO = new DatosGerenteDAO();
        this.jugador = jugador;
        
        datosTorneo = new DatosTorneo();
        torneoDAO = new DatosTorneoDAO();
        
        torneoDAO.cargarSede();
        //datosClub = new DatosClub();
        //datosClub.cargarDatosClub();
        
        //Persona personaGerente = new Persona();
        //datosGerente = (DatosGerente) personaGerente.crearPersona(2);
        
        //Persona personaEntrenador = new Persona();
        //datosEntrenador = (DatosEntrenador) personaEntrenador.crearPersona(3);
        //datosEntrenador.cargarDatosEntrenadores();
        
        //jugadores();
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
            if(g.getClubActual().equals("null"))
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
    public ArrayList<String> getSedes()
    {
        return torneoDAO.getSedes();
    }

    public ArrayList<String> getJugadores()
    {
        torneoDAO.cargarSede();
        return jugador.obtenerUsuarios();
    }
    public ArrayList<String> getTorneos()
    {
        return torneoDAO.nombreTorneos();
    }
    public boolean comprobarTorneo(String nombreTorneo)
    {
        return datosTorneo.comprobarTorneo(nombreTorneo, torneoDAO.nombreTorneos());
    }
    
    public boolean comprobarTorneoUsuario(String usuario, String torneo)
    {
        return torneoDAO.comprobarTorneoUsuario(usuario, torneo);
    }
    
    public ArrayList<String> asignarJugadoresTorneo(String nombreTorneo)
    {
        return torneoDAO.asignarJugadoresTorneo(nombreTorneo);
    }
    
    public ArrayList<String> jugadoresParticipantes(String nombreTorneo) throws SQLException
    {
        return torneoDAO.jugadoresParticipantes(nombreTorneo);
    }
    
    public void eliminarJugadorTorneo(String usuario, String torneo)
    {
        torneoDAO.eliminarJugadorTorneo(usuario, torneo);
    }
    
    public ArrayList<String> asignarSedesTorneo(String nombreTorneo)
    {
        return torneoDAO.asignarSedesTorneo(nombreTorneo);
    }
    
     public ArrayList<String> sedesParticipantes(String nombreTorneo)
    {
        return torneoDAO.sedesParticipantes(nombreTorneo);
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
    
    public void guardarTorneoUsuario(String usuario, String torneo)        
    {
        ArrayList <String> jugador = new ArrayList<>();
        jugador.add(usuario);
        
        torneoDAO.agregarTorneoJugador(torneo, jugador);
    }
    
    public void guardarTorneo(String nombre, ArrayList<String> usuario, ArrayList<String> sede)
    {
        torneoDAO.agregarTorneo(nombre);
        
        if(sede.size() > 0)
            torneoDAO.agregarTorneoSede(nombre, sede);
        
        if(usuario.size() > 0)
            torneoDAO.agregarTorneoJugador(nombre, usuario);
    }
    public void guardarSedeTorneo(String sede, String nombreTorneo)
    {
        ArrayList<String> sedes = new ArrayList<>();
        sedes.add(sede);
        torneoDAO.agregarTorneoSede(nombreTorneo, sedes);
    }
    
    public void eliminarSedeTorneo(String sede, String nombreTorneo)
    {
        torneoDAO.eliminarSedeTorneo(sede, nombreTorneo);
    }
    
    public void darDeBajaJugador(String usuario) throws IOException
    {
        jugador.darDeBajaJugador(usuario);
    }
    
    public void darDeBajaTorneo(String torneo)
    {
        torneoDAO.darDebajaTorneo(torneo);
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

    public boolean clubRepe(String nombre) {
        boolean repe = false;
        for(DatosClub i:datosClub.getClubes())
        {
            if(i.getNombre().toLowerCase().equals((nombre).toLowerCase()))
                repe = true;
        }
        return repe;
    }

    public void crearClub(String nombre, String sede, String federacion, Object ger) throws FileNotFoundException, IOException, SQLException {
        datosClub.guardarDatosClub(nombre, sede, federacion);
        datosClub.cargarDatosClub();
        ArrayList<DatosGerente> listagerente = new ArrayList();
        //Actualizar datos gerente y guardarlos
        ((DatosGerente) ger).setClubActual(nombre);
        
        //Copiamos los datos de todos los gerentes excepto el nuevo que queremos añadir con la nueva informacion
        for(DatosGerente i:datosGerenteDAO.getGerentes())
        {
            if(!i.getnCompleto().equals(((DatosGerente)ger).getnCompleto()))
                listagerente.add(i);
        }
        listagerente.add((DatosGerente) ger);
        datosGerenteDAO.setGerentes(listagerente);
        
        //Eliminar sede de sedes disponibles
        ArrayList<String> sed = new ArrayList();

        FileReader leer = new FileReader("ficheros/SedesDisponibles.txt");
        BufferedReader datosSedes = new BufferedReader(leer);
        String dato;

        while((dato = datosSedes.readLine()) != null)
        {
            if(!dato.equals(sede))
                sed.add(dato);
        } 
        
        leer.close();
        datosSedes.close();
        
        FileWriter escribir = new FileWriter("ficheros/SedesDisponibles.txt");
        PrintWriter p = new PrintWriter(escribir);

        for(String s:sed)
        {
                p.println(s);
        } 
        
        escribir.close();
        p.close();
    }

    public ArrayList<String> getFederaciones() throws FileNotFoundException, IOException {
            ArrayList<String> federaciones = new ArrayList();
            
            FileReader leer = new FileReader("ficheros/Federaciones.txt");
            BufferedReader datosFederaciones = new BufferedReader(leer);
            String dato;
            
            while((dato = datosFederaciones.readLine()) != null)
            {
                federaciones.add(dato);
                datosFederaciones.readLine();
            }
            
        return federaciones;    
    }

    public void getCambiaClub(Object club, Object ger ) throws SQLException {
        
        
        //Copiamos los datos de todos los gerentes excepto el nuevo que queremos añadir con la nueva informacion
        for(DatosGerente i:datosGerenteDAO.getGerentes())
        {
            //Cambiamos el club del gerente anterior a null
            //Si fuera el mismo no sería erróneo porque no lo añadiríamos en la lista, quedándose en el mismo club
            if(((DatosClub) club).getNombre().equals(i.getClubActual()))
            {
                i.setClubActual("null");
                datosGerenteDAO.actualizarGerente(i);
            }
        }
        ((DatosGerente) ger).setClubActual(((DatosClub) club).getNombre());
        datosGerenteDAO.actualizarGerente((DatosGerente) ger);
    }
}
