/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author areba
 */
public class AppAjedrez {
    
    ArrayList<Club> clubes;
    ArrayList<Gerente> gerentes;
    
    
    
    public ArrayList<Club> getClubs()
    {
        return clubes;
    }
    

    public void crearClub(String nombre, String sede, String nComGerente) 
    {
        Club newClub = null;
       
       for(Gerente g:gerentes)
            if(g.getnCompleto() == nComGerente)
            {
                clubes.add(newClub = new Club(nombre,null,sede,g,null,null));
                g.setClubActual(newClub);
            }
            else
                System.out.println("Error. El nombre completo del gerente no se encuentra");
       
        System.out.println("Club creado: " + newClub.toString());
    }
    
    public ArrayList<String> getGerentesLibres()
    {
        ArrayList<String> gerentesLibres = null;
        for(int i = 0; i < gerentes.size(); i++)
            if(gerentes.get(i).getClubActual() == null)
                gerentesLibres.add(gerentes.get(i).getnCompleto());
        return gerentesLibres;
    }

    public ArrayList<Gerente> getGerentes() 
    {
        return gerentes;
    }
    
    public void crearGerentePrueba()
    {
        gerentes.add(new Gerente("Pepe","Media Villa",55,"H", Float.parseFloat("2500.0"), Float.parseFloat("0.5"), null, null, null));
    }
    
}
