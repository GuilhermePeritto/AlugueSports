package Model;

public class Estado {
    private Integer codigoEstado;
    private String nomeEstado;
    private String sigla;
    private Pais pais;

    public Estado(Integer codigoEstado, String nomeEstado, String sigla, Pais pais) {
        this.codigoEstado = codigoEstado;
        this.nomeEstado = nomeEstado;
        sigla = sigla;
        this.pais = pais;
    }

    public Integer getCodigoEstado() {
        return codigoEstado;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }


    public String getSigla() {
        return sigla;
    }

    public Pais getPais() {
        return pais;
    }

    public void setCodigo(Integer codigo) {
        this.codigoEstado = codigoEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public void setSigla(String sigla) {
        sigla = sigla;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "codigoEstado=" + codigoEstado +
                ", nomeEstado='" + nomeEstado + '\'' +
                ", sigla=" + sigla +
                ", pais=" + pais +
                '}';
    }
}

