
/**
 * Write a description of class Moradia here.
 * 
 * @author G23
 * @version 4/5/2016 enum,exceçoes,interfaces
 */
import java.io.Serializable;

public class Moradia extends Imovel implements Habitavel, Serializable {
    
    /**
     * Variáveis de instância
     */
    private TipoMoradia tipo;
    private int areaImplantacao;
    private int areaTotalCoberta;
    private int areaTerrenoEnvolvente;
    private int numQuartos;
    private int numWCs;
    private int numPorta;
    private int anoConstrucao;
    private TipoAquecimento tipoAquecimento;
    
    /**
     * Construtor Vazio
     */
    public Moradia(){
        
        super();
        
        areaImplantacao = 0;
        areaTotalCoberta = 0;
        areaTerrenoEnvolvente = 0;
        numQuartos = 0;
        numWCs = 0;
        numPorta = 0;
        anoConstrucao = 0;
    }
    
    
    
    /**
     * Construtor por partes
     * 
     *
     * @param codigo
     * @param rua
     * @param precoPedido
     * @param precoMin
     * @param estado
     * @param tipo
     * @param areaImplantacao
     * @param areaTotalCoberta
     * @param areaTerrenoEnvolvente
     * @param numQuartos
     * @param numWCs
     * @param numPorta
     * @param anoConstrucao
     * @param tipoAquecimento
     */
    public Moradia(String codigo, String rua, int precoPedido, int precoMin, EstadoImovel estado, TipoMoradia tipo, int areaImplantacao, int areaTotalCoberta, int areaTerrenoEnvolvente, int numQuartos, int numWCs, int numPorta, int anoConstrucao, TipoAquecimento tipoAquecimento ){
        
        super(codigo, rua, precoPedido, precoMin, estado);
        
        this.tipo = tipo;
        this.areaImplantacao = areaImplantacao;
        this.areaTotalCoberta = areaTotalCoberta;
        this.areaTerrenoEnvolvente = areaTerrenoEnvolvente;
        this.numQuartos = numQuartos;
        this.numWCs = numWCs;
        this.numPorta = numPorta;
        this.anoConstrucao = anoConstrucao;
        this.tipoAquecimento = tipoAquecimento;    
    }
    
    /**
     * Constutor copia
     * 
     * @param m
     */
    public Moradia(Moradia m){
        
        super(m);
        
        this.tipo = m.getTipo();
        this.areaImplantacao = m.getAreaImplantacao();
        this.areaTotalCoberta = m.getAreaTotalCoberta();
        this.areaTerrenoEnvolvente = m.getAreaTerrenoEnvolvente();
        this.numQuartos = m.getNumQuartos();
        this.numWCs = m.getNumWCs();
        this.numPorta = m.getNumPorta();
        this.anoConstrucao = m.getAnoConstrucao();
        this.tipoAquecimento = m.getTipoAquecimento();
    }
    
    /** GETS **/    
    
    /**
     * Obter o tipo de moradia
     * 
     * @returm o tipo de moradia (ISOLADA, GEMINADA, BANDA, GAVETO)
     */
    public TipoMoradia getTipo(){
        return tipo;
    }
        
    /**
     * Obter a area de implantacao d
     * 
     * @return a area de implantancao
     */
    public int getAreaImplantacao(){
        return areaImplantacao;
    }
    
    /**
     * Obter a area total coberta
     * 
     * @return a area total coberta
     */
    public int getAreaTotalCoberta(){
        return areaTotalCoberta;
    }
    
    /**
     * Obter a area do terreno envolvente
     * 
     * @return a area do terreno envolvente
     */
    public int getAreaTerrenoEnvolvente(){
        return areaTerrenoEnvolvente;
    }
    
    /**
     * Obter o numero de quartos da moradia
     * 
     * @return o numero de quartos que existem na moradia
     */
    public int getNumQuartos(){
        return numQuartos;
    }
    
    /**
     * Obter o numero de WCs da moradia
     * 
     * @return o numero de WCs existentes na moradia 
     */
    public int getNumWCs(){
        return numWCs;
    }
    
