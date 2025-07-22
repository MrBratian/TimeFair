package timefair.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.File;

public class AccessConection {
    private static Connection conexion;

    public static Connection conectar() {
        if (conexion != null) return conexion;
        try {
            // 1) Cargar el driver de UCanAccess
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            // 2) Construir ruta absoluta de la .accdb
            String nombreArchivo = "DB.accdb";
            File archivo = new File(nombreArchivo);
            String rutaAbsoluta = archivo.getAbsolutePath();

            // 3) URL de conexión
            String url = "jdbc:ucanaccess://" + rutaAbsoluta;

            // 4) Abrir la conexión
            conexion = DriverManager.getConnection(url);
            return conexion;
        } catch (ClassNotFoundException ex) {
            System.err.println("No se encontró el driver UCanAccess: " + ex.getMessage());
            return null;
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            return null;
        }
    }

    public static Connection getConexion() {
        return conexion;
    }
}
