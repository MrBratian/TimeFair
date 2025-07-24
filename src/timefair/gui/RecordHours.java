package timefair.gui;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class RecordHours extends javax.swing.JPanel {
    private JPanel cardsContainer;
    public RecordHours(JPanel cardsContainer) {
        this.cardsContainer = cardsContainer;
        initComponents();
        cargarEmpleados();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxEmpleadosPorHoras = new javax.swing.JComboBox();
        jTextFieldHorasTrabajadas = new javax.swing.JTextField();
        jButtonRegistrar = new javax.swing.JButton();
        GoBackButton = new javax.swing.JButton();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxEmpleadosPorHoras.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBoxEmpleadosPorHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 110, -1));
        add(jTextFieldHorasTrabajadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 110, -1));

        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });
        add(jButtonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, -1, -1));

        GoBackButton.setText("Volver");
        GoBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoBackButtonActionPerformed(evt);
            }
        });
        add(GoBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));
        add(jFormattedTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 110, -1));

        jLabel1.setText("Empleado:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, -1, -1));

        jLabel2.setText("Fecha trabajada:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));

        jLabel3.setText("Horas trabajadas:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void GoBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoBackButtonActionPerformed
        CardLayout cl = (CardLayout) cardsContainer.getLayout();
        cl.show(cardsContainer, "MAIN");
    }//GEN-LAST:event_GoBackButtonActionPerformed

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        EmpleadoItem empleado = (EmpleadoItem) jComboBoxEmpleadosPorHoras.getSelectedItem();
        String horasTexto = jTextFieldHorasTrabajadas.getText().trim();
        String fechaTexto = jFormattedTextField1.getText().trim();

        if (empleado == null || horasTexto.isEmpty() || fechaTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.");
            return;
        }

        int horas;
        try {
            horas = Integer.parseInt(horasTexto);
            if (horas <= 0) {
                JOptionPane.showMessageDialog(this, "Las horas deben ser mayores que cero.");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingresa un número válido de horas.");
            return;
        }

        java.sql.Date fecha;
        try {
            java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("dd/MM/yyyy");
            formato.setLenient(false); // evita fechas como 32/01/2025
            java.util.Date fechaUtil = formato.parse(fechaTexto);
            fecha = new java.sql.Date(fechaUtil.getTime());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Fecha inválida. Usa el formato dd/MM/yyyy.");
            return;
        }

        try (Connection conn = timefair.db.AccessConection.conectar()) {
            String sql = "INSERT INTO [Horas trabajadas] (id_empleado, [fecha trabajada], horas) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, empleado.getId());
                stmt.setDate(2, fecha);
                stmt.setInt(3, horas);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Horas registradas correctamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al registrar horas: " + e.getMessage());
        }
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void cargarEmpleados() {
        try (Connection conn = timefair.db.AccessConection.conectar()) {
            String sql = "SELECT id, nombre FROM Empleados WHERE eliminado = false AND TipoContrato = 4";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            jComboBoxEmpleadosPorHoras.removeAllItems(); 

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                jComboBoxEmpleadosPorHoras.addItem(new EmpleadoItem(id, nombre));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    class EmpleadoItem {
        int id;
        String nombre;

        public EmpleadoItem(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        public int getId() {
            return id;
        }

        public String toString() {
            return nombre;
        }
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GoBackButton;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JComboBox jComboBoxEmpleadosPorHoras;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextFieldHorasTrabajadas;
    // End of variables declaration//GEN-END:variables
}
