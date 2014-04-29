package br.com.mdsgpp.guiaescolaideal.dao.teste;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import br.com.mdsgpp.guiaescolaideal.dao.EscolaDAO;

/*
 * Teste criado para complementar TesteEscolaDAO,
 * pois o DbUnit não reconhece as anotações Test, Before, etc do JUnit
 * 
 */
public class TesteEscolaDAOComplemento {
	
	EscolaDAO dao;
	
	@Before
	public void setUP(){
		this.dao = new EscolaDAO(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPesquisarPorNomeInvalidao() throws SQLException {
		this.dao.pesquisarPorNome("", 0, 100);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPesquisarPorNomeValorInteiroInvalido() throws SQLException {
		this.dao.pesquisarPorNome("x", -1, 100);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPesquisarPorNomeValorInteiroInvalidoQuantidade() throws SQLException {
		this.dao.pesquisarPorNome("x", 0, 0);
	}
}
