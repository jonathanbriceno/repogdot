/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupodotApp;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Jonathan Briceno
 * 
 */
@ManagedBean(name= "cotizacionMB" )
@SessionScoped
public class CotizacionMB {
    
    private double valorCotizacion;
    
    
    @EJB
    private Cotizador cotizador;
    private boolean renderizarCandidato = false;
    private String nombreSocio;

   
  @PostConstruct
  public void  init(){
  System.out.println("Inicializacion de variables");
  this.renderizarCandidato = false;
  }

    
    /*Metodos*/
    
    public void calcularCotizacion(){
        System.out.println(renderizarCandidato);
         
        if (valorCotizacion > 100) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dimelo " + 
                    cotizador.consultarSocios(valorCotizacion)));
             this.renderizarCandidato = false;
        }else {
        this.renderizarCandidato = true;
        this.nombreSocio = "Socio";
        }
    
    }
    
    /*Getters y Setters*/
    public double getValorCotizacion() {
        return valorCotizacion;
    }

    public void setValorCotizacion(double valorCotizacion) {
        this.valorCotizacion = valorCotizacion;
    }
    
       public void setRenderizarCandidato(boolean renderizarCandidato) {
        this.renderizarCandidato = renderizarCandidato;
    }

    public void setNombreSocio(String nombreSocio) {
        this.nombreSocio = nombreSocio;
    }

    public boolean isRenderizarCandidato() {
        return renderizarCandidato;
    }

    public String getNombreSocio() {
        return nombreSocio;
    }
    
    
    
}
