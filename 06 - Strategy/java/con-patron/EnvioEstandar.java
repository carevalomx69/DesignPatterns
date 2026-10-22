// ESTRATEGIA CONCRETA 1. Tarifa por kilo.
public class EnvioEstandar implements EstrategiaEnvio {
    @Override
    public int calcular(int pesoKg) {
        return pesoKg * 15;
    }
}
