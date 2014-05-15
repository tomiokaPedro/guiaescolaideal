package br.com.mdsgpp.guiaescolaideal.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import br.com.mdsgpp.guiaescolaideal.control.EscolaControl;
import br.com.mdsgpp.guiaescolaideal.dao.ConnectionFactory;
import br.com.mdsgpp.guiaescolaideal.dao.EscolaDAO;
import br.com.mdsgpp.guiaescolaideal.model.Escola;

@WebServlet(value="/pegarEscola.jsp")
public class EscolaPorIdServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		RequestDispatcher dispatcher = null;

		Connection connection;
		try {
			connection = new ConnectionFactory().getConnection();

			EscolaDAO escolaDAO = new EscolaDAO(connection);
			EscolaControl control = new EscolaControl(escolaDAO);
			
			Escola escola = control.getEscolaPorId(id);
			request.setAttribute("escola", escola);
			
			dispatcher = request.getRequestDispatcher("/perfil.jsp");
			connection.close();
		} catch (SQLException e) {
			request.setAttribute("erroMsg", e.getMessage());
			dispatcher = request.getRequestDispatcher("/erro.jsp");
		} catch (ParseException e) {
			request.setAttribute("erroMsg", e.getMessage());
			dispatcher = request.getRequestDispatcher("/erro.jsp");
		}

		dispatcher.forward(request, response);

	}
}
