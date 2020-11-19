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
public class DatosClub {
    
    
    ArrayList<DatosClub> clubes;
    
    //Declaracion de datos
    private String nombre;
    private String sede;
    private String federacion;

    public DatosClub() {}

    @Override
    public String toString() {
        return nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<DatosClub> getClubes() {
        return clubes;
    }

    public void setClubes(ArrayList<DatosClub> clubes) {
        this.clubes = clubes;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getFederacion() {
        return federacion;
    }

    public void setFederacion(String federacion) {
        this.federacion = federacion;
    }
    

    
    
    public ArrayList<DatosClub> getClubs()
    {
        return clubes;
    }
    
        public void cargarDatosClub()
    {
        try {
            clubes = new ArrayList();
            FileReader leer = new FileReader("ficheros/Clubs.txt");
            BufferedReader datosJug = new BufferedReader(leer);
            String dato;
            
            while((dato = datosJug.readLine()) != null)
            {
                DatosClub nuevoClub = new DatosClub();
                nuevoClub.nombre = dato;
                dato = datosJug.readLine();
                
                nuevoClub.sede = dato;
                dato = datosJug.readLine();

                nuevoClub.federacion = dato;
                
                clubes.add(nuevoClub);
            }
        } catch (IOException ex) {
            System.err.println("No se ha encontrado el fichero Gerentes.txt");
        }

    }
    
    public void guardarDatosClub(String nombre, String sede, String federacion)
   {
        FileWriter fichero = null;
        PrintWriter p = null;
        try
        {   
            fichero = new FileWriter("ficheros/Clubs.txt",true);
            p = new PrintWriter(fichero);

            p.println(nombre);
            p.println(sede); 
            p.println(federacion);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
   }

    
    
}
