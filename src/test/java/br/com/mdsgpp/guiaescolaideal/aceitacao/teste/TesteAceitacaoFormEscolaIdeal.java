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

	Select listaModalidade = new Select(driver.findElement(By
		.name("modalidade")));
	listaModalidade.selectByVisibleText("Ensino Regular");

	Select listaEstado = new Select(driver.findElement(By.name("estado")));
	listaEstado.selectByVisibleText("Distrito Federal");

	WebElement radioLabInfo = driver.findElement(By.name("labinf"));
	radioLabInfo.click();

	WebElement radioLabCiencia = driver.findElement(By.name("labcien"));
	radioLabCiencia.click();

	WebElement submit = driver.findElement(By.name("submit"));
	submit.click();

	String linkPagAtual = driver.getCurrentUrl();

	assertTrue(!linkPag.equalsIgnoreCase(linkPagAtual));
    }

    @Test
    public void testeSemInserirEstado() {
	Select listaModalidade = new Select(driver.findElement(By
		.name("modalidade")));
	listaModalidade.selectByVisibleText("Ensino Regular");

	WebElement submit = driver.findElement(By.name("submit"));
	submit.click();

	String texto = driver.switchTo().alert().getText();

	driver.switchTo().alert().accept();

	assertTrue(texto.equals("Selecione um estado"));

    }

    @Test
    public void testeMunicipioComCaracteresInvalidos() {
	Select listaModalidade = new Select(driver.findElement(By
		.name("modalidade")));
	listaModalidade.selectByVisibleText("Ensino Regular");

	Select listaEstado = new Select(driver.findElement(By.name("estado")));
	listaEstado.selectByVisibleText("Distrito Federal");

	WebElement radioLabInfo = driver.findElement(By.name("labinf"));
	radioLabInfo.click();

	WebElement radioLabCiencia = driver.findElement(By.name("labcien"));
	radioLabCiencia.click();

	WebElement municipio = driver.findElement(By.name("municipio"));
	municipio.sendKeys("$%$จ&%จจจ&%");

	WebElement submit = driver.findElement(By.name("submit"));
	submit.click();

	String texto = driver.switchTo().alert().getText();
	driver.switchTo().alert().accept();

	assertTrue(texto != null && !texto.isEmpty());
    }
    
    @Test
    public void testeNaoEncontrarEscola() {
	Select listaModalidade = new Select(driver.findElement(By
		.name("modalidade")));
	listaModalidade.selectByVisibleText("Ensino Regular");

	Select listaEstado = new Select(driver.findElement(By.name("estado")));
	listaEstado.selectByVisibleText("Distrito Federal");

	WebElement radioLabInfo = driver.findElement(By.name("labinf"));
	radioLabInfo.click();

	WebElement municipio = driver.findElement(By.name("municipio"));
	municipio.sendKeys("Java");

	WebElement radioLabCiencia = driver.findElement(By.name("labcien"));
	radioLabCiencia.click();

	WebElement submit = driver.findElement(By.name("submit"));
	submit.click();
	
	String linkPag = driver.getCurrentUrl();
	assertTrue(linkPag
		.equalsIgnoreCase("http://localhost:8765/GuiaEscolaIdeal/realizarConsultaEscolaEspecifica.jsp"));

	assertTrue(driver.getPageSource().contains(
		"Consulta nใo retornou nenhuma escola com esses atributos."));

    }

    @Test
    public void testeModalidadeVazia()
    {
	
	Select listaEstado = new Select(driver.findElement(By.name("estado")));
	listaEstado.selectByVisibleText("Distrito Federal");

	WebElement radioLabInfo = driver.findElement(By.name("labinf"));
	radioLabInfo.click();

	WebElement radioLabCiencia = driver.findElement(By.name("labcien"));
	radioLabCiencia.click();

	WebElement submit = driver.findElement(By.name("submit"));
	submit.click();
	
	String texto = driver.switchTo().alert().getText();
	driver.switchTo().alert().accept();
	
	assertTrue(texto.equalsIgnoreCase("Selecione uma modalidade"));
	
	
    }
    @After
    public void close() {
	driver.close();
    }

}
