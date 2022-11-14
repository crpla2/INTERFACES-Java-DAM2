/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.Date;

/**
 *
 * @author DAM2Alu10
 */
public class Hora {
    private int hora;
    private int dia;
    private String modulo;
    private Date fechaAlta;

    public Hora() {
    }

    public Hora(int hora, int dia, String modulo, Date fechaAlta) {
        this.hora = hora;
        this.dia = dia;
        this.modulo = modulo;
        this.fechaAlta = fechaAlta;
    }

    public int getDia() {
        return dia;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public int getHora() {
        return hora;
    }

    public String getModulo() {
        return modulo;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    @Override
    public String toString() {
        return "Hora: "+hora+" Día: "+dia+ " Módulo: "+modulo+" Alta: "+fechaAlta.toString(); 
    }
    
    
}
