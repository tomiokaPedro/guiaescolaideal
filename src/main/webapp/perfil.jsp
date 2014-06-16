<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Guia da Escola Ideal</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="css/freelancer.css" rel="stylesheet" type="text/css">
    <link href="css/style.css" rel="stylesheet" type="text/css">

    <!-- Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>

    <!-- IE8 support for HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    
  
 

 	

</head>
<body>

<%@ include file="navbar.jsp" %> 
<%@ include file="guia.jsp" %> 
<%@ include file="home.jsp" %> 
<%@ include file="selecionabusca.jsp" %> 
<%@ include file="faq.jsp" %> 
<%@ include file="quemsomos.jsp" %> 
<%@ include file="contato.jsp" %> 
<%@ include file="footer.jsp" %> 
<%@ include file="click.jsp" %> 
<%@ include file="pesquisaideal.jsp" %> 
 
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script src="js/classie.js"></script>
    <script src="js/cbpAnimatedHeader.js"></script>
    <script src="js/freelancer.js"></script>
    <script src="jquery-2.1.1.min.js" type="text/javascript" charset="utf-8"></script>

<script type="text/javascript">
    $(window).load(function(){
        $('#portfolioModal1').modal('show');
    });
</script>


    <script type="text/javascript">
    	$(function(){
  		$("#select_estado").change(function(event){
  		$("option:selected", $(this)).each(function(){
  		var obj = document.getElementById('select_estado').value;
  			if(obj != "x"){
  				$("#select_estado").removeClass("disable").addClass("enable");
  			}else{
  				$("#select_estado").removeClass("enable").addClass("disable");
  			}
  			});
  		});
  		});
    </script>


    <script type="text/javascript">
    	$(function(){
  		$("#modalidade").change(function(event){
  		$("option:selected", $(this)).each(function(){
  		var obj = document.getElementById('modalidade').value;
  			if(obj != "x"){
  				$("#modalidade").removeClass("disable").addClass("enable");
  			}else{
  				$("#modalidade").removeClass("enable").addClass("disable");
  			}
  			});
  		});
  		});
    </script>
    
      <script type="text/javascript">

$(document).ready(function(){
    $('#table_id td.y_n').each(function(){
        if ($(this).text() == 'false') {
            $(this).css('background-color','red');
        }
    });
});

$(document).ready(function(){
    $('#table_id td.y_n').each(function(){
        if ($(this).text() == 'true') {
            $(this).css('background-color','green');
        }
    });
});

</script>

</body>

</html>
