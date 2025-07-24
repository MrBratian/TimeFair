package timefair.gui;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;


public class CalcularNomina extends javax.swing.JPanel {
    private JPanel cardsContainer;
    
    public CalcularNomina(JPanel cardsContainer) {
        this.cardsContainer = cardsContainer;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonCalcularPago = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        GoBackButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonCalcularPago.setText("Calcular Pagos");
        jButtonCalcularPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalcularPagoActionPerformed(evt);
            }
        });
        add(jButtonCalcularPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre ", "Monto", "Fecha", "Contrato"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 350, 110));

        GoBackButton.setText("Volver");
        GoBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoBackButtonActionPerformed(evt);
            }
        });
        add(GoBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void GoBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoBackButtonActionPerformed
        CardLayout cl = (CardLayout) cardsContainer.getLayout();
        cl.show(cardsContainer, "MAIN");
    }//GEN-LAST:event_GoBackButtonActionPerformed

    private void jButtonCalcularPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalcularPagoActionPerformed
        Connection conn = timefair.db.AccessConection.conectar();
        if (conn == null) {
            JOptionPane.showMessageDialog(this, "No se pudo conectar a la base de datos.");
            return;
        }

        DefaultTableModel model = new DefaultTableModel(
            new String[] { "Nombre", "Monto", "Fecha", "Contrato" }, 0);
        jTable1.setModel(model);

        try {
            PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM Empleados WHERE eliminado = false"
            );
            ResultSet rs = ps.executeQuery();

            java.sql.Date hoy = new java.sql.Date(System.currentTimeMillis());

            while (rs.next()) {
                int id = rs.getInt("ID");
                String nombre = rs.getString("Nombre");
                String contrato = rs.getString("TipoContrato");
                double salario = rs.getDouble("salario");
                double bono = rs.getDouble("bono");
                double horas = 0;
                double total = 0;
                System.out.println("Insertando pago -> ID: " + id + ", Total: " + total);


                if ("Por horas".equalsIgnoreCase(contrato)) {
                    PreparedStatement hrsPs = conn.prepareStatement(
                        "SELECT SUM(HorasTrabajadas) as TotalHoras FROM HorasTrabajadas WHERE id_empleado = ?"
                    );
                    hrsPs.setInt(1, id);
                    ResultSet hrsRs = hrsPs.executeQuery();
                    if (hrsRs.next()) {
                        horas = hrsRs.getDouble("TotalHoras");
                    }
                    total = (horas * salario) + bono;
                    hrsRs.close();
                    hrsPs.close();
                } else {
                    total = salario + bono;
                }

                // Insertar en tabla Pagos
                PreparedStatement insertPs = conn.prepareStatement(
                    "INSERT INTO Pagos (id_empleado, inicio, fin, horas, salario, bono, fecha, tarifa, total) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
                );
                insertPs.setInt(1, id);
                insertPs.setDate(2, hoy); // periodo_inicio
                insertPs.setDate(3, hoy); // periodo_fin
                insertPs.setDouble(4, horas);
                insertPs.setDouble(5, salario);
                insertPs.setDouble(6, bono);
                insertPs.setDouble(7, total);
                insertPs.setDate(8, hoy);
                insertPs.executeUpdate();
                insertPs.close();

                model.addRow(new Object[] {
                    nombre, total, hoy.toString(), contrato
                });
            }

            rs.close();
            ps.close();
            conn.close();

            JOptionPane.showMessageDialog(this, "Nómina calculada y registrada con éxito.");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_jButtonCalcularPagoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GoBackButton;
    private javax.swing.JButton jButtonCalcularPago;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
