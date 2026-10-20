// El DECORADOR BASE. Es una Bebida (cumple la interfaz) y ademas TIENE una
// Bebida (la guarda en un atributo). Por defecto no agrega nada: le pasa cada
// pregunta a la bebida que envuelve. Los decoradores concretos solo
// sobrescriben lo que quieren cambiar.
public abstract class DecoradorBebida implements Bebida {

    protected final Bebida bebida;   // la bebida envuelta

    public DecoradorBebida(Bebida bebida) {
        this.bebida = bebida;
    }

    @Override
    public String obtenerDescripcion() { return bebida.obtenerDescripcion(); }

    @Override
    public int obtenerCosto() { return bebida.obtenerCosto(); }
}
