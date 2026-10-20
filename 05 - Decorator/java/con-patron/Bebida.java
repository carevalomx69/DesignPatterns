// La INTERFAZ comun. Tanto el cafe como cada decorador cumplen este contrato,
// y por eso se pueden usar en el mismo lugar sin que el cliente note la
// diferencia. Los costos son pesos enteros (int).
public interface Bebida {
    String obtenerDescripcion();
    int obtenerCosto();
}
