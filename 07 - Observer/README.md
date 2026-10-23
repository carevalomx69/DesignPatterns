# Patrón 7. Observer

## Objetivo

Reconocer el patrón Observer, ver qué problema resuelve cuando varias partes
del sistema deben reaccionar a un mismo cambio, y decidir cuándo conviene
usarlo.

El problema aparece cuando un objeto cambia de estado y otros objetos
necesitan enterarse. Si el objeto que cambia llama directamente a cada
interesado, queda acoplado a todos ellos, y agregar o quitar uno obliga a
modificarlo. Observer invierte la relación. Los interesados se suscriben, y el
objeto que cambia solo conoce una interfaz común y avisa a todos los
suscritos.

## Conocimientos de POO necesarios para la implementación del patrón

Observer se apoya en varias ideas de programación orientada a objetos. Si
alguna no está clara, conviene repasarla antes de seguir, porque los
diagramas y el código que siguen las dan por sabidas. La columna "Dónde se ve
en los diagramas de clases" remite a la sección Diagramas de clases, más
abajo.

| Concepto | Dónde se ve en los diagramas de clases | En una frase |
|---|---|---|
| Interfaz | `Observador` | Es un contrato. Dice que cualquier observador tiene un método `actualizar`, sin escribir qué hace. Es lo único que el sujeto sabe de sus interesados |
| Implementación | Flechas punteadas de `GeneradorConstancias`, `EnvioCorreo` y `Auditoria` hacia `Observador` (`implements`) | Cada clase se compromete a cumplir el contrato y decide qué hace al recibir el aviso. Si le falta el método, no compila |
| Colección de objetos | `List<Observador>` dentro de `Inscripciones` | Una lista que crece según se agregan elementos. El `<Observador>` indica que solo guarda objetos que cumplen esa interfaz. Se recorre con un `for` mejorado, que se explica en la sección Dónde ocurre el aviso |
| Composición y agregación | Rombo relleno en la versión sin patrón y rombo hueco en la versión con patrón | En los dos casos un objeto guarda a otros, pero cambia quién los crea. Se explica debajo de la tabla |
| Delegación | `observador.actualizar(alumno)` dentro de `notificar()` | `Inscripciones` no hace el trabajo de reaccionar. Avisa y cada observador hace lo suyo |
| Polimorfismo | No se dibuja | `notificar()` llama a `actualizar()` sobre cada elemento de la lista. Al ejecutarse, Java usa el objeto real de cada uno, que son clases distintas, aunque todos estén declarados con el tipo de la interfaz |

Sobre los rombos. En este README "composición" se usa en el sentido general de
la programación orientada a objetos, que es guardar una referencia a otro
objeto en un atributo (Gamma et al., 1994). UML distingue dos casos según
quién crea y es dueño de la parte. En la composición, que lleva rombo relleno,
el todo es dueño de la parte, y si el todo se elimina sus partes también (UML
Diagrams, s. f.-a). En la agregación, que lleva rombo hueco, la parte llega de
afuera y puede existir sin el todo (UML Diagrams, s. f.-b). Este patrón sirve
bien para ver la diferencia. En la versión sin patrón, `Inscripciones` crea con
`new` a los dos interesados y los guarda en atributos, así que es su dueña y
se dibuja composición. En la versión con patrón, los observadores se crean en
`Principal` y llegan por `suscribir()`, así que `Inscripciones` solo guarda
referencias y se dibuja agregación. El rombo va del lado del todo, que es
`Inscripciones` en los dos casos.

Si estos conceptos todavía te cuestan, es normal. Una buena forma de
revisarlos es leer `java/sin-patron`, donde `Inscripciones` crea y llama a
cada interesado, y compararlo con `java/con-patron`, donde aparecen la
interfaz, la lista y los observadores.

## Sin el patrón

