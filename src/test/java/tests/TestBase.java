package tests;

import configuration.ConfigurationProperties;
import configuration.PropertiesLoader;
import driver.manager.DriverManager;
import driver.manager.DriverUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

import static navigation.ApplicationURLs.APPLICATION_URL;

public class TestBase {

    @BeforeClass
    public void beforeClass() {
//        usunąć przy zmianie metody pobierającej wartości z properiesów
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);
    }

    @BeforeMethod
    public void beforeTest() {
        //Inicjalizajca ChromeDriver
        DriverManager.getWebDriver();
        //Ustawienie Implicit Wait na 10 sekund
        //maksymalny rozmiar przegladarki
        DriverUtils.setInitialConfiguration();
        //Przejśćie do strony sklepu
//        DriverUtils.navigateToPage("http://przyklady.javastart.pl/jpetstore/");
//        relatywne url
        DriverUtils.navigateToPage(APPLICATION_URL);
    }

    @AfterMethod
    public void afterTest() {
        //Zamknięcie okna przeglądarki
        //Zabicie procesu WebDrivera
        //przypisanie null do drivera żeby usunac go z pamieci i potem wzbudzic nowy driver
        DriverManager.disposeDriver();
    }
}
