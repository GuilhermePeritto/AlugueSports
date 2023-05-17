package Repository;
import Model.UsuarioCliente;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {
    static List<UsuarioCliente> pessoas = new ArrayList<>();
    public static void salvar(UsuarioCliente pessoa) {
        pessoas.add(pessoa);
    }
    public static List<UsuarioCliente> buscaTodos() {
            return pessoas;
        }
}
