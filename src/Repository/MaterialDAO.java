package Repository;
import Model.EnumStatusMaterial;
import Model.Material;
import Model.Pais;
import Model.UsuarioCliente;
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
    public static List<Material> buscarPorNome(String nome) {
        List<Material> materiaisFiltrados = new ArrayList<>();
        for (Material material : materialList) {
            if (material.getNomeMaterial().contains(nome)) {
                materialList.add(material);
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
}
