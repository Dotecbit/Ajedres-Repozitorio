/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Ayoub El Moussaoui
 */
public class DatosTorneo 
{
    ArrayList<String> sedes;
    ArrayList<String> jugadores = new ArrayList<>();
    public DatosTorneo()
    {}
    
    public void CargarSedes()
    {
        try {
            sedes = new ArrayList();
            FileReader leer = new FileReader("ficheros/SedesDisponibles.txt");
            BufferedReader datosJug = new BufferedReader(leer);
            String sede;
            while((sede = datosJug.readLine()) != null)
                sedes.add(sede);
            
        } catch (IOException ex) {
            System.err.println("No se ha encontrado el fichero Jugador.txt");
        }
    }
    public void GuardarTorneo(String nombre, ArrayList<String> usuario, ArrayList<String> sede)
    {
        FileWriter fichero = null;
        PrintWriter p = null;
        try
        {   
            fichero = new FileWriter(new File("ficheros/Torneos.txt"), true);
            p = new PrintWriter(fichero);

                p.println(nombre);
                for(int i = 0; i < usuario.size(); i++)
                    p.println(usuario.get(i));
                p.println("SEDE");
                for(int i = 0; i < sede.size(); i++)
                    p.println(sede.get(i));
                p.println("FIN");

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
    public void GuardarSedes(ArrayList<String> sede)
    {;}
    
    public ArrayList<String> getSedes()
    {
        return sedes;
    }
    public void jugadores(ArrayList<DatosJugador> datosJugadores)
    {
        for(int i = 0; i < datosJugadores.size(); i++)
        {
            if(datosJugadores.get(i).getClub().equals("null"))
                jugadores.add(datosJugadores.get(i).getUsuario());
        }  
    }
    public ArrayList<String> getJugadores()
    {
        return jugadores;
    }

}
