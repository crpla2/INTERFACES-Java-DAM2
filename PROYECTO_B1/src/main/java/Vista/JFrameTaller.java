package Vista;

import java.awt.Color;
import static java.awt.Color.black;
import static java.awt.Color.white;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import logicaNegocio.Acceso;
import logicaNegocio.Taller;
import logicaNegocio.Usuario;
import logicaNegocio.Vehiculo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author carlo
 */
public class JFrameTaller extends javax.swing.JFrame {

    int mecaN;
    Taller taller;
    boolean dia = true;
    JDialogClientes jdc;
    JDialogReparaciones jdr;
    JDialogVehiculos jdv;
    ImageIcon imagen, imagen2, imagen3, imagen4, imagen5, imagen6, imagen7, imagen8;
    ArrayList<ImageIcon> listaimagenes;
    ArrayList<JLabel> listaJLabel;
    Acceso acceso;

    /**
     * Creates new form JFrameTaller
     */
    public JFrameTaller(Acceso acceso) {
        super("TALLERES FITIPALDI");
        initComponents();
        this.acceso = acceso;
        taller = new Taller();
        taller.addVehiculo("2112JFK", "SEAT", "IBIZA", Vehiculo.TIPO_TURISMO, false, "18048688C");
        taller.addVehiculo("0004PKK", "VOLVO", "S40", Vehiculo.TIPO_TURISMO, false, "18048677P");
        taller.addVehiculo("1234YFK", "AUDI", "A8", Vehiculo.TIPO_TURISMO, true, "38048655H");
        taller.addVehiculo("4004PKD", "VOLKSWAGEN", "GOLF", Vehiculo.TIPO_TURISMO, false, "18048677P");
        taller.addVehiculo("2012JJK", "RENAULT", "TWINGO", Vehiculo.TIPO_TURISMO, true, "42548677M");
        taller.addVehiculo("0006PLK", "BMW", "SERIE3", Vehiculo.TIPO_TURISMO, true, "38048655H");
        taller.addCliente("Rodrigo Pla", "Carlos", "Calle MiCalle 2", "18048688C", "974243494");
        taller.addCliente("Saez Santamaría", "Soralla", "Calle SuCalle 2", "18048677P", "914243494");
        taller.addCliente("Sanchez Castejón", "Pedro", "La Moncloa 12", "38048655H", "914243666");
        taller.addCliente("Nuñez Feijoo", "Alberto", "Calle PaTuCasa 28", "42548677M", "91425566");

        taller.addParte(taller.getCodigoParteReparacion(), "38048655H", "1234YFK", getDateFormat("20/08/2022"), true, 4, 6, getDateFormat("25/08/2022"), 850, "Filtro antipartículas", 2);
        taller.addParte(taller.getCodigoParteReparacion(), "38048655H", "0006PLK", getDateFormat("18/11/2022"), true, 4, 5, getDateFormat("21/11/2022"), 1500, "Embrague", 2);
        taller.addParte(taller.getCodigoParteReparacion(), "38048655H", "0006PLK", getDateFormat("18/11/2022"), true, 4, 5, getDateFormat("21/11/2022"), 1000, "Turbo", 2);
        taller.addParte(taller.getCodigoParteReparacion(), "18048677P", "4004PKD", getDateFormat("19/11/2022"), false, 4, 0, getDateFormat("03/03/0003"), 500, "Cadena de distribución", 1);
        taller.addParte(taller.getCodigoParteReparacion(), "18048677P", "0004PKK", getDateFormat("20/11/2022"), false, 4, 0, getDateFormat("03/03/0003"), 100, "Cambio de ruedas", 1);
        taller.addParte(taller.getCodigoParteReparacion(), "18048688C", "2112JFK", getDateFormat("21/11/2022"), false, 4, 0, getDateFormat("03/03/0003"), 700, "Junta de la trocola", 1);
        taller.addParte(taller.getCodigoParteReparacion(), "42548677M", "2012JJK", getDateFormat("21/11/2022"), false, 4, 0, getDateFormat("03/03/0003"), 1000, "Turbo", 1);
        taller.addParte(taller.getCodigoParteReparacion(), "42548677M", "2012JJK", getDateFormat("21/11/2022"), false, 4, 0, getDateFormat("03/03/0003"), 850, "Filtro antipartículas", 1);
       
    //Cambiamos el icono de la ventana
        setIconImage(new ImageIcon("img/logo.png").getImage());
        //Añadimos las imagenes a una lista
        listaimagenes = new ArrayList<>();
        listaimagenes.add(new ImageIcon("img/claro.jpg"));
        listaimagenes.add(new ImageIcon("img/centro.png"));
        listaimagenes.add(new ImageIcon("img/rueda.png"));
        listaimagenes.add(new ImageIcon("img/clientes.png"));
        listaimagenes.add(new ImageIcon("img/vehiculos.png"));
        listaimagenes.add(new ImageIcon("img/reparaciones.png"));
        //
        listaimagenes.add(new ImageIcon("img/oscuro.jpg"));
        listaimagenes.add(new ImageIcon("img/solluna.png"));
        //Añadimos los jlabel a una lista
        listaJLabel = new ArrayList<>();
        listaJLabel.add(jLabelFondo);
        listaJLabel.add(jLabelImagen);
        listaJLabel.add(jLabelRueda1);
        listaJLabel.add(jLabelBotonClientes);
        listaJLabel.add(jLabelBotonVehiculos);
        listaJLabel.add(jLabelBotonReparaciones);
        for (int i = 0; i < listaJLabel.size(); i++) {
            listaJLabel.get(i).setIcon(listaimagenes.get(i));
            listaJLabel.get(i).setBounds(150, 150, listaimagenes.get(i).getIconWidth(), listaimagenes.get(i).getIconHeight());
        }
        jLabelRueda2.setIcon(listaimagenes.get(2));
        jLabelRueda2.setBounds(150, 150, listaimagenes.get(2).getIconWidth(), listaimagenes.get(2).getIconHeight());
        jToggleButtonDiaNoche.setIcon(listaimagenes.get(7));
        jToggleButtonDiaNoche.setBounds(150, 150, listaimagenes.get(7).getIconWidth(), listaimagenes.get(7).getIconHeight());

        if (acceso.getUsuarioIdentificado().getMecanico() > 0) {
            jLabelBotonClientes.setVisible(false);
            jLabelBotonVehiculos.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToggleButtonDiaNoche = new javax.swing.JToggleButton();
        jPanelTitulo = new javax.swing.JPanel();
        jLabelRueda1 = new javax.swing.JLabel();
        jLabelTitulo1 = new javax.swing.JLabel();
        jLabelTitulo2 = new javax.swing.JLabel();
        jLabelRueda2 = new javax.swing.JLabel();
        jPanelBotones = new javax.swing.JPanel();
        jLabelBotonClientes = new javax.swing.JLabel();
        jLabelBotonReparaciones = new javax.swing.JLabel();
        jLabelBotonVehiculos = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabelImagen = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setResizable(false);

        jPanel1.setMaximumSize(new java.awt.Dimension(600, 400));
        jPanel1.setMinimumSize(new java.awt.Dimension(600, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToggleButtonDiaNoche.setAlignmentY(0.0F);
        jToggleButtonDiaNoche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonDiaNocheActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButtonDiaNoche, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, 50, 50));

        jPanelTitulo.setOpaque(false);
        jPanelTitulo.setLayout(new java.awt.GridLayout(1, 0));

        jLabelRueda1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanelTitulo.add(jLabelRueda1);

        jLabelTitulo1.setFont(new java.awt.Font("Rockwell Condensed", 1, 36)); // NOI18N
        jLabelTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo1.setText("Talleres");
        jPanelTitulo.add(jLabelTitulo1);

        jLabelTitulo2.setFont(new java.awt.Font("Rockwell Condensed", 1, 36)); // NOI18N
        jLabelTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo2.setText("Fitipaldi");
        jPanelTitulo.add(jLabelTitulo2);

        jLabelRueda2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanelTitulo.add(jLabelRueda2);

        jPanel1.add(jPanelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 600, 60));

        jPanelBotones.setOpaque(false);
        jPanelBotones.setLayout(new java.awt.GridLayout(1, 0));

        jLabelBotonClientes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelBotonClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBotonClientesMouseClicked(evt);
            }
        });
        jPanelBotones.add(jLabelBotonClientes);

        jLabelBotonReparaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBotonReparaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBotonReparacionesMouseClicked(evt);
            }
        });
        jPanelBotones.add(jLabelBotonReparaciones);

        jLabelBotonVehiculos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelBotonVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBotonVehiculosMouseClicked(evt);
            }
        });
        jPanelBotones.add(jLabelBotonVehiculos);

        jPanel1.add(jPanelBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 350, 80));

        jSeparator3.setBackground(new java.awt.Color(204, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(255, 0, 0));
        jSeparator3.setOpaque(true);
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 600, -1));

        jSeparator4.setBackground(new java.awt.Color(204, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(255, 0, 0));
        jSeparator4.setOpaque(true);
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 600, -1));
        jPanel1.add(jLabelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 260, 200));

        jLabelFondo.setOpaque(true);
        jPanel1.add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
