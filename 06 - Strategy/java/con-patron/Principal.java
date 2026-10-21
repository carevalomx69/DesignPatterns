public class Principal {
    public static void main(String[] args) {
        System.out.println("--- Catalogo (con patron) ---");

        Producto[] lista = {
            new Producto("Monitor", 250),
            new Producto("Teclado", 45),
            new Producto("Mouse", 15),
            new Producto("Audifonos", 60)
        };

        // Este es el lugar que elige la estrategia. Catalogo solo recibe una
        // EstrategiaOrden y no sabe cual es.
        Catalogo catalogo = new Catalogo(lista, new OrdenarPorNombre());
        catalogo.ordenar();
        catalogo.mostrar();

        // Se cambia la estrategia en plena ejecucion. Catalogo no se modifica.
        catalogo.setEstrategia(new OrdenarPorPrecio());
        catalogo.ordenar();
        catalogo.mostrar();

        // Un criterio nuevo es una clase nueva, y aqui solo se usa.
        catalogo.setEstrategia(new OrdenarPorPrecioDescendente());
        catalogo.ordenar();
        catalogo.mostrar();

        System.out.println("\n--- Fin ---");
    }
}
