package Repository;

import Model.Pessoa;

public class UsuarioCliente extends Pessoa {

    private Boolean cliente;

    public UsuarioCliente(Integer codigo, String nome, String telefone, String cpf, String rg, Boolean cliente) {
        super(codigo, nome, telefone, cpf, rg);
        this.cliente = cliente;
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
                "cliente=" + cliente +
                '}';
    }
}
