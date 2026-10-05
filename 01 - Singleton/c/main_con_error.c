#include <stdio.h>
#include "logger.h"

/* Este archivo intenta romper el patron. Compilalo junto con logger.c y lee
   con calma los mensajes del compilador. */

int main(void) {
    Logger *logger1 = logger_instancia();

    Logger logger3;          /* intento 1: crear una instancia propia */
    Logger copia = *logger1; /* intento 2: copiar la instancia existente */

    printf("%p %p\n", (void *)&logger3, (void *)&copia);
    return 0;
}
