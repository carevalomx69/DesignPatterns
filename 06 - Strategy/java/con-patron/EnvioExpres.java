// ESTRATEGIA CONCRETA 2. Tarifa por kilo mas un cargo fijo por prioridad.
public class EnvioExpres implements EstrategiaEnvio {
    @Override
    public int calcular(int pesoKg) {
        return pesoKg * 30 + 50;
    }
}
