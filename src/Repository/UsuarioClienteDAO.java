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
}
