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