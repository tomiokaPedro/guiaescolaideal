<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link rel="stylesheet" href="CSS/style.css">
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

	<script>
	$(function() {
	  $('a[href*=#]:not([href=#])').click(function() {
	    if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {

	      var target = $(this.hash);
	      target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
	      if (target.length) {
	        $('html,body').animate({
	          scrollTop: target.offset().top
	        }, 1000);
	        return false;
	      }
	    }
	  });
	});
	</script>
</head>
<body>

	<div class="container">
		<header>
			<div class="menubar">
				<ul class="menu">
  					<li><a href="#first-content" class="active"><span>Home</span></a></li>
  					<li><a href="#second-content"><span>Noticias</span></a></li>
  					<li><a href="#third-content"><span>FAQ</span></a></li>
  					<li><a href="#footer"><span>Contato</span></a></li>
				</ul>
			</div>
		</header>
		<div id="first-content">

		</div>
		<div id="second-content">

		</div>
		<div id="third-content">

		</div>
		<div id="footer">
			<p></p>
			<p></p>
		</div>
	</div>
</body>
</html>	