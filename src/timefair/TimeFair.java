package timefair;

import timefair.empleados.*;
import timefair.registros.RegistroHoras;
import timefair.sistema.SistemaNomina;
import timefair.usuarios.Usuario;
import timefair.usuarios.Rol;

import java.util.Arrays;

public class TimeFair {
    public static void main(String[] args) {
        // Crear roles
        Rol adminRol = new Rol("Administrador", Arrays.asList("GESTIONAR_EMPLEADOS", "GENERAR_REPORTES"));
        
        // Crear empleados
        EmpleadoTiempoCompleto emp1 = new EmpleadoTiempoCompleto("Pedro Sánchez", "EMP100", 2500, 400);
        RegistroHoras registro = new RegistroHoras(35.5, 18);
        EmpleadoPorHoras emp2 = new EmpleadoPorHoras("María López", "EMP101", registro);

        // Crear usuario actual (admin)
        Usuario admin = new Usuario("USR001", "Carlos", "carlos@email.com", "1234", adminRol, null);

        // Crear sistema de nómina y registrar empleados
        SistemaNomina sistema = new SistemaNomina(admin);
        sistema.agregarEmpleado(emp1);
        sistema.agregarEmpleado(emp2);

        // Calcular pagos
        sistema.calcularPagos();

        // Generar reporte y enviar notificación
        sistema.generarReportePDF();
        sistema.enviarNotificacionEmail("rh@empresa.com", "Nómina procesada correctamente.");
    }
}
