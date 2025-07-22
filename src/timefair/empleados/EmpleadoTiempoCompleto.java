package timefair.empleados;

public class EmpleadoTiempoCompleto extends Empleado {
    private double salarioBase;
    private double bono;

    public EmpleadoTiempoCompleto(String nombre, String id, double salarioBase, double bono) {
        super(nombre, id);
        this.salarioBase = salarioBase;
        this.bono = bono;
    }

    @Override
    public double calcularPago() {
        return salarioBase + bono;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double getBono() {
        return bono;
    }
}
