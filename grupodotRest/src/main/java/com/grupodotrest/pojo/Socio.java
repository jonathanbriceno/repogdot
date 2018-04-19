/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupodotrest.pojo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonathan Briceno
 */
@XmlRootElement
public class Socio {

    private int id; 
    private String nombre; 
    private double tasa; 
    private double montoMaximo; 
    private double cuotaMensual;
    private double pagoTotal;
    private double tasaMensual;

    public double getCuotaMensual() {
        return cuotaMensual;
    }

    public void setCuotaMensual(double cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }

    public double getPagoTotal() {
        return pagoTotal;
    }

    public void setPagoTotal(double pagoTotal) {
        this.pagoTotal = pagoTotal;
    }

    public double getTasaMensual() {
        return tasaMensual;
    }

    public void setTasaMensual(double tasaMensual) {
        this.tasaMensual = tasaMensual;
    }
  
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    public void setMontoMaximo(double montoMaximo) {
        this.montoMaximo = montoMaximo;
    }

  
    
      public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTasa() {
        return tasa;
    }

    public double getMontoMaximo() {
        return montoMaximo;
    }
    
    
}
