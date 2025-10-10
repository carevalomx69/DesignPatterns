// 1. Producto
public class Reporte
{
    private List<string> _partes = new List<string>();

    public void Agregar(string parte)
    {
        this._partes.Add(parte);
    }

    public void Mostrar()
    {
        Console.WriteLine($"Reporte construido con partes: {string.Join(", ", _partes)}");
    }
}

// 2. Interfaz Builder
public interface IReporteBuilder
{
    void Reset();
    void BuildEncabezado();
    void BuildMetricasClave();
    void BuildFlujoCaja();
    Reporte GetResultado();
}

// 3. Concrete Builder
public class ReporteFinancieroBuilder : IReporteBuilder
{
    private Reporte _reporte = new Reporte();

    public ReporteFinancieroBuilder() { this.Reset(); }

    public void Reset() { this._reporte = new Reporte(); }

    public void BuildEncabezado() { this._reporte.Agregar("Encabezado (Fecha, Título)"); }
    public void BuildMetricasClave() { this._reporte.Agregar("Métricas de Viabilidad (VPN, TIR)"); }
    public void BuildFlujoCaja() { this._reporte.Agregar("Flujo de Caja Proyectado"); }

    public Reporte GetResultado()
    {
        Reporte resultado = this._reporte;
        this.Reset();
        return resultado;
    }
}

// 4. Director
public class Director
{
    private IReporteBuilder _builder;

    public IReporteBuilder Builder
    {
        set { this._builder = value; }
    }

    // Construye un reporte básico
    public void ConstruirReporteBasico()
    {
        this._builder.BuildEncabezado();
        this._builder.BuildMetricasClave();
    }

    // Construye un reporte completo
    public void ConstruirReporteCompleto()
    {
        this._builder.BuildEncabezado();
        this._builder.BuildMetricasClave();
        this._builder.BuildFlujoCaja();
    }
}

// Uso:
/*
Director director = new Director();
ReporteFinancieroBuilder builder = new ReporteFinancieroBuilder();
director.Builder = builder;

Console.WriteLine("Reporte Básico:");
director.ConstruirReporteBasico();
builder.GetResultado().Mostrar();

Console.WriteLine("\nReporte Completo:");
director.ConstruirReporteCompleto();
builder.GetResultado().Mostrar();
*/
