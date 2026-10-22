// El SUJETO, sin el patron. Cuando un alumno se inscribe, hay que avisar a
// tres partes del sistema. Esta clase las crea y las llama una por una.
public class Inscripciones {

    // EL PROBLEMA. Inscripciones conoce las clases concretas de todos los
    // interesados y las crea ella misma. Esta clase queda acoplada a todas.
    private final GeneradorConstancias constancias = new GeneradorConstancias();
    private final EnvioCorreo correo = new EnvioCorreo();
    private final ControlCupo cupo = new ControlCupo(3);

    public void inscribir(String alumno) {
        System.out.println("\nSe inscribe: " + alumno);

        // Aviso directo y explicito a cada uno, con el nombre del metodo de
        // cada uno. Si manana se agrega una cuarta reaccion (por ejemplo, una
        // bitacora), hay que abrir esta clase, agregar otro campo y otra
        // llamada. Y no hay forma de dejar de avisarle a alguien sin editarla.
        constancias.generar(alumno);
        correo.enviarBienvenida(alumno);
        cupo.descontar();
    }
}
