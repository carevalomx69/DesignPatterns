using System;

public class Config
{
    private static Config instancia;
    public string Valor { get; set; }

    private Config()
    {
        Valor = "Configuración inicial";
    }

    public static Config GetInstancia()
    {
        if (instancia == null)
        {
            instancia = new Config();
        }
        return instancia;
    }
}

class Program
{
    static void Main()
    {
        var config1 = Config.GetInstancia();
        var config2 = Config.GetInstancia();

        config1.Valor = "Configuración modificada";

        Console.WriteLine(config2.Valor);
        Console.WriteLine(Object.ReferenceEquals(config1, config2));
    }
}
