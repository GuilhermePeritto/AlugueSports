package Model;

public class Cidade {
    private Integer codigo;
    private String nomeCidade;
    private Estado estado;


    public Cidade(Integer codigo, String nomeCidade, Estado estado) {
        this.codigo = codigo;
        this.nomeCidade = nomeCidade;
        this.estado = estado;
    }


    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
