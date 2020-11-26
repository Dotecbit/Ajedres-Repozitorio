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
    public DatosTorneo()
    {}
    
    public boolean comprobarTorneo(String nombreTorneo, ArrayList<String> torneos)
    {
        boolean ok = false;
        int i = 0;
        while(i < torneos.size() && !ok)
        {
            if(torneos.get(i).equals(nombreTorneo))
                ok = true;
            
            i++;
        }
        
        return ok;
    }
    

}
