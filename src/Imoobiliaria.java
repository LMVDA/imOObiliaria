
/**
 * Write a description of class ImOObiliaria here.
 *
 * @author G23
 * @version 4/5/2016
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.Set;
import java.util.Iterator;
import java.util.Random;
import java.io.PrintStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;


import java.time.LocalDate;

public class Imoobiliaria implements Imobiliavel, Serializable {
    /**
     * Variáveis de instância
     */
    private Map<String, Utilizador> utilizadores;  //Hashmap
    private Map<String, Imovel> imoveis; //TreeMap
    private String utilizadorAutenticado;
    private Leilao leilao;

    /**
     * Construtor vazio
     *
     */
    public Imoobiliaria(){
        utilizadores = new HashMap<String, Utilizador>();
        imoveis = new TreeMap<String, Imovel>();
        utilizadorAutenticado = "";
        leilao = new Leilao();
    }

    /**
     * Construtor por partes
     *
     * @param utilizadores
     * @param imoveis
     * @param utilizadorAutenticado NOTA: utilizadorAutenticado??
     */
    public Imoobiliaria(Map<String, Utilizador> utilizadores, Map<String, Imovel> imoveis, String utilizadorAutenticado){
        setUtilizadores(utilizadores);
        setImoveis(imoveis);
        this.utilizadorAutenticado = utilizadorAutenticado;
        leilao = new Leilao();
    }

    /**
     * Construtor cópia
     *
     * @param i imobiliária
     *
     */
    public Imoobiliaria(Imoobiliaria i){
        utilizadores = i.getUtilizadores();
        imoveis = i.getImoveis();
        utilizadorAutenticado = i.getUtilizadorAutenticado();
        leilao = i.getLeilao();
    }

    /** GETS **/

    /**
     * Obter os utilizadores do sistema
     *
     * @return o utilizadores
     */
    public Map<String, Utilizador> getUtilizadores(){
        Map<String, Utilizador> r = new HashMap<String, Utilizador>();

        for( Map.Entry<String, Utilizador> par : utilizadores.entrySet()){
            String email = par.getKey();
            Utilizador utilizador = par.getValue();

            r.put(email, utilizador.clone());
        }

        return r;
    }

    /**
     * Obter os imóveis do sistema
     *
     * @return imoveis
     *
     */
    public Map<String, Imovel> getImoveis(){
        Map<String, Imovel> r = new TreeMap<String, Imovel>();

        for( Map.Entry<String, Imovel> par : imoveis.entrySet()){
            String codImovel = par.getKey();
            Imovel imovel = par.getValue();

            r.put(codImovel, imovel.clone());
        }

        return r;
    }

    /**
     * Obter o email do utilizador autenticado no sistema
     *
     * @return String
     */
    public String getUtilizadorAutenticado(){
        return utilizadorAutenticado;
    }

    /**
     * Obter o leilão actual
     *
     * @return Leilao
     */
    public Leilao getLeilao() {
        return leilao.clone();
    }

    /** SETS **/

    /**
     * Definir os utilizadores do sistema
     *
     * @param utilizadores
     */
    public void setUtilizadores(Map<String, Utilizador> utilizadores){

        this.utilizadores = new HashMap<String, Utilizador>();

        for(Map.Entry<String, Utilizador> par : utilizadores.entrySet()){
            String email = par.getKey();
            Utilizador utilizador = par.getValue();

            this.utilizadores.put(email, utilizador.clone());

        }

    }

    /**
     * Definir os imóveis do sistema
     *
     * @param imoveis
     */
    public void setImoveis(Map<String, Imovel> imoveis){

        this.imoveis = new TreeMap<String, Imovel>();

        for(Map.Entry<String, Imovel> par : imoveis.entrySet()){
            String codImovel = par.getKey();
            Imovel imovel = par.getValue();
            Imovel ic = imovel.clone();


            this.imoveis.put(codImovel, imovel.clone());
        }


    }

    /**
     * Definir o email do utilizador autenticado no sistema
     *
     * @param
     */
    public void setUtilizadorAutenticado(String utilizadorAutenticado){
        this.utilizadorAutenticado = utilizadorAutenticado;
    }

    /**
     * Definir o leilão actual do sistema
     *
     * @param leilao
     */
    public void setLeilao(Leilao leilao) {
        this.leilao = leilao.clone();
    }

    /**
     * Devolve uma cópia desta instância
     *
     * @return cópia do objecto Imoobiliaria
     */
    public Imoobiliaria clone(){
        return new Imoobiliaria(this);
    }

    /**
     * Métodos equals() e toString() // VER SE É PRECISO OU NAO!
     */

    /** Métodos : Requisitos básicos **/

    /**
     * Método que permite iniciar a aplicação
     *
     * @return Imoobiliaria
     */
    public static Imoobiliaria initApp(){
        return GeraImoobiliaria.geraImoobiliaria();
    }

    /**
     * Método que permite registar um utilizador (Vendedor ou Comprador)
     *
     * @param utilizador
     * @throws UtilizadorExistenteException
     */
    public void registarUtilizador(Utilizador utilizador) throws UtilizadorExistenteException{

        String email = utilizador.getEmail();

        if( !utilizadores.containsKey(email) ){
            utilizadores.put(email, utilizador.clone());
        }
        else {
            throw new UtilizadorExistenteException("O Utilizador com o email " + email + " já existe");
        }

    }

    /**
     * Método para validar o acesso à aplicação utiilizando as credenciais (email e password)
     *
     * @param email
     * @param password
     * @throws SemAutorizacaoException
     *
     */
    public void iniciaSessao(String email, String password) throws SemAutorizacaoException{
        boolean passWordCorrecta;

        if( utilizadores.containsKey(email) ){

            Utilizador u = utilizadores.get(email);

            if(u.getPassword().equals(password)){
                utilizadorAutenticado = email;
            }
            else {
                throw new SemAutorizacaoException("A password não está correta, tente de novo!");
            }

        }
        else {
            throw new SemAutorizacaoException("Utilizador inexistente, tente de novo!");
        }

    }

    /**
     * Método para terminar a sessão actual
     *
     */
    public void fechaSessao(){
        utilizadorAutenticado = "";
    }


    /** Métodos do vendedor - necessário estar previamente autenticado **/

    /**
     * Método que permite a um vendedor colocar um imóvel à venda
     * Necessário estar previamente autenticado.
     *
     * @param im
     * @throws ImovelExisteException
     * @throws SemAutorizacaoException
     */
    public void registaImovel(Imovel im) throws ImovelExisteException, SemAutorizacaoException {

        utilizadorComSessao("Vendedor");

        if(!imoveis.containsKey(im.getCodigo() )){
            im.setVendedor(utilizadorAutenticado);
            imoveis.put(im.getCodigo(), im.clone());

            Vendedor u = (Vendedor) utilizadores.get(utilizadorAutenticado);
            u.addImovelVenda(im.getCodigo());
        }
        else{
            throw new ImovelExisteException("O imóvel já existe!");
        }

    }

    /**
     * Método que devolve a um vendedor as 10 últimas consultas dos imóveis que tem para venda
     * Necessário estar previamente autenticado.
     *
     * @throws SemAutorizacaoException
     * @return Lista das 10 últimas consultas aos imóveis para venda
     */

    public List<Consulta> getConsultas() throws SemAutorizacaoException{
        utilizadorComSessao("Vendedor");

        List<Consulta> lista = new ArrayList<Consulta>();
        Vendedor v = (Vendedor) utilizadores.get(utilizadorAutenticado);
        Set<Consulta> conj = new TreeSet<Consulta>(); //ordenado pela data das consultas;

        List<String> imoveisParaVenda = v.getImoveisParaVenda();

        for (String codigoImovel : imoveisParaVenda) {
            Imovel imovel = imoveis.get(codigoImovel);

            List<Consulta> consultas = imovel.getConsultas();

            for (Consulta c : consultas) {
                conj.add(c.clone());
            }
        }

        Iterator<Consulta> it = conj.iterator();
        int n = 0;

        while(it.hasNext() && n < 10) {
            Consulta c = it.next();
            lista.add(c.clone());
            n++;
        }

        return lista;
    }

    /**
     * Método que permite ao vendedor alterar o estado de um imóvel de acordo com as acções feitas sobre ele
     * Necessário estar previamente autenticado.
     *
     * @param idImovel - Código do imóvel
     * @param estado
     * @throws ImovelInexistenteException
     * @throws SemAutorizacaoException
     * @throws EstadoInvalidoException
     */
    public void setEstado(String idImovel, String estado) throws ImovelInexistenteException,
            SemAutorizacaoException,
            EstadoInvalidoException {

        utilizadorComSessao("Vendedor"); //  só os vendedores o podem fazer
        Vendedor v = (Vendedor) utilizadores.get(utilizadorAutenticado);

        if(!v.existeImovelVendedor(idImovel)) { // lançar excepção se imóvel não existente
            throw new ImovelInexistenteException("O imóvel com código " + idImovel + " nao pertence ao vendedor!");
        }

        Imovel i = imoveis.get(idImovel);
        EstadoImovel e;

        switch(estado){
            case "VENDA" :
                e = EstadoImovel.VENDA;
                i.setEstado(e);
                break;
            case "RESERVADO" :
                e = EstadoImovel.RESERVADO;
                i.setEstado(e);
                break;
            case "VENDIDO" :
                imoveis.remove(idImovel); //imóvel deixa de existir no sistema (na listas de imóveis.. fica só um registo (código)na lista de vendidos do vendedor
                v.vendaDoImovel(idImovel);
                break;
            default:
                throw new EstadoInvalidoException("O estado " + estado + " é inválido!");
        }

    }


    /**
     * Permite ao vendedor obter um conjunto com todos os códigos dos imóveis mais consultados (com mais de N consultas)
     * Necessário estar previamente autenticado.
     *
     * @param n Consultas
     * @return conjunto dos códigos de imóveis
     */
    public Set<String> getTopImoveis(int n)  {
        // utilizadorComSessao("Vendedor");
        Vendedor v = (Vendedor) utilizadores.get(utilizadorAutenticado);

        Set<String> conjunto = new TreeSet<String>();
        List<String> imoveisParaVenda = v.getImoveisParaVenda();

        for(String cod: imoveisParaVenda) {
            Imovel i = imoveis.get(cod);
            int tam = i.getConsultas().size();
            if(tam > n) {
                conjunto.add(cod);
                i.adicionaConsulta(utilizadorAutenticado);
            }
        }

        return conjunto;
    }

    /**
     * Permite ao vendedor registar a venda de um imóvel.
     * Necessário estar previamente autenticado.
     * @param cod
     * @throws SemAutorizacaoException
     * @throws SemAutorizacaoException
     */
    public void registaVenda (String cod) throws ImovelInexistenteException, SemAutorizacaoException {

        utilizadorComSessao("Vendedor");
        Vendedor v = (Vendedor) utilizadores.get(utilizadorAutenticado);

        if(v.existeImovelVendedor(cod)==false) {
            throw new ImovelInexistenteException("O imóvel com código " + cod + " não pertence ao vendedor!");
        }

        Imovel i = imoveis.get(cod);

        imoveis.remove(cod);
        v.vendaDoImovel(cod);

    }

    /**
     * Permite ao vendedor consultar o portfolio de imóveis que tem para venda
     * Necessário estar previamente autenticado
     * @return portfolio O Portfolio de imoveis para venda
     */
    public List<Imovel> getPortfolioImoveisParaVenda() throws SemAutorizacaoException{
        utilizadorComSessao("Vendedor");
        Vendedor v = (Vendedor) utilizadores.get(utilizadorAutenticado);
        List<String> portfolio = v.getImoveisParaVenda();

        List<Imovel> portfolioNovo = new ArrayList<Imovel>();
        for(String cod : portfolio){
            Imovel i = imoveis.get(cod);
            portfolioNovo.add(i.clone());
        }
        return portfolioNovo;
    }

    /**
     * Permite ao vendedor consultar o histórico de imóveis vendidos
     * Necessário estar previamente autenticado
     * @return historico O Histórico de imóveis vendidos
     */
    public List<String> getHistorioImoveisVendidos() throws SemAutorizacaoException{
        utilizadorComSessao("Vendedor");
        Vendedor v = (Vendedor) utilizadores.get(utilizadorAutenticado);
        List<String> historico = v.getImoveisVendidos();

        return historico;
    }

    /** Método que devolve o número de imóveis para venda **/
    public int numImoveisParaVenda() throws SemAutorizacaoException{
        utilizadorComSessao("Vendedor");
        Vendedor v = (Vendedor) utilizadores.get(utilizadorAutenticado);
        List<String> lista = v.getImoveisParaVenda();
        int numImoveisParaVenda = 0;

        for(String cod : lista){
            numImoveisParaVenda++;
        }

        return numImoveisParaVenda;
    }

    /** Método que devolve o número de imóveis vendidos **/
    public int numImoveisVendidos() throws SemAutorizacaoException{
        utilizadorComSessao("Vendedor");
        Vendedor v = (Vendedor) utilizadores.get(utilizadorAutenticado);
        List<String> lista = v.getImoveisVendidos();
        int numImoveisVendidos = 0;

        for(String cod : lista){
            numImoveisVendidos++;
        }

        return numImoveisVendidos;
    }

    /** Método que devolve a quantidade de dinheiro ganho com os imóveis vendidos **/
    /*
    public int quantidadeDinheiroGanho() throws SemAutorizacaoException{
        utilizadorComSessao("Vendedor");
        Vendedor v = (Vendedor) utilizadores.get(utilizadorAutenticado);
        List<String> lista = v.getImoveisVendidos();
        int dinheiroGanho = 0;


    }
    */


    /** Métodos do comprador - necessário estar previamente autenticado.**/

    /**
     * Permite ao comprador marcar um imóvel como favorito
     * Necessário estar previamente autenticado
     *
     * @param idImovel - Código do imóvel
     * @throws ImovelInexistenteException
     * @throws SemAutorizacaoException
     */
    public void setFavorito(String idImovel) throws ImovelInexistenteException, SemAutorizacaoException{

        utilizadorComSessao("Comprador"); //  só os compradores o podem fazer
        Comprador c = (Comprador) utilizadores.get(utilizadorAutenticado);

        if (imoveis.containsKey(idImovel) == false) { // lançar excepção se imóvel não existente
            throw new ImovelInexistenteException("O imóvel com código " + idImovel + " nao existe!");
        }

        Imovel i = imoveis.get(idImovel);

        c.adicionaFavorito(idImovel);
    }

    /**
     * Permite ao comprador desmarcar um imóvel como favorito
     * Necessário estar previamente autenticado
     *
     * @param idImovel - Código do imóvel
     * @throws ImovelInexistenteException
     * @throws SemAutorizacaoException
     */
    public void desmarcaFavorito(String idImovel) throws ImovelInexistenteException, SemAutorizacaoException{

        utilizadorComSessao("Comprador"); //  só os compradores o podem fazer
        Comprador c = (Comprador) utilizadores.get(utilizadorAutenticado);

        if(imoveis.containsKey(idImovel) == false) { // lançar excepção se imóvel não existente
            throw new ImovelInexistenteException("O imóvel com código " + idImovel + " nao existe!");
        }

        Imovel i = imoveis.get(idImovel);

        c.removeFavorito(idImovel);
    }

    /**
     * Permite a um comprador consultar os imóveis favoritos (ordenado por preço)
     * Necessário estar previamente autenticado
     *
     * @throws SemAutorizacaoException
     * @return conjunto de imóveis favoritos ordenados por preço
     */
    public TreeSet<Imovel> getFavoritos() throws SemAutorizacaoException{
        utilizadorComSessao("Comprador");
        Comprador c = (Comprador) utilizadores.get(utilizadorAutenticado);

        List<String> imoveisFavoritos = c. getImoveisFavoritos();
        ComparadorPreco p = new ComparadorPreco();
        TreeSet<Imovel> conjunto = new TreeSet<Imovel>(p);

        for(String cod: imoveisFavoritos) {
            Imovel i = imoveis.get(cod);
            conjunto.add(i.clone());
            i.adicionaConsulta(utilizadorAutenticado); // adiciona consulta
        }

        return conjunto;
    }


    /** Métodos para todos os utilizadores **/

    /**
     * Consultar a lista de todos os imóveis de um dado tipo e até um determinado preço
     *
     * @param classe tipo do imóvel (Moradia, Apartamento, Loja, Terreno, etc)
     * @param preco preço máximo
     * @return lista de imóveis
     */
    public List<Imovel> getImovel(String classe, int preco){ /** mudei preco para int ass:lucia **/
        List<Imovel> lista = new ArrayList<Imovel>();

        for(Imovel i : imoveis.values()){

            String s = i.getClass().getSimpleName();
            int p = i.getPrecoPedido();

            if (s.equals(classe) && p <= preco)  {
                lista.add(i.clone());
                i.adicionaConsulta(utilizadorAutenticado);// adiciona consulta
            }

        }
        return lista;
    }

    /**
     * Consultar todos os imóveis habitáveis até um determinado preço
     *
     * @param preco preço máximo
     * @return lista de imóveis habitáveis
     */
    public List<Habitavel> getHabitaveis(int preco){
        List<Habitavel> lista = new ArrayList<Habitavel>();

        for(Imovel i : imoveis.values()){

            if( (i instanceof Habitavel) && (i.getPrecoPedido() <= preco) ){
                lista.add(((Habitavel) i.clone()));
                i.adicionaConsulta(utilizadorAutenticado);// adiciona consulta
            }
        }

        return lista;
    }

    /**
     * Mapeamento entre imóveis e o respectivo vendedor
     *
     * @return mapeamento
     */
    public Map<Imovel, Vendedor> getMapeamentoImoveis(){
        Map<Imovel, Vendedor> mapeamento = new TreeMap<Imovel, Vendedor>();

        for(Imovel i : imoveis.values()){
            String nomeVendedor = i.getVendedor();

            Vendedor v = (Vendedor) utilizadores.get(nomeVendedor);

            mapeamento.put(i.clone(), v.clone());

        }

        return mapeamento;
    }

    /**
     * Método que pesquisa um imóvel
     * @param codigo
     * @return Um imóvel
     */
    public Imovel pesquisarImovel(String codigo) throws ImovelInexistenteException {
        if (imoveis.containsKey(codigo) == false)
            throw new ImovelInexistenteException("O código "+ codigo + " não corresponde a nenhum imóvel.");

        Imovel im  = imoveis.get(codigo);

        return im.clone();
    }

    /**
     * Método que pesquisa um imóvel
     * @param codigo
     * @return Um imóvel
     */
    public Imovel pesquisarMyImovel(String codigo) throws ImovelInexistenteException, SemAutorizacaoException {
        if (imoveis.containsKey(codigo) == false)
            throw new ImovelInexistenteException("O código "+ codigo + " não corresponde a nenhum imóvel.");

        Imovel im  = imoveis.get(codigo);

        if (im.getVendedor().equals(utilizadorAutenticado) == false)
            throw new SemAutorizacaoException("O imóvel com o código " + codigo + " não pertence ao utilizador.");

        return im.clone();
    }

    /**
     * Método que altera o dado pessoal Nome
     * @param novoNome
     */
    public void mudarNome(String novoNome) {
        Utilizador u = utilizadores.get(utilizadorAutenticado);
        u.setNome(novoNome);
    }

    /**
     * Método que altera o dado pessoal Password
     * @param novaPassword
     */
    public void mudarPassword(String novaPassword) {
        Utilizador u = utilizadores.get(utilizadorAutenticado);
        u.setPassword(novaPassword);
    }

    /** Método que altera o dado pessoal Morada
     * @param novaMorada
     */
    public void mudarMorada(String novaMorada) {
        Utilizador u = utilizadores.get(utilizadorAutenticado);
        u.setMorada(novaMorada);
    }

    /** Método que altera o dado pessoal Data de Nascimento
     * @param novaDataDeNascimento
     */
    public void mudarDataDeNascimento(LocalDate novaDataDeNascimento) {
        Utilizador u = utilizadores.get(utilizadorAutenticado);
        u.setDataNascimento(novaDataDeNascimento);
    }

    /**
     * Obter o utilizador autenticado no sistema
     *
     * @return utilizador
     */
    public Utilizador getUtilizadorAutenticadoCompleto(){
        Utilizador u = utilizadores.get(utilizadorAutenticado);

        return u.clone();
    }


    /** Métodos auxiliares **/

    /**
     * Método que verifica se um utilizador está autenticado e lança uma excepção caso não esteja
     *
     * @param tipo tipo do utilizador (Comprador ou Vendedor)
     * @throws SemAutorizacaoException
     *
     */
    private void utilizadorComSessao(String tipo) throws SemAutorizacaoException {
        if(utilizadorAutenticado.equals("")){
            throw new SemAutorizacaoException("O utilizador não se encontra autenticado!");
        }
        else {
            Utilizador u = utilizadores.get(utilizadorAutenticado);
            if (!u.getClass().getSimpleName().equals(tipo)) {
                throw new SemAutorizacaoException("O utilizador não é do tipo pretendido!");
            }
        }
    }

    /**
     * Consultar os imóveis de uma determinada tipologia
     *
     * @param tipologia
     * @return lista dos imóveis
     */
    public List<Habitavel> getImoveisTipologia(int tipologia){
        List<Habitavel> lista = new ArrayList<Habitavel>();

        for(Imovel i : imoveis.values()){

            if( (i instanceof Habitavel) && ((Habitavel) i).getTipologia() == tipologia ){
                lista.add(((Habitavel) i.clone()));
                i.adicionaConsulta(utilizadorAutenticado);
            }
        }

        return lista;
    }

    /**
     * Consultar o número de consultas em todos os imóveis do vendedor
     */
    public Map<String, Integer> getNrVisualizacoes() {
        Vendedor v = (Vendedor) utilizadores.get(utilizadorAutenticado);
        List<String> imoveis = v.getImoveisParaVenda();
        Map<String, Integer> visualizacoes = new TreeMap<String, Integer>();

        int total = 0;

        for (String idImovel : imoveis) {
            Imovel imovel = this.imoveis.get(idImovel);

            visualizacoes.put(idImovel, imovel.getConsultas().size());
        }

        return visualizacoes;
    }

    /**
     * Remover um imóvel do sistema
     * @param idImovel
     */
    public void removeImovel(String idImovel) throws ImovelInexistenteException, SemAutorizacaoException {
        utilizadorComSessao("Vendedor");

        if (imoveis.containsKey(idImovel) == false)
            throw new ImovelInexistenteException("O imóvel com código " + idImovel + " nao pertence ao vendedor!");

        for (Utilizador u : utilizadores.values()) {
            if (u instanceof Comprador) {
                ((Comprador) u).removeFavorito(idImovel);
            }
        }

        Imovel imovel = imoveis.get(idImovel);

        Vendedor vendedor = (Vendedor) utilizadores.get(imovel.getVendedor());

        vendedor.remImovelVenda(idImovel);

        imoveis.remove(idImovel);
    }

    
    /** Métodos associados ao leilão **/
    
    /**
     * Método que gera participações para permitir a existência de um leilão
     * 
     */
    private void geraParticipacoesLeilao() {
        Random random = new Random();
        Set<String> codigosUtilizadores = utilizadores.keySet();
        int maxNumeroParticipacoes = (int) (codigosUtilizadores.size() * 0.20); //queremos no máximo 20% dos utilizadores
        List<String> utilizadoresAParticipar = new ArrayList<String>();
        String imovelSeleccionado = leilao.getImovel();

        Iterator<String> it = codigosUtilizadores.iterator();

        // Gerar lista de utilizadores a participar
        while (it.hasNext() && utilizadoresAParticipar.size() < maxNumeroParticipacoes) {
            String codigoUtilizador = it.next();

            // Verificamos se o utilizador é Comprador e 40% das vezes adicionamos, isto gera aleatoriedade nos compradores escolhidos
            if ((utilizadores.get(codigoUtilizador) instanceof Comprador) && (random.nextDouble() > 0.6)) {
                utilizadoresAParticipar.add(codigoUtilizador);
            }
        }

        // Adicionar as participacoes
        Imovel imovel = imoveis.get(imovelSeleccionado);
        for (String codigoUtilizador : utilizadoresAParticipar) {
            int minimoALicitar = (int) (imovel.getPrecoPedido() * 0.85);
            int maximoALicitar = (int) (imovel.getPrecoPedido() * 1.2);
            int incrementosMinimos = (int) (imovel.getPrecoPedido() * 0.00075);
            int incrementosMaximos = (int) (imovel.getPrecoPedido() * 0.0015);
            int intervaloEntreIncrementosMinimo = (int) (leilao.getDuracao() * 0.02);
            int intervaloEntreIncrementosMaximo = (int) (leilao.getDuracao() * 0.2);

            double limite = random.nextInt(maximoALicitar-minimoALicitar) + minimoALicitar; // gerar limite de licitação entre 95% e 120% do valor do imóvel
            double incrementos = random.nextInt(incrementosMaximos-incrementosMinimos) + incrementosMinimos; // gerar incrementos entre 0.2% e 0.3% do valor do imóvel
            double minutos = random.nextInt(intervaloEntreIncrementosMaximo-intervaloEntreIncrementosMinimo) + intervaloEntreIncrementosMinimo; // gerar intervalos entre 5% e 7% da duração total do leilão

            adicionaComprador(codigoUtilizador, limite, incrementos, minutos);
        }

    }

    /**
     * Método para iniciar um leilão
     * 
     * @param im
     * @param horas
     */
    public void iniciaLeilao(Imovel im, int horas) {
        leilao = new Leilao(im.getCodigo(), horas, 0.98 * im.getPrecoMin());

        //criar participações aleatorias
        geraParticipacoesLeilao();
    }

    
    /**
     * Método para adicionar um comprador ao leilão
     * 
     * @param idComprador
     * @param limite
     * @param incrementos
     * @param minutos
     */
    public void adicionaComprador(String idComprador, double limite, double incrementos, double minutos) {
        Participacao p = new Participacao(idComprador, limite, minutos, incrementos);
        leilao.adicionaParticipacao(p);
    }
    
    /**
     * Método para arrancar um leilão
     * 
     * @param printStream
     * 
     */
    public void arrancaLeilao(PrintStream printStream) {
        long instanteInicial = System.currentTimeMillis();
        Random random = new Random();

        while(leilao.leilaoTerminado() == false) {

            if (leilao.calculaProximaLicitacao())
                printStream.println("Última actualização: Comprador " + leilao.getUltimoLicitador() + " licitou " + leilao.getPropostaActual() + " pelo imóvel.");

            try {
                Thread.sleep(random.nextInt(2000)+1000);
            } catch (InterruptedException e) { }

            long instanteActual = System.currentTimeMillis();
            int tempoDecorrido = (int) (instanteActual - instanteInicial)/1000;

            leilao.setTempoDecorrido(tempoDecorrido);
        }

        Imovel imovel = imoveis.get(leilao.getImovel());

        if (imovel.valorMinimoSatisfeito(leilao.getPropostaActual())) {
            imovel.setEstado(EstadoImovel.RESERVADO);
        }
    }

    /**
     * Método para encerrar um leilão
     * 
     * @return Comprador que ganhou o leilão
     */
    public Comprador encerraLeilao() {
        Imovel imovel = imoveis.get(leilao.getImovel());

        if (imovel.getEstado() != EstadoImovel.VENDA)
            return ((Comprador) utilizadores.get(leilao.getUltimoLicitador())).clone();
        else
            return null;
    }


    /**
     * Permite guardar o estado actual da imoobiliaria.
     */
    public void guardarEstado() throws IOException {
        FileOutputStream fos = new FileOutputStream("Imoobiliaria.state");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(this);
        oos.close();
    }

    /**
     * Carregar uma imoobiliaria a partir de ficheiro.
     */
    public static Imoobiliaria carregarEstado() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Imoobiliaria.state"));

        Imoobiliaria novoState = (Imoobiliaria) ois.readObject();
        ois.close();

        return novoState;
    }

    /**
     * Permite obter o tipo de utilizador autenticado
     */
    public String getTipoUtilizadorAuntenticado() {
        Utilizador u = getUtilizadorAutenticadoCompleto();

        if (u instanceof Comprador) return "Comprador";
        else return "Vendedor";
    }

    private static double randomDoubleBetween(int min, int max) {
        Random random = new Random();
        return min + (max - min) * random.nextDouble();
    }
}
