package Model;

public class Pais {
    Integer Codigo;
    String NomePais;

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
        NomePais = nomePais;
    }
}




