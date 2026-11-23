package patrones.factory;

/**
PATRON FACTORY METHOD - Rol: ConcreteProduct
 */
public class Division implements Operacion {
    @Override
    public double calcular(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir entre cero.");
        }
        return a / b;
    }

    @Override
    public String getNombre() {
        return "Division";
    }

    @Override
    public int getCantidadOperandos() {
        return 2;
    }
}
