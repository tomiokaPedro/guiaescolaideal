package br.com.mdsgpp.guiaescolaideal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.mdsgpp.guiaescolaideal.exceptions.ConsultaBancoRetornoVazioException;
import br.com.mdsgpp.guiaescolaideal.model.Endereco;
import br.com.mdsgpp.guiaescolaideal.model.Escola;
import br.com.mdsgpp.guiaescolaideal.model.Telefone;
import br.com.mdsgpp.guiaescolaideal.util.ConversorDeEntrada;
import br.com.mdsgpp.guiaescolaideal.util.Util;

public class EscolaDAO {

    private final static String TAMANHO_PESQUISA = "TAMANHO_PESQUISA";

    private Connection connection;

    public EscolaDAO(Connection connection) {
	this.connection = connection;
    }

    public Escola pesquisarPorID(int id) throws SQLException, ParseException,
	    ConsultaBancoRetornoVazioException {
	String sql = "select * from escola where COD_ESCOLA= ?";

	PreparedStatement stmt = this.connection.prepareStatement(sql);
	stmt.setInt(1, id);

	ResultSet rs = stmt.executeQuery();
	Escola escola = null;
	if (rs.next()) {
	    escola = getEscolaAll(rs);
	} else {
	    stmt.close();
	    throw new ConsultaBancoRetornoVazioException(
		    "Nenhuma escola com o id= " + id + " foi encontrada.");
	}

	stmt.close();
	return escola;
    }

    public List<Escola> pesquisaPorCampos(List<Campo> campos)
	    throws SQLException, ConsultaBancoRetornoVazioException {
	StringBuilder sb = new StringBuilder();

	gerarQuerySQL(sb);
	addCondicaoAQuery(campos, sb);

	PreparedStatement stmt = this.connection
		.prepareStatement(sb.toString());

	addValoresAQuery(campos, stmt);

	ResultSet rs = stmt.executeQuery();
	List<Escola> listaEscola = getListaEscola(rs);
	stmt.close();

	verificarSeListaEstaVazia(listaEscola);

	return listaEscola;
    }

    private void addValoresAQuery(List<Campo> campos, PreparedStatement stmt)
	    throws SQLException {
	for (int i = 0; i < campos.size(); i++) {
	    stmt.setString(i + 1, "%" + campos.get(i).getValor() + "%");
	}
    }

    private void addCondicaoAQuery(List<Campo> campos, StringBuilder sb) {
	for (Campo campo : campos) {
	    sb.append("AND " + campo.getTabela() + "." + campo.getNome()
		    + " like ? ");
	}
    }

    private void gerarQuerySQL(StringBuilder sb) {
	sb.append("select * from escola ");
	sb.append("INNER JOIN endereco ON escola.COD_ENDERECO = endereco.COD_ENDERECO ");
	sb.append("INNER JOIN municipio  ON municipio.COD_MUNICIPIO = endereco.COD_MUNICIPIO ");
	sb.append("INNER JOIN uf uf ON uf.COD_UF = municipio.COD_UF ");
	sb.append("INNER JOIN modalidade_escola_escola ON modalidade_escola_escola.COD_ESCOLA = escola.COD_ESCOLA ");
	sb.append("INNER JOIN modalidade_ensino ON modalidade_ensino.COD_MODALIDADE_ENSINO = modalidade_escola_escola.COD_MODALIDADE_ENSINO ");
    }

    public List<Escola> pesquisarEscolaPorCep(String cep) throws SQLException,
	    ConsultaBancoRetornoVazioException {

	String prefixoCep = cep.substring(0, 5) + "%";

	String sql = "select * from escola INNER JOIN endereco ON endereco.COD_ENDERECO = escola.COD_ENDERECO AND endereco.CEP like ?";

	PreparedStatement stmt = this.connection.prepareStatement(sql);
	stmt.setString(1, prefixoCep);

	ResultSet rs = stmt.executeQuery();
	List<Escola> listaEscola = getListaEscola(rs);
	stmt.close();

	verificarSeListaEstaVazia(listaEscola);

	return listaEscola;
    }

    private void verificarSeListaEstaVazia(List<Escola> listaEscola)
	    throws ConsultaBancoRetornoVazioException {
	if (listaEscola.isEmpty()) {
	    throw new ConsultaBancoRetornoVazioException(
		    "Consulta não retornou nenhuma escola com esses atributos.");
	}
    }

    private List<Escola> getListaEscola(ResultSet rs) throws SQLException {
	List<Escola> listaEscola = new ArrayList<Escola>();

	while (rs.next()) {
	    Escola escola = getEscolaDefault(rs);
	    listaEscola.add(escola);
	}

	return listaEscola;
    }

