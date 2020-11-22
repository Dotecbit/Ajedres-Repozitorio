/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimeZone;

/**
 *
 * @author alumno
 */
public class DatosDAO {
private Connection conexionBD;
    
    public DatosDAO() throws SQLException
    {
        String bd = "jdbc:mysql://localhost/MySQL?serverTimezone=" + TimeZone.getDefault().getID();
        try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver de m ysql
        // Conexión usando usuario y clave de administrador de la BD
        conexionBD = DriverManager.getConnection(bd, "root", "Ayoub6275");
        } catch (Exception e) { // Error en la conexión con la BD
        System.out.println(e);
        }
        cargarDatos();
        
    }
    
    public void cargarDatos() throws SQLException
    {
        ResultSet resultados = null;
        try {
            String con;
            Statement s = conexionBD.createStatement();
            // Consulta SQL
            con = "SELECT nombre FROM ajdrez.clubs";
            resultados = s.executeQuery(con);
            while (resultados.next()) {
            String id = resultados.getString("nombre");
            System.out.print(id);
        }
        } catch (Exception e) { // Error al realizar la consulta
            System.err.println(e);
        }
        
    }
    
}
