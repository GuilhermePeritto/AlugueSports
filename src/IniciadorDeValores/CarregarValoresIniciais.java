package IniciadorDeValores;

import Model.*;
import Repository.*;

import java.time.LocalDate;

public class CarregarValoresIniciais {

    public static void StartClientes() {
        UsuarioCliente tomas = new UsuarioCliente(1, "Tomas", "48996638183", "65161621951", "123456", true);
        UsuarioClienteDAO.salvar(tomas);
        UsuarioCliente maria = new UsuarioCliente(2, "Maria", "48996638183", "65161621951", "123456", true);
        UsuarioClienteDAO.salvar(maria);
        UsuarioCliente pedro = new UsuarioCliente(3, "Pedro", "48996638183", "65161621951", "123456", true);
        UsuarioClienteDAO.salvar(pedro);
        UsuarioCliente joao = new UsuarioCliente(4, "João", "48996638183", "65161621951", "123456", true);
        UsuarioClienteDAO.salvar(joao);
        UsuarioCliente carlos = new UsuarioCliente(5, "Carlos", "48996638183", "65161621951", "123456", true);
        UsuarioClienteDAO.salvar(carlos);
        UsuarioCliente ana = new UsuarioCliente(6, "Ana", "48996638183", "65161621951", "123456", true);
        UsuarioClienteDAO.salvar(ana);
        UsuarioCliente marcos = new UsuarioCliente(7, "Marcos", "48996638183", "65161621951", "123456", true);
        UsuarioClienteDAO.salvar(marcos);
    }

    public static void StartEsporte() {
        Esporte futbol = new Esporte(1, "Futbol");
        EsporteDAO.salvar(futbol);
        Esporte basquete = new Esporte(2, "Basquete");
        EsporteDAO.salvar(basquete);
        Esporte natacao = new Esporte(3, "Natação");
        EsporteDAO.salvar(natacao);
        Esporte voley = new Esporte(4, "Voley");
        EsporteDAO.salvar(voley);
        Esporte corrida = new Esporte(5, "Corrida");
        EsporteDAO.salvar(corrida);
    }

    public static void StartEspaco() {
        Espaco Campo1 = new Espaco(1, "Campo 1", new Esporte(1, "Futbol"),LocalDate.now(),LocalDate.now(), EnumStatusEspaco.DISPONIVEL);
        EspacoDAO.salvar(Campo1);
        Espaco Campo2 = new Espaco(2, "Campo 2", new Esporte(2, "Basquete") ,LocalDate.now(),LocalDate.now(), EnumStatusEspaco.DISPONIVEL);
        EspacoDAO.salvar(Campo2);
        Espaco Campo3 = new Espaco(3, "Campo 3", new Esporte(3, "Natação"), LocalDate.now(),LocalDate.now(), EnumStatusEspaco.DISPONIVEL);
        EspacoDAO.salvar(Campo3);
        Espaco Campo4 = new Espaco(4, "Campo 4", new Esporte(4, "Voley"), LocalDate.now(),LocalDate.now(), EnumStatusEspaco.DISPONIVEL);
        EspacoDAO.salvar(Campo4);
        Espaco Campo5 = new Espaco(5, "Campo 5", new Esporte(5, "Corrida"), LocalDate.now(),LocalDate.now(), EnumStatusEspaco.DISPONIVEL);
        EspacoDAO.salvar(Campo5);
    }

    public static void StartPais() {
        Pais brasil = new Pais(1, "Brasil");
        PaisDAO.salvar(brasil);
        Pais argentina = new Pais(2, "Argentina");
        PaisDAO.salvar(argentina);
        Pais mexico = new Pais(3, "Mexico");
        PaisDAO.salvar(mexico);
        Pais australia = new Pais(4, "Australia");
        PaisDAO.salvar(australia);
    }
    public static void StartEstado() {
        Estado santaCatarina = new Estado(1, "Santa Catarina", "SC", new Pais(1, "Brasil"));
        EstadoDAO.salvar(santaCatarina);
        Estado rioDeJaneiro = new Estado(2, "Rio de Janeiro", "RJ", new Pais(2, "Argentina"));
        EstadoDAO.salvar(rioDeJaneiro);
        Estado saoPaulo = new Estado(3, "São Paulo", "SP", new Pais(3, "Mexico"));
        EstadoDAO.salvar(saoPaulo);
        Estado rioGrandeDoSul = new Estado(4, "Rio Grande do Sul", "RS", new Pais(4, "Australia"));
        EstadoDAO.salvar(rioGrandeDoSul);
    }

