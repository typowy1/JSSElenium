package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        //Ustawienie ścieżki do WebDrivera Chrome
        System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
        //Inicjalizajca ChromeDriver
        driver = new ChromeDriver();
        //Ustawienie Implicit Wait na 10 sekund
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Przejśćie do strony sklepu
        driver.navigate().to("http://przyklady.javastart.pl/jpetstore/");
    }

    @AfterMethod
    public void afterTest() {
        //Zamknięcie okna przeglądarki
        driver.close();
        //Zabicie procesu WebDrivera
        driver.quit();
    }
}
