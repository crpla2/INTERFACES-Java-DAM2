/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicaNegocio;

import java.util.Date;

/**
 *
 * @author carlo
 */
public class Vehiculo {

    private String matricula;
    private String marca;
    private String modelo;
    private String tipo;
    private String ClienteDni;

    public static final String TIPO_TURISMO = "TURISMO";
    public static final String TIPO_FURGONETA = "FURGONETA";
    public static final String TIPO_MOTOCICLETA = "MOTOCICLETA";
    private boolean enReparacion;

    public Vehiculo(String matricula,String marca, String modelo, String tipo, boolean enReparacion,String clienteDni) {

        this.matricula = matricula;
         this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.enReparacion = enReparacion;
        this.ClienteDni=clienteDni;
    }
    
    

    public void setClienteDni(String ClienteDni) {
        this.ClienteDni = ClienteDni;
    }

    public String getClienteDni() {
        return ClienteDni;
    }
    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String modelo) {
        this.modelo = marca;
    }
    
    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public boolean getEnReparacion() {
        return this.enReparacion;
    }

    public void setEnReparacion(boolean enReparacion) {
        this.enReparacion = enReparacion;
    }
}
