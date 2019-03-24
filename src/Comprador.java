
/**
 * Write a description of class Comprador here.
 * 
 * @author G23
 * @version 04/05/2016
 */
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Iterator;

public class Comprador extends Utilizador {
    
    /**
     * Variáveis de instância
     */
    private List<String> imoveisFavoritos; // imóveis favoritos
    
    /**
     * Construtor vazio
     */
    public Comprador(){
        super();
        
        imoveisFavoritos = new ArrayList<String>();
    }
    
    /**
     * Construtor por partes
     * 
     * @param imoveisFavoritos
     * 
     */
    public Comprador(String email, String nome, String password, String morada, LocalDate dataNascimento, List<String> imoveisFavoritos){
        
        super(email, nome, password, morada, dataNascimento);
        
        setImoveisFavoritos(imoveisFavoritos);
            
    }
    
    /**
     * Construtor por partes
     * 
     * @param imoveisFavoritos
     * 
     */
    public Comprador(String email, String nome, String password, String morada, LocalDate dataNascimento){
        
        super(email, nome, password, morada, dataNascimento);
        
        imoveisFavoritos = new ArrayList<String>();
                   
    }
    
    /**
     * Construtor cópia
     * 
     * @param c comprador
     */
    public Comprador(Comprador c){
        super(c);
        
        this.imoveisFavoritos = c.getImoveisFavoritos();
    }
    
    /**
     * Devolve uma cópia desta instância 
     * 
     * @return cópia do objecto Comprador
     */
    public Comprador clone(){
        return new Comprador(this);
    }
    
    /** GETS **/
    
    /**
     * Obter os imoveis Favoritos
     * 
     * @return 
     */
    public List<String> getImoveisFavoritos(){
        List<String> f = new ArrayList<String>();
        
        f.addAll(imoveisFavoritos);   
        
        return f;
        
    }
    
    /** SETS **/
    
    /**
     * Definir os imoveis Favoritos
     * 
     * @param imoveisFavoritos
     * 
     */
    public void setImoveisFavoritos(List<String> imoveisFavoritos){
        this.imoveisFavoritos = new ArrayList<String>();
        
        this.imoveisFavoritos.addAll(imoveisFavoritos);      
        
    }
    
    /**
     * Método que devolve uma representação do comprador no formato textual
     * 
     * @return string que representa o comprador 
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        int i = 1;
        
        sb.append("\t - Lista de imóveis Favoritos: \n");
        
        for(String cod : imoveisFavoritos){
            sb.append("\t \t Imovel favorito nº: " + i + ": " + cod + "\n");
            i++;
        }
        
        return super.toString() + "\n" +sb.toString();
    }

    /**
     * Método que devolve uma representação do comprador no formato textual
     *
     * @return string que representa o comprador
     */
    public String toStringSimples(){
        return super.toString();
    }
    
        
    /**
     * Método que adiciona um imóvel aos favoritos do comprador (caso ainda não tenha sido adicionado)
     * 
     * @param codigo
     */
    public void adicionaFavorito(String codigo){
 
        if(!imoveisFavoritos.contains(codigo)) {
            imoveisFavoritos.add(codigo);
        }
    }

    /**
     * Método que remove um imóvel dos favoritos do comprador
     *
     * @param codigo
     */
    public void removeFavorito(String codigo){
        imoveisFavoritos.remove(codigo);
    }
}
