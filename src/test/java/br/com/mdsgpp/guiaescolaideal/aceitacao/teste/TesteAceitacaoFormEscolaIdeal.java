package br.com.mdsgpp.guiaescolaideal.aceitacao.teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteAceitacaoFormEscolaIdeal {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
	driver = new FirefoxDriver();
	driver.get("http://localhost:8765/GuiaEscolaIdeal/pesquisarEscolaIdeal.jsp");
    }

    @Test
    public void testeCasoPerfeito() {
	String linkPag = driver.getCurrentUrl();

	selecionaModalidade();
	selecionaEstado();
	selecionaLabInfo();
	selecionaLabCiencias();
	submit();

	String linkPagAtual = driver.getCurrentUrl();
	
	assertTrue(!linkPag.equalsIgnoreCase(linkPagAtual));
	assertTrue(driver.getPageSource().contains("Bairro"));
    }

    @Test
    public void testeSemInserirEstado() {
	selecionaModalidade();
	submit();

	String texto = getAlertText();
	assertTrue(texto.equals("Selecione um estado"));
    }

    @Test
    public void testeMunicipioComCaracteresInvalidos() {
	selecionaModalidade();
	selecionaEstado();
	selecionaLabInfo();
	selecionaLabCiencias();

	WebElement municipio = driver.findElement(By.name("municipio"));
	municipio.sendKeys("$%$จ&%จจจ&%");
	submit();

	String texto = getAlertText();
	assertTrue(texto != null && !texto.isEmpty());
    }

    private String getAlertText() {
	String texto = driver.switchTo().alert().getText();
	driver.switchTo().alert().accept();
	return texto;
    }

    @Test
    public void testeNaoEncontrarEscola() {
	selecionaModalidade();
	selecionaEstado();
	selecionaLabInfo();

	WebElement municipio = driver.findElement(By.name("municipio"));
	municipio.sendKeys("Java");

	selecionaLabCiencias();
	submit();

	assertTrue(driver.getPageSource().contains(
		"Consulta nใo retornou nenhuma escola com esses atributos."));
    }

    @Test
    public void testeModalidadeVazia() {
	selecionaEstado();
	selecionaLabInfo();
	selecionaLabCiencias();
	submit();

	String texto = getAlertText();
	assertTrue(texto.equalsIgnoreCase("Selecione uma modalidade"));
    }

    @After
    public void close() {
	driver.close();
    }
    
    private void submit() {
	WebElement submit = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
	submit.click();
    }

    private void selecionaLabCiencias() {
	WebElement radioLabCiencia = driver.findElement(By.name("labcien"));
	radioLabCiencia.click();
    }

    private void selecionaLabInfo() {
	WebElement radioLabInfo = driver.findElement(By.name("labinf"));
	radioLabInfo.click();
    }

    private void selecionaEstado() {
	Select listaEstado = new Select(driver.findElement(By.name("estado")));
	listaEstado.selectByVisibleText("Distrito Federal");
    }

    private void selecionaModalidade() {
	Select listaModalidade = new Select(driver.findElement(By
		.name("modalidade")));
	listaModalidade.selectByVisibleText("Ensino Regular");
    }

}
