package Model;

public class Material {
    Integer codigoMaterial;
    String nomeMaterial;

    public Material(Integer codigoMaterial, String nomeMaterial) {
        this.codigoMaterial = codigoMaterial;
        this.nomeMaterial = nomeMaterial;
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

    @Override
    public String toString() {
        return "Material{" +
                "codigoMaterial=" + codigoMaterial +
                ", nomeMaterial='" + nomeMaterial + '\'' +
                '}';
    }
}
