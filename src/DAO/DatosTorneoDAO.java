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

/**
 *
 * @author 34677
 */
public class DatosTorneoDAO 
{
    
    private Connection conexionBD;
    private ArrayList<String> sede;
    private ArrayList<String> nombreTroneo;
    private ArrayList<String> nombreTorneoUsuario;
    public DatosTorneoDAO()     
    {

    }
    
    public void cargarSede()
    {
        String id;
        sede = new ArrayList<>();
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
            con = "SELECT * FROM ajdrez.sede ";
            resultados = s.executeQuery(con);
            while (resultados.next()) 
            {
                id = resultados.getString("nombre");
                sede.add(id);
            }
            conexionBD.close();
        } catch (Exception e) { // Error al realizar la consulta
            System.err.println(e);
            
        }      
    }
    
    public void agregarTorneoSede(String nombreTorneo, ArrayList<String> sedes)
    {
        ResultSet resultados = null;
        String con;
        String bd = "jdbc:mysql://localhost/MySQL?serverTimezone=" + TimeZone.getDefault().getID();
        try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver de m ysql
        // Conexión usando usuario y clave de administrador de la BD
        conexionBD = DriverManager.getConnection(bd, "root", "Dddedo");
        } catch (Exception e) { // Error en la conexión con la BD
            System.out.println(e);
        }        
        try {
            Statement s = conexionBD.createStatement();
            for(int i = 0; i < sedes.size(); i++)
            {
                // Consulta SQL
                con =   "INSERT INTO ajdrez.torneo_sede VALUES(?, ?)";
            
                PreparedStatement preparedStmt = conexionBD.prepareStatement(con);
                preparedStmt.setString (1, sedes.get(i));
                preparedStmt.setString (2, nombreTorneo);
                preparedStmt.execute();
            }
            conexionBD.close();
            
          } catch (Exception e) { // Error al realizar la consulta
            System.err.println(e);
        }       
    }
    
    public void agregarTorneoJugador(String nombreTorneo, ArrayList<String> jugadores)
    {
        ResultSet resultados = null;
        String con;
        String bd = "jdbc:mysql://localhost/MySQL?serverTimezone=" + TimeZone.getDefault().getID();
        try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver de m ysql
        // Conexión usando usuario y clave de administrador de la BD
        conexionBD = DriverManager.getConnection(bd, "root", "Dddedo");
        } catch (Exception e) { // Error en la conexión con la BD
            System.out.println(e);
        }        
        try {
            Statement s = conexionBD.createStatement();
            if(jugadores.size() > 0)
            {
                for(int i = 0; i < jugadores.size(); i++)
                {
                    // Consulta SQL
                    con =   "INSERT INTO ajdrez.torneo_jugador VALUES(?, ?)";

                    PreparedStatement preparedStmt = conexionBD.prepareStatement(con);
                    preparedStmt.setString (1, jugadores.get(i));
                    preparedStmt.setString (2, nombreTorneo);
                    preparedStmt.execute();
                }
            }
            else
            {
                    con =   "INSERT INTO ajdrez.torneo_jugador VALUES(?, ?)";
                    PreparedStatement preparedStmt = conexionBD.prepareStatement(con);
                    preparedStmt.setString (1, "null");
                    preparedStmt.setString (2, nombreTorneo);
                    preparedStmt.execute();
                
            }
            conexionBD.close();
            
          } catch (Exception e) { // Error al realizar la consulta
            System.err.println(e);
        }       
    }
    
    public void agregarTorneo(String nombre)
    {
        ResultSet resultados = null;
        String con;
        String bd = "jdbc:mysql://localhost/MySQL?serverTimezone=" + TimeZone.getDefault().getID();
        try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver de m ysql
        // Conexión usando usuario y clave de administrador de la BD
        conexionBD = DriverManager.getConnection(bd, "root", "Dddedo");
        } catch (Exception e) { // Error en la conexión con la BD
            System.out.println(e);
        }        
        try {
            Statement s = conexionBD.createStatement();
                // Consulta SQL
                con =   "INSERT INTO ajdrez.torneos VALUES(?)";
            
                PreparedStatement preparedStmt = conexionBD.prepareStatement(con);
                preparedStmt.setString (1, nombre);
                preparedStmt.execute();
                conexionBD.close();
            
          } catch (Exception e) { // Error al realizar la consulta
            System.err.println(e);
        }        
    }
    public  ArrayList<String> nombreTorneos()
    {
        String id;
        nombreTroneo = new ArrayList<>();
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
            con = "SELECT nombre FROM ajdrez.torneos ";
            
            resultados = s.executeQuery(con);
            while (resultados.next()) 
            {
                id = resultados.getString("nombre");
                nombreTroneo.add(id);
            }
            conexionBD.close();
        } catch (Exception e) { // Error al realizar la consulta
            System.err.println(e);   
        }      
        return nombreTroneo;
    }
    
    public boolean comprobarTorneoUsuario(String usuario, String torneo)
    {
        boolean ok = false;
        
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
            int count;
            
            Statement s = conexionBD.createStatement();
            // Consulta SQL
            con = "SELECT COUNT(*) AS CANTIDAD FROM ajdrez.torneo_jugador WHERE jugador ='" + usuario + 
                    "'" + "AND nombreTorneo ='" + torneo + "'";
            
            resultados = s.executeQuery(con);
            resultados.next();
            count = resultados.getInt("CANTIDAD");
            if (count > 0) 
                ok = true;
            conexionBD.close();
        } catch (Exception e) { // Error al realizar la consulta
            System.err.println(e);
        }      
        return ok;        
    }
    
    public void darDebajaTorneo(String torneo)
    {
        String bd = "jdbc:mysql://localhost/MySQL?serverTimezone=" + TimeZone.getDefault().getID();
        String torneo_jugador, torneo_sede, nombre_torneo;
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
                torneo_jugador = "DELETE FROM ajdrez.torneo_jugador " +
                    "WHERE nombreTorneo = ?";
                
                torneo_sede = "DELETE FROM ajdrez.torneo_sede " +
                    "WHERE nombre_torneo = ?";
                
                nombre_torneo = "DELETE FROM ajdrez.torneos " +
                    "WHERE nombre = ?";
            
            PreparedStatement prepaResponsable = conexionBD.prepareStatement(torneo_jugador);
            prepaResponsable.setString (1, torneo);
            prepaResponsable.execute();    
            
            PreparedStatement prepaTorneo = conexionBD.prepareStatement(torneo_sede);
            prepaTorneo.setString (1, torneo);
            prepaTorneo.execute();    
                
            PreparedStatement preparJugador = conexionBD.prepareStatement(nombre_torneo);
            preparJugador.setString (1, torneo);
            preparJugador.execute();
            conexionBD.close();
            
        } catch (Exception e) { // Error al realizar la consulta
            System.err.println(e);
        }       
    }
    
    public ArrayList<String> asignarJugadoresTorneo(String nombre)
    {
        ArrayList<String> jugadores = new ArrayList<>();
        ArrayList<String> jugadoresActualizados = new ArrayList<>();
        
        String bd = "jdbc:mysql://localhost/MySQL?serverTimezone=" + TimeZone.getDefault().getID();
        String con, id;
        int count = 0;
        try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver de m ysql
        // Conexión usando usuario y clave de administrador de la BD
        conexionBD = DriverManager.getConnection(bd, "root", "Dddedo");
        } catch (Exception e) { // Error en la conexión con la BD
        System.out.println(e);
        }
        ResultSet resultados = null;
        
        try {
            Statement s = conexionBD.createStatement();
            // Consulta SQL
            con = "SELECT usuario FROM ajdrez.jugador;";
            resultados = s.executeQuery(con);
            while (resultados.next()) 
            {
                id = resultados.getString("usuario");
                jugadores.add(id);
            }               
            for(int i = 0; i < jugadores.size(); i++)
            {
                con = "SELECT COUNT(*) AS CANTIDAD FROM ajdrez.torneo_jugador " +
                        "WHERE jugador = '" + jugadores.get(i) + "'" + " AND nombreTorneo = '" + nombre + "'";
                
                resultados = s.executeQuery(con);
                resultados.next();
                count = resultados.getInt("CANTIDAD");
                
                if(count == 0)
                    jugadoresActualizados.add(jugadores.get(i));
            }
            conexionBD.close();
            
        } catch (Exception e) { // Error al realizar la consulta
            System.err.println(e);
        }        
        
        return jugadoresActualizados;
    }
    public ArrayList<String> jugadoresParticipantes(String nombreTorneo) throws SQLException
    {
        
        ArrayList<String> jugadores = new ArrayList<>();
        
        String bd = "jdbc:mysql://localhost/MySQL?serverTimezone=" + TimeZone.getDefault().getID();
        String con, id;
        int count = 0;
        try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver de m ysql
        // Conexión usando usuario y clave de administrador de la BD
        conexionBD = DriverManager.getConnection(bd, "root", "Dddedo");
        } catch (Exception e) { // Error en la conexión con la BD
        System.out.println(e);
        }
        ResultSet resultados = null;
        
        try {
            Statement s = conexionBD.createStatement();
            // Consulta SQL
            con = "SELECT tj.jugador FROM ajdrez.torneo_jugador tj " +
                    "JOIN ajdrez.torneos t ON tj.nombreTorneo = t.nombre " +
                    "WHERE t.nombre ='" +nombreTorneo + "'";
            resultados = s.executeQuery(con);
            while (resultados.next()) 
            {
                id = resultados.getString("tj.jugador");
                jugadores.add(id);
            }
        } catch (Exception e) { // Error al realizar la consulta
            System.err.println(e);
        }
        return jugadores;   
    }
    
    public void eliminarJugadorTorneo(String usuario, String torneo)
    {
        String bd = "jdbc:mysql://localhost/MySQL?serverTimezone=" + TimeZone.getDefault().getID();
        String torneo_jugador;
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
            torneo_jugador = "DELETE FROM ajdrez.torneo_jugador " +
                "WHERE jugador = ? AND nombreTorneo =?";

            PreparedStatement prepaResponsable = conexionBD.prepareStatement(torneo_jugador);
            prepaResponsable.setString (1, usuario);
            prepaResponsable.setString (2, torneo);
            prepaResponsable.execute();    
            
        } catch (Exception e) { // Error al realizar la consulta
            System.err.println(e);
        }          
    }
    
    public ArrayList<String> asignarSedesTorneo(String nombre)
    {
        ArrayList<String> sedesActualizados = new ArrayList<>();
        String bd = "jdbc:mysql://localhost/MySQL?serverTimezone=" + TimeZone.getDefault().getID();
        String con, id;
        int count = 0;
        try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver de m ysql
        // Conexión usando usuario y clave de administrador de la BD
        conexionBD = DriverManager.getConnection(bd, "root", "Dddedo");
        } catch (Exception e) { // Error en la conexión con la BD
        System.out.println(e);
        }
        ResultSet resultados = null;
        
        try {
            Statement s = conexionBD.createStatement();          
            for(int i = 0; i < sede.size(); i++)
            {
                con = "SELECT COUNT(*) AS CANTIDAD FROM ajdrez.torneo_sede " +
                        "WHERE nombre_sede = '" + sede.get(i) + "'" + " AND nombre_torneo = '" + nombre + "'";
                
                resultados = s.executeQuery(con);
                resultados.next();
                count = resultados.getInt("CANTIDAD");
                
                if(count == 0)
                    sedesActualizados.add(sede.get(i));
            }
            conexionBD.close();
            
        } catch (Exception e) { // Error al realizar la consulta
            System.err.println(e);
        }               
        return sedesActualizados;
    }
    
    public  ArrayList<String> sedesParticipantes(String nombreTorneo)
    {
        ArrayList<String> sedeParticipante = new ArrayList<>();
        
        String bd = "jdbc:mysql://localhost/MySQL?serverTimezone=" + TimeZone.getDefault().getID();
        String con, id;
        int count = 0;
        try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver de m ysql
        // Conexión usando usuario y clave de administrador de la BD
        conexionBD = DriverManager.getConnection(bd, "root", "Dddedo");
        } catch (Exception e) { // Error en la conexión con la BD
        System.out.println(e);
        }
        ResultSet resultados = null;
        
        try {
            Statement s = conexionBD.createStatement();
            // Consulta SQL
            con = "SELECT ts.nombre_sede FROM ajdrez.torneo_sede ts " +
                    "JOIN ajdrez.torneos t ON ts.nombre_torneo = t.nombre " +
                    "WHERE t.nombre ='" +nombreTorneo + "'";
            resultados = s.executeQuery(con);
            while (resultados.next()) 
            {
                id = resultados.getString("ts.nombre_sede");
                sedeParticipante.add(id);
            }
        } catch (Exception e) { // Error al realizar la consulta
            System.err.println(e);
        }
        return sedeParticipante;   
    }
    
    public void eliminarSedeTorneo(String sede, String torneo)
    {
        String bd = "jdbc:mysql://localhost/MySQL?serverTimezone=" + TimeZone.getDefault().getID();
        String torneo_sede;
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
            torneo_sede = "DELETE FROM ajdrez.torneo_sede " +
                "WHERE nombre_sede = ? AND nombre_torneo =?";

            PreparedStatement prepaResponsable = conexionBD.prepareStatement(torneo_sede);
            prepaResponsable.setString (1, sede);
            prepaResponsable.setString (2, torneo);
            prepaResponsable.execute();    
            
        } catch (Exception e) { // Error al realizar la consulta
            System.err.println(e);
        }          
    }
    
    
    public ArrayList<String> getSedes()
    {
        return sede;
    }
}