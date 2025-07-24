package timefair.gui;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class RequestList extends javax.swing.JPanel {
    
    private JPanel cardsContainer;
    
    public RequestList(JPanel cardsContainer) {
        this.cardsContainer = cardsContainer;
        initComponents();
        cargarSolicitudes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        acceptButton = new javax.swing.JButton();
        rejectButton = new javax.swing.JButton();
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
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 550, 131));

        acceptButton.setText("Aceptar");
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });
        add(acceptButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, -1));

        rejectButton.setText("Rechazar");
        rejectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectButtonActionPerformed(evt);
            }
        });
        add(rejectButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, -1, -1));

        GoBackButton.setText("Volver");
        GoBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoBackButtonActionPerformed(evt);
            }
        });
        add(GoBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void GoBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoBackButtonActionPerformed
        CardLayout cl = (CardLayout) cardsContainer.getLayout();
        cl.show(cardsContainer, "MAIN");
    }//GEN-LAST:event_GoBackButtonActionPerformed

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una solicitud para aceptar.");
            return;
        }

        int solicitudId = (int) jTable1.getValueAt(selectedRow, 0);

        try (Connection conn = timefair.db.AccessConection.conectar()) {
            String sql = "UPDATE Solicitudes SET aceptada = TRUE, rechazada = FALSE WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, solicitudId);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Solicitud aceptada.");
            cargarSolicitudes(); // refrescar tabla
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al aceptar la solicitud: " + e.getMessage());
        }
    }//GEN-LAST:event_acceptButtonActionPerformed

    private void rejectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectButtonActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una solicitud para rechazar.");
            return;
        }

        int solicitudId = (int) jTable1.getValueAt(selectedRow, 0);

        try (Connection conn = timefair.db.AccessConection.conectar()) {
            String sql = "UPDATE Solicitudes SET rechazada = TRUE, aceptada = FALSE WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, solicitudId);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Solicitud rechazada.");
            cargarSolicitudes(); // refrescar tabla
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al rechazar la solicitud: " + e.getMessage());
        }
    }//GEN-LAST:event_rejectButtonActionPerformed

    public void cargarSolicitudes() {
    try {
        Connection conn = timefair.db.AccessConection.conectar();
        
        String sql = "SELECT s.id, e.nombre AS empleado, t.licencia AS tipo, s.fecha_solicitud, s.texto " +
             "FROM Solicitudes s " +
             "LEFT JOIN Empleados e ON s.empleado = e.id " +
             "LEFT JOIN [Tipos de solicitud] t ON s.licencia = t.id " +
             "WHERE s.aceptada = FALSE AND s.rechazada = FALSE";

        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ID", "Empleado", "Tipo de Solicitud", "Fecha", "Texto"});

        while (rs.next()) {
            int id = rs.getInt("id");
            String empleado = rs.getString("empleado");
            String tipo = rs.getString("tipo");
            Date fecha = rs.getDate("fecha_solicitud");
            String texto = rs.getString("texto");

            model.addRow(new Object[]{id, empleado, tipo, fecha, texto});
        }

        jTable1.setModel(model);

        rs.close();
        stmt.close();
        conn.close();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al cargar las solicitudes: " + e.getMessage());
    }
}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GoBackButton;
    private javax.swing.JButton acceptButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton rejectButton;
    // End of variables declaration//GEN-END:variables
}
