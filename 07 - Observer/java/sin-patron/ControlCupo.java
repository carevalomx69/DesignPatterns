// Una tercera reaccion: descontar un lugar del cupo del congreso.
public class ControlCupo {
    private int disponibles;

    public ControlCupo(int disponibles) {
        this.disponibles = disponibles;
    }

    public void descontar() {
        disponibles--;
        System.out.println("  [Cupo] Lugares disponibles: " + disponibles);
    }
}
