package timefair.empleados;

import timefair.registros.RegistroHoras;

public class EmpleadoPorHoras extends Empleado {
    private RegistroHoras registroHoras;

    public EmpleadoPorHoras(String nombre, String id, RegistroHoras registroHoras) {
        super(nombre, id);
        this.registroHoras = registroHoras;
    }

    @Override
    public double calcularPago() {
        return registroHoras.calcularPago();
    }

    public RegistroHoras getRegistroHoras() {
        return registroHoras;
    }

    public void setRegistroHoras(RegistroHoras registroHoras) {
        this.registroHoras = registroHoras;
    }
}
