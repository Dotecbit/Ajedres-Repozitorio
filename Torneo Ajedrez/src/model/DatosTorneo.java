/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Ayoub El Moussaoui
 */
public class DatosTorneo 
{
    ArrayList<String> sedes = new ArrayList<>();
    ArrayList<String> jugadores = new ArrayList<>();
    public DatosTorneo()
    {}
    
    public void CargarSedes()
    {
        try {
            FileReader leer = new FileReader("ficheros/Sedes.txt");
            BufferedReader datosJug = new BufferedReader(leer);
            String sede;
            while((sede = datosJug.readLine()) != null)
                sedes.add(sede);
            
        } catch (IOException ex) {
            System.err.println("No se ha encontrado el fichero Jugador.txt");
        }
        
    }
    
    public ArrayList<String> getSedes()
    {
        return sedes;
    }
    public void jugadores(ArrayList<DatosJugador> datosJugadores)
    {
        for(int i = 0; i < datosJugadores.size(); i++)
            jugadores.add(datosJugadores.get(i).getUsuario());
        System.err.println(jugadores.size());
    }
    public ArrayList<String> getJugadores()
    {
        return jugadores;
    }
}
