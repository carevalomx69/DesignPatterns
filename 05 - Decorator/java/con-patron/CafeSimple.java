// El objeto BASE, el que se va a decorar. No sabe nada de los extras.
public class CafeSimple implements Bebida {
    @Override
    public String obtenerDescripcion() { return "Cafe negro"; }

    @Override
    public int obtenerCosto() { return 30; }
}
