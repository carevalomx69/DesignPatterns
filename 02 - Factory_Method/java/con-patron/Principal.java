public class Principal {
    public static void main(String[] args) {
        System.out.println("--- Aplicacion de documentos (con patron) ---");

        // El programa trabaja con el tipo abstracto CreadorDocumento. Aqui
        // se ELIGE el creador, y con eso queda decidido el formato.
        CreadorDocumento creadorPdf = new CreadorPDF();
        creadorPdf.procesar();

        CreadorDocumento creadorWord = new CreadorWord();
        creadorWord.procesar();

        creadorPdf.vistaPrevia();

        // Si manana piden un DocumentoExcel, se agregan dos clases nuevas
        // (DocumentoExcel y CreadorExcel). procesar() y vistaPrevia() no
        // se tocan. Solo se agrega la linea que elige "new CreadorExcel()".
        System.out.println("\n--- Fin ---");
    }
}
