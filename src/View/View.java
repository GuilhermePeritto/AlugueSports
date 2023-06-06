package View;

import Repository.ClienteDAO;

import javax.swing.*;

import IniciadorDeValores.*;

import static View.ViewController.*;

import static View.ViewController.*;

public class View {
    public static void chamaMenuPrincipal() {
        try {
            String[] opcoesMenu = {"Cadastros", "Processos", "Relatorios", "Carga Inicial"};
            int opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção: ",
                    "Menu Principal",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenu, opcoesMenu[0]);
            switch (opcao) {
                case 0: //Cadastros
                    listBoxCadastros();
                    break;
                case 1: //Processos
                    listBoxProcessos();
                    break;
                case 2: //Relatorios
                    chamaMenuRelatorios();
                    break;
                case 3: //SAIR
                    try {
                        CarregarValoresIniciais.StartReserva();
                        CarregarValoresIniciais.StartClientes();
                        CarregarValoresIniciais.StartMaterial();
                        CarregarValoresIniciais.StartEspaco();
                        CarregarValoresIniciais.StartPais();
                        CarregarValoresIniciais.StartEsporte();
                        CarregarValoresIniciais.StartEstado();
                        JOptionPane.showMessageDialog(null, "Cadastros salvos com Sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        chamaMenuPrincipal();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Cadastro Invalido, favor tentar novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
                        chamaMenuPrincipal();
                    }
                    break;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cadastro Invalido, favor tentar novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            chamaMenuPrincipal();
        }
    }
}