package Repository;
import Model.*;
import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import static Model.DataFormatada.formatarData;
import static Model.VerificaRegistroNullo.verificaRegistroNullo;
import static Model.View.chamaMenuPrincipal;

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
        JOptionPane.showMessageDialog(null, "Material disponível nessa data.");
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
        JOptionPane.showMessageDialog(null, "Espaco disponível nessa data.");
        return true;
    }
    public static List<Reserva> getUsuarioReserva() {
        return usuarioReserva;
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
            JOptionPane.showMessageDialog(null, "Cliente Devedor!");
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
        String tituloReserva = JOptionPane.showInputDialog(null, "Digite o titulo", reserva.getTitulo());
        verificaRegistroNullo(tituloReserva);
        //Altera data inicio
        LocalDate dataAlocacaoInicio = LocalDate.now();
        String inputDataAlocacaoInicio = JOptionPane.showInputDialog(null, "Informe a data de início desejada", formatarData(reserva.getDataAlocacaoInicio()));
        try {
            dataAlocacaoInicio = LocalDate.parse(inputDataAlocacaoInicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data invalida, tente no formato dd/MM/yyyy");
        }
        verificaRegistroNullo(dataAlocacaoInicio);
        //Altera data fim
        LocalDate dataAlocacaoFim = LocalDate.now();
        String inputDataAlocacaoFim = JOptionPane.showInputDialog(null, "Informe a data fim desejada", formatarData(reserva.getDataAlocacaoFim()));
        try {
            dataAlocacaoFim = LocalDate.parse(inputDataAlocacaoFim, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data invalida, tente no formato dd/MM/yyyy");
        }
        verificaRegistroNullo(dataAlocacaoFim);
        //altera status da reserva
        Object[] selectionStatusReserva = {"CANCELADO", "ABERTO"};
        String initialSelectionStatusReserva = reserva.getEnumStatus().toString();
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
        String initialSelectionMaterial = reserva.getMaterial().getNome();
        Object selectionMaterial = JOptionPane.showInputDialog(null, "Selecione o Material",
                "Alterar Material", JOptionPane.QUESTION_MESSAGE, null, selectionValuesMaterial, initialSelectionMaterial);
        List<Material> material = MaterialDAO.buscarPorNome((String) selectionMaterial);
        verificaRegistroNullo(selectionMaterial);
        verificarDisponibilidadeMaterial(material.get(0), dataAlocacaoInicio, dataAlocacaoFim);
        reservarMaterial(material.get(0), dataAlocacaoInicio, dataAlocacaoFim);
        verificaRegistroNullo(material);
        //altera espaco selecionado na reserva
        Object[] selectionValuesEspaco = EspacoDAO.findEspacoInArray();
        String initialSelectionEspaco = (String) reserva.getEspaco().getNome();
        Object selectionEspaco = JOptionPane.showInputDialog(null, "Selecione o Espaco",
                "Alterar Espaço", JOptionPane.QUESTION_MESSAGE, null, selectionValuesEspaco, initialSelectionEspaco);
        List<Espaco> espaco = EspacoDAO.buscarPorNome((String) selectionEspaco);
        verificaRegistroNullo(selectionEspaco);
        verificarDisponibilidadeEspaco(espaco.get(0), dataAlocacaoInicio, dataAlocacaoFim);
        reservarEspaco(espaco.get(0), dataAlocacaoInicio, dataAlocacaoFim);
        verificaRegistroNullo(espaco);
        reserva.setTitulo(tituloReserva);
        reserva.setDataAlocacaoInicio(dataAlocacaoInicio);
        reserva.setDataAlocacaoFim(dataAlocacaoFim);
        reserva.setEnumStatus(statusReserva);
        reserva.setMaterial(material.get(0));
        reserva.setEspaco(espaco.get(0));
    }

    public static void excluir(Reserva reserva) {
        usuarioReserva.remove(reserva);
        JOptionPane.showMessageDialog(null, "Reserva excluida com sucesso!");
    }

    public static void cadastroReserva() {
        try {

            if (ClienteDAO.getClientes().size() == 0){
                JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado!"+"\n"+ "Por favor cadastre um cliente.", "Atenção", JOptionPane.WARNING_MESSAGE);
                chamaMenuPrincipal();
            } else if (MaterialDAO.getMaterialList().size() == 0) {
                JOptionPane.showMessageDialog(null, "Nenhum material cadastrado!" + "\n" + "Por favor cadastre um material.", "Atenção", JOptionPane.WARNING_MESSAGE);
                chamaMenuPrincipal();
            } else if (EspacoDAO.getEspacos().size() == 0) {
                JOptionPane.showMessageDialog(null, "Nenhum espaço cadastrado!" + "\n" + "Por favor cadastre um espaço.", "Atenção", JOptionPane.WARNING_MESSAGE);
                chamaMenuPrincipal();
            }

            Integer codigoReserva = CalcularCodigo.calculaCodigo(ReservaDAO.getUsuarioReserva());
            String titulo = JOptionPane.showInputDialog(null, "Digite o titulo da reserva");
            verificaRegistroNullo(titulo);
            LocalDate dataReservaInicio = LocalDate.now();
            String imputDataReservaInicio = JOptionPane.showInputDialog(null, "Digite a data de inicio da reserva");
            try {
                dataReservaInicio = LocalDate.parse(imputDataReservaInicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data invalida, tente no formato dd/MM/yyyy");
            }
            verificaRegistroNullo(imputDataReservaInicio);
            LocalDate dataReservaFim = LocalDate.now();
            String imputDataReservaFim = JOptionPane.showInputDialog(null, "Digite a data de fim da reserva");
            try {
                dataReservaFim = LocalDate.parse(imputDataReservaFim, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data invalida, tente no formato dd/MM/yyyy");
            }
            verificaRegistroNullo(imputDataReservaFim);
            Object[] selectionValuesUsuarioCliente = ClienteDAO.findUsuarioClienteInArray();
            String initialSelectionUsuarioCliente = (String) selectionValuesUsuarioCliente[0];
            Object selectionUsuarioCliente = JOptionPane.showInputDialog(null, "Selecione o cliente",
                    "VendasApp", JOptionPane.QUESTION_MESSAGE, null, selectionValuesUsuarioCliente, initialSelectionUsuarioCliente);
            List<Cliente> cliente = ClienteDAO.buscarPorNome((String) selectionUsuarioCliente);
            verificaRegistroNullo(selectionUsuarioCliente);
            EnumStatusReserva statusReserva = EnumStatusReserva.ABERTO;
            Object[] selectionValuesEspaco = EspacoDAO.findEspacoInArray();
            String initialSelectionEspaco = (String) selectionValuesEspaco[0];
            Object selectionEspaco = JOptionPane.showInputDialog(null, "Selecione o espaco",
                    "Alugar espaco", JOptionPane.QUESTION_MESSAGE, null, selectionValuesEspaco, initialSelectionEspaco);
            List<Espaco> espaco = EspacoDAO.buscarPorNome((String) selectionEspaco);
            verificaRegistroNullo(selectionEspaco);
            verificarDisponibilidadeEspaco(espaco.get(0), dataReservaInicio, dataReservaFim);
            reservarEspaco(espaco.get(0), dataReservaInicio, dataReservaFim);
            Object[] selectionValuesMaterial = MaterialDAO.findMaterialInArray();
            String initialSelectionMaterial = (String) selectionValuesMaterial[0];
            Object selectionMaterial = JOptionPane.showInputDialog(null, "Selecione o Material",
                    "Alugar Material", JOptionPane.QUESTION_MESSAGE, null, selectionValuesMaterial, initialSelectionMaterial);
            List<Material> material = MaterialDAO.buscarPorNome((String) selectionMaterial);
            verificaRegistroNullo(selectionMaterial);
            verificarDisponibilidadeMaterial(material.get(0), dataReservaInicio, dataReservaFim);
            reservarMaterial(material.get(0), dataReservaInicio, dataReservaFim);
            Double diasReserva = calcularDias(dataReservaInicio, dataReservaFim);
            if(diasReserva == 0.0){
                diasReserva = 1.0;
            }
            Double valorReserva = calcularValor(material.get(0), espaco.get(0), diasReserva);
            Reserva reserva = new Reserva(codigoReserva, titulo, LocalDate.now(), dataReservaInicio, dataReservaFim, cliente.get(0), statusReserva, material.get(0), espaco.get(0), valorReserva);
            salvar(reserva);
            JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            chamaMenuPrincipal();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cadastro Invalido, favor tentar novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            chamaMenuPrincipal();
        }

    }

    public static void cancelarReserva() {
        Object[] selectionValuesReserva = ReservaDAO.findReservaInArray();
        String initialSelectionReserva = (String) selectionValuesReserva[0];
        Object selectionReserva = JOptionPane.showInputDialog(null, "Selecione a reserva",
                "Cancelar Reserva", JOptionPane.QUESTION_MESSAGE, null, selectionValuesReserva, initialSelectionReserva);
        List<Reserva> reserva = ReservaDAO.buscarPorNome((String) selectionReserva);
        verificaRegistroNullo(selectionReserva);
        ReservaDAO.cancelar(reserva.get(0));
        JOptionPane.showMessageDialog(null, "Reserva cancelada com sucesso!", "Cancelamento", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, ReservaDAO.buscaTodos());
    }
}