Esta es la idea en su forma más simple. Cuando un alumno se inscribe a un
congreso, siempre que todavía haya lugar, hay que generar su constancia y
enviarle un correo de bienvenida. La clase `Inscripciones` revisa el cupo, y
si hay lugar, crea a esos dos interesados y los llama uno por uno, cada uno
con su propio nombre de método. Agregar o quitar una reacción obliga a abrir y
modificar `Inscripciones`.

![Sin el patrón, Inscripciones conoce y llama directamente a cada interesado](img/diagrama-sin-patron.svg)

## El patrón en breve

Observer define una dependencia de uno a muchos entre objetos, de modo que
cuando uno cambia de estado, todos sus dependientes son notificados
automáticamente (Gamma et al., 1994). También se le conoce como
publicación y suscripción (Gamma et al., 1994). Es como suscribirse a un canal
de noticias. El canal publica, no sabe quiénes lo siguen, y cada suscriptor
decide qué hacer con la noticia. Quien quiere dejar de recibirla se da de baja.

En el ejemplo de la práctica, las inscripciones a un congreso avisan a quien
le interese. Las piezas son tres.

- **Sujeto** (`Inscripciones`). El objeto que cambia. Revisa que haya lugar,
  guarda una lista de observadores y les avisa cuando ocurre una inscripción.
- **Interfaz del observador** (`Observador`). El contrato que cumplen todos
  los interesados, con el método `actualizar`.
- **Observadores concretos** (`GeneradorConstancias`, `EnvioCorreo` y
  `Auditoria`). Cada uno hace algo distinto al recibir el aviso.

Así se ve la idea. El sujeto ya no conoce a nadie por su nombre. Recorre su
lista y llama a `actualizar()` en cada elemento. Quien arma el programa, que
aquí es `Principal`, decide quién se suscribe y quién se da de baja.

![Con Observer, Inscripciones avisa a una lista de observadores a través de una interfaz](img/diagrama-con-patron.svg)

### Dónde ocurre el aviso

El corazón del patrón es un método pequeño. Está en
`java/con-patron/Inscripciones.java` y se llama `notificar()`. Es el único
lugar donde el sujeto recorre su lista de observadores.

```java
private void notificar(String alumno) {
    for (Observador observador : observadores) {
        observador.actualizar(alumno);
    }
}
```

El `for` se lee "para cada `observador` de la lista `observadores`, llama a
`actualizar(alumno)`". En cada vuelta, `observador` es el siguiente elemento de
la lista, en el orden en que se suscribieron. Esa notación se llama `for`
mejorado, o *for-each*, y no existe en C. La versión con índice, que es la
equivalente a un ciclo de C, es esta.

```java
for (int i = 0; i < observadores.size(); i++) {
    Observador observador = observadores.get(i);
    observador.actualizar(alumno);
}
```

Las dos hacen lo mismo y producen la misma salida. `size()` es el número de
elementos de la lista y `get(i)` devuelve el de la posición `i`, como
`arreglo[i]`. La versión mejorada solo se ahorra llevar la cuenta del índice.

La lista misma es un `ArrayList`, una clase de la biblioteca estándar de Java.
La documentación la describe como una implementación de la interfaz `List`
basada en un arreglo que cambia de tamaño y cuya capacidad crece
automáticamente al agregar elementos (Oracle, s. f.). En términos
estructurados, es un arreglo dinámico. `suscribir()` solo hace
`observadores.add(observador)`, que agrega al final, y `desuscribir()` hace
`observadores.remove(observador)`, que quita la primera coincidencia.

Hay algo más que notar en esta clase. `notificar()` no menciona a
`GeneradorConstancias`, ni a `EnvioCorreo`, ni a ningún otro observador
concreto. Solo conoce a `Observador`, y por eso agregar o quitar uno no cambia
este método.

### Por qué el control de cupo no es un observador

