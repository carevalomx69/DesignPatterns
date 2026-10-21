// ESTRATEGIA CONCRETA 3. Ordena de mayor a menor precio. Agregar este criterio
// fue escribir UNA clase nueva. Catalogo.java no se toco.
public class OrdenarPorPrecioDescendente implements EstrategiaOrden {
    @Override
    public boolean vaAntes(Producto a, Producto b) {
        return a.getPrecio() > b.getPrecio();
    }
}
