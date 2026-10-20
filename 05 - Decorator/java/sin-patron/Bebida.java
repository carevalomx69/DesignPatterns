// Clase base SIN el patron. Guarda la descripcion y el costo de la bebida.
// Los costos son pesos enteros (int) para no mezclar este ejemplo con el
// tema de precision decimal que se vio en Adapter.
public class Bebida {
    protected String descripcion;
    protected int costo;

    public void mostrar() {
        System.out.println("Bebida: " + descripcion);
        System.out.println("Costo: $" + costo);
    }
}
