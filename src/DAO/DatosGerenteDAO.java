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
import model.DatosGerente;

/**
 *
 * @author areba
 */
public class DatosGerenteDAO {
private Connection conexionBD;
private ArrayList<DatosGerente> gerentes;
    
    public DatosGerenteDAO() throws SQLException
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
    
    
    public ArrayList<DatosGerente> getGerentes() throws SQLException
    {
        String bd = "jdbc:mysql://localhost/MySQL?serverTimezone=" + TimeZone.getDefault().getID();
        try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver de m ysql
        // Conexión usando usuario y clave de administrador de la BD
        conexionBD = DriverManager.getConnection(bd, "root", "Dddedo");
        } catch (Exception e) { // Error en la conexión con la BD
        System.out.println(e);
        }
        
        gerentes = new ArrayList();
        
        ResultSet resultados = null;
        String con, dato;
        Statement s = conexionBD.createStatement();

        // Consulta SQL
        con = "SELECT * FROM ajdrez.gerentes";
        resultados = s.executeQuery(con);

        while (resultados.next()) 
        {
            DatosGerente nuevoGerente = new DatosGerente();
            dato = resultados.getString("nombre");
            nuevoGerente.setNombre(dato);
            
            dato = resultados.getString("apellidos");
            nuevoGerente.setApellidos(dato);
            
            dato = resultados.getString("sexo");
            nuevoGerente.setSexo(dato);
            
            dato = resultados.getString("nCompleto");
            nuevoGerente.setnCompleto(dato);
            
            dato = resultados.getString("edad");
            nuevoGerente.setEdad(Integer.parseInt(dato));
            
            dato = resultados.getString("nomina");
            nuevoGerente.setNomina(Float.parseFloat(dato));
            
            dato = resultados.getString("IRPF");
            nuevoGerente.setIRPF(Float.parseFloat(dato));
            
            dato = resultados.getString("Club");
            nuevoGerente.setClubActual(dato);

            gerentes.add(nuevoGerente);
            }
        conexionBD.close();
        return gerentes;
        
    }
    
    public void setGerentes(ArrayList<DatosGerente> gerentes) throws SQLException
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

        for(DatosGerente i:gerentes)
        {
                con = "INSERT INTO ajdrez.gerentes VALUES ('" + i.getnCompleto()+
                        "','" + i.getNombre()+ "','" + i.getApellidos()+ "','" + i.getSexo()+ "','" + i.getEdad()+ 
                        "','" + i.getNomina()+"','" + i.getIRPF() + "','" + i.getClubActual()+ "')";
                PreparedStatement preparedStmt = conexionBD.prepareStatement(con);
                preparedStmt.executeUpdate();
        }
        conexionBD.close();
    }
    
       public void CrearGerentes(DatosGerente gerente) throws SQLException
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
                con = "INSERT INTO ajdrez.gerentes VALUES ('" + gerente.getnCompleto()+
                        "','" + gerente.getNombre()+ "','" + gerente.getApellidos()+ "','" + gerente.getSexo()+ "','" + gerente.getEdad()+ 
                        "','" + gerente.getNomina()+"','" + gerente.getIRPF() + "'," + "null"+ ")";
                PreparedStatement preparedStmt = conexionBD.prepareStatement(con);
                preparedStmt.executeUpdate();
        conexionBD.close();
    }
    
    public void actualizarGerente(DatosGerente gerente) throws SQLException
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
       
        if(gerente.getClubActual() != null)
        {
            con = "UPDATE  ajdrez.gerentes SET nCompleto ='" + gerente.getnCompleto()+
                    "' ,nombre ='" + gerente.getNombre()+ "' ,apellidos ='" + gerente.getApellidos()+ "' ,sexo ='" +gerente.getSexo()+ 
                    "' ,edad =" + gerente.getEdad()+ " ,nomina =" + gerente.getNomina()+ " ,IRPF =" + gerente.getIRPF() +
                    ", Club ='" + gerente.getClubActual()+
                    "' WHERE nCompleto ='" +gerente.getnCompleto()+"'";
            PreparedStatement preparedStmt = conexionBD.prepareStatement(con);
            preparedStmt.executeUpdate();
        }
        else
        {
            con = "UPDATE  ajdrez.gerentes SET nCompleto ='" + gerente.getnCompleto()+
                    "' ,nombre ='" + gerente.getNombre()+ "' ,apellidos ='" + gerente.getApellidos()+ "' ,sexo ='" +gerente.getSexo()+ 
                    "' ,edad =" + gerente.getEdad()+ " ,nomina =" + gerente.getNomina()+ " ,IRPF =" + gerente.getIRPF() +
                    ", Club = null"+
                    " WHERE nCompleto ='" +gerente.getnCompleto()+"'";
            PreparedStatement preparedStmt = conexionBD.prepareStatement(con);
            preparedStmt.executeUpdate();
        }
        conexionBD.close();

    }

        
}
    
