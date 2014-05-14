<section class="conteudo" id="busca">
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<table>
		<c:forEach var="escola" items="${listaEscola}">
			<tr>
				<td>${escola.nomeEscola}</td>
				<td>${escola.email}</td>
				<td>${escola.endereco.bairro}</td>
				<td>(${escola.endereco.municipio.codigoDDD})${escola.telefone.telefone}</td>
			</tr>
		</c:forEach>
		
		<a href="resultadoPesquisa.jsp?code=2">teste</a>
	</table>
</section>