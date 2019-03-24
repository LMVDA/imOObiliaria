
/**
 * Write a description of class Terreno here.
 * 
 * @author G23
 * @version 4/5/2016 
 */

import java.io.Serializable;

public class Terreno extends Imovel implements Serializable{
    /**
     * Variáveis de instância
     */
    private int areaDisponivel;
    private TipoTerreno tipo;
    private int diametroCanalizacoes;
    private boolean redeInstalada;
    private int potenciaMax; 
    private boolean redeEsgotos;
    
    /**
     * Construtor Vazio
     */
    
    public Terreno(){
        
        super();
        
        areaDisponivel = 0;
        diametroCanalizacoes = 0;
        potenciaMax = 0;
    }
    
    /**
     * Consturtor por partes
     *
     * @param codigo
     * @param rua
     * @param precoPedido
     * @param precoMin
     * @param estado
     *
     * @param areaDisponivel
     * @param tipo
     * @param diametroCanalizacoes
     * @param redeInstalada
     * @param potenciaMax
     * @param redeEsgotos
     */
    
    public Terreno(String codigo, String rua, int precoPedido, int precoMin, EstadoImovel estado, int areaDisponivel, TipoTerreno tipo, int diametroCanalizacoes, boolean redeInstalada, int potenciaMax, boolean redeEsgotos){
        
        super(codigo, rua, precoPedido, precoMin, estado);
        
        this.areaDisponivel = areaDisponivel;
        this.tipo = tipo;
        this.diametroCanalizacoes = diametroCanalizacoes;
        this.redeInstalada = redeInstalada;
        this.potenciaMax = potenciaMax;
        this.redeEsgotos = redeEsgotos;
    }
    
    /**
     * Constutor copia
     * 
     * @param t
     */
    public Terreno(Terreno t){
        
        super(t);
        
        this.areaDisponivel = t.getAreaDisponivel();
        this.tipo = t.getTipo();
        this.diametroCanalizacoes = t.getDiametroCanalizacoes();
        this.redeInstalada = t.getRedeInstalada();
        this.potenciaMax = t.getPotenciaMax();
        this.redeEsgotos = t.getRedeEsgotos();
    }
    
    /** GETS **/
    
    /**
     * Obter a area disponivel
     * 
     * @return a area disponivel
     */
    public int getAreaDisponivel(){
        return areaDisponivel;
    }
    
    /**
     * Obter o tipo de terreno
     * 
     * @returm o tipo de terreno (HABITACAO, ARMAZEM)
     */
    public TipoTerreno getTipo(){
        return tipo;
    }
    
    /**
     * Obter o diametro das canalizacoes
     * 
     * @return o diametro das canalizacoes
     */
    public int getDiametroCanalizacoes(){
        return diametroCanalizacoes;
    }
    
    /**
     * Saber se o terreno possui rede instalada
     * 
     * @return true se possuir rede instalada, false c.c.
     */
    
    public boolean getRedeInstalada(){
        return redeInstalada;
    }
    
    /**
     * Obter a potencia maxima 
     * 
     * @return a potencia maxima
     */
    public int getPotenciaMax(){
        return potenciaMax;
    }
    
    /**
     * Saber se o terreno possui rede de esgotos
     * 
     * @return true se possuir rede de esgotos, false c.c.
     */
    
    public boolean getRedeEsgotos(){
        return redeEsgotos;
    }
        
    /** SETS **/
    
    /**
     * Definir a area disponivel
     * 
     * @param areaDisponivel
     * 
     */
    public void setAreaDisponivel(int areaDisponivel){
        this.areaDisponivel = areaDisponivel;
    }
    
    /**
     * Definir o tipo de terreno
     * 
     * @param tipo (HABITACAO, ARMAZEM)
     */
    public void setTipoTerreno(TipoTerreno tipo){
        this.tipo = tipo;
    }
    
    /**
     * Definir o diametro das canalizacoes
     * 
     * @param diametroCanalizacoes
     */
    public void setDiametroCanalizacoes(int diametroCanalizacoes){
        this.diametroCanalizacoes = diametroCanalizacoes;
    }
    
    /**
     * Definir se o apartamento tem rede instalada ou não
     * 
     * @param redeInstalada
     */
    
    public void setRedeInstalada(boolean redeInstalada){
        this.redeInstalada = redeInstalada;
    }
    
    /**
     * Definir a potencia maxima
     * 
     * @param potenciaMax
     * 
     */
    public void setPotenciaMax(int potenciaMax){
        this.areaDisponivel = areaDisponivel;
    }
    
    /**
     * Definir se o apartamento tem rede de esgotos ou não
     * 
     * @param redeEsgotos
     */
    
    public void setRedeEsgotos(boolean redeEsgotos){
        this.redeEsgotos = redeEsgotos;
    }
    
    /**
     * Devolve uma cópia desta instância 
     * 
     * @return cópia do objecto
     */
    public Terreno clone(){
        return new Terreno(this);
    }
    
    /**
     * Método que devolve uma representação do Apartamento no formato textual
     * 
     * @return string que representa a moradia
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("\t Area disponivel: " + areaDisponivel + "\n");
        sb.append("\t Tipo de terreno: " + tipo + "\n");
        sb.append("\t Diametro das canalizacoes: " + diametroCanalizacoes + "milimetros. \n");
        sb.append("\t Possui rede instalada: " + (redeInstalada ? "Sim" : "Nao") + "\n");
        sb.append("\t Potencia Maxima: " + potenciaMax + "kWh\n");
        sb.append("\t Possui rede de Esgotos: " + (redeEsgotos ? "Sim" : "Nao") + "\n");
        sb.append("\t Contacto vendedor: " + super.getVendedor() + "\n");
        
        return "\t .: Terreno :." + super.toString()+sb.toString();
    }
 

}
