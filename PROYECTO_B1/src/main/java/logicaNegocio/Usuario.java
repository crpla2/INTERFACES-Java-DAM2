/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicaNegocio;

/**
 *
 * @author carlo
 */
public class Usuario {
    String usuario;
    String password;
    int mecanico;

    public Usuario(String usuario, String password, int mecanico) {
        this.usuario = usuario;
        this.password = password;
        this.mecanico = mecanico;
    }

  
    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public int getMecanico() {
        return mecanico;
    }

}