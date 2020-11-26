/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import DAO.DatosClubDAO;
import DAO.DatosEntrenadorDAO;
import DAO.DatosGerenteDAO;
import DAO.DatosJugadorDAO;
import DAO.DatosTorneoDAO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DatosClub;
import model.DatosEntrenador;
import model.DatosGerente;
import model.DatosTorneo;

/**
 *
 * @author areba
 */
public class Administrador {

    private Jugador jugador;
    private DatosJugadorDAO datosJugadorDAO;
    private DatosGerente datosGerente;
    private ArrayList<DatosGerente> gerentes;
    private DatosGerenteDAO datosGerenteDAO;
    private DatosEntrenadorDAO datosEntrenadorDAO;
    private DatosClubDAO datosClubDAO;
    private DatosEntrenador datosEntrenador;
    private DatosTorneo datosTorneo;
    private DatosTorneoDAO torneoDAO;
    public Administrador(Jugador jugador) throws SQLException 
    {
        datosClubDAO = new DatosClubDAO();
        datosGerenteDAO = new DatosGerenteDAO();
        this.jugador = jugador;
        datosJugadorDAO = new DatosJugadorDAO();
        
        datosEntrenadorDAO = new DatosEntrenadorDAO();
        
        datosTorneo = new DatosTorneo();
        torneoDAO = new DatosTorneoDAO();

        torneoDAO.cargarSede();
    }
   
    public ArrayList<DatosGerente> getGerentes() throws SQLException
    {
        return datosGerenteDAO.getGerentes();
    }
    
    public ArrayList<DatosGerente> getGerentesConClub() throws SQLException
    {
        ArrayList<DatosGerente> gerEnvio = new ArrayList();
        
        //Seleccionamos todos los gerentes que tengan club
        gerentes = datosGerenteDAO.getGerentes();
        for(DatosGerente i:gerentes)
        {
            if(i.getClubActual() != null)
                gerEnvio.add(i);
        }
        return gerEnvio;
    }
    
    public ArrayList<DatosGerente> getGerentesLibres() throws SQLException
    {
        ArrayList<DatosGerente> gerentesLibres = new ArrayList();
        gerentes = datosGerenteDAO.getGerentes();
        for(DatosGerente g:gerentes)
        {
            if(g.getClubActual() == null)
                gerentesLibres.add(g);
        }
        return gerentesLibres;
    }
    
    public void guardarGerente(String nombre, String ape1, String ap2, String sexo,String edad, String nomina, String IRPF ) throws SQLException
    {
        DatosGerente gerente = new DatosGerente(nombre.replace(" ", ""), ape1.replace(" ", "")+" "+ap2.replace(" ", ""), sexo, Integer.parseInt(edad),
                Float.parseFloat(nomina), Float.parseFloat(IRPF));
    
        datosGerenteDAO.CrearGerentes(gerente);
    }
    
    public ArrayList<DatosClub> getClubs() throws SQLException
    {
        return datosClubDAO.getClub();
    }

    public void cargarSedes()
    {
        torneoDAO.cargarSede();
    }
    public ArrayList<String> getSedes()
    {
        torneoDAO.cargarSede();
        return torneoDAO.getSedes();
    }

    public ArrayList<String> getJugadores()
    {
        torneoDAO.cargarSede();
        return jugador.obtenerUsuarios();
    }
    
    public boolean comprobarTorneo(String nombreTorneo)
    {
        return datosTorneo.comprobarTorneo(nombreTorneo, torneoDAO.nombreTorneos());
    }
    
    public ArrayList<String> getNombreTorneo(String usuario)
    {
        return torneoDAO.nombreTorneosUsuario(usuario);
    }
    public void guardarEntrenador(String nombre, String ap1, String ap2, String sexo, String edad) throws SQLException 
    {
        //Al crear el entrenador nos aseguramos de que no haya espacios al haber creado al entrenador
        DatosEntrenador entrenador = new DatosEntrenador(nombre.replace(" ", ""),ap1.replace(" ", ""),ap2.replace(" ", ""),sexo,Integer.parseInt(edad));
        datosEntrenadorDAO.CrearEntrenador(entrenador);
    }

    public boolean entrenadorRepe(String nombre, String ap1, String ap2) throws SQLException 
    {
        boolean repe = false;
        String nCompleto = nombre+ap1+ap2;

        for(DatosEntrenador i:datosEntrenadorDAO.getEntrenadores())
        {
                if(i.getnCompleto().toLowerCase().replace(" ", "").equalsIgnoreCase(nCompleto.toLowerCase().replace(" ", "")))
                    repe = true;
        }
        return repe;
    }
    
