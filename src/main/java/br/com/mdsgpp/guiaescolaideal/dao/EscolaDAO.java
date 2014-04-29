package br.com.mdsgpp.guiaescolaideal.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.mdsgpp.guiaescolaideal.model.Escola;

public class EscolaDAO {

	private Connection connection;

	public EscolaDAO(Connection connection) {
		this.connection = connection;
	}

	public Escola pesquisarPorID(int id) throws SQLException, ParseException {
		String sql = "select * from escola where COD_ESCOLA= ?";

		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {

			Escola escola = getEscola(rs);

			stmt.close();
			return escola;
		}

		stmt.close();
		return null;
	}

	public List<Escola> pesquisarPorNome(String nome, int comeco, int quantidade)
			throws SQLException, ParseException {

		if (nome.isEmpty()) {
			throw new IllegalArgumentException();
		}

		ArrayList<String> listaPalavras = new ArrayList<String>();
		listaPalavras.add(nome);

		return pesquisarPorNomeComPalavrasChaves(listaPalavras, comeco,
				quantidade);
	}

	public List<Escola> pesquisarPorNomeComPalavrasChaves(
			List<String> listaPalavras, int comeco, int quantidade)
			throws SQLException, ParseException {
		
		if((comeco < 0) || (quantidade <= 0)){
			throw new IllegalArgumentException();
		}

		String sql = gerarQuerySql(listaPalavras);
		PreparedStatement stmt = this.connection.prepareStatement(sql);

		int sizeLista = listaPalavras.size();

		for (int i = 1; i <= sizeLista; i++) {
			stmt.setString(i, "%" + listaPalavras.get(i - 1) + "%");
		}

		stmt.setInt(sizeLista + 1, comeco);
		stmt.setInt(sizeLista + 2, quantidade);

		List<Escola> listaEscola = new ArrayList<Escola>();
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			Escola escola = getEscola(rs);
			listaEscola.add(escola);

		}
		
