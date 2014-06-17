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
	String fimlucrativo = null;
	String brasilalfabet = null;
	String indigena = null;
	String salaleitura = null;
	String salaatendimentoespecial = null;
	String salaprofessor = null;
	String saladiretoria = null;
	String sanitarioinfantil = null;
	String sanitarioforapredio = null;
	String cozinha = null;
	String dispensa = null;
	String refeitorio = null;
	String bercario = null;
	String auditorio = null;
	String almoxarifado = null;
	String secretaria = null;
	String lavanderia = null;
	String chuveiro = null;
	String parqueinfantil = null;
	String patiocoberto = null;
	String patiodescoberto = null;

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
	fimlucrativo = request.getParameter("fimlucrativo");
	brasilalfabet = request.getParameter("brasilalfabet");
	indigena = request.getParameter("indigena");
	salaleitura = request.getParameter("salaleitura");
	salaatendimentoespecial = request
		.getParameter("salaatendimentoespecial");
	salaprofessor = request.getParameter("salaprofessor");
	saladiretoria = request.getParameter("saladiretoria");
	sanitarioinfantil = request.getParameter("sanitarioinfantil");
	sanitarioforapredio = request.getParameter("sanitarioforapredio");
	cozinha = request.getParameter("cozinha");
	dispensa = request.getParameter("dispensa");
	refeitorio = request.getParameter("refeitorio");
	bercario = request.getParameter("bercario");
	auditorio = request.getParameter("auditorio");
	almoxarifado = request.getParameter("almoxarifado");
	secretaria = request.getParameter("secretaria");
	lavanderia = request.getParameter("lavanderia");
	chuveiro = request.getParameter("chuveiro");
	parqueinfantil = request.getParameter("parqueinfantil");
	patiocoberto = request.getParameter("patiocoberto");
	patiodescoberto = request.getParameter("patiodescoberto");

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
	    campos.addAll(ConversorDeEntrada.gerarCampos("SE_FINS_LURATIVOS",
		    fimlucrativo, "escola"));
	    campos.addAll(ConversorDeEntrada.gerarCampos(
		    "SE_BRASIL_ALFABETIZACAO", brasilalfabet, "escola"));
	    campos.addAll(ConversorDeEntrada.gerarCampos("SE_EDUCACAO_INDIGNA",
		    indigena, "escola"));
	    campos.addAll(ConversorDeEntrada.gerarCampos("SE_SALA_LEITURA",
		    salaleitura, "escola"));
	    campos.addAll(ConversorDeEntrada.gerarCampos("SE_SALA_ATEND_ESP",
		    salaatendimentoespecial, "escola"));
	    campos.addAll(ConversorDeEntrada.gerarCampos("SE_SALA_PROFESSOR",
		    salaprofessor, "escola"));
	    campos.addAll(ConversorDeEntrada.gerarCampos("SE_SALA_DIRETORIA",
		    saladiretoria, "escola"));
	    campos.addAll(ConversorDeEntrada
		    .gerarCampos("SE_SANITARIO_EDUC_ADEQ_INFAN",
			    sanitarioinfantil, "escola"));
	    campos.addAll(ConversorDeEntrada.gerarCampos(
		    "SE_SANITARIO_FORA_PREDIO", sanitarioforapredio, "escola"));
	    campos.addAll(ConversorDeEntrada.gerarCampos("SE_COZINHA", cozinha,
		    "escola"));
	    campos.addAll(ConversorDeEntrada.gerarCampos("SE_DESPENSA",
		    dispensa, "escola"));
	    campos.addAll(ConversorDeEntrada.gerarCampos("SE_REFEITORIO",
		    refeitorio, "escola"));
	    campos.addAll(ConversorDeEntrada.gerarCampos("SE_BERCARIO",
		    bercario, "escola"));
	    campos.addAll(ConversorDeEntrada.gerarCampos("SE_AUDITORIO",
		    auditorio, "escola"));
	    campos.addAll(ConversorDeEntrada.gerarCampos("SE_ALMOXARIFADO",
		    almoxarifado, "escola"));
	    campos.addAll(ConversorDeEntrada.gerarCampos("SE_SECRETARIA",
		    secretaria, "escola"));
	    campos.addAll(ConversorDeEntrada.gerarCampos("SE_LAVANDERIA",
		    lavanderia, "escola"));
	    campos.addAll(ConversorDeEntrada.gerarCampos(
		    "SE_BANHEIRO_CHUVEIRO", chuveiro, "escola"));
	    campos.addAll(ConversorDeEntrada.gerarCampos("SE_PARQUE_INFANTIL",
		    parqueinfantil, "escola"));
	    campos.addAll(ConversorDeEntrada.gerarCampos("SE_PATIO_COBERTO",
		    patiocoberto, "escola"));
	    campos.addAll(ConversorDeEntrada.gerarCampos("SE_PATIO_DESCOBERTO",
		    patiodescoberto, "escola"));

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
