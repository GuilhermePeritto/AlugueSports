package Repository;

import Model.Esporte;
import Model.UsuarioCliente;

import java.util.ArrayList;
import java.util.List;

public class EsporteDAO {
    static List<Esporte> esportes= new ArrayList<>();
    public static void salvar(Esporte esporte) {
        esportes.add(esporte);
    }
    public static List<Esporte> buscaTodos() {
        return esportes;
    }
}
