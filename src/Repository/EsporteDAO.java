package Repository;

import Model.Esporte;
import java.util.ArrayList;
import java.util.List;

public class EsporteDAO {
    static List<Esporte> esportes= new ArrayList<>();
    public static void salvar(Esporte esporte) {
        esportes.add(esporte);
    }
    public static List<Esporte> buscaTodos() {
        return esportes;
    }

    public static List<Esporte> buscarPorNome(String nome) {
        List<Esporte> esportesFiltrados = new ArrayList<>();
        for (Esporte esporte : esportes) {
            if (esporte.getNomeEsporte().contains(nome)) {
                esportesFiltrados.add(esporte);
            }
        }
        return esportesFiltrados;
    }

    public static Object[] findEsportesInArray() {
        List<Esporte> produtos = buscaTodos();
        List<String> clienteNomes = new ArrayList<>();

        for (Esporte esporte : produtos) {
            clienteNomes.add(esporte.getNomeEsporte());
        }

        return clienteNomes.toArray();
    }

    public static Integer canculaCodigo(){
        return esportes.size() + 1;
    }
}
