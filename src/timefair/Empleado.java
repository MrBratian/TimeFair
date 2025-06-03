package timefair;

public class Empleado {
    private String nombre;
    private String id;
    private int tipoContrato;
    private int salarioBase;
    private int bono;
    private RegistroHoras registroHoras;

    public Empleado(String nombre, String id, int tipoContrato) {
        this.nombre = nombre;
        this.id = id;
        this.tipoContrato = tipoContrato;
    }

    public double calcularPago() {
        if (tipoContrato == TipoContrato.TIEMPO_COMPLETO) {
            return salarioBase + bono;
        } else if (tipoContrato == TipoContrato.POR_HORAS) {
            return registroHoras.calcularPago();
        }
        return 0;
    }

    public void mostrarDetalles() {
    }

    public void setTiempoCompleto(int salarioBase, int bono) {
        this.salarioBase = salarioBase;
        this.bono = bono;
    }

    public void setRegistroHoras(RegistroHoras registroHoras) {
        this.registroHoras = registroHoras;
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(int tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double getBono() {
        return bono;
    }

    public RegistroHoras getRegistroHoras() {
        return registroHoras;
    }
}
