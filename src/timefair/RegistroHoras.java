package timefair;

public class RegistroHoras {
    private double horasTrabajadas;
    private int tarifaPorHora;

    // Constructor
    public RegistroHoras(double horasTrabajadas, int tarifaPorHora) {
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
    }

    // Método con lógica (b)
    public double calcularPago() {
        return horasTrabajadas * tarifaPorHora;
    }

    // Método vacío (c)
    public void registrarHoras() {
    }

    // Getters y Setters (e)
    public double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public double getTarifaPorHora() {
        return tarifaPorHora;
    }

    public void setTarifaPorHora(int tarifaPorHora) {
        this.tarifaPorHora = tarifaPorHora;
    }
}
