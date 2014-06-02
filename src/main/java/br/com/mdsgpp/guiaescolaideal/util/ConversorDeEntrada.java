package br.com.mdsgpp.guiaescolaideal.util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.mdsgpp.guiaescolaideal.dao.Campo;
import br.com.mdsgpp.guiaescolaideal.exceptions.EntradaDadosException;
import br.com.mdsgpp.guiaescolaideal.exceptions.PesquisaException;

public class ConversorDeEntrada {

    /**
     * Quebra o texto em n palavras;
     * 
     * @param texto
     * @return List<String> palavras chaves do texto em uma lista.
     * @throws PesquisaException
     */
    public static List<String> getPalavrasChaveDoTexto(String texto)
	    throws EntradaDadosException {
	// Verificando a entrada
	Utilitarios.checarParaConteudo(texto, 3);
	// retirnando os acentos
	texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
	// retirnando tudo que não for letra ou número ou espaço simples.
	texto = texto.replaceAll("[^a-zA-Z0-9 ]", "");
	// retirando possíveis espaços.
	texto = texto.replaceAll("  ", " ");
	// Verificando texto após verificação
	Utilitarios.checarParaConteudo(texto, 0);

	return Arrays.asList(texto.split(" "));
    }
    public static List<Campo> gerarCampos(String nome,String valor,String tabela) throws EntradaDadosException{

	List<Campo> campos = new ArrayList<Campo>();
	List<String> palavras = getPalavrasChaveDoTexto(valor);
	
	for(String palavra : palavras){
	    campos.add(new Campo(nome, palavra, tabela));
	}
	return campos;
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
    public static boolean validarCep(String cep){
	if(cep == null || cep.isEmpty()){
	    return false;
	}
	return cep.matches("[0-9]{5}-[0-9]{3}");
    	}
}
