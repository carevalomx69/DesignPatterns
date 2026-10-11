import java.math.BigDecimal;

public class Principal {

    // Cliente 1: cobra un pedido. Tiene que conocer la API del tercero
    // (sus nombres y sus tipos) y hacer la conversion de BigDecimal a double.
    static void cobrarPedido(ServicioTerceroPago servicio, BigDecimal monto) {
        System.out.println("\nCobrando un pedido...");
        double montoTercero = monto.doubleValue();        // conversion manual
        servicio.realizarTransaccion(montoTercero);       // nombre del proveedor
        if (servicio.consultarDisponibilidad()) {         // respuesta del proveedor
            System.out.println("El servicio esta disponible.");
        }
    }

    // Cliente 2: cobra una suscripcion. Necesita lo mismo, asi que repite
    // la conversion y las llamadas. El conocimiento de la API del tercero ya
    // esta en dos lugares.
    static void cobrarSuscripcion(ServicioTerceroPago servicio, BigDecimal monto) {
        System.out.println("\nCobrando una suscripcion...");
        double montoTercero = monto.doubleValue();
        servicio.realizarTransaccion(montoTercero);
        if (servicio.consultarDisponibilidad()) {
            System.out.println("El servicio esta disponible.");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Sistema de cobros (sin patron) ---");

        ServicioTerceroPago servicio = new ServicioTerceroPago();
        cobrarPedido(servicio, new BigDecimal("125.50"));
        cobrarSuscripcion(servicio, new BigDecimal("49.99"));

        // Si manana se cambia de proveedor, hay que reescribir TODO el codigo
        // de cobrarPedido() y de cobrarSuscripcion(), porque ambos hablan
        // directamente el idioma del proveedor actual.
        System.out.println("\n--- Fin ---");
    }
}
