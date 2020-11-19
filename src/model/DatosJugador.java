/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Factory.Persona;
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
public class DatosJugador extends Persona{
    private ArrayList<DatosJugador> jugador = new ArrayList<>();
    private ArrayList<String> responsableInfantil = new ArrayList<>();


    private String  usuario, correo, contraseña;
    private String fechaNacimiento, club, elo, categoria;
    
    @Override
    public String toString() {
        return nombre+" "+apellidos;
    }

    public String getElo() {
        return elo;
    }

    public void setElo(String elo) {
        this.elo = elo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }
    public DatosJugador()
    {
        super();
    }
    public DatosJugador(String nombre, String apellido, String usuario, String correo, 
            String contraseña, String fechaNacimiento, String club, String categoria, String elo) 
    {
        this.nombre = nombre;
        this.apellidos = apellido;
        this.usuario = usuario;
        this.correo = correo;
        this.contraseña = contraseña;
        this.fechaNacimiento = fechaNacimiento;
        this.club = club;
        this.categoria = categoria;
        this.elo = elo;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellidos;
    }

    public void setApellido(String apellido) {
        this.apellidos = apellido;
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
    

    public int edadJugador(Date fecha)
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
        
        return difAño;
    }
    
   public void guardarDatosJugador(String nombre, String apellido, String usuario,
                String correo, String fecha, String contraseña, String club, String categoria, String elo)
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
                p.println(club);
                p.println(categoria);
                p.println(elo);

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
            jugador = new ArrayList();
            FileReader leer = new FileReader("ficheros/Jugadores.txt");
            BufferedReader datosJug = new BufferedReader(leer);
            String dato;
            
            while((dato = datosJug.readLine()) != null)
            {
                Persona persona = new Persona();
                DatosJugador datosJugador = (DatosJugador) persona.crearPersona(1);
                datosJugador.setNombre(dato);
                dato = datosJug.readLine();
                datosJugador.setApellido(dato);
                dato = datosJug.readLine();
                datosJugador.setUsuario(dato);
                dato = datosJug.readLine();
                datosJugador.setCorreo(dato);
                dato = datosJug.readLine();
                datosJugador.setFechaNacimiento(dato);
                dato = datosJug.readLine();
                datosJugador.setContraseña(dato);
                dato = datosJug.readLine();
                datosJugador.setClub(dato);
                dato = datosJug.readLine();
                datosJugador.setCategoria(dato);
                dato = datosJug.readLine();
                datosJugador.setElo(dato);
                
                jugador.add(datosJugador);
            }
        } catch (IOException ex) {
            System.err.println("No se ha encontrado el fichero Jugador.txt");
        }

    }
    public void CargarDatosResponsable()
    {
        try {
            FileReader leer = new FileReader("ficheros/responsablesInfantiles.txt");
            BufferedReader datosJug = new BufferedReader(leer);
            String dato;
            
            while((dato = datosJug.readLine()) != null)
                responsableInfantil.add(dato);
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
    
    public void añadirUsuario(String nombre, String apellido, String usuario, String correo, String contraseña, String fechaNacimiento, 
            String club, String categoria, String elo)
    {
        DatosJugador datosJugador = null;
        
        jugador.add(datosJugador = new DatosJugador(nombre, apellido, usuario, correo, contraseña, fechaNacimiento, club, categoria, elo));
        
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

    public ArrayList<String> datosTarjeta(String usuarioJugador)
    {
        ArrayList<String> tarjeta = new ArrayList<>();
        boolean ok = false;
        int i = 0;
        while(i < jugador.size() && !ok)
        {
            if(jugador.get(i).getUsuario().equals(usuarioJugador))
            {
                tarjeta.add(jugador.get(i).getNombre());
                tarjeta.add(jugador.get(i).getFechaNacimiento());
                tarjeta.add(jugador.get(i).getApellido());
                tarjeta.add(jugador.get(i).getCategoria());
                tarjeta.add(jugador.get(i).getElo());
                ok = true;
            }
            i++;
        }
        return tarjeta;
    }
    public void darDeBaja(String usuarioJugador) throws IOException
    {

        boolean ok = false, responsable = false;
        int i = 0;
        
        while(i < jugador.size() && !ok)
        {
            if(jugador.get(i).getUsuario().equals(usuarioJugador))
            {
                if(jugador.get(i).getCategoria().equals("Infantil"))
                    responsable = true;
                jugador.remove(i);
                ok = true;
            }
            i++;
        }
        if(ok)
            actualizarDatosJugador();
        if(responsable)
        {
            i = 0;
            ok = false;
            
            while(i < responsableInfantil.size() && !ok)
            {
                if(responsableInfantil.get(i).equals(usuarioJugador))
                {
                    responsableInfantil.remove(i);
                    responsableInfantil.remove(i);
                    responsableInfantil.remove(i);
                    responsableInfantil.remove(i);
                    responsableInfantil.remove(i);
                    
                    ok = true;
                }
            }   
        }
    }
    public void actualizarDatosJugador()
    {
        FileWriter fichero = null;
        PrintWriter bufferEscritura;
        try
        {
            
            fichero = new FileWriter(new File("ficheros/Jugadores.txt"), true);
            bufferEscritura = new PrintWriter(fichero);
                
            for(int i = 0; i < jugador.size(); i++)
            {
                bufferEscritura.println(jugador.get(i).getNombre());
                bufferEscritura.println(jugador.get(i).getApellido());
                bufferEscritura.println(jugador.get(i).getUsuario());
                bufferEscritura.println(jugador.get(i).getCorreo());
                bufferEscritura.println(jugador.get(i).getFechaNacimiento());
                bufferEscritura.println(jugador.get(i).getContraseña());
                bufferEscritura.println(jugador.get(i).getClub());
                bufferEscritura.println(jugador.get(i).getCategoria());
                bufferEscritura.println(jugador.get(i).getElo());
            }  
        }        
        catch (IOException ex) 
        {        
            System.err.println(ex);
        }        
    }
}
