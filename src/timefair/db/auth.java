package timefair.db;

public class auth {
    private static int idEmpleado = -1;

    public static void setIdEmpleado(int id) {
        idEmpleado = id;
    }

    public static int getIdEmpleado() {
        return idEmpleado;
    }
}
