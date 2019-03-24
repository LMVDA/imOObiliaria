
/**
 * Write a description of class Leilao here.
 * 
 * @author G23
 * @version 4/5/2016
 */
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

public class Leilao implements Serializable{
    
    /**
     * Variáveis de instância
     */
    private String imovel;          //imóvel em leilão
    private int duracao;            //duração do leilão
    private int tempoDecorrido;     //tempo decorrido desde o inicio do leilão
    private String ultimoLicitador; //email do comprador que fez a uma licitacao (a mais alta)
    private double propostaActual;  //valor actual (proposto pelo ultimo licitador - licitacao mais alta actual)
    private List<Participacao> participacoes; //Lista de particiappações
    
    /**
     * Construtor vazio
     */
    public Leilao() {
        imovel = "n/a";
        duracao = 0;
        tempoDecorrido = 0;
        ultimoLicitador = "n/a";
        propostaActual = 0;
        participacoes = new ArrayList<Participacao>();
    }

    /**
     * Construtor por partes
     * 
     * @param imovel
     * @param duracao
     */
    public Leilao(String imovel, int duracao, double propostaActual) {
        this.imovel = imovel;
        this.duracao = duracao;
        tempoDecorrido = 0;
        ultimoLicitador = "n/a";
        this.propostaActual = propostaActual;
        participacoes = new ArrayList<Participacao>();
    }

    /**
     * Construtor cópia
     * 
     * @param l
     */
    public Leilao(Leilao l) {
        imovel = l.getImovel();
        duracao = l.getDuracao();
        tempoDecorrido = l.getTempoDecorrido();
        ultimoLicitador = l.getUltimoLicitador();
        propostaActual = l.getPropostaActual();
        setParticipacoes(l.getParticipacoes());
    }

    /** GETS **/
    
    /**
     * Obter o código do imóvel em leilão
     * 
     * @return imóvel em leilão
     */
    public String getImovel() {
        return imovel;
    }

    /**
     * Obter a duração do leilão
     * 
     * @return duração do leilão
     */
    public int getDuracao() {
        return duracao;
    }

    /**
     * Obter o tempo decorrido desde o inicio do leilão
     * 
     * @return tempo deste o incio do leilão
     */
    public int getTempoDecorrido() {
        return tempoDecorrido;
    }
    
    /**
     * Obter a proposta actual (proposto pelo ultimo licitador - licitacao mais alta)
     * 
     * @return valor da proposta actual
     */
    public double getPropostaActual() {
        return propostaActual;
    }

    /**
     * Obter a lista das participações (associadas a compradores) do leilão
     * 
     * @return lista das participações
     */
    public List<Participacao> getParticipacoes() {
        List<Participacao> r = new ArrayList<Participacao>();

        for (Participacao p : participacoes) {
            r.add(p.clone());
        }

        return r;
    }

    /**
     * Obter o utilizador comprador que fez a última licitação (licitação mais alta actual)
     * 
     * @return código do comprador (email)
     */
    public String getUltimoLicitador() {
        return ultimoLicitador;
    }

    /** SETS **/
    
    /**
     * Definir o imóvel do leilão
     * 
     * @param imovel código do imóvel
     */
    public void setImovel(String imovel) {
        this.imovel = imovel;
    }

    /**
     * Definir a duração do leilão
     * 
     * @param duracao
     */
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    /**
     * Definir o tempo decorrido desde o inicio do leilão
     * 
     * @param tempoDecorrido
     */
    public void setTempoDecorrido(int tempoDecorrido) {
        this.tempoDecorrido = tempoDecorrido;
    }

    /**
     * Definir/Actualizar o valor da última licitação (a mais alta até ao momento)
     * 
     * @param propostaActual valor actual da licitação
     */
    public void setPropostaActual(double propostaActual) {
        this.propostaActual = propostaActual;
    }

    /**
     * Definir a lista com as participações (associadas a compradores) do leilão
     * 
     * @param participacoes do leilão
     */
    public void setParticipacoes(List<Participacao> participacoes) {
        this.participacoes = new ArrayList<Participacao>();

        for (Participacao p : participacoes) {
            this.participacoes.add(p.clone());
        }
    }
    
    /**
     * Definir o último utilizador que licitou 
     * 
     * @param ultimoLicitador código (email)
     */
    public void setUltimoLicitador(String ultimoLicitador) {
        this.ultimoLicitador = ultimoLicitador;
    }
        
    
    
    /**
     * Método que permite adicionar uma partição ao leilão
     * 
     * @param p Participação
     */
    public void adicionaParticipacao(Participacao p) {
        participacoes.add(p.clone());
    }

    /**
     * Método que incrementa um incremento ao tempo decorrido desde o incio do leilão
     * 
     * @param incremento valor do incremento
     */
    public void incrementaTempoDecorrido(int incremento) {
        tempoDecorrido += incremento;
    }


    /**
     * Método que verifica a próxima licitação do leilão
     *
     * @returns true se houve licitacao
     */
    public boolean calculaProximaLicitacao() {
        boolean encontradoLicitador = false;

        for (int i = 0; i < participacoes.size() && !encontradoLicitador; i++) {
            Participacao p = participacoes.get(i);

            if (p.podeLicitar(tempoDecorrido, propostaActual, ultimoLicitador)) {
                encontradoLicitador = true;
                propostaActual += p.getIncrementos();
                ultimoLicitador = p.getCodigoUtilizador();
                p.setInstanteUltimaLicitacao(tempoDecorrido);
                p.setValorUltimaLicitacao(propostaActual);
            }
        }

        return encontradoLicitador;
    }

    /**
     * Método que verifica se o leilão está terminado
     * 
     * @return true caso o leilão esteja terminado, false c.c.
     */
    public boolean leilaoTerminado() {
        return tempoDecorrido >= duracao;
    }

    /**
     * Devolve uma cópia desta instância 
     * 
     * @return cópia do Leilão 
     */
    public Leilao clone() {
        return new Leilao(this);
    }
}
