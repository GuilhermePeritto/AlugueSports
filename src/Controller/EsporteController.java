package Controller;
import Model.Esporte;
import Repository.EsporteDAO;
import javax.swing.*;
import java.util.List;

import static Model.VerificaRegistroNullo.verificaRegistroNullo;

public class EsporteController {
    public static void processoEsporte() {
        Object[] selectionValues = EsporteDAO.findEsportesInArray();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o esporte!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Esporte> esportes = EsporteDAO.buscarPorNome((String) selection);
        verificaRegistroNullo(selection);
        Object[] selectionValuesEsporte = {"Alterar Dados - Esporte", "Excluir Cadastro - Esporte", "Busca por nome - Esporte"};
        String initialSelectionEsporte = (String) selectionValues[0];
        Object selectionEsporte = JOptionPane.showInputDialog(null, "Selecione o processo!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValuesEsporte, initialSelectionEsporte);
        verificaRegistroNullo(selectionEsporte);
        switch ((String) selectionEsporte) {
            case "Alterar Dados - Esporte":
                EsporteDAO.alterar(esportes.get(0));
                break;
            case "Excluir Cadastro - Esporte":
                EsporteDAO.excluir(esportes.get(0));
                break;
            case "Busca por nome - Esporte":
                String nomeBusca = JOptionPane.showInputDialog(null, "Informe o nome para busca.");
                EsporteDAO.buscarPorNome(nomeBusca);
                break;
        }
    }
}
