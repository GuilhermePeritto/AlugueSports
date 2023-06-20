package IniciadorDeValores;

import Model.*;
import Repository.*;

import java.time.LocalDate;

public class CarregarValoresIniciais {

    public static void StartClientes() {
        Cliente tomas = new Cliente(CalcularCodigo.calculaCodigo(ClienteDAO.getClientes()), "Tomas", LocalDate.now(), "48996638183", "65161621951", "123456");
        ClienteDAO.salvar(tomas);
        Cliente maria = new Cliente(CalcularCodigo.calculaCodigo(ClienteDAO.getClientes()), "Maria", LocalDate.now(), "48996638183", "65161621951", "123456");
        ClienteDAO.salvar(maria);
        Cliente pedro = new Cliente(CalcularCodigo.calculaCodigo(ClienteDAO.getClientes()), "Pedro", LocalDate.now(), "48996638183", "65161621951", "123456");
        ClienteDAO.salvar(pedro);
        Cliente joao = new Cliente(CalcularCodigo.calculaCodigo(ClienteDAO.getClientes()), "João", LocalDate.now(), "48996638183", "65161621951", "123456");
        ClienteDAO.salvar(joao);
        Cliente carlos = new Cliente(CalcularCodigo.calculaCodigo(ClienteDAO.getClientes()), "Carlos", LocalDate.now(), "48996638183", "65161621951", "123456");
        ClienteDAO.salvar(carlos);
        Cliente ana = new Cliente(CalcularCodigo.calculaCodigo(ClienteDAO.getClientes()), "Ana", LocalDate.now(),"48996638183", "65161621951", "123456");
        ClienteDAO.salvar(ana);
        Cliente marcos = new Cliente(CalcularCodigo.calculaCodigo(ClienteDAO.getClientes()), "Marcos", LocalDate.now(), "48996638183", "65161621951", "123456");
        ClienteDAO.salvar(marcos);
    }

    public static void StartEsporte() {
        Esporte futbol = new Esporte(CalcularCodigo.calculaCodigo(EsporteDAO.getEsportes()), "Futebol");
        EsporteDAO.salvar(futbol);
        Esporte basquete = new Esporte(CalcularCodigo.calculaCodigo(EsporteDAO.getEsportes()), "Basquete");
        EsporteDAO.salvar(basquete);
        Esporte natacao = new Esporte(CalcularCodigo.calculaCodigo(EsporteDAO.getEsportes()), "Natação");
        EsporteDAO.salvar(natacao);
        Esporte voley = new Esporte(CalcularCodigo.calculaCodigo(EsporteDAO.getEsportes()), "Voley");
        EsporteDAO.salvar(voley);
        Esporte corrida = new Esporte(CalcularCodigo.calculaCodigo(EsporteDAO.getEsportes()), "Corrida");
        EsporteDAO.salvar(corrida);
    }

    public static void StartEspaco() {
        Espaco Campo1 = new Espaco(CalcularCodigo.calculaCodigo(EspacoDAO.getEspacos()), "Campo 1", EsporteDAO.getEsportes().get(0), EnumStatusEspaco.DISPONIVEL, 1000.0);
        EspacoDAO.salvar(Campo1);
        Espaco Campo2 = new Espaco(CalcularCodigo.calculaCodigo(EspacoDAO.getEspacos()), "Campo 2", EsporteDAO.getEsportes().get(0) , EnumStatusEspaco.DISPONIVEL, 1000.0);
        EspacoDAO.salvar(Campo2);
        Espaco Campo3 = new Espaco(CalcularCodigo.calculaCodigo(EspacoDAO.getEspacos()), "Campo 3", EsporteDAO.getEsportes().get(3), EnumStatusEspaco.DISPONIVEL, 1000.0);
        EspacoDAO.salvar(Campo3);
        Espaco Campo4 = new Espaco(CalcularCodigo.calculaCodigo(EspacoDAO.getEspacos()), "Campo 4", EsporteDAO.getEsportes().get(3), EnumStatusEspaco.DISPONIVEL, 1000.0);
        EspacoDAO.salvar(Campo4);
        Espaco Campo5 = new Espaco(CalcularCodigo.calculaCodigo(EspacoDAO.getEspacos()), "Campo 5", EsporteDAO.getEsportes().get(4), EnumStatusEspaco.DISPONIVEL, 1000.0);
        EspacoDAO.salvar(Campo5);
    }

