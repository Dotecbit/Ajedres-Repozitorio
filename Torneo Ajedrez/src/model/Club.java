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
    private String nombre;
    private ArrayList<Jugador> jugadores;
    private ArrayList<String> sedes;
    private Gerente gerente;
    private Entrenador entrenador;

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

    public Club(String nombre, ArrayList<Jugador> jugadores, String sede,Gerente gerente, Entrenador entrenador, String federación) {
        this.nombre = nombre;
        this.jugadores = jugadores;
        this.sedes.add(sede);
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
