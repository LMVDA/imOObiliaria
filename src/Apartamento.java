
/**
 * Write a description of class Apartamento here.
 * 
 * @author G23
 * @version 4/5/2016
 */
import java.io.Serializable;

public class Apartamento extends Imovel implements Habitavel, Serializable {
        
    /**
     * Variáveis de instância
     */
    private TipoApartamento tipo;
    private int areaTotal;
    private int numQuartos;
    private int numWCs;
    private int numPorta;
    private int numAndar;
    private int anoConstrucao;
    private TipoAquecimento tipoAquecimento;
    private boolean garagem;
    private int areaGaragem;
    
    /**
     * Construtor Vazio
     */
    
    public Apartamento(){
        
        super();
        
        areaTotal = 0;
        numQuartos = 0;
        numWCs = 0;
        numPorta = 0;
        numAndar = 0;
        anoConstrucao = 0;
        areaGaragem = 0;
    }
    
    /**
     * Construtor por partes
     *
     * @param codigo
     * @param rua
     * @param precoPedido
     * @param precoMin
     * @param estado
     * @param tipo
     * @param areaTotal
     * @param numQuartos
     * @param numWCs
     * @param numPorta
     * @param numAndar
     * @param anoConstrucao
     * @param tipoAquecimento
     * @param garagem
     * @param areaGaragem
     * 
     */
    public Apartamento(String codigo, String rua, int precoPedido, int precoMin, EstadoImovel estado, TipoApartamento tipo, int areaTotal, int numQuartos, int numWCs, int numPorta, int numAndar, int anoConstrucao, TipoAquecimento tipoAquecimento, boolean garagem, int areaGaragem){
        
        super(codigo, rua, precoPedido, precoMin, estado);
        
        this.tipo = tipo;
        this.areaTotal = areaTotal;
        this.numQuartos = numQuartos;
        this.numWCs = numWCs;
        this.numPorta = numPorta;
        this.numAndar = numAndar;
        this.anoConstrucao = anoConstrucao;
        this.tipoAquecimento = tipoAquecimento;
        this.garagem = garagem;
        this.areaGaragem = areaGaragem;
    }
    
    /**
     * Construtor Cópia
     * 
     * @param a
     */
    
    public Apartamento(Apartamento a){
        
        super(a);
        
        this.tipo = a.getTipoApartamento();
        this.areaTotal = a.getAreaTotal();
        this.numQuartos = a.getNumQuartos();
        this.numWCs = a.getNumWCs();
        this.numPorta = a.getNumPorta();
        this.numAndar = a.getNumAndar();
        this.anoConstrucao = a.getAnoConstrucao();
        this.tipoAquecimento = a.getTipoAquecimento();
        this.garagem = a.getGaragem();
        this.areaGaragem = a.getAreaGaragem();
    }
    
    /** GETS **/    
    
    /**
     * Obter o tipo do apartamento
     * 
     * @return o tipo do apartamento (SIMPLES,DUPLEX,TRIPLEX)
     */
    
    public TipoApartamento getTipoApartamento(){
        return tipo;
    }
    
    /**
     * Obter a area total do apartamento
     * 
     * @return a area total do apartamento
     */
    
    public int getAreaTotal(){
        return areaTotal;
    }
    
    /**
     * Obter o numero de quartos do apartamento
     * 
     * @return o numero de quartos do apartamento
     */
    
    public int getNumQuartos(){
        return numQuartos;
    }
    
    /**
     * Obter o numero de WCs do apartamento
     * 
     * @return o numero de WCs do apartamento
     */
    
    public int getNumWCs(){
        return numWCs;
    }
    
    /**
     * Obter o numero da porta do apartamento
     * 
     * @return o numero da porta do apartamento
     */
    
    public int getNumPorta(){
        return numPorta;
    }
    
    /**
     * Obter o numero do andar do apartamento
     * @return o numero do andar do apartamento
     */
    
    public int getNumAndar(){
        return numAndar;
    }
    
    /**
     * Obter o ano de construcao do apartamento
     * 
     * @return o ano de construcao do apartamento
     */
    
    public int getAnoConstrucao(){
        return anoConstrucao;
    }
    
