package br.com.mdsgpp.guiaescolaideal.util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class ConversorDeEntrada {

	public static List<String> getPalavrasChaveDoTexto(String texto) {
		String novoTexto = texto.replaceAll(
				"[-!\"#$%&'()*+,./:;<=>?@\\\\\\_`{|}~]", "");

		List<String> lista = Arrays.asList(novoTexto.split(" "));
		return lista;

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

	public static boolean getValorBooleanDoTexto(String texto) {
		if (texto == null) {
			return false;
		} else
			return texto.equalsIgnoreCase("sim");
	}

	public static Date getData(String dataTexto) throws ParseException {
		Date data = null;
		if (dataTexto != null) {
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			data = new Date(dateFormat.parse(dataTexto).getTime());
		}
		return data;
	}

}