    /**
     * Obter o numero da porta da moradia
     * 
     * @return o numero da porta da moradia
     */
    public int getNumPorta(){
        return numPorta;
    }
    
    /**
     * Obter o ano em que foi construida a moradia 
     * 
     * @return o ano de construcao
     */
    public int getAnoConstrucao(){
        return anoConstrucao;
    }
    
    /**
     * Obter o tipo de aquecimento existente na moradia
     * 
     * @return o tipo de aquecimento (AR_CONDICIONADO, PISO_RADIANTE, AQUECIMENTO_CENTRAL, NENHUM)
     */
    public TipoAquecimento getTipoAquecimento(){
        return tipoAquecimento;
    }
    
    /** SETS **/    
    
    /**
     * Definir o tipo de moradia
     * 
     * @param tipo (ISOLADA, GEMINADA, BANDA, GAVETO)
     */
    public void setTipoMoradia(TipoMoradia tipo){
        this.tipo = tipo;
    }
    
        /**
     * Definir a area de implantacao da moradia
     * 
     * @param areaImplantacao
     * 
     */
    public void setAreaImplantacao(int areaImplantacao){
        this.areaImplantacao = areaImplantacao;
    }
    
    /**
     * Definir a area total coberta da moradia
     * 
     * @param areaTotalCoberta
     */
    public void setareAreaTotalCoberta(int areaTotalCoberta){
        this.areaTotalCoberta = areaTotalCoberta;
    }
    
    /**
     * Definir a area do terreno envolvente da moradia
     * 
     * @param areaTerrenoEnvolvente
     */
    public void setAreaTerrenoEnvolvente(int areaTerrenoEnvolvente){
        this.areaTerrenoEnvolvente = areaTerrenoEnvolvente;
    }
    
    /**
     * Definir o numero de quartos da moradia
     * 
     * @param numQuartos
     */
    public void setNumQuartos(int numQuartos){
        this.numQuartos = numQuartos;
    }
    
    /**
     * Definir o numero de WCs da moradia
     * 
     * @param numWCs
     */
    public void setNumWCs(int numWCs){
        this.numWCs = numWCs; 
    }
    
    /**
     * Definir o numero da porta da moradia
     * 
     * @param numPorta
     */
    public void setNumPorta(int numPorta){
        this.numPorta = numPorta;
    }
    
    /**
     * Definir o ano em que foi construida a moradia 
     * 
     * @param anoConstrucao
     */
    public void setAnoConstrucao(int anoConstrucao){
        this.anoConstrucao= anoConstrucao;
    }
    
    /**
     * Definir o tipo de aquecimento existente na moradia
     * 
     * @param tipoAquecimento (AR_CONDICIONADO, PISO_RADIANTE, AQUECIMENTO_CENTRAL, NENHUM)AR_CONDICIONADO, PISO_RADIANTE, AQUECIMENTO_CENTRAL, NENHUM
     */
    public void setTipoAquecimento(TipoAquecimento tipoAquecimento){
        this.tipoAquecimento = tipoAquecimento;
    }
        
    /**
     * Devolve uma cópia desta instância 
     * 
     * @return cópia do objecto Moradia
     */
    public Moradia clone(){
        return new Moradia(this);
    }
    
    /**
     * Método que devolve uma representação da Moradia no formato textual
     * 
     * @return string que representa a moradia
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("\t Tipo de moradia: " + tipo + "\n");
        sb.append("\t Area de implantacao: " + areaImplantacao + "\n");
        sb.append("\t Area total coberta: " + areaTotalCoberta + "\n");
        sb.append("\t Area de terreno envolvente: " + areaTerrenoEnvolvente + "\n");
        sb.append("\t Numero de quartos: " + numQuartos + "\n");
        sb.append("\t Numero de WCs: " + numWCs + "\n");
        sb.append("\t Numero de Porta: " + numPorta + "\n");
        sb.append("\t Ano de construcao: " + anoConstrucao + "\n");
        sb.append("\t Tipo de aquecimento: " + tipoAquecimento + "\n");
        sb.append("\t Contacto vendedor: " + super.getVendedor() + "\n");
        
        return "\t .: Moradia :." + super.toString() + sb.toString();
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
