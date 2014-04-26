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
    public void testGetCategoriaEscola() 
    {
	CategoriaEscola categoria = new CategoriaEscola(true);
	this.escola.setCategoriaEscola(categoria);
	
	assertTrue(this.escola.getCategoriaEscola().equals(categoria));
    }

    @Test
    public void testSetCategoriaEscola() 
    {
	
    }

    @Test
    public void testGetNomeEscola() 
    {
	
	this.escola.setNomeEscola("Escola das Nacoes");
	
	assertTrue(this.escola.getNomeEscola().equals("Escola das Nacoes"));
	
    }

    @Test
    public void testSetNomeEscola() {
	fail("Not yet implemented");
    }

    @Test
    public void testGetCodigoRede() 
    {
	int codigoRede = 628213;
	this.escola.setCodigoRede(codigoRede);
	
	assertEquals(this.escola.getCodigoRede(),codigoRede);
    }

    @Test
    public void testSetCodigoRede() {
	fail("Not yet implemented");
    }

    @Test
    public void testGetTipoLocalizacao() {
	this.escola.setTipoLocalizacao("STRING");
	
	assertTrue(this.escola.getTipoLocalizacao().equals("STRING"));
    }

    @Test
    public void testSetTipoLocalizacao() {
	fail("Not yet implemented");
    }

    @Test
    public void testGetCodigoendereco() 
    {
	int codigoendereco = 34567;
	this.escola.setCodigoendereco(codigoendereco);
	
	assertEquals(this.escola.getCodigoendereco(),codigoendereco);
    }

    @Test
    public void testSetCodigoendereco() {
	fail("Not yet implemented");
    }

    @Test
    public void testGetCodicaoFuncionamento() {
	this.escola.setCodicaoFuncionamento("STRING");
	
	assertTrue(this.escola.getCodicaoFuncionamento().equals("STRING"));
    }

    @Test
    public void testSetCodicaoFuncionamento() {
	fail("Not yet implemented");
    }

    @Test
    public void testGetEmail() {
	this.escola.setEmail("felipeta@gov.br");
	
	assertTrue(this.escola.getEmail().equals("felipeta@gov.br"));
    }

    @Test
    public void testSetEmail() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsSistemaSenai() {
	this.escola.setSistemaSenai(true);
	
	assertEquals(this.escola.isSistemaSenai());
	
    }

    @Test
    public void testSetSistemaSenai() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsOng() {
	
	this.escola.setOng(true);
	
	assertEquals(this.escola.isOng(),true);
    }

    @Test
    public void testSetOng() {
	fail("Not yet implemented");
    }

    @Test
    public void testGetDataInicioLetivo() {
	
	Date dataDeInicio = new Date(25);
	this.escola.setDataInicioLetivo(dataDeInicio);
	
	assertTrue(this.escola.getDataInicioLetivo().equals(dataDeInicio));
    }

    @Test
    public void testSetDataInicioLetivo() {
	fail("Not yet implemented");
    }

    @Test
    public void testGetDataTerminoLetivo() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetDataTerminoLetivo() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsSeFinsLucrativos() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetSeFinsLucrativos() {
	fail("Not yet implemented");
    }

    @Test
    public void testGetAtividadeComplementar() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetAtividadeComplementar() {
	fail("Not yet implemented");
    }

    @Test
    public void testGetCodLocalFuncionamento() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetCodLocalFuncionamento() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsAcessibilidade() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetAcessibilidade() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsDependViasAcesso() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetDependViasAcesso() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsSantiAcess() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetSantiAcess() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsAtendEducacionalEspecializado() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetAtendEducacionalEspecializado() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsSalaDiretoria() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetSalaDiretoria() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsSalaProfessor() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetSalaProfessor() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsRefeitorio() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetRefeitorio() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsDespensa() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetDespensa() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsAlmoxarifado() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetAlmoxarifado() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsAuditorio() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetAuditorio() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsLabInformatica() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetLabInformatica() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsLabCiencias() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetLabCiencias() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsSalaAtendimentoEspecializado() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetSalaAtendimentoEspecializado() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsQuadraEsporteCoberta() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetQuadraEsporteCoberta() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsQuadraEsporteDescoberta() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetQuadraEsporteDescoberta() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsPatioCoberto() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetPatioCoberto() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsPatioDescoberto() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetPatioDescoberto() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsParqueInfantil() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetParqueInfantil() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsCozinha() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetCozinha() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsBiblioteca() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetBiblioteca() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsBercario() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetBercario() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsSanitarioNoPredio() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetSanitarioNoPredio() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsSanitarioForaPredio() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetSanitarioForaPredio() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsSanitarioAdequadoInfantil() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetSanitarioAdequadoInfantil() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsBanheiroChuveiro() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetBanheiroChuveiro() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsLavanderia() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetLavanderia() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsOutrasDependencias() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetOutrasDependencias() {
	fail("Not yet implemented");
    }

    @Test
    public void testGetNumSalaExistentes() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetNumSalaExistentes() {
	fail("Not yet implemented");
    }

    @Test
    public void testGetNumSalaUtilizadas() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetNumSalaUtilizadas() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsSalaLeitura() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetSalaLeitura() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsAlojamentoAluno() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetAlojamentoAluno() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsAlojamentoProfessor() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetAlojamentoProfessor() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsAreaVerde() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetAreaVerde() {
	fail("Not yet implemented");
    }

    @Test
    public void testGetNumFuncionarios() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetNumFuncionarios() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsAlimentacaoEscAlunos() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetAlimentacaoEscAlunos() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsAguaFiltrada() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetAguaFiltrada() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsInternet() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetInternet() {
	fail("Not yet implemented");
    }

    @Test
    public void testGetNumComputadoresAlunos() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetNumComputadoresAlunos() {
	fail("Not yet implemented");
    }

    @Test
    public void testGetNumComputadoresAdministracao() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetNumComputadoresAdministracao() {
	fail("Not yet implemented");
    }

    @Test
    public void testGetNumComputadoresTotal() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetNumComputadoresTotal() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsEducacaoIndigena() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetEducacaoIndigena() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsLinguaIndigena() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetLinguaIndigena() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsBrasilAlfabetizacao() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetBrasilAlfabetizacao() {
	fail("Not yet implemented");
    }

    @Test
    public void testIsAberturaFdsComun() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetAberturaFdsComun() {
	fail("Not yet implemented");
    }

    @Test
    public void testGetNumMatriculas() {
	fail("Not yet implemented");
    }

    @Test
    public void testSetNumMatriculas() {
	fail("Not yet implemented");
    }

}
