package View;

import Model.*;
import Repository.*;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ViewController extends View {

    public static void cadastroUsuarioCliente() {
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
    }

    public static void cadastroEsporte() {
        Integer codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o codigo do esporte"));
        String nomeEsporte = JOptionPane.showInputDialog(null, "Digite o nome do esporte");
        Esporte esporte = new Esporte(codigo, nomeEsporte);
        EsporteDAO.salvar(esporte);
        chamaMenuPrincipal();
    }

    public static void cadastroPais() {
        Integer codigoPais = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o código do país"));
        String nomePais = JOptionPane.showInputDialog(null, "Digite o nome do país");
        Pais pais = new Pais(codigoPais, nomePais);
        PaisDAO.salvar(pais);
        chamaMenuPrincipal();
    }

    public static void cadastroMaterial() {
        Integer codigoMaterial = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o código do material"));
        String nomeMaterial = JOptionPane.showInputDialog(null, "Digite o nome do material");
        Material material = new Material(codigoMaterial, nomeMaterial);
        MaterialDAO.salvar(material);
        chamaMenuPrincipal();
    }

    public static void cadastroEspaco() {
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
    }

    public static <EnumStatusReserva> void cadastroReserva() {
        Integer codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o código da reserva"));
        //DATA RESERVA
        LocalDate dataReserva = LocalDate.now();
        String imputDataReserva = JOptionPane.showInputDialog(null, "Digite a data de reserva");
        try {
            dataReserva = LocalDate.parse(imputDataReserva, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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
        Reserva reserva = new Reserva(codigo, LocalDate.now(), dataReserva, usuarioCliente.get(0), statusReserva);
        ReservaDAO.salvar(reserva);
        chamaMenuPrincipal();
    }

    public static void listBoxCadastros() {
        try {
            Object[] selectionValues = {"Cliente", "Esporte", "Material", "Pais", "Espaço", "Reserva"};
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
            confirmacaoDeCancelamento();
        }
    }

    public static void confirmacaoDeCancelamento() {
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja cancelar o cadastro?", "Confirmação", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Cadastro cancelado.");
            System.out.println("Cadastro cancelado.");
            chamaMenuPrincipal();
        } else {
            // Código para continuar o cadastro aqui
            System.out.println("Continuando o cadastro.");
        }
    }

}