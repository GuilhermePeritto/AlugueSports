package Repository;

import Model.*;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static Model.VerificaRegistroNullo.verificaRegistroNullo;

public class ReservaDAO {
    static List<Reserva> usuarioReserva = new ArrayList<>();

    public static void salvar(Reserva reserva) {
        usuarioReserva.add(reserva);
    }

    public static List<Reserva> buscaTodos() {
        return usuarioReserva;
    }

    public static void cancelar(Reserva reserva) {
        reserva.setEnumStatus(EnumStatusReserva.CANCELADO);
    }

    public static List<Reserva> buscarPorNome(String nome) {
        List<Reserva> reservasFiltrados = new ArrayList<>();
        for (Reserva reserva : usuarioReserva) {
            if (reserva.getTitulo().contains(nome)) {
                reservasFiltrados.add(reserva);
            }
        }
        return reservasFiltrados;
    }

    public static Object[] findReservaInArray() {
        List<Reserva> reservas = buscaTodos();
        List<String> reservaNomes = new ArrayList<>();

        for (Reserva reserva : reservas) {
            reservaNomes.add(reserva.getTitulo());
        }

        return reservaNomes.toArray();
    }

    public static boolean reservarMaterial(Material material, LocalDate dataInicio, LocalDate dataFim) {
        // Verifica se o material está disponível
        if (material.getEnumStatus() != EnumStatusMaterial.DISPONIVEL) {
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

    public static boolean verificarDisponibilidadeMaterial(Material material, LocalDate datainicio, LocalDate datafim) {
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

    public static boolean reservarEspaco(Espaco espaco, LocalDate dataInicio, LocalDate dataFim) {
        // Verifica se o material está disponível
        if (espaco.getEnumStatus() != EnumStatusEspaco.DISPONIVEL) {
            JOptionPane.showMessageDialog(null, "Espaco não disponível para reserva.");
            return false;
        }

        // Verifica se o material já está reservado para algum dia dentro do período
        for (Reserva reserva : usuarioReserva) {
            if (reserva.getEspaco() == espaco &&
                    (dataInicio.isBefore(reserva.getDataAlocacaoFim()) || dataInicio.isEqual(reserva.getDataAlocacaoFim())) &&
                    (dataFim.isAfter(reserva.getDataAlocacaoInicio()) || dataFim.isEqual(reserva.getDataAlocacaoInicio()))) {
                JOptionPane.showMessageDialog(null, "Espaco já reservado para algum dia dentro desse período.");
                return false;
            }
        }
        JOptionPane.showMessageDialog(null, "Reserva realizada com sucesso.");
        return true;
    }

    public static boolean verificarDisponibilidadeEspaco(Espaco espaco, LocalDate datainicio, LocalDate datafim) {
        // Verifica se o material está disponível para o dia especificado
        for (Reserva reserva : usuarioReserva) {
            if (reserva.getEspaco() == espaco &&
                    (datainicio.isEqual(reserva.getDataAlocacaoInicio()) ||
                            (datainicio.isAfter(reserva.getDataAlocacaoInicio()) && datainicio.isBefore(reserva.getDataAlocacaoFim())) ||
                            datainicio.isEqual(reserva.getDataAlocacaoFim()))) {
                JOptionPane.showMessageDialog(null, "Espaco não disponível nessa data.");
                return false;
            }
        }
        for (Reserva reserva : usuarioReserva) {
            if (reserva.getEspaco() == espaco &&
                    (datafim.isEqual(reserva.getDataAlocacaoInicio()) ||
                            (datafim.isAfter(reserva.getDataAlocacaoInicio()) && datafim.isBefore(reserva.getDataAlocacaoFim())) ||
                            datafim.isEqual(reserva.getDataAlocacaoFim()))) {
                JOptionPane.showMessageDialog(null, "Espaco não disponível nessa data.");
                return false;
            }
        }
        JOptionPane.showMessageDialog(null, "Espaco disponível para o dia especificado.");
        return true;
    }

    public static Integer calculaCodigo() {
        return usuarioReserva.size() + 1;
    }

    public static Double calcularDias(LocalDate dataInicio, LocalDate dataFim) {
        LocalDateTime dataInicialTempoZero = dataInicio.atStartOfDay();
        LocalDateTime dataFinalTempoZero = dataInicio.atStartOfDay();

        long diferencaEmSegundos = ChronoUnit.SECONDS.between(dataInicialTempoZero, dataFinalTempoZero);
        double diferencaEmDias = diferencaEmSegundos / (24.0 * 60 * 60);

        return diferencaEmDias;
    }

    public static Double calcularValor(Material material, Espaco espaco, Double diasReserva) {
        return Calcular.somar(Calcular.multiplicar(material.getValor(), diasReserva).doubleValue(), Calcular.multiplicar(espaco.getValor(), diasReserva).doubleValue()).doubleValue();
    }

    public static void verificarCliente(Cliente cliente) {
        if (usuarioReserva.get(cliente.getCodigo()).getDataAlocacaoFim().isBefore(LocalDate.now())) {
            JOptionPane.showMessageDialog(null, "Cliente Malandro!");
        }
        else if (usuarioReserva.get(cliente.getCodigo()).getDataAlocacaoFim().isAfter(LocalDate.now())) {
            JOptionPane.showMessageDialog(null, "Cliente ja tem reservas nos dias " + usuarioReserva.get(cliente.getCodigo()).getDataAlocacaoInicio() + " a " + usuarioReserva.get(cliente.getCodigo()).getDataAlocacaoFim());
        }
        else {
            JOptionPane.showMessageDialog(null, "Cliente nao tem reservas");
        }
    }
    public static void alterarDadosReserva(Reserva reserva) {
        //Altera titulo da reserva
        String tituloReserva = JOptionPane.showInputDialog(null, "Digite o titulo");
        verificaRegistroNullo(tituloReserva);
        reserva.setTitulo(tituloReserva);

        //Altera data inicio
        LocalDate dataAlocacaoInicio = LocalDate.now();
        String inputDataAlocacaoInicio = JOptionPane.showInputDialog(null, "Informe a data de início desejada");
        try {
            dataAlocacaoInicio = LocalDate.parse(inputDataAlocacaoInicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data invalida, tente no formato dd/MM/yyyy");
        }
        verificaRegistroNullo(dataAlocacaoInicio);

        //Altera data fim
        LocalDate dataAlocacaoFim = LocalDate.now();
        String inputDataAlocacaoFim = JOptionPane.showInputDialog(null, "Informe a data fim desejada");
        try {
            dataAlocacaoFim = LocalDate.parse(inputDataAlocacaoFim, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data invalida, tente no formato dd/MM/yyyy");
        }
        verificaRegistroNullo(dataAlocacaoFim);

        //altera status da reserva
        Object[] selectionStatusReserva = {"CANCELADO", "ABERTO"};
        String initialSelectionStatusReserva = (String) selectionStatusReserva[0];
        Object selectionStatus = JOptionPane.showInputDialog(null, "Selecione o status da reserva!",
                "Lista de Status", JOptionPane.QUESTION_MESSAGE, null, selectionStatusReserva, initialSelectionStatusReserva);
        EnumStatusReserva statusReserva = EnumStatusReserva.ABERTO;
        if (selectionStatus.equals("ABERTO")) {
            statusReserva = EnumStatusReserva.ABERTO;
        } else if (selectionStatus.equals("CANCELADO")) {
            statusReserva = EnumStatusReserva.CANCELADO;
        }
        verificaRegistroNullo(statusReserva);

        //altera material selecionado na reserva
        Object[] selectionValuesMaterial = MaterialDAO.findMaterialInArray();
        String initialSelectionMaterial = (String) selectionValuesMaterial[0];
        Object selectionMaterial = JOptionPane.showInputDialog(null, "Selecione o Material",
                "Alterar Material", JOptionPane.QUESTION_MESSAGE, null, selectionValuesMaterial, initialSelectionMaterial);
        List<Material> material = MaterialDAO.buscarPorNome((String) selectionMaterial);
        verificaRegistroNullo(selectionMaterial);
        verificarDisponibilidadeMaterial(material.get(0), dataAlocacaoInicio, dataAlocacaoFim);
        reservarMaterial(material.get(0), dataAlocacaoInicio, dataAlocacaoFim);
        verificaRegistroNullo(material);

        //altera espaco selecionado na reserva
        Object[] selectionValuesEspaco = EspacoDAO.findEspacoInArray();
        String initialSelectionEspaco = (String) selectionValuesEspaco[0];
        Object selectionEspaco = JOptionPane.showInputDialog(null, "Selecione o Espaco",
                "Alterar Espaço", JOptionPane.QUESTION_MESSAGE, null, selectionValuesEspaco, initialSelectionEspaco);
        List<Espaco> espaco = EspacoDAO.buscarPorNome((String) selectionEspaco);
        verificaRegistroNullo(selectionEspaco);
        verificarDisponibilidadeEspaco(espaco.get(0), dataAlocacaoInicio, dataAlocacaoFim);
        reservarEspaco(espaco.get(0), dataAlocacaoInicio, dataAlocacaoFim);
        verificaRegistroNullo(espaco);
    }

    public static void excluir(Reserva reserva) {
        usuarioReserva.remove(reserva);
        JOptionPane.showMessageDialog(null, "Reserva excluida com sucesso!");
    }
}
