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
public class Club {
    
    //Declaracion de datos
    private ArrayList<Jugador> jugadores;
    private ArrayList<String> sedes;
    private Gerente gerente;
    private Entrenador entrenador;
    private String federación;

    public Club(ArrayList<Jugador> jugadores, ArrayList<String> sedes, Gerente gerente, Entrenador entrenador, String federación) {
        this.jugadores = jugadores;
        this.sedes = sedes;
        this.gerente = gerente;
        this.entrenador = entrenador;
        this.federación = federación;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public ArrayList<String> getSedes() {
        return sedes;
    }

    public void setSedes(ArrayList<String> sedes) {
        this.sedes = sedes;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public String getFederación() {
        return federación;
    }

    public void setFederación(String federación) {
        this.federación = federación;
    }
    
    
    
}
