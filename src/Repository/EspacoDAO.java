package Repository;

import Model.Espaco;
import Model.Esporte;

import java.util.ArrayList;
import java.util.List;

public class EspacoDAO {
    static List<Espaco> espacos = new ArrayList<>();
    public static void salvar (Espaco espaco){
        espacos.add(espaco);
    }
    public static List<Espaco> buscaEspacos(){
        return espacos;
    }

    public static List<Espaco> buscarPorNome(String nome) {
        List<Espaco> espacosFiltrados = new ArrayList<>();
        for (Espaco espaco : espacos) {
            if (espaco.getNomeEspaco().contains(nome)) {
                espacosFiltrados.add(espaco);
            }
        }
        return espacosFiltrados;
    }

    public static Object[] findEsportesInArray() {
        List<Espaco> espacos = buscaEspacos();
        List<String> espacoNomes = new ArrayList<>();

        for (Espaco espaco : espacos) {
            espacoNomes.add(espaco.getNomeEspaco());
        }

        return espacoNomes.toArray();
    }
}
