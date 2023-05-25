
package Repository;
        import Model.Pais;
        import Model.UsuarioCliente;

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

    public static List<Pais> buscarPorNome(String nome) {
        List<Pais> paisesFiltrados = new ArrayList<>();
        for (Pais pais : paises) {
            if (pais.getNomePais().contains(nome)) {
                paisesFiltrados.add(pais);
            }
        }
        return paisesFiltrados;
    }

    public static Object[] findPaisInArray() {
        List<Pais> paises = buscaTodos();
        List<String> paisNomes = new ArrayList<>();

        for (Pais pais : paises) {
            paisNomes.add(pais.getNomePais());
        }

        return paisNomes.toArray();
    }
    public static Integer canculaCodigo(){
        return paises.size() + 1;
    }
}
