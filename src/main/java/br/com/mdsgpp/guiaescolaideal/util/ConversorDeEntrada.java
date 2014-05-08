package br.com.mdsgpp.guiaescolaideal.util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConversorDeEntrada {

	// Quebra a frase em n palavras as colocando em uma Lista.
	public static List<String> getPalavrasChaveDoTexto(String texto) {

		if (texto == null || texto.isEmpty()) {
			return new ArrayList<String>();
		}

		String novoTexto = texto.replaceAll(
				"[-!\"#$%&'()*+,./:;<=>?@\\\\\\_`{|}~]", "");

		// retira espaço duplo
		novoTexto = novoTexto.replaceAll("  ", " ");
		// retira espaço antes e no final da frase
		novoTexto = novoTexto.trim();
		// quebra a frase com base nos espaços e retorna
		return Arrays.asList(novoTexto.split(" "));
	}

	public static int getNumeroInteiroSemPonto(String numero) {
		if (numero == null || numero.isEmpty()) {
			return 0;
		}

		// Substitui todos os pontos por nada e retirna os espaços antes e no
		// final do número
		String novoTexto = numero.replaceAll("[.]", "").trim();
		return Integer.parseInt(novoTexto);
	}

	// sim = true e false para o resto
	public static boolean getValorBooleanDoTexto(String texto) {
		if (texto == null || texto.isEmpty()) {
			return false;
		}

		return texto.equalsIgnoreCase("sim");
	}

	public static Date getData(String dataTexto) throws ParseException {
		Date data = null;
		if (dataTexto != null && !dataTexto.isEmpty()) {
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			data = new Date(dateFormat.parse(dataTexto).getTime());
		}

		return data;
	}
}
