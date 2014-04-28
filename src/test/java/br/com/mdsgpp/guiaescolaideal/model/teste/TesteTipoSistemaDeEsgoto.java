package br.com.mdsgpp.guiaescolaideal.model.teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.mdsgpp.guiaescolaideal.model.TipoAbastecimentoAgua;
import br.com.mdsgpp.guiaescolaideal.model.TipoSistemaDeEsgoto;

public class TesteTipoSistemaDeEsgoto {

	private TipoSistemaDeEsgoto tipo;
	
	@Before
	public void setUP(){
		tipo = new TipoSistemaDeEsgoto();
		tipo.setTipo("publica");
	}
	
	@Test
	public void testGetTipo() {
		assertTrue(tipo.getTipo().equalsIgnoreCase("publica"));	
	}

	@Test
	public void testSetTipo() {
		tipo.setTipo("fossa");
		assertTrue(tipo.getTipo().equalsIgnoreCase("fossa"));	
		assertFalse(tipo.getTipo().equalsIgnoreCase("publica"));	
	}

}
