package Repository;
import Model.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

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
