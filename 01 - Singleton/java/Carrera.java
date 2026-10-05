import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Dos Singleton casi iguales. Solo cambia una palabra en incrementar().
class ContadorInseguro {
    private static final ContadorInseguro INSTANCIA = new ContadorInseguro();
    private int cuenta = 0;
    private ContadorInseguro() { }
    static ContadorInseguro getInstancia() { return INSTANCIA; }
    void incrementar() { cuenta++; }
    int getCuenta() { return cuenta; }
}

class ContadorSeguro {
    private static final ContadorSeguro INSTANCIA = new ContadorSeguro();
    private int cuenta = 0;
    private ContadorSeguro() { }
    static ContadorSeguro getInstancia() { return INSTANCIA; }
    synchronized void incrementar() { cuenta++; }
    synchronized int getCuenta() { return cuenta; }
}

public class Carrera {
    static final int HILOS = 4;
    static final int LLAMADAS = 200000;

    // Lanza HILOS hilos que ejecutan la misma tarea y espera a que terminen.
    static void ejecutarEnHilos(Runnable tarea) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(HILOS);
        List<Future<?>> futuros = new ArrayList<Future<?>>();
        for (int h = 0; h < HILOS; h++) {
            futuros.add(pool.submit(tarea));
        }
        for (Future<?> f : futuros) {
            f.get();
        }
        pool.shutdown();
    }

    public static void main(String[] args) throws Exception {
        final Set<Integer> identidades = ConcurrentHashMap.newKeySet();

        // Fase 1. El Singleton sin proteccion.
        ejecutarEnHilos(new Runnable() {
            public void run() {
                ContadorInseguro c = ContadorInseguro.getInstancia();
                identidades.add(System.identityHashCode(c));
                for (int i = 0; i < LLAMADAS; i++) {
                    c.incrementar();
                }
            }
        });

        // Fase 2. El Singleton con synchronized.
        ejecutarEnHilos(new Runnable() {
            public void run() {
                ContadorSeguro c = ContadorSeguro.getInstancia();
                for (int i = 0; i < LLAMADAS; i++) {
                    c.incrementar();
                }
            }
        });

        System.out.println("instancias distintas vistas por los hilos: " + identidades.size());
        System.out.println("esperado                 : " + (HILOS * LLAMADAS));
        System.out.println("contador sin synchronized: " + ContadorInseguro.getInstancia().getCuenta());
        System.out.println("contador con synchronized: " + ContadorSeguro.getInstancia().getCuenta());
    }
}
