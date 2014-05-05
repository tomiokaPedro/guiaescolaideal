package br.com.mdsgpp.guiaescolaideal.util;

import java.util.Arrays;
import java.util.List;

public class ConversorDeEntrada {
	
	/**
	 * Retira as palavras chave do texto
	 * @param texto
	 * @return
	 */
	public static List<String> getPalavrasChaveDoTexto(String texto){
		String novoTexto = texto.replaceAll("[-!\"#$%&'()*+,./:;<=>?@\\\\\\_`{|}~]", "");

		List<String> lista = Arrays.asList(novoTexto.split(" "));
		return lista;
		
	}
	
	public static int getNumeroInteiroSemPonto(String numero){
		if(numero == null || numero.isEmpty()){
			return 0;
		}
		
		String novoTexto = numero.replaceAll("[.]", "").trim();
		return Integer.parseInt(novoTexto);
	}
	
}
