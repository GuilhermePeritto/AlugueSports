package Controller;
import Model.Material;
import Repository.MaterialDAO;
import javax.swing.*;
import java.util.List;

import static Model.VerificaRegistroNullo.verificaRegistroNullo;

public class MaterialController {
    public static void processoMaterial() {
        Object[] selectionValues = MaterialDAO.findMaterialInArray();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o material!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Material> material = MaterialDAO.buscarPorNome((String) selection);
        verificaRegistroNullo(selection);
        Object[] selectionValuesMaterial = {"Alterar Dados", "Excluir Cadastro"};
        String initialSelectionMaterial = (String) selectionValues[0];
        Object selectionMaterial = JOptionPane.showInputDialog(null, "Selecione o processo!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValuesMaterial, initialSelectionMaterial);
        verificaRegistroNullo(selectionMaterial);
        switch ((String) selectionMaterial) {
            case "Alterar Dados":
                MaterialDAO.alterar(material.get(0));
                break;
            case "Excluir Cadastro":
                MaterialDAO.exluir(material.get(0));

                break;
        }
    }

}
