<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<style type="text/css">

#map_canvas {
	height: 400px;
	width: 600px;
	border: 1px solid black;
}
</style>
</head>
<body >
	<!-- Para que o mapa seja exibido em uma página da Web, devemos reservar um espaço para ele fazemos isso criando um
	elemento div nomeado e obtendo uma referência para esse elemento no modelo de objeto de documento (DOM) do navegador.-->
	<div id="map_canvas"></div>

	<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=TRUE">
    </script>
	<script type="text/javascript">
	var map;
	var directionsDisplay;
	var directionsService = new google.maps.DirectionsService();
	var escolaLatLng;
	
	function inicializaPorPosicao(latitude, longitude){
		escolaLatLng = new google.maps.LatLng(latitude, longitude);
		initialize(escolaLatLng);
		verificaPosicaoUsuario();

	}
	
	function marcaPonto(posicao, title){
		var marker = new google.maps.Marker({
		    position: posicao,
		    map: map,
		    title:title
		});
	}
	
	function inicializaPorNome(search){
		//achar por nome
		initialize();
	}
	
	function initialize(posicao) {
		if(posicao === undefined){
			console.log("setando posicao");
			posicao = new google.maps.LatLng(-18.8800397, -47.05878999999999);
		}
		
		<!-- Para inicializar um mapa, primeiro devemos criar um objeto Map options para conter variáveis de inicialização do mapa. -->
		var mapOptions = {
			center : posicao, <!-- Para centralizar o mapa no ponto específico da (latitude, longitude) -->
			zoom : 15,
			mapTypeId : google.maps.MapTypeId.ROADMAP <!-- Definição do tipo de mapa: ROADMAP - exibe os blocos 2D normais padrão do Google Maps.-->
		};
		
		map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions); <!-- Instanciação de um objeto do tipo Map. A classe JavaScript que representa um mapa é a classe Map.-->
		
		directionsDisplay = new google.maps.DirectionsRenderer();
		directionsDisplay.setMap(map);
		directionsDisplay.setPanel(document.getElementById("info-mapa"));
	}

	function verificaPosicaoUsuario() {
		if(navigator.geolocation){
			navigator.geolocation.getCurrentPosition(success, pegaPosicaoDoUsuario);
		}else{
			pegaPosicaoDoUsuario();
		}
	}
	
	function success(position){
		console.log("Foi");
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
				console.log(status);
			}
		});
	}
	
	function pegaPosicaoDoUsuario(msg){
		//C2
	}
</script>
	<c:if test="${!escola.endereco.posicao.latitude.equals(\"ERROR\")}" >
		<script>	
		window.onload = inicializaPorPosicao("${escola.endereco.posicao.latitude}", "${escola.endereco.posicao.longitude}");
		</script>
	</c:if>
	<c:if test="${escola.endereco.posicao.latitude.equals(\"ERROR\")}" >
		<script>	
		//window.onload = inicializaPorNome("${escola.nomeEscola} , ${escola.endereco.bairro}, ${escola.endereco.municipio.nome}, ${escola.endereco.municipio.uf.estado}, Brasil");
		window.onload = inicializaPorNome("${escola.nomeEscola}");
		</script>
	</c:if>
</body>
</html>