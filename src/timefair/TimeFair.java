package timefair;

import timefair.db.AccessConection;
import timefair.gui.Login;
import javax.swing.SwingUtilities;

public class TimeFair {
    public static void main(String[] args) {
        // Conexión a la base de datos
        if (AccessConection.conectar() != null) {
            System.out.println("✅ Conexión a la base de datos establecida correctamente.");
        } else {
            System.err.println("❌ Error al conectar a la base de datos.");
        }

        // Abrir ventana de Login
        SwingUtilities.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
}
