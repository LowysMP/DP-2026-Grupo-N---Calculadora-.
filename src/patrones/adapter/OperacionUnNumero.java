package patrones.adapter;

/*
PATRON ADAPTER - Rol: Adaptee (Interfaz incompatible de 1 solo numero)
Cumple ISP (Segregacion de Interfaces) al separar operaciones unarias.
*/
public interface OperacionUnNumero {
    double calcular(double a);
    String getNombre();
}
