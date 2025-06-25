package timefair.pagos;

public class Impuesto {
    private String descripcion;
    private double porcentaje;

    public Impuesto(String descripcion, double porcentaje) {
        this.descripcion = descripcion;
        this.porcentaje = porcentaje;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPorcentaje() {
        return porcentaje;
    }
}
