#include <stdio.h>
#include "logger.h"

/* La definicion de la estructura solo existe en este archivo. */
struct Logger {
    int log_count;
};

static struct Logger instancia = { 0 };

Logger *logger_instancia(void) {
    return &instancia;
}

void logger_log(Logger *l, const char *mensaje) {
    l->log_count++;
    printf("[%d] LOG: %s\n", l->log_count, mensaje);
}

int logger_cuenta(const Logger *l) {
    return l->log_count;
}
