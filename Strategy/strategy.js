// 1. Interfaz (Clase Base) Strategy
class IEstrategiaCalculoViabilidad {
    CalcularViabilidad(inversionInicial, flujoCajaPromedio) {
        throw new Error("El método 'CalcularViabilidad' debe ser implementado.");
    }
}

// 2. Concrete Strategy A: VPN
class EstrategiaVPN extends IEstrategiaCalculoViabilidad {
    CalcularViabilidad(inversionInicial, flujoCajaPromedio) {
        // Lógica simplificada de VPN para el ejemplo
        if (flujoCajaPromedio * 5 > inversionInicial) { 
            const vpn = flujoCajaPromedio * 5 - inversionInicial;
            return `VPN Positivo. Proyecto Viable. (Ficticio: ${vpn.toFixed(2)})`;
        }
        return "VPN Negativo. Proyecto NO Viable.";
    }
}

// 3. Concrete Strategy B: Periodo de Recuperación (PR)
class EstrategiaPR extends IEstrategiaCalculoViabilidad {
    CalcularViabilidad(inversionInicial, flujoCajaPromedio) {
        const periodoRecuperacion = inversionInicial / flujoCajaPromedio;
        return `Periodo de Recuperación: ${periodoRecuperacion.toFixed(2)} años.`;
    }
}

// 4. Contexto
class SimuladorFinanciero {
    constructor(estrategia) {
        this.estrategia = estrategia;
    }

    setEstrategia(estrategia) {
        this.estrategia = estrategia;
    }

    ejecutarCalculo(inversionInicial, flujoCajaPromedio) {
        const resultado = this.estrategia.CalcularViabilidad(inversionInicial, flujoCajaPromedio);
        console.log(`Resultado con ${this.estrategia.constructor.name}: ${resultado}`);
    }
}

// Uso:
/*
const inv = 10000;
const flujo = 3000;

// Usar la estrategia de VPN
const simulador = new SimuladorFinanciero(new EstrategiaVPN());
simulador.ejecutarCalculo(inv, flujo);

// Cambiar a la estrategia de Periodo de Recuperación en tiempo de ejecución
simulador.setEstrategia(new EstrategiaPR());
simulador.ejecutarCalculo(inv, flujo);
*/
