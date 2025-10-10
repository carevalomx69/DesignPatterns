//En JavaScript, el Factory Method se implementa típicamente con una función o clase que encapsula el switch/case de instanciación.
// 1. Producto (Clases concretas que comparten una funcionalidad)
class EstrategiaVPN {
    Calcular() {
        return "Cálculo de Viabilidad realizado usando VPN.";
    }
}

class EstrategiaTIR {
    Calcular() {
        return "Cálculo de Viabilidad realizado usando TIR.";
    }
}

// 2. La Función Factory (Método de Fábrica)
class FabricaEstrategias {
    static CrearEstrategia(tipo) {
        switch (tipo.toUpperCase()) {
            case "VPN":
                return new EstrategiaVPN();
            case "TIR":
                return new EstrategiaTIR();
            default:
                throw new Error(`Tipo de estrategia '${tipo}' no reconocido.`);
        }
    }
}

// 3. Uso (El cliente solo pide el objeto a la fábrica)
/*
try {
    // El cliente solo conoce la interfaz y el nombre de la estrategia.
    const estrategia1 = FabricaEstrategias.CrearEstrategia("VPN");
    console.log(estrategia1.Calcular());

    const estrategia2 = FabricaEstrategias.CrearEstrategia("TIR");
    console.log(estrategia2.Calcular());
} catch (e) {
    console.error(e.message);
}
*/
