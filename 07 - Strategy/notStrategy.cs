using System;
using System.Collections.Generic;
using System.Linq;

// Producto a manipular (la clase se mantiene igual)
public class Producto
{
    public string Nombre { get; set; }
    public decimal Precio { get; set; }
    public override string ToString() => $"[Producto: {Nombre}, ${Precio:N2}]";
}

// 1. Contexto (¡Ahora maneja toda la lógica del algoritmo!)
// Esto viola el Principio de Responsabilidad Única (SRP).
public class Contexto
{
    private List<Producto> _listaProductos;

    public Contexto(List<Producto> productos)
    {
        _listaProductos = productos;
    }

    // El método ahora recibe un parámetro que define el algoritmo a usar.
    public void EjecutarOrdenamiento(string tipoOrdenamiento)
    {
        Console.WriteLine($"\n--- Contexto: Ejecutando ordenamiento por: {tipoOrdenamiento} ---");

        // 2. Sentencia condicional grande (El Anti-Patrón)
        switch (tipoOrdenamiento)
        {
            case "Nombre":
                Console.WriteLine("[Lógica Incrustada] Ordenando por Nombre (A-Z).");
                // Lógica de algoritmo 1
                _listaProductos.Sort((p1, p2) => string.Compare(p1.Nombre, p2.Nombre));
                break;

            case "Precio":
                Console.WriteLine("[Lógica Incrustada] Ordenando por Precio (menor a mayor).");
                // Lógica de algoritmo 2
                _listaProductos.Sort((p1, p2) => p1.Precio.CompareTo(p2.Precio));
                break;

            default:
                Console.WriteLine($"[Lógica Incrustada] Tipo de ordenamiento '{tipoOrdenamiento}' no reconocido.");
                return;
        }

        Console.WriteLine("Resultado:");
        _listaProductos.ForEach(p => Console.WriteLine(p));
    }
}

// Clase principal para la ejecución.
class Program
{
    static void Main(string[] args)
    {
        var lista = new List<Producto>
        {
            new Producto { Nombre = "Monitor", Precio = 250.00m },
            new Producto { Nombre = "Teclado", Precio = 45.00m },
            new Producto { Nombre = "Mouse", Precio = 15.00m }
        };

        Contexto contexto = new Contexto(lista);

        // Uso 1: Ordenar por Nombre
        contexto.EjecutarOrdenamiento("Nombre");

        // Uso 2: Ordenar por Precio
        contexto.EjecutarOrdenamiento("Precio");
    }
}
