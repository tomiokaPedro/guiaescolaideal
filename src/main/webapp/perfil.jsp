<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
	<table>
		<c:forEach var="escola" items="${listaEscola}">
			<tr>
				<td>${escola.nomeEscola}</td>
				<td>${escola.email}</td>
				<td>${escola.endereco.bairro}</td>
				<td>(${escola.endereco.municipio.codigoDDD})${escola.telefone.telefone}</td>
				<td>(${escola.codigoRede })</td>
				<td>(${escola.tipoLocalizacao})</td>
				<td>(${escola.codigoendereco})</td>
				<td>(${escola.condicaoFuncionamento})</td>
				<td>(${escola.email})</td>
				<td>(${escola.sistemaEmail})</td>
				<td>(${escola.ong })</td>
				<td>(${escola.dataInicioLetivo })</td>
				<td>(${escola.dataTerminoLetivo })</td>
				<td>(${escola.seFinsLucrativos })</td>
				<td>(${escola.atividadeComplementar})</td>
				<td>(${escola.codLocalFuncionamento})</td>
				<td>(${escola.acessibilidade})</td>
				<td>(${escola.dependViasAcesso})</td>
				<td>(${escola.santiAcess})</td>
				<td>(${escola.atendEducacionalEspecializado})</td>
				<td>(${escola.salaDiretoria})</td>
				<td>(${escola.salaProfessor})</td>
				<td>(${escola.secretaria})</td>
				<td>(${escola.refeitorio})</td>
				<td>(${escola.dispensa})</td>
				<td>(${escola.almoxarifado})</td>
				<td>(${escola.despensa})</td>
				<td>(${escola.auditorio})</td>
				<td>(${escola.labInformatica})</td>
				<td>(${escola.labCiencias})</td>
				<td>(${escola.salaAtendimentoEspecializado})</td>
				<td>(${escola.quadraEsporteCoberta})</td>
				<td>(${escola.quadraEsporteDescoberta})</td>
				<td>(${escola.patioCoberto})</td>
				<td>(${escola.patioDescoberto})</td>
				<td>(${escola.parqueInfantil})</td>
				<td>(${escola.cozinha})</td>
				<td>(${escola.biblioteca})</td>
				<td>(${escola.bercario})</td>
				<td>(${escola.sanitarioNoPredio})</td>
				<td>(${escola.sanitarioForaPredio})</td>
				<td>(${escola.sanitarioAdequadoInfantil})</td>
				<td>(${escola.banheiroChuveiro})</td>
				<td>(${escola.lavanderia})</td>
				<td>(${escola.outrasDependencias})</td>
				<td>(${escola.numSalaExistentes})</td>
				<td>(${escola.numSalaUtilizadas})</td>
				<td>(${escola.salaLeitura})</td>
				<td>(${escola.alojamentoAluno})</td>
				<td>(${escola.alojamentoProfessor})</td>
				<td>(${escola.areaVerde})</td>
				<td>(${escola.numFuncionarios})</td>	
				<td>(${escola.alimentacaoEscAlunos})</td>
				<td>(${escola.aguaFiltrada})</td>
				<td>(${escola.internet})</td>
				<td>(${escola.numComputadoresAlunos})</td>
				<td>(${escola.numComputadoresAdministracao})</td>
				<td>(${escola.numComputadoresTotal})</td>
				<td>(${escola.educacaoIndigena})</td>
				<td>(${escola.linguaIndigena})</td>
				<td>(${escola.brasilAlfabetizacao})</td>
				<td>(${escola.aberturaFdsComun})</td>
				<td>(${escola.numMatriculas})</td>
			</tr>
		</c:forEach>
		
		<a href="resultadoPesquisa.jsp?code=2">teste</a>
		
	</table>
</body>
</html>