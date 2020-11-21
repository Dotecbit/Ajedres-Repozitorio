/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import DAO.DatosTorneoDAO;
import Factory.Persona;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
    private DatosClub datosClub;
    private DatosEntrenador datosEntrenador;
    private DatosTorneo datosTorneo;
    private DatosTorneoDAO torneoDAO;
    public Administrador(Jugador jugador) 
    {
        
        this.jugador = jugador;
        datosTorneo = new DatosTorneo();
        
        torneoDAO = new DatosTorneoDAO();
        torneoDAO.cargarSede();
        
        
        datosClub = new DatosClub();
        datosClub.cargarDatosClub();
        
        Persona personaGerente = new Persona();
        datosGerente = (DatosGerente) personaGerente.crearPersona(2);
        datosGerente.cargarDatosGerente();
        
        Persona personaEntrenador = new Persona();
        datosEntrenador = (DatosEntrenador) personaEntrenador.crearPersona(3);
        datosEntrenador.cargarDatosEntrenadores();
        
        jugadores();
    }
   
    public ArrayList<DatosGerente> getGerentes()
    {
        datosGerente.cargarDatosGerente();
        return datosGerente.getGerentes();
    }
    
    public ArrayList<DatosGerente> getGerentesConClub()
    {
        ArrayList<DatosGerente> gerEnvio = new ArrayList();
        
        //Seleccionamos todos los gerentes que tengan club
        for(DatosGerente i:datosGerente.getGerentes())
        {
            if(!i.getClubActual().toLowerCase().equals(("null")))
                gerEnvio.add(i);
        }
        return gerEnvio;
    }
    
    public ArrayList<DatosGerente> getGerentesLibres()
    {
        datosGerente.cargarDatosGerente();
        return datosGerente.getGerentesLibres();
    }
    
    public void guardarGerente(String nombre, String ape1, String ap2, String sexo,String edad, String nomina, String IRPF )
    {
        datosGerente.guardarDatosGerente(nombre, ape1+" "+ap2, sexo, Integer.parseInt(edad),
                Float.parseFloat(nomina), Float.parseFloat(IRPF), "null");
        datosGerente.cargarDatosGerente();
    }
    
    public ArrayList<DatosClub> getClubs()
    {
        datosClub.cargarDatosClub();
        return datosClub.getClubs();
    }

//    public void getCambiaClub(Object gerente, Object club) 
//    {
//        //Actualizamos el club que se ha cambiado el gerente
//        ((DatosGerente) gerente).getClubActual().setGerente(null);
//        //Añadimso el nuevo club al historial
//        ((DatosGerente) gerente).actHistClub((DatosClub) club);
//        //Asignamos al gerente el club al que se ha cambiado
//        ((DatosGerente) gerente).setClubActual((DatosClub) club);
//        //Asignamos al club el nuevo gerente
//        ((DatosClub) club).setGerente((DatosGerente) gerente);
//    }
    public void cargarSedes()
    {
        datosTorneo.CargarSedes();
    }
    public ArrayList<String> getSedes()
    {
        return datosTorneo.getSedes();
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

    public boolean gerenteRepe(String nombre, String ap1, String ap2) {
        boolean repe = false;
        datosGerente.cargarDatosGerente();
        for(DatosGerente i:datosGerente.getGerentes())
        {
            if(i.getnCompleto().toLowerCase().equals((nombre+" "+ap1+" "+ap2).toLowerCase()))
                repe = true;
        }
        return repe;
    }

    public boolean clubRepe(String nombre) {
        boolean repe = false;
        datosGerente.cargarDatosGerente();
        for(DatosClub i:datosClub.getClubes())
        {
            if(i.getNombre().toLowerCase().equals((nombre).toLowerCase()))
                repe = true;
        }
        return repe;
    }

    public void crearClub(String nombre, String sede, String federacion, Object ger) throws FileNotFoundException, IOException {
        datosClub.guardarDatosClub(nombre, sede, federacion);
        datosClub.cargarDatosClub();
        ArrayList<DatosGerente> listagerente = new ArrayList();
        //Actualizar datos gerente y guardarlos
        ((DatosGerente) ger).setClubActual(nombre);
        
        //Copiamos los datos de todos los gerentes excepto el nuevo que queremos añadir con la nueva informacion
        for(DatosGerente i:datosGerente.getGerentes())
        {
            if(!i.getnCompleto().equals(((DatosGerente)ger).getnCompleto()))
                listagerente.add(i);
        }
        listagerente.add((DatosGerente) ger);
        datosGerente.setGerentes(listagerente);
        datosGerente.guardarDatosGerenteActuales();
        datosGerente.cargarDatosGerente();
        
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

    public void getCambiaClub(Object club, Object ger ) {
        ArrayList<DatosGerente> listagerente = new ArrayList();
        //Actualizar datos gerente
        
        
        //Copiamos los datos de todos los gerentes excepto el nuevo que queremos añadir con la nueva informacion
        for(DatosGerente i:datosGerente.getGerentes())
        {
            //Cambiamos el club del gerente anterior a null
            //Si fuera el mismo no sería erróneo porque no lo añadiríamos en la lista, quedándose en el mismo club
            if(((DatosClub) club).getNombre().equals(i.getClubActual()))
                i.setClubActual("null");
            //No añadimos a nuestra lista de gerentes el gerente con los datos antiguos
            if(!i.getnCompleto().equals(((DatosGerente)ger).getnCompleto()))
                listagerente.add(i);
        }
        ((DatosGerente) ger).setClubActual(((DatosClub) club).getNombre());
        listagerente.add((DatosGerente) ger);
        datosGerente.setGerentes(listagerente);
        datosGerente.guardarDatosGerenteActuales();
        datosGerente.cargarDatosGerente();
    }
}
