package Model;

import java.time.LocalDate;

public class Reserva {

    private Integer codigo;
    private LocalDate dataSolicitacao;
    private LocalDate dataAlocacao;
    private UsuarioCliente usuarioCliente;
    private EnumStatusReserva enumStatusReserva;


    public Reserva(Integer codigo, LocalDate dataSolicitacao, LocalDate dataAlocacao, UsuarioCliente usuarioCliente, EnumStatusReserva enumStatusReserva) {
        this.codigo = codigo;
        this.dataSolicitacao = dataSolicitacao;
        this.dataAlocacao = dataAlocacao;
        this.usuarioCliente = usuarioCliente;
        this.enumStatusReserva = enumStatusReserva;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public LocalDate getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public LocalDate getDataAlocacao() {
        return dataAlocacao;
    }

    public void setDataAlocacao(LocalDate dataAlocacao) {
        this.dataAlocacao = dataAlocacao;
    }

    public UsuarioCliente getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(UsuarioCliente usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    public EnumStatusReserva getEnumStatusReserva() {
        return enumStatusReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "codigo=" + codigo +
                ", dataSolicitacao=" + dataSolicitacao +
                ", dataAlocacao=" + dataAlocacao +
                ", usuarioCliente=" + usuarioCliente +
                ", enumStatusReserva=" + enumStatusReserva +
                '}';
    }
}
