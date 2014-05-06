package br.com.mdsgpp.guiaescolaideal.control;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import br.com.mdsgpp.guiaescolaideal.dao.EscolaDAO;
import br.com.mdsgpp.guiaescolaideal.model.Escola;

public class EscolaControl {
	
	private EscolaDAO escolaDAO;
	
	public EscolaControl(EscolaDAO escolaDAO) throws SQLException{
		this.escolaDAO = escolaDAO;
	}
	
	
	public List<Escola> getEscolaEspecifica(List<String> listaPalavrasChaves, String estado,List<String> ListaPalavrasMunicipio) throws SQLException, ParseException{
		List<Escola> listaEscola = this.escolaDAO.pesquisarPorNomeMaisLocalizacao(listaPalavrasChaves, estado, ListaPalavrasMunicipio, 0, 30);
		return listaEscola;
		
	}

	
}
