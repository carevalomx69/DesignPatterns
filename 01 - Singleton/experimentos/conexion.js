// ========== conexion.js ==========
// Imita lo que hace 03-capas-mvc/backend/db.js. La instancia se crea en el
// momento en que Node carga este archivo, y todos los demás archivos que
// lo importan con require() reciben esa misma instancia.
//
// Fíjate en lo que NO hay aquí: no hay constructor privado, no hay campo
// estático, no hay método getInstance(). Aun así, para quien lo usa, se
// comporta como un Singleton. Los experimentos 1 y 3 te ayudan a descubrir
// por qué.

const etiqueta = Math.random().toString(36).slice(2, 6);

class Conexion {
  constructor() {
    this.etiqueta = etiqueta;
    this.pid = process.pid;
    console.log(`  [conexion.js] se crea la conexión "${this.etiqueta}" en el proceso ${this.pid}`);
  }
}

module.exports = new Conexion();
