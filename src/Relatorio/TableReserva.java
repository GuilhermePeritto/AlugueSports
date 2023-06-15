package Relatorio;

import Model.*;

import javax.swing.table.AbstractTableModel;
import java.time.LocalDate;
import java.util.Vector;

public class TableReserva extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    public static final int INDEX_CODIGO = 0;
    public static final int INDEX_TITULO = 1;
    public static final int INDEX_ENUMSTATUS = 2;
    public static final int INDEX_ESPACO = 3;
    public static final int INDEX_CLIENTE = 4;
    public static final int INDEX_DATASOLICITACAO = 5;
    public static final int INDEX_DATAALOCACAOINICIO = 6;
    public static final int INDEX_DATAALOCACAOFIM = 7;
    public static final int INDEX_MATERIAL = 8;
    public static final int INDEX_VALOR = 9;
    public static final int  INDEX_ESCONDIDO = 10;
    protected String[] nomeColunas;
    protected Vector<Reserva> vetorDados;

    public TableReserva(String[] columnNames, Vector<Reserva> vetorDados){
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
        Reserva registroReserva = (Reserva) vetorDados.get(linha);
        switch (coluna) {
            case INDEX_CODIGO:
                return registroReserva.getCodigo();
            case INDEX_TITULO:
                return registroReserva.getTitulo();
            case INDEX_DATASOLICITACAO:
                return registroReserva.getDataSolicitacao();
            case INDEX_DATAALOCACAOINICIO:
                return registroReserva.getDataAlocacaoInicio();
            case INDEX_DATAALOCACAOFIM:
                return registroReserva.getDataAlocacaoFim();
            case INDEX_CLIENTE:
                return registroReserva.getUsuarioCliente().getNome();
            case INDEX_ENUMSTATUS:
                return registroReserva.getEnumStatus();
            case INDEX_MATERIAL:
                return registroReserva.getMaterial().getNome();
            case INDEX_ESPACO:
                return registroReserva.getEspaco().getNome();
            case INDEX_VALOR:
                return registroReserva.getValor();
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
