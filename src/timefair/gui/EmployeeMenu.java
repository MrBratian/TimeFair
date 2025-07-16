package timefair.gui;

import java.awt.*;
import javax.swing.*;

public class EmployeeMenu extends javax.swing.JFrame {

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
        jLabel1 = new JLabel("Bienvenido de nuevo [USER]");
        getContentPane().add(jLabel1, gbc);

        // Botón cerrar sesión a la derecha
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        gbc.weightx = 1;
        jButton3 = new JButton("Cerrar sesión");
        getContentPane().add(jButton3, gbc);

        // Reset de constraints para lo demás
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;

        jLabel2 = new JLabel("Tu info personal:");
        getContentPane().add(jLabel2, gbc);

        gbc.gridy++;
        jButton1 = new JButton("Ver historial de pagos");
        getContentPane().add(jButton1, gbc);

        gbc.gridy++;
        jButton2 = new JButton("Solicitar vacaciones o licencias");
        getContentPane().add(jButton2, gbc);

        // Espaciado inferior para empujar hacia arriba todo
        gbc.gridy++;
        gbc.weighty = 1;
        getContentPane().add(Box.createVerticalGlue(), gbc);

        pack();
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            new EmployeeMenu().setVisible(true);
        });
    }

    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JLabel jLabel1;
    private JLabel jLabel2;
}
