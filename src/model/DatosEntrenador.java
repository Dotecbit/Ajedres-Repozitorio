/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Factory.Persona;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DatosEntrenador extends Persona{
    private ArrayList<DatosEntrenador> entrenador = new ArrayList();
    private String sexo, nCompleto, club;
    int edad;

    public DatosEntrenador() {
    }

    public DatosEntrenador(String nombre, String ap1, String ap2, String sexo, int edad) {
        this.sexo = sexo;
        this.nCompleto = nombre+" "+ap1+" "+ap2;
        this.edad = edad;
        super.apellidos= ap1+" "+ap2;
        super.nombre=nombre;
    }

    

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }
    
    @Override
    public String toString() {
        return nCompleto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        super.nombre = nombre;
    }

    public String getApellidos() {
        return super.apellidos;
    }

    public void setApeilldos(String apeilldos) {
        super.apellidos = apeilldos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getnCompleto() {
        return nCompleto;
    }

    public void setnCompleto(String nCompleto) {
        this.nCompleto = nCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    public void cargarDatosEntrenadores() {
        try {
            
            entrenador = new ArrayList();
            FileReader leer = new FileReader("ficheros/Entrenadores.txt");
            BufferedReader datosJug = new BufferedReader(leer);
            String dato;
            
            while((dato = datosJug.readLine()) != null)
            {
                Persona persona = new Persona();
                DatosEntrenador nuevoEntrenador = (DatosEntrenador) persona.crearPersona(3);
                nuevoEntrenador.nombre = dato;
                dato = datosJug.readLine();
                
                nuevoEntrenador.apellidos = dato;
                dato = datosJug.readLine();
                
                nuevoEntrenador.sexo = dato;
                dato = datosJug.readLine();
                
                nuevoEntrenador.edad = Integer.parseInt(dato);
                dato = datosJug.readLine();
                
                nuevoEntrenador.nCompleto = dato;
                dato = datosJug.readLine();
                                
                nuevoEntrenador.club = dato;
                
                entrenador.add(nuevoEntrenador);
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
                p.println(club);

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
        return entrenador;
    }


    
}