    public List<Escola> pesquisarPorNome(String nome, int comeco, int quantidade)
	    throws SQLException, ParseException {

	if (!Util.textoTemConteudo(nome)) {
	    throw new IllegalArgumentException();
	}

	return pesquisarPorNomeComPalavrasChaves(Arrays.asList(nome), comeco,
		quantidade);
    }

    public List<Escola> pesquisarPorNomeComPalavrasChaves(
	    List<String> listaPalavras, int comeco, int quantidade)
	    throws SQLException, ParseException {

	if ((comeco < 0) || (quantidade <= 0)) {
	    throw new IllegalArgumentException();
	}

	String sql = gerarQuerySqlComPesquisaPorPalavras(listaPalavras);
	sql = sql + addLimit();
	PreparedStatement stmt = this.connection.prepareStatement(sql);

	int sizeLista = listaPalavras.size();

	for (int i = 1; i <= sizeLista; i++) {
	    stmt.setString(i, "%" + listaPalavras.get(i - 1) + "%");
	}

	stmt.setInt(sizeLista + 1, comeco);
	stmt.setInt(sizeLista + 2, quantidade);

	ResultSet rs = stmt.executeQuery();
	List<Escola> listaEscola = getListaEscola(rs);
	stmt.close();

	return listaEscola;
    }

    public int pesquisarPorNomeMaisLocalizacaoQuantidadeResultados(
	    List<String> listaPalavras, String estado,
	    List<String> listaPalavrasMunicipio) throws SQLException {
	String retorno = "count(*) as " + TAMANHO_PESQUISA;
	String sql = gerarQuerySQLNomeMaisLocalizao(retorno, listaPalavras,
		listaPalavrasMunicipio);

	PreparedStatement stmt = getStmtConfig(listaPalavras, estado,
		listaPalavrasMunicipio, sql);

	ResultSet rs = stmt.executeQuery();

	int valor = 0;
	if (rs.next()) {
	    valor = rs.getInt(TAMANHO_PESQUISA);
	}

	return valor;
    }

    private PreparedStatement getStmtConfig(List<String> listaPalavras,
	    String estado, List<String> listaPalavrasMunicipio, String sql)
	    throws SQLException {
	PreparedStatement stmt = this.connection.prepareStatement(sql);

	int sizeLista = listaPalavras.size();

	for (int i = 1; i <= sizeLista; i++) {
	    stmt.setString(i, "%" + listaPalavras.get(i - 1) + "%");
	}

	int sizeListaMunicipio = listaPalavrasMunicipio.size();

	for (int i = 0, p = sizeLista + 1; i < sizeListaMunicipio; i++, p++) {
	    stmt.setString(p, "%" + listaPalavrasMunicipio.get(i) + "%");
	}

	int posicaoEstado = sizeLista + sizeListaMunicipio + 1;
	stmt.setString(posicaoEstado, estado);
	return stmt;
    }

    public List<Escola> pesquisarPorNomeMaisLocalizacao(
	    List<String> listaPalavras, String estado,
	    List<String> listaPalavrasMunicipio) throws SQLException,
	    ParseException, ConsultaBancoRetornoVazioException {

	String sql = gerarQuerySQLNomeMaisLocalizao("*", listaPalavras,
		listaPalavrasMunicipio);

	PreparedStatement stmt = getStmtConfig(listaPalavras, estado,
		listaPalavrasMunicipio, sql);

	ResultSet rs = stmt.executeQuery();
	List<Escola> listaEscola = getListaEscola(rs);
	stmt.close();

	verificarSeListaEstaVazia(listaEscola);

	return listaEscola;
    }

    private String gerarQuerySQLNomeMaisLocalizao(String retorno,
	    List<String> listaPalavras, List<String> palavrasMunicipio) {
	StringBuilder sb = new StringBuilder();
	sb.append("select ");
	sb.append(retorno);
	sb.append(" from escola esc ");
	sb.append("INNER JOIN endereco en ON esc.COD_ENDERECO = en.COD_ENDERECO AND ");
	sb.append(addListaNome("esc.NOME_ESCOLA", listaPalavras));
	sb.append("INNER JOIN municipio mun ON mun.COD_MUNICIPIO = en.COD_MUNICIPIO ");

	if (palavrasMunicipio.size() != 0) {
	    sb.append("AND ");
	    sb.append(addListaNome("mun.DESCRICAO", palavrasMunicipio));
	}

	sb.append("INNER JOIN uf uf ON uf.COD_UF = mun.COD_UF and uf.DESCRICAO = ? ");
	return sb.toString();
    }

    private String gerarQuerySqlComPesquisaPorPalavras(
	    List<String> listaPalavras) {
	StringBuilder builder = new StringBuilder();
	builder.append("select * from escola where ");
	builder.append(addListaNome("NOME_ESCOLA", listaPalavras));

	return builder.toString();
    }

