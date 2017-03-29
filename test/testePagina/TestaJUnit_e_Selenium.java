package testePagina;

import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestaJUnit_e_Selenium {

    // Declarando um objeto do tipo WebDriver, utilizado pelo Selenium WebDriver.
    private static WebDriver driver;

    // Método que inicia tudo que for necessário para o teste
    // Cria uma instância do navegador e abre a página inicial da DevMedia.
    @BeforeClass
    public static void setUpTest() {
        // carrega o driver para que o browser Chrome
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\PROFESSOR\\Downloads\\projNetBeans-TestesSelenium\\TestesSelenium\\driver\\chromedriver.exe");
        // Declarando um objeto do tipo WebDriver.
        driver = new ChromeDriver();
        driver.get("https://mail.ifpa.edu.br");
    }

    // Método que finaliza o teste, fechando a instância do WebDriver.    
    @AfterClass
    public static void tearDownTest() {
     //   driver.quit();
    }

    // Testa título "DevMedia - Cursos, Tutoriais e Vídeos para Desenvolvedores".
    @Test
    public void testaTituloDaPagina() {
        assertEquals("Entrar no cliente Zimbra para Web", driver.getTitle());
    }

    // Método que testa o login no site DevMedia.
    @Test
    public void testaLoginDevMedia() {

        // Instancia um novo objeto do tipo "WebElement", e passa como parâmetro
        // um elemento da tela cujo valor do atributo "name" seja igual a "usuario".
        WebElement element = driver.findElement(By.name("username"));

        // Insere dados no elemento "username".
        element.sendKeys("claudio.martins");

        // Atribui ao objeto “element” o elemento de atributo "name" igual a "password".
        element = driver.findElement(By.name("password"));

        // Insere dados no elemento "senha".
        element.sendKeys("123456");

        // Clica no botão "OK" e submete os dados para concluir o login.
        driver.findElement(By.tagName("form")).submit();
      //  driver.findElement(By.id("imglogar")).click();
    }
}
