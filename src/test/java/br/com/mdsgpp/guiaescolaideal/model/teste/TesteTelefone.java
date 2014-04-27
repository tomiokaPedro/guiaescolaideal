package br.com.mdsgpp.guiaescolaideal.model.teste;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.mdsgpp.guiaescolaideal.model.Telefone;

public class TesteTelefone {

	Telefone telefone = new Telefone();
	
	@Before
	public void setUp(){
		telefone.setTelefone("96465022");
	}
	
	@Test
	public void testGetTelefone(){
		assertTrue(telefone.getTelefone().equalsIgnoreCase("96465022"));
	}
	
	
	
}
