using System;

public interface IProducto
{
    void Operar();
}

public class ProductoConcreto : IProducto
{
    public void Operar()
    {
        Console.WriteLine("Operación del producto concreto.");
    }
}

public abstract class Creador
{
    public abstract IProducto CrearProducto();
}

public class CreadorConcreto : Creador
{
    public override IProducto CrearProducto()
    {
        return new ProductoConcreto();
    }
}

class Program
{
    static void Main()
    {
        Creador creador = new CreadorConcreto();
        IProducto producto = creador.CrearProducto();
        producto.Operar();
    }
}
