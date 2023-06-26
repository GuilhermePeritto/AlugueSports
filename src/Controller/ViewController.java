package Controller;
import Form.*;
import Model.*;
import Repository.*;
import javax.swing.*;
import static Controller.CidadeController.processoCidade;
import static Controller.ClienteController.processoCliente;
import static Controller.EspacoController.processoEspaco;
import static Controller.EsporteController.processoEsporte;
import static Controller.EstadoController.processoEstado;
import static Controller.MaterialController.processoMaterial;
import static Controller.PaisController.processoPais;
import static Controller.ReservaController.processoReserva;
import static Repository.CidadeDAO.cadastroCidade;
import static Repository.ClienteDAO.cadastroCliente;
import static Repository.EspacoDAO.cadastroEspaco;
import static Repository.EsporteDAO.cadastroEsporte;
import static Repository.EstadoDAO.cadastroEstado;
import static Repository.MaterialDAO.cadastroMaterial;
import static Repository.PaisDAO.cadastroPais;
import static Repository.ReservaDAO.*;

public class ViewController extends View {

    public static void listBoxCadastros() {
        try {
            Object[] selectionValues = {"Cliente", "Esporte", "Material", "Pais", "Estado", "Cidade", "Espaço", "Reserva"};
            String initialSelection = (String) selectionValues[0];
            Object selection = JOptionPane.showInputDialog(null, "Selecione o tipo de cadastro",
                    "Cadastro", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

            switch ((String) selection) {
                case "Cliente":
                    cadastroCliente();
                    break;
                case "Esporte":
                    cadastroEsporte();
                    break;
                case "Material":
                    cadastroMaterial();
                    break;
                case "Pais":
                    cadastroPais();
                    break;
                case "Estado":
                    cadastroEstado();
                    break;
                case "Cidade":
                    cadastroCidade();
                    break;
                case "Espaço":
                    cadastroEspaco();
                    break;
                case "Reserva":
                    cadastroReserva();
                    break;
                default:
                    chamaMenuPrincipal();
            }
        } catch (Exception e) {
            chamaMenuPrincipal();
        }
    }

    public static void listBoxProcessos() {
        try {
            Object[] selectionValues = {"Cliente", "Esporte", "Material", "Pais", "Estado", "Cidade", "Espaço", "Reserva"};
            String initialSelection = (String) selectionValues[0];
            Object selection = JOptionPane.showInputDialog(null, "Selecione o tipo de processo",
                    "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

            switch ((String) selection) {
                case "Cliente":
                    processoCliente();
                    chamaMenuPrincipal();
                    break;
                case "Esporte":
                    processoEsporte();
                    chamaMenuPrincipal();
                    break;
                case "Material":
                    processoMaterial();
                    chamaMenuPrincipal();
                    break;
                case "Pais":
                    processoPais();
                    chamaMenuPrincipal();
                    break;
                case "Estado":
                    processoEstado();
                    chamaMenuPrincipal();
                    break;
                case "Cidade":
                    processoCidade();
                    chamaMenuPrincipal();
                case "Espaço":
                    processoEspaco();
                    chamaMenuPrincipal();
                    break;
                case "Reserva":
                    processoReserva();
                    chamaMenuPrincipal();
                    break;
                default:
                    chamaMenuPrincipal();
            }
        } catch (Exception e) {
            chamaMenuPrincipal();
        }
    }

    public static void chamaMenuRelatorios() {
        try {
            Object[] selectionValues = {"Cliente", "Esporte", "Material", "Pais", "Estado", "Cidade", "Espaço", "Reserva"};
            String initialSelection = (String) selectionValues[0];
            Object selection = JOptionPane.showInputDialog(null, "Selecione o tipo de processo",
                    "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

            switch ((String) selection) {
                case "Cliente":
                    RelatorioClienteForm.emitirRelatorio(ClienteDAO.buscaTodos());
                    break;
                case "Esporte":
                    RelatorioEsporteForm.emitirRelatorio(EsporteDAO.buscaTodos());
                    break;
                case "Material":
                    RelatorioMaterialForm.emitirRelatorio(MaterialDAO.buscaTodos());
                    break;
                case "Pais":
                    RelatorioPaisForm.emitirRelatorio(PaisDAO.buscaTodos());
                    break;
                case "Estado":
//
                case "Cidade":
                    RelatorioCidadeForm.emitirRelatorio(CidadeDAO.buscaTodos());
                    break;
                case "Espaço":
                    RelatorioEspacoForm.emitirRelatorio(EspacoDAO.buscaTodos());
                    break;
                case "Reserva":
                    RelatorioReservaForm.emitirRelatorio(ReservaDAO.buscaTodos());
                    break;
                default:
                    chamaMenuPrincipal();
            }
        } catch (Exception e) {
            chamaMenuPrincipal();
        }
    }
}