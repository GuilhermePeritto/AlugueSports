package Relatorio;

import Model.Cidade;
import Model.Cliente;
import Model.Pais;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class TablePais extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    public static final int INDEX_CODIGO = 0;
    public static final int INDEX_NOME = 1;

    public static final int INDEX_ESCONDIDO = 2;

    protected String[] nomeColunas;
    protected Vector<Pais> vetorDados;

    public TablePais(String[] columnNames, Vector<Pais> vetorDados) {
        this.nomeColunas = columnNames;
        this.vetorDados = vetorDados;
    }

    @Override
    public String getColumnName(int column) {
        return nomeColunas[column];
    }

    @Override
    public boolean isCellEditable(int linha, int coluna) {
        return coluna != INDEX_ESCONDIDO;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Pais registroPais = vetorDados.get(linha);
        switch (coluna) {
            case INDEX_CODIGO:
                return registroPais.getCodigo();
            case INDEX_NOME:
                return registroPais.getNome();
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