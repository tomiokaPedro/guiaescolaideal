package br.com.mdsgpp.guiaescolaideal.model.teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.mdsgpp.guiaescolaideal.model.LocalFuncionamento;

public class TesteLocalFuncionamento {

	LocalFuncionamento localFuncionamento = new LocalFuncionamento();
	
	@Before
	public void setUp(){
		localFuncionamento.setTipoLocalFuncionamento("teste1");
	}
	
	@Test
	public void testGetTipoLocalFuncionamento(){
		assertTrue(localFuncionamento.getTipoLocalFuncionamento().equals("teste1"));		
	}
	
	@Test
	public void testSetTipoLocalFuncionamento(){
		localFuncionamento.setTipoLocalFuncionamento("teste2");
		assertTrue(localFuncionamento.getTipoLocalFuncionamento().equals("teste2"));
	}
	
	
	
}
