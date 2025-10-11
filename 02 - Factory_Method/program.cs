using System;

// 1. Interfaz de Producto (el objeto que se crea).
public interface IDocumento
{
    void Abrir();
    void Guardar();
}

// 2. Clases Concretas de Producto.
public class DocumentoPDF : IDocumento
{
    public void Abrir() => Console.WriteLine("DocumentoPDF: Abriendo archivo PDF.");
    public void Guardar() => Console.WriteLine("DocumentoPDF: Guardando datos en formato PDF.");
}

public class DocumentoWord : IDocumento
{
    public void Abrir() => Console.WriteLine("DocumentoWord: Abriendo archivo DOCX.");
    public void Guardar() => Console.WriteLine("DocumentoWord: Guardando datos en formato DOCX.");
}

// 3. Clase Base Creadora (Abstracta).
// Define el Factory Method, pero deja la implementación a las subclases.
public abstract class CreadorDocumento
{
    // El Factory Method. Retorna la interfaz de producto.
    // **NOTA**: Las subclases deben implementar este método para crear el producto concreto.
    public abstract IDocumento CrearDocumento();

    // Lógica principal: opera sobre el producto creado por el método de fábrica.
    public void ProcesarNuevoDocumento()
    {
        // 4. Llama al Factory Method. El cliente no sabe qué clase concreta recibirá.
        IDocumento documento = CrearDocumento(); 
        Console.WriteLine("\n--- Inicia procesamiento genérico ---");
        documento.Abrir();
        documento.Guardar();
        Console.WriteLine("--- Termina procesamiento genérico ---\n");
    }
}

// 5. Clases Concretas Creadoras (Fábricas).
// Cada una sobrescribe el Factory Method para instanciar un tipo de producto específico.
public class CreadorPDF : CreadorDocumento
{
    public override IDocumento CrearDocumento()
    {
        Console.WriteLine("CreadorPDF: Creando instancia de DocumentoPDF.");
        return new DocumentoPDF();
    }
}

public class CreadorWord : CreadorDocumento
{
    public override IDocumento CrearDocumento()
    {
        Console.WriteLine("CreadorWord: Creando instancia de DocumentoWord.");
        return new DocumentoWord();
    }
}

// Clase principal para la ejecución.
class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("--- Aplicación de Procesamiento de Documentos ---");

        // El cliente trabaja con la clase base CreadorDocumento.
        // El Factory Method decidirá qué objeto crear en base al objeto Creador.
        CreadorDocumento creador1 = new CreadorPDF();
        creador1.ProcesarNuevoDocumento();

        CreadorDocumento creador2 = new CreadorWord();
        creador2.ProcesarNuevoDocumento();

        // Si mañana agregamos un DocumentoExcel, solo necesitamos crear CreadorExcel
        // sin tocar esta lógica principal. ¡Esto es el Abierto/Cerrado!
        Console.WriteLine("--- Fin de la demostración ---");
    }
}
