package Repository;
import Model.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import static Model.View.chamaMenuPrincipal;

public class EspacoDAO extends VerificaRegistroNullo{
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
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do espaço", espaco.getNome());
        verificaRegistroNullo(nome);
        Object[] selectionStatusEspaco = {"ALUGADO", "DISPONIVEL"};
        String initialSelectionStatusEspaco = espaco.getEnumStatus().toString();
        Object selectionStatus = JOptionPane.showInputDialog(null, "Selecione o status do espaço!",
                "Lista de Status", JOptionPane.QUESTION_MESSAGE, null, selectionStatusEspaco, initialSelectionStatusEspaco);
        EnumStatusEspaco status = EnumStatusEspaco.ALUGADO;
        if (selectionStatus.equals("ALUGADO")) {
            status = EnumStatusEspaco.ALUGADO;
        } else if (selectionStatus.equals("DISPONIVEL")) {
            status = EnumStatusEspaco.DISPONIVEL;
        }
        verificaRegistroNullo(status);
        Object[] selectionValuesEsporte = EsporteDAO.findEsportesInArray();
        String initialSelectionEsporte = espaco.getEsporte().getNome();
        Object selectionEsporte = JOptionPane.showInputDialog(null, "Selecione o Esporte",
                "Alterar Material", JOptionPane.QUESTION_MESSAGE, null, selectionValuesEsporte, initialSelectionEsporte);
        List<Esporte> esporte = EsporteDAO.buscarPorNome((String) selectionEsporte);
        verificaRegistroNullo(selectionEsporte);
        Double valor= Double.valueOf(JOptionPane.showInputDialog(null, "Digite o valor", espaco.getValor()));
        verificaRegistroNullo(valor);
        espaco.setNome(nome);
        espaco.setEnumStatus(status);
        espaco.setEsporte(esporte.get(0));
        espaco.setValor(valor);
    }

    public static List<Espaco> getEspacos() {
        return espacos;
    }

    public static void cadastroEspaco() {
        try {

            if (EsporteDAO.getEsportes().size() == 0){
                JOptionPane.showMessageDialog(null, "Nenhum esporte cadastrado!"+"\n"+ "Por favor cadastre um esporte.", "Atenção", JOptionPane.WARNING_MESSAGE);
                chamaMenuPrincipal();
            }

            Integer codigo = CalcularCodigo.calculaCodigo(EspacoDAO.getEspacos());
            String nomeEspaco = JOptionPane.showInputDialog(null, "Digite o nome do espaço");
            verificaRegistroNullo(nomeEspaco);
            Object[] selectionValuesEsporte = EsporteDAO.findEsportesInArray();
            String initialSelectionEsporte = (String) selectionValuesEsporte[0];
            Object selectionEsporte = JOptionPane.showInputDialog(null, "Selecione tipo de esporte",
                    "VendasApp", JOptionPane.QUESTION_MESSAGE, null, selectionValuesEsporte, initialSelectionEsporte);
            List<Esporte> esporte = EsporteDAO.buscarPorNome((String) selectionEsporte);
            verificaRegistroNullo(selectionEsporte);
            EnumStatusEspaco statusEspaco = EnumStatusEspaco.DISPONIVEL;
            Double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor do espaco"));
            verificaRegistroNullo(valor);
            Espaco espaco = new Espaco(codigo, nomeEspaco, esporte.get(0), statusEspaco, valor);
            EspacoDAO.salvar(espaco);
            JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            chamaMenuPrincipal();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cadastro Invalido, favor tentar novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            chamaMenuPrincipal();
        }
    }
}
