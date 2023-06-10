package Model;

import java.time.LocalDate;

public class Espaco {
    private Integer codigo;
    private String nome;
    private Esporte esporte;
    private LocalDate dataInicioReserva;
    private LocalDate dataFimReserva;
    private EnumStatusEspaco enumStatus;
    private Double valor;

    public Espaco(Integer codigo, String nome, Esporte esporte, LocalDate dataInicioReserva, LocalDate dataFimReserva, EnumStatusEspaco enumStatus, Double valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.esporte = esporte;
        this.dataInicioReserva = dataInicioReserva;
        this.dataFimReserva = dataFimReserva;
        this.enumStatus = enumStatus;
        this.valor = valor;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Esporte getEsporte() {
        return esporte;
    }

    public void setEsporte(Esporte esporte) {
        this.esporte = esporte;
    }

    public LocalDate getDataInicioReserva() {
        return dataInicioReserva;
    }

    public void setDataInicioReserva(LocalDate dataInicioReserva) {
        this.dataInicioReserva = dataInicioReserva;
    }

    public LocalDate getDataFimReserva() {
        return dataFimReserva;
    }

    public void setDataFimReserva(LocalDate dataFimReserva) {
        this.dataFimReserva = dataFimReserva;
    }

    public EnumStatusEspaco getEnumStatus() {
        return enumStatus;
    }

    public void setEnumStatus(EnumStatusEspaco enumStatus) {
        this.enumStatus = enumStatus;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    @Override
    public String toString() {
        return "Espaco{" +
                "codigoEspaco=" + codigo +
                ", nomeEspaco='" + nome + '\'' +
                ", esporte=" + esporte +
                ", dataInicioReserva=" + dataInicioReserva +
                ", dataFimReserva=" + dataFimReserva +
                ", enumStatusEspaco=" + enumStatus +
                ", valorEspaco=" + valor +
                '}';
    }
}