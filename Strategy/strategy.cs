// 1. Interfaz Strategy
public interface IEstrategiaCalculoViabilidad
{
    string CalcularViabilidad(double inversionInicial, double flujoCajaPromedio);
}

// 2. Concrete Strategy A: VPN
public class EstrategiaVPN : IEstrategiaCalculoViabilidad
{
    public string CalcularViabilidad(double inversionInicial, double flujoCajaPromedio)
    {
        // Lógica simplificada de VPN para el ejemplo
        if (flujoCajaPromedio * 5 > inversionInicial) // Asumimos 5 periodos
        {
            return $"VPN Positivo. Proyecto Viable. (Ficticio: {flujoCajaPromedio * 5 - inversionInicial:C})";
        }
        return "VPN Negativo. Proyecto NO Viable.";
    }
}

// 3. Concrete Strategy B: Periodo de Recuperación (PR)
public class EstrategiaPR : IEstrategiaCalculoViabilidad
{
    public string CalcularViabilidad(double inversionInicial, double flujoCajaPromedio)
    {
        double periodoRecuperacion = inversionInicial / flujoCajaPromedio;
        return $"Periodo de Recuperación: {periodoRecuperacion:F2} años.";
    }
}

// 4. Contexto
public class SimuladorFinanciero
{
    private IEstrategiaCalculoViabilidad _estrategia;

    public SimuladorFinanciero(IEstrategiaCalculoViabilidad estrategia)
    {
        this._estrategia = estrategia;
    }

    public void SetEstrategia(IEstrategiaCalculoViabilidad estrategia)
    {
        this._estrategia = estrategia;
    }

    public void EjecutarCalculo(double inversionInicial, double flujoCajaPromedio)
    {
        string resultado = this._estrategia.CalcularViabilidad(inversionInicial, flujoCajaPromedio);
        Console.WriteLine($"Resultado con {this._estrategia.GetType().Name}: {resultado}");
    }
}

// Uso:
/*
double inv = 10000;
double flujo = 3000;

// Usar la estrategia de VPN
SimuladorFinanciero simulador = new SimuladorFinanciero(new EstrategiaVPN());
simulador.EjecutarCalculo(inv, flujo);

// Cambiar a la estrategia de Periodo de Recuperación en tiempo de ejecución
simulador.SetEstrategia(new EstrategiaPR());
simulador.EjecutarCalculo(inv, flujo);
*/
