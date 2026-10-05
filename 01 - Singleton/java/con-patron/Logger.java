public class Logger {

    // Campo estatico que contiene la unica instancia.
    private static final Logger INSTANCIA = new Logger();

    private int logCount = 0;

    // Constructor privado, para impedir que se cree otro Logger desde fuera.
    private Logger() {
        System.out.println("Logger: se creo la unica instancia.");
    }

    // Unica forma de obtener el Logger.
    public static Logger getInstancia() {
        return INSTANCIA;
    }

    public void log(String mensaje) {
        logCount++;
        System.out.println("[" + logCount + "] LOG: " + mensaje);
    }
}
