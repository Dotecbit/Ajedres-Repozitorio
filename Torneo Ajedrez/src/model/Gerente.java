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
public class Gerente {
    private String nombre, apellidos, sexo, nCompleto;
    private int  edad;
    private Float nomina;
    private Float IRPF;
    private ArrayList<Club> histClub;
    private ArrayList<Float> histNom, histIRPF;
    private Club clubActual = null;

    @Override
    public String toString() {
        return nCompleto;
    }

    public Gerente(String nombre, String apellidos, int edad, String sexo, Float nomina, Float IRPF, ArrayList<Club> histClub, ArrayList<Float> histNom, ArrayList<Float> histIRPF) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.sexo = sexo;
        this.nomina = nomina;
        this.IRPF = IRPF;
        this.histClub = histClub;
        this.histNom = histNom;
        this.histIRPF = histIRPF;
        nCompleto= nombre + " " + apellidos;
    }

    public String getnCompleto() {
        return nCompleto;
    }

    public void setnCompleto(String nCompleto) {
        this.nCompleto = nCompleto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Float getNomina() {
        return nomina;
    }

    public void setNomina(Float nomina) {
        this.nomina = nomina;
    }

    public Float getIRPF() {
        return IRPF;
    }

    public void setIRPF(Float IRPF) {
        this.IRPF = IRPF;
    }

    public ArrayList<Club> getHistClub() {
        return histClub;
    }

    public void actHistClub(Club newClub) {
        this.histClub.add(newClub);
    }

    public ArrayList<Float> getHistNom() {
        return histNom;
    }

    public void setHistNom(ArrayList<Float> histNom) {
        this.histNom = histNom;
    }

    public ArrayList<Float> getHistIRPF() {
        return histIRPF;
    }

    public void setHistIRPF(ArrayList<Float> histIRPF) {
        this.histIRPF = histIRPF;
    }

    public Club getClubActual() {
        return clubActual;
    }

    public void setClubActual(Club clubActual) {
        this.clubActual = clubActual;
    }
    
    
}
