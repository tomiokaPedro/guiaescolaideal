
<!-- pesquisa especifica -->


<div class="portfolio-modal modal fade" id="portfolioModal1"
	tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-content">
		<div class="close-modal" data-dismiss="modal">
			<div class="lr">
				<div class="rl"></div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<div class="modal-body">
						<h2>Resultado</h2>
						<hr class="star-primary">
					</div>
					<div class="row">
						<div class="col-lg-8 col-lg-offset-2">
							<div id="content">	
								<c:forEach var="escolar" items="${listaescola}">
										Nome:<a href="pegarEscola.jsp?id=${escolar.codEscola}">${escolar.nomeEscola}</a>
									<br> 
										Bairro: ${escolar.endereco.bairro}<br> 
										Telefone:(${escolar.endereco.municipio.codigoDDD})${escolar.telefone.telefone}
										<br>
									<br>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
