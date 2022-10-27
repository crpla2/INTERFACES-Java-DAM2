/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conversordivisas;

import java.text.DecimalFormat;

/**
 *
 * @author DAM2Alu10
 */
public class Divisa {

    private String nombre;
    private String valor;

    public Divisa() {
    }

    public Divisa(String nombre, String valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String aEuros(String cantidad) {
        String resultado;
        DecimalFormat df = new DecimalFormat("0.00");
        resultado = df.format(Double.parseDouble(cantidad) * Double.parseDouble(valor));

        return resultado;
    }

    public String deEuros(String cantidad) {
        String resultado;
        DecimalFormat df = new DecimalFormat("0.00");
        resultado = df.format(Double.parseDouble(cantidad) / Double.parseDouble(valor));

        return resultado;
    }

    @Override
    public String toString() {
        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
