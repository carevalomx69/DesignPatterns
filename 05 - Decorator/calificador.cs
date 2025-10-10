// 1. Componente: Interfaz Base
public interface ICalificacion
{
    double ObtenerCalificacion();
    string ObtenerDescripcion();
}

// 2. Componente Concreto: La Clase Base
public class CalificacionProyecto : ICalificacion
{
    private readonly double _calificacionBase = 80.0;

    public double ObtenerCalificacion() => _calificacionBase;

    public string ObtenerDescripcion() => $"Calificación Base ({_calificacionBase:F1})";
}

// 3. Decorador Base
public abstract class DecoradorCalificacion : ICalificacion
{
    protected ICalificacion _calificacionBase;

    public DecoradorCalificacion(ICalificacion calificacionBase)
    {
        this._calificacionBase = calificacionBase;
    }

    // Por defecto, delega el comportamiento
    public virtual double ObtenerCalificacion() => _calificacionBase.ObtenerCalificacion();
    public virtual string ObtenerDescripcion() => _calificacionBase.ObtenerDescripcion();
}

// 4. Decorador Concreto A: Añadir Bono
public class DecoradorBonoImpacto : DecoradorCalificacion
{
    public DecoradorBonoImpacto(ICalificacion calificacionBase) : base(calificacionBase) { }

    public override double ObtenerCalificacion()
    {
        // Añade +5 puntos al resultado
        return base.ObtenerCalificacion() + 5.0;
    }

    public override string ObtenerDescripcion()
    {
        return $"{base.ObtenerDescripcion()} + Bono por Impacto Social (+5)";
    }
}

// 5. Decorador Concreto B: Añadir Descuento
public class DecoradorDescuentoRetraso : DecoradorCalificacion
{
    public DecoradorDescuentoRetraso(ICalificacion calificacionBase) : base(calificacionBase) { }

    public override double ObtenerCalificacion()
    {
        // Resta 10 puntos al resultado
        return base.ObtenerCalificacion() - 10.0;
    }

    public override string ObtenerDescripcion()
    {
        return $"{base.ObtenerDescripcion()} - Descuento por Entrega Tarde (-10)";
    }
}

// Uso:
/*
// 1. Proyecto con Calificación Base
ICalificacion proyecto = new CalificacionProyecto();
Console.WriteLine($"Base: {proyecto.ObtenerDescripcion()} = {proyecto.ObtenerCalificacion()}"); // 80.0

// 2. Decorar con un Bono
ICalificacion proyectoConBono = new DecoradorBonoImpacto(proyecto);
Console.WriteLine($"Bono: {proyectoConBono.ObtenerDescripcion()} = {proyectoConBono.ObtenerCalificacion()}"); // 85.0

// 3. Decorar con Bono Y Descuento (Envolver el objeto ya decorado)
ICalificacion proyectoCompuesto = new DecoradorDescuentoRetraso(proyectoConBono);
Console.WriteLine($"Compuesto: {proyectoCompuesto.ObtenerDescripcion()} = {proyectoCompuesto.ObtenerCalificacion()}"); // 75.0
*/
