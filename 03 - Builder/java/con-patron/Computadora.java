public class Computadora {

    private final String cpu;              // obligatoria
    private final String ram;              // opcional
    private final String almacenamiento;   // opcional
    private final String tarjetaGrafica;   // opcional

    // Constructor PRIVADO. Nadie desde fuera arma una Computadora
    // directamente. Se arma con el Builder, que le entrega todos los datos.
    private Computadora(Builder b) {
        this.cpu = b.cpu;
        this.ram = b.ram;
        this.almacenamiento = b.almacenamiento;
        this.tarjetaGrafica = b.tarjetaGrafica;
    }

    public void mostrarConfiguracion() {
        System.out.println("  CPU: " + cpu);
        System.out.println("  RAM: " + (ram == null ? "N/A" : ram));
        System.out.println("  Almacenamiento: " + (almacenamiento == null ? "N/A" : almacenamiento));
        System.out.println("  Grafica: " + (tarjetaGrafica == null ? "N/A" : tarjetaGrafica));
    }

    // EL BUILDER. Es una clase anidada que va juntando los datos paso a paso.
    public static class Builder {
        private final String cpu;          // obligatoria, va en el constructor
        private String ram;                // opcionales, con valor por omision null
        private String almacenamiento;
        private String tarjetaGrafica;

        public Builder(String cpu) {
            this.cpu = cpu;
        }

        // Cada paso OPCIONAL tiene nombre y devuelve el mismo Builder (this),
        // para poder encadenar las llamadas una tras otra.
        public Builder ram(String ram) {
            this.ram = ram;
            return this;
        }

        public Builder almacenamiento(String almacenamiento) {
            this.almacenamiento = almacenamiento;
            return this;
        }

        public Builder tarjetaGrafica(String tarjetaGrafica) {
            this.tarjetaGrafica = tarjetaGrafica;
            return this;
        }

        // Entrega el producto terminado. Es el lugar natural para validar
        // que los datos obligatorios esten completos antes de crear el objeto.
        public Computadora build() {
            return new Computadora(this);
        }
    }
}
