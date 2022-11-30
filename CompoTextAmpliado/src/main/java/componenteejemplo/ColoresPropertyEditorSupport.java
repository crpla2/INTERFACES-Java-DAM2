/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componenteejemplo;

import java.awt.Color;
import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author DAM2Alu10
 */
public class ColoresPropertyEditorSupport extends PropertyEditorSupport {

    private ColoresPanel coloresPanel = new ColoresPanel();

    @Override
    public boolean supportsCustomEditor() {
        return true;
    }

    @Override
    public Component getCustomEditor() {
        return coloresPanel;
    }

    @Override
    public Object getValue() {
        return coloresPanel.getPropiedadSeleccionada(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getJavaInitializationString() {
        Color colorFondo = coloresPanel.getPropiedadSeleccionada().getColorFondo();
        Color colorTexto = coloresPanel.getPropiedadSeleccionada().getColorTexto();
        return "new componenteejemplo.ClaseDosColores(new java.awt.Color("
                + colorFondo.getRGB() + "),new java.awt.Color(" + colorTexto.getRGB() + "))";
    }
}
