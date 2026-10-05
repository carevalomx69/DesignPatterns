public class Logger {

    // Campo estatico y final que contiene la unica instancia.
    private static final Logger INSTANCIA = new Logger();

    private int logCount = 0;

    // Constructor privado, para impedir la instanciacion desde fuera.
    private Logger() {
        System.out.println("Logger: Se ha creado la unica instancia!");
    }

    public static Logger getInstancia() {
        return INSTANCIA;
    }

    public void log(String mensaje) {
        logCount++;
        System.out.println("[" + logCount + "] LOG: " + mensaje);
    }
}
