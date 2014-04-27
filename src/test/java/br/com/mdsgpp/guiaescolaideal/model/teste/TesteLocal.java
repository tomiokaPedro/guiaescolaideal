package br.com.mdsgpp.guiaescolaideal.model.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.mdsgpp.guiaescolaideal.model.Local;

public class TesteLocal {

	@Test
    public void test() {
	Local local = Local.valueOf("SALA_EMPRESA");
	
	assertTrue(local.name().equals(Local.SALA_EMPRESA.name()));
    }
}
