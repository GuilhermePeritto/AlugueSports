package Model;

public class Esporte {
    private Integer codigo;
    private String nomeEsporte;

    public Esporte(Integer codigo, String nomeEsporte) {
        this.codigo = codigo;
        this.nomeEsporte = nomeEsporte;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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
                "codigo=" + codigo +
                ", nomeEsporte='" + nomeEsporte + '\'' +
                '}';
    }
}
