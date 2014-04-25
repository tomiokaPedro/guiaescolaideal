package br.com.mdsgpp.guiaescolaideal.model.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.mdsgpp.guiaescolaideal.model.ModalidadeEnsino;

public class TesteModalidadeEnsino {

    @Test
    public void test() {
	ModalidadeEnsino modalidadeEnsino = ModalidadeEnsino.valueOf("ENSINO_REGULAR");
	
	assertTrue(modalidadeEnsino.name().equals(ModalidadeEnsino.ENSINO_REGULAR.name()));
    }

}
