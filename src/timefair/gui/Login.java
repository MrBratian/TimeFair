package timefair.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;


public class Login extends javax.swing.JFrame {
    public Login() {
        initComponents();
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int ancho = (int) (pantalla.width * 0.8);
        int alto  = (int) (pantalla.height * 0.8);
        this.setSize(ancho, alto);
        this.setMinimumSize(new Dimension(400, 350)); 
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        java.awt.GridBagConstraints gbc;

        emailField = new javax.swing.JTextField(20);
        PasswordField = new javax.swing.JPasswordField(20);
        LogInButton = new javax.swing.JButton("Iniciar sesión");
        
        getRootPane().setDefaultButton(LogInButton);
        LogInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInButtonActionPerformed(evt);
            }
        });
        
        welcomeLabel = new javax.swing.JLabel("¡Bienvenid@ a TimeFair!");
        emailLabel = new javax.swing.JLabel("Ingresa tu correo electrónico:");
        passwordLabel = new javax.swing.JLabel("Ingresa tu contraseña:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        gbc = new java.awt.GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);
        gbc.anchor = java.awt.GridBagConstraints.CENTER;
        getContentPane().add(welcomeLabel, gbc);

        gbc.gridy++;
        getContentPane().add(emailLabel, gbc);

        gbc.gridy++;
        getContentPane().add(emailField, gbc);

        gbc.gridy++;
        getContentPane().add(passwordLabel, gbc);

        gbc.gridy++;
        getContentPane().add(PasswordField, gbc);

        gbc.gridy++;
        getContentPane().add(LogInButton , gbc);

        pack();
}

    private void LogInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String correo = emailField.getText();
        String contrasena = new String(PasswordField.getPassword());

        if (correo.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.");
            return;
        }

        try {
            String rutaBD = "jdbc:ucanaccess://DB.accdb";
            Connection conn = DriverManager.getConnection(rutaBD);
            String sql = "SELECT rol FROM Usuarios WHERE correo=? AND contraseña=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, correo);
            pst.setString(2, contrasena);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String rol = rs.getString("rol");

                this.dispose(); // Cierra la ventana de login

                if (rol.equalsIgnoreCase("admin")) {
                    new AdminMenu().setVisible(true);
                } else if (rol.equalsIgnoreCase("empleado")) {
                    new EmployeeMenu().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Rol no reconocido.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Correo o contraseña incorrectos.");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos.");
        }
    }

    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JButton LogInButton;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel welcomeLabel;
}