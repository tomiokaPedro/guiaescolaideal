package br.com.mdsgpp.guiaescolaideal.model.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.mdsgpp.guiaescolaideal.model.TipoAbastecimentoEnergia;

public class TesteTipoAbastecimentoEnergia {

    @Test
    public void test() {
	TipoAbastecimentoEnergia abastecimentoEnergia = TipoAbastecimentoEnergia.valueOf("GERADOR");
	
	assertTrue(abastecimentoEnergia.name().equals(TipoAbastecimentoEnergia.GERADOR.name()));
    }

}
