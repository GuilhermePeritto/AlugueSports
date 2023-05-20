package Repository;

import Model.Estado;

import java.util.ArrayList;
import java.util.List;

public class EstadoDAO {
    static List<Estado> estados = new ArrayList<>();
    public static void salvar(Estado estado) {
        estados.add(estado);
    }
    public static List<Estado> buscaTodos() {
        return estados;
    }
}
