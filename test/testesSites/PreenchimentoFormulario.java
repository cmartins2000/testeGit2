package testesSites;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PreenchimentoFormulario {
	
	@Test
	public void preencheFormularioCorreiosBuscaLogradouroPorBairro() {
		// carrega o driver para que o browser Chrome 
		System.setProperty("webdriver.chrome.driver",
				  "C:\\Users\\PROFESSOR\\Downloads\\projNetBeans-TestesSelenium\\TestesSelenium\\driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		// Visita a pagina do Correios
		driver.get("http://www.buscacep.correios.com.br/sistemas/buscacep/buscaLogBairro.cfm");
		
		// Escolhe o valor de UF
		Select selectUF = new Select(driver.findElement(By.name("UF")));
		selectUF.selectByVisibleText("RJ");
		// Preenche a Localidade com o valor "Rio de Janeiro"
		WebElement inputLocalidade = driver.findElement(By.name("Localidade"));
		inputLocalidade.sendKeys("Rio de Janeiro");
		// Preenche o campo Bairro com o valor "Copacabana"
		WebElement inputBairro = driver.findElement(By.name("Bairro"));
		inputBairro.sendKeys("Copacabana");
		
		// clica no botao Buscar
		WebElement buttonBuscar = driver.findElement(By.cssSelector("input[type='submit'"));
		buttonBuscar.click();
		
		// verifica se ha resultados
		String codigoPagina = driver.getPageSource();
		assertThat(codigoPagina, Matchers.containsString("DADOS ENCONTRADOS COM SUCESSO."));
		assertNotNull(driver.findElement(By.cssSelector("table.tmptabela")));
		
		//driver.quit();
	}

}
