package Model;

public class Espaco {
    private Integer codigoEspaco;
    private String nomeEspaco;
    private Esporte esporte;

    public static void disponibilidadeEspaco(){

    }

    public Espaco(Integer codigo, String nomeEspaco, Esporte esporte) {
        this.codigoEspaco = codigo;
        this.nomeEspaco = nomeEspaco;
        this.esporte = esporte;
    }

    public Integer getCodigo() {
        return codigoEspaco;
    }

    public void setCodigo(Integer codigo) {
        this.codigoEspaco = codigo;
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
                "codigo=" + codigoEspaco +
                ", nomeEspaco='" + nomeEspaco + '\'' +
                ", esporte=" + esporte +
                '}';
    }
}
