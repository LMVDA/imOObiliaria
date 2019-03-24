
/**
 * Abstract class Utilizador - write a description of the class here
 * 
 * @author G23
 * @version 4/5/2016 
 */
import java.util.List;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Utilizador implements Serializable{
    
    /**
     * Variáveis de instância
     */
    private String email;
    private String nome;
    private String password;
    private String morada;
    private LocalDate dataNascimento;
    
    /**
     * Construtor vazio
     */
    public Utilizador(){
        email = "n/a";
        nome = "n/a";
        password = "n/a";
        morada = "n/a";
        dataNascimento = LocalDate.now();
    }
            
    /**
     * Construtor por partes
     * 
     * @param email
     * @param nome
     * @param password
     * @param morada
     * @param dataNascimento
     */
    public Utilizador(String email, String nome, String password, String morada, LocalDate dataNascimento){
        this.email = email;
        this.nome = nome;
        this.password = password;
        this.morada = morada;
        this.dataNascimento = LocalDate.from(dataNascimento);
    }
    
    /**
     * Construtor cópia
     * 
     * @param u utilizador
     */
    public Utilizador(Utilizador u){
        this.email = u.getEmail();
        this.nome = u.getNome();
        this.password = u.getPassword();
        this.morada = u.getMorada();
        this.dataNascimento = u.getDataNascimento();
    }
    
    /** GETS **/
    
    /**
     * Obter o email do utilizador
     * 
     * @return o email
     */
    public String getEmail(){
        return email;
    }
    
    /**
     * Obter o nome do utilizador
     * 
     * @return o nome
     */
    public String getNome(){
        return nome;
    }
    
    /**
     * Obter a password do utilizador
     * 
     * @return a password
     */
    public String getPassword(){
        return password;
    }
    
    /**
     * Obter a morada do utilizador
     * 
     * @return a morada
     */
    public String getMorada(){
        return morada;
    }
    
    /**
     * Obter a data de nascimento do utilizador
     * 
     * @return a data de nascimento
     */
    public LocalDate getDataNascimento(){
        return LocalDate.from(dataNascimento);
    }
    
    /** SETS **/
    
    /**
     * Definir o email do utilizador
     * 
     * @param email
     */
    public void setEmail(String email){
        this.email = email;
    }
    
    /**
     * Definir o nome do utilizador
     * 
     * @param nome
     */
    public void setNome(String nome){
        this.nome = nome;
    }
    
    /**
     * Definir a password do utilizador
     * 
     * @param password
     */
    public void setPassword(String password){
        this.password = password;
    }
    
    /**
     * Definir a morada do utilizador
     * 
     * @param morada
     */
    public void setMorada(String morada){
        this.morada = morada;
    }
    
    /**
     * Definir a data de nascimento do utilizador
     * 
     * @param dataNascimento 
     */
    public void setDataNascimento(LocalDate dataNascimento){
        this.dataNascimento = LocalDate.from(dataNascimento);
    }

    /**
     * Método abstract 
     * Devolve uma cópia desta instância 
     * 
     * @return cópia do objecto
     */
    public abstract Utilizador clone();
    
    /**
     * Método que compara a igualdade com outro objecto
     * 
     * @param o 
     * @return true se os objectos são iguais, false c.c.
     */
    public boolean equals(Object o){
        
        if(o == this) return true;
        
        if(o == null) return false;
        
        if(o.getClass() != this.getClass()) return false;
        
        Utilizador u = (Utilizador) o;
        
        return email.equals(u.getEmail());
    }
    
    /**
     * Método que devolve uma representação do utilizador no formato textual
     * 
     * @return string que representa o utilizador
     */
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();
        
        sb.append("\t Email: " + email + "\n");
        sb.append("\t Nome: " + nome + "\n");
        sb.append("\t Morada: " + morada + "\n");
        sb.append("\t Data de nascimento: ");
        sb.append(dataNascimento.format(formatter));
        sb.append("\n");
        
        return sb.toString();
    }    
}
