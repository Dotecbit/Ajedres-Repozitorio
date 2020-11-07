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
    private ArrayList<DatosJugador> jugadores;
    private String sede;
    private DatosGerente gerente;
    private DatosEntrenador entrenador;
    private String federacion;

    public DatosClub() {
//        cargarDatosClub();
    }
    
    

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
    
    public ArrayList<DatosJugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<DatosJugador> jugadores) {
        this.jugadores = jugadores;
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
            FileReader leer = new FileReader("ficheros/Gerentes.txt");
            BufferedReader datosJug = new BufferedReader(leer);
            String dato;
            
            while((dato = datosJug.readLine()) != null)
            {
                nombre = dato;
                dato = datosJug.readLine();
                
                sede = dato;
                dato = datosJug.readLine();
                
                DatosGerente gerente = new DatosGerente();
                for(DatosGerente g:gerente.getGerentes())
                {
                    if(g.getnCompleto() == dato)
                        setGerente(g);
                }
                
                if(dato == "null")
                    setEntrenador(null);
//                else
//                DatosEntrenador entrenador = new DatosEntrenador();
//                for(DatosGerente e:entrenador())
//                {
//                    if(e.getnCompleto() == dato)
//                        setEntrenador(e);
//                }
                
                federacion = dato;
                dato = datosJug.readLine();
                
                clubes.add(this);
            }
        } catch (IOException ex) {
            System.err.println("No se ha encontrado el fichero Gerentes.txt");
        }

    }
    
    public void guardarDatosClub(String nombre, String sede, DatosGerente g,
    DatosEntrenador e, String federacion)
   {
        FileWriter fichero = null;
        PrintWriter p = null;
        try
        {   
            fichero = new FileWriter("ficheros/Gerentes.txt",true);
            p = new PrintWriter(fichero);

                p.println(nombre);
                p.println(sede); 
                p.println(g.getnCompleto()); 
                //Si no tiene se guarda "null"
//                p.println(e.getnCompleto()); 
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
