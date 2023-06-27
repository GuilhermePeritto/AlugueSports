package Repository;
import Model.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import static Model.VerificaRegistroNullo.verificaRegistroNullo;
import static Model.View.chamaMenuPrincipal;

public class CidadeDAO {
    static List<Cidade> cidades = new ArrayList<>();
    public static void salvar(Cidade cidade) {
        cidades.add(cidade);
    }
    public static List<Cidade> buscaTodos() {
        return cidades;
    }

    public static void excluir(Cidade cidade) {
        cidades.remove(cidade);
        JOptionPane.showMessageDialog(null, "Cidade excluida com sucesso!");
    }

    public static void alterar(Cidade cidade) {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome", cidade.getNome());
        verificaRegistroNullo(nome);
        Object[] selectionValuesEstado = EstadoDAO.findEstadoInArray();
        String initialSelectionEstado = cidade.getEstado().getNome();
        Object selectionEstado = JOptionPane.showInputDialog(null, "Selecione o estado",
                "Lista de Estados", JOptionPane.QUESTION_MESSAGE, null, selectionValuesEstado, initialSelectionEstado);
        List<Estado> estado = EstadoDAO.buscarPorNome(selectionEstado.toString());
        cidade.setNome(nome);
        cidade.setEstado(estado.get(0));

    }


    public static List<Cidade> buscarPorNome(String nomeCidade) {
        List<Cidade> cidadesFiltradas = new ArrayList<>();
        for (Cidade cidade : cidades) {
            if (cidade.getNome().contains(nomeCidade)) {
                cidadesFiltradas.add(cidade);
            }
        }
        return cidadesFiltradas;
    }

    public static Object[] findCidadeInArray() {
        List<Cidade> cidades = buscaTodos();
        List<String> cidadeNomes = new ArrayList<>();

        for (Cidade cidade : cidades) {
            cidadeNomes.add(cidade.getNome());
        }

        return cidadeNomes.toArray();
    }

    public static List<Cidade> getCidades() {
        return cidades;
    }
    public static void cadastroCidade() {
        try {

            if (EstadoDAO.getEstados().size() == 0) {
                JOptionPane.showMessageDialog(null, "Nenhum estado cadastrado!" + "\n" + "Por favor cadastre um estado.", "Atenção", JOptionPane.WARNING_MESSAGE);
                chamaMenuPrincipal();
            }

            Integer codigoCidade = CalcularCodigo.calculaCodigo(CidadeDAO.getCidades());
            String nomeCidade = JOptionPane.showInputDialog(null, "Digite o nome da cidade");
            verificaRegistroNullo(nomeCidade);
            Object[] selectionValuesEstado = EstadoDAO.findEstadoInArray();
            String initialSelectionEstado = (String) selectionValuesEstado[0];
            Object selectionEstado = JOptionPane.showInputDialog(null, "Selecione o estado",
                    "Lista de Estados", JOptionPane.QUESTION_MESSAGE, null, selectionValuesEstado, initialSelectionEstado);
            List<Estado> estados = EstadoDAO.buscarPorNome(selectionEstado.toString());
            verificaRegistroNullo(selectionEstado);
            Cidade cidade = new Cidade(codigoCidade, nomeCidade, estados.get(0));
            CidadeDAO.salvar(cidade);
            JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            chamaMenuPrincipal();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cadastro Invalido, favor tentar novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            chamaMenuPrincipal();
        }
    }
}
