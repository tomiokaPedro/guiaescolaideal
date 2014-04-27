package br.com.mdsgpp.guiaescolaideal.dao;

import java.sql.Connection;
import java.util.List;

public class EscolaDAO<Escola> extends AbstractDAO {

	public EscolaDAO(Connection connection) {
		super(connection);
	}

	public Escola pesquisarPorID(int id) {
		String sql = "select * from 'escola' where COD_ESCOLA= ?";
		return null;
	}
	
	public List<Escola> pesquisarPorNome(String nome){
		//limitar num resultados
		String sql = "select * from 'escola' where NOME like %?%";
		
		return null;
	}
	
	public List<Escola> pesquisarPorNomeComPalavrasChaves(List<String> listaPalavras){
		//limitar num resultados
		// criar método para gerar o sql
		String sql = "";
		
		return null;
	}

}