void setMecaN(int i) {
        this.mecaN = i;
    }

    public static Date getDateFormat(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formatter.parse(date);
        } catch (ParseException ex) {
            return null;
        }
    }

    public static String getStringFormat(Date d) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(d);
    }

    private void jLabelBotonClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBotonClientesMouseClicked
        jdc = new JDialogClientes(this, true);
        jdc.setVisible(true);
    }//GEN-LAST:event_jLabelBotonClientesMouseClicked

    private void jLabelBotonReparacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBotonReparacionesMouseClicked
        jdr = new JDialogReparaciones(this, true);
        jdr.setVisible(true);
    }//GEN-LAST:event_jLabelBotonReparacionesMouseClicked

    private void jLabelBotonVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBotonVehiculosMouseClicked
        jdv = new JDialogVehiculos(this, true);
        jdv.setVisible(true);
    }//GEN-LAST:event_jLabelBotonVehiculosMouseClicked

    private void jToggleButtonDiaNocheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonDiaNocheActionPerformed
        if (jToggleButtonDiaNoche.isSelected()) {
            listaJLabel.get(0).setIcon(listaimagenes.get(6));
            listaJLabel.get(0).setBounds(150, 150, listaimagenes.get(6).getIconWidth(), listaimagenes.get(6).getIconHeight());
            jLabelTitulo1.setForeground(white);
            jLabelTitulo2.setForeground(white);
            dia = false;
        } else {
            listaJLabel.get(0).setIcon(listaimagenes.get(0));
            listaJLabel.get(0).setBounds(150, 150, listaimagenes.get(0).getIconWidth(), listaimagenes.get(0).getIconHeight());
            jLabelTitulo1.setForeground(black);
            jLabelTitulo2.setForeground(black);
            dia = true;

        }
    }//GEN-LAST:event_jToggleButtonDiaNocheActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelBotonClientes;
    private javax.swing.JLabel jLabelBotonReparaciones;
    private javax.swing.JLabel jLabelBotonVehiculos;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JLabel jLabelRueda1;
    private javax.swing.JLabel jLabelRueda2;
    private javax.swing.JLabel jLabelTitulo1;
    private javax.swing.JLabel jLabelTitulo2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JToggleButton jToggleButtonDiaNoche;
    // End of variables declaration//GEN-END:variables

}
