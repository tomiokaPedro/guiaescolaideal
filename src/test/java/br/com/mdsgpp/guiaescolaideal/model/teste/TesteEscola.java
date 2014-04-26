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
    public void testIsPatioCoberto() {
	fail("Not yet implemented");
    }

   

    @Test
    public void testIsPatioDescoberto() {
	fail("Not yet implemented");
    }


    @Test
    public void testIsParqueInfantil() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsCozinha() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsBiblioteca() {
	fail("Not yet implemented");
    }


    @Test
    public void testIsBercario() {
	fail("Not yet implemented");
    }


    @Test
    public void testIsSanitarioNoPredio() {
	fail("Not yet implemented");
    }


    @Test
    public void testIsSanitarioForaPredio() {
	fail("Not yet implemented");
    }


    @Test
    public void testIsSanitarioAdequadoInfantil() {
	fail("Not yet implemented");
    }


    @Test
    public void testIsBanheiroChuveiro() {
	fail("Not yet implemented");
    }


    @Test
    public void testIsLavanderia() {
	fail("Not yet implemented");
    }


    @Test
    public void testIsOutrasDependencias() {
	fail("Not yet implemented");
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
