package Model;

import java.time.LocalDate;

public class Reserva {

    private Integer codigo;
    private String titulo;
    private LocalDate dataSolicitacao;
    private LocalDate dataAlocacaoInicio;
    private LocalDate dataAlocacaoFim;
    private Cliente cliente;
    private EnumStatusReserva enumStatus;
    private Material material;
    private Espaco espaco;
    private Double valor;

    public Reserva(Integer codigo, String titulo, LocalDate dataSolicitacao, LocalDate dataAlocacaoInicio, LocalDate dataAlocacaoFim, Cliente cliente, EnumStatusReserva enumStatus, Material material, Espaco espaco, Double valor) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.dataSolicitacao = dataSolicitacao;
        this.dataAlocacaoInicio = dataAlocacaoInicio;
        this.dataAlocacaoFim = dataAlocacaoFim;
        this.cliente = cliente;
        this.enumStatus = enumStatus;
        this.material = material;
        this.espaco = espaco;
        this.valor = valor;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public EnumStatusReserva getEnumStatus() {
        return enumStatus;
    }

    public void setEnumStatus(EnumStatusReserva enumStatus) {
        this.enumStatus = enumStatus;
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "codigoReserva=" + codigo +
                ", tituloReserva='" + titulo + '\'' +
                ", dataSolicitacao=" + dataSolicitacao +
                ", dataAlocacaoInicio=" + dataAlocacaoInicio +
                ", dataAlocacaoFim=" + dataAlocacaoFim +
                ", usuarioCliente=" + cliente +
                ", enumStatusReserva=" + enumStatus +
                ", material=" + material +
                ", espaco=" + espaco +
                ", valorReserva=" + valor +
                '}';
    }
}
