using System;
using System.Collections.Generic;

// 1. Interfaz Observador (Define el método de notificación)
public interface IObservador
{
    void Actualizar(SujetoBolsa sujeto);
}

// 2. Interfaz Sujeto (Define la gestión de observadores)
public abstract class SujetoBolsa
{
    // Lista de clientes suscritos (relación uno a muchos)
    private List<IObservador> _observadores = new List<IObservador>();

    public void Suscribir(IObservador observador)
    {
        Console.WriteLine($"[SUJETO] Observador {observador.GetType().Name} suscrito.");
        _observadores.Add(observador);
    }

    public void Desuscribir(IObservador observador)
    {
        _observadores.Remove(observador);
        Console.WriteLine($"[SUJETO] Observador {observador.GetType().Name} desuscrito.");
    }

    // Método para Notificar a todos los suscritos.
    public void Notificar()
    {
        Console.WriteLine("\n[SUJETO] **NOTIFICANDO CAMBIO DE PRECIO A TODOS**");
        foreach (var observador in _observadores)
        {
            observador.Actualizar(this); // Polimorfismo: Llama al método 'Actualizar' de cada uno.
        }
    }
}

// 3. Sujeto Concreto (Mantiene el estado y dispara las notificaciones)
public class CotizacionAccion : SujetoBolsa
{
    private string _simbolo;
    private decimal _precio;

    public CotizacionAccion(string simbolo, decimal precio)
    {
        _simbolo = simbolo;
        _precio = precio;
        Console.WriteLine($"Cotización creada para {_simbolo} con precio inicial ${_precio:N2}");
    }

    public string Simbolo => _simbolo;
    public decimal Precio => _precio;

    // Método que cambia el estado y activa el patrón Observer.
    public void CambiarPrecio(decimal nuevoPrecio)
    {
        if (_precio != nuevoPrecio)
        {
            _precio = nuevoPrecio;
            Console.WriteLine($"\n[COTIZACIÓN] El precio de {_simbolo} ha cambiado a: ${_precio:N2}");
            Notificar(); // <-- ¡El Sujeto notifica sin saber a quién!
        }
    }
}

// 4. Observador Concreto 1 (Cliente móvil)
public class ClienteMovil : IObservador
{
    public void Actualizar(SujetoBolsa sujeto)
    {
        if (sujeto is CotizacionAccion cotizacion)
        {
            Console.WriteLine($"  [ClienteMovil]: Notificación recibida! Nuevo precio: ${cotizacion.Precio:N2}.");
        }
    }
}

// 5. Observador Concreto 2 (Cliente de escritorio, solo reacciona a precios bajos)
public class ClienteEscritorio : IObservador
{
    public void Actualizar(SujetoBolsa sujeto)
    {
        if (sujeto is CotizacionAccion cotizacion)
        {
            if (cotizacion.Precio < 100m)
            {
                Console.WriteLine($"  [ClienteEscritorio]: ¡Alerta de compra! Precio bajo: ${cotizacion.Precio:N2}");
            }
        }
    }
}

// Clase principal para la ejecución.
class Program
{
    static void Main(string[] args)
    {
        // El Sujeto
        CotizacionAccion google = new CotizacionAccion("GOOGL", 150.00m);

        // Los Observadores
        IObservador movil = new ClienteMovil();
        IObservador escritorio = new ClienteEscritorio();

        // Suscripción
        google.Suscribir(movil);
        google.Suscribir(escritorio);

        // --- Evento 1: Precio alto (ambos reciben notificación, solo Escritorio filtra) ---
        google.CambiarPrecio(155.50m); 

        // --- Evento 2: Precio bajo (el ClienteEscritorio muestra su lógica de alerta) ---
        google.CambiarPrecio(95.00m); 

        // --- Desuscripción y Evento 3: El cliente móvil ya no recibe la notificación ---
        google.Desuscribir(movil);
        google.CambiarPrecio(80.00m);
    }
}
