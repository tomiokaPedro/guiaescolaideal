<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<script language="JavaScript">
	function jumpScroll(){
		window.scroll(250,0);
	}
</script>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
<script type="text/javascript">
		$(function() {
			$('ul li a').bind('click',function(event){
				var $anchor = $(this);
				/*
				if you want to use one of the easing effects:
				$('html, body').stop().animate({
					scrollLeft: $($anchor.attr('href')).offset().left
				}, 1500,'easeInOutExpo');
				 */
				$('html, body').stop().animate({
					scrollLeft: $($anchor.attr('href')).offset().left
				}, 1000);
				event.preventDefault();
			});
		})
    </script>
<link rel="stylesheet" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guia da Escola Ideal</title>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
$(window).load(function() {
	$(".loader").fadeOut("slow");
})

</script>

<script src="http://code.jquery.com/jquery-1.6.3.min.js" type="text/javascript"></script>

<script src="scripts/jquery.cycle.all.js" type="text/javascript"></script>
</head>
<body onLoad="jumpScroll()">

<div class="loader"></div>

<%@ include file="header.jsp" %> 
<%@ include file="nav.jsp" %> 
<%@ include file="home.jsp" %> 
<%@ include file="busca.jsp" %> 
<%@ include file="noticias.jsp" %> 
<%@ include file="faq.jsp" %> 
<%@ include file="quem.jsp" %> 
<%@ include file="contato.jsp" %> 


</body>
</html>