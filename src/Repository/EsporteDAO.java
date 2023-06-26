package Repository;
import Model.CalcularCodigo;
import Model.Esporte;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import static Model.VerificaRegistroNullo.verificaRegistroNullo;
import static Model.View.chamaMenuPrincipal;

public class EsporteDAO {
    static List<Esporte> esportes= new ArrayList<>();
    public static void salvar(Esporte esporte) {
        esportes.add(esporte);
    }
    public static List<Esporte> buscaTodos() {
        return esportes;
    }

    public static void excluir(Esporte esporte){
        esportes.remove(esporte);
        JOptionPane.showMessageDialog(null, "Esporte removido com sucesso!");
    }

    public static void alterar(Esporte esporte) {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome", esporte.getNome());
        verificaRegistroNullo(nome);
        esporte.setNome(nome);
        JOptionPane.showMessageDialog(null,"Cadastro alterado com sucesso");
    }



    public static List<Esporte> buscarPorNome(String nome) {
        List<Esporte> esportesFiltrados = new ArrayList<>();
        for (Esporte esporte : esportes) {
            if (esporte.getNome().contains(nome)) {
                esportesFiltrados.add(esporte);
            }
        }
        return esportesFiltrados;
    }

    public static Object[] findEsportesInArray() {
        List<Esporte> produtos = buscaTodos();
        List<String> clienteNomes = new ArrayList<>();

        for (Esporte esporte : produtos) {
            clienteNomes.add(esporte.getNome());
        }

        return clienteNomes.toArray();
    }

    public static List<Esporte> getEsportes() {
        return esportes;
    }

    public static void cadastroEsporte() {
        try {
            Integer codigo = CalcularCodigo.calculaCodigo(EsporteDAO.getEsportes());
            String nomeEsporte = JOptionPane.showInputDialog(null, "Digite o nome do esporte");
            Esporte esporte = new Esporte(codigo, nomeEsporte);
            EsporteDAO.salvar(esporte);
            JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            chamaMenuPrincipal();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cadastro Invalido, favor tentar novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            chamaMenuPrincipal();
        }
    }
}
