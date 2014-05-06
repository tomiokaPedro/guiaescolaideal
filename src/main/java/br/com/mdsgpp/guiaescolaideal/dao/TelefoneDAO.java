package br.com.mdsgpp.guiaescolaideal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.mdsgpp.guiaescolaideal.model.Telefone;

public class TelefoneDAO 
{
    private Connection connection;
    
    public TelefoneDAO(Connection connection)
    {
	this.connection = connection;
    }
    
    public Telefone pesquisarPorID(int id) throws SQLException {
	String sql = "select * from telefone where COD_TELEFONE = ?";

	PreparedStatement stmt = this.connection.prepareStatement(sql);
	stmt.setInt(1, id);

	ResultSet rs = stmt.executeQuery();

	if (rs.next()) {

		Telefone telefone = new Telefone();
		telefone.setTelefone(rs.getString("NUMERO_TELEFONE"));
		stmt.close();
		return telefone;
	}
	
	stmt.close();
	return null;
}

	public Telefone pesquisarPorIDEscola(int codEscola) throws SQLException {
		String sql = "select * from telefone where COD_ESCOLA = ?";

		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setInt(1, codEscola);

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {

			Telefone telefone = new Telefone();
			telefone.setTelefone(rs.getString("NUMERO_TELEFONE"));
			stmt.close();
			return telefone;
		}
		
		stmt.close();
		return null;
	}
    
}
