// Creador concreto. Es el UNICO lugar donde se crea un DocumentoPDF.
public class CreadorPDF extends CreadorDocumento {
    @Override
    public Documento crearDocumento() {
        System.out.println("CreadorPDF: creando un DocumentoPDF.");
        return new DocumentoPDF();
    }
}
