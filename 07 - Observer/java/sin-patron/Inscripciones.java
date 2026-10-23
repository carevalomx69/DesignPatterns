// El SUJETO, sin el patron. Cuando un alumno se inscribe, hay que avisar a dos
// partes del sistema. Esta clase las crea y las llama una por una.
public class Inscripciones {

    // EL PROBLEMA. Inscripciones conoce las clases concretas de todos los
    // interesados y las crea ella misma. Esta clase queda acoplada a todas.
    private final GeneradorConstancias constancias = new GeneradorConstancias();
    private final EnvioCorreo correo = new EnvioCorreo();

    private int lugares;

    public Inscripciones(int lugares) {
        this.lugares = lugares;
    }

    public void inscribir(String alumno) {
        // La REGLA del cupo. Se revisa antes de aceptar al alumno. Si ya no
        // hay lugares, no se inscribe y a nadie se le avisa. (En la version
        // con patron esta regla se queda igual, en el sujeto.)
        if (lugares == 0) {
            System.out.println("\nCupo lleno. No se inscribe: " + alumno);
            return;
        }
        lugares--;
        System.out.println("\nSe inscribe: " + alumno + " (lugares restantes: " + lugares + ")");

        // Aviso directo y explicito a cada uno, con el nombre del metodo de
        // cada uno. Si manana se agrega una tercera reaccion (por ejemplo, una
        // bitacora), hay que abrir esta clase, agregar otro campo y otra
        // llamada. Y no hay forma de dejar de avisarle a alguien sin editarla.
        constancias.generar(alumno);
        correo.enviarBienvenida(alumno);
    }
}