		return listaEscola;
	}

	private Escola getEscola(ResultSet rs) throws SQLException, ParseException {
		Escola escola = new Escola();

		escola.setNomeEscola(rs.getString("NOME_ESCOLA"));
		escola.setCodEscola(rs.getInt("COD_ESCOLA"));
		escola.setTipoLocalizacao(rs.getString("TIPO_LOCALIZACAO"));
		escola.setCodicaoFuncionamento(rs.getString("CONDICAO_FUNCIONAMENTO"));
		escola.setEmail(rs.getString("EMAIL"));
		escola.setSistemaSenai(rs.getString("SE_SISTEMA_SENAI").equalsIgnoreCase("sim"));
		escola.setOng(rs.getString("SE_ONG").equalsIgnoreCase("sim"));
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		escola.setDataInicioLetivo(new Date(dateFormat.parse(rs.getString("DATA_INICIO_LETIVO")).getTime()));
		escola.setDataTerminoLetivo(new Date(dateFormat.parse(rs.getString("DATA_TERMINO_LETIVO")).getTime()));
		
		escola.setSeFinsLucrativos(rs.getString("SE_FINS_LURATIVOS").equalsIgnoreCase("sim"));
		escola.setAtividadeComplementar(rs.getString("ATIVIDADE_COMPLEMENTAR"));
		escola.setAcessibilidade(rs.getString("SE_ACESSIBILIDADE").equalsIgnoreCase("sim"));
		escola.setDependViasAcesso(rs.getString("SE_DEPEN_VIAS_ACES").equalsIgnoreCase("sim"));
		escola.setSantiAcess(rs.getString("SE_SANTI_ACESS").equalsIgnoreCase("sim"));
		escola.setAtendEducacionalEspecializado(rs.getString("SE_AEE").equalsIgnoreCase("sim"));
		escola.setSalaDiretoria(rs.getString("SE_SALA_DIRETORIA").equalsIgnoreCase("sim"));
		escola.setSalaProfessor(rs.getString("SE_SALA_PROFESSOR").equalsIgnoreCase("sim"));
		escola.setSecretaria(rs.getString("SE_SECRETARIA").equalsIgnoreCase("sim"));
		escola.setRefeitorio(rs.getString("SE_REFEITORIO").equalsIgnoreCase("sim"));
		escola.setDespensa(rs.getString("SE_DESPENSA").equalsIgnoreCase("sim"));
		escola.setAlmoxarifado(rs.getString("SE_ALMOXARIFADO").equalsIgnoreCase("sim"));
		escola.setAuditorio(rs.getString("SE_AUDITORIO").equalsIgnoreCase("sim"));
		escola.setLabInformatica(rs.getString("SE_LAB_INFO").equalsIgnoreCase("sim"));
		escola.setLabCiencias(rs.getString("SE_LAB_CIENCIAS").equalsIgnoreCase("sim"));
		escola.setSalaAtendimentoEspecializado(rs.getString("SE_SALA_ATEND_ESP").equalsIgnoreCase("sim"));
		escola.setQuadraEsporteCoberta(rs.getString("SE_QUADRA_ESPO_COBERTA").equalsIgnoreCase("sim"));
		escola.setQuadraEsporteDescoberta(rs.getString("SE_QUADRA_ESPO_DESCOBERTA").equalsIgnoreCase("sim"));
		escola.setPatioCoberto(rs.getString("SE_PATIO_COBERTO").equalsIgnoreCase("sim"));
		escola.setPatioDescoberto(rs.getString("SE_PATIO_DESCOBERTO").equalsIgnoreCase("sim"));
		escola.setParqueInfantil(rs.getString("SE_PARQUE_INFANTIL").equalsIgnoreCase("sim"));
		escola.setCozinha(rs.getString("SE_COZINHA").equalsIgnoreCase("sim"));
		escola.setBiblioteca(rs.getString("SE_BIBLIOTECA").equalsIgnoreCase("sim"));
		escola.setBercario(rs.getString("SE_BERCARIO").equalsIgnoreCase("sim"));
		escola.setSanitarioNoPredio(rs.getString("SE_SANITARIO_NO_PREDIO").equalsIgnoreCase("sim"));
		escola.setSanitarioForaPredio(rs.getString("SE_SANITARIO_FORA_PREDIO").equalsIgnoreCase("sim"));
		escola.setSanitarioAdequadoInfantil(rs.getString("SE_SANITARIO_EDUC_ADEQ_INFAN").equalsIgnoreCase("sim"));
		escola.setBanheiroChuveiro(rs.getString("SE_BANHEIRO_CHUVEIRO").equalsIgnoreCase("sim"));
		escola.setLavanderia(rs.getString("SE_LAVANDERIA").equalsIgnoreCase("sim"));
		escola.setOutrasDependencias(rs.getString("SE_OUTRAS_DEPENDENCIAS").equalsIgnoreCase("sim"));
		
		escola.setNumSalaExistentes(Integer.parseInt(rs.getString("NUM_SALAS_EXISTENTES")));
		escola.setNumSalaUtilizadas(Integer.parseInt(rs.getString("NUM_SALAS_UTILIZADAS")));
		
		escola.setSalaLeitura(rs.getString("SE_SALA_LEITURA").equalsIgnoreCase("sim"));
		escola.setAlojamentoAluno(rs.getString("SE_ALOJAMENTO_ALUNO").equalsIgnoreCase("sim"));
		escola.setAlojamentoProfessor(rs.getString("SE_ALOJAMENTO_PROFESSOR").equalsIgnoreCase("sim"));
		escola.setAreaVerde(rs.getString("SE_AREA_VERDE").equalsIgnoreCase("sim"));
		escola.setAlimentacaoEscAlunos(rs.getString("SE_ALIMENTACAO_ESC_ALUNOS").equalsIgnoreCase("sim"));
		escola.setAguaFiltrada(rs.getString("SE_AGUA_FILTRADA").equalsIgnoreCase("sim"));
		escola.setInternet(rs.getString("SE_INTERNET").equalsIgnoreCase("sim"));
		
		escola.setNumFuncionarios(Integer.parseInt(rs.getString("NUM_FUNCIONARIOS")));
		escola.setNumComputadoresAlunos(Integer.parseInt(rs.getString("NUM_COMPUTADORES_ALUNOS")));
		escola.setNumComputadoresAdministracao(Integer.parseInt(rs.getString("NUM_COMPUTADORES_ADMINISTRACAO")));
		escola.setNumComputadoresTotal(Integer.parseInt(rs.getString("NUM_COMPUTADORES_TOTAL")));
		escola.setNumMatriculas(Integer.parseInt(rs.getString("NUM_MATRICULAS")));
		
		escola.setEducacaoIndigena(rs.getString("SE_EDUCACAO_INDIGNA").equalsIgnoreCase("sim"));
		escola.setLinguaIndigena(rs.getString("SE_LINGUA_INDIGENA").equalsIgnoreCase("sim"));
		escola.setBrasilAlfabetizacao(rs.getString("SE_BRASIL_ALFABETIZACAO").equalsIgnoreCase("sim"));
		escola.setAberturaFdsComun(rs.getString("SE_ABERTURA_FDS_COMUN").equalsIgnoreCase("sim"));
		
		return escola;
	}

	private String gerarQuerySql(List<String> listaPalavras) {
		StringBuilder builder = new StringBuilder();
		builder.append("select * from escola where ");

		int sizeLista = listaPalavras.size();

		for (int i = 0; i < sizeLista; i++) {
			builder.append("( NOME_ESCOLA like ?) ");

			if (i != (sizeLista - 1)) {
				builder.append("AND ");
			}
		}

		builder.append("LIMIT ?, ?");
		return builder.toString();
	}

}
