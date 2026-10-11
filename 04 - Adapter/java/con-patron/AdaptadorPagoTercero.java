import java.math.BigDecimal;

// El ADAPTADOR. Cumple la interfaz que nuestro sistema espera
// (ProcesadorPago) y por dentro usa el servicio del tercero. Toda la
// traduccion de nombres y de tipos vive en esta clase y en ningun otro lugar.
public class AdaptadorPagoTercero implements ProcesadorPago {

    private final ServicioTerceroPago servicio;   // el objeto que se adapta

    public AdaptadorPagoTercero(ServicioTerceroPago servicio) {
        this.servicio = servicio;
    }

    @Override
    public void procesarPago(BigDecimal monto) {
        System.out.println("  [Adaptador] Traduciendo el pago...");
        // Traduccion de tipo (BigDecimal a double) y de nombre
        // (procesarPago a realizarTransaccion).
        servicio.realizarTransaccion(monto.doubleValue());
    }

    @Override
    public void obtenerEstado() {
        System.out.println("  [Adaptador] Traduciendo la consulta de estado...");
        // Traduccion de la respuesta del tercero a algo legible para nosotros.
        if (servicio.consultarDisponibilidad()) {
            System.out.println("El servicio esta disponible.");
        }
    }
}
