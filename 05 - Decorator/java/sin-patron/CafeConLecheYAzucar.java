// Combinacion C: leche y azucar. Otra clase mas, y aqui esta el problema.
// Con 2 extras ya hacen falta 4 clases (contando el cafe solo).
// Con 3 extras harian falta 8, con 4 extras 16: el doble por cada extra.
public class CafeConLecheYAzucar extends Bebida {
    public CafeConLecheYAzucar() {
        descripcion = "Cafe negro, con leche, con azucar";
        costo = 30 + 8 + 2;   // los precios de cada extra se repiten otra vez
    }
}
