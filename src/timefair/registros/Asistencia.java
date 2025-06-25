package timefair.registros;

import java.time.LocalDate;
import timefair.interfaces.RegistrableAsistencia;

public class Asistencia implements RegistrableAsistencia {
    private LocalDate fecha;
    private boolean presente;
    private double horasTrabajadas;

    public Asistencia(LocalDate fecha, boolean presente, double horasTrabajadas) {
        this.fecha = fecha;
        this.presente = presente;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public void registrarHoras() {
        // Implementación futura si se necesita
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public boolean isPresente() {
        return presente;
    }

    public double getHorasTrabajadas() {
        return horasTrabajadas;
    }
}
