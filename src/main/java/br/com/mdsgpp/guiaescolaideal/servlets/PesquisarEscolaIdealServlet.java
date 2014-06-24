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

	String modalidade = null;
	String estado = null;
	String municipio = null;
	
	String fimlucrativo = null;
	String brasilalfabet = null;
	String edindigena = null;
	
	
	String salaleitura = null;
	String salaatendespecializado = null;
	String salaprofessor = null;
	String saladiretoria = null;
	
	String labinf = null;
	String labcien = null;
	
	String quadraCoberta = null;
	String quadraDescoberta = null;
	String parqueInfantil = null;
	String patioCoberto = null;
	String patioDescoberto = null;
	
	String sanitario_adeq_infantil = null;
	String sanitario_fora_predio = null;
	
	String acessibilidade = null;
	String cozinha = null;
	String refeitorio = null;
	String alojamentoAluno = null;
	String bercario = null;
	String auditorio = null;
	String secretaria = null;
	String lavanderia = null;
	String chuveiro = null;
	String internet = null;	
	
	
	modalidade = request.getParameter("modalidade");
	estado = request.getParameter("estado");
	municipio = request.getParameter("municipio");
	
	fimlucrativo = request.getParameter("fimlucrativo");
	brasilalfabet = request.getParameter("brasilalfabet");
	edindigena = request.getParameter("indigena");
	
	
	salaleitura = request.getParameter("salaleitura");
	salaatendespecializado = request.getParameter("salaatendimentoespecial");
	salaprofessor = request.getParameter("salaprofessor");
	saladiretoria = request.getParameter("saladiretoria");
	
	labinf = request.getParameter("labinf");
	labcien = request.getParameter("labcien");
	
	sanitario_adeq_infantil = request.getParameter("sanitarioinfantil");
	sanitario_fora_predio = request.getParameter("sanitarioforapredio");
	
	quadraCoberta = request.getParameter("quadra_coberta");
	quadraDescoberta = request.getParameter("quadra_descoberta");
	parqueInfantil = request.getParameter("parqueInfantil");
	patioCoberto = request.getParameter("patioCoberto");
	patioDescoberto = request.getParameter("patioDescoberto");
	
	acessibilidade = request.getParameter("acessibilidade");
	cozinha = request.getParameter("cozinha");
	refeitorio = request.getParameter("refeitorio");
	alojamentoAluno =request.getParameter("alojamentoAluno");
	bercario = request.getParameter("bercario");
	auditorio = request.getParameter("auditorio");
	secretaria = request.getParameter("secretaria");
	lavanderia = request.getParameter("lavanderia");
	chuveiro = request.getParameter("chuveiro");
	internet = request.getParameter("internet");	
	
	
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
	    
	    if(modalidade!="")
	    {
		campos.addAll(ConversorDeEntrada.gerarCampos("DESCRICAO",
		    modalidade, "modalidade_ensino"));
	    }
	    if(fimlucrativo!="")
	    {
		campos.addAll(ConversorDeEntrada.gerarCampos("SE_FINS_LURATIVOS", fimlucrativo, "escola"));
	    }
	    
	    if(brasilalfabet!="")
	    {
		campos.addAll(ConversorDeEntrada.gerarCampos("SE_BRASIL_ALFABETIZACAO", brasilalfabet, "escola"));
	    }
	    
	    if(edindigena!="")
	    {
		campos.addAll(ConversorDeEntrada.gerarCampos("SE_EDUCACAO_INDIGNA", edindigena, "escola"));
	    }
	    
	    if(salaleitura!="")
	    {
		campos.addAll(ConversorDeEntrada.gerarCampos("SE_SALA_LEITURA", salaleitura, "escola"));
	    }
	    
	    if(salaatendespecializado!="")
	    {
		campos.addAll(ConversorDeEntrada.gerarCampos("SE_SALA_ATEND_ESP", salaatendespecializado, "escola"));
	    }
	    
	    if(salaprofessor!="")
	    {
		campos.addAll(ConversorDeEntrada.gerarCampos("SE_SALA_PROFESSOR", salaprofessor, "escola"));
	    }
	    if(saladiretoria!="")
	    {
		campos.addAll(ConversorDeEntrada.gerarCampos("SE_SALA_DIRETORIA", saladiretoria, "escola"));
	    }
	    if(saladiretoria!="")
	    {
		campos.addAll(ConversorDeEntrada.gerarCampos("SE_LAB_INFO", labinf,
		    "escola"));
	    }
	    if(saladiretoria!="")
	    {
		campos.addAll(ConversorDeEntrada.gerarCampos("SE_LAB_CIENCIAS",
		    labcien, "escola"));
	    }
	    if(sanitario_adeq_infantil!="")
	    {
		campos.addAll(ConversorDeEntrada.gerarCampos("SE_SANITARIO_EDUC_ADEQ_INFAN",
		    sanitario_adeq_infantil, "escola"));
	    }
	    if(sanitario_adeq_infantil!="")
	    {
		campos.addAll(ConversorDeEntrada.gerarCampos("SE_SANITARIO_EDUC_ADEQ_INFAN",
		    sanitario_adeq_infantil, "escola"));
	    }
	    if(sanitario_fora_predio!="")
	    {
		campos.addAll(ConversorDeEntrada.gerarCampos("SE_SANITARIO_FORA_PREDIO",
		    sanitario_fora_predio, "escola"));
	    }
	    if(sanitario_fora_predio!="")
	    {
		campos.addAll(ConversorDeEntrada.gerarCampos("SE_SANITARIO_FORA_PREDIO",
		    sanitario_fora_predio, "escola"));
	    }
	    if(quadraCoberta!="")
	    {
		campos.addAll(ConversorDeEntrada.gerarCampos(
		    "SE_QUADRA_ESPO_COBERTA", quadraCoberta, "escola"));
	    }
	    if(quadraDescoberta!="")
	    {
		campos.addAll(ConversorDeEntrada.gerarCampos(
		    "SE_QUADRA_ESPO_DESCOBERTA", quadraDescoberta, "escola"));
	    }
	    if(parqueInfantil!="")
	    {
		campos.addAll(ConversorDeEntrada.gerarCampos(
		    "SE_PARQUE_INFANTIL", parqueInfantil, "escola"));
	    }
	    if(patioCoberto!="")
	    {
		campos.addAll(ConversorDeEntrada.gerarCampos(
		    "SE_PATIO_COBERTO", patioCoberto, "escola"));
	    }
	    if(patioDescoberto!="")
	    {
		campos.addAll(ConversorDeEntrada.gerarCampos(
		    "SE_PATIO_DESCOBERTO", patioDescoberto, "escola"));
	    }
	    if(acessibilidade!="")
	    {
		campos.addAll(ConversorDeEntrada.gerarCampos("SE_ACESSIBILIDADE",
		    acessibilidade, "escola"));
	    }
	    if(cozinha!="")
	    {
		campos.addAll(ConversorDeEntrada.gerarCampos("SE_COZINHA",
		    cozinha, "escola"));
	    }
	    if(refeitorio!="")
	    {
		campos.addAll(ConversorDeEntrada.gerarCampos("SE_REFEITORIO",
		    refeitorio, "escola"));
	    }
	    if(alojamentoAluno!="")
	    {
		campos.addAll(ConversorDeEntrada.gerarCampos("SE_ALOJAMENTO_ALUNO",
		    alojamentoAluno, "escola"));
	    }
	    if(bercario!="")
	    {
		campos.addAll(ConversorDeEntrada.gerarCampos("SE_BERCARIO",
		    bercario, "escola"));
	    }
	    if(auditorio!="")
	    {
		campos.addAll(ConversorDeEntrada.gerarCampos("SE_AUDITORIO",
		    auditorio, "escola"));
	    }
	    if(secretaria!="")
	    {
		campos.addAll(ConversorDeEntrada.gerarCampos("SE_SECRETARIA",
		    secretaria, "escola"));
	    }
	    if(lavanderia!="")
	    {
		campos.addAll(ConversorDeEntrada.gerarCampos("SE_LAVANDERIA",
		    lavanderia, "escola"));
	    }
	    if(chuveiro!="")
	    {
		campos.addAll(ConversorDeEntrada.gerarCampos("SE_BANHEIRO_CHUVEIRO",
		    chuveiro, "escola"));
	    }
	    if(internet!="")
	    {
		campos.addAll(ConversorDeEntrada.gerarCampos("SE_INTERNET",
			    internet, "escola"));
	    }
	    
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
