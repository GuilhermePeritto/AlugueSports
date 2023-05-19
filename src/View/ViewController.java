package View;

import Model.Esporte;
import Model.UsuarioCliente;
import Repository.EsporteDAO;
import Repository.UsuarioClienteDAO;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ViewController extends View {

    public static void cadastroDePessoas() {
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

    public static void cadastroDeEsporte() {
        Integer codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o codigo do esporte"));
        String nomeEsporte = JOptionPane.showInputDialog(null, "Digite o nome do esporte");
        Esporte esporte = new Esporte(codigo, nomeEsporte);
        EsporteDAO.salvar(esporte);
        chamaMenuPrincipal();
    }

    public static void listBoxCadastros() {
        Object[] selectionValues = {"Cliente", "Esporte"};
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o tipo de cadastro?",
                "Cadastro", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

        switch ((String) selection) {
            case "Cliente":
                cadastroDePessoas();
                break;
            case "Esporte":
                cadastroDeEsporte();
                break;
            default:
                chamaMenuPrincipal();
        }


    }


}