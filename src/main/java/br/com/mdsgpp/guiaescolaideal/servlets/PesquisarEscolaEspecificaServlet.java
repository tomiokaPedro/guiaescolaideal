package br.com.mdsgpp.guiaescolaideal.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import br.com.mdsgpp.guiaescolaideal.control.EscolaControl;
import br.com.mdsgpp.guiaescolaideal.dao.ConnectionFactory;
import br.com.mdsgpp.guiaescolaideal.dao.EscolaDAO;
import br.com.mdsgpp.guiaescolaideal.util.ConversorDeEntrada;

@WebServlet(value = "/realizarConsultaEscolaEspecifica.jsp")
public class PesquisarEscolaEspecificaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException  {

		RequestDispatcher dispatcher = null;
		String nome = null;
		String estado = null;
		String municipio = null;

		nome = request.getParameter("nome");
		estado = request.getParameter("estado");
		municipio = request.getParameter("municipio");
		
		Connection con = null;
		

		try {
			con = new ConnectionFactory().getConnection();
			EscolaDAO escolaDAO = new EscolaDAO(con);
			EscolaControl escolaControl = new EscolaControl(escolaDAO);
			
			List<String> palavras = ConversorDeEntrada.getPalavrasChaveDoTexto(nome);
			List<String> palavrasMunicipio = ConversorDeEntrada.getPalavrasChaveDoTexto(municipio);
			
			request.setAttribute("listaEscola",
					escolaControl.getEscolaEspecifica(palavras, estado, palavrasMunicipio));

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
