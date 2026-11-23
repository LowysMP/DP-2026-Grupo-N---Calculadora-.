package patrones.factory;

/**
PATRON FACTORY METHOD - Rol: ConcreteProduct
 */
public class Suma implements Operacion {
    @Override
    public double calcular(double a, double b) {
        return a + b;
    }

    @Override
    public String getNombre() {
        return "Suma";
    }

    @Override
    public int getCantidadOperandos() {
        return 2;
    }
}
