/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factory.Persona;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TimeZone;
import model.DatosClub;
import model.DatosGerente;

/**
 *
 * @author areba
 */
public class DatosClubDAO {
    
    private Connection conexionBD;
    private ArrayList<DatosClub> clubs;
    
    public DatosClubDAO() throws SQLException
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
    
    
    public ArrayList<DatosClub> getClub() throws SQLException
    {
        String bd = "jdbc:mysql://localhost/MySQL?serverTimezone=" + TimeZone.getDefault().getID();
        try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver de m ysql
        // Conexión usando usuario y clave de administrador de la BD
        conexionBD = DriverManager.getConnection(bd, "root", "Dddedo");
        } catch (Exception e) { // Error en la conexión con la BD
        System.out.println(e);
        }
        
        clubs = new ArrayList();
        
        ResultSet resultados = null;
        String con, dato;
        Statement s = conexionBD.createStatement();

        // Consulta SQL
        con = "SELECT * FROM ajdrez.clubs";
        resultados = s.executeQuery(con);

        while (resultados.next()) 
        {
            DatosClub nuevoClub = new DatosClub();
            dato = resultados.getString("nombre");
            nuevoClub.setNombre(dato);
            
            dato = resultados.getString("federacion");
            nuevoClub.setFederacion(dato);
            
            dato = resultados.getString("sede");
            nuevoClub.setSede(dato);

            clubs.add(nuevoClub);
            }
        conexionBD.close();
        
        return clubs;
        
    }
    
    public void setClub(ArrayList<DatosClub> clubs) throws SQLException
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
        String con, dato;
        Statement s = conexionBD.createStatement();

        for(DatosClub i:clubs)
        {
                con = "INSERT INTO ajdrez.clubs VALUES ('" + i.getNombre()+
                        "','" + i.getFederacion()+ "','" + i.getSede()+")";
                PreparedStatement preparedStmt = conexionBD.prepareStatement(con);
                preparedStmt.executeUpdate();
        }
        conexionBD.close();
    }
    
       public void CrearClub(DatosClub club) throws SQLException
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
        String con, dato;
        Statement s = conexionBD.createStatement();
                con = "INSERT INTO ajdrez.clubs VALUES ('" + club.getNombre()+
                        "','" + club.getFederacion()+ "','" + club.getSede()+ "')";
                PreparedStatement preparedStmt = conexionBD.prepareStatement(con);
                preparedStmt.executeUpdate();
        conexionBD.close();
    }
    
    public void actualizarGerente(DatosClub club) throws SQLException
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
        String con, dato;
        Statement s = conexionBD.createStatement();

        {
                con = "UPDATE  ajdrez.clubs SET nombre =" + club.getNombre()+
                        ",federacion =" + club.getFederacion()+ ",sede =" + club.getSede()+
                        "WHERE nCompleto =" +club.getNombre();
                PreparedStatement preparedStmt = conexionBD.prepareStatement(con);
                preparedStmt.executeUpdate();
        }
        conexionBD.close();

    }

    public ArrayList<String> getFederaciones() throws SQLException {
        
        String bd = "jdbc:mysql://localhost/MySQL?serverTimezone=" + TimeZone.getDefault().getID();
        try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver de m ysql
        // Conexión usando usuario y clave de administrador de la BD
        conexionBD = DriverManager.getConnection(bd, "root", "Dddedo");
        } catch (Exception e) { // Error en la conexión con la BD
        System.out.println(e);
        }
        
        ArrayList<String> federaciones = new ArrayList();
        
        ResultSet resultados = null;
        String con, dato;
        Statement s = conexionBD.createStatement();

        // Consulta SQL
        con = "SELECT * FROM ajdrez.federaciones";
        resultados = s.executeQuery(con);

        while (resultados.next()) 
        {
            DatosClub nuevoClub = new DatosClub();
            dato = resultados.getString("nombre");

            federaciones.add(dato);
        }
        
        conexionBD.close();
        
        return federaciones;
    }
    
     public void eliminarClub(DatosClub club) throws SQLException {
        
        String bd = "jdbc:mysql://localhost/MySQL?serverTimezone=" + TimeZone.getDefault().getID();
        try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver de m ysql
        // Conexión usando usuario y clave de administrador de la BD
        conexionBD = DriverManager.getConnection(bd, "root", "Dddedo");
        } catch (Exception e) { // Error en la conexión con la BD
        System.out.println(e);
        }
        
        ResultSet resultados = null;
        String con, dato;
        Statement s = conexionBD.createStatement();

        {
                con = "DELETE FROM  ajdrez.clubs WHERE nombre ='" + club.getNombre()+"'";
                PreparedStatement preparedStmt = conexionBD.prepareStatement(con);
                preparedStmt.executeUpdate();
        }
        conexionBD.close();
    }   
        
}