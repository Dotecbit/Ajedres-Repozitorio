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

public class DatosEntrenador {
    private ArrayList<DatosEntrenador> entrenadores = new ArrayList();
    private String nombre, apeilldos, sexo, nCompelot;
    int    edad;

    public DatosEntrenador() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApeilldos() {
        return apeilldos;
    }

    public void setApeilldos(String apeilldos) {
        this.apeilldos = apeilldos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getnCompelot() {
        return nCompelot;
    }

    public void setnCompelot(String nCompelot) {
        this.nCompelot = nCompelot;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    public void cargarDatosEntrenadores() {
        try {
            FileReader leer = new FileReader("ficheros/Entrenadores.txt");
            BufferedReader datosJug = new BufferedReader(leer);
            String dato;
            
            while((dato = datosJug.readLine()) != null)
            {
                nombre = dato;
                dato = datosJug.readLine();
                
                apeilldos = dato;
                dato = datosJug.readLine();
                
                sexo = dato;
                dato = datosJug.readLine();
                
                edad = Integer.parseInt(dato);
                dato = datosJug.readLine();
                
                nCompelot = dato;
                dato = datosJug.readLine();
                
                entrenadores.add(this);
            }
        } catch (IOException ex) {
            System.err.println("No se ha encontrado el fichero Gerentes.txt");
        }

    }
    
    public void guardarDatosEntrenador(String nombre, String ap1, String ap2, String sexo, String edad)
   {
        FileWriter fichero = null;
        PrintWriter p = null;
        try
        {   
            fichero = new FileWriter("ficheros/Entrenadores.txt",true);
            p = new PrintWriter(fichero);

                p.println(nombre);
                p.println(ap1+" "+ap2); 
                p.println(sexo); 
                p.println(edad); 
                p.println(nombre+" "+ap1+" "+ap2);

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

    public ArrayList<DatosEntrenador> getEntrenadores() {
        return entrenadores;
    }


    
}
