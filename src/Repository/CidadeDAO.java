package Repository;

import Model.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static Model.VerificaRegistroNullo.verificaRegistroNullo;

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
        String nome = JOptionPane.showInputDialog(null, "Digite o nome");
        verificaRegistroNullo(nome);
        Object[] selectionValuesEstado = EstadoDAO.findEstadoInArray();
        String initialSelectionEstado = (String) selectionValuesEstado[0];
        Object selectionEstado = JOptionPane.showInputDialog(null, "Selecione o estado",
                "Lista de Estados", JOptionPane.QUESTION_MESSAGE, null, selectionValuesEstado, initialSelectionEstado);
        List<Estado> estado = EstadoDAO.buscarPorNome(selectionEstado.toString());
        cidade.setNome(nome);
        cidade.setEstado(estado.get(0));

    }

    public static Integer calculaCodigo(){
        return cidades.size() + 1;
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
}
