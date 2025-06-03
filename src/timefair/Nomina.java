package timefair;

import java.time.LocalDate;

public class Nomina {
    private Empleado empleado;

    public Nomina(Empleado empleado) {
        this.empleado = empleado;
    }

    public Pago generarPago() {
        double monto = empleado.calcularPago();
        LocalDate fecha = LocalDate.now();
        return new Pago(empleado, monto, fecha);
    }

    public void procesarPago() {
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
