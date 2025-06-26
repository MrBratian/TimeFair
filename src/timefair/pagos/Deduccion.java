package timefair.pagos;

public class Deduccion {
    private TipoDeduccion tipo;
    private String descripcion;
    private double monto;

    public Deduccion(TipoDeduccion tipo, String descripcion, double monto) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.monto = monto;
    }

    public TipoDeduccion getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeduccion tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
