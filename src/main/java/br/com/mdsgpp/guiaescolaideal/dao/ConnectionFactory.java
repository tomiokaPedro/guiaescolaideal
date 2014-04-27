package br.com.mdsgpp.guiaescolaideal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private Connection connection;

	private String user = "root";
	private String password = "";
	private String database = "guia_escola_ideal";

	public Connection getConnection() throws SQLException {
		if (this.connection == null) {

			try {
				Class.forName("com.mysql.jdbc.Driver");

				this.connection = DriverManager.getConnection(
						"jdbc:mysql://localhost/" + database, user, password);
			} catch (ClassNotFoundException e) {
				throw new SQLException();
			}
		}
		return this.connection;

	}
}
