package Model;

public class Espaco {
    private Integer codigo;
    private String nomeEspaco;
    private Esporte esporte;

    public Espaco(Integer codigo, String nomeEspaco, Esporte esporte) {
        this.codigo = codigo;
        this.nomeEspaco = nomeEspaco;
        this.esporte = esporte;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

    @Override
    public String toString() {
        return "Espaco{" +
                "codigo=" + codigo +
                ", nomeEspaco='" + nomeEspaco + '\'' +
                ", esporte=" + esporte +
                '}';
    }
}
