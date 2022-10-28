/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehiculos;

import java.util.Date;

/**
 *
 * @author DAM2Alu10
 */

public class Vehiculo {
    private String nombre;
    private String apellidos;
    private String telefono;
    private Date fechaEntrada;
    private String dni;
    private String modelo;
    private String matricula;

    public Vehiculo() {
    }
    public Vehiculo(String nombre, String apellidos, String telefono, Date fechaEntrada, String dni, String modelo, String matricula) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.fechaEntrada = fechaEntrada;
        this.dni = dni;
        this.modelo = modelo;
        this.matricula = matricula;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
        return dni;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return super.toString(); 
    }

    
    
    
   
    
  

    
}

