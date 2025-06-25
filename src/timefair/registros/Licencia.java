package timefair.registros;

import java.time.LocalDate;

public class Licencia {
    private String tipo; // Ej: "maternidad", "paternidad", "luto", "calamidad doméstica", "enfermedad"
    private LocalDate inicio;
    private LocalDate fin;
    private boolean aprobada;

    public Licencia(String tipo, LocalDate inicio, LocalDate fin, boolean aprobada) {
        this.tipo = tipo;
        this.inicio = inicio;
        this.fin = fin;
        this.aprobada = aprobada;
    }

    public String getTipo() {
        return tipo;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public LocalDate getFin() {
        return fin;
    }

    public boolean isAprobada() {
        return aprobada;
    }
}
