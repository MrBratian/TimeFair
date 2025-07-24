package timefair.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;


public class Login extends javax.swing.JFrame {
    public Login() {
        setTitle("TimeFair - Inicio de sesion");
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

    private void LogInButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String correo    = emailField.getText().trim();
        String contrasen = new String(PasswordField.getPassword());

        if (correo.isEmpty() || contrasen.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.");
            return;
        }

        Connection conn = timefair.db.AccessConection.conectar();
        if (conn == null) {
            JOptionPane.showMessageDialog(this, "No se pudo conectar a la base de datos.");
            return;
        }

        String sql = "SELECT id, Rol FROM Usuarios WHERE [Correo electronico]=? AND Contraseña=?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, correo);
            pst.setString(2, contrasen);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int idUsuario = rs.getInt("id");
                    String rol = rs.getString("Rol");

                    if ("2".equalsIgnoreCase(rol)) { // Empleado
                        // Obtener el id del empleado asociado al usuario
                        String sqlEmp = "SELECT id FROM Empleados WHERE id_usuario=?";
                        try (PreparedStatement pstEmp = conn.prepareStatement(sqlEmp)) {
                            pstEmp.setInt(1, idUsuario);
                            try (ResultSet rsEmp = pstEmp.executeQuery()) {
                                if (rsEmp.next()) {
                                    int idEmpleado = rsEmp.getInt("id");
                                    timefair.db.auth.setIdEmpleado(idEmpleado); // Guardar
                                } else {
                                    JOptionPane.showMessageDialog(this, "No se encontró empleado asociado.");
                                    return;
                                }
                            }
                        }
                    }

                    this.dispose(); // cerrar login

                    if ("1".equalsIgnoreCase(rol)) {
                        new AdminMenu().setVisible(true);
                    } else if ("2".equalsIgnoreCase(rol)) {
                        new EmployeeMenu().setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(this, "Rol no reconocido: " + rol);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Correo o contraseña incorrectos.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al ejecutar la consulta: " + e.getMessage());
        }
    }

    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JButton LogInButton;
}