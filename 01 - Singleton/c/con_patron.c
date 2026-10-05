#include <stdio.h>

/* El Singleton en C: una variable con alcance de archivo (static) y una
   funcion de acceso. Aqui no hay clases, ni constructor, ni "private". */

typedef struct {
    int log_count;
} Logger;

static Logger instancia = { 0 };

Logger *logger_instancia(void) {
    return &instancia;
}

void logger_log(Logger *l, const char *mensaje) {
    l->log_count++;
    printf("[%d] LOG: %s\n", l->log_count, mensaje);
}

int main(void) {
    Logger *logger1;
    Logger *logger2;

    printf("--- Iniciando aplicacion ---\n");

    logger1 = logger_instancia();
    logger_log(logger1, "Primer evento registrado.");

    logger2 = logger_instancia();
    logger_log(logger2, "Segundo evento registrado desde otra parte del codigo.");

    if (logger1 == logger2) {
        printf("\nCOMPROBACION: logger1 y logger2 son la MISMA instancia.\n");
    } else {
        printf("\nERROR: se crearon multiples instancias.\n");
    }

    printf("--- Finalizando aplicacion ---\n");
    return 0;
}
