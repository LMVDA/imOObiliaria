

/**
 * Escreva a descrição da classe ComparadorPreco aqui.
 * 
 * @author G23
 * @version 05/05/2016
 */

import java.util.Comparator;

import java.io.Serializable;

public class ComparadorPreco implements Comparator<Imovel>, Serializable{
    
    /**
     * Método que compara dois imóveis pelo seu preço
     * 
     * @param i1 Imóvel 1
     * @param i2 Imóvel 2
     * e
     * @return 1 se i1 apresenta um preço mais elevado que i2,
     *        -1 se i2 apresenta um preço mais elevado que i1,
     *         0 se apresentam o mesmo preço
     */
    public int compare(Imovel i1, Imovel i2){
        int p1 = i1.getPrecoPedido();
        int p2 = i2.getPrecoPedido();
        
        if(p1 < p2){
            return -1;
        }
        if (p1 == p2) {
            return 0;
        }
        return 1;
    }
    
  
}
