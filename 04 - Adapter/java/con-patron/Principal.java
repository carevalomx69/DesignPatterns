import java.math.BigDecimal;

public class Principal {

    // Cliente 1. Solo conoce ProcesadorPago, la interfaz de NUESTRO sistema.
    // No sabe que existe un proveedor externo ni como se llaman sus metodos.
    static void cobrarPedido(ProcesadorPago procesador, BigDecimal monto) {
        System.out.println("\nCobrando un pedido...");
        procesador.procesarPago(monto);
        procesador.obtenerEstado();
    }

    // Cliente 2. Igual de corto: ya no repite conversiones ni nombres ajenos.
    static void cobrarSuscripcion(ProcesadorPago procesador, BigDecimal monto) {
        System.out.println("\nCobrando una suscripcion...");
        procesador.procesarPago(monto);
        procesador.obtenerEstado();
    }

    public static void main(String[] args) {
        System.out.println("--- Sistema de cobros (con patron) ---");

        // Este es el UNICO lugar que conoce al proveedor: se crea el servicio
        // del tercero y se le pone su adaptador.
        ServicioTerceroPago servicioExistente = new ServicioTerceroPago();
        ProcesadorPago procesador = new AdaptadorPagoTercero(servicioExistente);

        cobrarPedido(procesador, new BigDecimal("125.50"));
        cobrarSuscripcion(procesador, new BigDecimal("49.99"));

        // Si manana se cambia de proveedor, se escribe otro adaptador y se
        // cambian las dos lineas de arriba, las que crean el servicio y su
        // adaptador. cobrarPedido() y cobrarSuscripcion() no se tocan.
        System.out.println("\n--- Fin ---");
    }
}