    private String addListaNome(String nomeCampo, List<String> listaPalavras) {
	StringBuilder builder = new StringBuilder();

	int sizeLista = listaPalavras.size();

	for (int i = 0; i < sizeLista; i++) {
	    builder.append("( " + nomeCampo + " like ?) ");

	    if (i != (sizeLista - 1)) {
		builder.append("AND ");
	    }
	}

	return builder.toString();
    }

    private String addLimit() {
	return " LIMIT ?, ?";
    }

    private Escola getEscolaAll(ResultSet rs) throws SQLException,
	    ParseException {
	Escola escola = getEscolaDefault(rs);

	escola.setTipoLocalizacao(rs.getString("TIPO_LOCALIZACAO"));
	escola.setSistemaSenai(rs.getString("SE_SISTEMA_SENAI")
		.equalsIgnoreCase("sim"));
	escola.setOng(ConversorDeEntrada.getValorBooleanDoTexto(rs
		.getString("SE_ONG")));

	escola.setDataInicioLetivo(ConversorDeEntrada.getData(rs
		.getString("DATA_INICIO_LETIVO")));
	escola.setDataTerminoLetivo(ConversorDeEntrada.getData(rs
		.getString("DATA_TERMINO_LETIVO")));

	escola.setSeFinsLucrativos(ConversorDeEntrada.getValorBooleanDoTexto(rs
		.getString("SE_FINS_LURATIVOS")));
	escola.setAtividadeComplementar(rs.getString("ATIVIDADE_COMPLEMENTAR"));
	escola.setAcessibilidade(ConversorDeEntrada.getValorBooleanDoTexto(rs
		.getString("SE_ACESSIBILIDADE")));
	escola.setDependViasAcesso(ConversorDeEntrada.getValorBooleanDoTexto(rs
		.getString("SE_DEPEN_VIAS_ACES")));
	escola.setSantiAcess(ConversorDeEntrada.getValorBooleanDoTexto(rs
		.getString("SE_SANTI_ACESS")));
	escola.setAtendEducacionalEspecializado(rs.getString("SE_AEE"));
	escola.setSalaDiretoria(ConversorDeEntrada.getValorBooleanDoTexto(rs
		.getString("SE_SALA_DIRETORIA")));
	escola.setSalaProfessor(ConversorDeEntrada.getValorBooleanDoTexto(rs
		.getString("SE_SALA_PROFESSOR")));
	escola.setSecretaria(ConversorDeEntrada.getValorBooleanDoTexto(rs
		.getString("SE_SECRETARIA")));
	escola.setRefeitorio(ConversorDeEntrada.getValorBooleanDoTexto(rs
		.getString("SE_REFEITORIO")));
	escola.setDespensa(rs.getString("SE_DESPENSA").equalsIgnoreCase("sim"));

	escola.setAlmoxarifado(ConversorDeEntrada.getValorBooleanDoTexto(rs
		.getString("SE_ALMOXARIFADO")));
	escola.setAuditorio(ConversorDeEntrada.getValorBooleanDoTexto(rs
		.getString("SE_AUDITORIO")));
	escola.setLabInformatica(ConversorDeEntrada.getValorBooleanDoTexto(rs
		.getString("SE_LAB_INFO")));
	escola.setLabCiencias(ConversorDeEntrada.getValorBooleanDoTexto(rs
		.getString("SE_LAB_CIENCIAS")));
	escola.setSalaAtendimentoEspecializado(ConversorDeEntrada
		.getValorBooleanDoTexto(rs.getString("SE_SALA_ATEND_ESP")));
	escola.setQuadraEsporteCoberta(ConversorDeEntrada
		.getValorBooleanDoTexto(rs.getString("SE_QUADRA_ESPO_COBERTA")));
	escola.setQuadraEsporteDescoberta(ConversorDeEntrada
		.getValorBooleanDoTexto(rs
			.getString("SE_QUADRA_ESPO_DESCOBERTA")));
	escola.setPatioCoberto(ConversorDeEntrada.getValorBooleanDoTexto(rs
		.getString("SE_PATIO_COBERTO")));
	escola.setPatioDescoberto(ConversorDeEntrada.getValorBooleanDoTexto(rs
		.getString("SE_PATIO_DESCOBERTO")));
	escola.setParqueInfantil(ConversorDeEntrada.getValorBooleanDoTexto(rs
		.getString("SE_PARQUE_INFANTIL")));
	escola.setCozinha(ConversorDeEntrada.getValorBooleanDoTexto(rs
		.getString("SE_COZINHA")));
	escola.setBiblioteca(ConversorDeEntrada.getValorBooleanDoTexto(rs
		.getString("SE_BIBLIOTECA")));
	escola.setBercario(ConversorDeEntrada.getValorBooleanDoTexto(rs
		.getString("SE_BERCARIO")));
	escola.setSanitarioNoPredio(ConversorDeEntrada
		.getValorBooleanDoTexto(rs.getString("SE_SANITARIO_NO_PREDIO")));
	escola.setSanitarioForaPredio(ConversorDeEntrada
		.getValorBooleanDoTexto(rs
			.getString("SE_SANITARIO_FORA_PREDIO")));
	escola.setSanitarioAdequadoInfantil(ConversorDeEntrada
		.getValorBooleanDoTexto(rs
			.getString("SE_SANITARIO_EDUC_ADEQ_INFAN")));
	escola.setBanheiroChuveiro(ConversorDeEntrada.getValorBooleanDoTexto(rs
		.getString("SE_BANHEIRO_CHUVEIRO")));
	escola.setLavanderia(ConversorDeEntrada.getValorBooleanDoTexto(rs
		.getString("SE_LAVANDERIA")));
	escola.setOutrasDependencias(ConversorDeEntrada
		.getValorBooleanDoTexto(rs.getString("SE_OUTRAS_DEPENDENCIAS")));

	escola.setNumSalaExistentes(ConversorDeEntrada
		.getNumeroInteiroSemPonto(rs.getString("NUM_SALAS_EXISTENTES")));
	escola.setNumSalaUtilizadas(ConversorDeEntrada
		.getNumeroInteiroSemPonto(rs.getString("NUM_SALAS_UTILIZADAS")));

	escola.setSalaLeitura(ConversorDeEntrada.getValorBooleanDoTexto(rs
		.getString("SE_SALA_LEITURA")));
	escola.setAlojamentoAluno(ConversorDeEntrada.getValorBooleanDoTexto(rs
		.getString("SE_ALOJAMENTO_ALUNO")));
	escola.setAlojamentoProfessor(ConversorDeEntrada
		.getValorBooleanDoTexto(rs.getString("SE_ALOJAMENTO_PROFESSOR")));
	escola.setAreaVerde(ConversorDeEntrada.getValorBooleanDoTexto(rs
		.getString("SE_AREA_VERDE")));

	escola.setAlimentacaoEscAlunos(ConversorDeEntrada
		.getValorBooleanDoTexto(rs
			.getString("SE_ALIMENTACAO_ESC_ALUNOS")));

	String seAguaFiltrada = rs.getString("SE_AGUA_FILTRADA");
	if ("Filtrada".equalsIgnoreCase(seAguaFiltrada)) {
	    seAguaFiltrada = "sim";
	}

	escola.setAguaFiltrada(ConversorDeEntrada
		.getValorBooleanDoTexto(seAguaFiltrada));

	escola.setInternet(ConversorDeEntrada.getValorBooleanDoTexto(rs
		.getString("SE_INTERNET")));

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

	escola.setEducacaoIndigena(ConversorDeEntrada.getValorBooleanDoTexto(rs
		.getString("SE_EDUCACAO_INDIGNA")));
	escola.setLinguaIndigena(ConversorDeEntrada.getValorBooleanDoTexto(rs
		.getString("SE_LINGUA_INDIGENA")));
	escola.setBrasilAlfabetizacao(ConversorDeEntrada
		.getValorBooleanDoTexto(rs.getString("SE_BRASIL_ALFABETIZACAO")));
	escola.setAberturaFdsComun(ConversorDeEntrada.getValorBooleanDoTexto(rs
		.getString("SE_ABERTURA_FDS_COMUN")));

	return escola;
    }

    private Escola getEscolaDefault(ResultSet rs) throws SQLException {
	Escola escola = new Escola();

	escola.setCodEscola(rs.getInt("COD_ESCOLA"));
	escola.setNomeEscola(rs.getString("NOME_ESCOLA"));
	escola.setCodicaoFuncionamento(rs.getString("CONDICAO_FUNCIONAMENTO"));
	escola.setEmail(rs.getString("EMAIL"));

	Endereco endereco = null;

	EnderecoDAO enderecoDAO = new EnderecoDAO(connection);
	endereco = enderecoDAO.pesquisarPorID(ConversorDeEntrada
		.getNumeroInteiroSemPonto(rs.getString("COD_ENDERECO")));
	escola.setEndereco(endereco);

	Telefone telefone = null;

	TelefoneDAO telefoneDAO = new TelefoneDAO(connection);
	telefone = telefoneDAO.pesquisarPorIDEscola(escola.getCodEscola());
	if (telefone != null) {
	    telefone.setMunicipio(endereco.getMunicipio());
	}
	escola.setTelefone(telefone);

	return escola;
    }
}
