/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author 34677
 */
public class DatosJugadorDAO 
{
    private Connection conexionBD;
    private PreparedStatement prep;
    
    public DatosJugadorDAO()
    {
    }
    
    public boolean comprobarUsuario(String usuarioNuevo)
    {
        String bd = "jdbc:mysql://localhost/MySQL?serverTimezone=" + TimeZone.getDefault().getID();
        try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver de m ysql
        // Conexión usando usuario y clave de administrador de la BD
        conexionBD = DriverManager.getConnection(bd, "root", "Dddedo");
        } catch (Exception e) { // Error en la conexión con la BD
        System.out.println(e);
        }
        boolean ok = false;
        ResultSet resultados = null;
        try {
            String con;
            Statement s = conexionBD.createStatement();
            // Consulta SQL
            con = "SELECT usuario FROM ajdrez.jugador " +
                    "WHERE usuario = usuarioNuevo";
            resultados = s.executeQuery(con);
            while (resultados.next() && !ok) 
            {
                String id = resultados.getString("usuario");
                ok = true;
                System.out.print(id);
            }
            conexionBD.close();
        } catch (Exception e) { // Error al realizar la consulta
            System.err.println(e);
        }
        return ok;
    }
    
    public void agregarUsuario(String nombre, String apellido, String usuario, String correo, String contraseña, 
            String fechaNacimiento, String club, String categoria, String elo)
    {
        String bd = "jdbc:mysql://localhost/MySQL?serverTimezone=" + TimeZone.getDefault().getID();
        try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver de m ysql
        // Conexión usando usuario y clave de administrador de la BD
        conexionBD = DriverManager.getConnection(bd, "root", "Dddedo");
        } catch (Exception e) { // Error en la conexión con la BD
        System.out.println(e);
        }
        ResultSet resultados = null;
        try {
            
            String con;
            Statement s = conexionBD.createStatement();
            // Consulta SQL
            con =   "INSERT INTO ajdrez.jugador VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
               // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conexionBD.prepareStatement(con);
            preparedStmt.setString (1, usuario);
            preparedStmt.setString (2, nombre);
            preparedStmt.setString   (3, apellido);
            preparedStmt.setString(4, correo);
            preparedStmt.setString(5, fechaNacimiento);
            preparedStmt.setString (6, contraseña);
            preparedStmt.setString (7, club);
            preparedStmt.setString   (8, categoria);
            preparedStmt.setString(9, elo);
            preparedStmt.execute();
            conexionBD.close();
        } catch (Exception e) { // Error al realizar la consulta
            System.err.println(e);
        }
    }
    public void añadirResponsableInfantil(String usuario, String nombre, String apellido,
                String correo, String fecha)
    {
        String bd = "jdbc:mysql://localhost/MySQL?serverTimezone=" + TimeZone.getDefault().getID();
        try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver de m ysql
        // Conexión usando usuario y clave de administrador de la BD
        conexionBD = DriverManager.getConnection(bd, "root", "Dddedo");
        } catch (Exception e) { // Error en la conexión con la BD
        System.out.println(e);
        }
        ResultSet resultados = null;
        try {
            
            String con;
            Statement s = conexionBD.createStatement();
            // Consulta SQL
            con =   "INSERT INTO ajdrez.responsablesinfantiles VALUES( ?, ?, ?, ?, ?)";
            
            PreparedStatement preparedStmt = conexionBD.prepareStatement(con);
            preparedStmt.setString (1, usuario);
            preparedStmt.setString (2, nombre);
            preparedStmt.setString  (3, apellido);
            preparedStmt.setString(4, correo);
            preparedStmt.setString(5, fecha);
            preparedStmt.execute();
            
            conexionBD.close();
            
          } catch (Exception e) { // Error al realizar la consulta
            System.err.println(e);
        } 
    }
    
    public boolean validarUsuario(String user, String pass)
    {
        String bd = "jdbc:mysql://localhost/MySQL?serverTimezone=" + TimeZone.getDefault().getID();
        try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver de m ysql
        // Conexión usando usuario y clave de administrador de la BD
        conexionBD = DriverManager.getConnection(bd, "root", "Dddedo");
        } catch (Exception e) { // Error en la conexión con la BD
        System.out.println(e);
        }
        boolean ok = false;
        ResultSet resultados = null;
        try {
            String con;
            Statement s = conexionBD.createStatement();
            // Consulta SQL
            con = "SELECT usuario FROM ajdrez.jugador " +
                    "WHERE usuario = '" + user + "'" + "AND contraseña = '" + pass + "'";
            resultados = s.executeQuery(con);
            while (resultados.next() && !ok) 
            {
                String id = resultados.getString("usuario");
                ok = true;
            }
            conexionBD.close();
        } catch (Exception e) { // Error al realizar la consulta
            System.err.println(e);
        }
        
        return ok;
    }
    
    public boolean validarUsuario(String usser)
    {
        String bd = "jdbc:mysql://localhost/MySQL?serverTimezone=" + TimeZone.getDefault().getID();
        try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver de m ysql
        // Conexión usando usuario y clave de administrador de la BD
        conexionBD = DriverManager.getConnection(bd, "root", "Dddedo");
        } catch (Exception e) { // Error en la conexión con la BD
        System.out.println(e);
        }
        boolean ok = false;
        ResultSet resultados = null;
        try {
            String con;
            Statement s = conexionBD.createStatement();
            // Consulta SQL
            con = "SELECT usuario FROM ajdrez.jugador " +
                    "WHERE usuario = '" + usser + "'";
            resultados = s.executeQuery(con);
            while (resultados.next() && !ok) 
            {
                String id = resultados.getString("usuario");
                ok = true;
            }
            conexionBD.close();
        } catch (Exception e) { // Error al realizar la consulta
            System.err.println(e);
        } 
        return ok;         
    }
    public ArrayList<String> verTarjeta(String usser)
    {
        String bd = "jdbc:mysql://localhost/MySQL?serverTimezone=" + TimeZone.getDefault().getID();
        try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver de m ysql
        // Conexión usando usuario y clave de administrador de la BD
        conexionBD = DriverManager.getConnection(bd, "root", "Dddedo");
        } catch (Exception e) { // Error en la conexión con la BD
        System.out.println(e);
        }
        ArrayList<String> tarjeta = new ArrayList<>();
        String id;
        //System.out.println(usser);
        ResultSet resultados = null;
        try {
            String con;
            Statement s = conexionBD.createStatement();
            // Consulta SQL
            con = "SELECT nombre, apellido, fechaNacimiento, ELO, categoria FROM ajdrez.jugador " +
                    "WHERE usuario = '" + usser + "'";
            resultados = s.executeQuery(con);
            while (resultados.next()) 
            {
                id = resultados.getString("nombre");
                tarjeta.add(id);
                
                id = resultados.getString("fechaNacimiento");
                tarjeta.add(id);
                
                id = resultados.getString("apellido");
                tarjeta.add(id);
                
                id = resultados.getString("categoria");
                tarjeta.add(id);
                
                id = resultados.getString("ELO");
                tarjeta.add(id);
            }
            conexionBD.close();
        } catch (Exception e) { // Error al realizar la consulta
            System.err.println(e);
        }
        return tarjeta;
    }
    
    public void darBajaUsuario(String usser)
    {
        String bd = "jdbc:mysql://localhost/MySQL?serverTimezone=" + TimeZone.getDefault().getID();
        String jugadores, torneo, responsable;
        try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver de m ysql
        // Conexión usando usuario y clave de administrador de la BD
        conexionBD = DriverManager.getConnection(bd, "root", "Dddedo");
        } catch (Exception e) { // Error en la conexión con la BD
        System.out.println(e);
        }
        ResultSet resultados = null;
        
        try {
                // Consulta SQL
                responsable = "DELETE FROM ajdrez.responsablesinfantiles " +
                    "WHERE usuario = ?";
                
                torneo = "DELETE FROM ajdrez.torneo_jugador " +
                    "WHERE jugador = ?";
                
                jugadores = "DELETE FROM ajdrez.jugador " +
                    "WHERE usuario = ?";
            
            PreparedStatement prepaResponsable = conexionBD.prepareStatement(responsable);
            prepaResponsable.setString (1, usser);
            prepaResponsable.execute();    
            
            PreparedStatement prepaTorneo = conexionBD.prepareStatement(torneo);
            prepaTorneo.setString (1, usser);
            prepaTorneo.execute();    
                
            PreparedStatement preparJugador = conexionBD.prepareStatement(jugadores);
            preparJugador.setString (1, usser);
            preparJugador.execute();
            conexionBD.close();
            
        } catch (Exception e) { // Error al realizar la consulta
            System.err.println(e);
        }
    }
    
    public ArrayList<String> obtenerUsuarios()
    {
        ArrayList<String> jugadores = new ArrayList<>();
        String bd = "jdbc:mysql://localhost/MySQL?serverTimezone=" + TimeZone.getDefault().getID();
        try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver de m ysql
        // Conexión usando usuario y clave de administrador de la BD
        conexionBD = DriverManager.getConnection(bd, "root", "Dddedo");
        } catch (Exception e) { // Error en la conexión con la BD
        System.out.println(e);
        }
        ArrayList<String> tarjeta = new ArrayList<>();
        String id;
        //System.out.println(usser);
        ResultSet resultados = null;
        try {
            String con;
            Statement s = conexionBD.createStatement();
            // Consulta SQL
            con = "SELECT usuario FROM ajdrez.jugador ";
            resultados = s.executeQuery(con);
            while (resultados.next()) 
            {
                id = resultados.getString("usuario");
                jugadores.add(id);
            }
            conexionBD.close();
        } catch (Exception e) { // Error al realizar la consulta
            System.err.println(e);
        }  
        
        return jugadores;
    }
    
}
