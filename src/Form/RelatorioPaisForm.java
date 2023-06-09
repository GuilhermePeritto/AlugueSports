package Form;

import Model.Pais;
import Relatorio.TablePais;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Vector;

import static Controller.ViewController.chamaMenuRelatorios;

public class RelatorioPaisForm extends JPanel {

    private static final long serialVersionUID = 1L;

    public static final String[] nomeColunas =
            {"Codigo", "Nome", ""};

    protected JTable table;
    protected JScrollPane scroller;
    protected TablePais tabela;

    public RelatorioPaisForm(Vector<Pais> vetorDados) {
        iniciarComponentes(vetorDados);
    }

    public void iniciarComponentes(Vector<Pais> vetorDados) {
        tabela = new TablePais(nomeColunas, vetorDados);
        table = new JTable();
        table.setModel(tabela);
        table.setSurrendersFocusOnKeystroke(true);
        scroller = new javax.swing.JScrollPane(table);
        table.setPreferredScrollableViewportSize(new java.awt.Dimension(500, 300));

        TableColumn colunaEscondida = table.getColumnModel().getColumn(TablePais.INDEX_ESCONDIDO);
        colunaEscondida.setMinWidth(2);
        colunaEscondida.setPreferredWidth(2);
        colunaEscondida.setMaxWidth(2);
        setLayout(new BorderLayout());
        add(scroller, BorderLayout.CENTER);
    }

    public static void emitirRelatorio(List<Pais> pais) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            JFrame frame = new JFrame("Relatorio");

            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent evt) {
                    frame.setVisible(false);
                    chamaMenuRelatorios();
                }
            });
            Vector<Pais> vetorDados = new Vector<Pais>();
            for (Pais pais1 : pais) {
                vetorDados.add(pais1);
            }

            frame.getContentPane().add(new RelatorioPaisForm(vetorDados));
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}