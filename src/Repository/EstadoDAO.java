package Repository;

import Model.Estado;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static Model.VerificaRegistroNullo.verificaRegistroNullo;

public class EstadoDAO {
    public static List<Estado> buscaEstados;
    static List<Estado> estados = new ArrayList<>();
    public static void salvar (Estado estado){
        estados.add(estado);
    }
    public static List<Estado> buscaTodos() {
        return estados;
    }

    public static Object[] findEstadoInArray() {
        List<Estado> estados = buscaTodos();
        List<String> estadosnomes = new ArrayList<>();

        for (Estado estado : estados) {
            estadosnomes.add(estado.getNome());
        }

        return estadosnomes.toArray();
    }

    public static List<Estado> buscarPorNome(String nome) {
        List<Estado> estadosFiltrados = new ArrayList<>();
        for (Estado estado : estados) {
            if (estado.getNome().contains(nome)) {
                estadosFiltrados.add(estado);
            }
        }
        return estadosFiltrados;
    }

    public static void alterar(Estado estado) {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do estado");
        verificaRegistroNullo(nome);
        estado.setNome(nome);
    }

    public static void excluir(Estado estado) {
        estados.remove(estado);
        JOptionPane.showMessageDialog(null, "Estado excluido com sucesso!");
    }

    public static Integer calculaCodigo(){
        return estados.size() + 1;
    }
}
