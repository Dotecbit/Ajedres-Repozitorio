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
    public DatosTorneoDAO()     
    {
        String bd = "jdbc:mysql://localhost/MySQL?serverTimezone=" + TimeZone.getDefault().getID();
        try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver de m ysql
        // Conexión usando usuario y clave de administrador de la BD
        conexionBD = DriverManager.getConnection(bd, "root", "Dddedo");
        } catch (Exception e) { // Error en la conexión con la BD
            System.out.println(e);
        }        
    }
    
    public ArrayList<String> cargarSede()
    {
        String id;
        //System.out.println(usser);
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
        return sede;        
    }
    
    public void agregarTorneoSede(String nombreTorneo, ArrayList<String> sedes)
    {
        ResultSet resultados = null;
        String con;
        try {
            Statement s = conexionBD.createStatement();
            for(int i = 0; i < sedes.size(); i++)
            {
                // Consulta SQL
                con =   "INSERT INTO ajdrez.sede VALUES(?, ?)";
            
                PreparedStatement preparedStmt = conexionBD.prepareStatement(con);
                preparedStmt.setString (1, sedes.get(i));
                preparedStmt.setString (1, nombreTorneo);
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
        try {
            Statement s = conexionBD.createStatement();
            if(jugadores.size() > 0)
            {
                for(int i = 0; i < jugadores.size(); i++)
                {
                    // Consulta SQL
                    con =   "INSERT INTO ajdrez.sede VALUES(?, ?)";

                    PreparedStatement preparedStmt = conexionBD.prepareStatement(con);
                    preparedStmt.setString (1, jugadores.get(i));
                    preparedStmt.setString (1, nombreTorneo);
                    preparedStmt.execute();
                }
            }
            else
            {
                    con =   "INSERT INTO ajdrez.sede VALUES(?, ?)";
                    PreparedStatement preparedStmt = conexionBD.prepareStatement(con);
                    preparedStmt.setString (1, "null");
                    preparedStmt.setString (1, nombreTorneo);
                    preparedStmt.execute();
                
            }
            conexionBD.close();
            
          } catch (Exception e) { // Error al realizar la consulta
            System.err.println(e);
        }       
    }
    
    public ArrayList<String> getSedes()
    {
        return sede;
    }
}
