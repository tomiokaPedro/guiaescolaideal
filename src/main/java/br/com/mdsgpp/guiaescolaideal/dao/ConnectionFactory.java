package br.com.mdsgpp.guiaescolaideal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private Connection connection;

    public Connection getConnection() throws SQLException {
	if (connection == null) {
	    try {
		Class.forName("com.mysql.jdbc.Driver");

		connection = DriverManager.getConnection(
			"jdbc:mysql://localhost/test", "root", "");
	    } catch (ClassNotFoundException e) {
		throw new SQLException();
	    }

	}
	return connection;

    }
}
