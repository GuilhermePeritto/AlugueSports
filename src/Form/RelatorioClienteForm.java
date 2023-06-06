package Form;

import Model.Cliente;
import Relatorio.TableCliente;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Vector;

import static View.ViewController.chamaMenuRelatorios;

public class RelatorioClienteForm extends JPanel {

    private static final long serialVersionUID = 1L;

    public static final String[] nomeColunas =
            {"Codigo", "Nome", "CPF", "RG", "Telefone", ""};

    protected JTable table;
    protected JScrollPane scroller;
    protected TableCliente tabela;

    public RelatorioClienteForm(Vector<Cliente> vetorDados) {
        iniciarComponentes(vetorDados);
    }

    public void iniciarComponentes(Vector<Cliente> vetorDados) {
        tabela = new TableCliente(nomeColunas, vetorDados);
        table = new JTable();
        table.setModel(tabela);
        table.setSurrendersFocusOnKeystroke(true);
        scroller = new javax.swing.JScrollPane(table);
        table.setPreferredScrollableViewportSize(new java.awt.Dimension(500, 300));

        TableColumn colunaEscondida = table.getColumnModel().getColumn(TableCliente.INDEX_ESCONDIDO);
        colunaEscondida.setMinWidth(2);
        colunaEscondida.setPreferredWidth(2);
        colunaEscondida.setMaxWidth(2);
        setLayout(new BorderLayout());
        add(scroller, BorderLayout.CENTER);
    }

    public static void emitirRelatorio(List<Cliente> clientes) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            JFrame frame = new JFrame("Relatorio");

            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent evt) {
                    frame.setVisible(false);
                    chamaMenuRelatorios();
                }
            });
            Vector<Cliente> vetorDados = new Vector<Cliente>();
            for (Cliente cliente : clientes) {
                vetorDados.add(cliente);
            }

            frame.getContentPane().add(new RelatorioClienteForm(vetorDados));
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}