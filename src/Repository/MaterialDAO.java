package Repository;
import Model.*;
import Model.Material;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static Model.VerificaRegistroNullo.verificaRegistroNullo;

public class MaterialDAO {
    static List<Material> materialList = new ArrayList<>();
    public static void salvar(Material material) {
        materialList.add(material);
    }

    public static List<Material> buscaTodos() {
        return materialList;
    }
    public static void alugarMaterial(Material material) {
        material.setEnumStatusMaterial(EnumStatusMaterial.ALUGADO);
    }


    public static void exluirCadastro(Material material) {
        materialList.remove(material);
        JOptionPane.showMessageDialog(null," Material removido com sucesso." );
    }


    public static void alterarDadosMaterial(Material material){
        String nomeMaterial = JOptionPane.showInputDialog(null," Infrome nome.");
        verificaRegistroNullo(nomeMaterial);
        material.setNomeMaterial(nomeMaterial);

        Object[] selectionStatusMaterial = {"ALUGADO", "DISPONIVEL", "CONSERTO", "INATIVADO"};
        String initialSelectionStatusMaterial = (String) selectionStatusMaterial[0];
        Object selectionStatus = JOptionPane.showInputDialog(null, "Selecione o status do material",
                "Lista de Status", JOptionPane.QUESTION_MESSAGE, null, selectionStatusMaterial, initialSelectionStatusMaterial);
        EnumStatusMaterial statusMaterial = EnumStatusMaterial.DISPONIVEL;

        if (selectionStatus.equals("ALUGADO")) {
            statusMaterial = EnumStatusMaterial.ALUGADO;
        } else if (selectionStatus.equals("DISPONIVEL")) {
            statusMaterial = EnumStatusMaterial.DISPONIVEL;
        } else if (selectionStatus.equals("CONSERTO")) {
            statusMaterial = EnumStatusMaterial.CONSERTO;
        } else if (selectionStatus.equals("INATIVADO")) {
            statusMaterial = EnumStatusMaterial.INATIVADO;
        }

        String valorStr = JOptionPane.showInputDialog(null, "Digite o valor do material");
        double valor = Double.parseDouble(valorStr);
        JOptionPane.showMessageDialog(null, "Material alterado com sucesso!");
    }


    public static void cancelarAluguel(Material material) {
        material.setEnumStatusMaterial(EnumStatusMaterial.DISPONIVEL);
    }

    public static List<Material> buscarPorNome(String nome) {
        List<Material> materiaisFiltrados = new ArrayList<>();
        for (Material material : materialList) {
            if (material.getNomeMaterial().contains(nome)) {
                materiaisFiltrados.add(material);
            }
        }
        return materialList;
    }

    public static Object[] findMaterialInArray() {
        List<Material> materiais = buscaTodos();
        List<String> materiaisNomes = new ArrayList<>();

        for (Material material : materiais) {
            materiaisNomes.add(material.getNomeMaterial());
        }

        return materiaisNomes.toArray();
    }
    public static Integer canculaCodigo(){
        return materialList.size() + 1;
    }
}
