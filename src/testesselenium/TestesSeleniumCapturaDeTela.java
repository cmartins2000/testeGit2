package testesselenium;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
 

public class TestesSeleniumCapturaDeTela {

    public static void main(String[] args) throws Exception {
        new TestesSeleniumCapturaDeTela().myTestChrome();
    }

    public void myTestChrome() throws Exception {
        // carrega o driver para que o browser Chrome
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\PROFESSOR\\Downloads\\projNetBeans-TestesSelenium\\TestesSelenium\\driver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com.br");

        //As duas formas mais usadas para obter um screenshot sao:
        //obter um objeto File OU um array de bytes
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte[] screenshotByteArray = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        //Salva um screenshot do tipo File, usando a classe
        //FileUtils (org.apache.commons.io.FileUtils)
        FileUtils.copyFile(screenshotFile, new File("c:/temp/screenshot_com_file.png"));

        //Salva um screenshot de byte[], usando a classe
        //FileOutputStream (java.io.FileOutputStream)
        FileOutputStream outputStream = new FileOutputStream("c:/temp/screenshot_com_byte_array.png");
        outputStream.write(screenshotByteArray);

    }

    public void myTestFirefox() throws Exception {

        // carrega o driver para que o browser Firefox
        System.setProperty("webdriver.gecko.driver", "C:/soft/workspace/testesSelenium/driver/geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        // WebDriver driver = new RemoteWebDriver(
        // new URL("http://localhost:4444/wd/hub"),
        // DesiredCapabilities.firefox());

        driver.get("https://www.google.com.br");

        // RemoteWebDriver does not implement the TakesScreenshot class
        // if the driver does have the Capabilities to take a screenshot
        // then Augmenter will add the TakesScreenshot methods to the instance
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
    }
}
