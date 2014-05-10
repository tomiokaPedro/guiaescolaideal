package br.com.mdsgpp.guiaescolaideal.control.teste;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.mdsgpp.guiaescolaideal.control.EscolaControl;
import br.com.mdsgpp.guiaescolaideal.dao.EscolaDAO;
import br.com.mdsgpp.guiaescolaideal.model.Escola;

public class TesteEscolaControl {
	
	private EscolaDAO escolaDAO;
	private EscolaControl control;

	
	@Before
	public void inic() throws SQLException, ParseException{
		List<Escola> listaEscola = new ArrayList<Escola>();
		
		for (int i = 0; i < 10; i++) {
			Escola escola = new Escola();
			escola.setNomeEscola("item "+ i );
			listaEscola.add(escola);
		}
		
		escolaDAO = Mockito.mock(EscolaDAO.class);
		Mockito.when(escolaDAO.pesquisarPorNomeMaisLocalizacao(new ArrayList<String>(), null, new ArrayList<String>())).thenReturn(listaEscola);
		
		control  = new EscolaControl(escolaDAO);
	
		
		
		
	}
	
	@Test
	public void testGetEscolaEspecifica() throws SQLException, ParseException {
		assertTrue(control.getEscolaEspecifica(null,null,null).size() == 10);
	}
	
	@Test
	public void testGetEscolaEspecificaValor() throws SQLException, ParseException {
		assertTrue(control.getEscolaEspecifica(null,null,null).get(0).getNomeEscola().equalsIgnoreCase("item 0"));
	}

}
