package timefair.registros;

import java.time.LocalDate;

public class Licencia {
    private TipoLicencia tipo;
    private LocalDate inicio;
    private LocalDate fin;
    private boolean aprobada;

    public Licencia(TipoLicencia tipo, LocalDate inicio, LocalDate fin, boolean aprobada) {
        this.tipo = tipo;
        this.inicio = inicio;
        this.fin = fin;
        this.aprobada = aprobada;
    }

    public TipoLicencia getTipo() {
        return tipo;
    }

    public void setTipo(TipoLicencia tipo) {
        this.tipo = tipo;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getFin() {
        return fin;
    }

    public void setFin(LocalDate fin) {
        this.fin = fin;
    }

    public boolean isAprobada() {
        return aprobada;
    }

    public void setAprobada(boolean aprobada) {
        this.aprobada = aprobada;
    }
}
