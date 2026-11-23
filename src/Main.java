import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import modelo.Calculadora;
import modelo.Historial;
import modelo.HistorialLista;
import patrones.factory.Operacion;
import patrones.factory.OperacionFactory;

/**
Cliente principal de la Calculadora Modular con Patrones GoF y SOLID.
 */
public class Main {
    private static final int OP_HISTORIAL = 6;
    private static final int OP_SALIR = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Historial historial = new HistorialLista();
        Calculadora calc = new Calculadora(historial);
        int opcion;

        do {
            System.out.println("\n--- CALCULADORA CON PATRONES GoF Y SOLID ---");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Raiz Cuadrada");
            System.out.println("6. Ver Historial");
            System.out.println("0. Salir");
            opcion = leerEntero(sc, "Elija una opcion: ");

            try {
                if (opcion >= OperacionFactory.OP_SUMA && opcion <= OperacionFactory.OP_RAIZ) {
                    //FACTORY METHOD (y ADAPTER para Raiz Cuadrada)
                    Operacion op = OperacionFactory.crearOperacion(opcion);
                    ejecutarOperacion(sc, calc, op);
                } else if (opcion == OP_HISTORIAL) {
                    mostrarHistorial(calc.getHistorial());
                } else if (opcion == OP_SALIR) {
                    System.out.println("Saliendo...");
                } else {
                    System.out.println("Opcion no valida.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != OP_SALIR);

        sc.close();
    }

    private static void ejecutarOperacion(Scanner sc, Calculadora calc, Operacion op) {
        double a = leerDouble(sc, "Numero 1: ");
        double b = (op.getCantidadOperandos() == 2) ? leerDouble(sc, "Numero 2: ") : 0;
        double resultado = calc.calcular(op, a, b);
        System.out.println("Resultado: " + resultado);
    }

    private static void mostrarHistorial(List<String> lista) {
        if (lista.isEmpty()) {
            System.out.println("El historial esta vacio.");
            return;
        }
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ". " + lista.get(i));
        }
    }

    private static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: ingrese un numero entero.");
                sc.next();
            }
        }
    }

    private static double leerDouble(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Error: ingrese un numero valido.");
                sc.next();
            }
        }
    }
}
