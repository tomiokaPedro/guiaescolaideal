<!-- Código criado a partir da demo https://github.com/wesnolte/Pajinate-->
	
	<section class="conteudo" id="busca">
	
	  <br/>
	   <br/>
	    <br/>
	     <br/>
	         <br/>
	          <br/>
	           <br/>
	        <div class="container">
			 <div class="content"> 
				<c:forEach var="escolar" items="${listaescola}">
					<div class="escola">
						Nome:<a href="pegarEscola.jsp?id=${escolar.codEscola}">${escolar.nomeEscola}</a><br> 
						Bairro: ${escolar.endereco.bairro}<br> 
						E-Mail:${escolar.email}<br>
						Telefone:(${escolar.endereco.municipio.codigoDDD})${escolar.telefone.telefone}
					</div>
				</c:forEach>
			</div>
			<div class="page_navigation"></div>
		</div>
	</section>

