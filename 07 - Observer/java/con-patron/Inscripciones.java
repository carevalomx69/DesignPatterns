import java.util.ArrayList;
import java.util.List;

// El SUJETO. Guarda una lista de observadores y les avisa cuando algo cambia.
// No sabe quienes son ni que hacen: solo que cumplen la interfaz Observador.
public class Inscripciones {

    private final List<Observador> observadores = new ArrayList<>();
    private int lugares;

    public Inscripciones(int lugares) {
        this.lugares = lugares;
    }

    // Alguien pide que se le avise.
    public void suscribir(Observador observador) {
        observadores.add(observador);
    }

    // Alguien pide dejar de recibir avisos.
    public void desuscribir(Observador observador) {
        observadores.remove(observador);
    }

    public void inscribir(String alumno) {
        // La REGLA del cupo vive aqui, en el sujeto, y se revisa ANTES de
        // aceptar al alumno. Un observador solo reacciona a algo que ya
        // ocurrio: no puede impedir que ocurra, ni depende del orden en que
        // se suscribieron los demas. Si no hay lugar, no se inscribe y a nadie
        // se le avisa.
        if (lugares == 0) {
            System.out.println("\nCupo lleno. No se inscribe: " + alumno);
            return;
        }
        lugares--;
        System.out.println("\nSe inscribe: " + alumno + " (lugares restantes: " + lugares + ")");
        notificar(alumno);
    }

    // Recorre la lista y avisa a cada observador, en el orden en que se
    // suscribieron. Esta clase no cambia aunque se agreguen mas observadores.
    private void notificar(String alumno) {
        for (Observador observador : observadores) {
            observador.actualizar(alumno);
        }
    }
}
