public class Principal {
    public static void main(String[] args) {
        System.out.println("--- Catalogo (sin patron) ---");

        Producto[] lista = {
            new Producto("Monitor", 250),
            new Producto("Teclado", 45),
            new Producto("Mouse", 15),
            new Producto("Audifonos", 60)
        };
        Catalogo catalogo = new Catalogo(lista);

        // El criterio se manda como texto. Si hay un error de dedo
        // ("presio"), el compilador no avisa: falla hasta que se ejecuta.
        catalogo.ordenar("nombre");
        catalogo.mostrar();

        catalogo.ordenar("precio");
        catalogo.mostrar();

        // Para ordenar por precio de mayor a menor hay que editar Catalogo.java
        // y agregar un case nuevo en vaAntes().
        System.out.println("\n--- Fin ---");
    }
}
