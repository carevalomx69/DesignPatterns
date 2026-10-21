// Un producto del catalogo. Es el mismo en las dos versiones.
// El precio es un entero en pesos para no mezclar este ejemplo con el tema
// de precision decimal que se vio en Adapter.
public class Producto {
    private final String nombre;
    private final int precio;

    public Producto(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() { return nombre; }
    public int getPrecio()    { return precio; }

    @Override
    public String toString() {
        return nombre + " - $" + precio;
    }
}
