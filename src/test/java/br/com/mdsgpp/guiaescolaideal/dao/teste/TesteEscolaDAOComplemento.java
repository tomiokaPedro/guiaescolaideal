package br.com.mdsgpp.guiaescolaideal.dao.teste;

import java.sql.SQLException;
import java.text.ParseException;

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
	public void testPesquisarPorNomeInvalidao() throws SQLException, ParseException {
		this.dao.pesquisarPorNome("", 0, 100);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPesquisarPorNomeValorInteiroInvalido() throws SQLException, ParseException {
		this.dao.pesquisarPorNome("x", -1, 100);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPesquisarPorNomeValorInteiroInvalidoQuantidade() throws SQLException, ParseException {
		this.dao.pesquisarPorNome("x", 0, 0);
	}
}
