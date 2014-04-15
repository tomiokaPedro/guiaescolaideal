package br.com.mdsgpp.guiaescolaideal.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/testando", name="TesteServlet")
public class TesteServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		PrintWriter out = arg1.getWriter();
		out.print("<html><body>");
		out.println("<h1>Configuração ok!<h1>")
	}

}
