package driver.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static WebDriver driver;
///wzorzec Singleton do zarządzania WebDriverem, http://www.algorytm.org/wzorce-projektowe/singleton-singleton/singleton-j.html

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {
        if (driver == null) {
            //Ustawienie ścieżki do WebDrivera Chrome
            System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void disposeDriver(){
        //Zamknięcie okna przeglądarki
        driver.close();
        //Zabicie procesu WebDrivera
        driver.quit();
        //przypisanie null do drivera żeby usunac go z pamieci i potem wzbudzic nowy driver
        driver = null;
    }
}
