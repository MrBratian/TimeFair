package timefair.pagos;

import java.util.ArrayList;
import java.util.List;

public class HistorialPago {
    private List<Pago> pagos;

    public HistorialPago() {
        this.pagos = new ArrayList<>();
    }

    public void agregarPago(Pago pago) {
        pagos.add(pago);
    }

    public List<Pago> obtenerPagos() {
        return pagos;
    }
}
