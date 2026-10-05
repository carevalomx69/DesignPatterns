using System;

// Clase Base Simple
public class Bebida
{
    // Las propiedades se establecen en los constructores de las subclases.
    public string Descripcion { get; protected set; }
    public double Costo { get; protected set; }

    public void Mostrar()
    {
        Console.WriteLine($"\nBebida: {Descripcion}");
        Console.WriteLine($"Costo: ${Costo:N2}");
    }
}

// 1. Caso Base
public class CafeSimple : Bebida
{
    public CafeSimple()
    {
        Descripcion = "Café Negro Simple";
        Costo = 2.0;
    }
}

// 2. Combinación A: Un ingrediente
public class CafeConLeche : Bebida
{
    public CafeConLeche()
    {
        Descripcion = "Café Negro Simple, con Leche";
        Costo = 2.0 + 0.5;
    }
}

// 3. Combinación B: Un ingrediente diferente
public class CafeConAzucar : Bebida
{
    public CafeConAzucar()
    {
        Descripcion = "Café Negro Simple, con Azúcar";
        Costo = 2.0 + 0.1;
    }
}

// 4. ¡EL PROBLEMA! Combinación C: Dos ingredientes
// Necesitamos una CLASE NUEVA para esta combinación.
public class CafeConLecheYAzucar : Bebida
{
    public CafeConLecheYAzucar()
    {
        Descripcion = "Café Negro Simple, con Leche, con Azúcar";
        Costo = 2.0 + 0.5 + 0.1;
    }
}


// Clase principal para la ejecución.
class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("--- Aplicación de Café: SIN Patrón Decorator (Herencia) ---");

        // Uso de clases rígidas:
        CafeSimple cafe1 = new CafeSimple();
        cafe1.Mostrar();

        // El cliente debe instanciar la clase exacta que quiere.
        CafeConLeche cafe2 = new CafeConLeche();
        cafe2.Mostrar();

        // Se necesita una clase separada para cada combinación
        CafeConLecheYAzucar cafe3 = new CafeConLecheYAzucar();
        cafe3.Mostrar();
        
        // Conclusión: Si agregamos 'Crema', se necesitarían 8 nuevas clases (2^3)
    }
}
