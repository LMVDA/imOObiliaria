import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import java.io.Serializable;

public class GeraImoobiliaria implements Serializable{
    private static String[] nomes = { "Aarao", "Abel", "Abilio", "Abraao", "Adalberto", "Adao", "Adelaide", "Adelia", "Adelio", "Adelina", "Adelino", "Aderito", "Adolfo", "Adosindo", "Adriana", "Adriano", "Afonso", "Agata", "Agostinho", "Aguinaldo", "Aida", "Aires", "Alarico", "Alberto", "Alberta", "Albino", "Alcides", "Alceste", "Alda", "Aldo", "Aldonca", "Aleixo", "Alexandra", "Alexandre", "Alfredo", "Alice", "Alicia", "Aline", "Alipio", "Almeno", "Almerinda", "Almor", "Aluisio", "Alvaro", "Alvito", "Alzira", "Amadeu", "Amalia", "Amanda", "Amelia", "Americo", "Amilcar", "Ana", "Anabela", "Anacleto", "Andre", "Andreia", "Angela", "Balduino", "Baltasar", "Barbara", "Barnabe", "Bartolomeu", "Beatriz", "Belchior", "Belmifer", "Belmiro", "Belmira", "Benedita", "Benedito", "Bento", "Berengaria", "Berengario", "Bernardete", "Bernardo", "Bernardina", "Bernardino", "Bibiana", "Blasco", "Lara", "Laura", "Laurinda", "Lazaro", "Leandro", "Jaime", "Jessica", "Jeremias", "Joana", "Joao", "Joaquim", "Joaquina", "Jeronimo", "Natividade", "Nazare", "Nelson", "Nestor", "Neusa", "Neuza", "Nicanor", "Nicolau", "Nicole", "Nidia", "Nilza", "Nivaldo", "Paulino", "Paula", "Paulo", "Paul", "Pedro", "Penelope", "Ramiro", "Raimundo", "Raquel", "Raul", "Rebeca", "Regina", "Telma", "Telmo", "Telo", "Teodorico", "Teodoro", "Teodora", "Tercio", "Teresa", "Tiago", "Valdemar", "Valentim", "Valentina", "Valeria", "Valerio", "Valmor", "Vanda", "Damiao", "Daniel", "Daniela", "Danilo", "David", "Diamantino", "Diana", "Diogo", "Vera" };
    private static String[] apelidos = { "Santiago", "Santos", "Saravia", "Sardinha", "Sarmento", "Sarmiento", "Seabra", "Seixas", "Semedo", "Sequeira", "Serpa", "Serralheiro", "Sesimbra", "Setœbal", "Severo", "Picanco", "Pimenta", "Pimentel", "Pinhal", "Pinheiro", "Pinho", "Pino", "Pinto", "Piteira", "Pires", "Pocas", "Pontes", "Portela", "Porto", "Puerto", "Portugal",  "Povoas", "Prada", "Prado", "Naves", "Nazario", "Negrao", "Negreiros", "Negromonte", "Neiva", "Neres", "Neto", "Maia", "Maior", "Mayor", "Malafaia", "Malheiro", "Malta", "Mangueira", "Mansilha", "Mantas", "Fonseca", "Fontes", "Fontoura", "Fortunato", "Frade", "Fraga", "Fragoso", "Franca", "Franco", "Freire", "Freire", "Freitas", "Campos" };
    private static String[] ruas = { "Ajuda", "Alcântara", "Alto Do Pina", "Alvalade", "Ameixoeira", "Anjos", "Beato", "Benfica", "Campo Grande", "Campolide", "Carnide	Castelo", "Charneca", "Coração De Jesus", "Encarnação", "Graça", "Lapa", "Lumiar", "Madalena", "Marvila", "Mártires", "Mercês", "Nossa Senhora De Fátima", "Pena", "Penha De França", "Prazeres", "Sacramento", "Santa Catarina", "Santa Engrácia", "Santa Isabel", "Santa Justa", "Santa Maria De Belém", "Santa Maria Dos Olivais", "Santiago", "Santo Condestável", "Santo Estêvão", "Santos-O-Velho", "São Cristóvão E São Lourenço", "São Domingos De Benfica", "São Francisco Xavier", "São João", "São João De Brito", "São João De Deus", "São Jorge De Arroios", "São José", "São Mamede", "São Miguel", "São Nicolau", "São Paulo", "São Sebastião Da Pedreira", "São Vicente De Fora", "Sé", "Socorro" };
    private static String[] datasNascimento = { "1946-10-10", "1947-10-07", "1951-07-02", "1952-01-28", "1952-10-13", "1953-07-08", "1956-07-27", "1957-02-03", "1958-11-22", "1959-12-26", "1960-09-30", "1961-06-17", "1966-05-22", "1969-12-12", "1970-08-16", "1975-03-26", "1975-09-12", "1979-06-13", "1980-05-07", "1981-11-02", "1982-06-24", "1985-03-12", "1987-08-05", "1988-01-13", "1989-02-16", "1950-01-23", "1950-05-15", "1950-07-11", "1950-09-18", "1952-10-17", "1956-11-25", "1957-02-11", "1957-12-01", "1964-02-04", "1964-12-14", "1965-01-05", "1965-11-09", "1967-12-25", "1969-04-16", "1971-09-10", "1971-12-05", "1974-06-18", "1974-12-17", "1980-08-27", "1981-07-07", "1987-05-06", "1988-04-26", "1990-08-12", "1991-02-13", "1991-05-07", "1948-02-01", "1948-08-04", "1950-02-04", "1951-07-04", "1955-08-01", "1957-08-24", "1958-01-10", "1960-04-20", "1964-09-23", "1965-08-15", "1968-01-19", "1969-12-21", "1970-02-26", "1970-04-22", "1971-10-02", "1973-02-20", "1973-05-19", "1973-11-16", "1974-05-29", "1975-04-15", "1977-05-13", "1979-06-21", "1981-06-25", "1987-11-27", "1989-03-01", "1946-10-15", "1949-05-09", "1952-02-28", "1953-04-07", "1956-10-28", "1958-10-23", "1959-10-03", "1961-01-23", "1961-11-19", "1961-12-07", "1966-04-01", "1966-07-10", "1968-02-22", "1968-02-29", "1970-10-25", "1972-05-01", "1972-08-22", "1973-03-16", "1973-10-17", "1975-03-20", "1977-06-17", "1983-10-04", "1988-04-02", "1989-11-16", "1992-12-25" };
    private static String[] tiposNegocio = { "Mercearia", "Roupa", "Ferragem" };
    private static Random random = new Random();
    private static LocalDateTime instanteAgora = LocalDateTime.now();
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static Imoobiliaria geraImoobiliaria() {
        Imoobiliaria imoobiliaria = new Imoobiliaria();

        List<Utilizador> utilizadores = geraUtilizadores();
        List<Imovel> imoveis = geraImoveisComVendedoresEConsultas(utilizadores);

        // Gera favoritos compradores
        for (Utilizador u : utilizadores) {
            if (u instanceof Comprador) {
                Comprador c = (Comprador) u;

                int nrFavoritos = randomIntBetween(2, 7);

                for (int i = 0; i < nrFavoritos; i++) {
                    int imovelPos = randomIntBetween(0, imoveis.size());

                    c.adicionaFavorito(imoveis.get(imovelPos).getCodigo());
                }
            }
        }

        Map<String, Utilizador> utilizadoresMap = new TreeMap<String, Utilizador>();
        Map<String, Imovel> imoveisMap = new TreeMap<String, Imovel>();


        for (Utilizador u : utilizadores) {
            utilizadoresMap.put(u.getEmail(), u);
        }

        for (Imovel i : imoveis) {
            imoveisMap.put(i.getCodigo(), i);
        }

        imoobiliaria.setUtilizadores(utilizadoresMap);
        imoobiliaria.setImoveis(imoveisMap);

        return imoobiliaria;
    }


