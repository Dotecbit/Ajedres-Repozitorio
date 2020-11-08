/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author areba
 */
public class DatosGerente {
    ArrayList<DatosGerente> gerentes = new ArrayList();
    private String nombre, apellidos, sexo, nCompleto;
    private int  edad;
    private Float nomina;
    private Float IRPF;
    private ArrayList<DatosClub> histClub;
    private ArrayList<Float> histNom, histIRPF;
    private DatosClub clubActual;

    @Override
    public String toString() {
        return nCompleto;
    }

    public DatosGerente() {}
    

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
        
    public void cargarDatosGerente()
    {
        try {
            FileReader leer = new FileReader("ficheros/Gerentes.txt");
            BufferedReader datosJug = new BufferedReader(leer);
            String dato;
            
            while((dato = datosJug.readLine()) != null)
            {
                setNombre(dato);
                dato = datosJug.readLine();
                
                setApellidos(dato);
                dato = datosJug.readLine();
                
                setSexo(dato);
                dato = datosJug.readLine();
                
                setnCompleto(dato);
                dato = datosJug.readLine();
                
                setEdad(Integer.parseInt(dato));
                dato = datosJug.readLine();
                
                setNomina(Float.parseFloat(dato));
                dato = datosJug.readLine();

                setIRPF(Float.parseFloat(dato));
                dato = datosJug.readLine();
                
                //Si no existe club, es nulo
                if(dato == "null")
                    setClubActual(null);
                //Si existe buscamos su nombre en los clubes y lo añadimos
                else
                {
                    DatosClub Clubs = new DatosClub();
                    for(DatosClub club:Clubs.getClubs())
                    {
                        if(club.getNombre() == dato)
                            setClubActual(club);
                    }
                }
                
                gerentes.add(this);
            }
        } catch (IOException ex) {
            System.err.println("No se ha encontrado el fichero Gerentes.txt");
        }

    }
    
    public void guardarDatosGerente(String nombre, String apellidos, String sexo,
    int edad, float nomina, float IRPF, String clubActual)
   {
        FileWriter fichero = null;
        PrintWriter p = null;
        try
        {   
            fichero = new FileWriter("ficheros/Gerentes.txt",true);
            p = new PrintWriter(fichero);

                p.println(nombre);
                p.println(apellidos); 
                p.println(sexo); 
                p.println(edad); 
                p.println(nomina);
                p.println(IRPF); 
                //Si no hay club actual, clubActual = "null"
                p.println(clubActual);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
   }
    
}
