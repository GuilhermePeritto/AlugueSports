package Repository;

import Model.Espaco;

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
}
