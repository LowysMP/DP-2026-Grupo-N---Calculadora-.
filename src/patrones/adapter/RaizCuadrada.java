package patrones.adapter;

/**
PATRON ADAPTER - Rol: ConcreteAdaptee
 */
public class RaizCuadrada implements OperacionUnNumero {
    @Override
    public double calcular(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("No existe raiz real de un numero negativo.");
        }
        return Math.sqrt(a);
    }

    @Override
    public String getNombre() {
        return "Raiz Cuadrada";
    }
}
