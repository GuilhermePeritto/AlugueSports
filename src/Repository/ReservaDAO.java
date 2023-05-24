package Repository;

import Model.*;

import javax.swing.*;
import java.time.LocalDate;
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

    public static boolean reservarMaterial(Material material, LocalDate dataInicio, LocalDate dataFim) {
        // Verifica se o material está disponível
        if (material.getEnumStatusMaterial() != EnumStatusMaterial.DISPONIVEL) {
            JOptionPane.showMessageDialog(null, "Material não disponível para reserva.");
            return false;
        }

        // Verifica se o material já está reservado para algum dia dentro do período
        for (Reserva reserva : usuarioReserva) {
            if (reserva.getMaterial() == material &&
                    (dataInicio.isBefore(reserva.getDataAlocacaoFim()) || dataInicio.isEqual(reserva.getDataAlocacaoFim())) &&
                    (dataFim.isAfter(reserva.getDataAlocacaoInicio()) || dataFim.isEqual(reserva.getDataAlocacaoInicio()))) {
                JOptionPane.showMessageDialog(null, "Material já reservado para algum dia dentro desse período.");
                return false;
            }
        }
        JOptionPane.showMessageDialog(null, "Reserva realizada com sucesso.");
        return true;
    }

    public static boolean verificarDisponibilidade(Material material, LocalDate datainicio, LocalDate datafim) {
        // Verifica se o material está disponível para o dia especificado
        for (Reserva reserva : usuarioReserva) {
            if (reserva.getMaterial() == material &&
                    (datainicio.isEqual(reserva.getDataAlocacaoInicio()) ||
                            (datainicio.isAfter(reserva.getDataAlocacaoInicio()) && datainicio.isBefore(reserva.getDataAlocacaoFim())) ||
                            datainicio.isEqual(reserva.getDataAlocacaoFim()))) {
                JOptionPane.showMessageDialog(null, "Material não disponível nessa data.");
                return false;
            }
        }
        for (Reserva reserva : usuarioReserva) {
            if (reserva.getMaterial() == material &&
                    (datafim.isEqual(reserva.getDataAlocacaoInicio()) ||
                            (datafim.isAfter(reserva.getDataAlocacaoInicio()) && datafim.isBefore(reserva.getDataAlocacaoFim())) ||
                            datafim.isEqual(reserva.getDataAlocacaoFim()))) {
                JOptionPane.showMessageDialog(null, "Material não disponível nessa data.");
                return false;
            }
        }
        JOptionPane.showMessageDialog(null, "Material disponível para o dia especificado.");
        return true;
    }

}
