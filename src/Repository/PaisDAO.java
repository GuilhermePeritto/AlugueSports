package Repository;
import Model.CalcularCodigo;
import Model.Pais;
import Model.VerificaRegistroNullo;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import static Model.View.chamaMenuPrincipal;

public class PaisDAO extends VerificaRegistroNullo {
    static List<Pais> paises = new ArrayList<>();

    public static void salvar(Pais pais) {
        paises.add(pais);
    }

    public static List<Pais> buscaTodos() {
        return paises;
    }

    public static void excluirCadastropais(Pais pais) {
        paises.remove(pais);
        JOptionPane.showMessageDialog(null, "Pais excluido com sucesso!");
    }

    public static List<Pais> buscarPorNome(String nome) {
        List<Pais> paisesFiltrados = new ArrayList<>();
        for (Pais pais : paises) {
            if (pais.getNome().contains(nome)) {
                paisesFiltrados.add(pais);
            }
        }
        return paisesFiltrados;
    }

    public static void alterardadospais(Pais pais) {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome", pais.getNome());
        verificaRegistroNullo(nome);
        pais.setNome(nome);
    }

    public static Object[] findPaisInArray() {
        List<Pais> paises = buscaTodos();
        List<String> paisNomes = new ArrayList<>();

        for (Pais pais : paises) {
            paisNomes.add(pais.getNome());
        }

        return paisNomes.toArray();
    }

    public static List<Pais> getPaises() {
        return paises;
    }

    public static void cadastroPais() {
        try {
            Integer codigoPais = CalcularCodigo.calculaCodigo(PaisDAO.getPaises());
            String nomePais = JOptionPane.showInputDialog(null, "Digite o nome do país");
            verificaRegistroNullo(nomePais);
            Pais pais = new Pais(codigoPais, nomePais);
            PaisDAO.salvar(pais);
            JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            chamaMenuPrincipal();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cadastro Invalido, favor tentar novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            chamaMenuPrincipal();
        }
    }
}
