package Controller;
import Model.Espaco;
import Repository.EspacoDAO;
import javax.swing.*;
import java.util.List;

import static Model.VerificaRegistroNullo.verificaRegistroNullo;

public class EspacoController {
    public static void processoEspaco() {
        Object[] selectionValues = EspacoDAO.findEspacoInArray();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o espaço.",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Espaco> espaco = EspacoDAO.buscarPorNome((String) selection);
        verificaRegistroNullo(selection);
        Object[] selectionValuesEspaco = {"Alterar Dados", "Excluir Cadastro"};
        String initialSelectionEspaco = (String) selectionValues[0];
        Object selectionCliente = JOptionPane.showInputDialog(null, "Selecione o processo!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValuesEspaco, initialSelectionEspaco);
        verificaRegistroNullo(selectionCliente);
        switch ((String) selectionCliente) {
            case "Alterar Dados":
                EspacoDAO.alterar(espaco.get(0));
                break;
            case "Excluir Cadastro":
                EspacoDAO.excluir(espaco.get(0));
        }
    }
}
