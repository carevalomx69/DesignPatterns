public class Principal {
    public static void main(String[] args) {
        System.out.println("--- Inscripciones al congreso (sin patron) ---");

        Inscripciones inscripciones = new Inscripciones(3);   // 3 lugares

        inscripciones.inscribir("Ana");
        inscripciones.inscribir("Beto");
        inscripciones.inscribir("Carla");
        inscripciones.inscribir("Diana");   // ya no hay lugar: se rechaza

        // Aqui no hay manera de decidir quien se entera. Las dos reacciones
        // estan escritas dentro de Inscripciones y siempre se ejecutan, para
        // todos los alumnos aceptados, en el mismo orden.
        System.out.println("\n--- Fin ---");
    }
}
