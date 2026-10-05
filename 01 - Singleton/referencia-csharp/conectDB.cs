// El Singleton
public sealed class GestorConexion
{
    // 1. Instancia estática privada (Lazy loading)
    private static readonly Lazy<GestorConexion> _lazyInstance =
        new Lazy<GestorConexion>(() => new GestorConexion());

    // 2. Propiedad estática para acceder a la única instancia
    public static GestorConexion GetInstancia => _lazyInstance.Value;

    // 3. Constructor privado para prevenir la instanciación externa
    private GestorConexion()
    {
        Console.WriteLine("Gestor de Conexión Creado (¡Solo una vez!)");
        this.EstadoConexion = "Desconectado";
    }

    public string EstadoConexion { get; private set; }

    public void Conectar()
    {
        this.EstadoConexion = "Conectado";
        Console.WriteLine($"Conexión establecida. Hash: {this.GetHashCode()}");
    }

    public void Desconectar()
    {
        this.EstadoConexion = "Desconectado";
        Console.WriteLine("Conexión finalizada.");
    }
}

// Uso:
/*
// Ambas variables apuntan a la misma única instancia
GestorConexion c1 = GestorConexion.GetInstancia;
c1.Conectar();

GestorConexion c2 = GestorConexion.GetInstancia;
Console.WriteLine($"c1 es igual a c2: {c1 == c2}"); // True
c2.Desconectar(); 
*/
