/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Vista;

import clases.Hora;
import java.awt.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author carlo
 */
public class DialogLog extends javax.swing.JDialog {

    DefaultTableModel dtm;
    String cabecera[] = {"Día", "Hora", "Módulo", "Fecha Alta", "Hora Alta"};
    TableRowSorter<TableModel> order;
    ArrayList<RowSorter.SortKey> keys;
    JFrameHorario jf;
    JDialogAlta jd;
    String[] dias ;
    String[] horas;

    /**
     * Creates new form DialogLog
     */
    public DialogLog(java.awt.Frame parent, boolean modal) {
        super(parent, "LISTADO LOG", false);
        initComponents();
        jf = (JFrameHorario) parent;
        this.dias=jf.dias;
        this.horas=jf.horas;
        dtm = new DefaultTableModel(cabecera, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTableTabla.setModel(dtm);

        for (int i = 0; i < jf.lista.tamanyo(); i++) {
            Hora h = jf.lista.getHora(i);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat shf = new SimpleDateFormat("HH:mm");
            String[] horas = {jf.dias[h.getDia() - 1], jf.horas[h.getHora() - 1], h.getModulo(), sdf.format(h.getFechaAlta()), shf.format(h.getFechaAlta())};
            dtm.addRow(horas);
            order = new TableRowSorter<TableModel>(dtm);
            jTableTabla.setRowSorter(order);
            keys = new ArrayList<RowSorter.SortKey>();
            keys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
            order.setSortKeys(keys);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableTabla.setMinimumSize(new java.awt.Dimension(200, 400));
        jTableTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTablaMouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() == 2) {
            int resultado= JOptionPane.showConfirmDialog(null, "¿Seguro que quieres borrar el registro?","ATENCIÓN",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
            if(resultado==JOptionPane.YES_OPTION){
            String dia = dtm.getValueAt(jTableTabla.getSelectedRow(), 0).toString();
            String hora = dtm.getValueAt(jTableTabla.getSelectedRow(), 1).toString();
            
            dtm.removeRow(jTableTabla.getSelectedRow());
            int d = 0;
            int h = 0;
            for (int i = 0; i < dias.length; i++) {
                if (dias[i].equalsIgnoreCase(dia)) {
                    d = i+1;
                }
            }
            for (int i = 0; i < horas.length; i++) {
                if (horas[i].equalsIgnoreCase(hora)) {
                    h = i+1;
                }
            }
           
            jf.lista.borraHora(jf.lista.buscaHora(d, h));
            jf.actualiza();
        }}
        
    }//GEN-LAST:event_jTableTablaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogLog dialog = new DialogLog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTabla;
    // End of variables declaration//GEN-END:variables
}
