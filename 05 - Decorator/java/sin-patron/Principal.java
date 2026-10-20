public class Principal {
    public static void main(String[] args) {
        System.out.println("--- Cafeteria (sin patron) ---\n");

        // El cliente tiene que elegir la clase exacta que corresponde a la
        // combinacion que quiere. No puede "agregarle" algo a una bebida ya
        // creada: si quiere otra combinacion, necesita otra clase.
        Bebida b1 = new CafeSimple();
        b1.mostrar();

        Bebida b2 = new CafeConLeche();
        b2.mostrar();

        Bebida b3 = new CafeConLecheYAzucar();
        b3.mostrar();

        // Si manana se agrega la crema como extra, hay que escribir una
        // clase por cada combinacion nueva que la incluya: CafeConCrema,
        // CafeConLecheYCrema, CafeConAzucarYCrema y CafeConLecheAzucarYCrema.
        // Y si cambia el precio de la leche, hay que corregirlo en cada clase
        // donde aparece.
        System.out.println("\n--- Fin ---");
    }
}
