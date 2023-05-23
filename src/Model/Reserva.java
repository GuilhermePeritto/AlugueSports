package Model;

import java.time.LocalDate;

public class Reserva {

    private Integer codigoReserva;
    private String tituloReserva;
    private LocalDate dataSolicitacao;
    private LocalDate dataAlocacao;
    private UsuarioCliente usuarioCliente;
    private EnumStatusReserva enumStatusReserva;


    public Reserva(Integer codigoReserva, String tituloReserva, LocalDate dataSolicitacao, LocalDate dataAlocacao, UsuarioCliente usuarioCliente, EnumStatusReserva enumStatusReserva) {
        this.codigoReserva = codigoReserva;
        this.tituloReserva = tituloReserva;
        this.dataSolicitacao = dataSolicitacao;
        this.dataAlocacao = dataAlocacao;
        this.usuarioCliente = usuarioCliente;
        this.enumStatusReserva = enumStatusReserva;
    }

    public Integer getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(Integer codigoReserva) {
        this.codigoReserva = codigoReserva;
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

    public void setEnumStatusReserva(EnumStatusReserva enumStatusReserva) {
        this.enumStatusReserva = enumStatusReserva;
    }

    public String getTituloReserva() {
        return tituloReserva;
    }

    public void setTituloReserva(String tituloReserva) {
        this.tituloReserva = tituloReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "codigoReserva=" + codigoReserva +
                ", tituloReserva='" + tituloReserva + '\'' +
                ", dataSolicitacao=" + dataSolicitacao +
                ", dataAlocacao=" + dataAlocacao +
                ", usuarioCliente=" + usuarioCliente +
                ", enumStatusReserva=" + enumStatusReserva +
                '}';
    }
}
