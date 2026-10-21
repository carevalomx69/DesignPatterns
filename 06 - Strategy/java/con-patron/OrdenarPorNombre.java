// ESTRATEGIA CONCRETA 1. Ordena alfabeticamente por nombre.
public class OrdenarPorNombre implements EstrategiaOrden {
    @Override
    public boolean vaAntes(Producto a, Producto b) {
        return a.getNombre().compareTo(b.getNombre()) < 0;
    }
}
