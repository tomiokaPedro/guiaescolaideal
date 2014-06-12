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

		var mapOptions = {
			center : posicao,
			zoom : 15,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};
		
		map = new google.maps.Map(document.getElementById("map_canvas"),
				mapOptions);
		
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
		window.onload = inicializaPorPosicao("${escola.endereco.posicao.longitude}", "${escola.endereco.posicao.latitude}");
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