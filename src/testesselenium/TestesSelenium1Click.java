package testesselenium;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestesSelenium1Click {

    public static void main(String[] args) {
        // carrega o driver para que o browser Chrome
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\PROFESSOR\\Downloads\\projNetBeans-TestesSelenium\\TestesSelenium\\driver\\chromedriver.exe");
        // Declarando um objeto do tipo WebDriver.
        WebDriver driver = new ChromeDriver();

        driver.get("http://ruf.folha.uol.com.br/2016/");
                // "http://localhost:8084/restcliente/index.html");

        // Cria lista de objetos do tipo WebElement que recebe 
        // as células da tabela acima.
        WebElement bt = driver.findElement(By.tagName("form"));
        bt.submit();
        
        
    }

}