Es tentador poner el control de cupo como un observador más, porque parece una
reacción a la inscripción. Pero un observador reacciona a algo que ya ocurrió y
no decide si debe ocurrir. Por eso la regla del cupo vive en
`Inscripciones.inscribir()` y se revisa antes de aceptar al alumno. Solo si hay
lugar se llama a `notificar()`. Si ya no hay, el alumno se rechaza y ningún
observador se entera, porque no hubo inscripción. Es lo que ocurre con Diana en
los dos `Principal`.

Si el cupo fuera un observador, tendría dos problemas.

- **No podría impedir nada.** Cuando le avisan, la inscripción ya ocurrió, y los
  demás observadores reciben el mismo aviso. El alumno recibiría su constancia y
  su correo aunque el cupo ya estuviera lleno.
- **Dependería del orden.** Para que el cupo se revise antes que la constancia,
  tendría que suscribirse primero, y los observadores no deberían depender unos
  de otros ni del orden. Una consecuencia del patrón es que, como no se conocen
  entre sí, una acción puede desencadenar actualizaciones difíciles de predecir
  (Gamma et al., 1994).

El Taller de Arquitecturas hace lo mismo. En
`06-orientado-a-eventos/servicio-tareas/adapters/apiAdapter.js`, el dominio
guarda la tarea primero, y solo después se publica el evento. El comentario del
código lo resume como "La tarea YA se guardó en MySQL, esto es solo avisar".
Primero se decide y se ejecuta, y después se avisa.

## Diagramas de clases

Las imágenes anteriores muestran la idea. Aquí están los mismos dos
escenarios como diagramas de clases, con la notación UML que se usa en la
documentación de software.

### Versión sin patrón

En `java/sin-patron` no hay interfaz ni lista. `Inscripciones` tiene un
atributo por cada interesado, los crea con `new` y los llama por el nombre de
su método, además del número de lugares que le quedan.

```mermaid
classDiagram
    class Inscripciones {
        -GeneradorConstancias constancias
        -EnvioCorreo correo
        -int lugares
        +Inscripciones(int lugares)
        +inscribir(String alumno)
    }
    class GeneradorConstancias {
        +generar(String alumno)
    }
    class EnvioCorreo {
        +enviarBienvenida(String alumno)
    }
    Inscripciones *-- GeneradorConstancias : crea y guarda
    Inscripciones *-- EnvioCorreo : crea y guarda
```

Los rombos son rellenos porque `Inscripciones` crea a sus dos interesados y es
su dueña. Para agregar una bitácora hay que abrir la clase, agregar otro
atributo y otra llamada.

### Versión con patrón

Con Observer, `Inscripciones` ya no conoce a los interesados. Guarda una lista
de `Observador` y les avisa a todos con el mismo método. Cada interesado es una
clase que implementa la interfaz.

```mermaid
classDiagram
    class Observador {
        <<interface>>
        +actualizar(String alumno)
    }
    class Inscripciones {
        -List~Observador~ observadores
        -int lugares
        +Inscripciones(int lugares)
        +suscribir(Observador observador)
        +desuscribir(Observador observador)
        +inscribir(String alumno)
        -notificar(String alumno)
    }
    class GeneradorConstancias
    class EnvioCorreo
    class Auditoria
    Observador <|.. GeneradorConstancias
    Observador <|.. EnvioCorreo
    Observador <|.. Auditoria
    Inscripciones o-- Observador : avisa a
```

Compara con la versión sin patrón. `Inscripciones` no tiene ninguna flecha
hacia las tres clases de observadores, solo hacia la interfaz, y el rombo
pasó de relleno a hueco porque ya no las crea. El único lugar que las crea y
las suscribe es `Principal`, que no se dibuja para que el diagrama se lea.

## Cuándo sí y cuándo no

Si solo hay un interesado y no se espera que haya más, llamarlo directamente
es más simple. Un observador ahí es la sobreingeniería de la que habla el
README general. Observer empieza a valer la pena cuando se cumple alguna de
estas situaciones.

- Varias partes del sistema deben reaccionar al mismo cambio, y se espera que
  aparezcan más.
- Quién se entera cambia mientras el programa corre, porque algunos se
  suscriben y otros se dan de baja.
