
package Repository;
        import Model.Pais;
        import java.util.ArrayList;
        import java.util.List;

public class PaisDAO {
    static List<Pais> paises = new ArrayList<>();
    public static void salvar(Pais pais) {
        paises.add(pais);
    }
    public static List<Pais> buscaTodos() {
        return paises;
    }
}
