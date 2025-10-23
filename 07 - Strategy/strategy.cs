using System;
using System.Collections.Generic;
using System.Linq;

// Producto a manipular
public class Producto
{
    public string Nombre { get; set; }
    public decimal Precio { get; set; }
    public override string ToString() => $"[Producto: {Nombre}, ${Precio:N2}]";
}

// 1. Interfaz de Estrategia (Define el contrato para todos los algoritmos).
public interface IEstrategiaOrdenamiento
{
    void Ordenar(List<Producto> productos);
}

// 2. Estrategia Concreta 1: Ordenar por Nombre
public class OrdenarPorNombre : IEstrategiaOrdenamiento
{
    public void Ordenar(List<Producto> productos)
    {
        Console.WriteLine("\n[Estrategia] Ordenando por Nombre (A-Z).");
        // Lógica específica para ordenar por nombre
        productos.Sort((p1, p2) => string.Compare(p1.Nombre, p2.Nombre));
    }
}

// 3. Estrategia Concreta 2: Ordenar por Precio
public class OrdenarPorPrecio : IEstrategiaOrdenamiento
{
    public void Ordenar(List<Producto> productos)
    {
        Console.WriteLine("\n[Estrategia] Ordenando por Precio (menor a mayor).");
        // Lógica específica para ordenar por precio
        productos.Sort((p1, p2) => p1.Precio.CompareTo(p2.Precio));
    }
}

// 4. Contexto (La clase que utiliza la Estrategia).
public class Contexto
{
    private IEstrategiaOrdenamiento _estrategia; // Referencia a la estrategia
    private List<Producto> _listaProductos;

    public Contexto(List<Producto> productos)
    {
        _listaProductos = productos;
    }

    // Método para establecer la estrategia dinámicamente.
    public void SetEstrategia(IEstrategiaOrdenamiento estrategia)
    {
        Console.WriteLine($"--- Contexto: Cambiando Estrategia a {estrategia.GetType().Name} ---");
        _estrategia = estrategia;
    }

    // El Contexto delega la ejecución del algoritmo a la estrategia actual.
    public void EjecutarOrdenamiento()
    {
        if (_estrategia == null)
        {
            Console.WriteLine("Contexto: No se ha establecido una estrategia de ordenamiento.");
            return;
        }
        
        _estrategia.Ordenar(_listaProductos); // Delegación
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
        contexto.SetEstrategia(new OrdenarPorNombre());
        contexto.EjecutarOrdenamiento();

        // Uso 2: Cambiar la estrategia y ordenar por Precio
        contexto.SetEstrategia(new OrdenarPorPrecio());
        contexto.EjecutarOrdenamiento();
    }
}
