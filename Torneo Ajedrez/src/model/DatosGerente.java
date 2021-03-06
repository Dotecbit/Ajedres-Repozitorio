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
    ArrayList<DatosGerente> gerentes;
    private String nombre, apellidos, sexo, nCompleto;
    private int  edad;
    private Float nomina;
    private Float IRPF;
    private ArrayList<String> histClub;
    private ArrayList<Float> histNom, histIRPF;
    private String clubActual;

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
        this.histNom = histNom;
        this.histIRPF = histIRPF;
        nCompleto= nombre + " " + apellidos;
    }

    public ArrayList<String> getHistClub() {
        return histClub;
    }

    public void setHistClub(ArrayList<String> histClub) {
        this.histClub = histClub;
    }

    public String getClubActual() {
        return clubActual;
    }

    public void setClubActual(String clubActual) {
        this.clubActual = clubActual;
    }

    public void setGerentes( ArrayList<DatosGerente> gerente) {
        gerentes = gerente;
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
    
        public ArrayList<DatosGerente> getGerentesLibres()
    {
        ArrayList<DatosGerente> gerentesLibres = new ArrayList();
        for(DatosGerente i:gerentes)
            if(i.getClubActual().equals("null"))
                gerentesLibres.add(i);
        return gerentesLibres;
    }
        
    public void cargarDatosGerente()
    {
        try {
            gerentes = new ArrayList();
            FileReader leer = new FileReader("ficheros/Gerentes.txt");
            BufferedReader datosJug = new BufferedReader(leer);
            String dato;
            
            while((dato = datosJug.readLine()) != null)
            {
                DatosGerente nuevoGerente = new DatosGerente();
                nuevoGerente.setNombre(dato);
                dato = datosJug.readLine();
                
                nuevoGerente.setApellidos(dato);
                dato = datosJug.readLine();
                
                nuevoGerente.setSexo(dato);
                dato = datosJug.readLine();
                
                nuevoGerente.setnCompleto(dato);
                dato = datosJug.readLine();
                
                nuevoGerente.setEdad(Integer.parseInt(dato));
                dato = datosJug.readLine();
                
                nuevoGerente.setNomina(Float.parseFloat(dato));
                dato = datosJug.readLine();

                nuevoGerente.setIRPF(Float.parseFloat(dato));
                dato = datosJug.readLine();
                
                nuevoGerente.setClubActual(dato);
                
                gerentes.add(nuevoGerente);
            }
        } catch (IOException ex) {
            System.err.println("No se ha encontrado el fichero Gerentes.txt");
        }

    }
    
    public void guardarDatosGerenteActuales()
   {
        FileWriter fichero = null;
        PrintWriter p = null;
        try
        {   
            fichero = new FileWriter("ficheros/Gerentes.txt");
            p = new PrintWriter(fichero);
            for(DatosGerente i:gerentes)
            {
                p.println(i.nombre);
                p.println(i.apellidos); 
                p.println(i.sexo);
                p.println(i.nombre+" "+i.apellidos);
                p.println(i.edad); 
                p.println(i.nomina);
                p.println(i.IRPF); 
                //Si no hay club actual, clubActual = "null"
                p.println(i.clubActual);
            }

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
                p.println(nombre+" "+apellidos);
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
