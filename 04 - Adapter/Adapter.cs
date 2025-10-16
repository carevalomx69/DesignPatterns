using System;

// 1. Interfaz Objetivo (La interfaz que nuestro sistema CLIENTE espera usar).
public interface IPagoNuevo
{
    void ProcesarPago(decimal cantidad);
    void ObtenerEstado();
}

// 2. Clase Existente (El Adaptado) - Incompatible con la interfaz objetivo.
public class ServicioTerceroPago
{
    // Método con nombre diferente (RealizarTransaccion)
    // y tipo de dato diferente (double en lugar de decimal).
    public void RealizarTransaccion(double monto)
    {
        Console.WriteLine($"  [ServicioTercero]: Se realizó el cobro de ${monto:N2} USD.");
    }

    public bool ConsultarDisponibilidad()
    {
        Console.WriteLine("  [ServicioTercero]: Consultando la disponibilidad del sistema...");
        return true;
    }
}

// 3. El Adaptador (Patrón Adapter)
// Implementa la interfaz Objetivo (IPagoNuevo) y usa una instancia del Adaptado.
public class AdaptadorPagoTercero : IPagoNuevo
{
    // Referencia al objeto que queremos adaptar.
    private readonly ServicioTerceroPago _servicioTercero;

    public AdaptadorPagoTercero(ServicioTerceroPago servicioTercero)
    {
        _servicioTercero = servicioTercero;
    }

    // Implementa el método Objetivo
    public void ProcesarPago(decimal cantidad)
    {
        Console.WriteLine("\n[Adaptador] Iniciando procesamiento de pago...");
        
        // **TRADUCCIÓN DE DATOS:** Convierte 'decimal' a 'double'.
        double montoTercero = (double)cantidad; 

        // Llama al método del Adaptado.
        _servicioTercero.RealizarTransaccion(montoTercero);
        
        Console.WriteLine("[Adaptador] Pago procesado y adaptado.");
    }

    // Implementa el método Objetivo
    public void ObtenerEstado()
    {
        Console.WriteLine("\n[Adaptador] Obteniendo estado del servicio...");
        
        // Llama al método del Adaptado y traduce su resultado
        if (_servicioTercero.ConsultarDisponibilidad())
        {
            Console.WriteLine("[Adaptador] El servicio de terceros está ACTIVO.");
        }
    }
}

// Clase principal para la ejecución (El Cliente).
class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("--- Sistema Bancario Central ---");
        
        // El servicio que no podemos modificar (el Adaptado)
        ServicioTerceroPago servicioExistente = new ServicioTerceroPago();

        // Creamos el Adaptador, pasándole el servicio existente.
        IPagoNuevo adaptador = new AdaptadorPagoTercero(servicioExistente);

        // El cliente (RealizarAccionesPago) solo ve la interfaz IPagoNuevo.
        RealizarAccionesPago(adaptador, 125.50m);
        
        Console.WriteLine("--- Fin de la demostración ---");
    }

    // El método Cliente solo acepta la interfaz IPagoNuevo.
    static void RealizarAccionesPago(IPagoNuevo procesador, decimal monto)
    {
        procesador.ProcesarPago(monto);
        procesador.ObtenerEstado();
    }
}
