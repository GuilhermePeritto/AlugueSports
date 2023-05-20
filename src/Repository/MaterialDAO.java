package Repository;
import Model.Material;
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
}
