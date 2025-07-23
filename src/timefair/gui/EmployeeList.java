package timefair.gui;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class EmployeeList extends javax.swing.JPanel {
    private JPanel cardsContainer;
    
    public EmployeeList(JPanel cardsContainer) {
        this.cardsContainer = cardsContainer;
        initComponents();
        cargarEmpleadosDesdeBD();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        GoBackButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Tipo de Contrato", ""
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 516, 126));

        jButton1.setText("editar");
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, -1));

        jButton2.setText("ver detalles");
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, -1, -1));

        jButton3.setText("eliminar");
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, -1, -1));

        GoBackButton.setText("Volver");
        GoBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoBackButtonActionPerformed(evt);
            }
        });
        add(GoBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void GoBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoBackButtonActionPerformed
        CardLayout cl = (CardLayout) cardsContainer.getLayout();
        cl.show(cardsContainer, "MAIN");
    }//GEN-LAST:event_GoBackButtonActionPerformed

    private void cargarEmpleadosDesdeBD() {
        try {
            Connection conn = timefair.db.AccessConection.conectar();
            String sql = "SELECT ID, Nombre, TipoContrato FROM Empleados";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            // Crear modelo de tabla
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Nombre");
            modelo.addColumn("Tipo de Contrato");

            while (rs.next()) {
                Object[] fila = new Object[3];
                fila[0] = rs.getInt("ID");
                fila[1] = rs.getString("Nombre");
                fila[2] = rs.getString("TipoContrato");
                modelo.addRow(fila);
            }

            jTable1.setModel(modelo);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar empleados desde la base de datos.");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GoBackButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
