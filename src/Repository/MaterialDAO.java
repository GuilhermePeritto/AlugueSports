package Repository;
import Model.*;
import Model.Material;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static Model.VerificaRegistroNullo.verificaRegistroNullo;

public class MaterialDAO extends VerificaRegistroNullo{
    static List<Material> materialList = new ArrayList<>();
    public static void salvar(Material material) {
        materialList.add(material);
    }

    public static List<Material> buscaTodos() {
        return materialList;
    }
    public static void alugar(Material material) {
        material.setEnumStatus(EnumStatusMaterial.ALUGADO);
    }


    public static void exluir(Material material) {
        materialList.remove(material);
        JOptionPane.showMessageDialog(null," Material removido com sucesso." );
    }


    public static void alterar(Material material){
        String nome = JOptionPane.showInputDialog(null," Informe o nome do material.", material.getNome());
        verificaRegistroNullo(nome);
        material.setNome(nome);

        Object[] selectionStatusMaterial = {"ALUGADO", "DISPONIVEL", "CONSERTO", "INATIVADO"};
        String initialSelectionStatusMaterial = material.getEnumStatus().toString();
        Object selectionStatus = JOptionPane.showInputDialog(null, "Selecione o status do material.",
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
        material.setEnumStatus(statusMaterial);

        String valor = JOptionPane.showInputDialog(null, "Digite o valor do material", material.getValor());
        material.setValor(Double.parseDouble(valor));
        JOptionPane.showMessageDialog(null, "Material alterado com sucesso!");
    }


    public static void cancelarAluguel(Material material) {
        material.setEnumStatus(EnumStatusMaterial.DISPONIVEL);
    }

    public static List<Material> buscarPorNome(String nome) {
        List<Material> materiaisFiltrados = new ArrayList<>();
        for (Material material : materialList) {
            if (material.getNome().contains(nome)) {
                materiaisFiltrados.add(material);
            }
        }
        return materialList;
    }

    public static Object[] findMaterialInArray() {
        List<Material> materiais = buscaTodos();
        List<String> materiaisNomes = new ArrayList<>();

        for (Material material : materiais) {
            materiaisNomes.add(material.getNome());
        }

        return materiaisNomes.toArray();
    }

    public static List<Material> getMaterialList() {
        return materialList;
    }
}
