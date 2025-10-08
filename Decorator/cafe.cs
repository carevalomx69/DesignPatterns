using System;

public interface ICafe
{
    string ObtenerDescripcion();
    double ObtenerCosto();
}

public class CafeSimple : ICafe
{
    public string ObtenerDescripcion() => "Café simple";
    public double ObtenerCosto() => 10.0;
}

public abstract class CafeDecorador : ICafe
{
    protected ICafe cafe;

    public CafeDecorador(ICafe cafe)
    {
        this.cafe = cafe;
    }

    public virtual string ObtenerDescripcion() => cafe.ObtenerDescripcion();
    public virtual double ObtenerCosto() => cafe.ObtenerCosto();
}

public class ConLeche : CafeDecorador
{
    public ConLeche(ICafe cafe) : base(cafe) { }

    public override string ObtenerDescripcion() => base.ObtenerDescripcion() + ", con leche";
    public override double ObtenerCosto() => base.ObtenerCosto() + 3.0;
}

public class ConChocolate : CafeDecorador
{
    public ConChocolate(ICafe cafe) : base(cafe) { }

    public override string ObtenerDescripcion() => base.ObtenerDescripcion() + ", con chocolate";
    public override double ObtenerCosto() => base.ObtenerCosto() + 2.0;
}

class Program
{
    static void Main()
    {
        ICafe miCafe = new CafeSimple();
        miCafe = new ConLeche(miCafe);
        miCafe = new ConChocolate(miCafe);

        Console.WriteLine(miCafe.ObtenerDescripcion());
        Console.WriteLine("Costo: $" + miCafe.ObtenerCosto());
    }
}
