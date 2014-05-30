<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pesquisar Escola Ideal</title>

<script language="javascript" type="text/javascript">
	function validar() {
		
		var estado = form1.estado.value;
		var municipio = form1.municipio.value;
		
		if (estado == "") {
			alert('Selecione um estado');
			form1.estado.focus();
			return false;
		}
		
		return true;
	}
</script>

</head>
<body>
	<table>
		<form name="form1" action="realizarConsultaEscolaEspecifica.jsp" method="post">

			<tr>
				<td>Modalidade de ensino:</td>
				<td><select name="modalidade">
						<option value="">Escolha a modalidade</option>
						<option value="ENSINO_REGULAR">Ensino Regular</option>
						<option value="EDUCACAO_ESPECIAL">Educação Especial</option>
						<option value="EDUCACAO_JOVENS_ADULTOS">EJA - Educação de Jovens e Adultos</option>
				</select></td>
			</tr>
			<tr>
				<td>Estado:</td>
				<td><select name="estado">
						<option value="">Escolha o Estado</option>
						<option value="Distrito Federal">Distrito Federal</option>
						<option value="Goias">Goiás</option>
						<option value="Mato Grosso">Mato Grosso</option>
						<option value="Mato Grosso do Sul">Mato Grosso do Sul</option>
				</select></td>
			</tr>
			<tr>
				<td>Município</td>
				<td><input type="text" name="municipio" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" onclick="return validar()" /></td>
			</tr>
			
			<tr><table>
			<tr>
				<td>Laboratório de informática:</td> 
				<td><input type="radio" name="labinf" value="true">Sim</td> 
				<td><input type="radio" name="labinf" value="false">Não</td>
			</tr>
			
			
			<tr>
				<td>Laboratório de ciências:</td>
				<td><input type="radio" name="labcien" value="true">Sim</td> 
				<td><input type="radio" name="labcien" value="false">Não</td>
			</tr>
			</table></tr>
		</form>
	</table>
</body>
</html>