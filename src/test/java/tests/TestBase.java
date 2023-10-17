package tests;

import driver.manager.DriverManager;
import driver.manager.DriverUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    @BeforeMethod
    public void beforeTest() {
        //Inicjalizajca ChromeDriver
        DriverManager.getWebDriver();
        //Ustawienie Implicit Wait na 10 sekund
        //maksymalny rozmiar przegladarki
        DriverUtils.setInitialConfiguration();
        //Przejśćie do strony sklepu
        DriverUtils.navigateToPage("http://przyklady.javastart.pl/jpetstore/");
    }

    @AfterMethod
    public void afterTest() {
        //Zamknięcie okna przeglądarki
        //Zabicie procesu WebDrivera
        //przypisanie null do drivera żeby usunac go z pamieci i potem wzbudzic nowy driver
        DriverManager.disposeDriver();
    }
}
