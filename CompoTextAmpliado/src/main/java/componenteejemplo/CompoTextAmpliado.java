/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componenteejemplo;

import java.awt.Color;
import java.io.Serializable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author DAM2Alu10
 */
public class CompoTextAmpliado extends JTextField implements Serializable {

    private ClaseDosColores colores;
    private int numCaracteres;
    private ClaseDosColores defecto;

    public CompoTextAmpliado() {
        super();
        //Salvamos el color que tenía el componente por defecto
        defecto= new ClaseDosColores(getBackground(),getForeground());
        
        super.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                analizaContenido();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                analizaContenido();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                analizaContenido();
            }

            private void analizaContenido() {
                if (getText().length() >= numCaracteres && colores != null) {
                    setBackground(colores.getColorFondo());
                    setForeground(colores.getColorTexto());
                } else {
                    setBackground(defecto.getColorFondo());
                    setForeground(defecto.getColorTexto());
                }
            }
        });
    }

    public ClaseDosColores getColores() {
        return colores;
    }

    public void setColores(ClaseDosColores colores) {
        this.colores = colores;
    }

    public int getNumCaracteres() {
        return numCaracteres;
    }

    public void setNumCaracteres(int numCaracteres) {
        this.numCaracteres = numCaracteres;
    }
}
