<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Guia da Escola Ideal</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/freelancer.css" rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css">

<!-- Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>

	<!-- IE8 support for HTML5 elements and media queries -->
	<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

</head>
<body>

	<%@ include file="navbar.jsp"%>
	<%@ include file="guia.jsp"%>
	<%@ include file="home.jsp"%>
	<%@ include file="selecionabusca.jsp"%>
	<%@ include file="faq.jsp"%>
	<%@ include file="quemsomos.jsp"%>
	<%@ include file="contato.jsp"%>
	<%@ include file="footer.jsp"%>
	<%@ include file="click.jsp"%>
	<%@ include file="pesquisaideal.jsp"%>

	<script src="js/jquery-1.10.2.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
	<script src="js/classie.js"></script>
	<script src="js/cbpAnimatedHeader.js"></script>
	<script src="js/freelancer.js"></script>
	<script src="jquery-2.1.1.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="http://maps.googleapis.com/maps/api/js?libraries=places&sensor=false"></script>
	
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
	var map;
	var directionsDisplay;
	var directionsService = new google.maps.DirectionsService();
	var escolaLatLng;

	function inicializaPorPosicao(latitude, longitude) {
		escolaLatLng = new google.maps.LatLng(latitude, longitude);
		inicializaMapa(escolaLatLng);
		verificaPosicaoUsuario();
		marcaEscola();
	}

	function inicializaMapa(posicao) {
		/*
		 * Para inicializar um mapa, primeiro devemos criar um objeto Map options 
		 * para conter variáveis de inicialização do mapa.
		 */
		var mapOptions = {
			// Para centralizar o mapa no ponto específico da (latitude, longitude)
			center : posicao,
			zoom : 15,
			// Definição do tipo de mapa: ROADMAP - exibe os blocos 2D normais padrão do Google Maps
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};

		/*
		 * Instanciação de um objeto do tipo Map. A classe JavaScript que representa 
		 * um mapa é a classe Map.
		 */
		map = new google.maps.Map(document.getElementById("map_canvas"),
				mapOptions);

		directionsDisplay = new google.maps.DirectionsRenderer();
		directionsDisplay.setMap(map);
		directionsDisplay.setPanel(document.getElementById("info-mapa"));
	}

	function verificaPosicaoUsuario() {
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(success, erro);
		} else {
			erro();
		}
	}

	function success(position) {
		var enderecoPartida = new google.maps.LatLng(position.coords.latitude,
				position.coords.longitude);
		var enderecoChegada = escolaLatLng;

		var request = {
			origin : enderecoPartida,
			destination : enderecoChegada,
			travelMode : google.maps.TravelMode.DRIVING
		};

		directionsService.route(request, function(result, status) {
			if (status == google.maps.DirectionsStatus.OK) {
				directionsDisplay.setDirections(result);
				$("#botao-caminho").css('display', 'block');
			} else {
				marcaEscola();
			}
		});
	}

	function marcaEscola() {
		console.log("2");
		marker = new google.maps.Marker({
			map : map,
			draggable : false,
			position : escolaLatLng,
			title : "Localização da escola."
		});
	}

	function erro(msg) {
		console.log(msg);
	}
</script>
<script>
	$(".y").append("<span class=\"glyphicon glyphicon-ok\"></span>");
	$(".n").append("<span class=\"glyphicon glyphicon-remove\"></span>");
</script>
<!-- Se Escola tem posicao então -->
<c:if test="${!escola.endereco.posicao.latitude.equals(\"ERROR\")}">
<script>
	
		function inicMapa(){
			inicializaPorPosicao(
					"${escola.endereco.posicao.latitude}",
					"${escola.endereco.posicao.longitude}");
		}
		
		document.ready = inicMapa();
		
		$('#portfolioModal1').on('shown.bs.modal', function() {
			inicMapa();
		});
	</script>
</c:if>

</body>
</html>
