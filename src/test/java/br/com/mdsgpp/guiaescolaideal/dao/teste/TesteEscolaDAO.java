package br.com.mdsgpp.guiaescolaideal.dao.teste;

import java.io.FileInputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;

import br.com.mdsgpp.guiaescolaideal.dao.EscolaDAO;

public class TesteEscolaDAO extends DAO {
	
	private EscolaDAO dao;
	
	public TesteEscolaDAO(String name) throws SQLException, Exception {
		super(name);
		this.dao = new EscolaDAO(getConnection().getConnection());
	}
	
	@Override
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(new FileInputStream(
				"xml-dbunit/banco-escola.xml"));
	}

	@Test
	public void testPesquisarPorId() throws SQLException, Exception {
		assertNotNull(this.dao.pesquisarPorID(75001));
	}

	@Test
	public void testPesquisarPorIdInexistente() throws SQLException, Exception {
		assertNull(this.dao.pesquisarPorID(75000));
	}
	
	@Test
	public void testPesquisarPorNome() throws SQLException, Exception {
		assertTrue(this.dao.pesquisarPorNome("mds", 0, 100).size() == 1);
	}
	
	@Test
	public void testPesquisarPorNomeInexistente() throws SQLException, Exception {
		assertTrue(this.dao.pesquisarPorNome("XPTO", 0, 100).size() == 0);
	}
	
	@Test
	public void testPesquisarpesquisarPorNomeComPalavrasChaves() throws SQLException, Exception {
		List<String> listaPalavras = new ArrayList<String>();
		listaPalavras.add("mds");
		listaPalavras.add("java");
		
		assertTrue(this.dao.pesquisarPorNomeComPalavrasChaves(listaPalavras, 0, 100).size() == 1);
	}
	
	@Test
	public void testPesquisarpesquisarPorNomeComPalavrasChavesCombinaçãoInexistente() throws SQLException, Exception {
		List<String> listaPalavras = new ArrayList<String>();
		listaPalavras.add("mds");
		listaPalavras.add("ruby");
		
		assertTrue(this.dao.pesquisarPorNomeComPalavrasChaves(listaPalavras, 0, 100).size() == 0);
	}
	
	@Test
	public void testPesquisarPorNomeMaisLocalizacao() throws SQLException, ParseException{
		List<String> listaPalavras = new ArrayList<String>();
		listaPalavras.add("XP5PK");
		listaPalavras.add("OVER");
		
		List<String> listaPalavrasMunicipio = new ArrayList<String>();
		listaPalavrasMunicipio.add("Rua");
		listaPalavrasMunicipio.add("loucos");
		
		String estado = "Javavah";
		
		assertTrue(this.dao.pesquisarPorNomeMaisLocalizacao(listaPalavras, estado, listaPalavrasMunicipio, 0, 1200).size() == 1);
	}
	
	@Test
	public void testPesquisarPorNomeMaisLocalizacaoNomeInexistente() throws SQLException, ParseException{
		List<String> listaPalavras = new ArrayList<String>();
		listaPalavras.add("XPTO");
		listaPalavras.add("OVER");
		
		List<String> listaPalavrasMunicipio = new ArrayList<String>();
		listaPalavrasMunicipio.add("Rua");
		listaPalavrasMunicipio.add("loucos");
		
		String estado = "Javavah";
		
		assertTrue(this.dao.pesquisarPorNomeMaisLocalizacao(listaPalavras, estado, listaPalavrasMunicipio, 0, 1200).isEmpty());
	}
	
	@Test
	public void testPesquisarPorNomeMaisLocalizacaoComEstadoInexistente() throws SQLException, ParseException{
		List<String> listaPalavras = new ArrayList<String>();
		listaPalavras.add("XP5PK");
		listaPalavras.add("OVER");
		
		List<String> listaPalavrasMunicipio = new ArrayList<String>();
		listaPalavrasMunicipio.add("Rua");
		listaPalavrasMunicipio.add("loucos");
		
		String estado = "Javavah do sul";
		
		assertTrue(this.dao.pesquisarPorNomeMaisLocalizacao(listaPalavras, estado, listaPalavrasMunicipio, 0, 1200).isEmpty());
	}

	@Test
	public void testPesquisarPorNomeMaisLocalizacaoComMunicipioInexistente() throws SQLException, ParseException{
		List<String> listaPalavras = new ArrayList<String>();
		listaPalavras.add("XP5PK");
		listaPalavras.add("OVER");
		
		List<String> listaPalavrasMunicipio = new ArrayList<String>();
		listaPalavrasMunicipio.add("Cidade");
		listaPalavrasMunicipio.add("loucos");
		
		String estado = "Javavah do sul";
		
		assertTrue(this.dao.pesquisarPorNomeMaisLocalizacao(listaPalavras, estado, listaPalavrasMunicipio, 0, 1200).isEmpty());
	}

}
