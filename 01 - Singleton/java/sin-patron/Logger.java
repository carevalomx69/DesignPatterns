public class Logger {

    // Cada Logger lleva su propia cuenta. Como habra varios Logger, habra
    // varias cuentas independientes.
    private int logCount = 0;

    // Constructor publico. Cualquiera puede crear un Logger nuevo.
    // ESTE es el origen del problema: nada impide tener varios Logger.
    public Logger() {
        System.out.println("Logger: se creo un Logger nuevo.");
    }

    public void log(String mensaje) {
        logCount++;
        System.out.println("[" + logCount + "] LOG: " + mensaje);
    }
}