    public static void StartPais() {
        Pais brasil = new Pais(CalcularCodigo.calculaCodigo(PaisDAO.getPaises()), "Brasil");
        PaisDAO.salvar(brasil);
        Pais argentina = new Pais(CalcularCodigo.calculaCodigo(PaisDAO.getPaises()), "Argentina");
        PaisDAO.salvar(argentina);
        Pais mexico = new Pais(CalcularCodigo.calculaCodigo(PaisDAO.getPaises()), "Mexico");
        PaisDAO.salvar(mexico);
        Pais australia = new Pais(CalcularCodigo.calculaCodigo(PaisDAO.getPaises()), "Australia");
        PaisDAO.salvar(australia);
    }
    public static void StartEstado() {
        Estado santaCatarina = new Estado(CalcularCodigo.calculaCodigo(EstadoDAO.getEstados()), "Santa Catarina", "SC", PaisDAO.getPaises().get(0));
        EstadoDAO.salvar(santaCatarina);
        Estado rioDeJaneiro = new Estado(CalcularCodigo.calculaCodigo(EstadoDAO.getEstados()), "Rio de Janeiro", "RJ", PaisDAO.getPaises().get(0));
        EstadoDAO.salvar(rioDeJaneiro);
        Estado saoPaulo = new Estado(CalcularCodigo.calculaCodigo(EstadoDAO.getEstados()), "São Paulo", "SP", PaisDAO.getPaises().get(0));
        EstadoDAO.salvar(saoPaulo);
        Estado rioGrandeDoSul = new Estado(CalcularCodigo.calculaCodigo(EstadoDAO.getEstados()), "Rio Grande do Sul", "RS", PaisDAO.getPaises().get(0));
        EstadoDAO.salvar(rioGrandeDoSul);
    }

    public static void StartCidade() {
        Cidade criciuma = new Cidade(CalcularCodigo.calculaCodigo(CidadeDAO.getCidades()), "Criciuma", EstadoDAO.getEstados().get(0));
        CidadeDAO.salvar(criciuma);
        Cidade sideropolis = new Cidade(CalcularCodigo.calculaCodigo(CidadeDAO.getCidades()), "Sideropolis", EstadoDAO.getEstados().get(0));
        CidadeDAO.salvar(sideropolis);
        Cidade novaVeneza = new Cidade(CalcularCodigo.calculaCodigo(CidadeDAO.getCidades()), "Nova Veneza", EstadoDAO.getEstados().get(0));
        CidadeDAO.salvar(novaVeneza);
        Cidade forquilinha = new Cidade(CalcularCodigo.calculaCodigo(CidadeDAO.getCidades()), "Forquilhinha", EstadoDAO.getEstados().get(0));
        CidadeDAO.salvar(forquilinha);
        Cidade saoPaulo = new Cidade(CalcularCodigo.calculaCodigo(CidadeDAO.getCidades()), "São Paulo", EstadoDAO.getEstados().get(2));
        CidadeDAO.salvar(saoPaulo);
        Cidade portoAlegre = new Cidade(CalcularCodigo.calculaCodigo(CidadeDAO.getCidades()), "Porto Alegre", EstadoDAO.getEstados().get(3));
        CidadeDAO.salvar(portoAlegre);
    }

