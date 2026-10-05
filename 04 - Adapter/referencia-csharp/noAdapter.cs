using System;

// Servicio de terceros con interfaz incompatible
public class ServicioTerceroPago
{
    public void RealizarTransaccion(double monto)
    {
        Console.WriteLine($"  [ServicioTercero]: Se realizó el cobro de ${monto:N2} USD.");
    }
    
    public bool ConsultarDisponibilidad()
    {
        Console.WriteLine("  [ServicioTercero]: Consultando la disponibilidad...");
        return true;
    }
}

// Cliente que necesita trabajar con el servicio
class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("--- Sistema Bancario (SIN Adapter) ---");
        
        ServicioTerceroPago servicio = new ServicioTerceroPago();
        
        // ❌ PROBLEMA 1: El cliente debe conocer la API del servicio tercero
        decimal montoOriginal = 125.50m;
        
        // ❌ PROBLEMA 2: El cliente debe hacer la conversión manualmente
        double montoConvertido = (double)montoOriginal;
        
        // ❌ PROBLEMA 3: El cliente llama directamente al servicio
        servicio.RealizarTransaccion(montoConvertido);
        
        // ❌ PROBLEMA 4: El cliente debe interpretar la respuesta
        bool disponible = servicio.ConsultarDisponibilidad();
        if (disponible)
        {
            Console.WriteLine("El servicio está disponible");
        }
        
        // ❌ PROBLEMA 5: Si cambias a otro proveedor de pagos,
        // debes modificar TODO el código del cliente
    }
}
