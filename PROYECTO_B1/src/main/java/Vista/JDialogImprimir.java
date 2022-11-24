/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Vista;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author carlo
 */
public class JDialogImprimir extends javax.swing.JDialog {

    JDialogReparaciones jd;

    /**
     * Creates new form JDialogImprimir
     */
    public JDialogImprimir(java.awt.Dialog parent, boolean modal) {
        super(parent, false);
        jd = (JDialogReparaciones) parent;
        initComponents();
        jLabelIcono.setIcon(new ImageIcon("img/factura.png"));
        jTextArea1.setText( 
          "\n                   ___                                                      TALLERES FITIPALDI, Ronda de la Industria 78- 22006 Huesca "
        + "\n           o(_____)o                                                                                    NIF-IVA E5652117259T CIF/NIF: 65117259T "
        + "\n        (O\\___!___/O)                                                                     E-mail:fitipaldi@gmail.com Teléfono: 987 87 87 87 "  
        + "\n          ||| ====== |||                                                                            "
        + "\n TALLERES FITIPALDI                                                                                 "
        + "\n_________________________________________________________________________________                   "
        + "\n                                                                                                    "
        + "\n                                                                                                    "
        + "\n                                                                                                    "
        + "\n                                                                                                    "
        + "\n                                                                                                    "
        + "\n                                                                                                    "
        + "\n                                                                                                    "
        + "\n_________________________________________________________________________________                                                                        " 
        + "\n   Descripción\t\tCantidad\tPrecio\tIVA\tImporte                                                                      "
        + "\n_________________________________________________________________________________                   "
        + "\n                                                                                                    "
        + "\n                                                                                                    "
        + "\n                                                                                                    "
        + "\n                                                                                                    "
        + "\n                                                                                                    "
        + "\n                                                                                                    "
        + "\n                                                                                                    "
        + "\n                                                                                                    " 
        + "\n_________________________________________________________________________________                   "
        + "\n                                                                                                    " 
        + "\n                                                                                                    "
        + "\n                                                             \t\tSubtotal sin IVA                                               "
        + "\n                                                             IVA 21%  de                                                    "
        + "\n                                                             Total EUR                                                             "
        + "\n                                                                                                    "
        + "\n                                                                                                    "
        + "\n                                                                                                    "
        + "\n   Terminos y condiciones:                                                                                                "                                                                                         
        + "\n   A pagar a la entrega del vehículo                                                                                              "
        + "\n                                                                                                    "
        + "\n                                                                                                    "
        + "\n         "
                
                
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
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabelIcono = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelImprimir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.setLayout(new java.awt.GridLayout());

        jLabelIcono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelIcono);

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Presupuesto");
        jPanel1.add(jLabelTitulo);
        jPanel1.add(jLabel2);

        jPanel2.setLayout(new java.awt.GridLayout());

        jLabelImprimir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabelImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabelImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelIcono;
    private javax.swing.JLabel jLabelImprimir;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
