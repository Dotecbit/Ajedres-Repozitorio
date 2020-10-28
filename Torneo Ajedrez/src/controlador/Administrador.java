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

/**
 *
 * @author areba
 */
public class Administrador {

    private  DatosGerente gerente; 
    private DatosJugador jugador;
    private DatosClub club;
    private DatosEntrenador entrenador;

    public Administrador(DatosGerente gerente, DatosJugador jugador, DatosClub club, DatosEntrenador entrenador) {
        this.gerente = gerente;
        this.jugador = jugador;
        this.club = club;
        this.entrenador = entrenador;
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
}
