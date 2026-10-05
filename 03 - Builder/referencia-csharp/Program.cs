using System;
using System.Collections.Generic;
using System.Linq;

// 1. Producto Complejo (la clase que queremos construir).
public class Computadora
{
    private Dictionary<string, string> _partes = new Dictionary<string, string>();
    public string Tipo { get; set; }

    public Computadora(string tipo)
    {
        Tipo = tipo;
    }

    public void AgregarParte(string nombre, string valor)
    {
        _partes.Add(nombre, valor);
    }

    public void MostrarConfiguracion()
    {
        Console.WriteLine($"\n--- Configuración de la {Tipo} ---");
        foreach (var parte in _partes)
        {
            Console.WriteLine($"  {parte.Key}: {parte.Value}");
        }
        Console.WriteLine("---------------------------------\n");
    }
}

// 2. Interfaz Builder (Define los pasos de construcción).
public interface IComputadoraBuilder
{
    void ConfigurarCPU();
    void ConfigurarRAM();
    void ConfigurarAlmacenamiento();
    Computadora GetResultado();
}

// 3. Concrete Builder (Constructor concreto para un tipo de producto).
public class BuilderGamer : IComputadoraBuilder
{
    private Computadora _computadora = new Computadora("Computadora Gamer");

    public void ConfigurarCPU() => _computadora.AgregarParte("CPU", "Intel Core i9 (Alto Rendimiento)");
    public void ConfigurarRAM() => _computadora.AgregarParte("RAM", "32 GB DDR5");
    public void ConfigurarAlmacenamiento() => _computadora.AgregarParte("Almacenamiento", "1 TB NVMe SSD + 2 TB HDD");
    public Computadora GetResultado() => _computadora;
}

// 4. Concrete Builder (Otro constructor concreto para otro tipo de producto).
public class BuilderOficina : IComputadoraBuilder
{
    private Computadora _computadora = new Computadora("Computadora de Oficina");

    public void ConfigurarCPU() => _computadora.AgregarParte("CPU", "Intel Core i3 (Bajo Consumo)");
    public void ConfigurarRAM() => _computadora.AgregarParte("RAM", "8 GB DDR4");
    public void ConfigurarAlmacenamiento() => _computadora.AgregarParte("Almacenamiento", "256 GB SATA SSD");
    public Computadora GetResultado() => _computadora;
}

// 5. Director (Opcional, pero recomendado). 
// Define el orden para construir, pero no los detalles de las partes.
public class Director
{
    public void ConstruirComputadoraCompleta(IComputadoraBuilder builder)
    {
        builder.ConfigurarCPU();
        builder.ConfigurarRAM();
        builder.ConfigurarAlmacenamiento();
    }
}

// Clase principal para la ejecución.
class Program
{
    static void Main(string[] args)
    {
        Director director = new Director();
        
        // 1. Construir la Computadora Gamer
        BuilderGamer builderGamer = new BuilderGamer();
        director.ConstruirComputadoraCompleta(builderGamer);
        Computadora gamer = builderGamer.GetResultado();
        gamer.MostrarConfiguracion();

        // 2. Construir la Computadora de Oficina
        BuilderOficina builderOficina = new BuilderOficina();
        director.ConstruirComputadoraCompleta(builderOficina);
        Computadora oficina = builderOficina.GetResultado();
        oficina.MostrarConfiguracion();

        // 3. Construcción personalizada (sin Director)
        Console.WriteLine("--- Construcción Personalizada ---");
        BuilderGamer builderPersonalizado = new BuilderGamer();
        builderPersonalizado.ConfigurarCPU(); // Solo agregar CPU
        Computadora pcParcial = builderPersonalizado.GetResultado();
        pcParcial.MostrarConfiguracion(); 
    }
}
