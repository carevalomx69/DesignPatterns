// OBSERVADOR CONCRETO 2. Envia el correo de bienvenida.
public class EnvioCorreo implements Observador {
    @Override
    public void actualizar(String alumno) {
        System.out.println("  [Correo] Correo de bienvenida enviado a " + alumno);
    }
}
