package br.com.mdsgpp.guiaescolaideal.dao;

/**
 * 
 * @author Augusto
 *
 * Generalizando o valor de retorno da DAO;
 * As DAOs possuem métodos com o mesmo comportamento, mas com retornos diferentes,
 * com o <V> a classe que implementar a DAO terá que especificar esse valor.
 * 
 *  documentação : <b>http://docs.oracle.com/javase/tutorial/java/generics/types.html</b>
 *  
 * @param <V> valor de retorno dos métodos;
 */
public interface DAO<V>{
	
	public V pesquisarPorID(int id);

}
