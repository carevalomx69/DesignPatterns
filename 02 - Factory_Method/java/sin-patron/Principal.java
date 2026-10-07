public class Principal {

    // Funcion 1: procesar un documento. Para saber QUE clase crear, esta
    // funcion revisa el tipo con un if/else y escribe "new" con clases
    // concretas.
    static void procesar(String tipo) {
        Documento doc;
        if (tipo.equals("PDF")) {
            doc = new DocumentoPDF();
        } else if (tipo.equals("WORD")) {
            doc = new DocumentoWord();
        } else {
            throw new IllegalArgumentException("Tipo no reconocido: " + tipo);
        }
        System.out.println("\n--- Inicia procesamiento ---");
        doc.abrir();
        doc.guardar();
        System.out.println("--- Termina procesamiento ---");
    }

    // Funcion 2: vista previa. Necesita el mismo documento, asi que repite
    // el mismo if/else. El conocimiento de "que tipos existen" ya esta en
    // dos lugares. Si hubiera una tercera funcion, estaria en tres.
    static void vistaPrevia(String tipo) {
        Documento doc;
        if (tipo.equals("PDF")) {
            doc = new DocumentoPDF();
        } else if (tipo.equals("WORD")) {
            doc = new DocumentoWord();
        } else {
            throw new IllegalArgumentException("Tipo no reconocido: " + tipo);
        }
        System.out.println("\n--- Vista previa ---");
        doc.abrir();
    }

    public static void main(String[] args) {
        System.out.println("--- Aplicacion de documentos (sin patron) ---");

        procesar("PDF");
        procesar("WORD");
        vistaPrevia("PDF");

        // Si manana piden un DocumentoExcel, hay que volver a abrir ESTE
        // archivo y agregar un "else if" en procesar() y otro en
        // vistaPrevia(). Codigo que ya funcionaba se modifica.
        System.out.println("\n--- Fin ---");
    }
}
