package br.com.mdsgpp.guiaescolaideal.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import br.com.mdsgpp.guiaescolaideal.control.EscolaControl;

@WebServlet(value = "/realizarConsultaEscolaEspecifica.jsp")
public class PesquisarEscolaEspecificaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {

		EscolaControl escolaControl = new EscolaControl();
		RequestDispatcher dispatcher = null;
		String nome = null;
		String estado = null;
		String municipio = null;

		nome = request.getParameter("nome");
		estado = request.getParameter("estado");
		municipio = request.getParameter("municipio");
		
		System.out.println(nome +" - "+ estado +" - "+ municipio);

		try {
			request.setAttribute("listaEscola",
					escolaControl.getEscolaEspecifica(nome, estado, municipio));

			dispatcher = request.getRequestDispatcher("/resultadoPesquisa.jsp");
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
