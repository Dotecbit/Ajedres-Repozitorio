/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Ayoub El Moussaoui
 */
public class DatosJugador {
    
    public DatosJugador()
    {}
    
    public boolean edadJugador(Date fecha)
    {
        boolean ok = true;
        int difAño, difMes, difDia;
        
        Calendar hoy = Calendar.getInstance();
        Calendar fechaN = Calendar.getInstance();
        fechaN.setTime(fecha);
        
        difAño = hoy.get(Calendar.YEAR) - fechaN.get(Calendar.YEAR);
        difMes = hoy.get(Calendar.MONTH) - fechaN.get(Calendar.MONTH);
        difDia = hoy.get(Calendar.DAY_OF_MONTH) - fechaN.get(Calendar.DAY_OF_MONTH);
        
        if (difMes < 0 || (difMes == 0 && difDia < 0)) 
            difAño = difAño - 1;
        
        if(difAño < 18)
            ok = false;
        
        System.err.println(ok);
        
        return ok;
    }
    
   public void guardarDatosJugador(String nombre, String apellido, String usuario,
                String correo, Date fecha, String contraseña)
   {
        FileWriter fichero = null;
        PrintWriter p = null;
        try
        {   
            fichero = new FileWriter(".src/ficheros/Jugadores.txt",true);
            p = new PrintWriter(fichero);

                p.println(nombre);
                p.println(apellido); 
                p.println(usuario); 
                p.println(correo); 
                p.println(fecha);
                p.println(contraseña);  

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
    public void guardarDatosResponsable(String usuario, String nombre, String apellido,
                String correo, Date fecha)
   {
        FileWriter fichero = null;
        PrintWriter p = null;
        try
        {   
            fichero = new FileWriter("/ficheros/responsablesInfantiles.txt",true);
            p = new PrintWriter(fichero);

                p.println(usuario);
                p.println(nombre); 
                p.println(apellido); 
                p.println(correo); 
                p.println(fecha);

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
