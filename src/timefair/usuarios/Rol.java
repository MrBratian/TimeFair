package timefair.usuarios;

import java.util.List;

public class Rol {
    private String nombre;
    private List<String> permisos;

    public Rol(String nombre, List<String> permisos) {
        this.nombre = nombre;
        this.permisos = permisos;
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getPermisos() {
        return permisos;
    }
}
