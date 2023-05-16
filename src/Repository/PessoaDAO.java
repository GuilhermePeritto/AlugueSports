package Repository;
import Model.Pessoa;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {
    static List<Pessoa> pessoas = new ArrayList<>();
    public static void salvar(Pessoa pessoa) {
        pessoas.add(pessoa);
    }
    public static List<Pessoa> buscaTodos() {
            return pessoas;
        }
}
