package timefair.gui;

import java.awt.*;
import javax.swing.*;

public class EmployeeMenu extends javax.swing.JFrame {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EmployeeMenu().setVisible(true);
        });
    }

    private JPanel cards;
    public EmployeeMenu() {
        setTitle("Panel de Empleado");
        initComponents();

        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int ancho = (int) (pantalla.width * 0.8);
        int alto = (int) (pantalla.height * 0.8);
        this.setSize(ancho, alto);
        this.setMinimumSize(new Dimension(800, 600));
        this.setLocationRelativeTo(null);

        cards = new JPanel(new CardLayout());
        cards.add(MainPanel, "MAIN");
        cards.add(new NewRequest(cards), "NR");
        cards.add(new PaymentHistory(cards), "VP");

        setContentPane(cards);
        revalidate();
        repaint();
        pack(); // ✅ debe ir aquí al final
    }


    private void initComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);

        MainPanel = new JPanel(new GridBagLayout());
        WelcomeLabel = new JLabel("Bienvenido de nuevo");
        LogOutButton = new JButton("Cerrar sesión");
        ViewPaymentsButton = new JButton("Ver historial de pagos");
        RequestButton = new JButton("Solicitar vacaciones o licencias");

        // Mensaje superior izquierda
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.NONE;
        MainPanel.add(WelcomeLabel, gbc);

        // Botón cerrar sesión a la derecha
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        MainPanel.add(LogOutButton, gbc);
        LogOutButton.addActionListener(evt -> LogOutButtonActionPerformed(evt));

        // Reset de constraints para lo demás
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;

        gbc.gridy++;
        MainPanel.add(ViewPaymentsButton, gbc);
        ViewPaymentsButton.addActionListener(evt -> ViewPaymentsButtonActionPerformed(evt));

        gbc.gridy++;
        MainPanel.add(RequestButton, gbc);
        RequestButton.addActionListener(evt -> RequestButtonActionPerformed(evt));
}

    
    private void ViewPaymentsButtonActionPerformed(java.awt.event.ActionEvent evt) {
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.show(cards, "VP");
    }
    
    private void RequestButtonActionPerformed(java.awt.event.ActionEvent evt) {
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.show(cards, "NR");
    }
    
    private void LogOutButtonActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        SwingUtilities.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
    
    private javax.swing.JPanel MainPanel;
    private JButton ViewPaymentsButton;
    private JButton RequestButton;
    private JButton LogOutButton;
    private JLabel WelcomeLabel;
}