    private static List<Utilizador> geraUtilizadores() {
        int nrCompradoresAGerar = randomIntBetween(25, 40);
        int nrVendedoresAGerar = randomIntBetween(10, 20);
        List<Utilizador> utilizadores = new ArrayList<Utilizador>();

        for (int i = 0; i < nrCompradoresAGerar; i++) {
            utilizadores.add(geraComprador(i));
        }

        for (int i = 0; i < nrVendedoresAGerar; i++) {
            utilizadores.add(geraVendedor(i));
        }

        return utilizadores;
    }

    private static List<Imovel> geraImoveis() {
        int nrMoradiasAGerar = randomIntBetween(25, 40);
        int nrApartamentosAGerar = randomIntBetween(40, 70);
        int nrLojasAGerar = randomIntBetween(15, 25);
        int nrLojasComApartamentoAGerar = randomIntBetween(5, 15);
        int nrTerrenosAGerar = randomIntBetween(20, 30);
        List<Imovel> imoveis = new ArrayList<Imovel>();
        int totalImoveis = 0;

        for (int i = 0; i < nrMoradiasAGerar; i++) {
            totalImoveis++;
            imoveis.add(geraMoradia(totalImoveis));
        }

        for (int i = 0; i < nrApartamentosAGerar; i++) {
            totalImoveis++;
            imoveis.add(geraApartamento(totalImoveis));
        }

        for (int i = 0; i < nrLojasAGerar; i++) {
            totalImoveis++;
            imoveis.add(geraLoja(totalImoveis));
        }

        for (int i = 0; i < nrLojasComApartamentoAGerar; i++) {
            totalImoveis++;
            imoveis.add(geraLojaComApartamento(totalImoveis));
        }

        for (int i = 0; i < nrTerrenosAGerar; i++) {
            totalImoveis++;
            imoveis.add(geraTerreno(totalImoveis));
        }

        return imoveis;
    }

