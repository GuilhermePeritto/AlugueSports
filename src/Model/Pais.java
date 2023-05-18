package Model;

public class Pais {
    private Integer codigoPais;
    private String nomePais;

    public Pais(Integer codigoPais, String nomePais) {
        this.codigoPais = codigoPais;
        this.nomePais = nomePais;
    }

    public Integer getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(Integer codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "codigoPais=" + codigoPais +
                ", nomePais='" + nomePais + '\'' +
                '}';
    }
}




