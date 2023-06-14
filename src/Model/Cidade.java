package Model;

public class Cidade {
    private Integer codigo;
    private String nome;
    private Estado estado;


    public Cidade(Integer codigo, String nome, Estado estado) {
        this.codigo = codigo;
        this.nome = nome;
        this.estado = estado;
    }


    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", estado=" + estado +
                '}';
    }
}
