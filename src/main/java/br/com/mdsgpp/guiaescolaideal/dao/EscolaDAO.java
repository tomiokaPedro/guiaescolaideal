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
import br.com.mdsgpp.guiaescolaideal.util.ConversorDeEntrada;

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

		if ((comeco < 0) || (quantidade <= 0)) {
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
		escola.setSistemaSenai(rs.getString("SE_SISTEMA_SENAI")
				.equalsIgnoreCase("sim"));
		escola.setOng(getBoolean(rs.getString("SE_ONG")));

		escola.setDataInicioLetivo(getData(rs, "DATA_INICIO_LETIVO"));
		escola.setDataTerminoLetivo(getData(rs, "DATA_TERMINO_LETIVO"));

		escola.setSeFinsLucrativos(getBoolean(rs.getString("SE_FINS_LURATIVOS")));
		escola.setAtividadeComplementar(rs.getString("ATIVIDADE_COMPLEMENTAR"));
		escola.setAcessibilidade(getBoolean(rs.getString("SE_ACESSIBILIDADE")));
		escola.setDependViasAcesso(getBoolean(rs
				.getString("SE_DEPEN_VIAS_ACES")));
		escola.setSantiAcess(getBoolean(rs.getString("SE_SANTI_ACESS")));
		escola.setAtendEducacionalEspecializado(rs.getString("SE_AEE"));
		escola.setSalaDiretoria(getBoolean(rs.getString("SE_SALA_DIRETORIA")));
		escola.setSalaProfessor(getBoolean(rs.getString("SE_SALA_PROFESSOR")));
		escola.setSecretaria(getBoolean(rs.getString("SE_SECRETARIA")));
		escola.setRefeitorio(getBoolean(rs.getString("SE_REFEITORIO")));
		escola.setDespensa(rs.getString("SE_DESPENSA").equalsIgnoreCase("sim"));

		escola.setAlmoxarifado(getBoolean(rs.getString("SE_ALMOXARIFADO")));
		escola.setAuditorio(getBoolean(rs.getString("SE_AUDITORIO")));
		escola.setLabInformatica(getBoolean(rs.getString("SE_LAB_INFO")));
		escola.setLabCiencias(getBoolean(rs.getString("SE_LAB_CIENCIAS")));
		escola.setSalaAtendimentoEspecializado(getBoolean(rs
				.getString("SE_SALA_ATEND_ESP")));
		escola.setQuadraEsporteCoberta(getBoolean(rs
				.getString("SE_QUADRA_ESPO_COBERTA")));
		escola.setQuadraEsporteDescoberta(getBoolean(rs
				.getString("SE_QUADRA_ESPO_DESCOBERTA")));
		escola.setPatioCoberto(getBoolean(rs.getString("SE_PATIO_COBERTO")));
		escola.setPatioDescoberto(getBoolean(rs
				.getString("SE_PATIO_DESCOBERTO")));
		escola.setParqueInfantil(getBoolean(rs.getString("SE_PARQUE_INFANTIL")));
		escola.setCozinha(getBoolean(rs.getString("SE_COZINHA")));
		escola.setBiblioteca(getBoolean(rs.getString("SE_BIBLIOTECA")));
		escola.setBercario(getBoolean(rs.getString("SE_BERCARIO")));
		escola.setSanitarioNoPredio(getBoolean(rs
				.getString("SE_SANITARIO_NO_PREDIO")));
		escola.setSanitarioForaPredio(getBoolean(rs
				.getString("SE_SANITARIO_FORA_PREDIO")));
		escola.setSanitarioAdequadoInfantil(getBoolean(rs
				.getString("SE_SANITARIO_EDUC_ADEQ_INFAN")));
		escola.setBanheiroChuveiro(getBoolean(rs
				.getString("SE_BANHEIRO_CHUVEIRO")));
		escola.setLavanderia(getBoolean(rs.getString("SE_LAVANDERIA")));
		escola.setOutrasDependencias(getBoolean(rs
				.getString("SE_OUTRAS_DEPENDENCIAS")));

		escola.setNumSalaExistentes(ConversorDeEntrada
				.getNumeroInteiroSemPonto(rs.getString("NUM_SALAS_EXISTENTES")));
		escola.setNumSalaUtilizadas(ConversorDeEntrada
				.getNumeroInteiroSemPonto(rs.getString("NUM_SALAS_UTILIZADAS")));

		escola.setSalaLeitura(getBoolean(rs.getString("SE_SALA_LEITURA")));
		escola.setAlojamentoAluno(getBoolean(rs
				.getString("SE_ALOJAMENTO_ALUNO")));
		escola.setAlojamentoProfessor(getBoolean(rs
				.getString("SE_ALOJAMENTO_PROFESSOR")));
		escola.setAreaVerde(getBoolean(rs.getString("SE_AREA_VERDE")));

		escola.setAlimentacaoEscAlunos(getBoolean(rs
				.getString("SE_ALIMENTACAO_ESC_ALUNOS")));

		escola.setAguaFiltrada(getBoolean(rs.getString("SE_AGUA_FILTRADA")));
		escola.setInternet(getBoolean(rs.getString("SE_INTERNET")));

		escola.setNumFuncionarios(ConversorDeEntrada
				.getNumeroInteiroSemPonto(rs.getString("NUM_FUNCIONARIOS")));
		escola.setNumComputadoresAlunos(ConversorDeEntrada
				.getNumeroInteiroSemPonto(rs
						.getString("NUM_COMPUTADORES_ALUNOS")));
		escola.setNumComputadoresAdministracao(ConversorDeEntrada
				.getNumeroInteiroSemPonto(rs
						.getString("NUM_COMPUTADORES_ADMINISTRACAO")));
		escola.setNumComputadoresTotal(ConversorDeEntrada
				.getNumeroInteiroSemPonto(rs
						.getString("NUM_COMPUTADORES_TOTAL")));

		escola.setNumMatriculas(ConversorDeEntrada.getNumeroInteiroSemPonto(rs
				.getString("NUM_MATRICULAS")));

		escola.setEducacaoIndigena(getBoolean(rs
				.getString("SE_EDUCACAO_INDIGNA")));
		escola.setLinguaIndigena(getBoolean(rs.getString("SE_LINGUA_INDIGENA")));
		escola.setBrasilAlfabetizacao(getBoolean(rs
				.getString("SE_BRASIL_ALFABETIZACAO")));
		escola.setAberturaFdsComun(getBoolean(rs
				.getString("SE_ABERTURA_FDS_COMUN")));

		return escola;
	}

	private Date getData(ResultSet rs, String nome_campo) throws SQLException,
			ParseException {
		Date data = null;
		if (rs.getString(nome_campo) != null) {
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			data = new Date(dateFormat.parse(rs.getString(nome_campo))
					.getTime());
		}
		return data;
	}

	private boolean getBoolean(String texto) {
		if (texto == null) {
			return false;
		} else
			return texto.equalsIgnoreCase("sim");
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
