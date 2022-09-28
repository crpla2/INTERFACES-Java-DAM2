/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package holanetbeans;

import java.util.Date;

/**
 *
 * @author DAM2Alu10
 */
public class HolaNetbeans {
    /**
     * @param args the command line arguments
     */
    static Nombre miNombre=new Nombre();
   
    
     public static void main(String[] args) {
        // TODO code application logic here
     Date fecha= new Date();
     miNombre.setNombre("Carlos");
        System.out.println("Saludando a "+ miNombre.getNombre()+ " hoy es "+ fecha.toString());
      
    }
    
}
