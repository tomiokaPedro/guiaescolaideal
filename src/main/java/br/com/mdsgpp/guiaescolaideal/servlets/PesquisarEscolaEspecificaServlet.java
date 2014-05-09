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
import br.com.mdsgpp.guiaescolaideal.model.Pagina;
import br.com.mdsgpp.guiaescolaideal.util.ConversorDeEntrada;

@WebServlet(value="/realizarConsultaEscolaEspecifica.jsp")
public class PesquisarEscolaEspecificaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException  {

		RequestDispatcher dispatcher = null;
		String nome = null;
		String estado = null;
		String municipio = null;
		String pagAtual = null;
		String escAtual = null;

		nome = request.getParameter("nome");
		estado = request.getParameter("estado");
		municipio = request.getParameter("municipio");
		pagAtual = request.getParameter("pagatual");
		escAtual = request.getParameter("escatual");
		
		Pagina pagina = new Pagina();
		
		pagina.setNome(nome);
		pagina.setEstado(estado);
		pagina.setMunicipio(municipio);
		pagina.setMaxResult(20);
		
		
		int pag = ConversorDeEntrada.getNumeroInteiroSemPonto(pagAtual);
		if(pag == 0)
		    pag = 1;
		
		pagina.setPagAtual(pag);
		
		int esc = ConversorDeEntrada.getNumeroInteiroSemPonto(escAtual);
		
		pagina.setEscAtual(esc);
		
		Connection con = null;
		
		try {
			con = new ConnectionFactory().getConnection();
			EscolaDAO escolaDAO = new EscolaDAO(con);
			EscolaControl escolaControl = new EscolaControl(escolaDAO);
			
			pagina.setListaEscola(escolaControl.getEscolaEspecifica(pagina));
			request.setAttribute("pagina",
					pagina);

			dispatcher = request.getRequestDispatcher("/resultadoPesquisa.jsp");
			con.close();
		} catch (SQLException e) {
			dispatcher = setDispatcherErro(request, e);
		} catch (ParseException e) {
			dispatcher = setDispatcherErro(request, e);
		}

		dispatcher.forward(request, response);
	}

	private RequestDispatcher setDispatcherErro(ServletRequest request, Exception e) {
		RequestDispatcher dispatcher;
		request.setAttribute("erroMsg", e.getMessage());
		dispatcher = request.getRequestDispatcher("/erro.jsp");
		return dispatcher;
	}

}
