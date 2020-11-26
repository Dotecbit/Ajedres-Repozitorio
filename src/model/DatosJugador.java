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
   
}
