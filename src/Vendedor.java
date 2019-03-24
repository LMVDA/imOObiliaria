
/**
 * Write a description of class Vendedor here.
 * 
 * @author G23
 * @version 4 Maio 2016
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.time.LocalDate;

public class Vendedor extends Utilizador{
    
    /**
     * Variáveis de instância
     */
    private List<String> imoveisParaVenda; //Portfólio (Para venda + reservados)
    private List<String> imoveisVendidos; //Histórico
    
    
    /**
     * Construtor vazio
     */
    
    public Vendedor(){
        super();
        
        imoveisParaVenda = new ArrayList<String>();
        imoveisVendidos = new ArrayList<String>();
    }
        
    /**
     * Construtor por partes
     * 
     * @param imoveisParaVenda
     * @param imoveisVendidos
     */
    public Vendedor(String email, String nome, String password, String morada, LocalDate dataNascimento, List<String> imoveisParaVenda, List<String> imoveisVendidos){
        
        super(email, nome, password, morada, dataNascimento);
        
        setImoveisParaVenda(imoveisParaVenda);
        setImoveisVendidos(imoveisVendidos);
            
    }
    
    /**
     * Construtor por partes
     * 
     */
    public Vendedor(String email, String nome, String password, String morada, LocalDate dataNascimento){
        
        super(email, nome, password, morada, dataNascimento);
        
        imoveisParaVenda = new ArrayList<String>();
        imoveisVendidos = new ArrayList<String>();
    }
    
    
    
    /**
     * Construtor cópia
     * 
     * @param v vendedor
     */
    public Vendedor(Vendedor v){
        super(v);
        
        this.imoveisParaVenda = v.getImoveisParaVenda();
        this.imoveisVendidos = v.getImoveisVendidos();
    }
    
    /** GETS **/
    
    /**
     * Obter os imoveis em venda
     * 
     * @return 
     */
    public List<String> getImoveisParaVenda(){
        List<String> r = new ArrayList<String>();
        
        r.addAll(imoveisParaVenda);   
        
        return r;
        
    }
    
    /**
     * Obter os imóveis Vendidos
     * 
     * @return
     */
    public List<String> getImoveisVendidos(){
        List<String> r = new ArrayList<String>();
        
        r.addAll(imoveisVendidos);
        
        return r;
    }
    
    /** SETS **/
    
    /**
     * Definir os imoveis em venda
     * 
     * @param imoveisParaVenda
     * 
     */
    public void setImoveisParaVenda(List<String> imoveisParaVenda){
        this.imoveisParaVenda = new ArrayList<String>();
        
        this.imoveisParaVenda.addAll(imoveisParaVenda);      
        
    }
    
    /**
     * Definir os imóveis Vendidos
     * 
     * @param imoveisVendidos
     * 
     */
    public void setImoveisVendidos(List<String> imoveisVendidos){
        this.imoveisVendidos = new ArrayList<String>();
        
        this.imoveisVendidos.addAll(imoveisVendidos);
    }
    
    /** 
     * Devolve uma cópia desta instância 
     * 
     * @return cópia do objecto Vendedor
     */
    public Vendedor clone(){
        
        return new Vendedor(this);

    }
    
        
    /**
     * Método que devolve uma representação do utilizador no formato textual
     * 
     * @return string que representa o vendedor
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        int i = 1;

        sb.append("\t - Lista de imóveis para Venda: \n");
        for( String cod : imoveisParaVenda) {
            sb.append("\t \tImóvel para Venda nº " + i + ": " + cod +"\n");
            i++;
        }
        
        i = 1;
        
        sb.append("\t - Lista de imóveis vendidos: \n");
        for( String cod : imoveisVendidos) {
            sb.append("\t \t Imóvel vendido nº " + i + ": " + cod +"\n");
            i++;
        }
        
        return super.toString() + "\n"+ sb.toString();
    }


    /**
     * Método que devolve uma representação simples do utilizador no formato textual
     *
     * @return string que representa o vendedor
     */
    public String toStringSimples(){
        StringBuilder sb = new StringBuilder();
        int i = 0;

        return super.toString() + "\n"+ sb.toString();
    }
    
    
    /**
     * Método que adiciona um imóvel ao vendedor para venda
     * 
     * @param codigo
     */
    public void addImovelVenda(String codigo){
        imoveisParaVenda.add(codigo);
    }
    
    /**
     * Método que muda o imóvel da lista de "para venda" para a lista de vendidos dado que o imóvel foi vendido
     * 
     * @param codigo
     */
    public void vendaDoImovel(String codigo){
        
        imoveisVendidos.add(codigo);
        
        imoveisParaVenda.remove(codigo);
    }
    
    /**
     * Método que verifica se um imóvel pertence a um vendedor
     * 
     * @param codigo
     * @return true se o imóvel pertence ao vendedor, false c.c.
     */
    public boolean existeImovelVendedor(String codigo) {
        return imoveisParaVenda.contains(codigo);
    }

    /**
     * Método que remove um imóvel da lista de imóveis para venda
     * @param codigo
     */
    public void remImovelVenda(String codigo) {
        imoveisParaVenda.remove(codigo);
    }
}


