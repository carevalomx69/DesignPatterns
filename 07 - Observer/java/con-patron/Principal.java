public class Principal {
    public static void main(String[] args) {
        System.out.println("--- Inscripciones al congreso (con patron) ---");

        Inscripciones inscripciones = new Inscripciones(3);   // 3 lugares

        // Este es el lugar que decide quien se entera. Cada observador se
        // crea aqui y se suscribe. Inscripciones solo recibe objetos que
        // cumplen la interfaz Observador.
        Observador constancias = new GeneradorConstancias();
        Observador correo = new EnvioCorreo();

        inscripciones.suscribir(constancias);
        inscripciones.suscribir(correo);

        inscripciones.inscribir("Ana");

        // Se deja de avisar al correo, en plena ejecucion.
        inscripciones.desuscribir(correo);
        inscripciones.inscribir("Beto");

        // Se suma un observador nuevo. Inscripciones no se modifica.
        inscripciones.suscribir(new Auditoria());
        inscripciones.inscribir("Carla");

        // Ya no hay lugares. La regla del cupo rechaza a Diana y ningun
        // observador se entera, porque no hubo inscripcion.
        inscripciones.inscribir("Diana");

        System.out.println("\n--- Fin ---");
    }
}
