package br.com.mdsgpp.guiaescolaideal.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TesteDao extends ConnectionFactory {
    public TesteDao() {
	super();
    }

    public void addNome(String nome) {
	String sql = "INSERT INTO test (nome)VALUES(?)";

	PreparedStatement stmt = null;
	
	try {
	   stmt = this.getConnection().prepareStatement(sql);
	   
	   stmt.setString(1, nome);
	   
	   stmt.execute();
	} catch (SQLException e) {
	    e.printStackTrace();
	    throw new RuntimeException();
	} finally {
	    try {
		stmt.close();
	    } catch (SQLException e) {
		throw new RuntimeException();
	    }
	}
    }
}
