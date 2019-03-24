
/**
 * Write a description of class Loja here.
 * 
 * @author G23 
 * @version 4/5/2016 
 */

import java.io.Serializable;

import java.util.Date;

public class Loja extends Imovel implements Serializable {
   
    /**
     * Variáveis de instância
     */
    private int area;
    private boolean wc;
    private String tipoNegocio;
    private int numPorta;
    private int anoConstrucao;
    
    /**
     * Construtor vazio
     */
    public Loja() {
        
        super();
        
        area = 0;
        tipoNegocio = "n/a";
        numPorta = 0;
        anoConstrucao = 0;
    }
    
    /**
     * Construtor por partes
     *
     * @param codigo
     * @param rua
     * @param precoPedido
     * @param precoMin
     * @param estado
     * 
     * @param area
     * @param wc
     * @param tipoNegocio
     * @param numPorta
     * @param anoConstrucao
     */
    public Loja(String codigo, String rua, int precoPedido, int precoMin, EstadoImovel estado, int area, boolean wc, String tipoNegocio, int numPorta, int anoConstrucao){
        
        super(codigo, rua, precoPedido, precoMin, estado);
        
        this.area = area;
        this.wc = wc;
        this.tipoNegocio = tipoNegocio;
        this.numPorta = numPorta;
        this.anoConstrucao = anoConstrucao;
    }
    
    /**
     * Construtor cópia
     * 
     * @param l loja
     */
    public Loja(Loja l) {
        
        super(l);
        
        this.area = l.getArea();
        this.wc = l.getWc();
        this.tipoNegocio = l.getTipoNegocio();
        this.numPorta = l.getNumPorta();
        this.anoConstrucao = l.getAnoConstrucao();
    }
    
    /** GETS **/
    
    /**
     * Obter a área da loja 
     * 
     * @return área da loja
     */
    public int getArea() {
        return area;
    }
    
    /**
     * Saber se a loja tem ou não WC 
     * 
     * @return true se possui WC, false c.c.
     */
    public boolean getWc() {
        return wc;
    }
    
    /**
     * Obter o tipo de negócio da loja
     * 
     * @return tipo de negócio
     */
    public String getTipoNegocio() {
        return tipoNegocio;
    }
    
     /**
     * Obter o número da porta da loja
     * 
     * @return número da porta
     */
    public int getNumPorta() {
        return numPorta;
    }
    
     /**
     * Obter o ano de construção da porta
     * 
     * @return ano de construção
     */
    public int getAnoConstrucao() {
        return anoConstrucao;
    }
   
    
    /** SETS **/
    
    /**
     * Definir a área da loja
     * 
     * @param area
     */
    public void setArea(int area) {
        this.area = area;
    }
    
    /**
     * Definir se existe ou não WC
     * 
     * @param wc
     */
    public void setWc(boolean wc) {
        this.wc = wc;
    }
    
     /**
     * Definir o tipo de Negócio
     * 
     * @param tipoNegocio
     */
    public void setTipoNegocio(String tipoNegocio) {
        this.tipoNegocio = tipoNegocio;
    }
    
    /**
     * Definir o número da Porta
     * 
     * @param numPorta
     */
    public void setNumPorta(int numPorta) {
        this.numPorta = numPorta;
    }
    
     /**
     * Definir o ano de Construção
     * 
     * @param anoConstrucao
     */
    public void setAnoConstrucao(int anoConstrucao) {
        this.anoConstrucao = anoConstrucao;
    }
    
    /** 
     * Devolve uma cópia desta instância 
     * 
     * @return cópia do objecto
     */
    public Loja clone(){
        return new Loja(this);
    }
    
     /**
     * Método que devolve uma representação da Loja no formato textual
     * 
     * @return string que representa a loja
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("\t Área: " + area + "\n");
        sb.append("\t Posui WC: " + (wc ? "Sim" : "Nao") + "\n");
        sb.append("\t Tipo de Negócio: " + tipoNegocio + "\n");
        sb.append("\t Número da Porta: " + numPorta + "\n");
        sb.append("\t Ano Construção: " + anoConstrucao + "\n");
        sb.append("\t Contacto vendedor: " + super.getVendedor() + "\n");
        
        
        return "\t .: Loja :." + super.toString() + sb.toString();
    }
}
