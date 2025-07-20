package timefair.gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class RecordHours extends javax.swing.JPanel {
    private JPanel cardsContainer;
    public RecordHours(JPanel cardsContainer) {
        this.cardsContainer = cardsContainer;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxEmpleadosPorHoras = new javax.swing.JComboBox();
        jTextFieldHorasTrabajadas = new javax.swing.JTextField();
        jButtonRegistrar = new javax.swing.JButton();
        GoBackButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxEmpleadosPorHoras.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBoxEmpleadosPorHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        jTextFieldHorasTrabajadas.setText("Horas Trabajadas");
        add(jTextFieldHorasTrabajadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 110, -1));

        jButtonRegistrar.setText("Registrar");
        add(jButtonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, -1, -1));

        GoBackButton.setText("Volver");
        GoBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoBackButtonActionPerformed(evt);
            }
        });
        add(GoBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void GoBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoBackButtonActionPerformed
        CardLayout cl = (CardLayout) cardsContainer.getLayout();
        cl.show(cardsContainer, "MAIN");
    }//GEN-LAST:event_GoBackButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GoBackButton;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JComboBox jComboBoxEmpleadosPorHoras;
    private javax.swing.JTextField jTextFieldHorasTrabajadas;
    // End of variables declaration//GEN-END:variables
}
