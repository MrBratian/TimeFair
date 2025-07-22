package timefair.pagos;

import java.time.LocalDate;
import java.util.List;
import timefair.empleados.Empleado;

public class Pago {
    private Empleado empleado;
    private double monto;
    private LocalDate fecha;
    private List<Deduccion> deducciones;
    private List<Beneficio> beneficios;
    private PeriodoPago periodo;
    private Impuesto impuesto; // Suponiendo uno general para simplificar

    public Pago(Empleado empleado, double monto, LocalDate fecha,
                List<Deduccion> deducciones, List<Beneficio> beneficios,
                PeriodoPago periodo, Impuesto impuesto) {
        this.empleado = empleado;
        this.monto = monto;
        this.fecha = fecha;
        this.deducciones = deducciones;
        this.beneficios = beneficios;
        this.periodo = periodo;
        this.impuesto = impuesto;
    }

    public String generarRecibo() {
        return "RECIBO DE PAGO\nEmpleado: " + empleado.getNombre() +
               "\nID: " + empleado.getId() +
               "\nFecha: " + fecha +
               "\nMonto: $" + monto;
    }

    public void imprimirRecibo() {
        System.out.println(generarRecibo());
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public double getMonto() {
        return monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public List<Deduccion> getDeducciones() {
        return deducciones;
    }

    public List<Beneficio> getBeneficios() {
        return beneficios;
    }

    public PeriodoPago getPeriodo() {
        return periodo;
    }

    public Impuesto getImpuesto() {
        return impuesto;
    }
}
