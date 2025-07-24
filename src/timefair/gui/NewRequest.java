package timefair.gui;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class NewRequest extends javax.swing.JPanel {
    private JPanel cardsContainer;
    private MyRequests myRequestsPanel;

    public NewRequest(JPanel cardsContainer, MyRequests myRequestsPanel) {
        this.cardsContainer = cardsContainer;
        this.myRequestsPanel = myRequestsPanel;
        initComponents();
        cargarTiposDeLicencia();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LicencesComboBox = new javax.swing.JComboBox();
        MakeRequestButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        GoBackButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LicencesComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(LicencesComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, -1, -1));

        MakeRequestButton.setText("Solicitar");
        MakeRequestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MakeRequestButtonActionPerformed(evt);
            }
        });
        add(MakeRequestButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 380, 100));

        GoBackButton.setText("Volver");
        GoBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoBackButtonActionPerformed(evt);
            }
        });
        add(GoBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void GoBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoBackButtonActionPerformed
        if (myRequestsPanel != null) {
            myRequestsPanel.cargarSolicitudesEmpleado(); // 🔁 RECARGA
        } else {
            System.out.println("myRequestsPanel es null");
        }

        CardLayout cl = (CardLayout) cardsContainer.getLayout();
        cl.show(cardsContainer, "MR");
    }//GEN-LAST:event_GoBackButtonActionPerformed

    private void MakeRequestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MakeRequestButtonActionPerformed
        int idEmpleado = timefair.db.auth.getIdEmpleado();
        if (idEmpleado == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Sesión no válida. Intenta iniciar sesión nuevamente.");
            return;
        }

        TipoLicencia seleccion = (TipoLicencia) LicencesComboBox.getSelectedItem();
        if (seleccion == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debes seleccionar un tipo de solicitud.");
            return;
        }

        String texto = jTextArea1.getText().trim();
        if (texto.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debes escribir una razón para la solicitud.");
            return;
        }

        try (Connection conn = timefair.db.AccessConection.conectar()) {
            String sql = "INSERT INTO Solicitudes (empleado, licencia, fecha_solicitud, texto) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, idEmpleado);
            pst.setInt(2, seleccion.getId());
            pst.setDate(3, new java.sql.Date(System.currentTimeMillis()));
            pst.setString(4, texto);

            pst.executeUpdate();
            pst.close();

            javax.swing.JOptionPane.showMessageDialog(this, "Solicitud registrada con éxito.");
            jTextArea1.setText(""); // Limpiar campo
            CardLayout cl = (CardLayout) cardsContainer.getLayout();
            cl.show(cardsContainer, "MR"); // Volver al panel anterior
        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error al registrar solicitud: " + e.getMessage());
        }
        myRequestsPanel.cargarSolicitudesEmpleado();
    }//GEN-LAST:event_MakeRequestButtonActionPerformed

    private void cargarTiposDeLicencia() {
        try (Connection conn = timefair.db.AccessConection.conectar()) {
            String sql = "SELECT id, licencia FROM [Tipos de solicitud]";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            LicencesComboBox.removeAllItems(); // limpiar combo

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("licencia");
                LicencesComboBox.addItem(new TipoLicencia(id, nombre));
            }

            rs.close();
            pst.close();
        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar tipos de licencia: " + e.getMessage());
        }
    }

    private class TipoLicencia {
        int id;
        String nombre;

        TipoLicencia(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        public String toString() {
            return nombre; // lo que se muestra en el combo
        }

        public int getId() {
            return id;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GoBackButton;
    private javax.swing.JComboBox LicencesComboBox;
    private javax.swing.JButton MakeRequestButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
