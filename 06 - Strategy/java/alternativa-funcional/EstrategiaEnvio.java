// La misma interfaz de la version con patron. Tiene UN solo metodo abstracto,
// y por eso Java la considera una "interfaz funcional": se puede crear un
// objeto de este tipo escribiendo solo una funcion (una expresion lambda),
// sin escribir una clase.
@FunctionalInterface
public interface EstrategiaEnvio {
    int calcular(int pesoKg);
}
