// ESTRATEGIA CONCRETA 3. Agregar este tipo de envio fue escribir UNA clase
// nueva. Pedido.java no se toco.
public class EnvioInternacional implements EstrategiaEnvio {
    @Override
    public int calcular(int pesoKg) {
        return pesoKg * 80 + 200;
    }
}
