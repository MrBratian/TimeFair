package timefair.gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class MyRequests extends javax.swing.JPanel {
    private JPanel cardsContainer;
    
    public MyRequests(JPanel cardsContainer) {
        this.cardsContainer = cardsContainer;
        initComponents();
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GoBackButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
