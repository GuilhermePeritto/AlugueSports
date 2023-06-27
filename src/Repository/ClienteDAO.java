package Repository;
import Model.CalcularCodigo;
import Model.Cliente;
import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import static Model.VerificaRegistroNullo.verificaRegistroNullo;
import static Model.View.chamaMenuPrincipal;

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
        String telefone = JOptionPane.showInputDialog(null, "Digite o telefone", cliente.getTelefone());
        verificaRegistroNullo(telefone);
        String cpf = JOptionPane.showInputDialog(null, "Digite o cpf", cliente.getCpf());
        verificaRegistroNullo(cpf);
        String rg = JOptionPane.showInputDialog(null, "Digite o rg", cliente.getRg());
        verificaRegistroNullo(rg);
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setCpf(cpf);
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

    public static void cadastroCliente() {
        try {
            Integer codigo = CalcularCodigo.calculaCodigo(ClienteDAO.getClientes());
            String nome = JOptionPane.showInputDialog(null, "Digite o nome");
            verificaRegistroNullo(nome);
            LocalDate nascimento = null;
            String imputnascimento = JOptionPane.showInputDialog(null, "Digite a data de nascimento");
            try {
                nascimento = LocalDate.parse(imputnascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data invalida, tente no formato dd/MM/yyyy");
            }
            verificaRegistroNullo(nascimento);
            String telefone = JOptionPane.showInputDialog(null, "Digite o telefone");
            verificaRegistroNullo(telefone);
            String cpf = JOptionPane.showInputDialog(null, "Digite o cpf");
            verificaRegistroNullo(cpf);
            String rg = JOptionPane.showInputDialog(null, "Digite o rg");
            verificaRegistroNullo(rg);
            Cliente pessoa = new Cliente(codigo, nome, nascimento, telefone, cpf, rg);
            ClienteDAO.salvar(pessoa);
            JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            chamaMenuPrincipal();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cadastro Invalido, favor tentar novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            chamaMenuPrincipal();
        }
    }
}
