package Repository;
import Model.*;
import Model.Material;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import static Model.View.chamaMenuPrincipal;

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
        verificaRegistroNullo(statusMaterial);
        String valor = JOptionPane.showInputDialog(null, "Digite o valor do material", material.getValor());
        verificaRegistroNullo(valor);
        material.setNome(nome);
        material.setEnumStatus(statusMaterial);
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

    public static void cadastroMaterial() {
        try {
            Integer codigoMaterial = CalcularCodigo.calculaCodigo(MaterialDAO.getMaterialList());
            String nomeMaterial = JOptionPane.showInputDialog(null, "Digite o nome do material");
            verificaRegistroNullo(nomeMaterial);
            EnumStatusMaterial statusMaterial = EnumStatusMaterial.DISPONIVEL;
            verificaRegistroNullo(statusMaterial);
            Double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor do material"));
            verificaRegistroNullo(valor);
            Material material = new Material(codigoMaterial, nomeMaterial, statusMaterial, valor);
            MaterialDAO.salvar(material);
            JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            chamaMenuPrincipal();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cadastro Invalido, favor tentar novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            chamaMenuPrincipal();
        }
    }
    public static void alugarMaterial() {
        Object[] selectionValuesMaterial = MaterialDAO.findMaterialInArray();
        String initialSelectionMaterial = (String) selectionValuesMaterial[0];
        Object selectionMaterial = JOptionPane.showInputDialog(null, "Selecione o Material",
                "Alugar Material", JOptionPane.QUESTION_MESSAGE, null, selectionValuesMaterial, initialSelectionMaterial);
        List<Material> alugarMaterial = MaterialDAO.buscarPorNome((String) selectionMaterial);
        verificaRegistroNullo(selectionMaterial);
        MaterialDAO.alugar(alugarMaterial.get(0));
        JOptionPane.showMessageDialog(null, "Material alugado com sucesso!", "Alugado", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, MaterialDAO.buscaTodos());
    }

    public static void cancelarAluguelMaterial() {
        Object[] selectionValuesMaterial = MaterialDAO.findMaterialInArray();
        String initialSelectionMaterial = (String) selectionValuesMaterial[0];
        Object selectionMaterial = JOptionPane.showInputDialog(null, "Selecione o Material",
                "Alugar Material", JOptionPane.QUESTION_MESSAGE, null, selectionValuesMaterial, initialSelectionMaterial);
        List<Material> alugarMaterial = MaterialDAO.buscarPorNome((String) selectionMaterial);
        verificaRegistroNullo(selectionMaterial);
        MaterialDAO.cancelarAluguel(alugarMaterial.get(0));
        JOptionPane.showMessageDialog(null, "Aluguel de material cancelado com sucesso!", "Alugado", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, MaterialDAO.buscaTodos());
    }
}
