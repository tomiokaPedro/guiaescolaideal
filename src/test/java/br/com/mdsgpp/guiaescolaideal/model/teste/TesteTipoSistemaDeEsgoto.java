package br.com.mdsgpp.guiaescolaideal.model.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.mdsgpp.guiaescolaideal.model.TipoSistemaDeEsgoto;

public class TesteTipoSistemaDeEsgoto {

	@Test
	public void test() {
		TipoSistemaDeEsgoto sistemaDeEsgoto = TipoSistemaDeEsgoto
				.valueOf(TipoSistemaDeEsgoto.INEXISTENTE.name());
		
		assertTrue(sistemaDeEsgoto.name().equals(TipoSistemaDeEsgoto.INEXISTENTE.name()));
	}

}
