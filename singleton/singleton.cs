// Singleton.cs
public class ConfiguracionManager
{
    // 1. Almacenamiento de la instancia única
    private static ConfiguracionManager _instancia;

    // 2. Bloqueo para asegurar la seguridad de hilos (thread-safe)
    private static readonly object _bloqueo = new object();

    // Propiedad para almacenar una configuración de ejemplo
    public string Tema { get; private set; } = "Oscuro";

    // 3. Constructor privado para evitar la instanciación externa
    private ConfiguracionManager()
    {
        // Lógica de inicialización (ej. leer archivo de configuración)
    }

    // 4. Método estático público para obtener la instancia
    public static ConfiguracionManager GetInstancia()
    {
        // Doble verificación de bloqueo para mejor rendimiento
        if (_instancia == null)
        {
            lock (_bloqueo)
            {
                if (_instancia == null)
                {
                    _instancia = new ConfiguracionManager();
                }
            }
        }
        return _instancia;
    }

    public void MostrarConfiguracion()
    {
        Console.WriteLine($"Tema actual: {Tema}");
    }
}

// Uso
// ConfiguracionManager c1 = new ConfiguracionManager(); // Error: constructor privado
var c1 = ConfiguracionManager.GetInstancia();
c1.MostrarConfiguracion(); // Salida: Tema actual: Oscuro

var c2 = ConfiguracionManager.GetInstancia();
Console.WriteLine(ReferenceEquals(c1, c2)); // Salida: True (es la misma instancia)
