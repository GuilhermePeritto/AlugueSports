package Relatorio;

import Model.Cidade;
import Model.Espaco;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class TableEspaco extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    public static final int INDEX_CODIGO = 0;
    public static final int INDEX_NOME = 1;
    public static final int INDEX_ESTADO = 2;
    public static final int INDEX_ESCONDIDO = 3;

    protected String[] nomeColunas;
    protected Vector<Espaco> vetorDados;

    public TableEspaco(String[] columnNames, Vector<Espaco> vetorDados) {
        this.nomeColunas = columnNames;
        this.vetorDados = vetorDados;
    }

    @Override
    public String getColumnName(int column) {
        return nomeColunas[column];
    }

    @Override
    public boolean isCellEditable(int linha, int coluna) {
        if (coluna == INDEX_ESCONDIDO) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Espaco registroCidade = (Espaco) vetorDados.get(linha);
        switch (coluna) {
            case INDEX_CODIGO:
                return registroCidade.getCodigo();
            case INDEX_NOME:
                return registroCidade.getNome();
            case INDEX_ESTADO:
                return registroCidade.getEsporte();
            default:
                return new Object();
        }
    }

    @Override
    public int getRowCount() {
        return vetorDados.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }
}