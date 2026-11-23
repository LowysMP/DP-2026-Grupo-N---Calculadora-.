package patrones.factory;

/**
PATRON FACTORY METHOD - Rol: Product (Interfaz)
PATRON ADAPTER - Rol: Target (Interfaz objetivo esperada por Calculadora)
 */
public interface Operacion {
    double calcular(double a, double b);
    String getNombre();
    int getCantidadOperandos();
}
