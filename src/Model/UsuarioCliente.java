package Model;

public class UsuarioCliente {
    private Integer codigoUsuarioCliente;
    private String nomeUsuarioCliente;
    private String telefone;
    private String cpf;
    private String rg;
    private Boolean cliente;

    public UsuarioCliente(Integer codigo, String nomeUsuarioCliente, String telefone, String cpf, String rg, Boolean cliente) {
        this.codigoUsuarioCliente = codigo;
        this.nomeUsuarioCliente = nomeUsuarioCliente;
        this.telefone = telefone;
        this.cpf = cpf;
        this.rg = rg;
        this.cliente = cliente;
    }

    public Integer getCodigo() {
        return codigoUsuarioCliente;
    }

    public void setCodigo(Integer codigo) {
        this.codigoUsuarioCliente = codigo;
    }

    public String getNomeUsuarioCliente() {
        return nomeUsuarioCliente;
    }

    public void setNomeUsuarioCliente(String nomeUsuarioCliente) {
        this.nomeUsuarioCliente = nomeUsuarioCliente;
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

    public Boolean getCliente() {
        return cliente;
    }

    public void setCliente(Boolean cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "UsuarioCliente{" +
                "codigo=" + codigoUsuarioCliente +
                ", nome='" + nomeUsuarioCliente + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", cliente=" + cliente +
                '}';
    }
}
