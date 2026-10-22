public class Principal {

    static void mostrar(Pedido pedido) {
        System.out.println(pedido.nombreEstrategia() + ": $" + pedido.calcularEnvio());
    }

    public static void main(String[] args) {
        System.out.println("--- Costo de envio (con patron) ---\n");

        // Este es el lugar que elige la estrategia. Pedido solo recibe una
        // EstrategiaEnvio y no sabe cual es.
        Pedido pedido = new Pedido(4, new EnvioEstandar());   // un pedido de 4 kg
        mostrar(pedido);

        // Se cambia la estrategia en plena ejecucion, como si el cliente
        // cambiara de opinion en la pantalla. Pedido no se modifica.
        pedido.setEstrategia(new EnvioExpres());
        mostrar(pedido);

        // Un tipo de envio nuevo es una clase nueva, y aqui solo se usa.
        pedido.setEstrategia(new EnvioInternacional());
        mostrar(pedido);

        System.out.println("\n--- Fin ---");
    }
}
