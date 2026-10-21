import java.util.ArrayList;
import java.util.List;

// El SUJETO. Guarda una lista de observadores y les avisa cuando algo cambia.
// No sabe quienes son ni que hacen: solo que cumplen la interfaz Observador.
public class Inscripciones {

    private final List<Observador> observadores = new ArrayList<>();

    // Alguien pide que se le avise.
    public void suscribir(Observador observador) {
        observadores.add(observador);
    }

    // Alguien pide dejar de recibir avisos.
    public void desuscribir(Observador observador) {
        observadores.remove(observador);
    }

    public void inscribir(String alumno) {
        System.out.println("\nSe inscribe: " + alumno);
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
