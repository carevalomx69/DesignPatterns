public class Principal {
    public static void main(String[] args) {
        System.out.println("--- Costo de envio (sin patron) ---\n");

        Pedido pedido = new Pedido(4);   // un pedido de 4 kg

        // El tipo de envio se manda como texto. Si hay un error de dedo
        // ("express"), el compilador no avisa: falla hasta que se ejecuta.
        System.out.println("Envio estandar: $" + pedido.calcularEnvio("estandar"));
        System.out.println("Envio expres:   $" + pedido.calcularEnvio("expres"));

        // Para agregar el envio internacional hay que editar Pedido.java.
        System.out.println("\n--- Fin ---");
    }
}
