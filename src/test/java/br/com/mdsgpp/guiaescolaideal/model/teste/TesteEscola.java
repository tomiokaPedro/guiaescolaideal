package br.com.mdsgpp.guiaescolaideal.model.teste;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.mdsgpp.guiaescolaideal.model.CategoriaEscola;
import br.com.mdsgpp.guiaescolaideal.model.Escola;

public class TesteEscola {
    
    private Escola escola = new Escola();

    @Before
    public void setUp() throws Exception 
    {
	
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetSetCategoriaEscola() 
    {
	CategoriaEscola categoria = new CategoriaEscola(true);
	this.escola.setCategoriaEscola(categoria);
	
	assertTrue(this.escola.getCategoriaEscola().equals(categoria));
    }


    @Test
    public void testGetSetNomeEscola() 
    {
	
	this.escola.setNomeEscola("Escola das Nacoes");
	
	assertTrue(this.escola.getNomeEscola().equals("Escola das Nacoes"));
	
    }


    @Test
    public void testGetSetCodigoRede() 
    {
	int codigoRede = 628213;
	this.escola.setCodigoRede(codigoRede);
	
	assertTrue(this.escola.getCodigoRede() == codigoRede);
	assertEquals(this.escola.getCodigoRede(),codigoRede);
    }


    @Test
    public void testGetTipoLocalizacao() {
	this.escola.setTipoLocalizacao("STRING");
	
	assertTrue(this.escola.getTipoLocalizacao().equals("STRING"));
    }


    @Test
    public void testGetCodigoendereco() 
    {
	int codigoendereco = 34567;
	this.escola.setCodigoendereco(codigoendereco);
	
	assertEquals(this.escola.getCodigoendereco(),codigoendereco);
    }


    @Test
    public void testGetSetCodicaoFuncionamento() {
	this.escola.setCodicaoFuncionamento("STRING");
	
	assertTrue(this.escola.getCodicaoFuncionamento().equals("STRING"));
    }


    @Test
    public void testGetSetEmail() {
	this.escola.setEmail("felipeta@gov.br");
	
	assertTrue(this.escola.getEmail().equals("felipeta@gov.br"));
    }


    @Test
    public void testIsSistemaSenai() {
	this.escola.setSistemaSenai(true);
	
	assertEquals(this.escola.isSistemaSenai(),true);
	
    }


    @Test
    public void testIsOng() {
	
	this.escola.setOng(true);
	
	assertEquals(this.escola.isOng(),true);
    }


    @Test
    public void testGetSetDataInicioLetivo() {
	
	Date dataDeInicio = new Date(25);
	this.escola.setDataInicioLetivo(dataDeInicio);
	
	assertTrue(this.escola.getDataInicioLetivo().equals(dataDeInicio));
    }


    @Test
    public void testGetSetDataTerminoLetivo() {
	Date dataDeInicio = new Date(25);
	this.escola.setDataInicioLetivo(dataDeInicio);
	
	assertTrue(this.escola.getDataInicioLetivo().equals(dataDeInicio));
    }


    @Test
    public void testIsSeFinsLucrativos() {
	
	this.escola.setSeFinsLucrativos(true);
	
	assertEquals(this.escola.isSeFinsLucrativos(),true);
	
    }


    @Test
    public void testGetSetAtividadeComplementar() {
	
	this.escola.setAtividadeComplementar("STRING");
	
	assertTrue(this.escola.getAtividadeComplementar().equals("STRING"));
    }


    @Test
    public void testGetCodLocalFuncionamento() {
	
	int codigo = 100;
	this.escola.setCodLocalFuncionamento(codigo);
	
	assertEquals(this.escola.getCodLocalFuncionamento(),codigo);
    }


    @Test
    public void testIsAcessibilidade() {
	this.escola.setAcessibilidade(true);
	
	assertEquals(this.escola.isAcessibilidade(),true);
    }

 

    @Test
    public void testIsDependViasAcesso() {
	this.escola.setDependViasAcesso(true);
	
	assertEquals(this.escola.isDependViasAcesso(),true);
    }

    

    @Test
    public void testIsSantiAcess() {
	fail("Not yet implemented");
    }


    @Test
    public void testIsAtendEducacionalEspecializado() {
	
    }


    @Test
    public void testIsSalaDiretoria() {
	this.escola.setSalaDiretoria(true);
	
	assertEquals(this.escola.isSalaDiretoria(),true);
    }


    @Test
    public void testIsSalaProfessor() {
	this.escola.setSalaProfessor(true);
	
	assertEquals(this.escola.isSalaProfessor(),true);
    }


    @Test
    public void testIsRefeitorio() {
	this.escola.setRefeitorio(true);
	
	assertEquals(this.escola.isRefeitorio(),true);
    }

    @Test
    public void testIsDespensa() {
	
	this.escola.setDespensa(true);
	
	assertEquals(this.escola.isDespensa(),true);
    }

    @Test
    public void testIsAlmoxarifado() {
	this.escola.setAlmoxarifado(true);
	
	assertEquals(this.escola.isAlmoxarifado(),true);
    }

   
    @Test
    public void testIsAuditorio() {
	
	this.escola.setAuditorio(true);
	
	assertEquals(this.escola.isAuditorio(),true);
    }

    

    @Test
    public void testIsLabInformatica() {
	
	this.escola.setLabInformatica(true);
	
	assertEquals(this.escola.isLabInformatica(),true);
    }

    @Test
    public void testIsLabCiencias() {
	this.escola.setLabCiencias(true);
	
	assertEquals(this.escola.isLabCiencias(),true);
    }

    @Test
    public void testIsSalaAtendimentoEspecializado() {
	
	this.escola.setSalaAtendimentoEspecializado(true);
	
	assertEquals(this.escola.isSalaAtendimentoEspecializado(),true);
    }
    
    @Test
    public void testIsQuadraEsporteCoberta() {

	this.escola.setQuadraEsporteCoberta(false);
	
	assertEquals(this.escola.isQuadraEsporteCoberta(),false);
    }

    @Test
    public void testIsQuadraEsporteDescoberta() {

	this.escola.setQuadraEsporteDescoberta(true);
	
	assertEquals(this.escola.isQuadraEsporteDescoberta(),true);
    }


    @Test
    public void testIsPatioCoberto() 
    {
	this.escola.setPatioCoberto(true);
	
	assertTrue(this.escola.isPatioCoberto() == true);

    }

   

    @Test
    public void testIsPatioDescoberto() {
	this.escola.setPatioDescoberto(true);
	
	assertTrue(this.escola.isPatioDescoberto() == true);
    }


    @Test
    public void testIsParqueInfantil() {
	this.escola.setParqueInfantil(true);
	
	assertTrue(this.escola.isParqueInfantil() == true);
    }

    @Test
    public void testIsCozinha() {
	this.escola.setCozinha(true);
	
	assertTrue(this.escola.isCozinha() == true);
    }

    @Test
    public void testIsBiblioteca() {
	this.escola.setBiblioteca(true);
	
	assertTrue(this.escola.isBiblioteca() ==  true);
    }


    @Test
    public void testIsBercario() 
    {
	this.escola.setBercario(true);
	
	assertTrue(this.escola.isBercario() == true);
    }


    @Test
    public void testIsSanitarioNoPredio() {
	this.escola.setSanitarioNoPredio(true);
	
	assertTrue(this.escola.isSanitarioNoPredio() == true);
    }


    @Test
    public void testIsSanitarioForaPredio() {

	this.escola.setSanitarioForaPredio(true);
	
	assertTrue(this.escola.isSanitarioForaPredio() == true);
    }


    @Test
    public void testIsSanitarioAdequadoInfantil() {
	this.escola.setSanitarioAdequadoInfantil(false);
	
	assertTrue(this.escola.isSanitarioAdequadoInfantil()== true);
    }


    @Test
    public void testIsBanheiroChuveiro() {
	this.escola.setBanheiroChuveiro(true);
	
	assertTrue(this.escola.isBanheiroChuveiro()==true);
    }


    @Test
    public void testIsLavanderia() {
	this.escola.setLavanderia(true);
	
	assertTrue(this.escola.isLavanderia()==true);
    }


    @Test
    public void testIsOutrasDependencias() {
	this.escola.setOutrasDependencias(true);
	
	assertTrue(this.escola.isLavanderia()==true);
    }


    @Test
    public void testGetNumSalaExistentes() {
	fail("Not yet implemented");
    }

    @Test
    public void testGetNumSalaUtilizadas() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsSalaLeitura() {
	fail("Not yet implemented");
    }


    @Test
    public void testIsAlojamentoAluno() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsAlojamentoProfessor() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsAreaVerde() {
	fail("Not yet implemented");
    }

    @Test
    public void testGetNumFuncionarios() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsAlimentacaoEscAlunos() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsAguaFiltrada() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsInternet() {
	fail("Not yet implemented");
    }

    @Test
    public void testGetNumComputadoresAlunos() {
	fail("Not yet implemented");
    }

    @Test
    public void testGetNumComputadoresAdministracao() {
	fail("Not yet implemented");
    }


    @Test
    public void testGetNumComputadoresTotal() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsEducacaoIndigena() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsLinguaIndigena() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsBrasilAlfabetizacao() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsAberturaFdsComun() {
	fail("Not yet implemented");
    }

    @Test
    public void testGetNumMatriculas() {
	fail("Not yet implemented");
    }

}
