public class Principal {
    public static void main(String[] args) {
        System.out.println("--- Iniciando aplicacion ---");

        // Primera parte del programa: crea su propio Logger.
        Logger logger1 = new Logger();
        logger1.log("Primer evento registrado.");

        // Otra parte del programa: crea OTRO Logger con new.
        // Observa que el mensaje sale con [1], no con [2]: este Logger
        // empezo su cuenta desde cero, sin saber del primero.
        Logger logger2 = new Logger();
        logger2.log("Segundo evento registrado desde otra parte del codigo.");

        // == compara si son el mismo objeto en memoria, no si se parecen.
        // Aqui dara DISTINTAS: son dos objetos separados.
        if (logger1 == logger2) {
            System.out.println("\nCOMPROBACION: logger1 y logger2 son la MISMA instancia.");
        } else {
            System.out.println("\nCOMPROBACION: logger1 y logger2 son instancias DISTINTAS.");
        }

        System.out.println("--- Finalizando aplicacion ---");
    }
}
