package Model;

import java.time.LocalDate;

public class Esporte {
    private Integer codigoEsporte;
    private String nomeEsporte;

    public Esporte(Integer codigoEsporte, String nomeEsporte) {
        this.codigoEsporte = codigoEsporte;
        this.nomeEsporte = nomeEsporte;
    }

    public Integer getCodigo() {
        return codigoEsporte;
    }

    public void setCodigo(Integer codigo) {
        this.codigoEsporte = codigo;
    }

    public String getNomeEsporte() {
        return nomeEsporte;
    }

    public void setNomeEsporte(String nomeEsporte) {
        this.nomeEsporte = nomeEsporte;
    }

    @Override
    public String toString() {
        return "Esporte{" +
                "codigo=" + codigoEsporte +
                ", nomeEsporte='" + nomeEsporte + '\'' +
                '}';
    }
}
