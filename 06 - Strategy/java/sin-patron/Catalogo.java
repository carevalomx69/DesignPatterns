// El CONTEXTO, sin el patron. Ordena un arreglo de productos, y para saber
// por que criterio hacerlo usa un switch DENTRO de esta misma clase. Los dos
// algoritmos (por nombre y por precio) viven aqui mezclados con todo lo demas.
public class Catalogo {

    private final Producto[] productos;

    public Catalogo(Producto[] productos) {
        this.productos = productos;
    }

    // Ordenamiento por seleccion: en cada vuelta busca el producto que debe ir
    // primero entre los que faltan y lo pone en su lugar.
    public void ordenar(String criterio) {
        System.out.println("\nOrdenando por: " + criterio);
        for (int i = 0; i < productos.length - 1; i++) {
            int primero = i;
            for (int j = i + 1; j < productos.length; j++) {
                if (vaAntes(productos[j], productos[primero], criterio)) {
                    primero = j;
                }
            }
            Producto temporal = productos[i];
            productos[i] = productos[primero];
            productos[primero] = temporal;
        }
    }

    // EL PROBLEMA. Cada criterio nuevo (por ejemplo, precio de mayor a menor)
    // obliga a abrir esta clase y agregar otro case. El switch crece, y todos
    // los criterios se prueban y se modifican en el mismo lugar.
    private boolean vaAntes(Producto a, Producto b, String criterio) {
        switch (criterio) {
            case "nombre":
                return a.getNombre().compareTo(b.getNombre()) < 0;
            case "precio":
                return a.getPrecio() < b.getPrecio();
            default:
                throw new IllegalArgumentException("Criterio desconocido: " + criterio);
        }
    }

    public void mostrar() {
        for (Producto p : productos) {
            System.out.println("  " + p);
        }
    }
}
