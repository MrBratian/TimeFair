package timefair.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.File;

public class AccessConection {

    public static Connection conectar() {
        try {
            // 1) Cargar el driver de UCanAccess (solo necesario una vez)
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            // 2) Construir ruta absoluta
            String nombreArchivo = "DB.accdb";
            File archivo = new File(nombreArchivo);
            String rutaAbsoluta = archivo.getAbsolutePath();

            // 3) URL y conexión
            String url = "jdbc:ucanaccess://" + rutaAbsoluta;
            return DriverManager.getConnection(url);

        } catch (ClassNotFoundException ex) {
            System.err.println("No se encontró el driver UCanAccess: " + ex.getMessage());
            return null;
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            return null;
        }
    }
}
