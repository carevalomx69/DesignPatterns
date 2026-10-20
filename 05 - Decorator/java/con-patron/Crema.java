// DECORADOR CONCRETO. Envuelve una bebida y le suma crema: pregunta a la bebida
// envuelta por su descripcion y su costo, y luego agrega lo suyo. Un extra es
// una sola clase, sin importar con cuales otros se combine.
public class Crema extends DecoradorBebida {

    public Crema(Bebida bebida) {
        super(bebida);
    }

    @Override
    public String obtenerDescripcion() {
        return bebida.obtenerDescripcion() + ", con crema";
    }

    @Override
    public int obtenerCosto() {
        return bebida.obtenerCosto() + 10;
    }
}