    private static List<Imovel> geraImoveisComVendedoresEConsultas(List<Utilizador> utilizadores) {
        List<Utilizador> compradores = new ArrayList<Utilizador>();
        List<Utilizador> vendedores = new ArrayList<Utilizador>();
        List<Imovel> imoveis = geraImoveis();

        for (Utilizador u : utilizadores) {
            if (u instanceof Comprador) compradores.add(u);
            else if (u instanceof Vendedor) vendedores.add(u);
        }

        // Gerar vendedores aleatorios para o imovel
        for (Imovel i : imoveis) {
            int vendedorPos = randomIntBetween(0, vendedores.size());

            Vendedor vendedor = (Vendedor) vendedores.get(vendedorPos);
            i.setVendedor(vendedor.getEmail());
            vendedor.addImovelVenda(i.getCodigo());
        }

        // Gerar consultas para cada imovel
        for (Imovel i : imoveis) {
            int nrConsultas = randomIntBetween(5, 20);
            List<Consulta> consultas = new ArrayList<Consulta>();

            for (int j = 0; j < nrConsultas; j++) {
                boolean consultaAnonima = random.nextBoolean();
                int compradorPos = randomIntBetween(0, compradores.size());

                String email = consultaAnonima ? "" : compradores.get(compradorPos).getEmail();
                Consulta c = geraConsulta(email);
                consultas.add(c);
            }

            i.setConsultas(consultas);
        }

        return imoveis;
    }

    private static Vendedor geraVendedor(int n) {
        String email = geraEmail("v", "vendedores", n);
        String nome = geraNome();
        String password = "1234";
        String morada = geraRua();
        LocalDate dataNascimento = geraDataNascimento();

        Vendedor v = new Vendedor(email, nome, password, morada, dataNascimento);

        return v;
    }

