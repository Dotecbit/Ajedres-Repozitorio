/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import model.DatosEntrenador;
import model.DatosGerente;
import model.DatosJugador;

/**
 *
 * @author alumno
 */
public class Persona 
{
    
    protected String nombre, apellidos;
    
    public Persona()
    {}
    
    public Persona crearPersona(int num)
    {
        Persona persona = new Persona();
        
        switch(num)
        {
            case 1:
                    DatosJugador jugador = new DatosJugador();
                    persona = jugador;
                    break;
                
            case 2:
                    DatosGerente gerente = new DatosGerente();
                    persona = gerente;
                    break;
            
            case 3:
                    DatosEntrenador entrenador = new DatosEntrenador();
                    persona = entrenador;
                    break; 
        }
        return persona; 
    }
}
