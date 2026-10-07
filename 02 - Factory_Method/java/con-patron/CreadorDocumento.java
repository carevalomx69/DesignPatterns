// El "creador". Define el FACTORY METHOD (crearDocumento) pero no lo
// implementa: cada subclase decide que documento concreto crear.
public abstract class CreadorDocumento {

    // FACTORY METHOD. Devuelve la interfaz Documento, nunca una clase
    // concreta. Es lo unico que las subclases estan obligadas a escribir.
    public abstract Documento crearDocumento();

    // La logica de la aplicacion se escribe UNA sola vez, aqui. Llama a
    // crearDocumento() sin saber (ni importarle) que clase recibira.
    public void procesar() {
        Documento doc = crearDocumento();
        System.out.println("\n--- Inicia procesamiento ---");
        doc.abrir();
        doc.guardar();
        System.out.println("--- Termina procesamiento ---");
    }

    public void vistaPrevia() {
        Documento doc = crearDocumento();
        System.out.println("\n--- Vista previa ---");
        doc.abrir();
    }
}
