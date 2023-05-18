package Repository;

import Model.Reserva;

import java.util.ArrayList;
import  java.util.List;
public class EspacoDao {

    static List<Reserva> reservasEspaço = new ArrayList<>();

    public static void salvar(Reserva reserva){
        reservasEspaço.add(reserva);
    }

    public static List<Reserva> buscarTodos(){
        return reservasEspaço;
    }


}
