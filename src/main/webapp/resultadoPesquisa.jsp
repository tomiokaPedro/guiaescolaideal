<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %> 
<%@ include file="nav.jsp" %> 
<%@ include file="home.jsp" %> 
	<table>
		<c:forEach var="escola" items="${listaEscola}">
			<tr>
				<td>${escola.nomeEscola}</td>
				<td>${escola.email}</td>
				<td>${escola.endereco.bairro}</td>
				<td>(${escola.endereco.municipio.codigoDDD})${escola.telefone.telefone}</td>
			</tr>
		</c:forEach>
	
		
		<a href="resultadoPesquisa.jsp?code=2">teste</a>
	</table>
		<%@ include file="noticias.jsp" %> 
<%@ include file="faq.jsp" %> 
<%@ include file="quem.jsp" %> 
<%@ include file="contato.jsp" %>
</body>
</html>