<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<style type="text/css">


#map_canvas {
	height: 400px;
}

body{
width:100% !important;
}

</style>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

</head>
<body >
	<!-- Para que o mapa seja exibido em uma página da Web, devemos reservar um espaço para ele fazemos isso criando um
	elemento div nomeado e obtendo uma referência para esse elemento no modelo de objeto de documento (DOM) do navegador.-->
	<div id="map_canvas" class = "col-xs-12 col-md-6" ></div>
	<div id="endereco" class = "col-xs-12 col-md-2">
		<div: class = "col-xs-12">
		Bairro: ${escola.endereco.bairro}</div:>
		<div: class = "col-xs-12">
		Rua: ${escola.endereco.rua} </div:>
		<div: class = "col-xs-12">
		Número: ${escola.endereco.numero}</div:>
		<div: class = "col-xs-12">
		Complemento: ${escola.endereco.complemento}</div:>
		<div: class = "col-xs-12">
		CEP: ${escola.endereco.cep}</div:>
		<div: class = "col-xs-12">
		Municipio: ${escola.endereco.municipio.nome}</div:>
	</div>
	
	
	<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=TRUE">
    </script>
	<script type="text/javascript">
	var map;
	var directionsDisplay;
	var directionsService = new google.maps.DirectionsService();
	var escolaLatLng;
	
	function inicializaPorPosicao(latitude, longitude){
		escolaLatLng = new google.maps.LatLng(latitude, longitude);
		inicializaMapa(escolaLatLng);
		verificaPosicaoUsuario();

	}
	
	function inicializaMapa(posicao) {
		if(posicao === undefined){
			posicao = new google.maps.LatLng(-18.8800397, -47.05878999999999);
		}
		
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
		map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions); 
		
		directionsDisplay = new google.maps.DirectionsRenderer();
		directionsDisplay.setMap(map);
		directionsDisplay.setPanel(document.getElementById("info-mapa"));
	}

	function verificaPosicaoUsuario() {
		if(navigator.geolocation){
			navigator.geolocation.getCurrentPosition(success, erro);
		}else{
			erro();
		}
	}
	
	function success(position){
		var enderecoPartida = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
		var enderecoChegada = escolaLatLng;

		var request = {
			origin: enderecoPartida,
			destination: enderecoChegada,
			travelMode: google.maps.TravelMode.DRIVING
		};

		directionsService.route(request, function(result, status) {
			if (status == google.maps.DirectionsStatus.OK) {
				directionsDisplay.setDirections(result);
			}else{
				erro();
			}
		});
	}
	
	function erro(){
		marker = new google.maps.Marker({
		    map:map,
		    draggable:false,
		    position: escolaLatLng,
		    title: "Localização da escola."
		});	
	}
	
</script>
	<!-- Se Escola tem posicao então -->
	<c:if test="${!escola.endereco.posicao.latitude.equals(\"ERROR\")}" >
		<script>	
		window.onload = inicializaPorPosicao("${escola.endereco.posicao.latitude}", "${escola.endereco.posicao.longitude}");
		</script>
	</c:if>
</body>
</html>