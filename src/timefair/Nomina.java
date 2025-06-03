package timefair;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Nomina {
    private List<Empleado> empleados;

    public Nomina() {
        empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado emp) {
        empleados.add(emp);
    }

    public void calcularPagos() {
        for (Empleado emp : empleados) {
            double monto = emp.calcularPago();
            LocalDate fecha = LocalDate.now();
            Pago pago = new Pago(emp, monto, fecha);
            System.out.println("Pago generado: " + pago);
        }
    }
}
