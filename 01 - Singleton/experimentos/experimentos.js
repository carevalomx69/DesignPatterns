// ========== experimentos.js ==========
// Tres experimentos cortos sobre qué significa "una sola instancia".
//
// Uso:
//   node experimentos.js 1     (experimento 1: el caché de módulos)
//   node experimentos.js 2     (experimento 2: dos llamadas al mismo tiempo)
//   node experimentos.js 3     (experimento 3: una por proceso)

const { fork } = require('child_process');

const esperar = (ms) => new Promise((resolve) => setTimeout(resolve, ms));

// ---------------------------------------------------------------------
// Experimento 1. ¿Quién garantiza la unicidad en Node.js?
// ---------------------------------------------------------------------
function experimento1() {
  console.log('Experimento 1: importar el mismo módulo dos veces\n');

  const a = require('./conexion');
  const b = require('./conexion');
  console.log(`  a === b  ->  ${a === b}`);

  console.log('\nAhora borramos la entrada de conexion.js del caché de Node y lo importamos otra vez.\n');
  delete require.cache[require.resolve('./conexion')];
  const c = require('./conexion');
  console.log(`  a === c  ->  ${a === c}`);
  console.log(`  etiquetas  a: ${a.etiqueta}   c: ${c.etiqueta}`);
}

// ---------------------------------------------------------------------
// Experimento 2. Inicialización perezosa con varias llamadas simultáneas.
// Abrir una conexión de red toma tiempo, así que lo simulamos con una
// espera de 50 ms. Diez partes del programa piden la conexión a la vez.
// ---------------------------------------------------------------------
let creadasIngenua = 0;
let conexionIngenua = null;

async function obtenerIngenua() {
  if (!conexionIngenua) {
    await esperar(50);
    creadasIngenua++;
    conexionIngenua = { id: creadasIngenua };
  }
  return conexionIngenua;
}

let creadasProtegida = 0;
let conexionProtegida = null;
let conectando = null;

async function obtenerProtegida() {
  if (conexionProtegida) return conexionProtegida;
  if (conectando) return conectando;
  conectando = (async () => {
    await esperar(50);
    creadasProtegida++;
    conexionProtegida = { id: creadasProtegida };
    return conexionProtegida;
  })();
  try {
    return await conectando;
  } finally {
    conectando = null;
  }
}

async function experimento2() {
  const LLAMADAS = 10;
  console.log(`Experimento 2: ${LLAMADAS} llamadas simultáneas a una inicialización perezosa\n`);

  await Promise.all(Array.from({ length: LLAMADAS }, obtenerIngenua));
  console.log(`  versión ingenua    ->  conexiones creadas: ${creadasIngenua}`);

  await Promise.all(Array.from({ length: LLAMADAS }, obtenerProtegida));
  console.log(`  versión protegida  ->  conexiones creadas: ${creadasProtegida}`);
}

// ---------------------------------------------------------------------
// Experimento 3. "Una sola" instancia, pero ¿una sola dónde?
// Lanzamos tres procesos de Node. Cada uno importa conexion.js.
// ---------------------------------------------------------------------
async function experimento3() {
  const PROCESOS = 3;
  console.log(`Experimento 3: ${PROCESOS} procesos, cada uno importa conexion.js\n`);

  const hijos = Array.from({ length: PROCESOS }, () =>
    new Promise((resolve) => {
      const hijo = fork(__filename, ['hijo']);
      hijo.on('exit', resolve);
    })
  );
  await Promise.all(hijos);
  console.log('\n  Cada proceso creó su propia conexión "única".');
}

// ---------------------------------------------------------------------
const opcion = process.argv[2];

if (opcion === 'hijo') {
  require('./conexion');
} else if (opcion === '1') {
  experimento1();
} else if (opcion === '2') {
  experimento2();
} else if (opcion === '3') {
  experimento3();
} else {
  console.log('Uso: node experimentos.js 1 | 2 | 3');
}
