/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Vista;

import java.awt.Color;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import logicaNegocio.Cliente;
import logicaNegocio.ParteReparacion;
import logicaNegocio.Taller;
import logicaNegocio.Vehiculo;

/**
 *
 * @author carlo
 */
public class jDialogPresupuesto extends javax.swing.JDialog {
    
    boolean dia;
    JDialogReparaciones jd;
    TableModel dtm;
    JTable jt;
    Taller taller;
    String imprime;
    TableRowSorter<TableModel> order;

    /**
     * Creates new form jDialogPresupuesto
     */
    public jDialogPresupuesto(java.awt.Dialog parent, boolean modal) {
        super(parent, false);
        jd = (JDialogReparaciones) parent;
        initComponents();
        imprime = jd.imprime;
        System.out.println(imprime);
        jLabelTitulo.setText(imprime);
        taller = jd.taller;
        jLabelIcono.setIcon(new ImageIcon("img/factura.png"));
        jLabelImprimir.setIcon(new ImageIcon("img/impresora.png"));
        jLabelMail.setIcon(new ImageIcon("img/mail.png"));
        dia = jd.dia;
        if (dia) {
            jPanel1.setBackground(Color.lightGray);
            jPanel2.setBackground(Color.lightGray);
            jLabelTitulo.setForeground(Color.black);
        } else {
            jPanel1.setBackground(Color.darkGray);
            jPanel2.setBackground(Color.darkGray);
            jLabelTitulo.setForeground(Color.white);
        }
        jt = jd.jTableTabla;
        order = jd.order;
        dtm = order.getModel();
        Cliente c = taller.getCliente((String) jt.getValueAt(0, 2));
        Vehiculo v, v2;
        ArrayList<ParteReparacion> lista = new ArrayList<>();

        try {

            for (int i = 0; i < jt.getRowCount(); i++) {
                boolean b = true;
                if (jt.getValueAt(i, 5).equals("SI")) {
                    b = true;
                }
                int x;
                try {
                    x = Integer.parseInt((String) jt.getValueAt(i, 8));
                } catch (Exception e) {
                    x = 0;
                }
                ParteReparacion p = new ParteReparacion(
                        Integer.parseInt((String) jt.getValueAt(i, 0)),//codigo
                        (String) jt.getValueAt(i, 2),//DNI
                        (String) jt.getValueAt(i, 3),//MAtricula
                        JFrameTaller.getDateFormat((String) jt.getValueAt(i, 4)),//FEcha entrada                   
                        b,//estado reparacion
                        Integer.parseInt((String) jt.getValueAt(i, 7)),//horas estimadas
                        x,//horas reales
                        JFrameTaller.getDateFormat((String) jt.getValueAt(i, 6)),//FEcha salida
                        Double.parseDouble((String) jt.getValueAt(i, 10)),//precio   
                        (String) jt.getValueAt(i, 9),//averia
                        Integer.parseInt((String) jt.getValueAt(i, 1))//mecanico
                );
                lista.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String tablaCliente = ""
                + " <p>" + c.getApellidos() + ", " + c.getNombre() + "<br>" + c.getDni() + "<br>" + c.getDireccion() + "<br>" + c.getTelefono() + "</p>";
        String tablaVehiculo = "";
        String tituloCliente = "";
        String tablaReparacion = "";
        String mensaje = "";
        String fechaE = JFrameTaller.getStringFormat(lista.get(0).getFechaEntrada());
        String fechaS = "";
        try {
            fechaS = JFrameTaller.getStringFormat(lista.get(0).getFechaSalida());
        } catch (Exception e) {
            fechaS = "03/03/0003";
        }

        String fechaTabla = "";
        int i = 0;
        double total = 0;
        
            v2 = null;
            for (ParteReparacion p : lista) {
                v = taller.getVehiculo(p.getMatriculaVehiculo());
                if (i == 0) {
                    v2 = v;
                    tablaVehiculo += "<p>" + v.getMarca() + "<br>" + v.getModelo() + "<br>" + v.getTipo() + "<br>" + v.getMatricula() + "</p></td>";
                }
                if (i > 0) {
                    if (!v2.equals(v)) {
                        tituloCliente += "<td style=\"width:250px\"><strong>Vehículo</strong> </td>\n";
                        tablaVehiculo += " <td style=\"width:250px\"><p>" + v.getMarca() + "<br>" + v.getModelo() + "<br>" + v.getTipo() + "<br>" + v.getMatricula() + "</p></td>";
                        v2 = v;
                    }
                }
                if (imprime.equals("PRESUPUESTO")) {
                    if (JFrameTaller.getStringFormat(p.getFechaEntrada()).compareTo(fechaE) <= 0) {
                        fechaE = JFrameTaller.getStringFormat(p.getFechaEntrada());
                    }
                    tablaReparacion += ""
                            + "<tr>"
                            + "<td style=\"width:200px\">" + p.getMatriculaVehiculo() + "</td>"
                            + "<td style=\"width:200px\">" + p.getTipoAveria() + "</td>"
                            + "<td style=\"width:200px\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1</td>"
                            + "<td style=\"width:200px\">&nbsp;&nbsp;" + p.getCuantiaReparacion() + "</td> "
                            + "<td style=\"width:200px\">" + (p.getCuantiaReparacion() * 1) + "</td> "
                            + "</tr>"
                            + " <tr>"
                            + "<td style=\"width:200px\">" + p.getMatriculaVehiculo() + "</td>"
                            + "<td style=\"width:200px\">Mano de obra</th>"
                            + "<td style=\"width:200px\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + p.getHorasEstimadas() + "</th>"
                            + "<td style=\"width:200px\">&nbsp;&nbsp;50.0</th>"
                            + "<td style=\"width:200px\">" + (double) (p.getHorasEstimadas() * 50) + "</th>"
                            + " </tr>";
                    total += p.getCuantiaReparacion() + (p.getHorasEstimadas() * 50);
                    mensaje = "El documento representa una estimación del coste real. <br>Puede ser que el precio final difiera del estimado en este documento.<br> Si acepta el presupuesto será informado en caso de que la cuantía final exceda en un 20% de este presupuesto.";
                    fechaTabla = fechaE;

                } else {
                    if (JFrameTaller.getStringFormat(p.getFechaSalida()).compareTo(fechaS) >= 0) {
                        fechaS = JFrameTaller.getStringFormat(p.getFechaSalida());
                    }
                    tablaReparacion += ""
                            + "<tr>"
                            + "<td style=\"width:200px\">" + p.getMatriculaVehiculo() + "</td>"
                            + "<td style=\"width:200px\">" + p.getTipoAveria() + "</td>"
                            + "<td style=\"width:200px\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1</td>"
                            + "<td style=\"width:200px\">&nbsp;&nbsp;" + p.getCuantiaReparacion() + "</td> "
                            + "<td style=\"width:200px\">" + (p.getCuantiaReparacion() * 1) + "</td> "
                            + "</tr>"
                            + " <tr>"
                            + "<td style=\"width:200px\">" + p.getMatriculaVehiculo() + "</td>"
                            + "<td style=\"width:200px\">Mano de obra</th>"
                            + "<td style=\"width:200px\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + p.getHorasReales() + "</th>"
                            + "<td style=\"width:200px\">&nbsp;&nbsp;50.0</th>"
                            + "<td style=\"width:200px\">" + (double) (p.getHorasReales() * 50) + "</th>"
                            + " </tr>";
                    total += p.getCuantiaReparacion() + (p.getHorasReales() * 50);
                    mensaje = "Gracias por confiar en TALLERES FITIPALDI.<br>Ante cualquier duda o aclaración no dude en ponerse en contacto con nosotros a través de nuestro correo electronico: fitipaldi.oficina@timofonica.net";
                    fechaTabla = fechaS;
                }
                i++;
            }

      

        System.out.println(lista.size());
        String imgsrc = "";
        try {
            imgsrc = new File("img/logo.png").toURL().toExternalForm();
        } catch (MalformedURLException ex) {
            Logger.getLogger(jDialogPresupuesto.class.getName()).log(Level.SEVERE, null, ex);
        }
        jEditorPane1.setEditable(false);
        jEditorPane1.setContentType("text/html");
        jEditorPane1.setText(""
                + ""
                + "<!DOCTYPE html>\n"
                + "<html lang=\"es\">\n"
                + "\n"
                + "<head>\n"
                + "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\"\n"
                + "        integrity=\"sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu\" crossorigin=\"anonymous\">\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n"
                + "    <title>Factura</title>\n"
                + "</head>\n"
                + "\n"
                + "<body>\n"
                + "    <div class=\"container-fluid\">\n"
                + "        <div class=\"row\">\n"
                + "       <table>    "
                + "<tr>\n"
                + "                 <td style=\"width:250px\"> <img class=\"img img-responsive\" src='" + imgsrc + "' alt=\"Logotipo\"></td>\n"
                + "                 <td style=\"width:250px\"> </td>\n"
                + "                 <td style=\"width:250px\"> </td>\n"
                + "                 <td style=\"width:250px\"><strong>Fecha</strong>\n"
                + "               <br>\n"
                + "               " + fechaTabla + "<br>\n"
                + "               <strong>Factura No.</strong>\n"
                + "              <br>\n"
                + "               "+JFrameTaller.NºFac+"</td>\n"
                + "             </tr>\n"
                + "             <tr>\n"
                + "                 <td style=\"width:250px\">  <strong>TALLERES FITIPALDI S.L.</strong>\n"
                + "                               <p>CIF V16286213\n"
                + "                               <br>\n"
                + "                            Ronda de la industria 68, Huesca\n"
                + "                               <br>\n"
                + "                               974225544</p> </td>\n"
                + "                 <td style=\"width:250px\"> </td>\n"
                + "                 <td style=\"width:250px\"> </td>\n"
                + "                 <td style=\"width:250px\"></tr>\n"
                + "       </table>    "
                + "        </div>\n"
                + "                <h1><center>" + imprime + "</center></h1>\n"
                + "        <hr>\n"
                + "        <div class=\"row\">\n"
                + "           <div class=\"col-xs-6\">\n  "
                + "         <table> \n"
                + "             <tr>\n"
                + "                 <td style=\"width:450px\"><strong>Cliente</strong></td>\n"
                + "                 <td style=\"width:50px\"></td>\n"
                + "                 <td style=\"width:250px\"><strong>Vehículo</strong> </td>\n"
                + "                 " + tituloCliente + ""
                + "             </tr>\n"
                + "             <tr>\n"
                + "                  <td style=\"width:450px\">" + tablaCliente + "</td>\n"
                + "                  <td style=\"width:50px\"></td>\n"
                + "                 <td style=\"width:250px\">" + tablaVehiculo + "\n"
                + "             </tr>\n"
                + "         </table> \n"
                + "                \n"
                + "            </div>\n"
                + "        </div>\n"
                + "        <hr>\n"
                + "        <div class=\"row\">\n"
                + "                <strong>Reparaciones:</strong><br><br>"
                + "            <div class=\"col-xs-12\">\n"
                + "                <table class=\"table table-condensed table-bordered table-striped\">\n"
                + "                    <thead>\n"
                + "                        <tr>\n"
                + "                            <th style=\"width:200px\">Matricula</th>\n"
                + "                            <th style=\"width:200px\">Descripción</th>\n"
                + "                           <th style=\"width:200px\">Cantidad</th>\n"
                + "                            <th style=\"width:200px\">Preciounitario</th>\n"
                + "                            <th style=\"width:200px\">Total</th>\n"
                + "                        </tr>\n"
                + "                    </thead>\n"
                + "                    <tbody>\n"
                + "                        " + tablaReparacion + ""
                + "                    </tbody>\n"
                + "                    <tfoot>\n"
                + "                        <tr></tr>\n"
                + "                        <tr>\n"
                + "                            <td colspan=\"4\" class=\"text-right\">Subtotal</td>\n"
                + "                            <td>" + total + "</td>\n"
                + "                        </tr>\n"
                + "                        <tr>\n"
                + "                            <td colspan=\"4\" class=\"text-right\">IVA (21%)</td>\n"
                + "                            <td>" + (total * 0.21) + "</td>\n"
                + "                        </tr>\n"
                + "                        <tr>\n"
                + "                            <td colspan=\"4\" class=\"text-right\">\n"
                + "                                <h4>Total</h4>\n"
                + "                            </td>\n"
                + "                            <td>\n"
                + "                                <h2>" + (total * 1.21) + "€</h2>\n"
                + "                            </td>\n"
                + "                        </tr>\n"
                + "                    </tfoot>\n"
                + "                </table>\n"
                + "            </div>\n"
                + "        </div>\n"
                + "        <div class=\"row\">\n"
                + "            <div class=\"col-xs-12 text-center\">\n"
                + "                <h4>" + mensaje + "</h4>\n"
                + "            </div>\n"
                + "        </div>\n"
                + "    </div>\n"
                + "</body>\n"
                + "\n"
                + "</html>"
        );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        jLabelIcono = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelMail = new javax.swing.JLabel();
        jLabelImprimir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1240, 1754));
        setMinimumSize(new java.awt.Dimension(900, 950));
        setPreferredSize(new java.awt.Dimension(300, 600));
        setResizable(false);

        jEditorPane1.setMaximumSize(null);
        jScrollPane1.setViewportView(jEditorPane1);

        jPanel1.setLayout(new java.awt.GridLayout(1, 3));

        jLabelIcono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelIcono);

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabelTitulo);
        jPanel1.add(jLabel3);

        jLabelMail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelMail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMailMouseClicked(evt);
            }
        });

        jLabelImprimir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelImprimirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabelMail, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabelImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelMail, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabelImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 988, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelMailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMailMouseClicked
        JOptionPane.showMessageDialog(null, "Enviando...", "EMAIL", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jLabelMailMouseClicked

    private void jLabelImprimirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImprimirMouseClicked
        JOptionPane.showMessageDialog(null, "Imprimiendo...", "IMPRIMIR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jLabelImprimirMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelIcono;
    private javax.swing.JLabel jLabelImprimir;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
