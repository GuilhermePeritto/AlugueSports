package Model;

public class Material {
    Integer codigoMaterial;
    String nomeMaterial;

    EnumStatusMaterial enumStatusMaterial;

    public Material(Integer codigoMaterial, String nomeMaterial, EnumStatusMaterial enumStatusMaterial) {
        this.codigoMaterial = codigoMaterial;
        this.nomeMaterial = nomeMaterial;
        this.enumStatusMaterial = enumStatusMaterial;
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

    @Override
    public String toString() {
        return "Material{" +
                "codigoMaterial=" + codigoMaterial +
                ", nomeMaterial='" + nomeMaterial + '\'' +
                ", enumStatusMaterial=" + enumStatusMaterial +
                '}';
    }
}
