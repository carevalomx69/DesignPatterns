// 1. Componente Base/Interfaz
public interface IBebida
{
    string GetDescripcion();
    double GetCosto();
}

// 2. Componente Concreto (El objeto a decorar)
public class Cafe : IBebida
{
    public string GetDescripcion() => "Café Base";
    public double GetCosto() => 5.0;
}

// 3. Decorador Base
public abstract class AdicionDecorator : IBebida
{
    // Mantiene una referencia al objeto envuelto
    protected IBebida bebidaEnvuelto;

    public AdicionDecorator(IBebida bebida)
    {
        this.bebidaEnvuelto = bebida;
    }

    public abstract string GetDescripcion();
    public abstract double GetCosto();
}

// 4. Decorador Concreto
public class Leche : AdicionDecorator
{
    public Leche(IBebida bebida) : base(bebida) { }

    public override string GetDescripcion() => bebidaEnvuelto.GetDescripcion() + ", Leche";
    public override double GetCosto() => bebidaEnvuelto.GetCosto() + 1.5;
}

// Uso:
// IBebida miCafe = new Cafe(); // Costo: 5.0, Desc: Café Base
// miCafe = new Leche(miCafe);  // Costo: 6.5, Desc: Café Base, Leche
// Console.WriteLine($"Costo: {miCafe.GetCosto()} - {miCafe.GetDescripcion()}");