    public static void StartMaterial() {
        Material bola = new Material(CalcularCodigo.calculaCodigo(MaterialDAO.getMaterialList()), "Bola", EnumStatusMaterial.DISPONIVEL, 1000.0);
        MaterialDAO.salvar(bola);
        Material couro = new Material(CalcularCodigo.calculaCodigo(MaterialDAO.getMaterialList()), "Couro", EnumStatusMaterial.DISPONIVEL, 1000.0);
        MaterialDAO.salvar(couro);
        Material borracha = new Material(CalcularCodigo.calculaCodigo(MaterialDAO.getMaterialList()), "Borracha", EnumStatusMaterial.DISPONIVEL, 1000.0);
        MaterialDAO.salvar(borracha);
        Material papel = new Material(CalcularCodigo.calculaCodigo(MaterialDAO.getMaterialList()), "Papel", EnumStatusMaterial.DISPONIVEL, 1000.0);
        MaterialDAO.salvar(papel);
        Material plastico = new Material(CalcularCodigo.calculaCodigo(MaterialDAO.getMaterialList()), "Plástico", EnumStatusMaterial.DISPONIVEL, 1000.0);
        MaterialDAO.salvar(plastico);
        Material metal = new Material(CalcularCodigo.calculaCodigo(MaterialDAO.getMaterialList()), "Metal", EnumStatusMaterial.DISPONIVEL, 1000.0);
        MaterialDAO.salvar(metal);
        Material outros = new Material(CalcularCodigo.calculaCodigo(MaterialDAO.getMaterialList()), "Outros", EnumStatusMaterial.DISPONIVEL, 1000.0);
        MaterialDAO.salvar(outros);
    }

    public static void StartReserva() {
        Reserva reserva1 = new Reserva(CalcularCodigo.calculaCodigo(ReservaDAO.getUsuarioReserva()), "Reserva1",LocalDate.now(), LocalDate.now() , LocalDate.now(), ClienteDAO.getClientes().get(0), EnumStatusReserva.ABERTO, MaterialDAO.getMaterialList().get(0), EspacoDAO.getEspacos().get(0), 10000.0);
        ReservaDAO.salvar(reserva1);
        Reserva reserva2 = new Reserva(CalcularCodigo.calculaCodigo(ReservaDAO.getUsuarioReserva()), "Reserva2",LocalDate.now(), LocalDate.now() , LocalDate.now(), ClienteDAO.getClientes().get(1), EnumStatusReserva.ABERTO, MaterialDAO.getMaterialList().get(1), EspacoDAO.getEspacos().get(1), 10000.0);
        ReservaDAO.salvar(reserva2);
        Reserva reserva3 = new Reserva(CalcularCodigo.calculaCodigo(ReservaDAO.getUsuarioReserva()), "Reserva3",LocalDate.now(), LocalDate.now() , LocalDate.now(), ClienteDAO.getClientes().get(2), EnumStatusReserva.ABERTO, MaterialDAO.getMaterialList().get(2), EspacoDAO.getEspacos().get(2), 10000.0);
        ReservaDAO.salvar(reserva3);
        Reserva reserva4 = new Reserva(CalcularCodigo.calculaCodigo(ReservaDAO.getUsuarioReserva()), "Reserva4",LocalDate.now(), LocalDate.now() , LocalDate.now(), ClienteDAO.getClientes().get(3), EnumStatusReserva.ABERTO, MaterialDAO.getMaterialList().get(3), EspacoDAO.getEspacos().get(3), 10000.0);
        ReservaDAO.salvar(reserva4);
        Reserva reserva5 = new Reserva(CalcularCodigo.calculaCodigo(ReservaDAO.getUsuarioReserva()), "Reserva5",LocalDate.now(), LocalDate.now() , LocalDate.now(), ClienteDAO.getClientes().get(4), EnumStatusReserva.ABERTO, MaterialDAO.getMaterialList().get(4), EspacoDAO.getEspacos().get(3), 10000.0);
        ReservaDAO.salvar(reserva5);
    }
}
