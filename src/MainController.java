import Model.Esporte;
import Model.UsuarioCliente;
import Repository.EsporteDAO;
import Repository.UsuarioClienteDAO;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainController {
    public static void chamaMenuPrincipal() {
        String[] opcoesMenu = {"Cadastros", "Processos", "Relatorios", "Sair"};
        int opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção: ",
                "Menu Principal",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenu, opcoesMenu[0]);
        switch (opcao){
            case 0: //Cadastros
                chamaMenuCadastros();
                break;
            case 1: //Processos

                break;
            case 2: //Relatorios
                JOptionPane.showMessageDialog(null, UsuarioClienteDAO.buscaTodos());
                chamaMenuPrincipal();
                break;
            case 3: //SAIR

                break;
        }
    }

    private static void chamaMenuCadastros() {
        String[] opcoesMenuCadastro = {"Usuario/Cliente", "Esporte", "******", "Voltar"};
        int menuCadastro = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Cadastros",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuCadastro, opcoesMenuCadastro[0]);

        switch (menuCadastro) {
            case 0: //Pessoa
                cadastroDePessoas();
                break;
            case 1: //Esporte
                cadastroDeEsporte();
                break;
            case 2: //******
                break;
            case 3: //Voltar
                chamaMenuPrincipal();
                break;
        }
    }

    private static void cadastroDePessoas() {
        Integer codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o codigo"));
        String nome = JOptionPane.showInputDialog(null, "Digite o nome");
        String telefone = JOptionPane.showInputDialog(null, "Digite o telefone");
        String cpf = JOptionPane.showInputDialog(null, "Digite o cpf");
        String rg = JOptionPane.showInputDialog(null, "Digite o rg");
        JCheckBox jCheckBox = new JCheckBox("Cliente");
        int result = JOptionPane.showOptionDialog(null, jCheckBox, "Informe se o cadastro é cliente?",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
        Boolean cliente = jCheckBox.isSelected();
        UsuarioCliente pessoa = new UsuarioCliente(codigo,nome, telefone, cpf, rg, cliente);
        UsuarioClienteDAO.salvar(pessoa);
        chamaMenuPrincipal();
    }

    private static void cadastroDeEsporte() {
        Integer codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o codigo do esporte"));
        String nomeEsporte = JOptionPane.showInputDialog(null, "Digite o nome do esporte");
        Esporte esporte = new Esporte(codigo, nomeEsporte);
        EsporteDAO.salvar(esporte);
        chamaMenuPrincipal();
    }
}