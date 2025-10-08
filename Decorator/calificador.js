// 1. Componente Concreto: La Clase Base
class CalificacionProyecto {
    constructor() {
        this.calificacionBase = 80.0;
    }

    obtenerCalificacion() {
        return this.calificacionBase;
    }

    obtenerDescripcion() {
        return `Calificación Base (${this.calificacionBase.toFixed(1)})`;
    }
}

// 2. Decorador Base (No es estrictamente necesario en JS, pero ayuda a la estructura)
// En JS, el decorador simplemente es una clase que envuelve el objeto base

// 3. Decorador Concreto A: Añadir Bono
class DecoradorBonoImpacto {
    constructor(calificacionBase) {
        this.calificacionBase = calificacionBase; // Almacena la referencia al objeto a decorar
    }

    obtenerCalificacion() {
        // Llama al método del objeto base y añade su propia lógica
        return this.calificacionBase.obtenerCalificacion() + 5.0;
    }

    obtenerDescripcion() {
        return `${this.calificacionBase.obtenerDescripcion()} + Bono por Impacto Social (+5)`;
    }
}

// 4. Decorador Concreto B: Añadir Descuento
class DecoradorDescuentoRetraso {
    constructor(calificacionBase) {
        this.calificacionBase = calificacionBase;
    }

    obtenerCalificacion() {
        // Llama al método del objeto base y resta su propia lógica
        return this.calificacionBase.obtenerCalificacion() - 10.0;
    }

    obtenerDescripcion() {
        return `${this.calificacionBase.obtenerDescripcion()} - Descuento por Entrega Tarde (-10)`;
    }
}

// Uso:
/*
// 1. Proyecto con Calificación Base
let proyecto = new CalificacionProyecto();
console.log(`Base: ${proyecto.obtenerDescripcion()} = ${proyecto.obtenerCalificacion()}`); // 80.0

// 2. Decorar con un Bono
let proyectoConBono = new DecoradorBonoImpacto(proyecto);
console.log(`Bono: ${proyectoConBono.obtenerDescripcion()} = ${proyectoConBono.obtenerCalificacion()}`); // 85.0

// 3. Decorar con Bono Y Descuento (Envolver el objeto ya decorado)
let proyectoCompuesto = new DecoradorDescuentoRetraso(proyectoConBono);
console.log(`Compuesto: ${proyectoCompuesto.obtenerDescripcion()} = ${proyectoCompuesto.obtenerCalificacion()}`); // 75.0
*/
