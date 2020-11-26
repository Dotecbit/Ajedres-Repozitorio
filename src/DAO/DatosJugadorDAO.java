/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TimeZone;
import model.DatosJugador;

/**
 *
 * @author 34677
 */
public class DatosJugadorDAO 
{
    private Connection conexionBD;
    private PreparedStatement prep;
    private ArrayList<String> jugadores = new ArrayList<>();
    
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
        String jugadores, torneo;
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
                torneo = "DELETE FROM ajdrez.torneo_jugador " +
                    "WHERE jugador = ?";
                
                jugadores = "DELETE FROM ajdrez.jugador " +
                    "WHERE usuario = ?";
            
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
    
    public void obtenerUsuarios()
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
    }
    
     public String obtenerClubDeUsuario(String usuario)
    {
        String bd = "jdbc:mysql://localhost/MySQL?serverTimezone=" + TimeZone.getDefault().getID();
        try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver de m ysql
        // Conexión usando usuario y clave de administrador de la BD
        conexionBD = DriverManager.getConnection(bd, "root", "Dddedo");
        } catch (Exception e) { // Error en la conexión con la BD
        System.out.println(e);
        }
        String id = null;

        ResultSet resultados = null;
        try {
            String con;
            Statement s = conexionBD.createStatement();
            // Consulta SQL
            con = "SELECT club FROM ajdrez.jugador WHERE usuario = '"+usuario+"'";
            resultados = s.executeQuery(con);
            while (resultados.next()) 
            {
                id = resultados.getString("club");
            }
            conexionBD.close();
            
        } catch (Exception e) { // Error al realizar la consulta
            System.err.println(e);
        }        
        return id;
    }
    
    public void actualizarJugador(DatosJugador jugador) throws SQLException
    {
        String bd = "jdbc:mysql://localhost/MySQL?serverTimezone=" + TimeZone.getDefault().getID();
        try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver de m ysql
        // Conexión usando usuario y clave de administrador de la BD
        conexionBD = DriverManager.getConnection(bd, "root", "Dddedo");
        } catch (Exception e) { // Error en la conexión con la BD
        System.out.println(e);
        }
        
        String con;
       
        if(jugador.getClub()!= null)
        {
            con = "UPDATE  ajdrez.jugador SET usuario ='" + jugador.getUsuario()+
                    "' ,nombre ='" + jugador.getNombre()+ "' ,apellido ='" + jugador.getApellido()+ "' ,correo ='" +jugador.getCorreo()+ 
                    "' ,fechaNacimiento =" + jugador.getFechaNacimiento()+ " ,contraseña =" + jugador.getContraseña()+ " ,club ='" + jugador.getClub()+
                    "', categoria ='" + jugador.getCategoria()+ ", ELO ='" + jugador.getElo()+ ", torneo = null "+
                    "' WHERE usuario ='" +jugador.getUsuario()+"'";
            PreparedStatement preparedStmt = conexionBD.prepareStatement(con);
            preparedStmt.executeUpdate();
        }
        else
        {
            con = "UPDATE  ajdrez.jugador SET usuario ='" + jugador.getUsuario()+
                    "' ,nombre ='" + jugador.getNombre()+ "' ,apellido ='" + jugador.getApellido()+ "' ,correo ='" +jugador.getCorreo()+ 
                    "' ,fechaNacimiento =" + jugador.getFechaNacimiento()+ " ,contraseña =" + jugador.getContraseña()+ " ,club =null"+
                    ", categoria ='" + jugador.getCategoria()+ ", ELO ='" + jugador.getElo()+ ", torneo = null "+
                    "' WHERE usuario ='" +jugador.getUsuario()+"'";
            PreparedStatement preparedStmt = conexionBD.prepareStatement(con);
            preparedStmt.executeUpdate();
        }
        conexionBD.close();

    }
    
    public void actualizarClubJugador(String usuario, String club) throws SQLException
    {
        String bd = "jdbc:mysql://localhost/MySQL?serverTimezone=" + TimeZone.getDefault().getID();
        try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver de m ysql
        // Conexión usando usuario y clave de administrador de la BD
        conexionBD = DriverManager.getConnection(bd, "root", "Dddedo");
        } catch (Exception e) 
        { // Error en la conexión con la BD
            System.out.println(e);
        }
        
        String con;

        con = "UPDATE  ajdrez.jugador SET club ='" + club+
              "' WHERE usuario ='" +usuario+"'";
        PreparedStatement preparedStmt = conexionBD.prepareStatement(con);
        preparedStmt.executeUpdate();

        conexionBD.close();
    }

    public ArrayList<String> getUsuarios()
    {
        return jugadores;
    }
    public void setJugadores(String usuarios)
    {
        jugadores.add(usuarios);
    }
    
}
