# Patrones de Diseño

Material del curso de Diseño de Software (UAA). Cada carpeta explica un
patrón y reúne los archivos de su práctica. La idea de fondo es aprender a
reconocer un patrón y a evaluar cuándo conviene usarlo, no solamente copiar código.

## Cómo está planteado

Cada práctica compara código sin el patrón y con el patrón, en Java.
Cuando aplica, una caja del README señala
dónde ya apareció la idea en el [Taller de Arquitecturas de Software](https://github.com/carevalomx69/Taller-de-Arquitecturas-de-Software).
El entregable es una reflexión corta sobre cuándo conviene usar el patrón
y cuándo no.

## Patrones

| # | Patrón | Estado | Carpeta |
|---|---|---|---|
| 1 | Singleton | Práctica en Java y pistas del Taller | [01 - Singleton](01%20-%20Singleton/) |
| 2 | Factory Method | Explicación y ejemplos en C#. Práctica por rediseñar | [02 - Factory_Method](02%20-%20Factory_Method/) |
| 3 | Builder | Explicación y ejemplos en C#. Práctica por rediseñar | [03 - Builder](03%20-%20Builder/) |
| 4 | Adapter | Explicación y ejemplos en C#. Práctica por rediseñar | [04 - Adapter](04%20-%20Adapter/) |
| 5 | Decorator | Explicación y ejemplos en C#. Práctica por rediseñar | [05 - Decorator](05%20-%20Decorator/) |
| 6 | Strategy | Explicación y ejemplos en C#. Práctica por rediseñar | [06 - Strategy](06%20-%20Strategy/) |
| 7 | Observer | Explicación y ejemplos en C#. Práctica por rediseñar | [07 - Observer](07%20-%20Observer/) |

## Estructura de cada carpeta

```
NN - Patron/
├── README.md              explicación del patrón, diagramas y práctica
└── referencia-csharp/     ejemplos originales en C#, con y sin el patrón,
                           y sus diagramas en PlantUML
```

La carpeta de Singleton, que ya tiene práctica rediseñada, agrega `java/`.

## Diagramas

Los diagramas de los README están en Mermaid, que GitHub muestra
directamente. Los archivos `.puml` de `referencia-csharp/` son los
originales, solo de consulta.

## Referencias

Gamma, E., Helm, R., Johnson, R. y Vlissides, J. (1994). *Design Patterns:
Elements of Reusable Object-Oriented Software*. Addison-Wesley.

## Autor

Carlos Arévalo
