package Repository;

import Model.EnumStatusEspaco;
import Model.Espaco;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static Model.VerificaRegistroNullo.verificaRegistroNullo;

public class EspacoDAO {
    static List<Espaco> espacos = new ArrayList<>();

    public static void salvar (Espaco espaco){
        espacos.add(espaco);
    }

    public static List<Espaco> buscaEspacos(){
        return espacos;
    }

    public static List<Espaco> buscarPorNome(String nome) {
        List<Espaco> espacosFiltrados = new ArrayList<>();
        for (Espaco espaco : espacos) {
            if (espaco.getNomeEspaco().contains(nome)) {
                espacosFiltrados.add(espaco);
            }
        }
        return espacosFiltrados;
    }

    public static Object[] findEspacoInArray() {
        List<Espaco> espacos = buscaEspacos();
        List<String> espacoNomes = new ArrayList<>();

        for (Espaco espaco : espacos) {
            espacoNomes.add(espaco.getNomeEspaco());
        }
        return espacoNomes.toArray();
    }


    public static Integer canculaCodigo(){
        return espacos.size() + 1;
    }

    public static void excluirEspaco(Espaco espaco) {
        espacos.remove(espaco);
        JOptionPane.showMessageDialog(null, "Cadastro excluido com sucesso!");
    }

    public static void alterarEspaco(Espaco espaco) {
        String nomeEspaco = JOptionPane.showInputDialog(null, "Digite o nome do espaço");
        verificaRegistroNullo(nomeEspaco);
        espaco.setNomeEspaco(nomeEspaco);

        String status = JOptionPane.showInputDialog(null, "Digite o status");
        verificaRegistroNullo(status);
        espaco.setEnumStatusEspaco(EnumStatusEspaco.valueOf(status));

//        String esporte = JOptionPane.showInputDialog(null, "Digite o esporte");
//        verificaRegistroNullo();
//        espaco.setEsporte(esporte);

        LocalDate dataInicioReserva= LocalDate.parse(JOptionPane.showInputDialog(null, "Digite a data inicial."));
        verificaRegistroNullo(dataInicioReserva);
        espaco.setDataInicioReserva(dataInicioReserva);

        LocalDate dataFimReserva= LocalDate.parse(JOptionPane.showInputDialog(null, "Digite a data final."));
        verificaRegistroNullo(dataFimReserva);
        espaco.setDataFimReserva(dataFimReserva);

        Double valor= Double.valueOf(JOptionPane.showInputDialog(null, "Digite o valor"));
        verificaRegistroNullo(valor);
        espaco.setValorEspaco(valor);
    }

}
