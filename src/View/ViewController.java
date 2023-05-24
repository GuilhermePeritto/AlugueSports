package View;

import Model.*;
import Repository.*;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static Repository.ReservaDAO.reservarMaterial;
import static Repository.ReservaDAO.verificarDisponibilidade;

public class ViewController extends View {

    public static void cadastroUsuarioCliente() {
        try {
            Integer codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o codigo"));
            String nome = JOptionPane.showInputDialog(null, "Digite o nome");
            String telefone = JOptionPane.showInputDialog(null, "Digite o telefone");
            String cpf = JOptionPane.showInputDialog(null, "Digite o cpf");
            String rg = JOptionPane.showInputDialog(null, "Digite o rg");
            JCheckBox jCheckBox = new JCheckBox("Cliente");
            int result = JOptionPane.showOptionDialog(null, jCheckBox, "Informe se o cadastro é cliente?",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
            Boolean cliente = jCheckBox.isSelected();
            UsuarioCliente pessoa = new UsuarioCliente(codigo, nome, telefone, cpf, rg, cliente);
            UsuarioClienteDAO.salvar(pessoa);
            chamaMenuPrincipal();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cadastro Invalido, favor tentar novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            cadastroUsuarioCliente();
        }
    }

    public static void cadastroEsporte() {
        try {
            Integer codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o codigo do esporte"));
            String nomeEsporte = JOptionPane.showInputDialog(null, "Digite o nome do esporte");
            Esporte esporte = new Esporte(codigo, nomeEsporte);
            EsporteDAO.salvar(esporte);
            chamaMenuPrincipal();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cadastro Invalido, favor tentar novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            cadastroEsporte();
        }
    }

    public static void cadastroPais() {
        try {
            Integer codigoPais = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o código do país"));
            String nomePais = JOptionPane.showInputDialog(null, "Digite o nome do país");
            Pais pais = new Pais(codigoPais, nomePais);
            PaisDAO.salvar(pais);
            chamaMenuPrincipal();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cadastro Invalido, favor tentar novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            cadastroPais();
        }
    }

    public static void cadastroEstado() {
        try {
            Integer codigoEstado = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o codigo do estado"));
            String nomeEstado = JOptionPane.showInputDialog(null, "Digite o nome do estado");
            String sigla = JOptionPane.showInputDialog(null, "Digite a sigla do estado");
            Object[] selectionValuesPais = PaisDAO.findPaisInArray();
            String initialSelectionPais = (String) selectionValuesPais[0];
            Object selectionPais = JOptionPane.showInputDialog(null, "Selecione o país",
                    "Lista de Países", JOptionPane.QUESTION_MESSAGE, null, selectionValuesPais, initialSelectionPais);
            List<Pais> pais = PaisDAO.buscarPorNome((String) selectionPais);
            Estado estado = new Estado(codigoEstado, nomeEstado, sigla, pais.get(0));
            EstadoDAO.salvar(estado);
            chamaMenuPrincipal();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cadastro Invalido, favor tentar novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            cadastroEstado();
        }
    }

    public static void cadastroMaterial() {
        try {
            Integer codigoMaterial = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o código do material"));
            String nomeMaterial = JOptionPane.showInputDialog(null, "Digite o nome do material");

            Object[] selectionStatusMaterial = {"ALUGADO", "DISPONIVEL"};
            String initialSelectionStatusMaterial = (String) selectionStatusMaterial[0];
            Object selectionStatus = JOptionPane.showInputDialog(null, "Selecione o status do material?",
                    "Lista de Status", JOptionPane.QUESTION_MESSAGE, null, selectionStatusMaterial, initialSelectionStatusMaterial);
            EnumStatusMaterial statusMaterial = EnumStatusMaterial.DISPONIVEL;
            if (selectionStatus.equals("ALUGADO")) {
                statusMaterial = EnumStatusMaterial.ALUGADO;
            } else if (selectionStatus.equals("DISPONIVEL")) {
                statusMaterial = EnumStatusMaterial.DISPONIVEL;
            }

            Material material = new Material(codigoMaterial, nomeMaterial, statusMaterial);
            MaterialDAO.salvar(material);
            chamaMenuPrincipal();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cadastro Invalido, favor tentar novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            cadastroMaterial();
        }
    }

    public static void cadastroEspaco() {
        try {
            Integer codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o código do espaco"));
            String nomeEspaco = JOptionPane.showInputDialog(null, "Digite o nome do espaco");
            Object[] selectionValuesEsporte = EsporteDAO.findEsportesInArray();
            String initialSelectionEsporte = (String) selectionValuesEsporte[0];
            Object selectionEsporte = JOptionPane.showInputDialog(null, "Selecione tipo de esporte?",
                    "VendasApp", JOptionPane.QUESTION_MESSAGE, null, selectionValuesEsporte, initialSelectionEsporte);
            List<Esporte> esporte = EsporteDAO.buscarPorNome((String) selectionEsporte);
            Espaco espaco = new Espaco(codigo, nomeEspaco, esporte.get(0));
            EspacoDAO.salvar(espaco);
            chamaMenuPrincipal();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cadastro Invalido, favor tentar novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            cadastroEspaco();
        }
    }

    public static void cadastroReserva() {
        try {
            Integer codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o código da reserva"));
            String titulo = JOptionPane.showInputDialog(null, "Digite o titulo da reserva");
            //DATA RESERVA
            LocalDate dataReservaInicio = LocalDate.now();
            String imputDataReservaInicio = JOptionPane.showInputDialog(null, "Digite a data de inicio da reserva");
            try {
                dataReservaInicio = LocalDate.parse(imputDataReservaInicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data invalida, tente no formato dd/MM/yyyy");
            }

            LocalDate dataReservaFim = LocalDate.now();
            String imputDataReservaFim = JOptionPane.showInputDialog(null, "Digite a data de fim da reserva");
            try {
                dataReservaFim = LocalDate.parse(imputDataReservaFim, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data invalida, tente no formato dd/MM/yyyy");
            }
            //USUARIO
            Object[] selectionValuesUsuarioCliente = UsuarioClienteDAO.findUsuarioClienteInArray();
            String initialSelectionUsuarioCliente = (String) selectionValuesUsuarioCliente[0];
            Object selectionUsuarioCliente = JOptionPane.showInputDialog(null, "Selecione o cliente?",
                    "VendasApp", JOptionPane.QUESTION_MESSAGE, null, selectionValuesUsuarioCliente, initialSelectionUsuarioCliente);
            List<UsuarioCliente> usuarioCliente = UsuarioClienteDAO.buscarPorNome((String) selectionUsuarioCliente);
            //FORMA DE PAGAMENTO
            Object[] selectionStatusReserva = {"ABERTO", "CANCELADO", "FINALIZADO"};
            String initialSelectionStatusReserva = (String) selectionStatusReserva[0];
            Object selectionStatus = JOptionPane.showInputDialog(null, "Selecione o status da reserva?",
                    "VendasApp", JOptionPane.QUESTION_MESSAGE, null, selectionStatusReserva, initialSelectionStatusReserva);

            Model.EnumStatusReserva statusReserva = Model.EnumStatusReserva.ABERTO;
            if (selectionStatus.equals("CANCELADO")) {
                statusReserva = Model.EnumStatusReserva.CANCELADO;
            } else if (selectionStatus.equals("FINALIZADO")) {
                statusReserva = Model.EnumStatusReserva.FINALIZADO;
            }

            Object[] selectionValuesEspaco = EspacoDAO.findEsportesInArray();
            String initialSelectionEspaco = (String) selectionValuesEspaco[0];
            Object selectionEspaco = JOptionPane.showInputDialog(null, "Selecione o espaco?",
                    "Alugar espaco", JOptionPane.QUESTION_MESSAGE, null, selectionValuesEspaco, initialSelectionEspaco);
            List<Espaco> espaco = EspacoDAO.buscarPorNome((String) selectionEspaco);

            Object[] selectionValuesMaterial = MaterialDAO.findMaterialInArray();
            String initialSelectionMaterial = (String) selectionValuesMaterial[0];
            Object selectionMaterial = JOptionPane.showInputDialog(null, "Selecione o Material?",
                    "Alugar Material", JOptionPane.QUESTION_MESSAGE, null, selectionValuesMaterial, initialSelectionMaterial);
            List<Material> material = MaterialDAO.buscarPorNome((String) selectionMaterial);
            verificarDisponibilidade(material.get(0), dataReservaInicio, dataReservaFim);
            reservarMaterial(material.get(0), dataReservaInicio, dataReservaFim);
            if (!verificarDisponibilidade(material.get(0), dataReservaInicio, dataReservaFim)) {
                listBoxCadastros();
            }
            Reserva reserva = new Reserva(codigo, titulo, LocalDate.now(), dataReservaInicio, dataReservaFim,usuarioCliente.get(0), statusReserva, material.get(0), espaco.get(0));
            ReservaDAO.salvar(reserva);
            chamaMenuPrincipal();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cadastro Invalido, favor tentar novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            cadastroReserva();
        }
    }

    public static void cancelarReserva() {
        Object[] selectionValuesReserva = ReservaDAO.findReservaInArray();
        String initialSelectionReserva = (String) selectionValuesReserva[0];
        Object selectionReserva = JOptionPane.showInputDialog(null, "Selecione a reserva?",
                "Cancelar Reserva", JOptionPane.QUESTION_MESSAGE, null, selectionValuesReserva, initialSelectionReserva);
        List<Reserva> reserva = ReservaDAO.buscarPorNome((String) selectionReserva);
        ReservaDAO.cancelar(reserva.get(0));
        JOptionPane.showMessageDialog(null, "Reserva cancelada com sucesso!");
        JOptionPane.showMessageDialog(null, ReservaDAO.buscaTodos());
    }

    public static void alugarMaterial() {
        Object[] selectionValuesMaterial = MaterialDAO.findMaterialInArray();
        String initialSelectionMaterial = (String) selectionValuesMaterial[0];
        Object selectionMaterial = JOptionPane.showInputDialog(null, "Selecione o Material?",
                "Alugar Material", JOptionPane.QUESTION_MESSAGE, null, selectionValuesMaterial, initialSelectionMaterial);
        List<Material> alugarMaterial = MaterialDAO.buscarPorNome((String) selectionMaterial);
        MaterialDAO.alugarMaterial(alugarMaterial.get(0));
        JOptionPane.showMessageDialog(null, "Material alugado com sucesso!");
        JOptionPane.showMessageDialog(null, MaterialDAO.buscaTodos());
    }

    public static void cancelarAluguelMaterial() {
        Object[] selectionValuesMaterial = MaterialDAO.findMaterialInArray();
        String initialSelectionMaterial = (String) selectionValuesMaterial[0];
        Object selectionMaterial = JOptionPane.showInputDialog(null, "Selecione o Material?",
                "Alugar Material", JOptionPane.QUESTION_MESSAGE, null, selectionValuesMaterial, initialSelectionMaterial);
        List<Material> alugarMaterial = MaterialDAO.buscarPorNome((String) selectionMaterial);
        MaterialDAO.cancelarAluguel(alugarMaterial.get(0));
        JOptionPane.showMessageDialog(null, "Aluguel de material cancelado com sucesso!");
        JOptionPane.showMessageDialog(null, MaterialDAO.buscaTodos());
    }

    public static void listBoxCadastros() {
        try {
            Object[] selectionValues = {"Cliente", "Esporte", "Material", "Pais", "Estado", "Espaço", "Reserva"};
            String initialSelection = (String) selectionValues[0];
            Object selection = JOptionPane.showInputDialog(null, "Selecione o tipo de cadastro?",
                    "Cadastro", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

            switch ((String) selection) {
                case "Cliente":
                    cadastroUsuarioCliente();
                    break;
                case "Esporte":
                    cadastroEsporte();
                    break;
                case "Material":
                    cadastroMaterial();
                    break;
                case "Pais":
                    cadastroPais();
                    break;
                case "Estado":
                    cadastroEstado();
                    break;
                case "Espaço":
                    cadastroEspaco();
                    break;
                case "Reserva":
                    cadastroReserva();
                    break;
                default:
                    chamaMenuPrincipal();
            }
        } catch (Exception e) {
            chamaMenuPrincipal();
        }
    }

    public static void listBoxProcessos() {
        try {
            Object[] selectionValues = {"Cancelar Reserva", "Alugar Material", "Cancelar Aluguel de material"};
            String initialSelection = (String) selectionValues[0];
            Object selection = JOptionPane.showInputDialog(null, "Selecione o tipo de processo?",
                    "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

            switch ((String) selection) {
                case "Cancelar Reserva":
                    cancelarReserva();
                    break;
                case "Alugar Material":
                    alugarMaterial();
                    break;
                case "Cancelar Aluguel de material":
                    cancelarAluguelMaterial();
                    break;

                default:
                    chamaMenuPrincipal();
            }
        } catch (Exception e) {
            chamaMenuPrincipal();
        }
    }
}