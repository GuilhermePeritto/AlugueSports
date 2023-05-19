package View;

import Model.Esporte;
import Model.Pais;
import Model.UsuarioCliente;
import Repository.EsporteDAO;
import Repository.PaisDAO;
import Repository.UsuarioClienteDAO;

import javax.swing.*;

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

    public static void cadstroPais(){
        Integer codigoPais = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o código do país"));
        String nomePais = JOptionPane.showInputDialog(null, "Digite o nome do país");
        Pais pais = new Pais(codigoPais, nomePais);
        PaisDAO.salvar(pais);
        chamaMenuPrincipal();
    }

    public static void listBoxCadastros() {
        Object[] selectionValues = {"Cliente", "Esporte"};
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
            default:
                chamaMenuPrincipal();
        }


    }


}