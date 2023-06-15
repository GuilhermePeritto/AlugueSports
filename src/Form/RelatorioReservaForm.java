package Form;

import Model.*;
import Relatorio.TableReserva;
import Relatorio.TableReserva;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.List;
import java.util.Vector;

import static View.ViewController.chamaMenuRelatorios;

public class RelatorioReservaForm extends JPanel {

    private static final long serialVersionUID = 1L;

    public static final String[] nomeColunas =
            {"Código", "Titulo", "Status", "Espaço", "Cliente", "Data Solicitação", "Data Alocação Inicio", "Data Alocação Fim", "Material", "Valor", ""};

    protected JTable table;
    protected JScrollPane scroller;
    protected TableReserva tabela;

    public RelatorioReservaForm(Vector<Reserva> vetorDados) {
        iniciarVetorComponentes(vetorDados);
    }

    public void iniciarVetorComponentes(Vector<Reserva> vetorDados){
        tabela = new TableReserva(nomeColunas, vetorDados);
        table = new JTable();
        table.setModel(tabela);
        table.setSurrendersFocusOnKeystroke(true);
        scroller = new javax.swing.JScrollPane(table);
        table.setPreferredScrollableViewportSize(new java.awt.Dimension(500, 300));

        TableColumn colunaEscondida = table.getColumnModel().getColumn(TableReserva.INDEX_ESCONDIDO);
        colunaEscondida.setMinWidth(2);
        colunaEscondida.setPreferredWidth(2);
        colunaEscondida.setMaxWidth(2);
        setLayout(new BorderLayout());
        add(scroller, BorderLayout.CENTER);
    }

    public static void emitirRelatorio(List<Reserva> reservas){
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            JFrame frame = new JFrame("Relatorio - Reserva");

            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent evt) {
                    frame.setVisible(false);
                    chamaMenuRelatorios();
                }
            });
            Vector<Reserva> vetorDados = new Vector<Reserva>();
            for (Reserva reserva1 : reservas) {
                vetorDados.add(reserva1);
            }

            frame.getContentPane().add(new RelatorioReservaForm(vetorDados));
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




