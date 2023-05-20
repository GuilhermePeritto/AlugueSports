package Model;

public class Estado {
    private Integer codigoEstado;
    private String nomeEstado;
    private String Sigla;
    private Pais pais;

    public Estado(Integer codigo, String nomeEstado, String sigla, Pais pais) {
        this.codigoEstado = codigo;
        this.nomeEstado = nomeEstado;
        Sigla = sigla;
        this.pais = pais;
    }

    public Integer getCodigo() {
        return codigoEstado;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public String getSigla() {
        return Sigla;
    }

    public Pais getPais() {
        return pais;
    }

    public void setCodigo(Integer codigo) {
        this.codigoEstado = codigo;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public void setSigla(String sigla) {
        Sigla = sigla;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "codigo=" + codigoEstado +
                ", nomeEstado='" + nomeEstado + '\'' +
                ", Sigla=" + Sigla +
                ", pais=" + pais +
                '}';
    }
}

