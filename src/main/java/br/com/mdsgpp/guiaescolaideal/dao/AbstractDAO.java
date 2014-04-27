package br.com.mdsgpp.guiaescolaideal.dao;

import java.sql.Connection;

public abstract class AbstractDAO implements DAO {

	private Connection connection;

	public AbstractDAO(Connection connection) {
		this.connection = connection;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
