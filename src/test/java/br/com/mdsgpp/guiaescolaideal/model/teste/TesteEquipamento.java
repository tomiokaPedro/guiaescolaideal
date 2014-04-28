package br.com.mdsgpp.guiaescolaideal.model.teste;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.mdsgpp.guiaescolaideal.model.Equipamento;



public class TesteEquipamento {

	@Test
    public void test() {
		Equipamento equipamento = Equipamento.valueOf("IMPRESSORA");
	
	assertTrue(equipamento.name().equals(Equipamento.IMPRESSORA.name()));
    }
	
}
