public class ConError {
    public static void main(String[] args) {
        // Intento de crear un segundo Logger. Este archivo NO compila a
        // proposito: el constructor de Logger es privado. Compilalo y lee
        // el mensaje de error.
        Logger logger3 = new Logger();
        logger3.log("Tercer evento registrado.");
    }
}
