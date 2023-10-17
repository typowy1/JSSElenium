package driver.manager;

import driver.browser.BrowserFactory;
import driver.browser.BrowserType;
import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static WebDriver driver;
    private static final BrowserType BROWSER_TYPE = BrowserType.CHROME;
///wzorzec Singleton do zarządzania WebDriverem, http://www.algorytm.org/wzorce-projektowe/singleton-singleton/singleton-j.html
//  wzorzec projektowy gwarantujący istnienie tylko jednego obiektu danego rodzaju. Udostępnia też pojedynczy punkt dostępowy do takiego obiektu z dowolnego miejsca w programie.

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {
        if (driver == null) {
            //Ustawienie ścieżki do WebDrivera
            driver = BrowserFactory.getBrowser(BROWSER_TYPE);
        }
        return driver;
    }

    public static void disposeDriver() {
        //Zamknięcie okna przeglądarki
        driver.close();

        //Zabicie procesu WebDrivera
        if (!BROWSER_TYPE.equals(BrowserType.FIREFOX)) {
            driver.quit();
        }
        //przypisanie null do drivera żeby usunac go z pamieci i potem wzbudzic nowy driver
        driver = null;
    }
}
