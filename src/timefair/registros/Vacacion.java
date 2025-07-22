package timefair.registros;

import java.time.LocalDate;

public class Vacacion {
    private int diasSolicitados;
    private LocalDate inicio;
    private LocalDate fin;
    private boolean aprobada;

    public Vacacion(int diasSolicitados, LocalDate inicio, LocalDate fin, boolean aprobada) {
        this.diasSolicitados = diasSolicitados;
        this.inicio = inicio;
        this.fin = fin;
        this.aprobada = aprobada;
    }

    public int getDiasSolicitados() {
        return diasSolicitados;
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
