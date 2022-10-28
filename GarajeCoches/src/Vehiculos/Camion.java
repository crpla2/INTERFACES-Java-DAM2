package Vehiculos;

import java.util.Date;

/**
 *
 * @author DAM2Alu10
 */
public class Camion extends Vehiculo {
    private double longitud;
    private  boolean adr;

    public Camion(double longitud, boolean adr, String nombre, String apellidos, String telefono, Date fechaEntrada, String dni, String modelo, String matricula) {
        super(nombre, apellidos, telefono, fechaEntrada, dni, modelo, matricula);
        this.longitud = longitud;
        this.adr = adr;
    } 

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
    
    public double getLongitud(){
        return this.longitud;
    }
    
    public void setAdr(boolean adr) {
        this.adr = adr;
    }

    public boolean isAdr() {
        return adr;
    }

    @Override
    public String toString() {
        return super.toString(); 
    }

    
    
}
