#include <stdio.h>
#include "logger.h"

int main(void) {
    Logger *logger1;
    Logger *logger2;

    printf("--- Iniciando aplicacion ---\n");

    logger1 = logger_instancia();
    logger_log(logger1, "Primer evento registrado.");

    logger2 = logger_instancia();
    logger_log(logger2, "Segundo evento registrado desde otra parte del codigo.");

    if (logger1 == logger2) {
        printf("\nCOMPROBACION: logger1 y logger2 son la MISMA instancia (cuenta = %d).\n",
               logger_cuenta(logger1));
    } else {
        printf("\nERROR: se crearon multiples instancias.\n");
    }

    printf("--- Finalizando aplicacion ---\n");
    return 0;
}
