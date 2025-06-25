package timefair.pagos;

public class Deduccion {
    private String tipo; // Ej: "retefuente", "reteiva", "reteica", "salud", "pensión"
    private String descripcion;
    private double monto;

    public Deduccion(String tipo, String descripcion, double monto) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.monto = monto;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getMonto() {
        return monto;
    }
}
        