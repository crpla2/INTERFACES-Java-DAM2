/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DAM2Alu10
 */
public class ListaHoras {

    private ArrayList<Hora> lista;

    public ListaHoras() {
        lista = new ArrayList<Hora>();
    }

    public void setHora(Hora h) {
        lista.add(h);
    }

    public Hora getHora(int h) {
        return lista.get(h);

    }
   
    public void borraHora(int h) {
        lista.remove(h);
    }

    public int buscaHora(int dia,int hora){
        int posicion=0;
        for(Hora h :lista){
            if(h.getDia()==dia&&h.getHora()==hora)
                    posicion=lista.indexOf(h);
        }
        return posicion;
    }
    
    public int tamanyo() {
        return lista.size();
    }

    public void imprime() {
        for (Hora h : lista) {
            System.out.println(h.toString());
        }
    }

}
