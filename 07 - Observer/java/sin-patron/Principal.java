public class Principal {
    public static void main(String[] args) {
        System.out.println("--- Inscripciones al congreso (sin patron) ---");

        Inscripciones inscripciones = new Inscripciones();

        inscripciones.inscribir("Ana");
        inscripciones.inscribir("Beto");

        // Aqui no hay manera de decidir quien se entera. Las tres reacciones
        // estan escritas dentro de Inscripciones y siempre se ejecutan, para
        // todos los alumnos, en el mismo orden.
        System.out.println("\n--- Fin ---");
    }
}
