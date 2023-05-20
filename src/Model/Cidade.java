package Model;

public class Cidade {
    private Integer Codigo;
    private String NomeCidade;
    private Estado estado;

    public Cidade(Integer codigo, String nomeCidade, Estado estado) {
        Codigo = codigo;
        NomeCidade = nomeCidade;
        this.estado = estado;
    }

    public Integer getCodigo() {
        return Codigo;
    }

    public void setCodigo(Integer codigo) {
        Codigo = codigo;
    }

    public String getNomeCidade() {
        return NomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        NomeCidade = nomeCidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "Codigo=" + Codigo +
                ", NomeCidade='" + NomeCidade + '\'' +
                ", estado=" + estado +
                '}';
    }
}
