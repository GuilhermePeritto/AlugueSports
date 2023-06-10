package Relatorio;

import Model.Esporte;
import Model.Material;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class TableEsporte extends AbstractTableModel {


    private static final long serialVersionUID = 1L;

    public static final int INDEX_CODIGO = 0;

    public static final int INDEX_NOME = 1;

    public static final int INDEX_ESCONDIDO = 2;

    protected String[] nomeColunas;
    protected Vector<Esporte> vetorDados;

    public TableEsporte(String[] nomeColunas, Vector<Esporte> vetorDados) {
        this.nomeColunas = nomeColunas;
        this.vetorDados = vetorDados;
    }


    @Override
    public boolean isCellEditable(int linha, int coluna) {
        if (coluna == INDEX_ESCONDIDO){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public String getColumnName(int column) {
        return nomeColunas[column];
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Esporte registroEsporte = (Esporte) vetorDados.get(linha);
        switch (coluna){
            case INDEX_CODIGO:
                return registroEsporte.getCodigo();
            case INDEX_NOME:
                return registroEsporte.getNomeEsporte();
            default:
                return new Object();
        }
    }

    @Override
    public int getRowCount() {
        return vetorDados.size();
    }
    public int getColumnCount(){
        return nomeColunas.length;
    }

}
