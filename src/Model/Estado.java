package Model;

public class Estado {
    private Integer codigo;
    private String nome;
    private String sigla;
    private Pais pais;

    public Estado(Integer codigo, String nome, String sigla, Pais pais) {
        this.codigo = codigo;
        this.nome = nome;
        sigla = sigla;
        this.pais = pais;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }


    public String getSigla() {
        return sigla;
    }

    public Pais getPais() {
        return pais;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = this.codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
                "codigoEstado=" + codigo +
                ", nomeEstado='" + nome + '\'' +
                ", sigla=" + sigla +
                ", pais=" + pais +
                '}';
    }
}

