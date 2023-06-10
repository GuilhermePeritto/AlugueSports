package Repository;

import Model.Cliente;
import Model.Estado;
import Model.Pais;

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
            estadosnomes.add(estado.getNomeEstado());
        }

        return estadosnomes.toArray();
    }

    public static List<Estado> buscarPorNome(String nome) {
        List<Estado> estadosFiltrados = new ArrayList<>();
        for (Estado estado : estados) {
            if (estado.getNomeEstado().contains(nome)) {
                estadosFiltrados.add(estado);
            }
        }
        return estadosFiltrados;
    }

    public static void alterardadosestado(Estado estado) {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do estado");
        verificaRegistroNullo(nome);
        estado.setNomeEstado(nome);
    }

    public static void excluirCadastroEstado(Estado estado) {
        estados.remove(estado);
        JOptionPane.showMessageDialog(null, "Estado excluido com sucesso!");
    }


    public static List<Estado> buscaEspacos(){
    public static List<Estado> buscaTodos(){
        return estados;
    }
    public static Integer canculaCodigo(){
        return estados.size() + 1;
    }
      
    public static Object[] findEstadoInArray() {
        List<Estado> estados = buscaTodos();
        List<String> estadoNomes = new ArrayList<>();

        for (Estado estado : estados) {
            estadoNomes.add(estado.getNomeEstado());
        }

        return estadoNomes.toArray();
    }

    public static List<Estado> buscarPorNome(String nome) {
        List<Estado> estadosFiltrados = new ArrayList<>();
        for (Estado estado : estados) {
            if (estado.getNomeEstado().contains(nome)) {
                estadosFiltrados.add(estado);
            }
        }
        return estadosFiltrados;
    }
}
