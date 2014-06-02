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

@WebServlet(value = "/realizarConsultaEscolaEspecifica.jsp")
public class PesquisarEscolaIdealServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest request, ServletResponse response)
	    throws ServletException, IOException {

	RequestDispatcher dispatcher = null;
	String nome = null;
	String estado = null;
	String municipio = null;
	String labinf = null;
	String labcien = null;
	String modalidade = null;
	
	nome = request.getParameter("nome");
	estado = request.getParameter("estado");
	municipio = request.getParameter("municipio");
	labinf = request.getParameter("labinf");
	labcien = request.getParameter("labcien");
	modalidade = request.getParameter("modalidade");
	
	
	Connection con = null;

	try {
	    con = new ConnectionFactory().getConnection();
	    EscolaDAO escolaDAO = new EscolaDAO(con);
	    EscolaControl escolaControl = new EscolaControl(escolaDAO);

	    request.setAttribute("listaescola",
		    escolaControl.getEscolaIdeal());

	    dispatcher = request.getRequestDispatcher("/resultadoPesquisa.jsp");
	    con.close();
	} catch (SQLException e) {
	    dispatcher = setDispatcherErro(request, e);
	} catch (ParseException e) {
	    dispatcher = setDispatcherErro(request, e);
	} catch (PesquisaException e) {
	    dispatcher = setDispatcherErro(request, e);
	} finally {
	    try {
		if (con != null && !con.isClosed()) {
		    con.close();
		}
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
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
