package Repository;

import Model.*;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import static Model.VerificaRegistroNullo.verificaRegistroNullo;

public class EspacoDAO {
    static List<Espaco> espacos = new ArrayList<>();

    public static void salvar (Espaco espaco){
        espacos.add(espaco);
    }

    public static List<Espaco> buscaTodos(){
        return espacos;
    }

    public static List<Espaco> buscarPorNome(String nome) {
        List<Espaco> espacosFiltrados = new ArrayList<>();
        for (Espaco espaco : espacos) {
            if (espaco.getNome().contains(nome)) {
                espacosFiltrados.add(espaco);
            }
        }
        return espacosFiltrados;
    }

    public static Object[] findEspacoInArray() {
        List<Espaco> espacos = buscaTodos();
        List<String> espacoNomes = new ArrayList<>();

        for (Espaco espaco : espacos) {
            espacoNomes.add(espaco.getNome());
        }
        return espacoNomes.toArray();
    }


    public static Integer calculaCodigo(){
        return espacos.size() + 1;
    }

    public static void excluir(Espaco espaco) {
        espacos.remove(espaco);
        JOptionPane.showMessageDialog(null, "Cadastro excluido com sucesso!");
    }

    public static void alterar(Espaco espaco) {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do espaço");
        verificaRegistroNullo(nome);
        espaco.setNome(nome);

        LocalDate dataInicioReserva = LocalDate.now();
        String inputDataInicioReserva = JOptionPane.showInputDialog(null, "Informe a data de início desejada");
        try {
            dataInicioReserva = LocalDate.parse(inputDataInicioReserva, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data invalida, tente no formato dd/MM/yyyy");
        }
        verificaRegistroNullo(dataInicioReserva);
        espaco.setDataInicioReserva(dataInicioReserva);

        LocalDate dataFimReserva = LocalDate.now();
        String inputDataFimReserva = JOptionPane.showInputDialog(null, "Informe a data de início desejada");
        try {
            dataFimReserva = LocalDate.parse(inputDataFimReserva, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data invalida, tente no formato dd/MM/yyyy");
        }
        verificaRegistroNullo(dataFimReserva);
        espaco.setDataFimReserva(dataFimReserva);

        Object[] selectionStatusEspaco = {"ALUGADO", "DISPONIVEL"};
        String initialSelectionStatusEspaco = (String) selectionStatusEspaco[0];
        Object selectionStatus = JOptionPane.showInputDialog(null, "Selecione o status do espaço!",
                "Lista de Status", JOptionPane.QUESTION_MESSAGE, null, selectionStatusEspaco, initialSelectionStatusEspaco);
        EnumStatusEspaco status = EnumStatusEspaco.ALUGADO;
        if (selectionStatus.equals("ALUGADO")) {
            status = EnumStatusEspaco.ALUGADO;
        } else if (selectionStatus.equals("DISPONIVEL")) {
            status = EnumStatusEspaco.DISPONIVEL;
        }
        verificaRegistroNullo(status);
        espaco.setEnumStatus(status);

        Object[] selectionValuesEsporte = EsporteDAO.findEsportesInArray();
        String initialSelectionEsporte = (String) selectionValuesEsporte[0];
        Object selectionEsporte = JOptionPane.showInputDialog(null, "Selecione o Esporte",
                "Alterar Material", JOptionPane.QUESTION_MESSAGE, null, selectionValuesEsporte, initialSelectionEsporte);
        List<Esporte> esporte = EsporteDAO.buscarPorNome((String) selectionEsporte);
        verificaRegistroNullo(selectionEsporte);
        espaco.setEsporte(esporte.get(0));

        Double valor= Double.valueOf(JOptionPane.showInputDialog(null, "Digite o valor"));
        verificaRegistroNullo(valor);
        espaco.setValor(valor);
    }

    public static List<Espaco> getEspacos() {
        return espacos;
    }
}
