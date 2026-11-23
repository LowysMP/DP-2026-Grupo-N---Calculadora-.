package modelo;

import java.util.List;

/* Abstraccion del repositorio de historial (Principio D - DIP).*/
public interface Historial {
    void guardar(String texto);
    List<String> obtenerLista();
}
