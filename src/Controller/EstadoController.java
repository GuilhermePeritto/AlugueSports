package Controller;
import Model.Estado;
import Repository.EstadoDAO;
import javax.swing.*;
import java.util.List;

import static Model.VerificaRegistroNullo.verificaRegistroNullo;

public class EstadoController {
    public static void processoEstado() throws ClassNotFoundException {

        Object[] selectionValues = EstadoDAO.findEstadoInArray();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o Estado!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

        List<Estado> estados = EstadoDAO.buscarPorNome((String) selection);
        verificaRegistroNullo(selection);
        Object[] selectionValuesCliente = {"Alterar Dados", "Excluir Cadastro"};
        String initialSelectionCliente = (String) selectionValues[0];
        Object selectionCliente = JOptionPane.showInputDialog(null, "Selecione o processo!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValuesCliente, initialSelectionCliente);
        verificaRegistroNullo(selectionCliente);

        switch ((String) selectionCliente) {
            case "Alterar Dados":
                EstadoDAO.alterar(estados.get(0));
                break;
            case "Excluir Cadastro":
                EstadoDAO.excluir(estados.get(0));
        }
    }
}
