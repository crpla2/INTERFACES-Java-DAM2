/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Vista;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import jdk.tools.jlink.resources.jlink;
import logicaNegocio.ParteReparacion;
import logicaNegocio.Taller;
import logicaNegocio.Vehiculo;

/**
 *
 * @author DAM2Alu10
 */
public class JDialogFORMreparacionActualizar extends javax.swing.JDialog {
    Taller taller;
    Vehiculo vehiculo;
    JDialogReparaciones jd;
    JFrameTaller jf;
    Boolean dia;
    ArrayList<JLabel> lista;
    DefaultComboBoxModel dom1;
    ParteReparacion parte;
    int codigo;

    /**
     * Creates new form JDialogFORMvehiculo
     */
    public JDialogFORMreparacionActualizar(java.awt.Dialog parent, boolean modal) {
        super(parent, "ACTUALIZA ", false);
        jd = (JDialogReparaciones) parent;
        initComponents();
        taller=jd.taller;
        dia = jd.dia;
        jLabelIcono.setIcon(new ImageIcon("img/actualizar.png"));
        jLabelBotonCancelar.setIcon(new ImageIcon("img/cancelar.png"));
        jLabelBotonGuardar.setIcon(new ImageIcon("img/guardar.png"));
        codigo=jd.codigo;

        lista = new ArrayList<>();
        lista.add(jLabelTitulo1);
        lista.add(jLabelTitulo2);
        lista.add(jLabelFecha);
        lista.add(jLabelhoras);
        lista.add(jLabelMatricula);
        lista.add(jLabelMecanico);
        lista.add(jLabelcodigo);
        lista.add(jLabelAveria);      
        if (dia) {
            jPanelFondo.setBackground(Color.lightGray);
            lista.forEach(x -> x.setForeground(Color.black));

        } else {
            jPanelFondo.setBackground(Color.darkGray);
            lista.forEach(x -> x.setForeground(Color.white));
        }
        
         parte= taller.getParte(codigo);
        
        jLabelcodigo.setText("NÚMERO DE PARTE: "+codigo);
        jLabelMecanico.setText("MECANICO: "+parte.getMecanico());
        jLabelMatricula.setText("VEHICULO: "+parte.getMatriculaVehiculo());
        jLabelAveria.setText("AVERIA: "+parte.getTipoAveria());
        jSpinnerHoras.setValue(parte.getHorasEstimadas());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFondo = new javax.swing.JPanel();
        jPanelBotones = new javax.swing.JPanel();
        jLabelBotonGuardar = new javax.swing.JLabel();
        jLabelBotonCancelar = new javax.swing.JLabel();
        jPanelTitulo = new javax.swing.JPanel();
        jLabelIcono = new javax.swing.JLabel();
        jLabelTitulo1 = new javax.swing.JLabel();
        jLabelTitulo2 = new javax.swing.JLabel();
        jPanelInsercion = new javax.swing.JPanel();
        jLabelcodigo = new javax.swing.JLabel();
        jLabelMecanico = new javax.swing.JLabel();
        jLabelMatricula = new javax.swing.JLabel();
        jLabelAveria = new javax.swing.JLabel();
        jLabelFecha = new javax.swing.JLabel();
        jSpinnerFecha = new javax.swing.JSpinner();
        jLabelhoras = new javax.swing.JLabel();
        jSpinnerHoras = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 200));
        setResizable(false);

        jPanelFondo.setPreferredSize(new java.awt.Dimension(500, 268));

        jPanelBotones.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelBotones.setOpaque(false);
        jPanelBotones.setLayout(new java.awt.GridLayout(1, 0));

        jLabelBotonGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBotonGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBotonGuardarMouseClicked(evt);
            }
        });
        jPanelBotones.add(jLabelBotonGuardar);

        jLabelBotonCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBotonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBotonCancelarMouseClicked(evt);
            }
        });
        jPanelBotones.add(jLabelBotonCancelar);

        jPanelTitulo.setOpaque(false);
        jPanelTitulo.setLayout(new java.awt.GridLayout(1, 0));

        jLabelIcono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanelTitulo.add(jLabelIcono);

        jLabelTitulo1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTitulo1.setText("FIN REPARACIÓN");
        jPanelTitulo.add(jLabelTitulo1);

        jLabelTitulo2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jPanelTitulo.add(jLabelTitulo2);

        jPanelInsercion.setOpaque(false);
        jPanelInsercion.setLayout(new java.awt.GridLayout(2, 4));
        jPanelInsercion.add(jLabelcodigo);
        jPanelInsercion.add(jLabelMecanico);
        jPanelInsercion.add(jLabelMatricula);
        jPanelInsercion.add(jLabelAveria);

        jLabelFecha.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelFecha.setText("  FECHA:");
        jPanelInsercion.add(jLabelFecha);

        jSpinnerFecha.setModel(new javax.swing.SpinnerDateModel());
        jSpinnerFecha.setEditor(new javax.swing.JSpinner.DateEditor(jSpinnerFecha, "dd/MM/yyyy"));
        jPanelInsercion.add(jSpinnerFecha);

        jLabelhoras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelhoras.setText("  HORAS:");
        jPanelInsercion.add(jLabelhoras);

        jSpinnerHoras.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jPanelInsercion.add(jSpinnerHoras);

        javax.swing.GroupLayout jPanelFondoLayout = new javax.swing.GroupLayout(jPanelFondo);
        jPanelFondo.setLayout(jPanelFondoLayout);
        jPanelFondoLayout.setHorizontalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 642, Short.MAX_VALUE)
            .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoLayout.createSequentialGroup()
                    .addContainerGap(176, Short.MAX_VALUE)
                    .addComponent(jPanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(171, 171, 171)))
            .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelFondoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 488, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelFondoLayout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addComponent(jPanelInsercion, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(32, Short.MAX_VALUE)))
        );
        jPanelFondoLayout.setVerticalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoLayout.createSequentialGroup()
                    .addContainerGap(227, Short.MAX_VALUE)
                    .addComponent(jPanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelFondoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(202, Short.MAX_VALUE)))
            .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelFondoLayout.createSequentialGroup()
                    .addGap(116, 116, 116)
                    .addComponent(jPanelInsercion, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(118, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelBotonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBotonGuardarMouseClicked
        guardar();
        jd.actualiza();
        this.dispose();
    }//GEN-LAST:event_jLabelBotonGuardarMouseClicked

    private void jLabelBotonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBotonCancelarMouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabelBotonCancelarMouseClicked
    
    private void guardar() {
       for(ParteReparacion p: taller.getTodosParte()){
           if(p.getCodigo()==parte.getCodigo()){
               p.setEstadoReparacion(true);
               p.setFechaSalida((Date)jSpinnerFecha.getValue());
               p.setHorasReales((int)jSpinnerHoras.getValue());
           }
       }
      
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelAveria;
    private javax.swing.JLabel jLabelBotonCancelar;
    private javax.swing.JLabel jLabelBotonGuardar;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelIcono;
    private javax.swing.JLabel jLabelMatricula;
    private javax.swing.JLabel jLabelMecanico;
    private javax.swing.JLabel jLabelTitulo1;
    private javax.swing.JLabel jLabelTitulo2;
    private javax.swing.JLabel jLabelcodigo;
    private javax.swing.JLabel jLabelhoras;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JPanel jPanelInsercion;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JSpinner jSpinnerFecha;
    private javax.swing.JSpinner jSpinnerHoras;
    // End of variables declaration//GEN-END:variables

}