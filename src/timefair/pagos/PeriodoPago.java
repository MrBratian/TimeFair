package timefair.pagos;

import java.time.LocalDate;

public class PeriodoPago {
    private LocalDate inicio;
    private LocalDate fin;
    private String descripcion;

    public PeriodoPago(LocalDate inicio, LocalDate fin, String descripcion) {
        this.inicio = inicio;
        this.fin = fin;
        this.descripcion = descripcion;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public LocalDate getFin() {
        return fin;
    }

    public String getDescripcion() {
        return descripcion;
    }
}

