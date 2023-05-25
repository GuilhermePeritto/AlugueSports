package Model;

import java.time.LocalDate;

public class Reserva {

    private Integer codigoReserva;
    private String tituloReserva;
    private LocalDate dataSolicitacao;
    private LocalDate dataAlocacaoInicio;
    private LocalDate dataAlocacaoFim;
    private UsuarioCliente usuarioCliente;
    private EnumStatusReserva enumStatusReserva;
    private Material material;
    private Espaco espaco;

    public Reserva(Integer codigoReserva, String tituloReserva, LocalDate dataSolicitacao, LocalDate dataAlocacaoInicio, LocalDate dataAlocacaoFim, UsuarioCliente usuarioCliente, EnumStatusReserva enumStatusReserva, Material material, Espaco espaco) {
        this.codigoReserva = codigoReserva;
        this.tituloReserva = tituloReserva;
        this.dataSolicitacao = dataSolicitacao;
        this.dataAlocacaoInicio = dataAlocacaoInicio;
        this.dataAlocacaoFim = dataAlocacaoFim;
        this.usuarioCliente = usuarioCliente;
        this.enumStatusReserva = enumStatusReserva;
        this.material = material;
        this.espaco = espaco;
    }

    public Integer getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(Integer codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public String getTituloReserva() {
        return tituloReserva;
    }

    public void setTituloReserva(String tituloReserva) {
        this.tituloReserva = tituloReserva;
    }

    public LocalDate getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public LocalDate getDataAlocacaoInicio() {
        return dataAlocacaoInicio;
    }

    public void setDataAlocacaoInicio(LocalDate dataAlocacaoInicio) {
        this.dataAlocacaoInicio = dataAlocacaoInicio;
    }

    public LocalDate getDataAlocacaoFim() {
        return dataAlocacaoFim;
    }

    public void setDataAlocacaoFim(LocalDate dataAlocacaoFim) {
        this.dataAlocacaoFim = dataAlocacaoFim;
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

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Espaco getEspaco() {
        return espaco;
    }

    public void setEspaco(Espaco espaco) {
        this.espaco = espaco;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "codigoReserva=" + codigoReserva +
                ", tituloReserva='" + tituloReserva + '\'' +
                ", dataSolicitacao=" + dataSolicitacao +
                ", dataAlocacaoInicio=" + dataAlocacaoInicio +
                ", dataAlocacaoFim=" + dataAlocacaoFim +
                ", usuarioCliente=" + usuarioCliente +
                ", enumStatusReserva=" + enumStatusReserva +
                ", material=" + material +
                ", espaco=" + espaco +
                '}';
    }
}