- El objeto que cambia no debería conocer, ni depender de, quienes reaccionan.

También tiene costos. Como el sujeto no conoce a sus observadores, estos no
se conocen entre sí, y una acción pequeña puede desencadenar actualizaciones
en cadena que son difíciles de predecir (Gamma et al., 1994). Al leer
`inscribir()` ya no se ve quién reacciona, hay que mirar quién se suscribió.
Además, un observador que se suscribe y nunca se da de baja sigue en la lista
y no se libera de la memoria, un descuido frecuente con este tipo de
suscripciones (Bloch, 2018). En el código de esta práctica, los observadores se
avisan en el orden en que se suscribieron, y si uno lanzara una excepción,
interrumpiría el aviso a los que siguen.

## Práctica en Java (20 min)

Antes de ejecutar cada programa, anota qué crees que va a imprimir.
Comparar tu predicción con el resultado es lo más valioso de la práctica.

1. **Sin patrón.** Lee `java/sin-patron/Inscripciones.java`. Fíjate cuántas
   clases crea con `new` y con qué nombre llama a cada una. Predice la salida,
   incluido lo que pasará con Diana, y ejecútalo.
2. **Con patrón.** Lee `java/con-patron/Observador.java`,
   `Inscripciones.java` (ubica el método `notificar()` y la revisión del
   cupo) y `Principal.java`. Predice qué líneas se imprimirán cuando se
   inscriba Beto, después de que el correo se dio de baja, cuando se inscriba
   Carla, después de suscribir a `Auditoria`, y cuando se intente inscribir a
   Diana. Ejecútalo.
3. **Comparar.** Si se quisiera agregar un aviso por mensaje de texto, ¿qué
   archivos habría que modificar o escribir en cada versión? Y si se quisiera
   dejar de enviar el correo de bienvenida, ¿qué habría que hacer en cada una?

### Cómo ejecutar

Desde la terminal, entra a la carpeta de cada versión y compila todo junto.

```
cd java/sin-patron
javac *.java
java Principal
```

Repite con `java/con-patron`. En VS Code, abre una versión a la vez (menú
*File > Open Folder*), porque las dos carpetas tienen clases con el mismo
nombre.

## Qué gana y qué cuesta usar Observer

| Aspecto | Sin patrón | Con patrón |
|---|---|---|
| Quién conoce a los interesados | `Inscripciones`, que crea las dos clases concretas | Solo `Principal`, al suscribirlos. `Inscripciones` conoce la interfaz |
| Cómo se les avisa | Cada uno por su nombre (`generar` y `enviarBienvenida`) | Todos con `actualizar()` |
| Agregar la bitácora | Abrir `Inscripciones`, agregar un atributo y otra llamada | Escribir `Auditoria` y suscribirla en `Principal` |
| Dejar de avisar a alguien | Editar `Inscripciones` | Llamar a `desuscribir()` |
| Relación en UML | Composición, rombo relleno | Agregación, rombo hueco |
| Clases con dos reacciones | 4 (`Inscripciones`, las dos reacciones y `Principal`) | 5 (las anteriores y la interfaz) |
| Clases con tres reacciones | 5, y `Inscripciones` crece | 6, y `Inscripciones` no cambia |
| Costo | El orden y las llamadas se ven en un solo lugar | Más piezas, y al leer `inscribir()` no se ve quién reacciona |

Con una o dos reacciones fijas, la versión sin patrón es más corta y más fácil
de seguir. El patrón gana cuando los interesados aumentan o cambian mientras
el programa corre.

## Árbol de archivos

```
07 - Observer/
├── README.md
├── img/                   diagramas de este README en formato SVG
├── java/
│   ├── sin-patron/        GeneradorConstancias.java, EnvioCorreo.java,
│   │                      Inscripciones.java y Principal.java
│   └── con-patron/        Observador.java, Inscripciones.java,
│                          GeneradorConstancias.java, EnvioCorreo.java,
│                          Auditoria.java y Principal.java
└── referencia-csharp/     versión original en C#, con cotizaciones de acciones,
                           solo de consulta
```

