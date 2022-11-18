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
class Vehiculo {

    private String matricula;
    private String modelo;
    private String tipo;
    public static final String TIPO_TURISMO = "Turismo";
    public static final String TIPO_FURGONETA = "Furgoneta";
    public static final String TIPO_MOTOCICLETA = "Motocicleta";
    private boolean enReparacion;

    public Vehiculo(String matricula, String modelo, String tipo, boolean enReparacion) {

        this.matricula = matricula;
        this.modelo = modelo;
        this.tipo = tipo;
        this.enReparacion = enReparacion;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
