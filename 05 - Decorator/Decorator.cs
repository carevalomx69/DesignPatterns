using System;

// 1. Componente Base (Define la interfaz para objetos base y decoradores).
public abstract class Bebida
{
    public abstract string ObtenerDescripcion();
    public abstract double ObtenerCosto();
}

// 2. Componente Concreto (El objeto base).
public class CafeSimple : Bebida
{
    public override string ObtenerDescripcion() => "Café Negro Simple";
    public override double ObtenerCosto() => 2.0;
}

// 3. Clase Decorador Base (Abstracta).
// Hereda de Bebida e internamente contiene una referencia a un objeto Bebida (Composición).
public abstract class DecoradorBebida : Bebida
{
    protected Bebida _bebida; // Referencia al objeto envuelto (la Composición)

    public DecoradorBebida(Bebida bebida)
    {
        _bebida = bebida;
    }

    // Delega el comportamiento por defecto al objeto envuelto.
    public override string ObtenerDescripcion() => _bebida.ObtenerDescripcion();
    public override double ObtenerCosto() => _bebida.ObtenerCosto();
}

// 4. Decorador Concreto 1 (Añade Leche)
public class Leche : DecoradorBebida
{
    public Leche(Bebida bebida) : base(bebida) { }

    // Sobrescribe, llama al base y agrega su propia lógica.
    public override string ObtenerDescripcion() => base.ObtenerDescripcion() + ", con Leche";
    public override double ObtenerCosto() => base.ObtenerCosto() + 0.5;
}

// 5. Decorador Concreto 2 (Añade Azúcar)
public class Azucar : DecoradorBebida
{
    public Azucar(Bebida bebida) : base(bebida) { }

    // Sobrescribe, llama al base y agrega su propia lógica.
    public override string ObtenerDescripcion() => base.ObtenerDescripcion() + ", con Azúcar";
    public override double ObtenerCosto() => base.ObtenerCosto() + 0.1;
}

// Clase principal para la ejecución.
class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("--- Aplicación de Café: Patrón Decorator ---");

        // 1. Crear el objeto base
        Bebida miCafe = new CafeSimple();
        MostrarBebida(miCafe); // Costo: $2.00

        // 2. Decorar con Leche (miCafe ahora es Leche, que envuelve a CafeSimple)
        miCafe = new Leche(miCafe); 
        MostrarBebida(miCafe); // Costo: $2.50 (2.0 + 0.5)

        // 3. Decorar con Azúcar (miCafe ahora es Azucar, que envuelve a Leche, que envuelve a CafeSimple)
        miCafe = new Azucar(miCafe); 
        MostrarBebida(miCafe); // Costo: $2.60 (2.5 + 0.1)

        Console.WriteLine("\n*** Observar la composición dinámica ***");
        // El cliente compone el objeto apilando decoradores.
    }
    
    static void MostrarBebida(Bebida bebida)
    {
        Console.WriteLine($"\nBebida: {bebida.ObtenerDescripcion()}");
        Console.WriteLine($"Costo: ${bebida.ObtenerCosto():N2}");
    }
}
