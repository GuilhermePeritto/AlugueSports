package Repository;
import Model.UsuarioCliente;
import java.util.ArrayList;
import java.util.List;

public class UsuarioClienteDAO {
    static List<UsuarioCliente> usuarioClientes = new ArrayList<>();
    public static void salvar(UsuarioCliente usuarioCliente) {
        usuarioClientes.add(usuarioCliente);
    }
    public static List<UsuarioCliente> buscaTodos() {
        return usuarioClientes;
    }

    public static List<UsuarioCliente> buscarPorNome(String nome) {
        List<UsuarioCliente> usuarioClientesFiltradas = new ArrayList<>();
        for (UsuarioCliente usuarioCliente : usuarioClientes) {
            if (usuarioCliente.getNome().contains(nome)) {
                usuarioClientesFiltradas.add(usuarioCliente);
            }
        }
        return usuarioClientesFiltradas;
    }

    public static Object[] findUsuarioClienteInArray() {
        List<UsuarioCliente> usuarioClientes = buscaTodos();
        List<String> clienteNomes = new ArrayList<>();

        for (UsuarioCliente usuarioCliente : usuarioClientes) {
            clienteNomes.add(usuarioCliente.getNome());
        }

        return clienteNomes.toArray();
    }
}
