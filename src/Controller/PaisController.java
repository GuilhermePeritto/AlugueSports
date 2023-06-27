package Controller;
import Model.Pais;
import Repository.PaisDAO;
import javax.swing.*;
import java.util.List;
import static Model.VerificaRegistroNullo.verificaRegistroNullo;

public class PaisController {
    public static void processoPais() {
        Object[] selectionValues = PaisDAO.findPaisInArray();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o Pais!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Pais> pais = PaisDAO.buscarPorNome((String) selection);
        verificaRegistroNullo(selection);
        Object[] selectionValuesCliente = {"Alterar Dados", "Excluir Cadastro"};
        String initialSelectionCliente = (String) selectionValues[0];
        Object selectionCliente = JOptionPane.showInputDialog(null, "Selecione o processo!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValuesCliente, initialSelectionCliente);
        verificaRegistroNullo(selectionCliente);

        switch ((String) selectionCliente) {
            case "Alterar Dados":
                PaisDAO.alterardadospais(pais.get(0));
                break;
            case "Excluir Cadastro":
                PaisDAO.excluirCadastropais(pais.get(0));
        }

    }
}
