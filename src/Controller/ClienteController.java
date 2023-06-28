package Controller;
import Model.Cliente;
import Repository.ClienteDAO;
import javax.swing.*;
import java.util.List;

import static Model.VerificaRegistroNullo.verificaRegistroNullo;

public class ClienteController {


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
                ClienteDAO.alterar(cliente.get(0));
                break;
            case "Excluir Cadastro":
                ClienteDAO.excluir(cliente.get(0));
                break;
        }
    }
}
