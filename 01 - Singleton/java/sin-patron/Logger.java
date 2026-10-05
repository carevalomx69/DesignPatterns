public class Logger {

    private int logCount = 0;

    // Constructor publico. Cualquiera puede crear un Logger nuevo.
    public Logger() {
        System.out.println("Logger: se creo un Logger nuevo.");
    }

    public void log(String mensaje) {
        logCount++;
        System.out.println("[" + logCount + "] LOG: " + mensaje);
    }
}
