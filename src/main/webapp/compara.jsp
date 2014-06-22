<div class="portfolio-modal modal fade" id="modal-compara" tabindex="-1"
	role="dialog" aria-hidden="true">
	<div class="modal-content">
		<div class="close-modal" data-dismiss="modal">
			<div class="lr">
				<div class="rl"></div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<div class="modal-body">
						<h2>Compara</h2>
						<hr class="star-primary">
					</div>
					<div class="categorias col-xs-12 col-md-10 col-md-offset-1">
						<!-- Inicio -->
<div class="cabecalho col-xs-9 col-xs-offset-3">
	<form action="removePerfilServlet.jsp" method="post">
	<div class="col-xs-12 col-sm-6 col-md-6">
		<div class="col-xs-10 dado-nome">
			${compara.escolaA.nomeEscola}
		</div>
		<div class="col-xs-2 dado-botao">
			<button class="btn btn-warning" type="submit" name="id" value="${compara.escolaA.codEscola}">
				<span class="glyphicon glyphicon-remove" style="color:white">
				</span>
			</button>
		</div>
	</div>
	<div class="col-xs-12 col-sm-6 col-md-6">
		<div class="col-xs-10 dado-nome">
			${compara.escolaB.nomeEscola}
		</div>
		<div class="col-xs-2 dado-botao">
			<button class="btn btn-warning" type="submit" name="id" value="${compara.escolaB.codEscola}">
				<span class="glyphicon glyphicon-remove" style="color:white"></span>
			</button>
		</div>
	</div>	
	</form>
</div>



						<!--  fim -->
					</div>
				</div>
			</div>
		</div>
	</div>
</div>