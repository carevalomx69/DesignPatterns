#ifndef LOGGER_H
#define LOGGER_H

/* Tipo opaco. Aqui solo se anuncia que Logger existe, no se dice de que esta
   hecho. Quien incluya este archivo puede tener un puntero a Logger, pero no
   puede crear uno propio ni copiar el existente. */
typedef struct Logger Logger;

Logger *logger_instancia(void);
void logger_log(Logger *l, const char *mensaje);
int logger_cuenta(const Logger *l);

#endif
