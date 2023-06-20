package Repository;
import Model.Cliente;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static Model.VerificaRegistroNullo.verificaRegistroNullo;

public class ClienteDAO {
    static List<Cliente> clientes = new ArrayList<>();
    public static void salvar(Cliente cliente) {
        clientes.add(cliente);
    }
    public static List<Cliente> buscaTodos() {
        return clientes;
    }

    public static void excluir(Cliente cliente) {
        clientes.remove(cliente);
        JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");
    }

    public static void alterar(Cliente cliente) {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome", cliente.getNome());
        verificaRegistroNullo(nome);
        cliente.setNome(nome);
        String telefone = JOptionPane.showInputDialog(null, "Digite o telefone", cliente.getTelefone());
        verificaRegistroNullo(telefone);
        cliente.setTelefone(telefone);
        String cpf = JOptionPane.showInputDialog(null, "Digite o cpf", cliente.getCpf());
        verificaRegistroNullo(cpf);
        cliente.setCpf(cpf);
        String rg = JOptionPane.showInputDialog(null, "Digite o rg", cliente.getRg());
        verificaRegistroNullo(rg);
        cliente.setRg(rg);

    }



    public static List<Cliente> buscarPorNome(String nome) {
        List<Cliente> clientesFiltradas = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (cliente.getNome().contains(nome)) {
                clientesFiltradas.add(cliente);
            }
        }
        return clientesFiltradas;
    }

    public static Object[] findUsuarioClienteInArray() {
        List<Cliente> clientes = buscaTodos();
        List<String> clienteNomes = new ArrayList<>();

        for (Cliente cliente : clientes) {
            clienteNomes.add(cliente.getNome());
        }

        return clienteNomes.toArray();
    }

    public static List<Cliente> getClientes() {
        return clientes;
    }
}
