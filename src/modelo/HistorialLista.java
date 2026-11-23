package modelo;

import java.util.ArrayList;
import java.util.List;

/*Implementacion concreta en memoria del historial (Principio S - SRP).*/
public class HistorialLista implements Historial {
    private ArrayList<String> lista = new ArrayList<>();

    @Override
    public void guardar(String texto) {
        lista.add(texto);
    }

    @Override
    public List<String> obtenerLista() {
        return new ArrayList<>(lista);
    }
}
