package timefair.pagos;

public class Beneficio {
    private String descripcion;
    private double monto;

    public Beneficio(String descripcion, double monto) {
        this.descripcion = descripcion;
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getMonto() {
        return monto;
    }
}
