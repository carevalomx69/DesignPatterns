import java.util.HashMap;
import java.util.Map;

// ALTERNATIVA SIN CLASES. Es la misma idea de Strategy, pero cada estrategia es
// solo una funcion (lambda) en lugar de una clase. La interfaz y Pedido son los
// mismos de la version con patron. Se acostumbra cuando cada algoritmo es
// corto y no necesita mas que una formula.
public class Principal {

    static void mostrar(String nombre, Pedido pedido) {
        System.out.println(nombre + ": $" + pedido.calcularEnvio());
    }

    public static void main(String[] args) {
        System.out.println("--- Costo de envio (alternativa funcional) ---\n");

        // Forma 1. Cada estrategia es una lambda: "peso -> formula".
        Pedido pedido = new Pedido(4, peso -> peso * 15);
        mostrar("Estandar", pedido);

        pedido.setEstrategia(peso -> peso * 30 + 50);
        mostrar("Expres", pedido);

        // Forma 2. Un mapa de nombre a funcion, parecido a un arreglo de
        // apuntadores a funcion en C. Elegir un tipo de envio es buscar su
        // nombre en el mapa, sin switch.
        Map<String, EstrategiaEnvio> tarifas = new HashMap<>();
        tarifas.put("estandar", peso -> peso * 15);
        tarifas.put("expres", peso -> peso * 30 + 50);
        tarifas.put("internacional", peso -> peso * 80 + 200);

        pedido.setEstrategia(tarifas.get("internacional"));
        mostrar("Internacional", pedido);

        System.out.println("\n--- Fin ---");
    }
}
