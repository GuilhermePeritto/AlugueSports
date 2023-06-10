package Model;

public class Material {
    private Integer codigo;
    private String nome;
    private EnumStatusMaterial enumStatus;
    private Double valor;

    public Material(Integer codigo, String nome, EnumStatusMaterial enumStatus, Double valor) {
        this.codigo = codigo;
        this.nome = nome;
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

    public EnumStatusMaterial getEnumStatus() {
        return enumStatus;
    }

    public void setEnumStatus(EnumStatusMaterial enumStatus) {
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
        return "Material{" +
                "codigoMaterial=" + codigo +
                ", nomeMaterial='" + nome + '\'' +
                ", enumStatusMaterial=" + enumStatus +
                ", valorMaterial=" + valor +
                '}';
    }
}
