using System;
using System.Collections.Generic;

// 1. Clientes (Ahora son clases normales, sin implementar ninguna interfaz de Observador)
public class ClienteMovil
{
    // El método de notificación debe ser conocido y llamado directamente por el Sujeto.
    public void RecibirActualizacion(string simbolo, decimal precio)
    {
        Console.WriteLine($"  [ClienteMovil]: Notificación recibida! Nuevo precio: ${precio:N2}.");
    }
}

public class ClienteEscritorio
{
    public void ProcesarAlerta(string simbolo, decimal precio)
    {
        if (precio < 100m)
        {
            Console.WriteLine($"  [ClienteEscritorio]: ¡Alerta de compra! Precio bajo: ${precio:N2}");
        }
    }
}

// 2. El Sujeto (¡Ahora acoplado a las clases Cliente!)
public class CotizacionAccion
{
    private string _simbolo;
    private decimal _precio;

    // EL PROBLEMA: El Sujeto debe mantener referencias a las CLASES CONCRETAS.
    private ClienteMovil _clienteMovil = new ClienteMovil();
    private ClienteEscritorio _clienteEscritorio = new ClienteEscritorio();

    public CotizacionAccion(string simbolo, decimal precio)
    {
        _simbolo = simbolo;
        _precio = precio;
        Console.WriteLine($"Cotización creada para {_simbolo} con precio inicial ${_precio:N2}");
    }

    // Método que cambia el estado.
    public void CambiarPrecio(decimal nuevoPrecio)
    {
        if (_precio != nuevoPrecio)
        {
            _precio = nuevoPrecio;
            Console.WriteLine($"\n[COTIZACIÓN] El precio de {_simbolo} ha cambiado a: ${_precio:N2}");
            
            // 3. Notificación Directa y Explícita (Alto Acoplamiento)
            // Aquí es donde el código viola el OCP y el Bajo Acoplamiento.
            _clienteMovil.RecibirActualizacion(_simbolo, _precio);
            _clienteEscritorio.ProcesarAlerta(_simbolo, _precio);
        }
    }
}

// Clase principal para la ejecución.
class Program
{
    static void Main(string[] args)
    {
        CotizacionAccion google = new CotizacionAccion("GOOGL", 150.00m);

        // No hay Suscribir/Desuscribir fácil; las dependencias son fijas.
        
        google.CambiarPrecio(155.50m); 
        google.CambiarPrecio(95.00m); 
        
        // PROBLEMA: No puedes dejar de notificar a ClienteMovil fácilmente.
        Console.WriteLine("\n--- Intento de Desuscripción (No es posible sin lógica compleja) ---");
        google.CambiarPrecio(80.00m);
    }
}
