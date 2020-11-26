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
    private ArrayList<String> sede = new ArrayList<>();
    private ArrayList<String> nombreTroneo;
    public DatosTorneoDAO()     
    {

    }
    
    public void cargarSede()
    {
        String id;
        
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
    
    public ArrayList<String> nombreTorneosUsuario(String usuario)
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
            con = "SELECT Distinct  t.nombre FROM ajdrez.torneos t JOIN ajdrez.torneo_jugador tj ON t.nombre = tj.nombreTorneo "
                    + " WHERE != ?";
            
            PreparedStatement preparedStmt = conexionBD.prepareStatement(con);
            preparedStmt.setString (1, usuario);
            
            resultados = preparedStmt.executeQuery();;
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
    
    public ArrayList<String> getSedes()
    {
        return sede;
    }
}
