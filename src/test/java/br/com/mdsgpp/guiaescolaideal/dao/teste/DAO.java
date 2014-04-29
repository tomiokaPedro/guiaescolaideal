package br.com.mdsgpp.guiaescolaideal.dao.teste;

import static org.junit.Assert.*;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;

public abstract class DAO extends DBTestCase {
	
	private String user = "root";
	private String password = "";
	private String database = "guia_escola_ideal";
	
	/*
	 * Configurando a conexão
	 */
	public DAO(String name) {
		super(name);
		System.setProperty(
				PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS,
				"com.mysql.jdbc.Driver");
		System.setProperty(
				PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL,
				"jdbc:mysql://localhost/" + database);
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME,
				user);
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD,
				password);
	}

	/*
	 * Método que será executado no começo de cada teste.
	 */
	protected DatabaseOperation getSetUpOperation() throws Exception {
		return DatabaseOperation.REFRESH;
	}
	
}
