public class Principal {

    // El cliente solo conoce la interfaz Bebida. Le da igual si recibe un cafe
    // solo o un cafe envuelto en tres decoradores.
    static void mostrar(Bebida bebida) {
        System.out.println("Bebida: " + bebida.obtenerDescripcion());
        System.out.println("Costo: $" + bebida.obtenerCosto());
    }

    public static void main(String[] args) {
        System.out.println("--- Cafeteria (con patron) ---\n");

        // 1. El objeto base.
        Bebida bebida = new CafeSimple();
        mostrar(bebida);

        // 2. Se envuelve con Leche. La variable ahora apunta al decorador,
        //    que por dentro guarda el cafe.
        System.out.println();
        bebida = new Leche(bebida);
        mostrar(bebida);

        // 3. Se envuelve otra vez, ahora con Azucar. Son capas: Azucar envuelve
        //    a Leche, y Leche envuelve a CafeSimple.
        System.out.println();
        bebida = new Azucar(bebida);
        mostrar(bebida);

        // 4. Los extras se combinan en el orden y la cantidad que se quiera,
        //    sin clases nuevas. Aqui, un cafe con crema y doble leche.
        System.out.println();
        Bebida especial = new Leche(new Leche(new Crema(new CafeSimple())));
        mostrar(especial);

        // Agregar un extra nuevo (por ejemplo, canela) es escribir UNA clase
        // que extienda DecoradorBebida. Las demas clases no se tocan.
        System.out.println("\n--- Fin ---");
    }
}
