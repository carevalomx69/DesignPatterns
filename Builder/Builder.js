// 1. Producto
class Reporte {
    constructor() {
        this.partes = [];
    }
    agregar(parte) {
        this.partes.push(parte);
    }
    mostrar() {
        console.log(`Reporte construido con partes: ${this.partes.join(', ')}`);
    }
}

// 2. Builder
class ReporteFinancieroBuilder {
    constructor() {
        this.reset();
    }
    reset() {
        this.reporte = new Reporte();
    }
    buildEncabezado() {
        this.reporte.agregar("Encabezado (Fecha, Título)");
    }
    buildMetricasClave() {
        this.reporte.agregar("Métricas de Viabilidad (VPN, TIR)");
    }
    buildFlujoCaja() {
        this.reporte.agregar("Flujo de Caja Proyectado");
    }
    getResultado() {
        const resultado = this.reporte;
        this.reset();
        return resultado;
    }
}

// 3. Director
class Director {
    constructor(builder) {
        this.builder = builder;
    }

    setBuilder(builder) {
        this.builder = builder;
    }

    // Construye un reporte básico
    construirReporteBasico() {
        this.builder.buildEncabezado();
        this.builder.buildMetricasClave();
    }

    // Construye un reporte completo
    construirReporteCompleto() {
        this.builder.buildEncabezado();
        this.builder.buildMetricasClave();
        this.builder.buildFlujoCaja();
    }
}

// Uso:
/*
const builder = new ReporteFinancieroBuilder();
const director = new Director(builder);

console.log("Reporte Básico:");
director.construirReporteBasico();
builder.getResultado().mostrar();

console.log("\nReporte Completo:");
director.construirReporteCompleto();
builder.getResultado().mostrar();
*/
