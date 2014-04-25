package br.com.mdsgpp.guiaescolaideal.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteTipoSistemaDeEsgoto {

	@Test
	public void test() {
		TipoSistemaDeEsgoto sistemaDeEsgoto = TipoSistemaDeEsgoto
				.valueOf(TipoSistemaDeEsgoto.INEXISTENTE.name());
		
		assertTrue(sistemaDeEsgoto.name().equals(TipoSistemaDeEsgoto.INEXISTENTE.name()));
	}

}
