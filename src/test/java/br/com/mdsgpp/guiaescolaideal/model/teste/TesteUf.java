package br.com.mdsgpp.guiaescolaideal.model.teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.mdsgpp.guiaescolaideal.model.Uf;

public class TesteUf {
    Uf uf= new Uf();
    @Before
    public void setUp(){
	uf.setEstado("teste");
    }
    @Test
    public void testGetEstado() {
	assertTrue(uf.getEstado().equalsIgnoreCase("teste"));
    }
    @Test
    public void testSetEstado() {
	uf.setEstado("teste2");
	assertTrue(uf.getEstado().equalsIgnoreCase("teste2"));
    }
}
