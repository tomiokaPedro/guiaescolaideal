<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Guia da Escola Ideal</title>
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript"
	src="http://maps.googleapis.com/maps/api/js?sensor=TRUE"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#table_id td.y_n').each(function() {
			if ($(this).text() == 'false') {
				$(this).css('background-color', 'red');
			}
		});
	});

	$(document).ready(function() {
		$('#table_id td.y_n').each(function() {
			if ($(this).text() == 'true') {
				$(this).css('background-color', 'green');
			}
		});
	});
</script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<style>
.localizacao {
	margin-top: 15px;
}

.mapa {
	height: 300px;
}

@media ( min-width : 992px) {
	.mapa {
		height: 480px;
	}
}
</style>
</head>

<body>

	<p>
		Nome:${escola.nomeEscola} &nbsp; &nbsp; &nbsp; <br>
	</p>
	<hr />
	<table id="table_id">
		<tr>
			<th>Modalidade</th>
		</tr>
		<tr>
			<td>Sem Fins Lucrativos</td>
			<td class="y_n">${escola.seFinsLucrativos }</td>
			<td>Brasil Alfabetização</td>
			<td class="y_n">${escola.brasilAlfabetizacao}</td>
			<td>Educação Indigena</td>
			<td class="y_n">${escola.educacaoIndigena}</td>
		</tr>
		<tr>
			<td>Acessibilidade</td>
			<td class="y_n">${escola.acessibilidade}</td>
		</tr>
		<tr>
			<th>Acesso</th>
		</tr>
		<tr>
			<td>Depende de Vias de Acesso</td>
			<td class="y_n">${escola.dependViasAcesso}</td>
		</tr>
		<tr>
			<th>Infra-Estrutura</th>
		</tr>
		<tr>
			<td>Cozinha</td>
			<td class="y_n">${escola.cozinha}</td>
			<td>Berçario</td>
			<td class="y_n">${escola.bercario}</td>
			<td>Secretaria</td>
			<td class="y_n">${escola.secretaria}</td>

		</tr>
		<tr>
			<td>Dispensa</td>
			<td class="y_n">${escola.despensa}</td>
			<td>Auditório</td>
			<td class="y_n">${escola.auditorio}</td>
			<td>Lavanderia</td>
			<td class="y_n">${escola.lavanderia}</td>
		</tr>
		<tr>
			<td>Refeitório</td>
			<td class="y_n">${escola.refeitorio}</td>
			<td>Almoxarifado</td>
			<td class="y_n">${escola.almoxarifado}</td>
			<td>Chuveiro</td>
			<td class="y_n">${escola.banheiroChuveiro}</td>
		</tr>
		<tr>



			<td>Alojamento Aluno</td>
			<td class="y_n">${escola.alojamentoAluno}</td>
		</tr>

		<tr>
			<th>Salas</th>
		</tr>
		<tr>
			<td>Sala de Leitura</td>
			<td class="y_n">${escola.salaLeitura}</td>
			<td>Sala de Atendimento Especializado</td>
			<td class="y_n">${escola.salaAtendimentoEspecializado}</td>
			<td>Sala Professor</td>
			<td class="y_n">${escola.salaProfessor}</td>
		</tr>
		<tr>
			<td>Sala Diretoria</td>
			<td class="y_n">${escola.salaDiretoria}</td>
		</tr>
		<tr>
			<th>Laboratórios</th>
		</tr>
		<tr>
			<td>Laboratório de Informática</td>
			<td class="y_n">${escola.labInformatica}</td>
			<td>Laboratório de Ciências</td>
			<td class="y_n">${escola.labCiencias}</td>
		</tr>
		<tr>
			<th>Recreação</th>
		</tr>
		<tr>
			<td>Quadra de Esportes Coberta</td>
			<td class="y_n">${escola.quadraEsporteCoberta}</td>
			<td>Quadra de Esportes Descoberta</td>
			<td class="y_n">${escola.quadraEsporteDescoberta}</td>
			<td>Pátio Coberto</td>
			<td class="y_n">${escola.patioCoberto}</td>
		</tr>
		<tr>
			<td>Pátio Descoberto</td>
			<td class="y_n">${escola.patioDescoberto}</td>
			<td>Parque Infantil</td>
			<td class="y_n">${escola.parqueInfantil}</td>
		</tr>
		<tr>
			<th>Sanitários</th>
		</tr>
		<tr>
			<td>Sanitário Adequado Infantil</td>
			<td class="y_n">${escola.sanitarioAdequadoInfantil}</td>
			<td>Sanitário Fora do Prédio</td>
			<td class="y_n">${escola.sanitarioForaPredio}</td>
		</tr>
		<th>Serviços</th>
		</tr>

		<tr>

			<td>Agua Filtrada</td>
			<td class="y_n">${escola.aguaFiltrada}</td>
			<td>Internet</td>
			<td class="y_n">${escola.internet}</td>
		</tr>

	</table>

	<div class="localizacao col-xs-12">
		<!-- Para que o mapa seja exibido em uma página da Web, devemos reservar um espaço para ele fazemos isso criando um
	elemento div nomeado e obtendo uma referência para esse elemento no modelo de objeto de documento (DOM) do navegador.-->
		<div id="endereco" class="col-xs-12 col-md-3">
			<div: class="col-xs-12">
		Bairro: ${escola.endereco.bairro}</div:>
			<div: class="col-xs-12">
		Rua: ${escola.endereco.rua} </div:>
			<div: class="col-xs-12">
		Número: ${escola.endereco.numero}</div:>
			<div: class="col-xs-12">
		Complemento: ${escola.endereco.complemento}</div:>
			<div: class="col-xs-12">
		CEP: ${escola.endereco.cep}</div:>
			<div: class="col-xs-12">
		Municipio: ${escola.endereco.municipio.nome}</div:>
		</div>
		<div id="map_canvas" class="col-xs-12 col-md-8 mapa"></div>
	</div>

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
			var enderecoPartida = new google.maps.LatLng(
					position.coords.latitude, position.coords.longitude);
			var enderecoChegada = escolaLatLng;

			var request = {
				origin : enderecoPartida,
				destination : enderecoChegada,
				travelMode : google.maps.TravelMode.DRIVING
			};

			directionsService.route(request, function(result, status) {
				if (status == google.maps.DirectionsStatus.OK) {
					directionsDisplay.setDirections(result);
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
	<!-- Se Escola tem posicao então -->
	<c:if test="${!escola.endereco.posicao.latitude.equals(\"ERROR\")}">
		<script>
			window.onload = inicializaPorPosicao(
					"${escola.endereco.posicao.latitude}",
					"${escola.endereco.posicao.longitude}");
		</script>
	</c:if>

	<footer>@2014</footer>
</body>
</html>