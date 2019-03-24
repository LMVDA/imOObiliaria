
/**
 * Write a description of class Consulta here.
 *
 * @author G23
 * @version 10/05/2016
 */
import java.io.Serializable;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Consulta implements Comparable<Consulta>, Serializable{
    /**
     * Variáveis de instância
     */
    private String email;
    private LocalDateTime dataConsulta;

    /**
     * Construtor vazio
     */
    public Consulta(){
        email = "n/a";
        dataConsulta = LocalDateTime.now();
    }

    /**
     * Construtor cópia
     *
     * @param c consulta
     */
    public Consulta(Consulta c){
        this.email = c.getEmail();
        this.dataConsulta = c.getDataConsulta();
    }
    
    /**
     * Construtor por partes
     * 
     * @param email
     */
    public Consulta(String email){
        if(email == "") this.email = "Utilizador não autenticado";
        else this.email = email;
        
        dataConsulta = LocalDateTime.now();
    }

    /**
     * Construtor por partes
     *
     * @param email
     * @param dataConsulta
     */
    public Consulta(String email, LocalDateTime dataConsulta){
        this.email = email;
        this.dataConsulta = LocalDateTime.from(dataConsulta);
    }

    /**GETS **/

    /**
     * Obter o email do utilizador que efectou a consulta
     *
     * @return o email do utilzador
     */
    public String getEmail(){
        return email;
    }

    /**
     * Obter a data em que a consulta foi efectuada
     *
     * @return a data da consulta
     */
    public LocalDateTime getDataConsulta(){
        return LocalDateTime.from(dataConsulta);
    }

    /** SETS **/

    /**
     * Definir o email do utilizador que efectuou a consulta 
     *
     * @param email
     */
    public void setEmail(String email){
        this.email = email;
    }

    /**
     * Definir a data em que a consulta ocorreu
     *
     * @param dataConsulta
     */
    public void setDataConsulta(LocalDateTime dataConsulta){
        this.dataConsulta = LocalDateTime.from(dataConsulta);
    }

    /**
     * Método que devolve cópia desta instância
     *
     * @return cópia do objecto
     */
    public Consulta clone(){
        return new Consulta(this);
    }

    /**
     * Método que compara a igualdade com outro objecto
     *
     * @param o
     * @return true se os objectos são iguais, false c.c
     */
    public boolean equals(Object o){

        if(o == this) return true;

        if(o == null) return false;

        if(o.getClass() != this.getClass()) return false;

        Consulta c = (Consulta) o;

        return email.equals(c.getEmail()) && (dataConsulta.equals(c.getDataConsulta()));
    }

    /**
     * Método que devolve uma representação da consulta no formato textual
     *
     * @return string que representa a consulta
     */
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        StringBuilder sb = new StringBuilder();
        String e = email;

        if(email.equals(""))
            e = "Utilizador não autenticado";

        sb.append("\t Email: " + e + "\n");
        sb.append("\t Data da consulta: ");
        sb.append(dataConsulta.format(formatter));
        sb.append("\n");

        return sb.toString();
        
    }

    /**
     * Ordem Natural definida para comparar as consultas: Comparação pela data mais recente
     *
     * @param c
     * @return 0 se as datas forem iguais, 1 se a data parâmetro for maior, -1 cc
     */
    public int compareTo(Consulta c){
        LocalDateTime data = c.getDataConsulta();

        return data.compareTo(dataConsulta);
    }




}