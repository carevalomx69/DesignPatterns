// La INTERFAZ de la estrategia. Define la pregunta que el pedido necesita
// responder: "cuanto cuesta enviar este peso?". Cada tipo de envio es una clase
// que la responde con su propia formula.
public interface EstrategiaEnvio {
    int calcular(int pesoKg);
}
