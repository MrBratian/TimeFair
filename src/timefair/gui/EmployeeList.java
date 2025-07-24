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
        EditButton = new javax.swing.JButton();
        ShowDetailsButton = new javax.swing.JButton();
        DeleteEmployeeButton = new javax.swing.JButton();
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

        EditButton.setText("editar");
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });
        add(EditButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, -1));

        ShowDetailsButton.setText("ver detalles");
        ShowDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowDetailsButtonActionPerformed(evt);
            }
        });
        add(ShowDetailsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, -1, -1));

        DeleteEmployeeButton.setText("eliminar");
        DeleteEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteEmployeeButtonActionPerformed(evt);
            }
        });
        add(DeleteEmployeeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, -1, -1));

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

    private void DeleteEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteEmployeeButtonActionPerformed
    int fila = jTable1.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Selecciona un empleado para eliminar.");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar este empleado?", "Confirmar", JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) return;

    int id = (int) jTable1.getValueAt(fila, 0);

    Connection conn = null;
    PreparedStatement pst = null;

    try {
        conn = timefair.db.AccessConection.conectar(); // 💡 Asegúrate que este método NO esté retornando null

        if (conn == null) {
            JOptionPane.showMessageDialog(this, "No se pudo establecer la conexión con la base de datos.");
            return;
        }

        pst = conn.prepareStatement("UPDATE Empleados SET Eliminado = true WHERE ID = ?");
        pst.setInt(1, id);
        pst.executeUpdate();

        JOptionPane.showMessageDialog(this, "Empleado eliminado con éxito.");

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al eliminar el empleado: " + e.getMessage());
    } finally {
        try { if (pst != null) pst.close(); } catch (Exception e) {}
        try { if (conn != null) conn.close(); } catch (Exception e) {}
    }

    // Cargar los empleados después de cerrar la conexión
    cargarEmpleadosDesdeBD();
    }//GEN-LAST:event_DeleteEmployeeButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        int fila = jTable1.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un empleado para editar.");
            return;
        }

        int id = (int) jTable1.getValueAt(fila, 0);
        String nombre = (String) jTable1.getValueAt(fila, 1);
        String tipoContrato = (String) jTable1.getValueAt(fila, 2);

        JOptionPane.showMessageDialog(this, "Función editar aún no implementada para el empleado: " + nombre);
        // Aquí podrías abrir un nuevo panel o popup para editar los datos.
    }//GEN-LAST:event_EditButtonActionPerformed

    private void ShowDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowDetailsButtonActionPerformed
                int fila = jTable1.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un empleado para ver detalles.");
            return;
        }

        int id = (int) jTable1.getValueAt(fila, 0);
        String nombre = (String) jTable1.getValueAt(fila, 1);
        String tipoContrato = (String) jTable1.getValueAt(fila, 2);

        JOptionPane.showMessageDialog(this, "Función 'ver detalles' aún no implementada para el empleado: " + nombre);
        // Aquí podrías abrir un nuevo panel o popup para editar los datos.
    }//GEN-LAST:event_ShowDetailsButtonActionPerformed

    private void cargarEmpleadosDesdeBD() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = timefair.db.AccessConection.conectar(); // 👈 crear nueva conexión SIEMPRE
            String sql = "SELECT E.ID, E.Nombre, T.Nombre AS TipoContrato " +
             "FROM Empleados E " +
             "JOIN [Tipos de Contrato] T ON E.TipoContrato = T.ID " +
             "WHERE E.Eliminado = false";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Nombre");
            modelo.addColumn("Tipo de Contrato");

            while (rs.next()) {
                modelo.addRow(new Object[]{
                rs.getInt("ID"),
                rs.getString("Nombre"),
                rs.getString("TipoContrato")
            });
            }

            jTable1.setModel(modelo); // tu JTable

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar empleados: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (pst != null) pst.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {} // 👈 cerrarla aquí
        }
    }

    public void recargarListaEmpleados() {
        cargarEmpleadosDesdeBD();  // este sigue siendo privado
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteEmployeeButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JButton GoBackButton;
    private javax.swing.JButton ShowDetailsButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
