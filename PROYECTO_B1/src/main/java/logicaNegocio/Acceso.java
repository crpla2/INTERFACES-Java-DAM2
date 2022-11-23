/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicaNegocio;

import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class Acceso {
    private ArrayList<Usuario> lista;
private ArrayList<Usuario> identificado;
    public Acceso() {
       lista= new ArrayList<>();
         identificado =new ArrayList<Usuario>();
    }
    public void addUsuario(Usuario u){
        lista.add(u);
    }
    public Usuario getUsuario(String usuario){
        for(Usuario u:lista)
            if (u.getUsuario().equals(usuario))
                    return u;
        return null;
    }
    
    public void setAcceso(Usuario u){
        
        identificado.add(u);
       
    }
    public Usuario getUsuarioIdentificado(){
       return identificado.get(0);
    }
}
