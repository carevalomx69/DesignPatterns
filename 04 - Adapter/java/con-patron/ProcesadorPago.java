import java.math.BigDecimal;

// La interfaz OBJETIVO: el idioma que nuestro sistema quiere hablar.
// Nombres y tipos los decidimos nosotros, no el proveedor.
public interface ProcesadorPago {
    void procesarPago(BigDecimal monto);
    void obtenerEstado();
}
