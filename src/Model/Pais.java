package Model;

public class Pais {
    private Integer Codigo;
    private String NomePais;

    public Pais(Integer codigo, String nomePais) {
        Codigo = codigo;
        NomePais = nomePais;
    }

    public Integer getCodigo() {
        return Codigo;
    }

    public void setCodigo(Integer codigo) {
        Codigo = codigo;
    }

    public String getNomePais() {
        return NomePais;
    }

    public void setNomePais(String nomePais) {
        NomePais = nomePais ;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "Codigo=" + Codigo +
                ", NomePais='" + NomePais + '\'' +
                '}';
    }
}




