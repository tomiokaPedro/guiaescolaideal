<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pesquisar Escola Específica</title>
</head>
<body>
	<table>
		<form action="realizarConsultaEscolaEspecifica.jsp" method="post">
			<tr>
				<td>Escola Nome:</td>
				<td><input type="text" name="nome" /></td>
			</tr>
			<tr>
				<td>Estado:</td>
				<td><select name="estado">
						<option value=""  >Escolha o Estado</option>
						<option value="Distrito Federal"  >Distrito Federal</option>
						<option value="Goias">Goiás</option>
						<option value="Mato Grosso">Mato Grosso</option>
						<option value="Mato Grosso do Sul">Mato Grosso do Sul</option>
				</select></td>
			</tr>
			<tr>
				<td>município</td>
				<td><input type="text" name="municipio" /></td>
			</tr>
			<td>
				<td><td>
				<td><input type="submit"/></td>
			</td>
		</form>
	</table>
</body>
</html>