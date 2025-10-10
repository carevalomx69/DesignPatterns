// 1. Interfaz Observer
public interface IObserver
{
    void Actualizar(ISujeto sujeto);
}

// 2. Interfaz Sujeto
public interface ISujeto
{
    void Suscribir(IObserver observer);
    void Desuscribir(IObserver observer);
    void Notificar();
}

// 3. Concrete Sujeto: Registro de Eventos
public class EventoRegistro : ISujeto
{
    private List<IObserver> _observadores = new List<IObserver>();
    public string Estado { get; private set; } = "Inicial"; // Estado (ej: Nombre del alumno inscrito)

    public void Suscribir(IObserver observer) => this._observadores.Add(observer);
    public void Desuscribir(IObserver observer) => this._observadores.Remove(observer);

    public void Notificar()
    {
        foreach (var observer in _observadores)
        {
            observer.Actualizar(this);
        }
    }

    // Método que provoca el cambio de estado (el evento)
    public void RegistrarAsistencia(string nombreAlumno)
    {
        this.Estado = $"Asistencia de {nombreAlumno} registrada.";
        Console.WriteLine($"\nSUJETO: Se ha registrado una nueva asistencia: {nombreAlumno}");
        this.Notificar();
    }
}

// 4. Concrete Observer A: Generar Constancia
public class GeneradorConstancias : IObserver
{
    public void Actualizar(ISujeto sujeto)
    {
        if (sujeto is EventoRegistro evento)
        {
            Console.WriteLine($"GeneradorConstancias: Procesando... {evento.Estado}");
            // Lógica para generar y firmar constancia...
        }
    }
}

// 5. Concrete Observer B: Notificar Email
public class NotificadorEmail : IObserver
{
    public void Actualizar(ISujeto sujeto)
    {
        if (sujeto is EventoRegistro evento)
        {
            Console.WriteLine($"NotificadorEmail: Enviando correo... {evento.Estado}");
            // Lógica para enviar email de bienvenida o agradecimiento...
        }
    }
}

// Uso:
/*
var registro = new EventoRegistro();
var constancias = new GeneradorConstancias();
var email = new NotificadorEmail();

registro.Suscribir(constancias);
registro.Suscribir(email);

registro.RegistrarAsistencia("Juan Pérez");

registro.Desuscribir(email);

registro.RegistrarAsistencia("María López");
*/
