package timefair.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.File;

public class AccessConection {
    private static Connection conexion;

    public static Connection conectar() {
        try {
            // Ruta relativa al archivo .accdb
            String nombreArchivo = "DB.accdb";
            File archivo = new File(nombreArchivo);
            String rutaAbsoluta = archivo.getAbsolutePath();

            // URL de conexión con UCanAccess
            String url = "jdbc:ucanaccess://" + rutaAbsoluta;

            conexion = DriverManager.getConnection(url);
            return conexion;
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            return null;
        }
    }

    public static Connection getConexion() {
        return conexion;
    }
}
