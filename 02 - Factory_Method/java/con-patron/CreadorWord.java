// Creador concreto. Es el UNICO lugar donde se crea un DocumentoWord.
public class CreadorWord extends CreadorDocumento {
    @Override
    public Documento crearDocumento() {
        System.out.println("CreadorWord: creando un DocumentoWord.");
        return new DocumentoWord();
    }
}
