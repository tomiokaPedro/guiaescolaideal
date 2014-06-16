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
		<button id="botao-caminho"
			class="btn btn-primary btn-lg caminho-botao" data-toggle="modal"
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
<!-- Se Escola tem posicao então -->
<c:if test="${!escola.endereco.posicao.latitude.equals(\"ERROR\")}">
	<script>
		window.onload = inicializaPorPosicao(
				"${escola.endereco.posicao.latitude}",
				"${escola.endereco.posicao.longitude}");
	</script>
</c:if>