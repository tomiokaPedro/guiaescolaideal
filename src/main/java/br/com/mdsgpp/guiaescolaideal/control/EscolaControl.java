package br.com.mdsgpp.guiaescolaideal.control;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.com.mdsgpp.guiaescolaideal.dao.EscolaDAO;
import br.com.mdsgpp.guiaescolaideal.exceptions.ConsultaBancoRetornoVazioException;
import br.com.mdsgpp.guiaescolaideal.exceptions.EntradaDadosException;
import br.com.mdsgpp.guiaescolaideal.exceptions.PesquisaException;
import br.com.mdsgpp.guiaescolaideal.model.Escola;
import br.com.mdsgpp.guiaescolaideal.util.ConversorDeEntrada;

public class EscolaControl {

    private EscolaDAO escolaDAO;

    public EscolaControl(EscolaDAO escolaDAO) throws SQLException {
	this.escolaDAO = escolaDAO;
    }

    public List<Escola> getEscolaEspecifica(String nomeEscola, String estado,
	    String nomeMunicipio) throws SQLException, ParseException,
	    PesquisaException {
	List<String> listaPalavrasChaves = ConversorDeEntrada
		.getPalavrasChaveDoTexto(nomeEscola);
	List<String> listaPalavrasMunicipio = null;

	try {
	    listaPalavrasMunicipio = ConversorDeEntrada
		    .getPalavrasChaveDoTexto(nomeMunicipio);
	} catch (EntradaDadosException e) {
	    listaPalavrasMunicipio = new ArrayList<String>();
	}

	return this.escolaDAO.pesquisarPorNomeMaisLocalizacao(
		listaPalavrasChaves, estado, listaPalavrasMunicipio);
    }

    public Escola getEscolaPorId(String id) throws SQLException,
	    ParseException, ConsultaBancoRetornoVazioException {
	int id_numerico = ConversorDeEntrada.getNumeroInteiroSemPonto(id);
	return escolaDAO.pesquisarPorID(id_numerico);
    }
}
