public class Principal {
    public static void main(String[] args) {
        System.out.println("--- Armado de computadoras (con patron) ---");

        // Caso 1. Oficina. Cada dato opcional se pide POR NOMBRE. Se lee casi
        // como una frase, y el orden de las llamadas ya no importa.
        System.out.println("\nOficina");
        Computadora oficina = new Computadora.Builder("Intel Core i3")
                .ram("8 GB DDR4")
                .almacenamiento("256 GB SATA SSD")
                .build();
        oficina.mostrarConfiguracion();

        // Caso 2. Gamer: todos los datos.
        System.out.println("\nGamer");
        Computadora gamer = new Computadora.Builder("Intel Core i9")
                .ram("32 GB DDR5")
                .almacenamiento("1 TB NVMe SSD")
                .tarjetaGrafica("NVIDIA RTX 4080")
                .build();
        gamer.mostrarConfiguracion();

        // Caso 3. Especial: cpu y grafica. Solo se llama a lo que se
        // necesita. No hay null en ninguna parte del codigo que usa la clase.
        System.out.println("\nEspecial");
        Computadora especial = new Computadora.Builder("AMD Ryzen 7")
                .tarjetaGrafica("AMD Radeon RX 7900")
                .build();
        especial.mostrarConfiguracion();

        // El descuido del caso 4 de la version sin patron aqui es mas dificil.
        // Para confundir cpu con ram habria que escribir ".ram("Intel Core i3")",
        // y el error se ve en la propia linea, porque cada dato lleva su nombre.
        System.out.println("\n--- Fin ---");
    }
}
