// 1. Producto (Interfaz o Clase Abstracta)
public interface IEstrategiaCalculoViabilidad
{
    string Calcular();
}

// 2. Productos Concretos (Estrategias de cálculo)
public class EstrategiaVPN : IEstrategiaCalculoViabilidad
{
    public string Calcular() => "Cálculo de Viabilidad realizado usando VPN.";
}

public class EstrategiaTIR : IEstrategiaCalculoViabilidad
{
    public string Calcular() => "Cálculo de Viabilidad realizado usando TIR.";
}

// 3. La Clase Factory (Simple Factory - una versión común en C#)
public class FabricaEstrategias
{
    public static IEstrategiaCalculoViabilidad CrearEstrategia(string tipo)
    {
        switch (tipo.ToUpper())
        {
            case "VPN":
                return new EstrategiaVPN();
            case "TIR":
                return new EstrategiaTIR();
            default:
                throw new ArgumentException($"Tipo de estrategia '{tipo}' no reconocido.");
        }
    }
}

// 4. Uso (El cliente solo pide el objeto a la fábrica)
/*
// El cliente solo conoce la interfaz y el nombre de la estrategia.
IEstrategiaCalculoViabilidad estrategia1 = FabricaEstrategias.CrearEstrategia("VPN");
Console.WriteLine(estrategia1.Calcular());

IEstrategiaCalculoViabilidad estrategia2 = FabricaEstrategias.CrearEstrategia("TIR");
Console.WriteLine(estrategia2.Calcular());
*/
