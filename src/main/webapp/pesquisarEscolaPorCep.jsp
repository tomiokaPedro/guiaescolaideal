<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pesquisar Escola por CEP</title>
<script language="javascript" type="text/javascript">
	function validar() {
		var nome = form1.cep;

		if(nome = ""){
			alert('Digite o cep desejado!');
			form1.cep.focus();
			return false;
		}

		return true;
	}
			
</script>
</head>
<body>
	<table>
		<element>
		<form name="form1" action="realizarConsultaPorCep.jsp" method="post"></element>
 
   		<!-- <label>CEP:<input required name="cep" pattern="[0-9]{5}-[0-9]{3}"></label>-->
		  CEP: <input type="text" name="cep" />
		
		<td><input type="submit" onclick="return validar()"/></td>
		</form>
	</table>
</body>
</html>