import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public interface Imobiliavel {

    //static Imoobiliaria initApp();

    void registarUtilizador(Utilizador utilizador) throws UtilizadorExistenteException;
    
    void iniciaSessao(String email, String password) throws SemAutorizacaoException;

    void fechaSessao();
    
    void registaImovel(Imovel im) throws ImovelExisteException, SemAutorizacaoException;
    
    List<Consulta> getConsultas() throws SemAutorizacaoException;

    void setEstado(String idImovel, String estado) throws ImovelInexistenteException, 
                                                                 SemAutorizacaoException,
                                                                 EstadoInvalidoException;
         
    public Set<String> getTopImoveis(int n);
    
    void setFavorito(String idImovel) throws ImovelInexistenteException, SemAutorizacaoException;

    TreeSet<Imovel> getFavoritos() throws SemAutorizacaoException;

    List<Imovel> getImovel(String classe, int preco);

    List<Habitavel> getHabitaveis(int preco);

    Map<Imovel, Vendedor> getMapeamentoImoveis();
}
