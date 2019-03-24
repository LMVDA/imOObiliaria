
/**
 * Abstract class Imovel - write a description of the class here
 *
 * @author G23
 * @version 4/5/2016
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import java.io.Serializable;

public abstract class Imovel implements Serializable, Comparable<Imovel>{

    /**
     * Variáveis de instância
     */
    private String codigo;
    private String rua;
    private int precoPedido;
    private int precoMin;
    private EstadoImovel estado; // vendido, Reservado, à venda
    private List<Consulta> consultas;
    private String vendedor;


    /**
     * Construtor vazio
     */
    public Imovel() {
        codigo = "n/a";
        rua = "n/a";
        precoPedido = 0;
        precoMin = 0;
        consultas = new ArrayList<Consulta>();
        vendedor = "n/a";
    }

    /**
     * Construtor por partes
     *
     * @param rua
     * @param precoPedido
     * @param precoMin
     * @param estado
     * @param consultas do imóvel
     */
    public Imovel(String codigo, String rua, int precoPedido, int precoMin, EstadoImovel estado, List<Consulta> consultas){
        this.codigo = codigo;
        this.rua = rua;
        this.precoPedido = precoPedido;
        this.precoMin = precoMin;
        this.estado = estado;
        setConsultas(consultas);
    }

    /**
     * Construtor por partes
     *
     * @param codigo
     * @param rua
     * @param precoPedido
     * @param precoMin
     * @param estado
     */
    public Imovel(String codigo, String rua, int precoPedido, int precoMin, EstadoImovel estado){
        this.codigo = codigo;
        this.rua = rua;
        this.precoPedido = precoPedido;
        this.precoMin = precoMin;
        this.estado = estado;
        consultas = new ArrayList<Consulta>();
    }

    /**
     * Construtor cópia
     *
     * @param i imóvel
     */
    public Imovel(Imovel i) {
        this.codigo = i.getCodigo();
        this.rua = i.getRua();
        this.precoPedido = i.getPrecoPedido();
        this.precoMin = i.getPrecoMin();
        this.estado = i.getEstado();
        this.consultas = i.getConsultas();
        this.vendedor = i.getVendedor();
    }

    /** GETS **/

    /**
     * Obter o código do imóvel
     *
     * @return o código do imóvel
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Obter o nome da rua
     *
     * @return o nome da rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * Obter o preco pedido para comprar o imóvel
     *
     * @return o preco de venda do imóvel
     */
    public int getPrecoPedido() {
        return precoPedido;
    }

    /**
     * Obter o preco minimo para comprar o imóvel
     *
     * @return o preco de mínimo do imóvel
     */
    public int getPrecoMin() {
        return precoMin;
    }

    /**
     * Obter o estado do imóvel
     *
     * @return o estado do imóvel (VENDA, RESERVADO, VENDIDO)
     */
    public EstadoImovel getEstado() {
        return estado;
    }

    /**
     * Obter as consultas do imóvel
     *
     * @return lista de consultas do imóvel
     */
    public List<Consulta> getConsultas(){
        List<Consulta> r = new ArrayList<Consulta>();

        for(Consulta c : consultas){
            r.add(c.clone());
        }

        return r;

    }

    /**
     * Obter a identificação (email) do vendedor que registou o imóvel
     *
     * @return email
     */
    public String getVendedor(){
        return vendedor;
    }

    /** SETS **/

    /**
     * Definir o código do imóvel
     *
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Definir a rua do imóvel
     *
     * @param rua
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * Definir o preço pedido pelo imóvel
     *
     * @param precoPedido
     */
    public void setPrecoPedido(int precoPedido) {
        this.precoPedido = precoPedido;
    }

    /**
     * Definir o preço mínimo pelo imóvel
     *
     * @param precoMin
     */
    public void setPrecoMin(int precoMin) {
        this.precoMin = precoMin;
    }

    /**
     * Definir o estado do imóvel
     *
     * @param estado (VENDA, RESERVADO, VENDIDO)
     */
    public void setEstado(EstadoImovel estado) {
        this.estado = estado;
    }

    /**
     * Definir as consultas do imóvel
     *
     * @param consultas
     *
     */
    public void setConsultas(List<Consulta> consultas){
        this.consultas = new ArrayList<Consulta>();

        for(Consulta c : consultas){
            this.consultas.add(c.clone());
        }

    }
    
    /**
     * Definir o vendedor associado ao imóvel
     * 
     * @param vendedor
     */
    public void setVendedor(String vendedor){
        this.vendedor = vendedor;
    }
    
    
    
    /**
     * Método abstract 
     * Devolve uma cópia desta instância 
     *
     * @return cópia do objecto
     */
    public abstract Imovel clone();

    /**
     * Método que compara a igualdade com outro objecto
     *
     * @param o
     * @return true se os objectos são iguais, false c.c.
     */
    public boolean equals(Object o) {
        if(o == this) return true;

        if(o == null) return false;

        if(o.getClass() != this.getClass()) return false;

        Imovel i = (Imovel) o;

        return codigo.equals(i.getCodigo());
    }

    /**
     * Método que devolve uma representação do imóvel no formato textual
     *
     * @return string que representa o imóvel
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("\n \t Código: " + codigo + "\n");
        sb.append("\t Rua: " + rua + "\n");
        sb.append("\t Preço Pedido: " + precoPedido + "\n");
        //sb.append("Preço Mínimo: " + precoMin + "\n");
        sb.append("\t Estado: " + estado + "\n");

        return sb.toString();
    }


    /**
     * Ordem Natural definida para comparar imóveis: Comparação de código de imóvel
     *
     * @param i
     * @return 0 se os imóveis forem iguais, -1 se o imóvel parâmetro for maior, 1 cc
     */
    public int compareTo(Imovel i){
        String cod = i.getCodigo();
        return codigo.compareTo(cod);
    }

    /**
     * Adiciona uma consulta 
     * 
     * @param codUtilizador Código do visualizador
     */
    public void adicionaConsulta(String codUtilizador){
        
        Consulta c = new Consulta(codUtilizador);
        consultas.add(c);
        
    }

    /**
     * Dado um valor, determina se o valor mínimo é satisfeito 
     *
     * @param valor Valor em comparação
     */
    public boolean valorMinimoSatisfeito(double valor) {
        return valor > precoMin;
    }

}