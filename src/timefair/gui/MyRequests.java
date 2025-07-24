package timefair.gui;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class MyRequests extends javax.swing.JPanel {
    private JPanel cardsContainer;
    
    public MyRequests(JPanel cardsContainer) {
        this.cardsContainer = cardsContainer;
        initComponents();
        cargarSolicitudesEmpleado();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GoBackButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GoBackButton.setText("Volver");
        GoBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoBackButtonActionPerformed(evt);
            }
        });
        add(GoBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jButton2.setText("Realizar una solicitud nueva");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, -1, -1));

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
        jScrollPane2.setViewportView(jTable1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, 110));
    }// </editor-fold>//GEN-END:initComponents

    private void GoBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoBackButtonActionPerformed
        CardLayout cl = (CardLayout) cardsContainer.getLayout();
        cl.show(cardsContainer, "MAIN");
    }//GEN-LAST:event_GoBackButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CardLayout cl = (CardLayout) cardsContainer.getLayout();
        cl.show(cardsContainer, "NR");
    }//GEN-LAST:event_jButton2ActionPerformed

    public void cargarSolicitudesEmpleado() {
        System.out.println("Ejecutando cargarSolicitudesEmpleado()");
        try {
            Connection conn = timefair.db.AccessConection.conectar();
            String sql = "SELECT s.id, t.licencia AS tipo, s.fecha_solicitud, s.texto, s.aceptada, s.rechazada " +
                         "FROM Solicitudes s " +
                         "LEFT JOIN [Tipos de solicitud] t ON s.licencia = t.id " +
                         "WHERE s.empleado = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, timefair.db.auth.getIdEmpleado());
            ResultSet rs = stmt.executeQuery();

            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{"ID", "Tipo", "Fecha", "Texto", "Estado"});

            while (rs.next()) {
                String estado;
                boolean aceptado = rs.getBoolean("aceptada");
                boolean rechazado = rs.getBoolean("rechazada");

                if (aceptado) estado = "Aceptado";
                else if (rechazado) estado = "Rechazado";
                else estado = "Pendiente";

                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("tipo"),
                    rs.getDate("fecha_solicitud"),
                    rs.getString("texto"),
                    estado
                });
            }

            jTable1.setModel(model);

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar solicitudes: " + e.getMessage());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GoBackButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}