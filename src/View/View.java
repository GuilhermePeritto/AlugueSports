package View;
import Repository.UsuarioClienteDAO;
import javax.swing.*;

public class View {
    public static void chamaMenuPrincipal() {
        String[] opcoesMenu = {"Cadastros", "Processos", "Relatorios", "Sair"};
        int opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção: ",
                "Menu Principal",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenu, opcoesMenu[0]);
        switch (opcao) {
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

    public static void chamaMenuCadastros() {
        String[] opcoesMenuCadastro = {"Usuario/Cliente", "Esporte", "******", "*******", "*****", "*******", "*********", "Voltar"};
        int menuCadastro = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Cadastros",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuCadastro, opcoesMenuCadastro[0]);

        switch (menuCadastro) {
            case 0: //Usuario
                ViewController.cadastroUsuarioCliente();
                break;
            case 1: //Esporte
                ViewController.cadastroEsporte();
                break;
            case 2: //******
                break;
            case 3: //*******
                break;
            case 4: //******
                break;
            case 5: //*******
                break;
            case 6: //******
                break;
            case 7: //Voltar
                chamaMenuPrincipal();
                break;
        }
    }
}