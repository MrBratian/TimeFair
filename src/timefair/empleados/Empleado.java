package timefair.empleados;

import timefair.pagos.HistorialPago;

public abstract class Empleado {
    protected String nombre;
    protected String id;
    protected HistorialPago historial;

    public Empleado(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.historial = new HistorialPago();
    }

    public abstract double calcularPago();

    public void mostrarDetalles() {
        System.out.println("Empleado: " + nombre + ", ID: " + id);
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public HistorialPago getHistorial() {
        return historial;
    }
}
