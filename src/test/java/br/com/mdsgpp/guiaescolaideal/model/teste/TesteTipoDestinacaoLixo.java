package br.com.mdsgpp.guiaescolaideal.model.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.mdsgpp.guiaescolaideal.model.TipoDestinacaoLixo;

public class TesteTipoDestinacaoLixo {

    @Test
    public void test() {
	TipoDestinacaoLixo tipoDestinacaoLixo = TipoDestinacaoLixo.valueOf("QUEIMA");
	
	assertTrue(tipoDestinacaoLixo.name().equals(TipoDestinacaoLixo.QUEIMA.name()));
    }

}
