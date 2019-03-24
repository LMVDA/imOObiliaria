
/**
 * Write a description of class App here.
 *
 * @author G23
 * @version 16/05/2016
 */

import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.Set;
import java.util.InputMismatchException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.IOException;

public class App implements Serializable{
    private static Imoobiliaria imoobiliaria;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
    private static Scanner read = new Scanner(System.in);


    public static void menu(){
        //System.out.print('\u000C');
        System.out.println("\n *** Seja Bem-vindo(a) à ImOObiliaria. ***\n");
        System.out.println("\t 1. Iniciar sessão. \n");
        System.out.println("\t 2. Registar. \n");
        System.out.println("\t 3. Consultar a lista de todos os imóveis de um dado tipo e até um determinado preço. \n");
        System.out.println("\t 4. Consultar todos os imóveis habitáveis até um determinado preço. \n");
        System.out.println("\t 5. Consultar todos os imóveis de uma determinada tipologia (T1, T2, T3, etc). \n");
        System.out.println("\t 6. Mapeamento entre imóveis e o respectivo vendedor. \n");
        System.out.println("\t 7. Pesquisar um imóvel. \n");
        System.out.println("\t 8. Sair do programa. \n");
        System.out.println("\t Selecione a opção que deseja.\n");
    }

    public static void sessaoComprador(){
        System.out.println("\n *** Página inicial do Comprador ***\n");
        System.out.println("\t 1. Consultar a lista de todos os imóveis de um dado tipo e até um determinado preço. \n");
        System.out.println("\t 2. Consultar todos os imóveis habitáveis até um determinado preço. \n");
        System.out.println("\t 3. Consultar todos os imóveis de uma determinada tipologia (T1, T2, T3, etc). \n");
        System.out.println("\t 4. Mapeamento entre imóveis e o respectivo vendedor. \n");
        System.out.println("\t 5. Pesquisar um imóvel. \n");
        System.out.println("\t 6. Marcar um imóvel como favorito. \n");
        System.out.println("\t 7. Consultar os imóveis favoritos. \n");
        System.out.println("\t 8. Desmarcar um imóvel como favorito. \n");
        System.out.println("\t 9. Consultar dados pessoais. \n");
        System.out.println("\t 10. Alterar dados pessoais. \n");
        System.out.println("\t 11. Terminar sessão. \n");
        System.out.println("\t Selecione a opção que deseja.\n");
    }

    public static void sessaoVendedor(){
        System.out.println("\n *** Página inicial do Vendedor ***\n");
        System.out.println("\t 1. Consultar a lista de todos os imóveis de um dado tipo e até um determinado preço. \n");
        System.out.println("\t 2. Consultar todos os imóveis habitáveis até um determinado preço. \n");
        System.out.println("\t 3. Consultar todos os imóveis de uma determinada tipologia (T1, T2, T3, etc). \n");
        System.out.println("\t 4. Mapeamento entre imóveis e o respectivo vendedor. \n");
        System.out.println("\t 5. Pesquisar um imóvel. \n");
        System.out.println("\t 6. Consultas (abre novo menú). \n");
        System.out.println("\t 7. Adicionar um imóvel. \n");
        System.out.println("\t 8. Alterar o estado de um imóvel para [Vendido / Reservado / Para Venda]. \n");
        System.out.println("\t 9. Registar a venda de um imóvel. \n");
        System.out.println("\t 10. Remover um imóvel. \n");
        System.out.println("\t 11. Alterar dados pessoais. \n");
        System.out.println("\t 12. Leiloar imóvel. \n");
        System.out.println("\t 13. Terminar sessão. \n");
        System.out.println("\t Selecione a opção que deseja.\n");
    }

    public static void menuConsultasVendedor(){
        System.out.println("\n *** Menú de Consultas ***\n");
        System.out.println("\t 1. Consultar as 10 últimas consultas dos imóveis que tem para venda. \n");
        System.out.println("\t 2. Consultar os imóveis mais consultados. \n");
        System.out.println("\t 3. Consultar as estatísticas. \n");
        System.out.println("\t 4. Consulta de portfolio de imóveis em venda. \n");
        System.out.println("\t 5. Consulta de histórico de imóveis vendidos. \n");
        System.out.println("\t 6. Voltar ao menu anterior. \n");
    }

    public static void menuEstatisticas(){
        System.out.println("\n *** Menú de Estatísticas ***\n");
        System.out.println("\t 1. Número de imóveis vendidos. \n");
        System.out.println("\t 2. Número de imóveis para venda (e desses quais estão reservados). \n");
        System.out.println("\t 3. Número de anúncios criados. \n");
        System.out.println("\t 4. Número de visualizações dos anúncios. \n");
        System.out.println("\t 5. Voltar ao menu anterior. \n");
    }

    /** --------------------------------------------------------- Métodos Iniciais --------------------------------------------------------- **/



