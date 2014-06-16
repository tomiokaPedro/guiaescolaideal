<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<<<<<<< HEAD

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
=======
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
>>>>>>> refs/remotes/origin/S3U568

<<<<<<< HEAD
=======
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
>>>>>>> refs/remotes/origin/S3U568

<<<<<<< HEAD
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
=======
<!-- Optional theme -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
>>>>>>> refs/remotes/origin/S3U568

<style>
.localizacao {
	margin-top: 15px;
}

.caminho-botao{
	display:none;
}

.mapa {
	height: 300px;
}

<<<<<<< HEAD
=======
@media ( min-width : 992px) {
	.mapa {
		height: 480px;
	}
}

td {
	padding: 5px;
}

td.y, td.n{
	width: 14px;
    padding-left: 10px;
    padding-right: 10px;
}

.y {
	color:green;
}

.n{
	color:red;
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
			<td class="${escola.seFinsLucrativos?'y':'n'}"></td>
			<td>Brasil Alfabetização</td>
			<td class="${escola.brasilAlfabetizacao?'y':'n'}"></td>
			<td>Educação Indigena</td>
			<td class="${escola.educacaoIndigena?'y':'n'}"></td>
		</tr>
		<tr>
			<td>Acessibilidade</td>
			<td class="${escola.acessibilidade?'y':'n'}"></td>
		</tr>
		<tr>
			<th>Acesso</th>
		</tr>
		<tr>
			<td>Depende de Vias de Acesso</td>
			<td class="${escola.dependViasAcesso?'y':'n'}"></td>
		</tr>
		<tr>
			<th>Infra-Estrutura</th>
		</tr>
		<tr>
			<td>Cozinha</td>
			<td class="${escola.cozinha?'y':'n'}"></td>
			<td>Berçario</td>
			<td class="${escola.bercario?'y':'n'}"></td>
			<td>Secretaria</td>
			<td class="${escola.secretaria?'y':'n'}"></td>

		</tr>
		<tr>
			<td>Dispensa</td>
			<td class="${escola.despensa?'y':'n'}"></td>
			<td>Auditório</td>
			<td class="${escola.auditorio?'y':'n'}"></td>
			<td>Lavanderia</td>
			<td class="${escola.lavanderia?'y':'n'}"></td>
		</tr>
		<tr>
			<td>Refeitório</td>
			<td class="${escola.refeitorio?'y':'n'}"></td>
			<td>Almoxarifado</td>
			<td class="${escola.almoxarifado?'y':'n'}"></td>
			<td>Chuveiro</td>
			<td class="${escola.banheiroChuveiro?'y':'n'}"></td>
		</tr>
		<tr>



			<td>Alojamento Aluno</td>
			<td class="${escola.alojamentoAluno?'y':'n'}"></td>
		</tr>

		<tr>
			<th>Salas</th>
		</tr>
		<tr>
			<td>Sala de Leitura</td>
			<td class="${escola.salaLeitura?'y':'n'}"></td>
			<td>Sala de Atendimento Especializado</td>
			<td class="${escola.salaAtendimentoEspecializado?'y':'n'}"></td>
			<td>Sala Professor</td>
			<td class="${escola.salaProfessor?'y':'n'}"></td>
		</tr>
		<tr>
			<td>Sala Diretoria</td>
			<td class="${escola.salaDiretoria?'y':'n'}"></td>
		</tr>
		<tr>
			<th>Laboratórios</th>
		</tr>
		<tr>
			<td>Laboratório de Informática</td>
			<td class="${escola.labInformatica?'y':'n'}"></td>
			<td>Laboratório de Ciências</td>
			<td class="${escola.labCiencias?'y':'n'}"></td>
		</tr>
		<tr>
			<th>Recreação</th>
		</tr>
		<tr>
			<td>Quadra de Esportes Coberta</td>
			<td class="${escola.quadraEsporteCoberta?'y':'n'}"></td>
			<td>Quadra de Esportes Descoberta</td>
			<td class="${escola.quadraEsporteDescoberta?'y':'n'}"></td>
			<td>Pátio Coberto</td>
			<td class="${escola.patioCoberto?'y':'n'}"></td>
		</tr>
		<tr>
			<td>Pátio Descoberto</td>
			<td class="${escola.patioDescoberto?'y':'n'}"></td>
			<td>Parque Infantil</td>
			<td class="${escola.parqueInfantil?'y':'n'}"></td>
		</tr>
		<tr>
			<th>Sanitários</th>
		</tr>
		<tr>
			<td>Sanitário Adequado Infantil</td>
			<td class="${escola.sanitarioAdequadoInfantil?'y':'n'}"></td>
			<td>Sanitário Fora do Prédio</td>
			<td class="${escola.sanitarioForaPredio?'y':'n'}"></td>
		</tr>
		<th>Serviços</th>
		</tr>

		<tr>

			<td>Agua Filtrada</td>
			<td class="${escola.aguaFiltrada?'y':'n'}"></td>
			<td>Internet</td>
			<td class="${escola.internet?'y':'n'}"></td>
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
		<div class="col-xs-12 col-md-1">
			<button id="botao-caminho" class="btn btn-primary btn-lg caminho-botao" data-toggle="modal"
				data-target="#caminho">caminho</button>

			<div class="modal fade" id="caminho">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title">Trajeto</h4>
						</div>
						<div class="modal-body" id="info-mapa"></div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->
		</div>
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
	<!-- Se Escola tem posicao então -->
	<c:if test="${!escola.endereco.posicao.latitude.equals(\"ERROR\")}">
		<script>
			window.onload = inicializaPorPosicao(
					"${escola.endereco.posicao.latitude}",
					"${escola.endereco.posicao.longitude}");
		</script>
	</c:if>
	<script>
		$(".y").append("<span class=\"glyphicon glyphicon-ok\"></span>");
		$(".n").append("<span class=\"glyphicon glyphicon-remove\"></span>");
	</script>
	<footer>@2014</footer>
>>>>>>> refs/remotes/origin/S3U568
</body>

</html>
