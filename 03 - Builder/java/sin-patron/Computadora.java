public class Computadora {

    private final String cpu;              // obligatoria
    private final String ram;              // opcional
    private final String almacenamiento;   // opcional
    private final String tarjetaGrafica;   // opcional

    // CONSTRUCTORES TELESCOPICOS. Para soportar cada combinacion de datos
    // opcionales se escribe un constructor que agrega un parametro mas a
    // la lista del anterior. Los argumentos tienen un ORDEN fijo.
    public Computadora(String cpu) {
        this(cpu, null);
    }

    public Computadora(String cpu, String ram) {
        this(cpu, ram, null);
    }

    public Computadora(String cpu, String ram, String almacenamiento) {
        this(cpu, ram, almacenamiento, null);
    }

    public Computadora(String cpu, String ram, String almacenamiento, String tarjetaGrafica) {
        this.cpu = cpu;
        this.ram = ram;
        this.almacenamiento = almacenamiento;
        this.tarjetaGrafica = tarjetaGrafica;
    }

    public void mostrarConfiguracion() {
        System.out.println("  CPU: " + cpu);
        System.out.println("  RAM: " + (ram == null ? "N/A" : ram));
        System.out.println("  Almacenamiento: " + (almacenamiento == null ? "N/A" : almacenamiento));
        System.out.println("  Grafica: " + (tarjetaGrafica == null ? "N/A" : tarjetaGrafica));
    }
}
