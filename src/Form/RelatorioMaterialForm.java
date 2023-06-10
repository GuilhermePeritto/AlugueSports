package Form;

import Model.Material;
import Relatorio.TableCliente;
import Relatorio.TableMaterial;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.event.WindowAdapter;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Vector;

import static View.ViewController.chamaMenuRelatorios;

public class RelatorioMaterialForm extends JPanel {

    private static final long serialVersionUID = 1L;

    public static final String[] nomeColunas =
            {"Código", "Nome", "Status-Material", "Valor", ""};

    protected JTable table;
    protected JScrollPane scroller;
    protected TableMaterial tabela;

    public RelatorioMaterialForm(Vector<Material> vetorDados) {
        iniciarVetorComponentes(vetorDados);
    }

    public void iniciarVetorComponentes(Vector<Material> vetorDados){
        tabela = new TableMaterial(nomeColunas, vetorDados);
        table = new JTable();
        table.setModel(tabela);
        table.setSurrendersFocusOnKeystroke(true);
        scroller = new javax.swing.JScrollPane(table);
        table.setPreferredScrollableViewportSize(new java.awt.Dimension(500, 300));

        TableColumn colunaEscondida = table.getColumnModel().getColumn(TableMaterial.INDEX_ESCONDIDO);
        colunaEscondida.setMinWidth(2);
        colunaEscondida.setPreferredWidth(2);
        colunaEscondida.setMaxWidth(2);
        setLayout(new BorderLayout());
        add(scroller, BorderLayout.CENTER);
    }

    public static void emitirRelatorio(List<Material> material){
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            JFrame frame = new JFrame("Relatorio - Material");

            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent evt) {
                    frame.setVisible(false);
                    chamaMenuRelatorios();
                }
            });
            Vector<Material> vetorDados = new Vector<Material>();
            for (Material material1 : material) {
                vetorDados.add(material1);
            }

            frame.getContentPane().add(new RelatorioMaterialForm(vetorDados));
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }




