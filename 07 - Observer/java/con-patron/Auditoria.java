// OBSERVADOR CONCRETO 4. Anota cada inscripcion en una bitacora. Agregarlo fue
// escribir una clase nueva: Inscripciones.java no se toco.
public class Auditoria implements Observador {
    @Override
    public void actualizar(String alumno) {
        System.out.println("  [Auditoria] Registro: se inscribio " + alumno);
    }
}
