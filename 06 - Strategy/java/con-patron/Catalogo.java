// El CONTEXTO. Guarda los productos y una estrategia de ordenamiento. El
// ciclo de ordenamiento es el mismo de la version sin patron, pero ya no sabe
// que criterios existen: para decidir quien va antes le pregunta a la
// estrategia que tiene guardada.
public class Catalogo {

    private final Producto[] productos;
    private EstrategiaOrden estrategia;   // la estrategia actual, se puede cambiar

    public Catalogo(Producto[] productos, EstrategiaOrden estrategia) {
        this.productos = productos;
        this.estrategia = estrategia;
    }

    // Cambiar de criterio es cambiar la estrategia guardada. Se puede hacer en
    // cualquier momento mientras el programa corre.
    public void setEstrategia(EstrategiaOrden estrategia) {
        this.estrategia = estrategia;
    }

    public void ordenar() {
        System.out.println("\nOrdenando con: " + estrategia.getClass().getSimpleName());
        for (int i = 0; i < productos.length - 1; i++) {
            int primero = i;
            for (int j = i + 1; j < productos.length; j++) {
                // DELEGACION. Catalogo no compara, le pregunta a la estrategia.
                if (estrategia.vaAntes(productos[j], productos[primero])) {
                    primero = j;
                }
            }
            Producto temporal = productos[i];
            productos[i] = productos[primero];
            productos[primero] = temporal;
        }
    }

    public void mostrar() {
        for (Producto p : productos) {
            System.out.println("  " + p);
        }
    }
}
