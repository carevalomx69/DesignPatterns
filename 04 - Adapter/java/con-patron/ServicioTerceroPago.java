// Simula una biblioteca de un proveedor externo. NO se puede modificar,
// porque no es nuestra. Fijate en sus nombres y en sus tipos: el metodo se
// llama realizarTransaccion y recibe un double.
public class ServicioTerceroPago {

    public void realizarTransaccion(double monto) {
        System.out.println("  [ServicioTercero] Se realizo el cobro de $" + String.format("%.2f", monto) + " USD.");
    }

    public boolean consultarDisponibilidad() {
        System.out.println("  [ServicioTercero] Consultando la disponibilidad del sistema...");
        return true;
    }
}
