public class Principal {
    public static void main(String[] args) {
        System.out.println("--- Iniciando aplicacion ---");

        Logger logger1 = Logger.getInstancia();
        logger1.log("Primer evento registrado.");

        Logger logger2 = Logger.getInstancia();
        logger2.log("Segundo evento registrado desde otra parte del codigo.");

        if (logger1 == logger2) {
            System.out.println("\nCOMPROBACION: logger1 y logger2 son la MISMA instancia.");
        } else {
            System.out.println("\nERROR: se crearon multiples instancias.");
        }

        System.out.println("--- Finalizando aplicacion ---");
    }
}
