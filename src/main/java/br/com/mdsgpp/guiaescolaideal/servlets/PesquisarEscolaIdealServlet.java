package br.com.mdsgpp.guiaescolaideal.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import br.com.mdsgpp.guiaescolaideal.control.EscolaControl;
import br.com.mdsgpp.guiaescolaideal.dao.Campo;
import br.com.mdsgpp.guiaescolaideal.dao.ConnectionFactory;
import br.com.mdsgpp.guiaescolaideal.dao.EscolaDAO;
import br.com.mdsgpp.guiaescolaideal.exceptions.PesquisaException;
import br.com.mdsgpp.guiaescolaideal.util.ConnectionUtil;
import br.com.mdsgpp.guiaescolaideal.util.ConversorDeEntrada;

@WebServlet(value = "/realizarConsultaEscolaIdeal.jsp")
public class PesquisarEscolaIdealServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest request, ServletResponse response)
	    throws ServletException, IOException {

	RequestDispatcher dispatcher = null;

	String estado = null;
	String municipio = null;
	String labinf = null;
	String labcien = null;
	String modalidade = null;
	String acessibilidade = null;
	String internet = null;
	String quadraCoberta = null;
	String quadraDescoberta = null;
	String alojamentoAluno = null;

	estado = request.getParameter("estado");
	municipio = request.getParameter("municipio");
	labinf = request.getParameter("labinf");
	labcien = request.getParameter("labcien");
	modalidade = request.getParameter("modalidade");
	acessibilidade = request.getParameter("acessibilidade");
	internet = request.getParameter("internet");
	quadraCoberta = request.getParameter("quadraCoberta");
	quadraDescoberta = request.getParameter("quadraDescoberta");
	alojamentoAluno = request.getParameter("alojamentoAluno");

	List<Campo> campos = new ArrayList<Campo>();

	Connection con = null;

	try {

	    campos.addAll(ConversorDeEntrada.gerarCampos("DESCRICAO", estado,
		    "uf"));
	    try {
		campos.addAll(ConversorDeEntrada.gerarCampos("DESCRICAO",
			municipio, "municipio"));

	    } catch (Exception e) {
	    }

	    campos.addAll(ConversorDeEntrada.gerarCampos("SE_LAB_INFO", labinf,
		    "escola"));

	    campos.addAll(ConversorDeEntrada.gerarCampos("SE_LAB_CIENCIAS",
		    labcien, "escola"));
	    campos.addAll(ConversorDeEntrada.gerarCampos("DESCRICAO",
		    modalidade, "modalidade_ensino"));
	    campos.addAll(ConversorDeEntrada.gerarCampos("SE_ACESSIBILIDADE",
		    acessibilidade, "escola"));
	    campos.addAll(ConversorDeEntrada.gerarCampos("SE_INTERNET",
		    internet, "escola"));
	    campos.addAll(ConversorDeEntrada.gerarCampos(
		    "SE_QUADRA_ESPO_COBERTA", quadraCoberta, "escola"));
	    campos.addAll(ConversorDeEntrada.gerarCampos(
		    "SE_QUADRA_ESPO_DESCOBERTA", quadraDescoberta, "escola"));
	    campos.addAll(ConversorDeEntrada.gerarCampos("SE_ALOJAMENTO_ALUNO",
		    alojamentoAluno, "escola"));

	    con = new ConnectionFactory().getConnection();
	    EscolaDAO escolaDAO = new EscolaDAO(con);
	    EscolaControl escolaControl = new EscolaControl(escolaDAO);

	    request.setAttribute("listaescola",
		    escolaControl.getEscolaIdeal(campos));

	    dispatcher = request.getRequestDispatcher("/resultadoPesquisa.jsp");
	} catch (SQLException e) {
	    dispatcher = setDispatcherErro(request, e);
	} catch (ParseException e) {
	    dispatcher = setDispatcherErro(request, e);
	} catch (PesquisaException e) {
	    dispatcher = setDispatcherErro(request, e);
	} finally {
	    ConnectionUtil.closeConnection(con);
	}

	dispatcher.forward(request, response);
    }

    private RequestDispatcher setDispatcherErro(ServletRequest request,
	    Exception e) {
	RequestDispatcher dispatcher;
	request.setAttribute("erroMsg", e.getMessage());
	dispatcher = request.getRequestDispatcher("/erro.jsp");
	return dispatcher;
    }

}
