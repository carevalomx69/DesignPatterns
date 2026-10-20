// DECORADOR CONCRETO. Envuelve una bebida y le suma azucar: pregunta a la bebida
// envuelta por su descripcion y su costo, y luego agrega lo suyo. Un extra es
// una sola clase, sin importar con cuales otros se combine.
public class Azucar extends DecoradorBebida {

    public Azucar(Bebida bebida) {
        super(bebida);
    }

    @Override
    public String obtenerDescripcion() {
        return bebida.obtenerDescripcion() + ", con azucar";
    }

    @Override
    public int obtenerCosto() {
        return bebida.obtenerCosto() + 2;
    }
}
