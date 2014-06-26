package br.com.mdsgpp.guiaescolaideal;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class TesteAceitacaoFormEscolaIdeal {

    private WebDriver driver;
    private String baseUrl = "http://localhost:8765";
    @Before
	public void setUp() throws Exception {
		// You may use any WebDriver implementation. Firefox is used here as an example
	 driver = new FirefoxDriver();
		
	}

    @Test
    public void testeCasoPerfeito() {
	
	
	realizarBuscaIdeal();
	
	selecionaModalidade("Ensino Regular");
	selecionaEstado("Distrito Federal");
	submit();

	
    }

    private void submit() {
	driver.findElement(By.id("button1id")).click();
    }

    private void selecionaEstado(String estado) {
	new Select(driver.findElement(By.id("select_estado-ideal"))).selectByVisibleText(estado);
    }

    private void selecionaModalidade(String modalidade) {
	new Select(driver.findElement(By.id("modalidade"))).selectByVisibleText(modalidade);
    }

    private void realizarBuscaIdeal() {
	driver.get(baseUrl + "/GuiaEscolaIdeal/index.jsp");
	driver.findElement(By.linkText("Buscar Escola")).click();
	driver.findElement(By.xpath("//section[@id='portfolio']/div/div[2]/div[2]/a/div")).click();
    }

    
/*
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
*/
    @After
    public void close() {
	driver.close();
    }

}
