<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="style.css">
	<title>Guia da Escola Ideal</title>
	<!--[if IE]>
  		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
</head>
<body>
	<header>
		<div id="logo"></div>
	</header>
	<nav>
		<ul>
			<li><a href="#home">Home</a></li>
			<li><a href="#busca">Buscar Escola</a></li>
			<li><a href="#noticias">Noticias</a></li>
			<li><a href="#faq">FAQ</a></li>
			<li><a href="#quem">Quem Somos</a></li>
			<li><a href="#contato">Contato</a></li>
		</ul>
	</nav>
	<section class="conteudo" id="home"></section>
	<section class="conteudo" id="busca"></section>
	<section class="conteudo" id="noticias"></section>
	<section class="conteudo" id="faq"></section>
	<section class="conteudo" id="quem"></section>
	<section class="conteudo" id="contato"></section>

	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script type="text/javascript" src="jquery.easing.1.3.js"></script>

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
	
</body>
</html>
    