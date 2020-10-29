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

    private DatosGerente gerente; 
    private DatosJugador jugador;
    private DatosClub club;
    private DatosEntrenador entrenador;
    private DatosTorneo datosTorneo;
    public Administrador() 
    {
        datosTorneo = new DatosTorneo();
        jugador = new DatosJugador();
        jugador.CargarDatosJugador();
    }
   
    public ArrayList<DatosGerente> getGerentes()
    {
        return gerente.getGerentes();
    }
    
    public ArrayList<String> getGerentesLibres()
    {
        return gerente.getGerentesLibres();
    }
    
    public void crearClub(String nombre, String sede, Object gerente) {
        club.crearClub(nombre, sede,(DatosGerente) gerente);
    }
    
    public ArrayList<DatosClub> getClubs()
    {
        return club.getClubs();
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
        datosTorneo.jugadores(jugador.getDatosJugador());
    }
    public ArrayList<String> getJugadores()
    {
        return datosTorneo.getJugadores();
    }
}
