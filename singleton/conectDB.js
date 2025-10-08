// El Singleton (Implementación con Clase y Método Estático)
class GestorConexion {
    // 1. Almacén de la instancia
    static #instancia = null;

    // 2. Constructor privado (no se puede llamar directamente)
    constructor() {
        if (GestorConexion.#instancia) {
            // Lanza un error o retorna la instancia existente para forzar el Singleton
            throw new Error("Solo se puede crear una instancia de GestorConexion.");
        }
        this.estadoConexion = "Desconectado";
        console.log("Gestor de Conexión Creado (¡Solo una vez!)");
    }

    // 3. Método estático para obtener la instancia
    static getInstancia() {
        if (!GestorConexion.#instancia) {
            // Crea la instancia solo si no existe
            GestorConexion.#instancia = new GestorConexion();
        }
        return GestorConexion.#instancia;
    }

    conectar() {
        this.estadoConexion = "Conectado";
        console.log(`Conexión establecida. Estado: ${this.estadoConexion}`);
    }
}

// Uso:
/*
try {
    const c1 = GestorConexion.getInstancia();
    c1.conectar();

    const c2 = GestorConexion.getInstancia();
    console.log(`c1 es igual a c2: ${c1 === c2}`); // True
    c2.conectar(); 

    // Intentar crear directamente fallará (si se usa la validación en el constructor)
    // const c3 = new GestorConexion(); 
} catch (e) {
    console.error(e.message);
}
*/
