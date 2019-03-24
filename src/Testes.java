

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Set;
import java.time.LocalDate;

/**
 * The test class Testes.
 *
 *  Classe de testes que permite testar as exepções implementadas e testes à aplicação
 *
 * @author G23
 * @version 20/05/2016
 */



public class Testes {
    private Imoobiliaria imo;
    private Vendedor v;
    private Terreno t;

    /**
     * Teste principal
     */
    @Test
    public void mainTest() {
        imo = new Imoobiliaria();
        try {
            imo.iniciaSessao("",null);
            fail();
        } catch(SemAutorizacaoException e) {
            
        } catch(Exception e) {
            fail();
        }
                
        try {
            v = new Vendedor("jsilva@imoobiliaria.com", "123j", "José Silva", "Rua de Braga", LocalDate.now());  // Preencher parâmetros do construtor
            imo.registarUtilizador(v);
        } catch(Exception e) {
            fail();
        }
             
        String email = v.getEmail();
        String password = v.getPassword();
        
        try {
            imo.iniciaSessao(email, password);
        } catch (Exception e) {
            fail();
        }        
        
        t = new Terreno("Imovel1", "Rua do Terreno", 100000, 90000, EstadoImovel.VENDA, 200, TipoTerreno.ARMAZEM, 5, true, 500, true);  // Preencher parâmetros do construtor
        try {
            imo.registaImovel(t);
        } catch(ImovelExisteException e) {
            System.out.println(e.getMessage());
        } catch(SemAutorizacaoException e){
            System.out.println(e.getMessage());
        }
                 
        int s = imo.getImovel("Terreno", Integer.MAX_VALUE).size();
        assertTrue(s>0);
           
        Set<String> ids = imo.getTopImoveis(0);
        
        assertTrue(ids.contains(t.getCodigo())); // falta as consultas
        assertTrue(imo.getMapeamentoImoveis().keySet().contains(t));
        try {
            assertTrue(imo.getConsultas().size()>0);
        } catch(Exception e) {
            fail();
        }
        
        imo.fechaSessao();
        Comprador c = new Comprador("msantos@gmail.com", "Maria Santos", "abcd", "Rua da Universidade", LocalDate.now());  // Preencher parâmetros do construtor
        try {
            imo.registarUtilizador(c);
        } catch(Exception e) {
            fail();
        }
        email = c.getEmail();
        password = c.getPassword();
        try {
            imo.iniciaSessao(email, password);
            imo.setFavorito(t.getCodigo());
            assertTrue(imo.getFavoritos().contains(t));
        } catch(Exception e) {
            e.printStackTrace();
            fail();
        }
    }
    
    /**
     * Método que lança a excepção quando se tenta pesquisar por um imóvel inexistente 
     */
    @Test(expected = ImovelInexistenteException.class)
    public void TesteImovelInexistente() throws ImovelInexistenteException {
        imo = new Imoobiliaria();
        
        imo.pesquisarImovel("1");
    }
    
    /**
     * Método que lança a excepção quando se tenta registar um utilizador existente na aplicação
     */
    @Test(expected = UtilizadorExistenteException.class)
    public void UtilizadorExistente() throws UtilizadorExistenteException {
        imo = new Imoobiliaria();
        
        Comprador c = new Comprador("msantos@gmail.com", "Maria Santos", "abcd", "Rua da Universidade", LocalDate.now());  // Preencher parâmetros do construtor
        try {
            imo.registarUtilizador(c);
        } catch(Exception e) {
            fail();
        }
        
        imo.registarUtilizador(c);
    }
    
    /**
     * Método que lança uma excepção que identifica o utilizador não tem autorização para ficar autenticado na aplicação
     */
    @Test(expected = SemAutorizacaoException.class)
    public void SemAutorizacao() throws SemAutorizacaoException{
        imo = new Imoobiliaria();
        
        imo.iniciaSessao("", "");
    }
    
    /**
     * Método que lança excepção quando se tenta definir um estado inválido para um imóvel
     */
    @Test(expected = EstadoInvalidoException.class)
    public void EstadoInvalido() throws EstadoInvalidoException {
        imo = new Imoobiliaria();
        
        try {
            v = new Vendedor("jsilva@imoobiliaria.com", "José Silva", "123j", "Rua de Braga", LocalDate.now()); 
            v.addImovelVenda("Imovel1");
            imo.registarUtilizador(v);
            
            imo.iniciaSessao("jsilva@imoobiliaria.com", "123j");
            
            t = new Terreno("Imovel1", "Rua do Terreno", 100000, 90000, EstadoImovel.VENDA, 200, TipoTerreno.ARMAZEM, 5, true, 500, true);
            t.setVendedor("jsilva@imoobiliaria.com");
            imo.registaImovel(t);
        }
        catch (Exception e) { }
        
        try {
            imo.setEstado("Imovel1", "Invalido");
        }
        catch (ImovelInexistenteException e) { }
        catch (SemAutorizacaoException e) { }
    }
    
    
    /**
     * Método que lança excepção quando se tenta registar um imóvel já existente na aplicação
     */
    @Test(expected = ImovelExisteException.class)
    public void ImovelExist() throws ImovelExisteException {
        imo = new Imoobiliaria();
        
        try {
            v = new Vendedor("jsilva@imoobiliaria.com", "José Silva", "123j", "Rua de Braga", LocalDate.now()); 
            v.addImovelVenda("Imovel1");
            imo.registarUtilizador(v);
            
            imo.iniciaSessao("jsilva@imoobiliaria.com", "123j");
            
            t = new Terreno("Imovel1", "Rua do Terreno", 100000, 90000, EstadoImovel.VENDA, 200, TipoTerreno.ARMAZEM, 5, true, 500, true);
            t.setVendedor("jsilva@imoobiliaria.com");
            imo.registaImovel(t);
        }
        catch (Exception e) { }
        
        try {
            imo.registaImovel(t);
        }
        catch (SemAutorizacaoException e) { }
    }
    
}
