// En JavaScript, el patrón se logra a menudo usando un módulo con una instancia exportada, o una clase con un mecanismo de closure.
// ConfiguracionManager.js
class ConfiguracionManager {
    constructor() {
        if (ConfiguracionManager.instancia) {
            return ConfiguracionManager.instancia;
        }
        // Propiedad de configuración de ejemplo
        this.tema = "Claro";
        ConfiguracionManager.instancia = this;
    }

    getTema() {
        return this.tema;
    }
}

// Exportar la instancia única
export const configuracionManager = new ConfiguracionManager();
// Uso en otro archivo (ej. main.js)
// import { configuracionManager } from './ConfiguracionManager.js';
// const c1 = configuracionManager;
// console.log(c1.getTema()); // Salida: Claro
// const c2 = new ConfiguracionManager(); // Si se usa el new, retorna la instancia existente
// console.log(c1 === c2); // Salida: true
