package timefair.gui;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class NewEmployee extends javax.swing.JPanel {
    private JPanel cardsContainer;
    public NewEmployee(JPanel cardsContainer) {
        this.cardsContainer = cardsContainer;
        initComponents();
        cargarTiposDeContrato();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        NameField = new javax.swing.JTextField();
        TipoContratoComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        SalaryField = new javax.swing.JTextField();
        BonoField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        SaveButton = new javax.swing.JButton();
        GoBackButton = new javax.swing.JButton();
        CedulaField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre del empleado nuevo:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));
        add(NameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 190, -1));

        TipoContratoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(TipoContratoComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 190, -1));

        jLabel2.setText("Tipo de contrato:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, -1, -1));

        jLabel3.setText("Salario base/Tarifa por hora:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, -1, -1));
        add(SalaryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 190, -1));
        add(BonoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 190, -1));

        jLabel4.setText("bono:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, -1, -1));

        SaveButton.setText("Registrar");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });
        add(SaveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, -1, -1));

        GoBackButton.setText("Volver");
        GoBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoBackButtonActionPerformed(evt);
            }
        });
        add(GoBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        CedulaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CedulaFieldActionPerformed(evt);
            }
        });
        add(CedulaField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 190, -1));

        jLabel5.setText("Cedula:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void GoBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoBackButtonActionPerformed
        CardLayout cl = (CardLayout) cardsContainer.getLayout();
        cl.show(cardsContainer, "EL");
    }//GEN-LAST:event_GoBackButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        String nombre = NameField.getText().trim();
        String cedula = CedulaField.getText().trim(); // Opcional
        String salarioStr = SalaryField.getText().trim();
        String bonoStr = BonoField.getText().trim();

        if (nombre.isEmpty() || salarioStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor llena el nombre y el salario/tarifa.");
            return;
        }

        try {
            // Asegúrate de que se pueda convertir a números
            double salario = Double.parseDouble(salarioStr);
            double bono = bonoStr.isEmpty() ? 0.0 : Double.parseDouble(bonoStr);

            // Obtener ID del tipo de contrato
            TipoContrato seleccionado = (TipoContrato) TipoContratoComboBox.getSelectedItem();
            if (seleccionado == null) {
                JOptionPane.showMessageDialog(this, "Selecciona un tipo de contrato.");
                return;
            }
            int tipoContratoID = seleccionado.getId();

            // Insertar en la base de datos
            Connection conn = timefair.db.AccessConection.conectar();
            String sql = "INSERT INTO Empleados (Nombre, Cedula, TipoContrato, salario, bono, eliminado) VALUES (?, ?, ?, ?, ?, false)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nombre);
            pst.setString(2, cedula.isEmpty() ? null : cedula); // Puedes poner null si está vacío
            pst.setInt(3, tipoContratoID);
            pst.setDouble(4, salario);
            pst.setDouble(5, bono);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Empleado registrado correctamente.");
            
            if (listener != null) {
                listener.onEmpleadoRegistrado();
            }

            // Limpiar campos
            NameField.setText("");
            CedulaField.setText("");
            SalaryField.setText("");
            BonoField.setText("");
            TipoContratoComboBox.setSelectedIndex(0);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Salario y bono deben ser números válidos.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al registrar el empleado en la base de datos.");
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void CedulaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CedulaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CedulaFieldActionPerformed

    private void cargarTiposDeContrato() {
    try {
        Connection conn = timefair.db.AccessConection.conectar();
        String sql = "SELECT ID, Nombre FROM [Tipos de contrato]"; // Asegúrate que la tabla se llame así
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        TipoContratoComboBox.removeAllItems(); // Limpia el combo por si acaso

        while (rs.next()) {
            int id = rs.getInt("ID");
            String nombre = rs.getString("Nombre");
            TipoContratoComboBox.addItem(new TipoContrato(id, nombre));
        }

        rs.close();
        pst.close();
        // No cierres la conexión si la estás reutilizando
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al cargar tipos de contrato.");
    }
}

    public class TipoContrato {
        private int id;
        private String nombre;

        public TipoContrato(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        public int getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        @Override
        public String toString() {
            return nombre;
        }
    }
    
    public interface EmpleadoRegistradoListener {
        void onEmpleadoRegistrado();
    }
    
    public void setEmpleadoRegistradoListener(EmpleadoRegistradoListener listener) {
        this.listener = listener;
    }

    private EmpleadoRegistradoListener listener;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BonoField;
    private javax.swing.JTextField CedulaField;
    private javax.swing.JButton GoBackButton;
    private javax.swing.JTextField NameField;
    private javax.swing.JTextField SalaryField;
    private javax.swing.JButton SaveButton;
    private javax.swing.JComboBox TipoContratoComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
