package br.com.mdsgpp.guiaescolaideal.dao;

import java.sql.Connection;
import java.util.List;

import br.com.mdsgpp.guiaescolaideal.model.Escola;

public class EscolaDAO {

	private Connection connection;
	
	public EscolaDAO(Connection connection) {
		this.connection = connection;
	}

	public Escola pesquisarPorID(int id) {
		String sql = "select * from 'escola' where COD_ESCOLA= ?";
		return null;
	}
	
	public List<Escola> pesquisarPorNome(String nome, int comeco, int quantidade){
		String sql = "select * from 'escola' where NOME like %?%";
		
		return null;
	}
	
	public List<Escola> pesquisarPorNomeComPalavrasChaves(List<String> listaPalavras, int comeco, int quantidade){
		// criar método para gerar o sql
		String sql = "";
		
		return null;
	}
	
	

}
