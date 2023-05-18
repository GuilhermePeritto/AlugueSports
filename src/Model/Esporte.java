package Model;

public class Esporte {
    private Integer codigoEsporte;
    private String nomeEsporte;

    public Esporte(Integer codigo, String nomeEsporte) {
        this.codigoEsporte = codigo;
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
