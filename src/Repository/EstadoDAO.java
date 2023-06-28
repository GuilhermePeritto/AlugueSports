package Repository;
import Model.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import static Model.View.chamaMenuPrincipal;

public class EstadoDAO extends VerificaRegistroNullo {
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

    public static void alterar(Estado estado) throws ClassNotFoundException {
        String nomeEstado = JOptionPane.showInputDialog(null, "Digite o nome do estado", estado.getNome());
        verificaRegistroNullo(nomeEstado);
        String sigla = JOptionPane.showInputDialog(null, "Digite a sigla do estado", estado.getSigla());
        verificaRegistroNullo(sigla);
        Object[] selectionValuesPais = PaisDAO.findPaisInArray();
        String initialSelectionPais = (String) estado.getPais().getNome();
        Object selectionPais = JOptionPane.showInputDialog(null, "Selecione o país",
                "Lista de Países", JOptionPane.QUESTION_MESSAGE, null, selectionValuesPais, initialSelectionPais);
        List<Pais> pais = PaisDAO.buscarPorNome((String) selectionPais);
        verificaRegistroNullo(selectionPais);
        estado.setNome(nomeEstado);
        estado.setSigla(sigla);
        estado.setPais(pais.get(0));
        JOptionPane.showMessageDialog(null, "Estado alterado com sucesso!");
    }

    public static void excluir(Estado estado) {
        estados.remove(estado);
        JOptionPane.showMessageDialog(null, "Estado excluido com sucesso!");
    }

    public static List<Estado> getEstados() {
        return estados;
    }

    public static void cadastroEstado() {
        try {

            if (PaisDAO.getPaises().size() == 0){
                JOptionPane.showMessageDialog(null, "Nenhum país cadastrado!"+"\n"+ "Por favor cadastre um país.", "Atenção", JOptionPane.WARNING_MESSAGE);
                chamaMenuPrincipal();
            }

            Integer codigoEstado = CalcularCodigo.calculaCodigo(EstadoDAO.getEstados());
            String nomeEstado = JOptionPane.showInputDialog(null, "Digite o nome do estado");
            verificaRegistroNullo(nomeEstado);
            String sigla = JOptionPane.showInputDialog(null, "Digite a sigla do estado");
            verificaRegistroNullo(sigla);
            Object[] selectionValuesPais = PaisDAO.findPaisInArray();
            String initialSelectionPais = (String) selectionValuesPais[0];
            Object selectionPais = JOptionPane.showInputDialog(null, "Selecione o país",
                    "Lista de Países", JOptionPane.QUESTION_MESSAGE, null, selectionValuesPais, initialSelectionPais);
            List<Pais> pais = PaisDAO.buscarPorNome((String) selectionPais);
            verificaRegistroNullo(selectionPais);
            Estado estado = new Estado(codigoEstado, nomeEstado, sigla, pais.get(0));
            EstadoDAO.salvar(estado);
            JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            chamaMenuPrincipal();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cadastro Invalido, favor tentar novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            chamaMenuPrincipal();
        }
    }
}
