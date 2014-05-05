package br.com.mdsgpp.guiaescolaideal.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import br.com.mdsgpp.guiaescolaideal.dao.ConnectionFactory;
import br.com.mdsgpp.guiaescolaideal.dao.EscolaDAO;
import br.com.mdsgpp.guiaescolaideal.model.Escola;
import br.com.mdsgpp.guiaescolaideal.util.ConversorDeEntrada;

public class EscolaControl {
	
	public List<Escola> getEscolaEspecifica(String nome, String endereco, String municipio) throws SQLException, ParseException{
		Connection connection = new ConnectionFactory().getConnection();
		
		EscolaDAO escolaDao= new EscolaDAO(connection);
		
		List<String> palavras = ConversorDeEntrada.getPalavrasChaveDoTexto(nome);
		List<Escola> listaEscola = escolaDao.pesquisarPorNomeComPalavrasChaves(palavras, 0, 20);
		connection.close();
		return listaEscola;
		
	}
}
