package br.com.mdsgpp.guiaescolaideal.control;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.mdsgpp.guiaescolaideal.controller.Control;
import br.com.mdsgpp.guiaescolaideal.model.Escola;

public class TesteControl {
    
    private Escola escola;
    
    @Before
    public void setUp() {
	Escola escola = Mockito.mock(Escola.class);
	Mockito.when(escola.getNome()).thenReturn("ola");
	
	this.escola = escola;
    }
    
    @Test
    public void test() throws Exception {
	Control control = new Control();

	control.getEscola(this.escola);
    }

}
