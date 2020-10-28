/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author areba
 */
public class DatosClub {
    
    
    ArrayList<DatosClub> clubes;
    
    //Declaracion de datos
    private String nombre;
    private ArrayList<DatosJugador> jugadores;
    private ArrayList<String> sedes;
    private DatosGerente gerente;
    private DatosEntrenador entrenador;

    @Override
    public String toString() {
        return nombre;
    }
    private String federación;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DatosClub(String nombre, ArrayList<DatosJugador> jugadores, String sede,DatosGerente gerente, DatosEntrenador entrenador, String federación) {
        this.nombre = nombre;
        this.jugadores = jugadores;
        this.sedes.add(sede);
        this.gerente = gerente;
        this.entrenador = entrenador;
        this.federación = federación;
    }

    public ArrayList<DatosJugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<DatosJugador> jugadores) {
        this.jugadores = jugadores;
    }

    public ArrayList<String> getSedes() {
        return sedes;
    }

    public void setSedes(ArrayList<String> sedes) {
        this.sedes = sedes;
    }

    public DatosGerente getGerente() {
        return gerente;
    }

    public void setGerente(DatosGerente gerente) {
        this.gerente = gerente;
    }

    public DatosEntrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(DatosEntrenador entrenador) {
        this.entrenador = entrenador;
    }

    public String getFederación() {
        return federación;
    }

    public void setFederación(String federación) {
        this.federación = federación;
    }
    
    
    public ArrayList<DatosClub> getClubs()
    {
        return clubes;
    }
    

    public void crearClub(String nombre, String sede, DatosGerente gerente) 
    {
        DatosClub newClub = null;
       
        clubes.add(newClub = new DatosClub(nombre,null,sede,gerente,null,null));
        gerente.setClubActual(newClub);
       
        System.out.println("Club creado: " + newClub.toString());
    }

    
    
}
