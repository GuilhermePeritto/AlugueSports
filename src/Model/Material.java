package Model;

public class Material {
    private Integer codigoMaterial;
    private String nomeMaterial;
    private EnumStatusMaterial enumStatusMaterial;
    private Double valorMaterial;

    public Material(Integer codigoMaterial, String nomeMaterial, EnumStatusMaterial enumStatusMaterial, Double valorMaterial) {
        this.codigoMaterial = codigoMaterial;
        this.nomeMaterial = nomeMaterial;
        this.enumStatusMaterial = enumStatusMaterial;
        this.valorMaterial = valorMaterial;
    }

    public Integer getCodigoMaterial() {
        return codigoMaterial;
    }

    public void setCodigoMaterial(Integer codigoMaterial) {
        this.codigoMaterial = codigoMaterial;
    }

    public String getNomeMaterial() {
        return nomeMaterial;
    }

    public void setNomeMaterial(String nomeMaterial) {
        this.nomeMaterial = nomeMaterial;
    }

    public EnumStatusMaterial getEnumStatusMaterial() {
        return enumStatusMaterial;
    }

    public void setEnumStatusMaterial(EnumStatusMaterial enumStatusMaterial) {
        this.enumStatusMaterial = enumStatusMaterial;
    }

    public Double getValorMaterial() {
        return valorMaterial;
    }

    public void setValorMaterial(Double valorMaterial) {
        this.valorMaterial = valorMaterial;
    }

    @Override
    public String toString() {
        return "Material{" +
                "codigoMaterial=" + codigoMaterial +
                ", nomeMaterial='" + nomeMaterial + '\'' +
                ", enumStatusMaterial=" + enumStatusMaterial +
                ", valorMaterial=" + valorMaterial +
                '}';
    }
}
