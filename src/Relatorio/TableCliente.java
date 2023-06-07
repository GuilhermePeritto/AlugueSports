package Relatorio;

import Model.Cidade;
import Model.Cliente;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class TableCliente extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    public static final int INDEX_CODIGO = 0;
    public static final int INDEX_NOME = 1;
    public static final int INDEX_CPF = 2;
    public static final int INDEX_RG = 3;
    public static final int INDEX_TELEFONE = 4;
    public static final int INDEX_ESCONDIDO = 5;

    protected String[] nomeColunas;
    protected Vector<Cliente> vetorDados;

    public TableCliente(String[] columnNames, Vector<Cliente> vetorDados) {
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
        Cliente registroPessoa = (Cliente) vetorDados.get(linha);
        switch (coluna) {
            case INDEX_CODIGO:
                return registroPessoa.getCodigo();
            case INDEX_NOME:
                return registroPessoa.getNome();
            case INDEX_CPF:
                return registroPessoa.getCpf();
            case INDEX_RG:
                return registroPessoa.getRg();
            case INDEX_TELEFONE:
                return registroPessoa.getTelefone();
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