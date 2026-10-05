# Patrones de Diseño

Material del curso de Diseño de Software (UAA). Cada carpeta explica un
patrón y reúne los archivos de su práctica. La idea de fondo es aprender a
reconocer un patrón y a evaluar cuándo conviene, no a copiar código.

## Cómo está planteado

Cada práctica sigue la misma necesidad a través de tres escalas.

| Escala | Qué se observa |
|---|---|
| C | El patrón como idioma de un lenguaje procedural |
| Java | El patrón como clases y objetos |
| Arquitectura | Dónde aparece, o se diluye, en el [Taller de Arquitecturas de Software](https://github.com/carevalomx69/Taller-de-Arquitecturas-de-Software) |

Un patrón se diluye cuando el lenguaje o la arquitectura ya resuelve por sí
solo lo que el patrón resolvía. Cada práctica tiene una tabla donde el
equipo compara casos y justifica su juicio con evidencia.

## Patrones

| # | Patrón | Estado | Carpeta |
|---|---|---|---|
| 1 | Singleton | Práctica completa (C, Java y arquitectura) | [01 - Singleton](01%20-%20Singleton/) |
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

La carpeta de Singleton agrega `c/`, `java/`, `experimentos/` y
`diagramas/`, que son parte de la práctica rediseñada.

## Diagramas

Los diagramas de los README están en Mermaid, que GitHub muestra
directamente. Los archivos `.puml` se generan con PlantUML. En
`01 - Singleton/diagramas/` hay las mismas figuras en ambos formatos, con
su exportación a SVG, para comparar.

## Referencias

Gamma, E., Helm, R., Johnson, R. y Vlissides, J. (1994). *Design Patterns:
Elements of Reusable Object-Oriented Software*. Addison-Wesley.

## Autor

Carlos Arévalo
