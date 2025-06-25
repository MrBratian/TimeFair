package timefair.registros;

import timefair.interfaces.Calculable;
import timefair.interfaces.RegistrableAsistencia;

public class RegistroHoras implements Calculable, RegistrableAsistencia {
    private double horasTrabajadas;
    private double tarifaPorHora;

    public RegistroHoras(double horasTrabajadas, double tarifaPorHora) {
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
    }

    @Override
    public double calcularPago() {
        return horasTrabajadas * tarifaPorHora;
    }

    @Override
    public void registrarHoras() {
        // Implementación pendiente
    }

    public double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(double horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public double getTarifaPorHora() {
        return tarifaPorHora;
    }

    public void setTarifaPorHora(double tarifaPorHora) {
        this.tarifaPorHora = tarifaPorHora;
    }
}
