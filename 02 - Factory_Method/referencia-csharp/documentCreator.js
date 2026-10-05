// La Interfaz/Clase base del "Producto"
class Documento {
    constructor(tipo) { this.tipo = tipo; }
    generar() { throw new Error('Debe ser implementado por la subclase'); }
}

class DocumentoPDF extends Documento {
    constructor() { super("PDF"); }
    generar() { return `✅ Documento PDF creado.`; }
}

class DocumentoHTML extends Documento {
    constructor() { super("HTML"); }
    generar() { return `🌐 Documento HTML generado.`; }
}

// La Interfaz/Clase base de la "Fábrica" (Creator)
class CreadorDocumentos {
    // El Factory Method (Método de Fábrica)
    crearDocumento(tipo) {
        if (tipo === 'pdf') {
            return new DocumentoPDF();
        } else if (tipo === 'html') {
            return new DocumentoHTML();
        }
        throw new Error('Tipo de documento no soportado.');
    }
}

// Uso:
const fabrica = new CreadorDocumentos();
const docPDF = fabrica.crearDocumento('pdf');
const docHTML = fabrica.crearDocumento('html');

// console.log(docPDF.generar()); // Output: ✅ Documento PDF creado.
// console.log(docHTML.generar()); // Output: 🌐 Documento HTML generado.
