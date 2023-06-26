package Controller;
import Model.*;
import Repository.ReservaDAO;
import javax.swing.*;
import java.util.List;
import static Model.VerificaRegistroNullo.verificaRegistroNullo;
public class ReservaController {

    public static void processoReserva() {
        Object[] selectionValues = ReservaDAO.findReservaInArray();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a reserva!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Reserva> reserva = ReservaDAO.buscarPorNome((String) selection);
        verificaRegistroNullo(selection);
        Object[] selectionValuesReserva = {"Alterar Dados", "Excluir Cadastro"};
        String initialSelectionReserva = (String) selectionValues[0];
        Object selectionReserva = JOptionPane.showInputDialog(null, "Selecione o processo!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValuesReserva, initialSelectionReserva);
        verificaRegistroNullo(selectionReserva);
        switch ((String) selectionReserva) {
            case "Alterar Dados":
                ReservaDAO.alterarDadosReserva(reserva.get(0));
                break;
            case "Excluir Cadastro":
                ReservaDAO.excluir(reserva.get(0));
        }
    }
}
