package Repository;

import Model.EnumStatusReserva;
import Model.Pais;
import Model.Reserva;

import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {
    static List<Reserva> usuarioReserva = new ArrayList<>();
    public  static void salvar(Reserva reserva) {
        usuarioReserva.add(reserva);
    }
    public static List<Reserva> buscaTodos(){
        return usuarioReserva;
    }
    public static void cancelar(Reserva reserva) {
        reserva.setEnumStatusReserva(EnumStatusReserva.CANCELADO);
    }

    public static List<Reserva> buscarPorNome(String nome) {
        List<Reserva> reservasFiltrados = new ArrayList<>();
        for (Reserva reserva : usuarioReserva) {
            if (reserva.getTituloReserva().contains(nome)) {
                reservasFiltrados.add(reserva);
            }
        }
        return reservasFiltrados;
    }

    public static Object[] findReservaInArray() {
        List<Reserva> reservas = buscaTodos();
        List<String> reservaNomes = new ArrayList<>();

        for (Reserva reserva : reservas) {
            reservaNomes.add(reserva.getTituloReserva());
        }

        return reservaNomes.toArray();
    }

}
