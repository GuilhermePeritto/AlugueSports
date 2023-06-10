package Repository;

import Model.Cliente;
import Model.Estado;

import java.util.ArrayList;
import java.util.List;

public class EstadoDAO {
    public static List<Estado> buscaEstados;
    static List<Estado> estados = new ArrayList<>();
    public static void salvar (Estado estado){
        estados.add(estado);
    }
    public static List<Estado> buscaTodos(){
        return estados;
    }
    public static Integer canculaCodigo(){
        return estados.size() + 1;
    }

    public static Object[] findEstadoInArray() {
        List<Estado> estados = buscaTodos();
        List<String> estadoNomes = new ArrayList<>();

        for (Estado estado : estados) {
            estadoNomes.add(estado.getNomeEstado());
        }

        return estadoNomes.toArray();
    }


    public static List<Estado> buscarPorNome(String nome) {
        List<Estado> estadosFiltrados = new ArrayList<>();
        for (Estado estado : estados) {
            if (estado.getNomeEstado().contains(nome)) {
                estadosFiltrados.add(estado);
            }
        }
        return estadosFiltrados;
    }

}
