public class Logger {

    // PIEZA 1 del patron: un campo estatico que guarda la unica instancia.
    // Java la crea una sola vez, la primera vez que el programa usa la
    // clase Logger. Por eso el mensaje "se creo la unica instancia" sale
    // despues de "Iniciando aplicacion", justo en el primer getInstancia().
    private static final Logger INSTANCIA = new Logger();

    // Una sola cuenta compartida por todo el programa, porque hay un solo
    // Logger.
    private int logCount = 0;

    // PIEZA 2 del patron: constructor PRIVADO. Solo la propia clase puede
    // ejecutarlo (lo hace una vez, en la linea de INSTANCIA). Desde fuera,
    // "new Logger()" ya no compila. Esto es lo que ConError.java intenta.
    private Logger() {
        System.out.println("Logger: se creo la unica instancia.");
    }

    // PIEZA 3 del patron: punto de acceso global. Es la unica forma de
    // obtener el Logger, y siempre devuelve el mismo objeto.
    public static Logger getInstancia() {
        return INSTANCIA;
    }

    public void log(String mensaje) {
        logCount++;
        System.out.println("[" + logCount + "] LOG: " + mensaje);
    }
}
