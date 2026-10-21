// Una reaccion a la inscripcion: generar la constancia del alumno. Es una
// clase normal. Fijate que su metodo se llama "generar", y que quien la use
// tiene que conocer ese nombre.
public class GeneradorConstancias {
    public void generar(String alumno) {
        System.out.println("  [Constancias] Constancia generada para " + alumno);
    }
}
