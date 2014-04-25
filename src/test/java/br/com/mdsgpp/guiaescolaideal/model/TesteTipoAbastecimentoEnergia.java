package br.com.mdsgpp.guiaescolaideal.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteTipoAbastecimentoEnergia {

    @Test
    public void test() {
	TipoAbastecimentoEnergia abastecimentoEnergia = TipoAbastecimentoEnergia.valueOf("GERADOR");
	
	assertTrue(abastecimentoEnergia.name().equals(TipoAbastecimentoEnergia.GERADOR.name()));
    }

}
