// 1. Sujeto (Publisher)
class EventoRegistro {
    constructor() {
        this.observadores = [];
        this.estado = "Inicial"; // Estado (ej: Nombre del alumno inscrito)
    }

    suscribir(observador) {
        this.observadores.push(observador);
    }

    desuscribir(observador) {
        this.observadores = this.observadores.filter(obs => obs !== observador);
    }

    notificar() {
        for (const observador of this.observadores) {
            observador.actualizar(this);
        }
    }

    // Método que provoca el cambio de estado (el evento)
    registrarAsistencia(nombreAlumno) {
        this.estado = `Asistencia de ${nombreAlumno} registrada.`;
        console.log(`\nSUJETO: Se ha registrado una nueva asistencia: ${nombreAlumno}`);
        this.notificar();
    }
}

// 2. Concrete Observer A: Generador Constancias
class GeneradorConstancias {
    actualizar(sujeto) {
        if (sujeto instanceof EventoRegistro) {
            console.log(`GeneradorConstancias: Procesando... ${sujeto.estado}`);
        }
    }
}

// 3. Concrete Observer B: Notificador Email
class NotificadorEmail {
    actualizar(sujeto) {
        if (sujeto instanceof EventoRegistro) {
            console.log(`NotificadorEmail: Enviando correo... ${sujeto.estado}`);
        }
    }
}

// Uso:
/*
const registro = new EventoRegistro();
const constancias = new GeneradorConstancias();
const email = new NotificadorEmail();

registro.suscribir(constancias);
registro.suscribir(email);

registro.registrarAsistencia("Juan Pérez");

registro.desuscribir(email);

registro.registrarAsistencia("María López");
*/
