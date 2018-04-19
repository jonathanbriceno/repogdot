package com.grupodotApp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Jonathan Briceno
 */

@Stateless
@LocalBean
public class Cotizador {
    
    public String consultarSocios(double valorCotizacion){
    
    return "llamar al servicio";
            
            }
    
}
