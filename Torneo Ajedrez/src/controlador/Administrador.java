/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
    private DatosJugador datosJugador;
    private DatosClub datosClub;
    private DatosEntrenador datosEntrenador;
    private DatosTorneo datosTorneo;
    public Administrador(Jugador jugador) 
    {
        
        this.jugador = jugador;
        datosTorneo = new DatosTorneo();
        datosTorneo.CargarSedes();
        
        datosClub = new DatosClub();
        datosClub.cargarDatosClub();
        
        datosGerente = new DatosGerente();
        datosGerente.cargarDatosGerente();
        
        datosEntrenador = new DatosEntrenador();
        datosEntrenador.cargarDatosEntrenadores();
        
        datosJugador = new DatosJugador();
        datosJugador.CargarDatosJugador();
        
        jugadores();
    }
   
    public ArrayList<DatosGerente> getGerentes()
    {
        return datosGerente.getGerentes();
    }
    
    public ArrayList<String> getGerentesLibres()
    {
        return datosGerente.getGerentesLibres();
    }
    
    public void guardarGerente(String nombre, String ape1, String ap2, String sexo,String edad, String nomina, String IRPF )
    {
        datosGerente.guardarDatosGerente(nombre, ape1+" "+ap2, sexo, Integer.parseInt(edad),
                Float.parseFloat(nomina), Float.parseFloat(IRPF), "null");
    }
    
    public ArrayList<DatosClub> getClubs()
    {
        return datosClub.getClubs();
    }

    public void getCambiaClub(Object gerente, Object club) 
    {
        //Actualizamos el club que se ha cambiado el gerente
        ((DatosGerente) gerente).getClubActual().setGerente(null);
        //Añadimso el nuevo club al historial
        ((DatosGerente) gerente).actHistClub((DatosClub) club);
        //Asignamos al gerente el club al que se ha cambiado
        ((DatosGerente) gerente).setClubActual((DatosClub) club);
        //Asignamos al club el nuevo gerente
        ((DatosClub) club).setGerente((DatosGerente) gerente);
    }
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
        datosTorneo.jugadores(datosJugador.getDatosJugador());
    }
    public ArrayList<String> getJugadores()
    {
        return datosTorneo.getJugadores();
    }

    public void guardarEntrenador(String nombre, String ap1, String ap2, String sexo, String edad) {
        datosEntrenador.guardarDatosEntrenador(nombre, ap1, ap2, sexo, edad);
    }

    public boolean entrenadorRepe(String nombre, String ap1, String ap2) {
        boolean repe = false;
        for(DatosEntrenador i:datosEntrenador.getEntrenadores())
        {
            if(i.getnCompelot() == nombre+" "+ap1+" "+ap2)
                repe = true;
        }
        return repe;
    }
}
