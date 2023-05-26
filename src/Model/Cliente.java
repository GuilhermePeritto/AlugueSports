package Model;

import java.time.LocalDate;

public class Cliente {
    private Integer codigo;
    private String nome;
    private LocalDate nascimento;
    private String telefone;
    private String cpf;
    private String rg;

    public Cliente(Integer codigo, String nome, LocalDate nascimento, String telefone, String cpf, String rg) {
        this.codigo = codigo;
        this.nome = nome;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.cpf = cpf;
        this.rg = rg;
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

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", nascimento=" + nascimento +
                ", telefone='" + telefone + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                '}';
    }
}
