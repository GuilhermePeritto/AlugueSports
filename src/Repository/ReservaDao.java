package Repository;

import Model.Reserva;

import java.util.ArrayList;
import java.util.List;

public class ReservaDao {
    static List<Reserva> usuarioReserva = new ArrayList<>();
    public  static void salvarReserva(Reserva reserva) {
        usuarioReserva.add(reserva);
    }
    public static List<Reserva> buscaTodasReserva(){
        return usuarioReserva;
    }

}
