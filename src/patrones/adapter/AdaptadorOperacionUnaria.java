package patrones.adapter;

import patrones.factory.Operacion;

/* 
PATRON ADAPTER - Rol: Adapter
Adapta una OperacionUnNumero (1 parametro) a la interfaz Operacion (2 parametros)
para que Calculadora pueda ejecutar ambas sin duplicar metodos.
 */
public class AdaptadorOperacionUnaria implements Operacion {
    private OperacionUnNumero operacionUnaria;

    public AdaptadorOperacionUnaria(OperacionUnNumero operacionUnaria) {
        this.operacionUnaria = operacionUnaria;
    }

    @Override
    public double calcular(double a, double b) {
        return operacionUnaria.calcular(a);
    }

    @Override
    public String getNombre() {
        return operacionUnaria.getNombre();
    }

    @Override
    public int getCantidadOperandos() {
        return 1;
    }
}
