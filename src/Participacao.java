
/**
 * Write a description of class Participacao here.
 * 
 * @author G23
 * @version 4/5/2016
 */

import java.io.Serializable;

public class Participacao implements Serializable{
    
    /**
     * Variáveis de instância
     */
    private String codigoUtilizador;     //email do comprador que vai participar no leilão
    private double maximoLicitacao;      //valor máximo que está disposto a dar pelo imóvel em leilão
    private double incrementos;          //valor dos incrementos entre licitações
    private double intervaloLicitacoes;  //intervalo entre as licitações
    private double valorUltimaLicitacao; //valor que o comprador ofereceu na última licitação
    private int instanteUltimaLicitacao; //instante da última licitação efectuada pelo comprador

    /**
     * Construtor vazio
     */
    public Participacao() {
        codigoUtilizador = "n/a";
        maximoLicitacao = 0;
        incrementos = 0;
        intervaloLicitacoes = 0;
        valorUltimaLicitacao = 0;
        instanteUltimaLicitacao = 0;
    }

    
    /**
     * Construtor por partes
     * 
     * @param codigoUtilizador
     * @param maximoLicitacao
     * @param intervaloLicitacoes
     * @param incrementos
     */
    public Participacao(String codigoUtilizador, double maximoLicitacao, double intervaloLicitacoes, double incrementos) {
        this.codigoUtilizador = codigoUtilizador;
        this.maximoLicitacao = maximoLicitacao;
        this.incrementos = incrementos;
        this.intervaloLicitacoes = intervaloLicitacoes;
        this.valorUltimaLicitacao = 0;
        this.instanteUltimaLicitacao = 0;
    }
    
    /**
     * Construtor cópia
     * 
     * @param p Participação de um comprador
     */
    public Participacao(Participacao p) {
        codigoUtilizador = p.getCodigoUtilizador();
        maximoLicitacao = p.getMaximoLicitacao();
        incrementos = p.getIncrementos();
        intervaloLicitacoes = p.getIntervaloLicitacoes();
        valorUltimaLicitacao = p.getValorUltimaLicitacao();
        instanteUltimaLicitacao = p.getInstanteUltimaLicitacao();
    }

    /** GETS **/
    
    /**
     * Obter o email do comprador que vai participar no leilão
     * 
     * @return código do comprador (email)
     */
    public String getCodigoUtilizador() {
        return codigoUtilizador;
    }

    /**
     * Obter o valor máximo que o comprador está disposto a dar pelo imóvel em leilão nesta particiapção
     * 
     * @return valor máximo da licitação
     */
    public double getMaximoLicitacao() {
        return maximoLicitacao;
    }

    /**
     * Obter o intervalo entre licitações pelo imóvel em leilão
     * 
     * @return intervalo de tempo entre licitações
     */
    public double getIntervaloLicitacoes() {
        return intervaloLicitacoes;
    }

    /**
     * Obter o valor que o comprador ofereceu na última licitação
     * 
     * @return valor da última licitação efectuada pelo comprador
     */
    public double getValorUltimaLicitacao() {
        return valorUltimaLicitacao;
    }

    /**
     * Obter o instante (desde que se iniciou o leilão) da última licitação
     * 
     * @return instante da última licitação efectuada pelo comprador
     */
    public int getInstanteUltimaLicitacao() {
        return instanteUltimaLicitacao;
    }
    
    /**
     * Obter o valor de incremento entre licitações do comprador
     * 
     * @return valor dos incrementos entre licitações
     */
    public double getIncrementos() {
        return incrementos;
    }
    
    /** SETS **/
    
    /**
     * Definir o utilizador comprador que vai participar no leilão
     * 
     * @param codigoUtilizador código do comprador (email)
     */
    public void setCodigoUtilizador(String codigoUtilizador) {
        this.codigoUtilizador = codigoUtilizador;
    }
  
    /**
     * Definir o valor máximo que o comprador está disposto a dar pelo imóvel em leilão nesta participação
     * 
     * @param maximoLicitacao valor máximo da licitação
     */
    public void setMaximoLicitacao(double maximoLicitacao) {
        this.maximoLicitacao = maximoLicitacao;
    }
        
    /**
     * Definir o intervalo entre licitações pelo imóvel em leilão
     * 
     * @param intervaloLicitacoes intervalo de tempo entre licitações
     */
    public void setIntervaloLicitacoes(double intervaloLicitacoes) {
        this.intervaloLicitacoes = intervaloLicitacoes;
    }
    
    /**
     * Definir o valor que o comprador ofereceu na última licitação
     * 
     * @param valorUltimaLicitacao valor da última licitação efectuada pelo comprador
     */
    public void setValorUltimaLicitacao(double valorUltimaLicitacao) {
        this.valorUltimaLicitacao = valorUltimaLicitacao;
    }

    /**
     * Definir o instante (desde que se iniciou o leilão) da última licitação
     * 
     * @param instanteUltimaLicitacao instante da última licitação
     */
    public void setInstanteUltimaLicitacao(int instanteUltimaLicitacao) {
        this.instanteUltimaLicitacao = instanteUltimaLicitacao;
    }
    
    /**
     * Definir o valor do incremento entre licitações do comprador
     * 
     * @param incrementos
     */
    public void setIncrementos(double incrementos) {
        this.incrementos = incrementos;
    }

    
    
    /**
     * Método que compara a igualdade com outro objecto
     * 
     * @param o 
     * @return true se os objectos são iguais, false c.c.
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Participacao p = (Participacao) o;

        return (maximoLicitacao == p.getMaximoLicitacao() &&
                intervaloLicitacoes == p.getIntervaloLicitacoes() &&
                incrementos == p.getIntervaloLicitacoes() &&
                valorUltimaLicitacao == p.getValorUltimaLicitacao() &&
                instanteUltimaLicitacao == p.getInstanteUltimaLicitacao() &&
                codigoUtilizador.equals(p.getCodigoUtilizador()));
    }
    
    /**
     * Devolve uma cópia desta instância 
     * 
     * @return cópia da Participação 
     */
    protected Participacao clone() {
        return new Participacao(this);
    }

    /**
     * Método que devolve uma representação da participação no formato textual
     * 
     * @return string que representa o Participação 
     */
    public String toString() {
        return codigoUtilizador;
    }

    
    
    /**
     * Método que verifica se o comprador pode licitar - Valida a licitação
     * Verifica se já passou tempo suficiente para que possa fazer uma nova licitação
     * Verifica se a licitação não atinge o máximo que quer licitar
     * Verifica se não foi o ultimo licitador do leilão
     * 
     * @param tempoDecorrido tempo decorrido desde o inicio do leilão
     * @param propostaActual proposta actual
     * @param ultimoLicitador 
     * @return true caso possa licitar, false c.c.
     */
    public boolean podeLicitar(int tempoDecorrido, double propostaActual, String ultimoLicitador) {
        int intervaloDesdeUltimaLicitacao = tempoDecorrido - instanteUltimaLicitacao;
        double possivelLicitacao = propostaActual + incrementos;

        if (instanteUltimaLicitacao == 0 && valorUltimaLicitacao == 0)
            return true;

        return (intervaloLicitacoes < intervaloDesdeUltimaLicitacao &&
                maximoLicitacao > possivelLicitacao &&
                !ultimoLicitador.equals(codigoUtilizador));
    }
}