    private static Comprador geraComprador(int n) {
        String email = geraEmail("c", "compradores", n);
        String nome = geraNome();
        String password = "1234";
        String morada = geraRua();
        LocalDate dataNascimento = geraDataNascimento();

        Comprador c = new Comprador(email, nome, password, morada, dataNascimento);

        return c;
    }

    private static Moradia geraMoradia(int n) {
        String rua = geraRua();
        int precoMin = randomIntBetween(100000, 250000);
        int precoPedido = randomIntBetween(precoMin, precoMin + 20000);
        EstadoImovel estadoImovel = EstadoImovel.VENDA;
        TipoMoradia tipoMoradia = geraTipoMoradia();
        int areaCoberta = randomIntBetween(100, 300);
        int areaImplantacao = randomIntBetween((int) areaCoberta, (int) areaCoberta + 75);
        int areaTerrenoEnvolvente = randomIntBetween(100, 300);
        int numeroQuartos = randomIntBetween(0, 7);
        int numeroWCs = randomIntBetween(1, 4);
        int numPorta = randomIntBetween(1, 100);
        int anoConstrucao = randomIntBetween(1975, 2015);
        TipoAquecimento tipoAquecimento = geraTipoAquecimento();

        Moradia m = new Moradia("Imovel"+n, rua, precoPedido, precoMin, estadoImovel, tipoMoradia, areaImplantacao, areaCoberta, areaTerrenoEnvolvente, numeroQuartos, numeroWCs, numPorta, anoConstrucao, tipoAquecimento);

        return m;
    }

    private static Apartamento geraApartamento(int n) {
        String rua = geraRua();
        int precoMin = randomIntBetween(45000, 250000);
        int precoPedido = randomIntBetween(precoMin, precoMin + 20000);
        EstadoImovel estadoImovel = EstadoImovel.VENDA;
        TipoApartamento tipoApartamento = geraTipoApartamento();
        int areaTotal = randomIntBetween(40, 300);
        int numeroQuartos = randomIntBetween(0, 7);
        int numeroWCs = randomIntBetween(1, 5);
        int numPorta = randomIntBetween(1, 100);
        int numAndar = randomIntBetween(0, 13);
        int anoConstrucao = randomIntBetween(1975, 2015);
        TipoAquecimento tipoAquecimento = geraTipoAquecimento();
        boolean garagem = random.nextBoolean();
        int areaGaragem = garagem ? randomIntBetween(20, 60) : 0;

        Apartamento a = new Apartamento("Imovel"+n, rua, precoPedido, precoMin, estadoImovel, tipoApartamento, areaTotal, numeroQuartos, numeroWCs, numPorta, numAndar, anoConstrucao,tipoAquecimento, garagem, areaGaragem);

        return a;
    }

    private static Loja geraLoja(int n) {
        String rua = geraRua();
        int precoMin = randomIntBetween(80000, 250000);
        int precoPedido = randomIntBetween(precoMin, precoMin + 20000);
        EstadoImovel estadoImovel = EstadoImovel.VENDA;
        int area = randomIntBetween(150, 500);
        boolean wc = random.nextBoolean();
        String tipoNegocio = geraTipoNegocio();
        int numPorta = randomIntBetween(1, 100);
        int anoConstrucao = randomIntBetween(1975, 2015);

        Loja loja = new Loja("Imovel"+n, rua, precoMin, precoPedido, estadoImovel, area, wc, tipoNegocio, numPorta, anoConstrucao);

        return loja;
    }

    private static LojaComApartamento geraLojaComApartamento(int n) {
        String rua = geraRua();
        int precoMin = randomIntBetween(80000, 250000);
        int precoPedido = randomIntBetween(precoMin, precoMin + 20000);
        EstadoImovel estadoImovel = EstadoImovel.VENDA;
        int area = randomIntBetween(150, 500);
        boolean wc = random.nextBoolean();
        String tipoNegocio = geraTipoNegocio();
        int numPorta = randomIntBetween(1, 100);
        int anoConstrucao = randomIntBetween(1975, 2015);
        Apartamento a = geraApartamento(n);

        LojaComApartamento lA = new LojaComApartamento("Imovel"+n, rua, precoMin, precoPedido, estadoImovel, area, wc, tipoNegocio, numPorta, anoConstrucao, a);

        return lA;
    }

