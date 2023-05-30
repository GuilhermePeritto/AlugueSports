package Model;

import java.time.LocalDate;

public class Reserva {

    private Integer codigoReserva;
    private String tituloReserva;
    private LocalDate dataSolicitacao;
    private LocalDate dataAlocacaoInicio;
    private LocalDate dataAlocacaoFim;
    private Cliente cliente;
    private EnumStatusReserva enumStatusReserva;
    private Material material;
    private Espaco espaco;
    private Double valorReserva;

    public Reserva(Integer codigoReserva, String tituloReserva, LocalDate dataSolicitacao, LocalDate dataAlocacaoInicio, LocalDate dataAlocacaoFim, Cliente cliente, EnumStatusReserva enumStatusReserva, Material material, Espaco espaco, Double valorReserva) {
        this.codigoReserva = codigoReserva;
        this.tituloReserva = tituloReserva;
        this.dataSolicitacao = dataSolicitacao;
        this.dataAlocacaoInicio = dataAlocacaoInicio;
        this.dataAlocacaoFim = dataAlocacaoFim;
        this.cliente = cliente;
        this.enumStatusReserva = enumStatusReserva;
        this.material = material;
        this.espaco = espaco;
        this.valorReserva = valorReserva;
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

    public Cliente getUsuarioCliente() {
        return cliente;
    }

    public void setUsuarioCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public Double getValorReserva() {
        return valorReserva;
    }

    public void setValorReserva(Double valorReserva) {
        this.valorReserva = valorReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "codigoReserva=" + codigoReserva +
                ", tituloReserva='" + tituloReserva + '\'' +
                ", dataSolicitacao=" + dataSolicitacao +
                ", dataAlocacaoInicio=" + dataAlocacaoInicio +
                ", dataAlocacaoFim=" + dataAlocacaoFim +
                ", usuarioCliente=" + cliente +
                ", enumStatusReserva=" + enumStatusReserva +
                ", material=" + material +
                ", espaco=" + espaco +
                ", valorReserva=" + valorReserva +
                '}';
    }
}
