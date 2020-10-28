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
public class DatosGerente {
    ArrayList<DatosGerente> gerentes;
    private String nombre, apellidos, sexo, nCompleto;
    private int  edad;
    private Float nomina;
    private Float IRPF;
    private ArrayList<DatosClub> histClub;
    private ArrayList<Float> histNom, histIRPF;
    private DatosClub clubActual = null;

    @Override
    public String toString() {
        return nCompleto;
    }

    public DatosGerente(String nombre, String apellidos, int edad, String sexo, Float nomina, Float IRPF, ArrayList<DatosClub> histClub, ArrayList<Float> histNom, ArrayList<Float> histIRPF) {
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

    public void setGerentes(DatosGerente gerente) {
        gerentes.add(gerente);
    }
    
    public ArrayList<DatosGerente> getGerentes() {
        return gerentes;
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

    public ArrayList<DatosClub> getHistClub() {
        return histClub;
    }

    public void actHistClub(DatosClub newClub) {
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

    public DatosClub getClubActual() {
        return clubActual;
    }

    public void setClubActual(DatosClub clubActual) {
        this.clubActual = clubActual;
    }
    
        public ArrayList<String> getGerentesLibres()
    {
        ArrayList<String> gerentesLibres = null;
        for(int i = 0; i < gerentes.size(); i++)
            if(gerentes.get(i).getClubActual() == null)
                gerentesLibres.add(gerentes.get(i).getnCompleto());
        return gerentesLibres;
    }
    
    public void crearGerentePrueba()
    {
        gerentes.add(new DatosGerente("Pepe","Media Villa",55,"H", Float.parseFloat("2500.0"), Float.parseFloat("0.5"), null, null, null));
    }
    
}
