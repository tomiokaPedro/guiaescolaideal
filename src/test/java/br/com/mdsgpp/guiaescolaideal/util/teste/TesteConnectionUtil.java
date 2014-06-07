package br.com.mdsgpp.guiaescolaideal.util.teste;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import br.com.mdsgpp.guiaescolaideal.util.ConnectionUtil;

public class TesteConnectionUtil {
    
    @Test
    public void testCloseConnection() throws SQLException {
	Connection connection = cenarioComConexaoAberta();
	ConnectionUtil.closeConnection(connection);
	verify(connection).close();
    }

    @Test
    public void testCloseConnectionIsClosed() throws SQLException {
	Connection connection = cenarioComConexaoJaFechada();
	ConnectionUtil.closeConnection(connection);
	verify(connection, never()).close();
    }
    
    private Connection cenarioComConexaoAberta() throws SQLException {
	Connection connection = mock(Connection.class);
	when(connection.isClosed()).thenReturn(false);
	return connection;
    }
    
    private Connection cenarioComConexaoJaFechada() throws SQLException {
	Connection connection = mock(Connection.class);
	when(connection.isClosed()).thenReturn(true);
	return connection;
    }
}
