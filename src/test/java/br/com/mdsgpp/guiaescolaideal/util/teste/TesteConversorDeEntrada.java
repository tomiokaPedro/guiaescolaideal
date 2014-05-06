package br.com.mdsgpp.guiaescolaideal.util.teste;
import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;

import br.com.mdsgpp.guiaescolaideal.util.ConversorDeEntrada;


public class TesteConversorDeEntrada {

	@Test
	public void testGetPalavrasChaveDoTextoIsNull() {
		List<String> lista = ConversorDeEntrada.getPalavrasChaveDoTexto(null);
		assertTrue(lista.isEmpty());
	}
	
	@Test
	public void testGetPalavrasChaveDoTextoIsEmpty() {
		List<String> lista = ConversorDeEntrada.getPalavrasChaveDoTexto("");
		assertTrue(lista.isEmpty());
	}
	
	@Test
	public void testGetPalavrasChaveDoTexto() {
		List<String> lista = ConversorDeEntrada.getPalavrasChaveDoTexto("MDS + GPP");
		assertTrue(lista.size() == 2);
	}
	
	@Test
	public void testGetPalavrasChaveDoTextoComSimbolos() {
		List<String> lista = ConversorDeEntrada.getPalavrasChaveDoTexto("m+at*e(m)a%t#i!c@a");
		assertTrue(lista.size() == 1);
		assertTrue(lista.get(0).equalsIgnoreCase("Matematica"));
	}

	@Test
	public void testGetNumeroInteiroSemPonto() {
		String numeroTexto = "1.223.456";
		int numero = ConversorDeEntrada.getNumeroInteiroSemPonto(numeroTexto);
		assertTrue(numero == 1223456);
	}
	
	@Test
	public void testGetNumeroInteiroSemPontoIsEmpty() {
		String numeroTexto = "";
		int numero = ConversorDeEntrada.getNumeroInteiroSemPonto(numeroTexto);
		assertTrue(numero == 0);
	}

	@Test
	public void testGetNumeroInteiroSemPontoIsNULL() {
		String numeroTexto = null;
		int numero = ConversorDeEntrada.getNumeroInteiroSemPonto(numeroTexto);
		assertTrue(numero == 0);
	}
	
	@Test
	public void testGetNumeroInteiroSemPontoComEspaco() {
		String numeroTexto = " 1.245";
		int numero = ConversorDeEntrada.getNumeroInteiroSemPonto(numeroTexto);
		assertTrue(numero == 1245);
	}
	
	@Test
	public void testGetNumeroInteiroSemPontoComEspacoNoFinal() {
		String numeroTexto = " 1.245 ";
		int numero = ConversorDeEntrada.getNumeroInteiroSemPonto(numeroTexto);
		assertTrue(numero == 1245);
	}
	
	@Test
	public void testGetValorBooleanDoTextoIsEmpty() {
		assertFalse(ConversorDeEntrada.getValorBooleanDoTexto(""));
	}
	
	@Test
	public void testGetValorBooleanDoTextoIsNULL() {
		assertFalse(ConversorDeEntrada.getValorBooleanDoTexto(""));
	}

	@Test
	public void testGetValorBooleanDoTexto() {
		assertFalse(ConversorDeEntrada.getValorBooleanDoTexto("nao"));
	}
	
	@Test
	public void testGetValorBooleanDoTextoValorTrue() {
		assertTrue(ConversorDeEntrada.getValorBooleanDoTexto("Sim"));
	}

	@Test
	public void testGetDataIsNull() throws ParseException {
		assertNull(ConversorDeEntrada.getData(null));
	}
	
	@Test
	public void testGetDataIsEmpty() throws ParseException {
		assertNull(ConversorDeEntrada.getData(null));
	}
	
	@Test(expected=ParseException.class)
	public void testGetDataErrada() throws ParseException {
		assertNull(ConversorDeEntrada.getData("22-1993"));
	}

	@Test
	public void testGetData() throws ParseException {
		assertNotNull(ConversorDeEntrada.getData("05/05/2015"));
	}
	
	@Test
	public void testConstrutor(){
		assertNotNull(new ConversorDeEntrada());
	}
}
