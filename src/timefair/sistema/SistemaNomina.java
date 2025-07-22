package timefair.sistema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import timefair.empleados.Empleado;
import timefair.pagos.Pago;
import timefair.usuarios.Usuario;

public class SistemaNomina {
    private List<Empleado> empleados;
    private Usuario usuarioActual;

    public SistemaNomina(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado emp) {
        empleados.add(emp);
    }

    public void calcularPagos() {
        for (Empleado emp : empleados) {
            double monto = emp.calcularPago();
            Pago pago = new Pago(emp, monto, LocalDate.now(), null, null, null, null);
            emp.getHistorial().agregarPago(pago);
        }
    }

    public void generarReportePDF() {
        Reporte reporte = new Reporte();
        reporte.generarPDF();
    }

    public void enviarNotificacionEmail(String destinatario, String mensaje) {
        Notificacion n = new Notificacion(destinatario, mensaje);
        n.enviar();
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }
}
