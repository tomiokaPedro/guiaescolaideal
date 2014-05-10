package br.com.mdsgpp.guiaescolaideal.control;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import br.com.mdsgpp.guiaescolaideal.dao.EscolaDAO;
import br.com.mdsgpp.guiaescolaideal.model.Escola;
import br.com.mdsgpp.guiaescolaideal.util.ConversorDeEntrada;

public class EscolaControl {
	
	private EscolaDAO escolaDAO;
	
	public EscolaControl(EscolaDAO escolaDAO) throws SQLException{
		this.escolaDAO = escolaDAO;
	}
	
	public List<Escola> getEscolaEspecifica(String nomeEscola,String estado, String nomeMunicipio) throws SQLException, ParseException{
	    	List<String> listaPalavrasChaves= ConversorDeEntrada.getPalavrasChaveDoTexto(nomeEscola);
	    	List<String> listaPalavrasMunicipio = ConversorDeEntrada.getPalavrasChaveDoTexto(nomeMunicipio);
		return this.escolaDAO.pesquisarPorNomeMaisLocalizacao(listaPalavrasChaves, estado, listaPalavrasMunicipio);
	}
}
