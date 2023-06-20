package Relatorio;

import Model.Cidade;
import Model.EnumStatusEspaco;
import Model.Espaco;
import Model.Esporte;

import javax.swing.table.AbstractTableModel;
import java.time.LocalDate;
import java.util.Vector;

public class TableEspaco extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    public static final int INDEX_CODIGO = 0;
    public static final int INDEX_NOME = 1;
    public static final int INDEX_ESPORTE = 2;
    public static final int INDEX_ESTATUS = 3;
    public static final int INDEX_VALOR = 4;
    public static final int INDEX_ESCONDIDO = 5;

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
        Espaco registroEspaco = (Espaco) vetorDados.get(linha);
        switch (coluna) {
            case INDEX_CODIGO:
                return registroEspaco.getCodigo();
            case INDEX_NOME:
                return registroEspaco.getNome();
            case INDEX_ESPORTE:
                return registroEspaco.getEsporte().getNome();
            case INDEX_ESTATUS:
                return registroEspaco.getEnumStatus();
            case INDEX_VALOR:
                return registroEspaco.getValor();
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