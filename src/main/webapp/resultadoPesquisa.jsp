<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Document</title>

<link type="text/css" rel="stylesheet" href="css/paginacao.css" />
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/jquery.pajinate.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#paging_container').pajinate({
			items_per_page : 20,
			num_page_links_to_display : 10,
			abort_on_small_lists : true,
		});
	});
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<%@ include file="nav.jsp"%>
	<%@ include file="home.jsp"%>
	<!-- Código criado a partir da demo https://github.com/wesnolte/Pajinate-->
	<div id="wrapper">
		<div id="paging_container" class="container">
			<div class="content">
				<c:forEach var="escolar" items="${listaescola}">

					<div class="escola">
						Nome:${escolar.nomeEscola}<br> 
						Bairro: ${escolar.endereco.bairro}<br> 
						E-Mail:${escolar.email}<br>
						Telefone:(${escolar.endereco.municipio.codigoDDD})${escolar.telefone.telefone}
					</div>
				</c:forEach>
			</diV>
			<div class="page_navigation"></div>
		</div>
	</div>

	<%@ include file="noticias.jsp"%>
	<%@ include file="faq.jsp"%>
	<%@ include file="quem.jsp"%>
	<%@ include file="contato.jsp"%>
</body>
</html>