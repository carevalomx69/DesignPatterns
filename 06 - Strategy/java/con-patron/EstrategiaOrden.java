// La INTERFAZ de la estrategia. Define la pregunta que el contexto necesita
// responder: "este producto, va antes que este otro?". Cada criterio de
// ordenamiento es una clase que responde esa pregunta a su manera.
public interface EstrategiaOrden {
    boolean vaAntes(Producto a, Producto b);
}
