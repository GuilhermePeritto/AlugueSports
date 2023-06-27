package Controller;

import Model.CalcularCodigo;
import Model.Cidade;
import Model.Estado;
import Repository.CidadeDAO;
import Repository.EstadoDAO;

import javax.swing.*;
import java.util.List;

import static Model.VerificaRegistroNullo.verificaRegistroNullo;

public class CidadeController {
    public static void processoCidade() {
        Object[] selectionValues = CidadeDAO.findCidadeInArray();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a cidade!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Cidade> cidades = CidadeDAO.buscarPorNome((String) selection);
        verificaRegistroNullo(selection);
        Object[] selectionValuesCidade = {"Alterar Dados", "Excluir Cadastro"};
        String initialSelectionCidade = (String) selectionValues[0];
        Object selectionCidade = JOptionPane.showInputDialog(null, "Selecione o processo!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValuesCidade, initialSelectionCidade);
        verificaRegistroNullo(selectionCidade);

        switch ((String) selectionCidade) {
            case "Alterar Dados":
                CidadeDAO.alterar(cidades.get(0));
                break;
            case "Excluir Cadastro":
                CidadeDAO.excluir(cidades.get(0));
                break;
            case "Busca por nome":
                String nomeBusca = JOptionPane.showInputDialog(null, "Informe o nome para busca.");
                CidadeDAO.buscarPorNome(nomeBusca);
                break;
        }
    }
}
