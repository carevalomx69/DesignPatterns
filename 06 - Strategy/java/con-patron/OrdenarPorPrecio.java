// ESTRATEGIA CONCRETA 2. Ordena de menor a mayor precio.
public class OrdenarPorPrecio implements EstrategiaOrden {
    @Override
    public boolean vaAntes(Producto a, Producto b) {
        return a.getPrecio() < b.getPrecio();
    }
}
