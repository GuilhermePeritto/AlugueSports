package Relatorio;

import Model.Material;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class TableMaterial extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    public static final int INDEX_CODIGO = 0;

    public static final int INDEX_NOME = 1;

    public static final int INDEX_ENUMSTATUSMATERIAL = 2;

    public static final int INDEX_VALOR = 3;

    public static final int INDEX_ESCONDIDO = 4;

    protected String[] nomeColunas;
    protected Vector<Material> vetorDados;

    public TableMaterial(String[] columnNames, Vector<Material> vetorDados){
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
        Material registroMaterial = (Material) vetorDados.get(linha);
        switch (coluna) {
            case INDEX_CODIGO:
                return registroMaterial.getCodigoMaterial();
            case INDEX_NOME:
                return registroMaterial.getNomeMaterial();
            case INDEX_VALOR:
                return registroMaterial.getValorMaterial();
            case INDEX_ENUMSTATUSMATERIAL:
                return registroMaterial.getEnumStatusMaterial();
            default:
                return new Object();
        }
    }

    @Override
    public int getRowCount(){
        return vetorDados.size();
    }


    @Override
    public int getColumnCount(){
        return nomeColunas.length;
    }


}
