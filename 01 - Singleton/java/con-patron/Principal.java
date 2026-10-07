public class Principal {
    public static void main(String[] args) {
        System.out.println("--- Iniciando aplicacion ---");

        // UNICO CAMBIO respecto a la version sin patron: en lugar de
        // "new Logger()", se pide el Logger con getInstancia().
        // Aqui es cuando se crea la instancia, por primera y unica vez.
        Logger logger1 = Logger.getInstancia();
        logger1.log("Primer evento registrado.");

        // Otra parte del programa pide el Logger y recibe el MISMO objeto.
        // Por eso este mensaje sale con [2]: la cuenta continua, no se
        // reinicia, y no aparece un segundo "se creo la unica instancia".
        Logger logger2 = Logger.getInstancia();
        logger2.log("Segundo evento registrado desde otra parte del codigo.");

        // Ahora la comparacion dara MISMA instancia: logger1 y logger2 son
        // dos nombres para un solo objeto.
        if (logger1 == logger2) {
            System.out.println("\nCOMPROBACION: logger1 y logger2 son la MISMA instancia.");
        } else {
            System.out.println("\nCOMPROBACION: logger1 y logger2 son instancias DISTINTAS.");
        }

        System.out.println("--- Finalizando aplicacion ---");
    }
}
