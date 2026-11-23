package patrones.factory;

import patrones.adapter.AdaptadorOperacionUnaria;
import patrones.adapter.RaizCuadrada;

/**
PATRON FACTORY METHOD - Rol: Creator
Centraliza la creacion de operaciones evitando que Main instancie
clases concretas con 'new' dentro del menu.
 */
public class OperacionFactory {
    public static final int OP_SUMA = 1;
    public static final int OP_RESTA = 2;
    public static final int OP_MULTIPLICACION = 3;
    public static final int OP_DIVISION = 4;
    public static final int OP_RAIZ = 5;

    public static Operacion crearOperacion(int opcion) {
        switch (opcion) {
            case OP_SUMA:
                return new Suma();
            case OP_RESTA:
                return new Resta();
            case OP_MULTIPLICACION:
                return new Multiplicacion();
            case OP_DIVISION:
                return new Division();
            case OP_RAIZ:
                return new AdaptadorOperacionUnaria(new RaizCuadrada());
            default:
                throw new IllegalArgumentException("Operacion no valida.");
        }
    }
}
