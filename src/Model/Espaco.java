package Model;

import java.time.LocalDate;

public class Espaco {
    private Integer codigo;
    private String nome;
    private Esporte esporte;
    private EnumStatusEspaco enumStatus;
    private Double valor;

    public Espaco(Integer codigo, String nome, Esporte esporte, EnumStatusEspaco enumStatus, Double valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.esporte = esporte;
        this.enumStatus = enumStatus;
        this.valor = valor;
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

    public Esporte getEsporte() {
        return esporte;
    }

    public void setEsporte(Esporte esporte) {
        this.esporte = esporte;
    }

    public EnumStatusEspaco getEnumStatus() {
        return enumStatus;
    }

    public void setEnumStatus(EnumStatusEspaco enumStatus) {
        this.enumStatus = enumStatus;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    @Override
    public String toString() {
        return "Espaco{" +
                "codigoEspaco=" + codigo +
                ", nomeEspaco='" + nome + '\'' +
                ", esporte=" + esporte +
                ", enumStatusEspaco=" + enumStatus +
                ", valorEspaco=" + valor +
                '}';
    }
}