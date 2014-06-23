package br.com.mdsgpp.guiaescolaideal.servlets;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mdsgpp.guiaescolaideal.control.ContatoControl;


@WebServlet(value = "/enviarEmail.jsp")
public class ContatoServlet extends HttpServlet{
    
    private static final long serialVersionUID = 1L;

    
    protected void service (HttpServletRequest request,
	        HttpServletResponse response)
	        throws ServletException, IOException {
	
	
	ContatoControl control = new ContatoControl();
	PrintWriter out = response.getWriter();
	
	String nome = null;
	String email = null;
	String assunto = null;
	String mensagem = null;
	
	
	nome = request.getParameter("name");
	email = request.getParameter("email");
	assunto = request.getParameter("assunto");
	mensagem = request.getParameter("mensagem");
	
	control.enviarEmail(nome, email, assunto, mensagem);
	out.println("Mensagem enviada com sucesso!");
	 
    }
    
}
 
	   

