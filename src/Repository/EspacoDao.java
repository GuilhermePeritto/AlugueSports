package Repository;

import Model.Espaco;
import Model.Reserva;

import java.util.ArrayList;
import  java.util.List;
public class EspacoDao {

    static List<Espaco> reservasEspaço = new ArrayList<>();

    public static void salvar(Espaco espaco){
        reservasEspaço.add(espaco);
    }

    public static List<Espaco> buscarTodos(){
        return reservasEspaço;
    }


}
