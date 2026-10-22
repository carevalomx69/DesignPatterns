// El CONTEXTO. Guarda el peso y una estrategia de envio. Ya no sabe cuantos
// tipos de envio existen ni como se calcula cada uno: le pregunta a la
// estrategia que tiene guardada.
public class Pedido {

    private final int pesoKg;
    private EstrategiaEnvio estrategia;   // la estrategia actual, se puede cambiar

    public Pedido(int pesoKg, EstrategiaEnvio estrategia) {
        this.pesoKg = pesoKg;
        this.estrategia = estrategia;
    }

    // Cambiar el tipo de envio es cambiar la estrategia guardada. Se puede
    // hacer en cualquier momento mientras el programa corre.
    public void setEstrategia(EstrategiaEnvio estrategia) {
        this.estrategia = estrategia;
    }

    public int calcularEnvio() {
        // DELEGACION. Pedido no calcula, le pregunta a la estrategia.
        return estrategia.calcular(pesoKg);
    }

    public String nombreEstrategia() {
        return estrategia.getClass().getSimpleName();
    }
}
