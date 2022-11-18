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
    private char tipo;
    public static final char TIPO_TURISMO = 't';
    public static final char TIPO_FURGONETA = 'f';
    public static final char TIPO_MOTOCICLETA = 'm';
    private boolean enReparacion;

    public Vehiculo(String matricula, String modelo, char tipo, boolean enReparacion) {

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

    public char getTipo() {
        return this.tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }


    public boolean getEnReparacion() {
        return this.enReparacion;
    }

    public void setEnReparacion(boolean enReparacion) {
        this.enReparacion = enReparacion;
    }
}
