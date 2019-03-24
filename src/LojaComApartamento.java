
/**
 * Write a description of class LojaComApartamento here.
 * 
 * @author G23
 * @version 10/05/2016
 */

public class LojaComApartamento extends Loja implements Habitavel {
    
    /**
     * Variável de instância
     */
    private Apartamento apartamento;
    
    /**
     * Construtor vazio
     */
    public LojaComApartamento(){
        
        super(); 
        
        apartamento = new Apartamento();
    }
    
    
    /**
     * Construtor por partes
     *
     * @param codigo
     * @param rua
     * @param precoPedido
     * @param precoMin
     * @param estado
     * @param area
     * @param wc
     * @param tipoNegocio
     * @param numPorta
     * @param anoConstrucao
     * @param apartamento
     */
    public LojaComApartamento(String codigo, String rua, int precoPedido, int precoMin, EstadoImovel estado, int area, boolean wc, String tipoNegocio, int numPorta, int anoConstrucao, Apartamento apartamento){
        super(codigo, rua, precoPedido, precoMin, estado, area, wc, tipoNegocio, numPorta, anoConstrucao);
        this.apartamento = apartamento.clone();
    }
    
    /**
     * Construtor cópia
     * 
     * @param lojacomApartamento
     */
    public LojaComApartamento(LojaComApartamento lojacomApartamento){
        super(lojacomApartamento);
        
        apartamento = lojacomApartamento.getApartamento();
    }

    /** GETS **/
    
    /**
     * Obter a apartamento existente na loja 
     * 
     * @return o apartamento da loja
     */
    public Apartamento getApartamento() {
        return apartamento.clone();
    }
    
    /** SETS **/
    
    /**
     * Definir o apartamento da loja
     * 
     * @param apartamento
     */
    public void setArea(Apartamento apartamento) {
        this.apartamento = apartamento.clone();
    }
    
    /** 
     * Devolve uma cópia desta instância 
     * 
     * @return cópia do objecto
     */
    public LojaComApartamento clone(){
        return new LojaComApartamento(this);
    }
    
    /**
     * Método que devolve uma representação do apartamento com loja no formato textual
     * 
     * @return string que representa o Apartamento com loja
     */
    public String toString(){

        StringBuilder sb = new StringBuilder();

        sb.append(apartamento.toString());
        sb.append("\t Dados apartamento\n");
        sb.append("\t Contacto vendedor: " + super.getVendedor() + "\n");

        
        return "\t .: Loja com apartamento :.\n" + super.toString() + sb.toString();
    }
    
    /**
     * Devolve o número de quartos
     * 
     * @return o número de quartos
     */
    public int getTipologia(){
        return apartamento.getNumQuartos();
    }
}
