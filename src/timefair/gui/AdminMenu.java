package timefair.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

public class AdminMenu extends javax.swing.JFrame {
    
        public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EmployeeMenu().setVisible(true);
        });
    }

    
    public AdminMenu() {
        initComponents();
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int ancho = (int) (pantalla.width * 0.8);
        int alto  = (int) (pantalla.height * 0.8);
        this.setSize(ancho, alto);
        this.setMinimumSize(new Dimension(800, 600));
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        welcomeLabel = new javax.swing.JLabel();
        NewEmployeeButton = new javax.swing.JButton();
        EmployeeListButton = new javax.swing.JButton();
        RecordHoursButton = new javax.swing.JButton();
        PaymentHistoryButton = new javax.swing.JButton();
        CalcButton = new javax.swing.JButton();
        RequestListButton = new javax.swing.JButton();
        MakeReportButton = new javax.swing.JButton();
        LogOutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        welcomeLabel.setText("Bienvenido de nuevo [USER]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 60, 0, 0);
        getContentPane().add(welcomeLabel, gridBagConstraints);

        NewEmployeeButton.setText("Registrar empleado nuevo"); 
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 41;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(66, 100, 0, 0);
        getContentPane().add(NewEmployeeButton, gridBagConstraints);
        NewEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewEmployeeButtonActionPerformed(evt);
            }
        });

        EmployeeListButton.setText("Ver lista de empleados");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 61;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 100, 0, 0);
        getContentPane().add(EmployeeListButton, gridBagConstraints);
        EmployeeListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeeListButtonActionPerformed(evt);
            }
        });

        RecordHoursButton.setText("Registrar horas trabajadas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 39;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(66, 65, 0, 0);
        getContentPane().add(RecordHoursButton, gridBagConstraints);
        RecordHoursButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecordHoursButtonActionPerformed(evt);
            }
        });

        PaymentHistoryButton.setText("Historial de pagos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 83;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 65, 0, 0);
        getContentPane().add(PaymentHistoryButton, gridBagConstraints);
        PaymentHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentHistoryButtonActionPerformed(evt);
            }
        });

        CalcButton.setText("Calcular nomina");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 93;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(47, 100, 0, 0);
        getContentPane().add(CalcButton, gridBagConstraints);
        CalcButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalcButtonActionPerformed(evt);
            }
        });

        RequestListButton.setText("Solicitudes de licencias o vacaciones");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 100, 53, 0);
        getContentPane().add(RequestListButton, gridBagConstraints);
        RequestListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RequestListButtonActionPerformed(evt);
            }
        });

        MakeReportButton.setText("Generar reporte");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 89;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(57, 65, 0, 0);
        getContentPane().add(MakeReportButton, gridBagConstraints);
        MakeReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MakeReportButtonActionPerformed(evt);
            }
        });

        LogOutButton.setText("Cerrar sesion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 205, 0, 60);
        getContentPane().add(LogOutButton, gridBagConstraints);
        LogOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutButtonActionPerformed(evt);
            }
        });

        pack();
    }
    
    private void NewEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }

    private void EmployeeListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }
    
    private void RecordHoursButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }
    
    private void PaymentHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }
    
    private void CalcButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }
    
    private void RequestListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }
    
    private void MakeReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }
    
    private void LogOutButtonActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        SwingUtilities.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
    
    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JButton NewEmployeeButton;
    private javax.swing.JButton EmployeeListButton;
    private javax.swing.JButton RecordHoursButton;
    private javax.swing.JButton PaymentHistoryButton;
    private javax.swing.JButton CalcButton;
    private javax.swing.JButton RequestListButton;
    private javax.swing.JButton MakeReportButton;
    private javax.swing.JButton LogOutButton;
}
