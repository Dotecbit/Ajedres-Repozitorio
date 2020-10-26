/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
        
        return ok;
    }
}
