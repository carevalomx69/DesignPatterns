using System;
using System.Collections.Generic;

// El "Producto" - Ahora con múltiples constructores para manejar combinaciones.
public class Computadora
{
    // Partes mínimas requeridas
    public string Tipo { get; }
    public string CPU { get; }

    // Partes opcionales
    public string RAM { get; }
    public string Almacenamiento { get; }
    public string TarjetaGrafica { get; }
    
    // --- CONSTRUCTORES TELESCOPICOS (EL ANTI-PATRÓN) ---

    // 1. Constructor Básico: Solo el tipo y CPU (Mínimo necesario)
    public Computadora(string tipo, string cpu)
    {
        Tipo = tipo;
        CPU = cpu;
        Console.WriteLine($"\n<<Creando: {tipo} con {cpu}>>");
    }

    // 2. Constructor para: CPU y RAM
    public Computadora(string tipo, string cpu, string ram)
        : this(tipo, cpu) // Llama al constructor base para inicializar CPU
    {
        RAM = ram;
    }

    // 3. Constructor para: CPU, RAM y Almacenamiento
    public Computadora(string tipo, string cpu, string ram, string almacenamiento)
        : this(tipo, cpu, ram) // Llama al constructor con RAM
    {
        Almacenamiento = almacenamiento;
    }
    
    // 4. Constructor FULL: CPU, RAM, Almacenamiento y Tarjeta Gráfica
    public Computadora(string tipo, string cpu, string ram, string almacenamiento, string grafica)
        : this(tipo, cpu, ram, almacenamiento) // Llama al constructor con Almacenamiento
    {
        TarjetaGrafica = grafica;
    }

    // Método para mostrar la configuración
    public void MostrarConfiguracion()
    {
        Console.WriteLine($"--- Configuración de la {Tipo} ---");
        Console.WriteLine($"  CPU: {CPU}");
        Console.WriteLine($"  RAM: {(string.IsNullOrEmpty(RAM) ? "N/A" : RAM)}");
        Console.WriteLine($"  Almacenamiento: {(string.IsNullOrEmpty(Almacenamiento) ? "N/A" : Almacenamiento)}");
        Console.WriteLine($"  Gráfica: {(string.IsNullOrEmpty(TarjetaGrafica) ? "N/A" : TarjetaGrafica)}");
        Console.WriteLine("---------------------------------\n");
    }
}

// Clase principal para la ejecución.
class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("--- Configuración SIN Patrón Builder ---");

        // 1. Crear una PC de Oficina (Usando el constructor #3)
        // La secuencia de argumentos es rígida: (tipo, cpu, ram, almacenamiento)
        Computadora oficina = new Computadora(
            "Oficina",
            "Intel Core i3",
            "8 GB DDR4",
            "256 GB SATA SSD"
        );
        oficina.MostrarConfiguracion();

        // 2. Crear una PC Gamer FULL (Usando el constructor #4)
        Computadora gamerFull = new Computadora(
            "Gamer",
            "Intel Core i9",
            "32 GB DDR5",
            "1 TB NVMe SSD",
            "NVIDIA RTX 4080"
        );
        gamerFull.MostrarConfiguracion();

        // 3. Crear una PC con CPU y Gráfica, pero SIN RAM ni Almacenamiento.
        // ¡PROBLEMA! Esto no es posible sin un nuevo constructor o pasando 'null'
        // Tendríamos que usar el constructor #4 y pasar 'null' o "" a los campos intermedios.
        Console.WriteLine("--- Intento de Configuración Especial ---");
        Computadora especial = new Computadora(
            "Especial",
            "AMD Ryzen 7",
            null, // ¡RAM debe ser nulo!
            null, // ¡Almacenamiento debe ser nulo!
            "AMD Radeon RX 7900" 
        );
        especial.MostrarConfiguracion();
    }
}
