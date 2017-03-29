package testePagina;

import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestaPaginaIndex {

    @Test
    public void testSelectedIdOfSizeComboBox() {

        // carrega o driver para que o browser Chrome
        System.setProperty("webdriver.chrome.driver",
                "D:\\sistemas\\restClienteTestes\\TestesSelenium\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:8084/restcliente/index.html");
        
        WebElement valorElemento = driver.findElement(By.name("size"));
        
        Select dropdown = new Select(valorElemento);
      
        assertEquals("medium", valorElemento);
    }
}