    public static void StartMaterial() {
        Material bola = new Material(1, "Bola", EnumStatusMaterial.DISPONIVEL);
        MaterialDAO.salvar(bola);
        Material couro = new Material(2, "Couro", EnumStatusMaterial.DISPONIVEL);
        MaterialDAO.salvar(couro);
        Material borracha = new Material(3, "Borracha", EnumStatusMaterial.DISPONIVEL);
        MaterialDAO.salvar(borracha);
        Material papel = new Material(4, "Papel", EnumStatusMaterial.DISPONIVEL);
        MaterialDAO.salvar(papel);
        Material plastico = new Material(5, "Plástico", EnumStatusMaterial.DISPONIVEL);
        MaterialDAO.salvar(plastico);
        Material metal = new Material(6, "Metal", EnumStatusMaterial.DISPONIVEL);
        MaterialDAO.salvar(metal);
        Material outros = new Material(7, "Outros", EnumStatusMaterial.DISPONIVEL);
        MaterialDAO.salvar(outros);
    }

    public static void StartReserva() {
        Reserva reserva1 = new Reserva(1, "Reserva1",LocalDate.now(), LocalDate.now() , LocalDate.now(),new UsuarioCliente(1, "Tomas", "48996638183", "65161621951", "123456", true), EnumStatusReserva.ABERTO, new Material(1, "Bola", EnumStatusMaterial.DISPONIVEL), new Espaco(1, "Campo 1", new Esporte(1, "Futbol"), LocalDate.now(),LocalDate.now(), EnumStatusEspaco.DISPONIVEL));
        ReservaDAO.salvar(reserva1);
        Reserva reserva2 = new Reserva(2, "Reserva2",LocalDate.now(), LocalDate.now() , LocalDate.now(), new UsuarioCliente(2, "Maria", "48996638183", "65161621951", "123456", true), EnumStatusReserva.ABERTO, new Material(2, "Couro", EnumStatusMaterial.DISPONIVEL), new Espaco(2, "Campo 2", new Esporte(2, "Basquete"), LocalDate.now(),LocalDate.now(), EnumStatusEspaco.DISPONIVEL));
        ReservaDAO.salvar(reserva2);
        Reserva reserva3 = new Reserva(3, "Reserva3",LocalDate.now(), LocalDate.now() , LocalDate.now(), new UsuarioCliente(3, "Pedro", "48996638183", "65161621951", "123456", true), EnumStatusReserva.ABERTO, new Material(3, "Borracha", EnumStatusMaterial.DISPONIVEL), new Espaco(3, "Campo 3", new Esporte(3, "Natação"), LocalDate.now(),LocalDate.now(), EnumStatusEspaco.DISPONIVEL));
        ReservaDAO.salvar(reserva3);
        Reserva reserva4 = new Reserva(4, "Reserva4",LocalDate.now(), LocalDate.now() , LocalDate.now(), new UsuarioCliente(4, "João", "48996638183", "65161621951", "123456", true), EnumStatusReserva.ABERTO, new Material(4, "Papel", EnumStatusMaterial.DISPONIVEL), new Espaco(4, "Campo 4", new Esporte(4, "Voley"), LocalDate.now(),LocalDate.now(), EnumStatusEspaco.DISPONIVEL));
        ReservaDAO.salvar(reserva4);
        Reserva reserva5 = new Reserva(5, "Reserva5",LocalDate.now(), LocalDate.now() , LocalDate.now(), new UsuarioCliente(5, "Carlos", "48996638183", "65161621951", "123456", true), EnumStatusReserva.ABERTO, new Material(5, "Plástico", EnumStatusMaterial.DISPONIVEL), new Espaco(5, "Campo 5", new Esporte(5, "Corrida"), LocalDate.now(),LocalDate.now(), EnumStatusEspaco.DISPONIVEL));
        ReservaDAO.salvar(reserva5);
    }
}