    /** Método que inicia a sessão. **/
    public static void iniciarSessao() {
        System.out.println("Insira o seu email:");
        String email = read.nextLine();

        System.out.println("Insira a sua password:");
        String password = read.nextLine();

        try {
            imoobiliaria.iniciaSessao(email, password);

            System.out.println ("A sua sessão foi iniciada com sucesso.\n");

            String tipoUtilizador = imoobiliaria.getTipoUtilizadorAuntenticado();

            if (tipoUtilizador.equals("Comprador")) sessaoCompradorEscolha();
            else sessaoVendedorEscolha();

        } catch (SemAutorizacaoException e) {
            System.out.println("\n As informações que introduziu não estão correctas!\n");
        }
    }

    private static void sessaoCompradorEscolha() {
        String opcao;

        boolean sairSessaoComprador = false;
        System.out.print('\u000C');

        try {
            do{
                sessaoComprador();
                opcao = read.nextLine();
                switch(opcao){
                    case "1":
                        consultarImoveisTipoPreco();
                        break;
                    case "2":
                        consultarImoveisHabitaveis();
                        break;
                    case "3":
                        consultarImoveisTipologia();
                        break;
                    case "4":
                        mapeamentoImoveis();
                        break;
                    case "5":
                        pesquisaImovel();
                        break;
                    case "6":
                        marcarFavorito();
                        break;
                    case "7":
                        consultaFavoritos();
                        break;
                    case "8":
                        desmarcarFavorito();
                        break;
                    case "9":
                        consultaDadosPessoais();
                        break;
                    case "10":
                        alteraDadosPessoais();
                        break;
                    case "11":
                        terminaSessao();
                        sairSessaoComprador = true;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } while(!sairSessaoComprador);
        }
        catch (SemAutorizacaoException e) {
            System.out.println("Não tem autorização para efectuar o pedido. A sessão será terminada automáticamente\n");
            terminaSessao();
        }
    }

    private static void sessaoVendedorEscolha() {
        String opcao;

        boolean sairSessaoVendedor = false;
        System.out.print('\u000C');

        try {
            do {
                sessaoVendedor();
                opcao = read.nextLine();
                switch (opcao) {
                    case "1":
                        consultarImoveisTipoPreco();
                        break;
                    case "2":
                        consultarImoveisHabitaveis();
                        break;
                    case "3":
                        consultarImoveisTipologia();
                        break;
                    case "4":
                        mapeamentoImoveis();
                        break;
                    case "5":
                        pesquisaImovel();
                        break;
                    case "6":
                        consultasVendedor();
                        break;
                    case "7":
                        adicionaImovel();
                        break;
                    case "8":
                        alteraEstadoImovel();
                        break;
                    case "9":
                        registaVendaImovel();
                        break;
                    case "10":
                        removeImovel();
                        break;
                    case "11":
                        alteraDadosPessoais();
                        break;
                    case "12":
                        iniciaLeilao();
                        break;
                    case "13":
                        terminaSessao();
                        sairSessaoVendedor = true;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } while (!sairSessaoVendedor);
        }
        catch (SemAutorizacaoException e) {
            System.out.println("Não tem autorização para efectuar o pedido. A sessão será terminada automáticamente\n");
            terminaSessao();
        }
    }

    /** Método que regista um novo utilizador. **/
    public static boolean registarConta(){
        Utilizador novo = null;

        System.out.println("\n Deseja criar uma conta de comprador ou vendedor?\n 1 - Comprador \n 2 - Vendedor\n");
        String opcao = read.nextLine();

        if (!opcao.equals("1") && !opcao.equals("2")) {
            System.out.println ("\n Opção inválida");
            return false;
        }

        if(opcao.equals("1")) {
            System.out.println("\n Insira o seu email:\n");
            String email = read.nextLine();

            System.out.println ("\n Insira a sua password.\n");
            String password = read.nextLine();
            System.out.println ("\n Insira o seu nome.\n");
            String nome = read.nextLine();
            System.out.println ("\n Insira a sua morada.\n");
            String morada = read.nextLine();
            LocalDate dataNascimento = pedeDataValida("\n Insira a sua data de nascimento.(dd/mm/aaaa)\n");

            novo = new Comprador(email, nome, password, morada, dataNascimento);
        }
        else if(opcao.equals("2")) {
            System.out.println("\n Insira o seu email:\n");
            String email = read.nextLine();

            System.out.println ("\n Insira a sua password.\n");
            String password = read.nextLine();
            System.out.println ("\n Insira o seu nome.\n");
            String nome = read.nextLine();
            System.out.println ("\n Insira a sua morada.\n");
            String morada = read.nextLine();
            LocalDate dataNascimento = pedeDataValida("\n Insira a sua data de nascimento.(dd/mm/aaaa)\n");

            novo = new Vendedor(email, nome, password, morada, dataNascimento);
        }

        try {
            imoobiliaria.registarUtilizador(novo);
            System.out.println ("\n A sua conta foi criada com sucesso.");

        } catch (UtilizadorExistenteException e) {
            System.out.println ("\n Não foi possível criar a sua conta. Utilizador já existente");
        }

        return true;
    }



    /** --------------------------------------------------------- Métodos comuns --------------------------------------------------------- **/

    /** Método que consulta a lista de todos os imóveis de um dado tipo e até um determinado preço. **/
    public static void consultarImoveisTipoPreco(){
        System.out.println("Que tipo de imóveis deseja consultar?\n 1 - Moradia \n 2 - Apartamento \n 3 - Loja \n 4 - Terreno\n");
        String opcao = read.nextLine();
        String tipo = "";
        boolean valido = true;

        switch (opcao) {
            case "1":
                tipo = "Moradia";
                break;
            case "2":
                tipo = "Apartamento";
                break;
            case "3":
                tipo = "Loja";
                break;
            case "4":
                tipo = "Terreno";
                break;
            default:
                System.out.println("Opção inválida");
                valido = false;
                break;
        }

        if (valido == true) {
            int preco = pedeIntValido("Diga qual o preço máximo dos imóveis que deseja consultar.");
            String lixo = read.nextLine();

            List<Imovel> imoveis = imoobiliaria.getImovel(tipo, preco);

            if (imoveis.size() > 0) {
                for (Imovel i : imoveis) {
                    System.out.println(i.toString());
                }
            }
            else {
                System.out.println("\nNão existem imóveis que correspondam aos critérios escolhidos.");
            }

            primaEnter();
        }
    }

    /** Método que consulta todos os imóveis habitáveis até um determinado preço. **/
    public static void consultarImoveisHabitaveis(){
        int preco = pedeIntValido("Diga qual o preço máximo dos imóveis habitáveis que deseja consultar.");
        String lixo = read.nextLine();

        List<Habitavel> imoveis = imoobiliaria.getHabitaveis(preco);

        if (imoveis.size() > 0) {
            imoveis.forEach(i -> System.out.println(((Imovel) i).toString()));
        }
        else {
            System.out.println("\nNão existem imóveis que correspondam aos critérios escolhidos.");
        }

        primaEnter();
    }

    /** Método que consulta os imóveis de uma determinada tipologia. **/
    public static void consultarImoveisTipologia(){
        int numQuartos = pedeIntValido("Que tipo de imóveis deseja consultar? \n Exemplo: T3 possui 3 quartos. \n Insira o número de quartos:");
        String lixo = read.nextLine();

        List<Habitavel> imoveis = imoobiliaria.getImoveisTipologia(numQuartos);

        if (imoveis.size() > 0) {
            imoveis.forEach(i -> System.out.println(((Imovel) i).toString()));
        }
        else {
            System.out.println("\nNão existem imóveis que correspondam aos critérios escolhidos.");
        }

        primaEnter();
    }

    /** Método que faz o Mapeamento entre imóveis e o respectivo vendedor. **/
    public static void mapeamentoImoveis(){
        Map<Imovel, Vendedor> mapeamento = imoobiliaria.getMapeamentoImoveis();

        if (mapeamento.size() > 0) {
            for(Map.Entry<Imovel, Vendedor> dupla : mapeamento.entrySet()){
                Imovel imovel = dupla.getKey();
                Vendedor vendedor = dupla.getValue();
                System.out.println("O Vendedor:\n" + vendedor.toStringSimples() + "Possui o Imovel:\n " + imovel.toString() + "\n");
            }
        }
        else {
            System.out.println("\t Não existem mapeamentos disponíveis");
        }

        primaEnter();
    }

    /** Método que pesquisa um imóvel. **/
    public static void pesquisaImovel(){
        System.out.println("Diga qual o código do imóvel que deseja pesquisar:");
        String cod = read.nextLine();

        try {
            Imovel imovel = imoobiliaria.pesquisarImovel(cod);

            System.out.println(imovel.toString());
        } catch (ImovelInexistenteException e) {
            System.out.println(e.getMessage());
        }

        primaEnter();
    }

    /**
     * Método que consulta os dados pessoais
     */
    public static void consultaDadosPessoais() {
        Utilizador utilizador = imoobiliaria.getUtilizadorAutenticadoCompleto();

        System.out.println("\n Dados pessoais:");
        System.out.println(utilizador);

        primaEnter();
    }

    /** Método que altera os dados pessoais. **/ // TODO: NAO PODE MUDAR O EMAIL -> colocar no relatorio
    public static void alteraDadosPessoais(){
        String opcao = "";
        boolean valido = true;

        do {
            System.out.println("\n Qual o dado pessoal que deseja alterar?");
            System.out.println("\n 1 - Nome \n 2 - Password \n 3 - Morada \n 4 - Data de nascimento (mm/dd/aaaa)\n");
            opcao = read.nextLine();

            valido = true;

            switch (opcao) {
                case "1":
                    System.out.println("\n Insira o novo nome:");
                    String nome = read.nextLine();
                    imoobiliaria.mudarNome(nome);
                    break;
                case "2":
                    System.out.println("\n Insira a nova password:");
                    String password = read.nextLine();
                    imoobiliaria.mudarPassword(password);
                    break;
                case "3":
                    System.out.println("\n Insira a nova morada:");
                    String morada = read.nextLine();
                    imoobiliaria.mudarMorada(morada);
                    break;
                case "4":
                    LocalDate dataNascimento = pedeDataValida("Insira a sua data de nascimento.(dd/mm/aaaa)");
                    imoobiliaria.mudarDataDeNascimento(dataNascimento);
                    break;
                default:
                    valido = false;
                    System.out.println("Opção inválida.\n");
                    break;
            }
        } while(valido == false);

        System.out.println("\n Os seus dados pessoais foram alterados com sucesso!");

        primaEnter();
    }

    /** Método que termina a sessão **/
    public static void terminaSessao(){
        imoobiliaria.fechaSessao();
        System.out.println("\n A sua sessão foi terminada com sucesso! \n");
    }

    /** Método que sai do programa **/
    public static void sairPrograma(){
        //VAI SER PRECISO FAZER???
    }

    /** --------------------------------------------------------- Métodos Comprador --------------------------------------------------------- **/

    /** Método que marca um imóvel como favorito. **/
    public static void marcarFavorito() throws SemAutorizacaoException {
        System.out.println(" Insira o codigo do imovel que deseja marcar como favorito:");
        String codigo = read.nextLine();

        try {
            imoobiliaria.setFavorito(codigo);

            System.out.println("\n O imóvel " + codigo + " foi marcado como favorito com sucesso!");
        } catch (ImovelInexistenteException e) {
            System.out.println(e.getMessage());
        }

        primaEnter();
    }

    /** Método que consulta os imóveis favoritos. **/
    public static void consultaFavoritos() throws SemAutorizacaoException {
        TreeSet<Imovel> imoveis = imoobiliaria.getFavoritos();

        if (imoveis.size() > 0) {
            System.out.println("\n O conjunto dos seus imóveis favoritos é:\n");
            imoveis.forEach(i -> System.out.println(i.toString()));
        }
        else {
            System.out.println(" Não contém imóveis favoritos.");
        }

        primaEnter();
    }

    /** Método que desmarca um imóvel como favorito. **/
    public static void desmarcarFavorito() throws SemAutorizacaoException {
        System.out.println("Insira o codigo do imovel que deseja desmarcar como favorito:");
        String codigo = read.nextLine();

        try {
            imoobiliaria.desmarcaFavorito(codigo);
            System.out.println("O seu imóvel foi desmarcado dos favoritos com sucesso!");
        } catch (ImovelInexistenteException e) {
            System.out.println(e.getMessage());
        }

        primaEnter();
    }

    /** --------------------------------------------------------- Métodos Vendedor --------------------------------------------------------- **/

    /** Método que chama o menú de consultas **/
    public static void consultasVendedor() throws SemAutorizacaoException {
        String opcao;

        boolean sairMenuConsultas = false;

        System.out.print('\u000C');
        do{
            menuConsultasVendedor();
            opcao = read.nextLine();
            switch(opcao){
                case "1":
                    ultimasConsultas();
                    break;
                case "2":
                    consultaImoveisConsultados();
                    break;
                case "3":
                    consultaEstatisticas();
                    break;
                case "4":
                    consultaPortfolio();
                    break;
                case "5":
                    consultaHistorico();
                    break;
                case "6":
                    sairMenuConsultas = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while(!sairMenuConsultas);
    }

    /** Método que adiciona um imóvel. **/
    public static void adicionaImovel() throws SemAutorizacaoException {
        Imovel novo = null;
        String lixo;

        System.out.println("\n *** Adicionar um Imóvel *** :\n");

        System.out.println (" Insira o código do imovel:");
        String codigo = read.nextLine();

        System.out.println (" Insira a rua do imovel:");
        String rua = read.nextLine();

        int precoPedido = pedeIntValido(" Insira o preço pedido do seu imovel.");
        lixo = read.nextLine();

        int precoMin = pedeIntValido(" Insira o preço mínimo do seu imovel.");
        lixo = read.nextLine();

        EstadoImovel estado = EstadoImovel.VENDA;

        System.out.println (" Que tipo de Imovel deseja adicionar? [Moradia, Apartamento, Loja, Terreno]");
        System.out.println(" 1 - Moradia \n 2 - Apartamento \n 3 - Loja \n 4 - Terreno");
        String resposta = read.nextLine();
        boolean valido = true;

        if(resposta.equals("1")) {
            System.out.println("\n Insira o tipo da moradia:");
            System.out.println(" 1 - Isolada \n 2 - Geminada \n 3 - Banda \n 4 - Gaveto");
            String x = read.nextLine();
            TipoMoradia tipo;

            if (x.equals("1")) { tipo = TipoMoradia.ISOLADA; }
            else if (x.equals("2")) { tipo = TipoMoradia.GEMINADA; }
            else if (x.equals("3")) { tipo = TipoMoradia.BANDA; }
            else { tipo = TipoMoradia.GAVETO; }

            int areaImplantacao = pedeIntValido("\n Insira a area de Implantação:");
            lixo = read.nextLine();

            int areaTotalCoberta = pedeIntValido("\n Insira a area Total Coberta:");
            lixo = read.nextLine();

            int areaTerrenoEnvolvente = pedeIntValido("\n Insira a area de Terreno Envolvente:");
            lixo = read.nextLine();

            int numQuartos = pedeIntValido("\n Insira o numero de quartos.");
            lixo = read.nextLine();

            int numWCs = pedeIntValido("\n Insira o numero de WCs.");
            lixo = read.nextLine();

            int numPorta = pedeIntValido("\n Insira o numero da porta.");
            lixo = read.nextLine();

            int anoConstrucao = pedeIntValido("\n Insira o ano de construção.");
            lixo = read.nextLine();

            System.out.println(" Insira o tipo de aquecimento");
            System.out.println(" 1 - Ar Condicionado \n 2 - Piso Radiante \n 3 - Aquecimento Central \n 4 - Nenhum");
            String y = read.nextLine();

            TipoAquecimento tipoAquecimento;

            if (y.equals("1")) { tipoAquecimento = TipoAquecimento.AR_CONDICIONADO; }
            else if (y.equals("2")) { tipoAquecimento = TipoAquecimento.PISO_RADIANTE; }
            else if (y.equals("3")) { tipoAquecimento = TipoAquecimento.AQUECIMENTO_CENTRAL; }
            else { tipoAquecimento = TipoAquecimento.NENHUM; }

            novo = new Moradia(codigo, rua, precoPedido, precoMin, estado, tipo, areaImplantacao, areaTotalCoberta, areaTerrenoEnvolvente, numQuartos, numWCs, numPorta, anoConstrucao, tipoAquecimento);
        }
        else if(resposta.equals("2")) {
            System.out.println("\n Insira o tipo de apartamento:");
            System.out.println(" 1 - Simplex \n 2 - Duplex \n 3 - Triplex");
            String x = read.nextLine();

            TipoApartamento tipo;

            if (x.equals("1")) { tipo = TipoApartamento.SIMPLES; }
            else if (x.equals("2")) { tipo = TipoApartamento.DUPLEX; }
            else { tipo = TipoApartamento.TRIPLEX; }

            int areaTotal = pedeIntValido("\n Insira a area Total:");
            lixo = read.nextLine();

            int numQuartos = pedeIntValido("\n Insira o numero de quartos.");
            lixo = read.nextLine();

            int numWCs = pedeIntValido("\n Insira o numero de WCs.");
            lixo = read.nextLine();

            int numPorta = pedeIntValido("\n Insira o numero da porta.");
            lixo = read.nextLine();

            int numAndar = pedeIntValido("\n Insira o numero do andar.");
            lixo = read.nextLine();

            int anoConstrucao = pedeIntValido("\n Insira o ano de construção.");
            lixo = read.nextLine();

            System.out.println("\n Insira o tipo de aquecimento\n");
            System.out.println(" 1 - Ar Condicionado \n 2 - Piso Radiante \n 3 - Aquecimento Central \n 4 - Nenhum");
            String y = read.nextLine();

            TipoAquecimento tipoAquecimento;

            if (y.equals("1")) { tipoAquecimento = TipoAquecimento.AR_CONDICIONADO; }
            else if (y.equals("2")) { tipoAquecimento = TipoAquecimento.PISO_RADIANTE; }
            else if (y.equals("3")) { tipoAquecimento = TipoAquecimento.AQUECIMENTO_CENTRAL; }
            else { tipoAquecimento = TipoAquecimento.NENHUM; }

            System.out.println ("\n O apartamento possui Garagem?\n");
            System.out.println(" 1 - Sim \n 2 - Não \n ");
            String z = read.nextLine();

            boolean garagem;

            if (z.equals("1")) { garagem = true; }
            else { garagem = false; }

            int areaGaragem = pedeIntValido("\n Qual a área da Garagem?\n");
            lixo = read.nextLine();

            novo = new Apartamento(codigo, rua, precoPedido, precoMin, estado, tipo, areaTotal, numQuartos, numWCs, numPorta, numAndar, anoConstrucao, tipoAquecimento, garagem, areaGaragem);
        }
        else if(resposta.equals("3")) {
            int area = pedeIntValido("\n Insira a area da Loja:");
            lixo = read.nextLine();

            System.out.println ("\n A Loja possui WC?");
            System.out.println(" 1 - Sim \n 2 - Não");
            String z = read.nextLine();

            boolean wc;

            if (z.equals("1")) { wc = true; }
            else { wc = false; }

            System.out.println("\n Insira o tipo de negócio da Loja");
            String negocio = read.nextLine();

            int numPorta = pedeIntValido("\n Insira o numero da porta.");
            lixo = read.nextLine();

            int anoConstrucao = pedeIntValido("\n Insira o ano de construção.");
            lixo = read.nextLine();

            novo = new Loja(codigo, rua, precoPedido, precoMin, estado, area, wc, negocio, numPorta, anoConstrucao);
        }
        else if(resposta.equals("4")) {
            int areaDisponivel = pedeIntValido("\n Insira a area disponível:");
            lixo = read.nextLine();

            System.out.println("\n Insira o tipo de Terreno");
            System.out.println(" 1 - Habitacao \n 2 - Armazem");
            String k = read.nextLine();

            TipoTerreno tipoTerreno;

            if (k.equals("1")) { tipoTerreno = TipoTerreno.HABITACAO; }
            else { tipoTerreno = TipoTerreno.ARMAZEM; }

            int diametroCanalizacoes = pedeIntValido("\n Insira o diâmetro das canalizações:");
            lixo = read.nextLine();

            System.out.println ("\n Possui rede instalada?");
            System.out.println(" 1 - Sim \n 2 - Não");
            String z = read.nextLine();

            boolean redeInstalada;

            if (z.equals("1")) { redeInstalada = true; }
            else { redeInstalada = false; }

            int potenciaMax = pedeIntValido("\n Insira a potência máxima:");
            lixo = read.nextLine();

            System.out.println ("\n Possui rede de esgotos?");
            System.out.println(" 1 - Sim \n 2 - Não");
            String s = read.nextLine();

            boolean redeEsgotos;

            if (s.equals("1")) { redeEsgotos = true; }
            else { redeEsgotos = false; }

            novo = new Terreno(codigo, rua, precoPedido, precoMin, estado, areaDisponivel, tipoTerreno, diametroCanalizacoes, redeInstalada, potenciaMax, redeEsgotos);
        }
        else {
            valido = false;
            System.out.println ("Opção inválida");
        }

        if (valido) {
            try {
                imoobiliaria.registaImovel(novo);
                System.out.println ("O seu imovel foi adicionado com sucesso!");

            } catch (ImovelExisteException e) {
                System.out.println("O imóvel já existe");
            }
        }
    }

    /** Método que consulta as 10 últimas consultas dos imóveis que tem para venda. **/
    public static void ultimasConsultas() throws SemAutorizacaoException {
        List<Consulta> consultas = imoobiliaria.getConsultas();

        if (consultas.size() > 0) {
            System.out.println("\n Estas são as 10 últimas consultas dos imóveis que tem para venda:");
            consultas.forEach(c -> System.out.println(c.toString()));
        }
        else {
            System.out.println(" Não existem consultas para os imóveis à venda");
        }

        primaEnter();
    }

    /** Método que adiciona altera o estado de um imóvel para [Vendido / Reservado / Para Venda]. **/
    public static void alteraEstadoImovel() throws SemAutorizacaoException {
        System.out.println("Qual o codigo do seu imovel?");
        String codigo = read.nextLine();


        String opcao = "";

        boolean valido;
        String estado = "";

        do {
            System.out.println("Para que estado deseja alterar o seu imovel? \n 1 - Vendido \n 2 - Reservado \n 3 - Para Venda.");
            opcao = read.nextLine();

            valido = true;

            switch (opcao) {
                case "1":
                    estado = "VENDIDO";
                    break;
                case "2":
                    estado = "RESERVADO";
                    break;
                case "3":
                    estado = "VENDA";
                    break;
                default:
                    System.out.println("Opção inválida.\n");
                    valido = false;
                    break;
            }
        } while (valido == false);

        try {
            imoobiliaria.setEstado(codigo, estado);
            System.out.println("Estado do imóvel alterado com sucesso\n");

        } catch (ImovelInexistenteException e) {
            System.out.println(e.getMessage());
        } catch (EstadoInvalidoException e) {
            System.out.println(e.getMessage());
        }

        primaEnter();
    }

    /** Método que consulta os imóveis mais consultados. **/
    public static void consultaImoveisConsultados(){
        int top = pedeIntValido("\nQual o tamanho do seu Top Imoveis mais consultados?");
        String lixo = read.nextLine();

        Set<String> imoveis = imoobiliaria.getTopImoveis(top);

        if (imoveis.size() > 0) {
            System.out.println(" Este é o seu Top Imoveis mais consultados:");

            imoveis.forEach(i -> System.out.println("\t "+i.toString()));
        }
        else {
            System.out.println("\t Não existem consultas nos imoveis");
        }

        primaEnter();
    }

    /** Método que regista a venda de um imóvel. **/
    public static void registaVendaImovel(){
        System.out.println("Qual o codigo do imóvel o qual deseja registar a venda?");
        String codigo = read.nextLine();

        try {
            imoobiliaria.registaVenda(codigo);
            System.out.println("A venda do seu imóvel foi registada com sucesso!");
        } catch (ImovelInexistenteException e) {
            System.out.println("Imóvel inexistente!");
        } catch (SemAutorizacaoException e) {
            System.out.println("Não tem autorização, só os vendedores o podem fazer!");
        }

        primaEnter();
    }

    /** Método que remove um imóvel. **/
    public static void removeImovel() {
        System.out.println(" Qual o codigo do imóvel que deseja remover?");
        String codigo = read.nextLine();

        try {
            imoobiliaria.removeImovel(codigo);

            System.out.println(" Imóvel removido com sucesso!");
        } catch (ImovelInexistenteException e) {
            System.out.println(e.getMessage());
        } catch (SemAutorizacaoException e) {
            System.out.println(e.getMessage());
        }

        primaEnter();
    }


        /** --------------------------------------------------------- Métodos de Consultas --------------------------------------------------------- **/

    /** Método que consulta as estatísticas. **/
    public static void consultaEstatisticas() throws SemAutorizacaoException { //tive de adicionar o throws ass: lucia
        String opcao;

        boolean sairMenuEstatisticas = false;
        System.out.print('\u000C');
        do{
            menuEstatisticas();
            opcao = read.nextLine();
            switch(opcao){
                case "1":
                    nrImoveisVendidos();
                    break;
                case "2":
                    nrImoveisParaVenda();
                    break;
                case "3":
                    nrAnunciosCriados();
                    break;
                case "4":
                    nrVisualizacoesAnuncios();
                    break;
                case "5":
                    sairMenuEstatisticas = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while(!sairMenuEstatisticas);
    }

    /** Método que consulta o portfolio de imóveis em venda. **/
    public static void consultaPortfolio()throws SemAutorizacaoException {

        List<Imovel> portfolio = imoobiliaria.getPortfolioImoveisParaVenda();

        if (portfolio.size() > 0) {
            System.out.println(" Este é o seu portfolio de imóveis em venda:");
            portfolio.forEach(i -> System.out.println(i.toString()));
        }
        else {
            System.out.println(" Não tem imóveis em venda");
        }

        primaEnter();
    }

    /** Método que consulta o histórico de imóveis vendidos. **/
    public static void consultaHistorico() throws SemAutorizacaoException {
        List<String> historico = imoobiliaria.getHistorioImoveisVendidos();

        if (historico.size() > 0) {
            System.out.println ("Este é o seu histórico de imoveis vendidos:");

            historico.forEach(i -> System.out.println("\t " + i.toString()));
        }
        else {
            System.out.println(" Não tem imóveis vendidos");
        }

        primaEnter();
    }

    /** --------------------------------------------------------- Métodos de Estatisticas --------------------------------------------------------- **/

    /** Método que devolve o número de imóveis vendidos. **/
    public static void nrImoveisVendidos() throws SemAutorizacaoException {
        int nrImoveisVendidos = imoobiliaria.numImoveisVendidos();
        System.out.println("Já vendeu " + nrImoveisVendidos + " imóveis");

        primaEnter();
    }

    /** Método que devolve o número de imóveis para venda. **/
    public static void nrImoveisParaVenda() throws SemAutorizacaoException {
        int nrImoveisParaVenda = imoobiliaria.numImoveisParaVenda();
        System.out.println("Tem " + nrImoveisParaVenda + " imóveis para venda.");

        primaEnter();
    }

    /** Método que devolve o número de anúncios criados  **/ //VER SE ESTÁ CORRETO
    public static void nrAnunciosCriados()throws SemAutorizacaoException {
        int nrAnunciosCriados = (imoobiliaria.numImoveisParaVenda() + imoobiliaria.numImoveisVendidos());
        System.out.println ("Até ao momento já criou " + nrAnunciosCriados + " anúncios.");

        primaEnter();
    }

    /** Método que devolve o número de visualizações de anúncios **/ //falta fazer
    public static void nrVisualizacoesAnuncios(){
        System.out.println ("O número de visualizações por cada anúncio:");
        Map<String, Integer> visualizacoes = imoobiliaria.getNrVisualizacoes();

        for (Map.Entry<String, Integer> par : visualizacoes.entrySet()) {
            String idImovel = par.getKey();
            Integer nrVisualizacoes = par.getValue();

            System.out.println("\t Imóvel: " + idImovel + " Visualizacoes: " + nrVisualizacoes);
        }

        primaEnter();
    }

    /** Métodos de Leilões **/

    public static void iniciaLeilao() {
        System.out.println ("\n Insira o código do imóvel que quer leiloar: ");

        String codigoImovel = read.nextLine();

        try {
            Imovel imovel = imoobiliaria.pesquisarMyImovel(codigoImovel);
            int duracao = pedeIntValido("\n Insira a duracao do leilão: ");
            String lixo = read.nextLine();

            imoobiliaria.iniciaLeilao(imovel, duracao);
            System.out.println("\n A começar o leilão...\n");

            imoobiliaria.arrancaLeilao(System.out);

            Comprador c = imoobiliaria.encerraLeilao();

            if (c != null) {
                System.out.println(" O utilizador que venceu o leilão foi o:\n");
                System.out.println(c.toStringSimples());
            }
            else {
                System.out.println(" Não foi atingido o mínimo do imóvel, o imóvel não foi vendido.\n");
            }
        } catch (ImovelInexistenteException e) {
            System.out.println(e.getMessage());
        } catch (SemAutorizacaoException e) {
            System.out.println(e.getMessage());
        }

        primaEnter();
    }

    public static int pedeIntValido(String s){
        int valor = 0;
        boolean opcaoInvalida = true;

        do{
            System.out.println(s);
            try{
                valor = read.nextInt();
                opcaoInvalida = false;
            }
            catch (InputMismatchException e){
                System.out.println("O valor não é válido!\n");
                read.next();
            }
        } while(opcaoInvalida);

        return valor;
    }

    public static LocalDate pedeDataValida(String s){
        LocalDate data = null;
        boolean opcaoInvalida = true;

        do{
            System.out.println(s);
            try{
                String lido = read.nextLine();
                data = LocalDate.parse(lido, formatter);
                opcaoInvalida = false;
            }
            catch (DateTimeParseException e){
                System.out.println("A data não está num formato válido! Formato: dd/mm/aaaa\n");
            }
        } while(opcaoInvalida);

        return data;
    }

    /** --------------------------------------------------------- Programa Principal --------------------------------------------------------- **/

    /** Programa Principal **/
    public static void main (String [] args){
        carregarEstado();

        String opcao;

        boolean sairSessao = false;
        System.out.print('\u000C');

        do {
            menu();
            opcao = read.nextLine();

            switch(opcao){
                case "1":
                    iniciarSessao();
                    break;
                case "2":
                    registarConta();
                    break;
                case "3":
                    consultarImoveisTipoPreco();
                    break;
                case "4":
                    consultarImoveisHabitaveis();
                    break;
                case "5":
                    consultarImoveisTipologia();
                    break;
                case "6":
                    mapeamentoImoveis();
                    break;
                case "7":
                    pesquisaImovel();
                    break;
                case "8":
                    guardarEstado();
                    sairSessao = true;
                    break;
                default:
                    System.out.println("\n Opção inválida.");
            }
        } while(!sairSessao);

        System.out.println("\n Aplicação terminada.");
    }

    public static void carregarEstado() {
        System.out.print('\u000C');
        boolean valido = false;

        do {
            System.out.println("Deseja carregar o ficheiro com informação previamente guardada em memória? \n 1 - Sim \n 2 - Não \n");
            String opcao = read.nextLine();
            valido = true;

            if (opcao.equals("1")) {
                try {
                    imoobiliaria = Imoobiliaria.carregarEstado();
                    System.out.println("\n O seu estado foi carregado com sucesso!");
                } catch (ClassNotFoundException e) {
                    // ficheiro estranho e nao foi possivel converter para imoobiliaria
                    imoobiliaria = Imoobiliaria.initApp();
                    System.out.println("\n O seu estado não foi carregado. Ficheiro não compatível.");
                } catch (IOException e) {
                    // ficheiro nao encontrado
                    imoobiliaria = Imoobiliaria.initApp();
                    System.out.println("\nO seu estado não foi carregado. Ficheiro não encontrado.");
                }

            }
            else if (opcao.equals("2")) {
                System.out.println("\n O seu estado não foi carregado.");
                imoobiliaria = Imoobiliaria.initApp();
            }
            else {
                valido = false;
                System.out.println("\n Opção inválida\n");
            }
        } while (!valido);

        primaEnter();
    }

    public static void guardarEstado() {

        String opcao = "";
        boolean valido;

        do {
            System.out.println ("\n Deseja guardar a informação num ficheiro em memória? \n 1 - Sim \n 2 - Não \n");
            opcao = read.nextLine();
            valido = true;

            if (opcao.equals("1")) {
                try {
                    imoobiliaria.guardarEstado();
                    System.out.println("\n O seu estado foi guardado com sucesso! Agradecemos a sua visita.");
                } catch (IOException e) {
                    // Não foi possível gravar em ficheiro
                    System.out.println("\n Não foi possível guardar o estado");
                }
            }
            else if (opcao.equals("2")) {
                System.out.println("\n O seu estado não foi guardado. Agradecemos a sua visita.");
            }
            else {
                valido = false;

                System.out.println("\n Opção inválida \n");
            }
        } while (!valido);
    }

    private static void primaEnter() {
        System.out.println("\n Prima Enter para continuar\n");
        read.nextLine();
    }
}
