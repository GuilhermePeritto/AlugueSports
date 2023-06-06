package View;

import Model.*;
import Repository.*;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static Form.RelatorioClienteForm.emitirRelatorio;
import static Model.VerificaRegistroNullo.verificaRegistroNullo;
import static Repository.ReservaDAO.*;

public class ViewController extends View {

    public static void cadastroCliente() {
        try {
            Integer codigo = ClienteDAO.canculaCodigo();
            String nome = JOptionPane.showInputDialog(null, "Digite o nome");
            verificaRegistroNullo(nome);
            LocalDate nascimento = LocalDate.now();
            String imputnascimento = JOptionPane.showInputDialog(null, "Digite a data de nascimento");
            try {
                nascimento = LocalDate.parse(imputnascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data invalida, tente no formato dd/MM/yyyy");
            }
            verificaRegistroNullo(nascimento);
            String telefone = JOptionPane.showInputDialog(null, "Digite o telefone");
            verificaRegistroNullo(telefone);
            String cpf = JOptionPane.showInputDialog(null, "Digite o cpf");
            verificaRegistroNullo(cpf);
            String rg = JOptionPane.showInputDialog(null, "Digite o rg");
            verificaRegistroNullo(rg);
            Cliente pessoa = new Cliente(codigo, nome, nascimento, telefone, cpf, rg);
            ClienteDAO.salvar(pessoa);
            JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            chamaMenuPrincipal();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cadastro Invalido, favor tentar novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            chamaMenuPrincipal();
        }
    }

    public static void cadastroEsporte() {
        try {
            Integer codigo = EsporteDAO.canculaCodigo();
            String nomeEsporte = JOptionPane.showInputDialog(null, "Digite o nome do esporte");
            Esporte esporte = new Esporte(codigo, nomeEsporte);
            EsporteDAO.salvar(esporte);
            JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            chamaMenuPrincipal();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cadastro Invalido, favor tentar novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            chamaMenuPrincipal();
        }
    }

    public static void cadastroPais() {
        try {
            Integer codigoPais = PaisDAO.canculaCodigo();
            String nomePais = JOptionPane.showInputDialog(null, "Digite o nome do país");
            verificaRegistroNullo(nomePais);
            Pais pais = new Pais(codigoPais, nomePais);
            PaisDAO.salvar(pais);
            JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            chamaMenuPrincipal();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cadastro Invalido, favor tentar novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            chamaMenuPrincipal();
        }
    }

    public static void cadastroEstado() {
        try {
            Integer codigoEstado = EstadoDAO.canculaCodigo();
            String nomeEstado = JOptionPane.showInputDialog(null, "Digite o nome do estado");
            verificaRegistroNullo(nomeEstado);
            String sigla = JOptionPane.showInputDialog(null, "Digite a sigla do estado");
            verificaRegistroNullo(sigla);
            Object[] selectionValuesPais = PaisDAO.findPaisInArray();
            String initialSelectionPais = (String) selectionValuesPais[0];
            Object selectionPais = JOptionPane.showInputDialog(null, "Selecione o país",
                    "Lista de Países", JOptionPane.QUESTION_MESSAGE, null, selectionValuesPais, initialSelectionPais);
            List<Pais> pais = PaisDAO.buscarPorNome((String) selectionPais);
            verificaRegistroNullo(selectionPais);
            Estado estado = new Estado(codigoEstado, nomeEstado, sigla, pais.get(0));
            EstadoDAO.salvar(estado);
            JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            chamaMenuPrincipal();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cadastro Invalido, favor tentar novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            chamaMenuPrincipal();
        }
    }

    public static void cadastroMaterial() {
        try {
            Integer codigoMaterial = MaterialDAO.canculaCodigo();
            String nomeMaterial = JOptionPane.showInputDialog(null, "Digite o nome do material");
            verificaRegistroNullo(nomeMaterial);
            Object[] selectionStatusMaterial = {"ALUGADO", "DISPONIVEL"};
            String initialSelectionStatusMaterial = (String) selectionStatusMaterial[0];
            Object selectionStatus = JOptionPane.showInputDialog(null, "Selecione o status do material",
                    "Lista de Status", JOptionPane.QUESTION_MESSAGE, null, selectionStatusMaterial, initialSelectionStatusMaterial);
            EnumStatusMaterial statusMaterial = EnumStatusMaterial.DISPONIVEL;
            if (selectionStatus.equals("ALUGADO")) {
                statusMaterial = EnumStatusMaterial.ALUGADO;
            } else if (selectionStatus.equals("DISPONIVEL")) {
                statusMaterial = EnumStatusMaterial.DISPONIVEL;
            }
            verificaRegistroNullo(selectionStatus);
            Double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor do material"));
            verificaRegistroNullo(valor);
            Material material = new Material(codigoMaterial, nomeMaterial, statusMaterial, valor);
            MaterialDAO.salvar(material);
            JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            chamaMenuPrincipal();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cadastro Invalido, favor tentar novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            chamaMenuPrincipal();
        }
    }

    public static void cadastroEspaco() {
        try {
            Integer codigo = EspacoDAO.canculaCodigo();
            String nomeEspaco = JOptionPane.showInputDialog(null, "Digite o nome do espaco");
            verificaRegistroNullo(nomeEspaco);
            Object[] selectionValuesEsporte = EsporteDAO.findEsportesInArray();
            String initialSelectionEsporte = (String) selectionValuesEsporte[0];
            Object selectionEsporte = JOptionPane.showInputDialog(null, "Selecione tipo de esporte",
                    "VendasApp", JOptionPane.QUESTION_MESSAGE, null, selectionValuesEsporte, initialSelectionEsporte);
            List<Esporte> esporte = EsporteDAO.buscarPorNome((String) selectionEsporte);
            verificaRegistroNullo(selectionEsporte);
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
            Object[] selectionStatusEspaco = {"ALUGADO", "DISPONIVEL"};
            String initialSelectionStatusEspaco = (String) selectionStatusEspaco[0];
            Object selectionStatus = JOptionPane.showInputDialog(null, "Selecione o status do espaco!",
                    "Lista de Status", JOptionPane.QUESTION_MESSAGE, null, selectionStatusEspaco, initialSelectionStatusEspaco);
            EnumStatusEspaco statusEspaco = EnumStatusEspaco.DISPONIVEL;
            if (selectionStatus.equals("ALUGADO")) {
                statusEspaco = EnumStatusEspaco.ALUGADO;
            } else if (selectionStatus.equals("DISPONIVEL")) {
                statusEspaco = EnumStatusEspaco.DISPONIVEL;
            }
            verificaRegistroNullo(selectionStatus);
            Double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor do espaco"));
            verificaRegistroNullo(valor);
            Espaco espaco = new Espaco(codigo, nomeEspaco, esporte.get(0), dataReservaInicio, dataReservaFim, statusEspaco, valor);
            EspacoDAO.salvar(espaco);
            JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            chamaMenuPrincipal();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cadastro Invalido, favor tentar novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            chamaMenuPrincipal();
        }
    }

    public static void cadastroReserva() {
        try {
            Integer codigoReserva = ReservaDAO.canculaCodigo();
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
            Object[] selectionStatusReserva = {"ABERTO", "CANCELADO", "FINALIZADO"};
            String initialSelectionStatusReserva = (String) selectionStatusReserva[0];
            Object selectionStatus = JOptionPane.showInputDialog(null, "Selecione o status da reserva",
                    "VendasApp", JOptionPane.QUESTION_MESSAGE, null, selectionStatusReserva, initialSelectionStatusReserva);

            Model.EnumStatusReserva statusReserva = Model.EnumStatusReserva.ABERTO;
            if (selectionStatus.equals("CANCELADO")) {
                statusReserva = Model.EnumStatusReserva.CANCELADO;
            } else if (selectionStatus.equals("FINALIZADO")) {
                statusReserva = Model.EnumStatusReserva.FINALIZADO;
            }
            verificaRegistroNullo(selectionStatus);
            Object[] selectionValuesEspaco = EspacoDAO.findEsportesInArray();
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
            if (!verificarDisponibilidadeMaterial(material.get(0), dataReservaInicio, dataReservaFim)) {
                listBoxCadastros();
            }
            Double diasReserva = calculardias(dataReservaInicio, dataReservaFim);
            Double valorReserva = calcularValor(material.get(0), espaco.get(0), diasReserva);
            Reserva reserva = new Reserva(codigoReserva, titulo, LocalDate.now(), dataReservaInicio, dataReservaFim, cliente.get(0), statusReserva, material.get(0), espaco.get(0), valorReserva);
            ReservaDAO.salvar(reserva);
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

    public static void alugarMaterial() {
        Object[] selectionValuesMaterial = MaterialDAO.findMaterialInArray();
        String initialSelectionMaterial = (String) selectionValuesMaterial[0];
        Object selectionMaterial = JOptionPane.showInputDialog(null, "Selecione o Material",
                "Alugar Material", JOptionPane.QUESTION_MESSAGE, null, selectionValuesMaterial, initialSelectionMaterial);
        List<Material> alugarMaterial = MaterialDAO.buscarPorNome((String) selectionMaterial);
        verificaRegistroNullo(selectionMaterial);
        MaterialDAO.alugarMaterial(alugarMaterial.get(0));
        JOptionPane.showMessageDialog(null, "Material alugado com sucesso!", "Alugado", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, MaterialDAO.buscaTodos());
    }

    public static void cancelarAluguelMaterial() {
        Object[] selectionValuesMaterial = MaterialDAO.findMaterialInArray();
        String initialSelectionMaterial = (String) selectionValuesMaterial[0];
        Object selectionMaterial = JOptionPane.showInputDialog(null, "Selecione o Material",
                "Alugar Material", JOptionPane.QUESTION_MESSAGE, null, selectionValuesMaterial, initialSelectionMaterial);
        List<Material> alugarMaterial = MaterialDAO.buscarPorNome((String) selectionMaterial);
        verificaRegistroNullo(selectionMaterial);
        MaterialDAO.cancelarAluguel(alugarMaterial.get(0));
        JOptionPane.showMessageDialog(null, "Aluguel de material cancelado com sucesso!", "Alugado", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, MaterialDAO.buscaTodos());
    }

    public static void verificarReputacaoCliente() {
        Object[] selectionValuesUsuarioCliente = ClienteDAO.findUsuarioClienteInArray();
        String initialSelectionUsuarioCliente = (String) selectionValuesUsuarioCliente[0];
        Object selectionUsuarioCliente = JOptionPane.showInputDialog(null, "Selecione o cliente",
                "VendasApp", JOptionPane.QUESTION_MESSAGE, null, selectionValuesUsuarioCliente, initialSelectionUsuarioCliente);
        List<Cliente> cliente = ClienteDAO.buscarPorNome((String) selectionUsuarioCliente);
        verificaRegistroNullo(selectionUsuarioCliente);
        verificarCliente(cliente.get(0));
    }

    public static void listBoxCadastros() {
        try {
            Object[] selectionValues = {"Cliente", "Esporte", "Material", "Pais", "Estado", "Espaço", "Reserva"};
            String initialSelection = (String) selectionValues[0];
            Object selection = JOptionPane.showInputDialog(null, "Selecione o tipo de cadastro",
                    "Cadastro", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

            switch ((String) selection) {
                case "Cliente":
                    cadastroCliente();
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
            Object[] selectionValues = {"Cliente", "Esporte", "Material", "Pais", "Estado", "Espaço", "Reserva"};
            String initialSelection = (String) selectionValues[0];
            Object selection = JOptionPane.showInputDialog(null, "Selecione o tipo de processo",
                    "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

            switch ((String) selection) {
                case "Cliente":
                    processoCliente();
                    chamaMenuPrincipal();
                    break;
                case "Esporte":
//                    processoEsporte();
                    chamaMenuPrincipal();
                    break;
                case "Material":
//                    processoMaterial();
                    chamaMenuPrincipal();
                    break;
                case "Pais":
//                    processoPais();
                    chamaMenuPrincipal();
                    break;
                case "Estado":
//                    processoEstado();
                    chamaMenuPrincipal();
                    break;
                case "Espaço":
//                    processoEspaco();
                    chamaMenuPrincipal();
                    break;
                case "Reserva":
//                    processoReserva();
                    chamaMenuPrincipal();
                    break;
                default:
                    chamaMenuPrincipal();
            }
        } catch (Exception e) {
            chamaMenuPrincipal();
        }
    }

    public static void chamaMenuRelatorios() {
        try {
            Object[] selectionValues = {"Cliente", "Esporte", "Material", "Pais", "Estado", "Espaço", "Reserva"};
            String initialSelection = (String) selectionValues[0];
            Object selection = JOptionPane.showInputDialog(null, "Selecione o tipo de processo",
                    "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

            switch ((String) selection) {
                case "Cliente":
                    emitirRelatorio(ClienteDAO.buscaTodos());
                    break;
                case "Esporte":
                    //
                    break;
                case "Material":
//
                    break;
                case "Pais":
//
                    break;
                case "Estado":
//
                case "Cidade":
//
                    break;
                case "Espaço":
//
                    break;
                case "Reserva":
//
                    break;
                default:
                    chamaMenuPrincipal();
            }
        } catch (Exception e) {
            chamaMenuPrincipal();
        }
    }

    public static void processoCliente() {
        Object[] selectionValues = ClienteDAO.findUsuarioClienteInArray();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o cliente!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Cliente> cliente = ClienteDAO.buscarPorNome((String) selection);
        verificaRegistroNullo(selection);
        Object[] selectionValuesCliente = {"Alterar Dados", "Excluir Cadastro"};
        String initialSelectionCliente = (String) selectionValues[0];
        Object selectionCliente = JOptionPane.showInputDialog(null, "Selecione o processo!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValuesCliente, initialSelectionCliente);
        verificaRegistroNullo(selectionCliente);
        switch ((String) selectionCliente) {
            case "Alterar Dados":
                ClienteDAO.alterarDadosCliente(cliente.get(0));
                break;
            case "Excluir Cadastro":
                ClienteDAO.excluirCadastroCliente(cliente.get(0));
                break;
            case "Busca por nome":
                String nomeBusca = JOptionPane.showInputDialog(null,"Informe o nome para busca.");
                ClienteDAO.buscarPorNome(nomeBusca);
                break;
        }
    }

    public static void processoReserva() {
        Object[] selectionValues = ReservaDAO.findReservaInArray();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a reserva!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Reserva> reserva = ReservaDAO.buscarPorNome((String) selection);
        verificaRegistroNullo(selection);
        Object[] selectionValuesReserva = {"Alterar Dados", "Excluir Cadastro"};
        String initialSelectionReserva = (String) selectionValues[0];
        Object selectionReserva = JOptionPane.showInputDialog(null, "Selecione o processo!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValuesReserva, initialSelectionReserva);
        verificaRegistroNullo(selectionReserva);
        switch ((String) selectionReserva) {
            case "Alterar Dados":
                ReservaDAO.alterarDadosReserva(reserva.get(0));
                break;
            case "Excluir Cadastro":
                ReservaDAO.excluirCadastroReserva(reserva.get(0));
        }
    }
  
    public static void chamaMenuRelatorios() {
        try {
            Object[] selectionValues = {"Cliente", "Esporte", "Material", "Pais", "Estado", "Espaço", "Reserva"};
            String initialSelection = (String) selectionValues[0];
            Object selection = JOptionPane.showInputDialog(null, "Selecione o tipo de processo",
                    "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

            switch ((String) selection) {
                case "Cliente":
                    emitirRelatorio(ClienteDAO.buscaTodos());
                    break;
                case "Esporte":
                    //
                    break;
                case "Material":
//
                    break;
                case "Pais":
//
                    break;
                case "Estado":
//
                case "Cidade":
//
                    break;
                case "Espaço":
//
                    break;
                case "Reserva":
//
                    break;
                default:
                    chamaMenuPrincipal();
            }
        } catch (Exception e) {
            chamaMenuPrincipal();
        }
    }
}