    /**
     * Obter o tipo de aquecimento do apartamento
     * 
     * @return o o tipo de aquecimento do apartamento (AR_CONDICIONADO, PISO_RADIANTE, AQUECIMENTO_CENTRAL, NENHUM)
     */
    
    public TipoAquecimento getTipoAquecimento(){
        return tipoAquecimento;
    }
    
    /**
     * Saber se o apartamento tem garagem ou nao
     * 
     * @return true se possuir garagem, false c.c.
     */
    
    public boolean getGaragem(){
        return garagem;
    }
    
    /**
     * Obter a area da garagem
     * 
     * @return a area da garagem
     */
    
    public int getAreaGaragem(){
        return areaGaragem;
    }
    
    /** SETS **/
        
    /**
     * Definir o tipo do apartamento (SIMPLES,DUPLEX,TRIPLEX)
     * 
     * @param tipoApartamento
     */
    
    public void setTipoApartamento(TipoApartamento tipoApartamento){
        this.tipo = tipoApartamento;
    }
    
    /**
     * Definir a area total do apartamento
     * 
     * @param areaTotal
     */
    
    public void setAreaTotal(int areaTotal){
        this.areaTotal = areaTotal;
    }
    
    /**
     * Definir o numero de quartos do apartamento
     * 
     * @param numQuartos
     */
    
    public void setNumQuartos(int numQuartos){
        this.numQuartos = numQuartos;
    }
    
    /**
     * Definir o numero de WCs do apartamento
     * 
     * @param numWCs
     */
    
    public void setNumWCs(int numWCs){
        this.numWCs = numWCs;
    }
    
    /**
     * Definir o numero da porta do apartamento
     * 
     * @param numPorta
     */
    
    public void setNumPorta(int numPorta){
        this.numPorta = numPorta;
    }
    
    /**
     * Definir o numero do andar do apartamento
     * 
     * @param numAndar
     */
    
    public void setNumAndar(int numAndar){
        this.numAndar = numAndar;
    }
    
    /**
     * Definir o ano de construcao do apartamento
     * 
     * @param anoConstrucao
     */
    
    public void setAnoConstrucao(int anoConstrucao){
        this.anoConstrucao = anoConstrucao;
    }
    
    /**
     * Definir o tipo de aquecimento do apartamento (AR_CONDICIONADO, PISO_RADIANTE, AQUECIMENTO_CENTRAL, NENHUM)
     * 
     * @param tipoAquecimento
     */
    
    public void setTipoAquecimento(TipoAquecimento tipoAquecimento){
        this.tipoAquecimento = tipoAquecimento;
    }
    
    /**
     * Definir se o apartamento tem garagem ou não
     * 
     * @param garagem
     */
    
    public void setGaragem(boolean garagem){
        this.garagem = garagem;
    }
    
    /**
     * Definir a area da garagem
     * 
     * @return a area da garagem
     */
    
    public void setAreaGaragem(int areaGaragem){
        this.areaGaragem = areaGaragem;
    }
    
    /**
     * Devolve uma cópia desta instância 
     * 
     * @return cópia do objecto Apartamento
     */
    public Apartamento clone(){
        return new Apartamento(this);
    }
    
    /**
     * Método que devolve uma representação da Apartamento no formato textual
     * 
     * @return string que representa o apartamento
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("\t Tipo de apartamento: " + tipo + "\n");
        sb.append("\t Area total: " + areaTotal + "\n");
        sb.append("\t Numero de quartos: " + numQuartos + "\n");
        sb.append("\t Numero de WCs: " + numWCs + "\n");
        sb.append("\t Numero de Porta: " + numPorta + "\n");
        sb.append("\t Numero de Andar: " + numAndar + "\n");
        sb.append("\t Ano de construcao: " + anoConstrucao + "\n");
        sb.append("\t Tipo de aquecimento: " + tipoAquecimento + "\n");
        sb.append("\t Possui garagem: " + (garagem ? "Sim" : "Nao") + "\n");
        if(garagem) {sb.append("\t Área de garagem: " + areaGaragem + "\n");}
        sb.append("\t Contacto vendedor: " + super.getVendedor() + "\n");
        
        return "\t .: Apartamento :." + super.toString() + sb.toString();
    }
        
    /**
     * Devolve o número de quartos
     * 
     * @return o número de quartos
     */
    public int getTipologia(){
        return numQuartos;
    }
   

}
