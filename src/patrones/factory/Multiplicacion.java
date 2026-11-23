package patrones.factory;

/**
PATRON FACTORY METHOD - Rol: ConcreteProduct
 */
public class Multiplicacion implements Operacion {
    @Override
    public double calcular(double a, double b) {
        return a * b;
    }

    @Override
    public String getNombre() {
        return "Multiplicacion";
    }

    @Override
    public int getCantidadOperandos() {
        return 2;
    }
}
