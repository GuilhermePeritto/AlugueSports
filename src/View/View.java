package View;
import Repository.UsuarioClienteDAO;
import javax.swing.*;
import static View.ViewController.listBoxCadastros;
import IniciadorDeValores.*;

public class View {
    public static void chamaMenuPrincipal() {
        String[] opcoesMenu = {"Cadastros", "Processos", "Relatorios", "Carga Inicial"};
        int opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção: ",
                "Menu Principal",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenu, opcoesMenu[0]);
        switch (opcao) {
            case 0: //Cadastros
                listBoxCadastros();
                break;
            case 1: //Processos

                break;
            case 2: //Relatorios
                JOptionPane.showMessageDialog(null, UsuarioClienteDAO.buscaTodos());
                chamaMenuPrincipal();
                break;
            case 3: //SAIR
                CarregarValoresIniciais.StartReserva();
                CarregarValoresIniciais.StartClientes();
                CarregarValoresIniciais.StartMaterial();
                CarregarValoresIniciais.StartEspaco();
                CarregarValoresIniciais.StartPais();
                CarregarValoresIniciais.StartEsporte();
                CarregarValoresIniciais.StartEstado();
                JOptionPane.showMessageDialog(null, "Cadastros salvos com Sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                chamaMenuPrincipal();
                break;
        }
    }
}