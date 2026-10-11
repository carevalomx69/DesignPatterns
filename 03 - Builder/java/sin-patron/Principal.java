public class Principal {
    public static void main(String[] args) {
        System.out.println("--- Armado de computadoras (sin patron) ---");

        // Caso 1. Oficina: cpu, ram y almacenamiento. Usa el constructor de
        // tres argumentos. Hay que recordar el orden: cpu, ram, almacenamiento.
        System.out.println("\nOficina");
        Computadora oficina = new Computadora("Intel Core i3", "8 GB DDR4", "256 GB SATA SSD");
        oficina.mostrarConfiguracion();

        // Caso 2. Gamer: todos los datos, constructor de cuatro argumentos.
        System.out.println("\nGamer");
        Computadora gamer = new Computadora("Intel Core i9", "32 GB DDR5", "1 TB NVMe SSD", "NVIDIA RTX 4080");
        gamer.mostrarConfiguracion();

        // Caso 3. Especial: cpu y grafica, pero SIN ram ni almacenamiento.
        // No existe un constructor para esa combinacion, asi que hay que
        // usar el de cuatro argumentos y rellenar los huecos con null.
        System.out.println("\nEspecial");
        Computadora especial = new Computadora("AMD Ryzen 7", null, null, "AMD Radeon RX 7900");
        especial.mostrarConfiguracion();

        // Caso 4. Un descuido: se intercambiaron cpu y ram. Todos los
        // argumentos son String, asi que el compilador NO se queja. El
        // programa corre sin errores y muestra un dato equivocado.
        System.out.println("\nDescuido");
        Computadora descuido = new Computadora("8 GB DDR4", "Intel Core i3", "256 GB SATA SSD");
        descuido.mostrarConfiguracion();

        System.out.println("\n--- Fin ---");
    }
}
