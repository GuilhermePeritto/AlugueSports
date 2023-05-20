package Repository;

import Model.Reserva;

import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {
    static List<Reserva> usuarioReserva = new ArrayList<>();
    public  static void salvar(Reserva reserva) {
        usuarioReserva.add(reserva);
    }
    public static List<Reserva> buscaTodasReserva(){
        return usuarioReserva;
    }

}
