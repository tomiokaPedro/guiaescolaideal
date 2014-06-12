<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<style type="text/css">
html {
	height: 100%
}

body {
	height: 100%;
	margin: 0;
	padding: 0
}

#map_canvas {
	height: 100%
}
</style>
</head>
<body onload="initialize()">
	<div id="map_canvas" style="width: 100%; height: 100%"></div>
	
<script type="text/javascript"
	src="http://maps.googleapis.com/maps/api/js?sensor=TRUE">
	
</script>
<script type="text/javascript">
	var map;
	var escolaLatLng;
	
	function inicializaPorPosicao(latitude, longitude){
		escolaLatLng = new google.maps.LatLng(latitude, longitude);
		initialize(escolaLatLng);
	}
	
	function inicializaPorNome(search){
		//achar por nome
		initialize();
	}
	
	function initialize(posicao) {
		if(posicao === 'undefined'){
			posicao = new google.maps.LatLng(-34.397, 150.644);
		}
		
		var mapOptions = {
			center : posicao,
			zoom : 15,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};
		var map = new google.maps.Map(document.getElementById("map_canvas"),
				mapOptions);
	}

	function verificaPosicaoUsuario() {
		if(navigator.geolocation){
			navigator.geolocation.getCurrentPosition(success, pegaPosicaoDoUsuario);
		}else{
			pegaPosicaoDoUsuario();
		}
	}
	
	function success(position){
		//C1
	}
	
	function pegaPosicaoDoUsuario(msg){
		//C2
	}
</script>
	<c:if test="${escola.endereco.posicao.latitude > -666}" >
		<script>	
		window.onload = inicializaPorPosicao("${escola.endereco.posicao.latitude}", "${escola.endereco.posicao.longitude}");
		</script>
	</c:if>
	<c:if test="${escola.endereco.posicao.latitude <= -666}" >
		<script>	
		//window.onload = inicializaPorNome("${escola.nomeEscola} , ${escola.endereco.bairro}, ${escola.endereco.municipio.nome}, ${${escola.endereco.municipio.uf.estado}, Brasil");
		window.onload = inicializaPorNome("${escola.nomeEscola}");
		</script>
	</c:if>
</body>
</html>