    private static Terreno geraTerreno(int n) {
        String rua = geraRua();
        int precoMin = randomIntBetween(20000, 250000);
        int precoPedido = randomIntBetween(precoMin, precoMin + 20000);
        EstadoImovel estadoImovel = EstadoImovel.VENDA;
        int areaDisponivel = randomIntBetween(150, 500);
        TipoTerreno tipoTerreno = geraTipoTerreno();
        int diametroCanalizacoes = randomIntBetween(25, 40);
        boolean redeElectricaInstalada = random.nextBoolean();
        int potenciaMaxima = redeElectricaInstalada ? randomIntBetween(150, 220) : 0;
        boolean redeEsgotos = random.nextBoolean();

        Terreno t = new Terreno("Imovel"+n, rua, precoMin, precoPedido, estadoImovel, areaDisponivel, tipoTerreno, diametroCanalizacoes, redeElectricaInstalada, potenciaMaxima, redeEsgotos);

        return t;
    }

    private static String geraEmail(String prefix, String suffix, int n) {
        return prefix + n + "@" + suffix + ".com";
    }

    private static String geraNome() {
        return nomes[random.nextInt(nomes.length)] + " " + apelidos[random.nextInt(apelidos.length)];
    }

    private static LocalDate geraDataNascimento() {
        String dataNascimento = datasNascimento[random.nextInt(datasNascimento.length)];

        return LocalDate.parse(dataNascimento, DATE_FORMAT);
    }

    private static String geraRua() {
        return ruas[random.nextInt(ruas.length)];
    }

    private static TipoMoradia geraTipoMoradia() {
        TipoMoradia[] tiposMoradia = { TipoMoradia.BANDA, TipoMoradia.GAVETO, TipoMoradia.GEMINADA, TipoMoradia.ISOLADA };

        return tiposMoradia[random.nextInt(tiposMoradia.length)];
    }

    private static TipoAquecimento geraTipoAquecimento() {
        TipoAquecimento[] tiposAquecimento = { TipoAquecimento.AQUECIMENTO_CENTRAL, TipoAquecimento.AR_CONDICIONADO, TipoAquecimento.NENHUM, TipoAquecimento.PISO_RADIANTE };

        return tiposAquecimento[random.nextInt(tiposAquecimento.length)];
    }

    private static TipoApartamento geraTipoApartamento() {
        TipoApartamento[] tiposApartamento = { TipoApartamento.SIMPLES, TipoApartamento.DUPLEX, TipoApartamento.TRIPLEX };

        return tiposApartamento[random.nextInt(tiposApartamento.length)];
    }

    private static String geraTipoNegocio() {
        return tiposNegocio[random.nextInt(tiposNegocio.length)];
    }

    private static TipoTerreno geraTipoTerreno() {
        TipoTerreno[] tiposTerreno = { TipoTerreno.ARMAZEM, TipoTerreno.HABITACAO };

        return tiposTerreno[random.nextInt(tiposTerreno.length)];
    }

    private static Consulta geraConsulta(String email) {
        LocalDateTime dataConsulta = geraLocalDateTime();

        Consulta c = new Consulta(email, dataConsulta);

        return c;
    }

    private static LocalDateTime geraLocalDateTime() {
        int diferencaEntreTempoActualeDataEmSegundos = randomIntBetween(1, 2000);

        LocalDateTime localDateTime = instanteAgora;

        localDateTime = localDateTime.minus(diferencaEntreTempoActualeDataEmSegundos, ChronoUnit.SECONDS);

        return localDateTime;
    }

    private static int randomIntBetween(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    private static double randomDoubleBetween(int min, int max) {
        return min + (max - min) * random.nextDouble();
    }
}