    public void guardarTorneo(String nombre, ArrayList<String> usuario, ArrayList<String> sede)
    {
        torneoDAO.agregarTorneo(nombre);
        torneoDAO.agregarTorneoJugador(nombre, usuario);
        torneoDAO.agregarTorneoSede(nombre, sede);
    }

    public boolean gerenteRepe(String nombre, String ap1, String ap2) throws SQLException 
    {
        boolean repe = false;
        String nCompleto = nombre+ap1+ap2;

        for(DatosGerente i:datosGerenteDAO.getGerentes())
        {
            if(i.getnCompleto().toLowerCase().replace(" ", "").equalsIgnoreCase(nCompleto.toLowerCase().replace(" ", "")))
                repe = true;
        }
        return repe;
    }

    public boolean clubRepe(String nombre) throws SQLException 
    {
        boolean repe = false;
        for(DatosClub i:datosClubDAO.getClub())
        {
            if(i.getNombre().toLowerCase().equals((nombre).toLowerCase()))
                repe = true;
        }
        return repe;
    }

    public void crearClub(String nombre, String sede, String federacion, Object ger) throws FileNotFoundException, IOException, SQLException 
    {
        DatosClub nuevoClub = new DatosClub(nombre,sede,federacion);
        ((DatosGerente) ger).setClubActual(nombre);
        
        datosClubDAO.CrearClub(nuevoClub);
        datosGerenteDAO.actualizarGerente((DatosGerente) ger);
    }

    public void getCambiaClub(Object club, Object ger, String nomina, String IRPF) throws SQLException 
    {
        //Actualizamos el gerente del club anterior
        for(DatosGerente i:datosGerenteDAO.getGerentes())
        {
            //Cambiamos el club del gerente anterior a null
            if(((DatosClub) club).getNombre().equals(i.getClubActual()))
            {
                datosGerenteDAO.guardarHistorialGer(i);
                i.setClubActual(null);
                i.setNomina(Float.parseFloat("0"));
                i.setIRPF(Float.parseFloat("0"));
                datosGerenteDAO.actualizarGerente(i);
            }
        }
        //Actualizamos el gerente nuevo
        datosGerenteDAO.guardarHistorialGer((DatosGerente) ger);
        ((DatosGerente) ger).setClubActual(((DatosClub) club).getNombre());
        ((DatosGerente) ger).setNomina(Float.parseFloat(nomina));
        ((DatosGerente) ger).setIRPF(Float.parseFloat(IRPF));
        datosGerenteDAO.actualizarGerente((DatosGerente) ger);
    }

    public Iterable<String> getFederaciones() throws SQLException 
    {
        return datosClubDAO.getFederaciones();
    }

    public boolean gerDelClub(Object gere, Object club) 
    {
        boolean pertenece = false;

        if(((DatosGerente) gere).getClubActual().equals(((DatosClub) club).getNombre()))
                pertenece = true;
        
        return pertenece;
        
    }

    public ArrayList<String> getHistClub(Object gerente) throws SQLException {
        return datosGerenteDAO.getHistClub((DatosGerente) gerente);
    }

    public ArrayList<String> getHistNomina(Object gerente) throws SQLException {
        return datosGerenteDAO.getHistNomina((DatosGerente) gerente);
    }

    public ArrayList<String> getHistIRPF(Object gerente) throws SQLException {
        return datosGerenteDAO.getHistIRPF((DatosGerente) gerente);
    }
    
    public void eliminarClub(Object club) throws SQLException
    {
        /*  Buscamos al gerente del club y cambiamos su club actual a "null"    *
        *   y guardamos en su historial la infromación del club al queperteneció*/
        for(DatosGerente g:this.getGerentesConClub())
        {
            if(g.getClubActual().equals(((DatosClub) club).getNombre()))
            {
                datosGerenteDAO.guardarHistorialGer(g);
                g.setClubActual(null);
                g.setNomina(Float.parseFloat("0"));
                g.setIRPF(Float.parseFloat("0"));
                datosGerenteDAO.actualizarGerente(g);
            }
        }
        //Eliminamos el club
        datosClubDAO.eliminarClub(((DatosClub) club));
    }
    
    public boolean jugClubRepe(String usuario, Object club)
    {
        return (datosJugadorDAO.obtenerClubDeUsuario(usuario) != null 
                && datosJugadorDAO.obtenerClubDeUsuario(usuario).equals(((DatosClub) club).getNombre()));
    }

    public void apuntarJugEquipo(String usuario, Object club) throws SQLException {
        datosJugadorDAO.actualizarClubJugador(usuario, ((DatosClub)club).getNombre());
    }
}
