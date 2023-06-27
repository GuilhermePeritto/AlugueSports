package Model;
import javax.swing.*;
import IniciadorDeValores.*;
import static Controller.ViewController.*;

public class View {
    public static void chamaMenuPrincipal() {
        try {
            String[] opcoesMenu = {"Cadastros", "Processos", "Relatorios", "Carga Inicial", "Sair"};
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
                case 3: //CarregadorDeValoresIniciais
                    try {
                        CarregarValoresIniciais.StartPais();
                        CarregarValoresIniciais.StartEstado();
                        CarregarValoresIniciais.StartCidade();
                        CarregarValoresIniciais.StartEsporte();
                        CarregarValoresIniciais.StartEspaco();
                        CarregarValoresIniciais.StartClientes();
                        CarregarValoresIniciais.StartMaterial();
                        CarregarValoresIniciais.StartReserva();
                        JOptionPane.showMessageDialog(null, "Cadastros salvos com Sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        chamaMenuPrincipal();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Cadastro Invalido, favor tentar novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
                        chamaMenuPrincipal();
                    }
                    break;

                case 4: //Sair
                    int opcaoSair = JOptionPane.showOptionDialog(null," Deseja realmente sair ? ",
                            "Confirmação",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);

                        if (opcaoSair == JOptionPane.YES_NO_OPTION){
                            System.exit(0);
                        }else {
                            chamaMenuPrincipal();
                        }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cadastro Invalido, favor tentar novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            chamaMenuPrincipal();
        }
    }
}