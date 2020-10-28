/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import model.AppAjedrez;
import model.Club;
import model.Gerente;

/**
 *
 * @author areba
 */
public class Administrador {
    AppAjedrez appAjedrez;

    public Administrador(AppAjedrez appAjedrez) {
        this.appAjedrez = appAjedrez;
        appAjedrez.crearGerentePrueba();
    }
    
    public ArrayList<Gerente> getGerentes()
    {
        return appAjedrez.getGerentes();
    }
    
    public ArrayList<String> getGerentesLibres()
    {
        return appAjedrez.getGerentesLibres();
    }
    
    public void crearClub(String nombre, String sede, String gerente) {
        appAjedrez.crearClub(nombre, sede, gerente);
    }
    
    public ArrayList<Club> getClubs()
    {
        return appAjedrez.getClubs();
    }

    public void gerCambiaClub(Object gerente, Object club) 
    {
        //Actualizamos el club que se ha cambiado el gerente
        ((Gerente) gerente).getClubActual().setGerente(null);
        //Añadimso el nuevo club al historial
        ((Gerente) gerente).actHistClub((Club) club);
        //Asignamos al gerente el club al que se ha cambiado
        ((Gerente) gerente).setClubActual((Club) club);
        //Asignamos al club el nuevo gerente
        ((Club) club).setGerente((Gerente) gerente);
    }
}
