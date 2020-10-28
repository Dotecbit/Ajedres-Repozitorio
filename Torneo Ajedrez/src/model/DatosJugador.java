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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Ayoub El Moussaoui
 */
public class DatosJugador{
    private ArrayList<DatosJugador> jugador = new ArrayList<>();
    private String nombre, apellido, usuario, correo, contraseña;
    private String fechaNacimiento;
    
    public DatosJugador(String nombre, String apellido, String usuario, String correo, String contraseña, String fechaNacimiento) 
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.correo = correo;
        this.contraseña = contraseña;
        this.fechaNacimiento = fechaNacimiento;
    }
 
    public DatosJugador()
    {}
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    

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
        
        System.out.println(ok);
        
        return ok;
    }
    
   public void guardarDatosJugador(String nombre, String apellido, String usuario,
                String correo, String fecha, String contraseña)
   {
        FileWriter fichero = null;
        PrintWriter p = null;
        try
        {   
            fichero = new FileWriter(new File("ficheros/Jugadores.txt"), true);
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
                String correo, String fecha)
   {
        FileWriter fichero = null;
        PrintWriter p = null;
        try
        {   
            fichero = new FileWriter("ficheros/responsablesInfantiles.txt",true);
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
    public void CargarDatosJugador()
    {
        try {
            FileReader leer = new FileReader("ficheros/Jugadores.txt");
            BufferedReader datosJug = new BufferedReader(leer);
            String dato;
            
            while((dato = datosJug.readLine()) != null)
            {
                setNombre(dato);
                dato = datosJug.readLine();
                setApellido(dato);
                dato = datosJug.readLine();
                setUsuario(dato);
                dato = datosJug.readLine();
                setCorreo(dato);
                dato = datosJug.readLine();
                setFechaNacimiento(dato);
                dato = datosJug.readLine();
                setContraseña(dato);
                //System.out.println("Hola");
                jugador.add(this);
            }
        } catch (IOException ex) {
            System.err.println("No se ha encontrado el fichero Jugador.txt");
        }

    }
    public boolean validarUsuario(String usuario)
    {
        boolean ok = false;
        int i = 0;
        
        while(i < jugador.size() && !ok)
        {
            if(jugador.get(i).getUsuario().equals(usuario))
                ok = true;
            i++;
        }
        
        return ok;
    }
    
    public void añadirUsuario(String nombre, String apellido, String usuario, String correo, String contraseña, String fechaNacimiento)
    {
        DatosJugador datosJugador = null;
        
        jugador.add(datosJugador = new DatosJugador(nombre, apellido, usuario, correo, contraseña, fechaNacimiento));
        
    }
    
    public boolean validarCuenta(String usuario, String contraseña)
    {
        boolean ok = false;
        int i = 0;
        
        while(i < jugador.size() && !ok)
        {
            if(jugador.get(i).getUsuario().equals(usuario) && jugador.get(i).getContraseña().equals(contraseña))
                ok = true;
            i++;
        }        
        return ok;
    }
    public ArrayList<DatosJugador> getDatosJugador()
    {
        return jugador;
    }
}
