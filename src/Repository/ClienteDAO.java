package Repository;
import Model.Cliente;
import Model.Pais;

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

    public static void excluirCadastroCliente(Cliente cliente) {
        clientes.remove(cliente);
        JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");
    }

    public static void alterarDadosCliente(Cliente cliente) {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome");
        verificaRegistroNullo(nome);
        cliente.setNome(nome);
        String telefone = JOptionPane.showInputDialog(null, "Digite o telefone");
        verificaRegistroNullo(telefone);
        cliente.setTelefone(telefone);
        String cpf = JOptionPane.showInputDialog(null, "Digite o cpf");
        verificaRegistroNullo(cpf);
        cliente.setCpf(cpf);
        String rg = JOptionPane.showInputDialog(null, "Digite o rg");
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
    public static Integer canculaCodigo(){
        return clientes.size() + 1;
    }

}
