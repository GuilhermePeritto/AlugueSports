package Model;

import java.time.LocalDate;

public class Espaco {
    private Integer codigoEspaco;
    private String nomeEspaco;
    private Esporte esporte;
    private LocalDate dataInicioReserva;
    private LocalDate dataFimReserva;

    private EnumStatusEspaco enumStatusEspaco;

    public Espaco(Integer codigoEspaco, String nomeEspaco, Esporte esporte, LocalDate dataInicioReserva, LocalDate dataFimReserva, EnumStatusEspaco enumStatusEspaco) {
        this.codigoEspaco = codigoEspaco;
        this.nomeEspaco = nomeEspaco;
        this.esporte = esporte;
        this.dataInicioReserva = dataInicioReserva;
        this.dataFimReserva = dataFimReserva;
        this.enumStatusEspaco = enumStatusEspaco;
    }

    public Integer getCodigoEspaco() {
        return codigoEspaco;
    }

    public void setCodigoEspaco(Integer codigoEspaco) {
        this.codigoEspaco = codigoEspaco;
    }

    public String getNomeEspaco() {
        return nomeEspaco;
    }

    public void setNomeEspaco(String nomeEspaco) {
        this.nomeEspaco = nomeEspaco;
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

    public EnumStatusEspaco getEnumStatusEspaco() {
        return enumStatusEspaco;
    }

    public void setEnumStatusEspaco(EnumStatusEspaco enumStatusEspaco) {
        this.enumStatusEspaco = enumStatusEspaco;
    }

    @Override
    public String toString() {
        return "Espaco{" +
                "codigoEspaco=" + codigoEspaco +
                ", nomeEspaco='" + nomeEspaco + '\'' +
                ", esporte=" + esporte +
                ", dataInicioReserva=" + dataInicioReserva +
                ", dataFimReserva=" + dataFimReserva +
                ", enumStatusEspaco=" + enumStatusEspaco +
                '}';
    }
}
