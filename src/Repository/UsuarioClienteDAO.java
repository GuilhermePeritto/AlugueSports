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
            if (usuarioCliente.getNomeUsuarioCliente().contains(nome)) {
                usuarioClientesFiltradas.add(usuarioCliente);
            }
        }
        return usuarioClientesFiltradas;
    }

    public static Object[] findUsuarioClienteInArray() {
        List<UsuarioCliente> usuarioClientes = buscaTodos();
        List<String> clienteNomes = new ArrayList<>();

        for (UsuarioCliente usuarioCliente : usuarioClientes) {
            clienteNomes.add(usuarioCliente.getNomeUsuarioCliente());
        }

        return clienteNomes.toArray();
    }
    public static Integer canculaCodigo(){
        return usuarioClientes.size() + 1;
    }
}
