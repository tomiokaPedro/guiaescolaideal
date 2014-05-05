package br.com.mdsgpp.guiaescolaideal.dao.teste;

import java.io.FileInputStream;
import java.sql.SQLException;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;

import br.com.mdsgpp.guiaescolaideal.dao.LocalFuncionamentoDAO;
import br.com.mdsgpp.guiaescolaideal.dao.TelefoneDAO;

public class TesteTelefoneDAO extends DAO
{

    private TelefoneDAO dao;
    
    public TesteTelefoneDAO(String name) throws SQLException, Exception {
	super(name);
	this.dao= new TelefoneDAO(getConnection().getConnection());
    }

    @Override
    protected IDataSet getDataSet() throws Exception 
    {
	return new FlatXmlDataSetBuilder().build(new FileInputStream(
		"xml-dbunit/banco-telefone.xml"));
    }
    
    @Test
    public void testPesquisarPorId() throws Exception, SQLException
    {
	assertNotNull(this.dao.pesquisarPorID(6423));
    }
    
    @Test
    public void testPesquisarPorIDInexistente() throws SQLException
    {
	assertNull(this.dao.pesquisarPorID(34567));
    }

    
}
