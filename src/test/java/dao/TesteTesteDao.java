package dao;

import static org.junit.Assert.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Test;

import br.com.mdsgpp.guiaescolaideal.dao.TesteDao;

public class TesteTesteDao {

    private TesteDao testeDao = new TesteDao();
    private final String NOME = "oi eu fui adicionado";

    @Test
    public void testAddNome() throws SQLException {
	testeDao.addNome(NOME);

	String sql = "SELECT * FROM test";

	PreparedStatement stmt = testeDao.getConnection().prepareStatement(sql);
	ResultSet rs = stmt.executeQuery();

	while (rs.next()) {
	    if (rs.getString("nome").equals(NOME)) {
		break;
	    }
	}

	assertTrue(rs.getString("nome").equals(NOME));

    }

    @After
    public void tearDown() throws SQLException {
	String sql = "DELETE FROM test WHERE nome = ?";

	PreparedStatement stmt = testeDao.getConnection().prepareStatement(sql);

	stmt.setString(1, NOME);
	stmt.execute();
    }

}
