// OBSERVADOR CONCRETO 1. Cumple la interfaz Observador. Cuando le avisan de una
// inscripcion, genera la constancia.
public class GeneradorConstancias implements Observador {
    @Override
    public void actualizar(String alumno) {
        System.out.println("  [Constancias] Constancia generada para " + alumno);
    }
}
