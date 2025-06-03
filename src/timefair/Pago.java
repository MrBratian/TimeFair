package timefair;

import java.time.LocalDate;

public class Pago {
    private Empleado empleado;
    private double montoPagado;
    private LocalDate fechaPago;

    // Constructor (d)
    public Pago(Empleado empleado, double montoPagado, LocalDate fechaPago) {
        this.empleado = empleado;
        this.montoPagado = montoPagado;
        this.fechaPago = fechaPago;
    }

    // Método lógico (b)
    public String generarRecibo() {
        return "RECIBO DE PAGO\nEmpleado: " + empleado.getNombre() +
               "\nID: " + empleado.getId() +
               "\nFecha: " + fechaPago +
               "\nMonto: $" + montoPagado;
    }

    // Método vacío (c)
    public void imprimirRecibo() {
    }

    // Getters y Setters (e)
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public double getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(int montoPagado) {
        this.montoPagado = montoPagado;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }
}
