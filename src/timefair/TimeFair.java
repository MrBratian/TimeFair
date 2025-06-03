package timefair;

public class TimeFair {
    public static void main(String[] args) {
        Nomina nomina = new Nomina();

        Empleado emp1 = new Empleado("Pedro Sánchez", "EMP100", TipoContrato.TIEMPO_COMPLETO);
        emp1.setTiempoCompleto(2500, 400);

        Empleado emp2 = new Empleado("María López", "EMP101", TipoContrato.POR_HORAS);
        RegistroHoras registro = new RegistroHoras(35.5, 18);
        emp2.setRegistroHoras(registro);

        nomina.agregarEmpleado(emp1);
        nomina.agregarEmpleado(emp2);

        nomina.calcularPagos();
    }
}