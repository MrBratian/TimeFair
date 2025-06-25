package timefair.usuarios;

import timefair.empleados.Empleado;

public class Usuario {
    private String id;
    private String nombre;
    private String correo;
    private String contraseña;
    private Rol rol;
    private Empleado empleado;

    public Usuario(String id, String nombre, String correo, String contraseña, Rol rol, Empleado empleado) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.rol = rol;
        this.empleado = empleado;
    }

    public boolean login(String correoIngresado, String contraseñaIngresada) {
        return correo.equals(correoIngresado) && contraseña.equals(contraseñaIngresada);
    }

    public void cambiarContraseña(String nuevaContraseña) {
        this.contraseña = nuevaContraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public Rol getRol() {
        return rol;
    }
}