package br.com.mdsgpp.guiaescolaideal.model.teste;

import org.junit.Before;

import br.com.mdsgpp.guiaescolaideal.model.Telefone;

public class TesteTelefone {

	Telefone telefone = new Telefone();
	
	@Before
	public void setUp(){
		telefone.setTelefone("96465922");
	}
	
	
}
