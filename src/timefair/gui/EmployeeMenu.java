package timefair.gui;

import java.awt.*;
import javax.swing.*;

public class EmployeeMenu extends javax.swing.JFrame {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EmployeeMenu().setVisible(true);
        });
    }

    public EmployeeMenu() {
        initComponents();
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int ancho = (int) (pantalla.width * 0.8);
        int alto = (int) (pantalla.height * 0.8);
        this.setSize(ancho, alto);
        this.setMinimumSize(new Dimension(800, 600));
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);

        // Mensaje superior izquierda
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.NONE;
        WelcomeLabel = new JLabel("Bienvenido de nuevo [USER]");
        getContentPane().add(WelcomeLabel, gbc);

        // Botón cerrar sesión a la derecha
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        gbc.weightx = 1;
        LogOutButton = new JButton("Cerrar sesión");
        getContentPane().add(LogOutButton, gbc);
        
        LogOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutButtonActionPerformed(evt);
            }
        });

        // Reset de constraints para lo demás
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;

        YourPersonalInfoLabel = new JLabel("Tu info personal:");
        getContentPane().add(YourPersonalInfoLabel, gbc);

        gbc.gridy++;
        ViewPaymentsButton = new JButton("Ver historial de pagos");
        getContentPane().add(ViewPaymentsButton, gbc);

        gbc.gridy++;
        RequestButton = new JButton("Solicitar vacaciones o licencias");
        getContentPane().add(RequestButton, gbc);

        // Espaciado inferior para empujar hacia arriba todo
        gbc.gridy++;
        gbc.weighty = 1;
        getContentPane().add(Box.createVerticalGlue(), gbc);

        pack();
    }
    
    private void LogOutButtonActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        SwingUtilities.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    private JButton ViewPaymentsButton;
    private JButton RequestButton;
    private JButton LogOutButton;
    private JLabel WelcomeLabel;
    private JLabel YourPersonalInfoLabel;
}
