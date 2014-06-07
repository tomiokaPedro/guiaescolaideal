package br.com.mdsgpp.guiaescolaideal.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import br.com.mdsgpp.guiaescolaideal.control.EscolaControl;
import br.com.mdsgpp.guiaescolaideal.dao.ConnectionFactory;
import br.com.mdsgpp.guiaescolaideal.dao.EscolaDAO;
import br.com.mdsgpp.guiaescolaideal.exceptions.PesquisaException;
import br.com.mdsgpp.guiaescolaideal.util.ConnectionUtil;

@WebServlet(value = "/realizarConsultaPorCep.jsp")
public class PesquisarPorCepServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest request, ServletResponse response)
	    throws ServletException, IOException {

	String cep = request.getParameter("cep");
	RequestDispatcher dispatcher = null;

	Connection connection = null;

	try {
	    connection = new ConnectionFactory().getConnection();

	    EscolaDAO escolaDAO = new EscolaDAO(connection);
	    EscolaControl escolaControl = new EscolaControl(escolaDAO);

	    request.setAttribute("listaescola",
		    escolaControl.getEscolaPorCep(cep));

	    dispatcher = request.getRequestDispatcher("/resultadoPesquisa.jsp");
	} catch (SQLException e) {
	    dispatcher = setDispatcherErro(request, e);
	} catch (PesquisaException e) {
	    dispatcher = setDispatcherErro(request, e);
	} finally {
	    ConnectionUtil.closeConnection(connection);
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
