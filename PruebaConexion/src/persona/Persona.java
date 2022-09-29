/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona;
/**
 *
 * @author DAM2Alu10
 */
public class Persona {
    String nombre;
    Integer edad;
    String mail;
    public Persona(){
        
    }
    public Persona(String persona,Integer edad,String mail){
        this.nombre=persona;
        this.edad=edad;
        this.mail=mail;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getNombre(){
            return nombre;}

    public Integer getEdad() {
        return edad;
    }
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    public String getMail() {
        return mail;
    } 
    public void setMail(String mail) {
        this.mail = mail;
    }
    
}
