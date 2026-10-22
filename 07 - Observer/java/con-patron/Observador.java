// La INTERFAZ del observador. Es lo unico que el sujeto conoce de quienes se
// interesan en sus cambios: que tienen un metodo actualizar().
public interface Observador {
    void actualizar(String alumno);
}
