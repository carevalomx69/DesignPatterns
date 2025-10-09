using System;

// 1. Declaración de la clase Singleton
public class Logger
{
    // 2. Campo estático y privado para contener la única instancia.
    // 'readonly' asegura que solo se asigna durante la inicialización.
    private static readonly Logger _instance = new Logger();

    // 3. Contador simple para demostrar que es la misma instancia.
    private int _logCount = 0;

    // 4. Constructor privado para evitar la instanciación directa (fuera de la propia clase).
    private Logger()
    {
        Console.WriteLine("Logger: ¡Se ha creado la única instancia!");
    }

    // 5. Propiedad estática y pública para obtener la única instancia.
    public static Logger Instance
    {
        get { return _instance; }
    }

    // 6. Método para registrar un mensaje.
    public void Log(string message)
    {
        _logCount++;
        Console.WriteLine($"[{_logCount}] LOG: {message}");
    }
}

// Clase principal para la ejecución.
class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("--- Iniciando aplicación ---");

        // 7. Accedemos a la única instancia del Logger.
        Logger logger1 = Logger.Instance;
        logger1.Log("Primer evento registrado.");

        // 8. Volvemos a acceder a la única instancia (¡será la misma!).
        Logger logger2 = Logger.Instance;
        logger2.Log("Segundo evento registrado desde otra parte del código.");

        // 9. Comprobación: Ambas referencias (logger1 y logger2) apuntan al mismo objeto.
        if (ReferenceEquals(logger1, logger2))
        {
            Console.WriteLine("\nCOMPROBACIÓN: logger1 y logger2 son la MISMA instancia.");
        }
        else
        {
            Console.WriteLine("\nERROR: Se crearon múltiples instancias.");
        }

        Console.WriteLine("--- Finalizando aplicación ---");
    }
}
