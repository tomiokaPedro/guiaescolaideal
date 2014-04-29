package br.com.mdsgpp.guiaescolaideal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mdsgpp.guiaescolaideal.model.Escola;

public class EscolaDAO {

	private Connection connection;

	public EscolaDAO(Connection connection) {
		this.connection = connection;
	}

	public Escola pesquisarPorID(int id) throws SQLException {
		String sql = "select * from escola where COD_ESCOLA= ?";

		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {

			Escola escola = getEscola(rs);

			stmt.close();
			return escola;
		}

		stmt.close();
		return null;
	}

	public List<Escola> pesquisarPorNome(String nome, int comeco, int quantidade)
			throws SQLException {

		if (nome.isEmpty()) {
			throw new IllegalArgumentException();
		}

		ArrayList<String> listaPalavras = new ArrayList<String>();
		listaPalavras.add(nome);

		return pesquisarPorNomeComPalavrasChaves(listaPalavras, comeco,
				quantidade);
	}

	public List<Escola> pesquisarPorNomeComPalavrasChaves(
			List<String> listaPalavras, int comeco, int quantidade)
			throws SQLException {
		
		if((comeco < 0) || (quantidade <= 0)){
			throw new IllegalArgumentException();
		}

		String sql = gerarQuerySql(listaPalavras);
		PreparedStatement stmt = this.connection.prepareStatement(sql);

		int sizeLista = listaPalavras.size();

		for (int i = 1; i <= sizeLista; i++) {
			stmt.setString(i, "%" + listaPalavras.get(i - 1) + "%");
		}

		stmt.setInt(sizeLista + 1, comeco);
		stmt.setInt(sizeLista + 2, quantidade);

		List<Escola> listaEscola = new ArrayList<Escola>();
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			Escola escola = getEscola(rs);
			listaEscola.add(escola);

		}
		
		return listaEscola;
	}

	private Escola getEscola(ResultSet rs) throws SQLException {
		Escola escola = new Escola();

		escola.setNomeEscola(rs.getString("NOME_ESCOLA"));
		return escola;
	}

	private String gerarQuerySql(List<String> listaPalavras) {
		StringBuilder builder = new StringBuilder();
		builder.append("select * from escola where ");

		int sizeLista = listaPalavras.size();

		for (int i = 0; i < sizeLista; i++) {
			builder.append("( NOME_ESCOLA like ?) ");

			if (i != (sizeLista - 1)) {
				builder.append("AND ");
			}
		}

		builder.append("LIMIT ?, ?");
		return builder.toString();
	}

}