Los programas no llevan acentos a propósito, para evitar problemas de
codificación en la consola de Windows. La versión en C# de la carpeta
`referencia-csharp` usa otro ejemplo, el de una acción de bolsa que avisa a
clientes móviles y de escritorio, pero la estructura del patrón es la misma.

## Anexos

### Referencia a patrones arquitectónicos

Aquí el patrón sí aparece, en su versión con intermediario. En el
[Taller de Arquitecturas de Software](https://github.com/carevalomx69/Taller-de-Arquitecturas-de-Software),
el servicio de tareas publica un evento cada vez que se crea o se completa una
tarea, y otros servicios se suscriben para reaccionar.

| Práctica | Archivo | Qué hace |
|---|---|---|
| 6. Orientada a eventos | `06-orientado-a-eventos/servicio-tareas/adapters/eventPublisher.js` | Es el sujeto. `publish()` envía el evento a RabbitMQ, por ejemplo `tarea.creada` y `tarea.completada`, sin saber quién lo recibirá |
| 6. Orientada a eventos | `06-orientado-a-eventos/servicio-auditoria/index.js` | Es un observador. `bindQueue(QUEUE, EXCHANGE, 'tarea.*')` es la suscripción, y `consume()` recibe cada evento y lo anota en la bitácora |
| 7. CQRS | `07-cqrs/servicio-consultas/index.js` | Es un segundo observador, con su propia cola (`cola_consultas`) y la misma suscripción `tarea.*`, de modo que recibe los mismos eventos que la auditoría |

La correspondencia es directa. Publicar es notificar, suscribir es
`bindQueue`, y cada servicio es un observador. Hay una diferencia que conviene
notar. En el patrón clásico, el sujeto guarda la lista de observadores y los
llama en el mismo programa. Aquí, la lista la guarda RabbitMQ, el sujeto ni
siquiera sabe cuántos hay, y el aviso viaja por la red y espera en una cola
hasta que el observador lo recoge. Es la misma idea con un intermediario en
medio, que se conoce como publicación y suscripción. Ábrelos y compara dónde
quedó cada pieza del diagrama: el sujeto, la lista y los observadores.

### Errores comunes

| Problema | Causa probable | Solución |
|---|---|---|
| `cannot find symbol` al compilar | Se compiló solo un archivo y faltan los demás | Usa `javac *.java` dentro de la carpeta |
| `class X is public, should be declared in a file named X.java` | El nombre del archivo no coincide con el de la clase pública | Cada clase pública va en un archivo con su mismo nombre |
| `javac` no se reconoce como comando | El JDK no está instalado o no está en el PATH | Usa el IDE de tu curso de Java |
| Un observador no recibe avisos | Se creó pero nunca se llamó a `suscribir()` con él | Suscríbelo en `Principal` antes de la inscripción que quieres observar |

## Entregable

Evidencia de que ejecutaste las dos versiones, sin patrón y con patrón.
Puede ser una captura de la salida de cada una o el texto copiado de la
consola, y una línea que diga qué diferencia notaste entre ambas.

Tu predicción no tiene que acertar. Lo que se revisa es que lo ejecutaste y
que observaste la diferencia.

## Referencias

Bloch, J. (2018). *Effective Java* (3.ª ed.). Addison-Wesley.

Gamma, E., Helm, R., Johnson, R. y Vlissides, J. (1994). *Design Patterns:
Elements of Reusable Object-Oriented Software*. Addison-Wesley.

Oracle. (s. f.). *ArrayList* (Java SE 21 y JDK 21). Documentación de la API.
https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/ArrayList.html

UML Diagrams. (s. f.-a). *UML composition*.
https://www.uml-diagrams.org/composition.html

UML Diagrams. (s. f.-b). *UML aggregation*.
https://www.uml-diagrams.org/aggregation.html
