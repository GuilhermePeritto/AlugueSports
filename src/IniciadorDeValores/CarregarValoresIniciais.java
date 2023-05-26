package IniciadorDeValores;

import Model.*;
import Repository.*;

import java.time.LocalDate;

public class CarregarValoresIniciais {

    public static void StartClientes() {
        Cliente tomas = new Cliente(1, "Tomas", LocalDate.now(), "48996638183", "65161621951", "123456");
        ClienteDAO.salvar(tomas);
        Cliente maria = new Cliente(2, "Maria", LocalDate.now(), "48996638183", "65161621951", "123456");
        ClienteDAO.salvar(maria);
        Cliente pedro = new Cliente(3, "Pedro", LocalDate.now(), "48996638183", "65161621951", "123456");
        ClienteDAO.salvar(pedro);
        Cliente joao = new Cliente(4, "João", LocalDate.now(), "48996638183", "65161621951", "123456");
        ClienteDAO.salvar(joao);
        Cliente carlos = new Cliente(5, "Carlos", LocalDate.now(), "48996638183", "65161621951", "123456");
        ClienteDAO.salvar(carlos);
        Cliente ana = new Cliente(6, "Ana", LocalDate.now(),"48996638183", "65161621951", "123456");
        ClienteDAO.salvar(ana);
        Cliente marcos = new Cliente(7, "Marcos", LocalDate.now(), "48996638183", "65161621951", "123456");
        ClienteDAO.salvar(marcos);
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
        Espaco Campo1 = new Espaco(1, "Campo 1", new Esporte(1, "Futbol"),LocalDate.now(),LocalDate.now(), EnumStatusEspaco.DISPONIVEL, 1000.0);
        EspacoDAO.salvar(Campo1);
        Espaco Campo2 = new Espaco(2, "Campo 2", new Esporte(2, "Basquete") ,LocalDate.now(),LocalDate.now(), EnumStatusEspaco.DISPONIVEL, 1000.0);
        EspacoDAO.salvar(Campo2);
        Espaco Campo3 = new Espaco(3, "Campo 3", new Esporte(3, "Natação"), LocalDate.now(),LocalDate.now(), EnumStatusEspaco.DISPONIVEL, 1000.0);
        EspacoDAO.salvar(Campo3);
        Espaco Campo4 = new Espaco(4, "Campo 4", new Esporte(4, "Voley"), LocalDate.now(),LocalDate.now(), EnumStatusEspaco.DISPONIVEL, 1000.0);
        EspacoDAO.salvar(Campo4);
        Espaco Campo5 = new Espaco(5, "Campo 5", new Esporte(5, "Corrida"), LocalDate.now(),LocalDate.now(), EnumStatusEspaco.DISPONIVEL, 1000.0);
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
        Material bola = new Material(1, "Bola", EnumStatusMaterial.DISPONIVEL, 1000.0);
        MaterialDAO.salvar(bola);
        Material couro = new Material(2, "Couro", EnumStatusMaterial.DISPONIVEL, 1000.0);
        MaterialDAO.salvar(couro);
        Material borracha = new Material(3, "Borracha", EnumStatusMaterial.DISPONIVEL, 1000.0);
        MaterialDAO.salvar(borracha);
        Material papel = new Material(4, "Papel", EnumStatusMaterial.DISPONIVEL, 1000.0);
        MaterialDAO.salvar(papel);
        Material plastico = new Material(5, "Plástico", EnumStatusMaterial.DISPONIVEL, 1000.0);
        MaterialDAO.salvar(plastico);
        Material metal = new Material(6, "Metal", EnumStatusMaterial.DISPONIVEL, 1000.0);
        MaterialDAO.salvar(metal);
        Material outros = new Material(7, "Outros", EnumStatusMaterial.DISPONIVEL, 1000.0);
        MaterialDAO.salvar(outros);
    }

    public static void StartReserva() {
        Reserva reserva1 = new Reserva(1, "Reserva1",LocalDate.now(), LocalDate.now() , LocalDate.now(),new Cliente(1, "Tomas", LocalDate.now(), "48996638183", "65161621951", "123456"), EnumStatusReserva.ABERTO, new Material(1, "Bola", EnumStatusMaterial.DISPONIVEL, 1000.0), new Espaco(1, "Campo 1", new Esporte(1, "Futbol"), LocalDate.now(),LocalDate.now(), EnumStatusEspaco.DISPONIVEL, 1000.0), 10000.0);
        ReservaDAO.salvar(reserva1);
        Reserva reserva2 = new Reserva(2, "Reserva2",LocalDate.now(), LocalDate.now() , LocalDate.now(), new Cliente(2, "Maria", LocalDate.now(), "48996638183", "65161621951", "123456"), EnumStatusReserva.ABERTO, new Material(2, "Couro", EnumStatusMaterial.DISPONIVEL, 1000.0), new Espaco(2, "Campo 2", new Esporte(2, "Basquete"), LocalDate.now(),LocalDate.now(), EnumStatusEspaco.DISPONIVEL, 1000.0), 10000.0);
        ReservaDAO.salvar(reserva2);
        Reserva reserva3 = new Reserva(3, "Reserva3",LocalDate.now(), LocalDate.now() , LocalDate.now(), new Cliente(3, "Pedro", LocalDate.now(), "48996638183", "65161621951", "123456"), EnumStatusReserva.ABERTO, new Material(3, "Borracha", EnumStatusMaterial.DISPONIVEL, 1000.0), new Espaco(3, "Campo 3", new Esporte(3, "Natação"), LocalDate.now(),LocalDate.now(), EnumStatusEspaco.DISPONIVEL, 1000.0), 10000.0);
        ReservaDAO.salvar(reserva3);
        Reserva reserva4 = new Reserva(4, "Reserva4",LocalDate.now(), LocalDate.now() , LocalDate.now(), new Cliente(4, "João", LocalDate.now(), "48996638183", "65161621951", "123456"), EnumStatusReserva.ABERTO, new Material(4, "Papel", EnumStatusMaterial.DISPONIVEL, 1000.0), new Espaco(4, "Campo 4", new Esporte(4, "Voley"), LocalDate.now(),LocalDate.now(), EnumStatusEspaco.DISPONIVEL, 1000.0), 10000.0);
        ReservaDAO.salvar(reserva4);
        Reserva reserva5 = new Reserva(5, "Reserva5",LocalDate.now(), LocalDate.now() , LocalDate.now(), new Cliente(5, "Carlos", LocalDate.now(), "48996638183", "65161621951", "123456"), EnumStatusReserva.ABERTO, new Material(5, "Plástico", EnumStatusMaterial.DISPONIVEL, 1000.0), new Espaco(5, "Campo 5", new Esporte(5, "Corrida"), LocalDate.now(),LocalDate.now(), EnumStatusEspaco.DISPONIVEL, 1000.0), 10000.0);
        ReservaDAO.salvar(reserva5);
    }
}
