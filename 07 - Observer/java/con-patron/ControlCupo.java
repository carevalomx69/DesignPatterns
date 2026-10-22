// OBSERVADOR CONCRETO 3. Descuenta un lugar del cupo. Los observadores pueden
// tener su propio estado: este recuerda cuantos lugares quedan.
public class ControlCupo implements Observador {
    private int disponibles;

    public ControlCupo(int disponibles) {
        this.disponibles = disponibles;
    }

    @Override
    public void actualizar(String alumno) {
        disponibles--;
        System.out.println("  [Cupo] Lugares disponibles: " + disponibles);
    }
}
