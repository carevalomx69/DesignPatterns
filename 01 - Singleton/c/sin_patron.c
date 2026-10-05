#include <stdio.h>

/* Sin patron. Cada parte del programa declara su propio Logger. */

typedef struct {
    int log_count;
} Logger;

void logger_log(Logger *l, const char *mensaje) {
    l->log_count++;
    printf("[%d] LOG: %s\n", l->log_count, mensaje);
}

int main(void) {
    Logger logger1 = { 0 };
    Logger logger2 = { 0 };

    printf("--- Iniciando aplicacion ---\n");

    logger_log(&logger1, "Primer evento registrado.");
    logger_log(&logger2, "Segundo evento registrado desde otra parte del codigo.");

    if (&logger1 == &logger2) {
        printf("\nCOMPROBACION: logger1 y logger2 son la MISMA instancia.\n");
    } else {
        printf("\nCOMPROBACION: logger1 y logger2 son instancias DISTINTAS.\n");
    }

    printf("--- Finalizando aplicacion ---\n");
    return 0;
}
