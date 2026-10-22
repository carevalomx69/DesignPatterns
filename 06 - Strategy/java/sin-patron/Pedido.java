// El CONTEXTO, sin el patron. Un pedido que sabe calcular su costo de envio.
// Los costos son pesos enteros (int) para no mezclar este ejemplo con el tema
// de precision decimal que se vio en Adapter.
public class Pedido {

    private final int pesoKg;

    public Pedido(int pesoKg) {
        this.pesoKg = pesoKg;
    }

    // EL PROBLEMA. El tipo de envio llega como texto y un switch decide cual
    // formula usar. Las formulas viven aqui, mezcladas con el resto del pedido.
    // Un tipo de envio nuevo (por ejemplo, internacional) obliga a abrir esta
    // clase y agregar otro case. Si el mismo switch se copia en otras clases,
    // hay que corregirlas todas.
    public int calcularEnvio(String tipoEnvio) {
        switch (tipoEnvio) {
            case "estandar":
                return pesoKg * 15;
            case "expres":
                return pesoKg * 30 + 50;
            default:
                throw new IllegalArgumentException("Tipo de envio desconocido: " + tipoEnvio);
        }
    }
}
