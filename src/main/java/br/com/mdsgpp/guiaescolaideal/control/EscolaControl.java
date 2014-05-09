package br.com.mdsgpp.guiaescolaideal.control;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import br.com.mdsgpp.guiaescolaideal.dao.EscolaDAO;
import br.com.mdsgpp.guiaescolaideal.model.Escola;
import br.com.mdsgpp.guiaescolaideal.model.Pagina;
import br.com.mdsgpp.guiaescolaideal.util.ConversorDeEntrada;

public class EscolaControl {
	
	private EscolaDAO escolaDAO;
	
	public EscolaControl(EscolaDAO escolaDAO) throws SQLException{
		this.escolaDAO = escolaDAO;
	}
	
	public List<Escola> getEscolaEspecifica(Pagina pagina) throws SQLException, ParseException{
	    	List<String> listaPalavrasChaves= ConversorDeEntrada.getPalavrasChaveDoTexto(pagina.getNome());
	    	List<String> listaPalavrasMunicipio = ConversorDeEntrada.getPalavrasChaveDoTexto(pagina.getMunicipio());
		int num = escolaDAO.pesquisarPorNomeMaisLocalizacaoQuantidadeResultados(listaPalavrasChaves, pagina.getEstado(), listaPalavrasMunicipio);
	    	pagina.setNumResult(num);
		return this.escolaDAO.pesquisarPorNomeMaisLocalizacao(listaPalavrasChaves, pagina.getEstado(), listaPalavrasMunicipio, pagina.getEscAtual(), pagina.getMaxResult());
	}
}
