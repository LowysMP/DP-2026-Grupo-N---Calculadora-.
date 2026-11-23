package modelo;

import java.util.List;
import patrones.factory.Operacion;

/*Clase de dominio que coordina los calculos y el registro en historial. Cumple SRP, OCP y DIP 
(depende solo de interfaces).*/

public class Calculadora {
    private Historial historial;

    public Calculadora(Historial historial) {
        this.historial = historial;
    }

    public double calcular(Operacion op, double a, double b) {
        double resultado = op.calcular(a, b);
        if (op.getCantidadOperandos() == 1) {
            historial.guardar(op.getNombre() + " de " + a + " = " + resultado);
        } else {
            historial.guardar(op.getNombre() + ": " + a + " y " + b + " = " + resultado);
        }
        return resultado;
    }

    public List<String> getHistorial() {
        return historial.obtenerLista();
    }
}
