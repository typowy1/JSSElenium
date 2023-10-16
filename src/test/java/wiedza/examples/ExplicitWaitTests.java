package wiedza.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class ExplicitWaitTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_controls");
    }

    @Test //czekanie az element zniknie
    public void waitForDisappearingElement() {
        WebElement checkbox = driver.findElement(By.cssSelector("#checkbox input"));
        assertTrue(checkbox.isDisplayed());
        assertFalse(checkbox.isSelected());

        WebElement removeButton = driver.findElement(By.xpath("//*[@id='checkbox-example']/button"));
        removeButton.click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(250));
        webDriverWait.until(ExpectedConditions.invisibilityOf(checkbox));//Sprawdzi, że po jakimś czasie zniknie chcekbox

        WebElement message = driver.findElement(By.id("message"));
        Assert.assertEquals(message.getText(), "It's gone!");
    }

    @Test
    public void waitForPresenceOfTheElement() {
        WebElement checkbox = driver.findElement(By.id("checkbox"));

        assertTrue(checkbox.isDisplayed());
        assertFalse(checkbox.isSelected());

        WebElement removeButton = driver.findElement(By.cssSelector("[onclick='swapCheckbox()'"));
        removeButton.click();

        WaitUntil waitUntil = new WaitUntil(driver);
        waitUntil.waitUntilElementIsInvisible(checkbox);

        WebElement messageLabel = driver.findElement(By.id("message"));
        assertEquals(messageLabel.getText(), "It's gone!");

        removeButton.click();

//        tu żucało StaleElementReferenceException dlatego że przeładowała się strona i nie mógł znaleźć elementu checkbox
//        wystarczyło jeszcze raz zainicjalizować element z waitem waitUntilPresenceOfElementLocated
//        który czeka aż element pokaże sie w DOM
//        Wyjątek StaleElementReferenceException występuje gdy Selenium wykonuje akcję na WebElemencie, który został częściowo
//        lub całkowicie przeładowany. To znaczy, że jego adres w DOMie został zmieniony i Selenium odnosi się do WebElementu,
//                który w strukturze DOM już nie istnieje. Jak w takim razie obronić się przed tym wyjątkiem? Odpowiedź na to
//        pytanie jest bardzo prosta, wystarczy jeszcze raz wyszukać WebElement przy pomocy metody findElement() lub wykorzystać
//        odpowiednią metodę z klasy ExpectedConditions, która zwróci nam nowo przeładowany WebElement. W rozwiązaniu powyżej
//        wykorzystaliśmy metodę o nazwie presenceOfElementLocated, która zwraca WebElement po jego znalezieniu w DOM.

        checkbox = waitUntil.waitUntilPresenceOfElementLocated(By.id("checkbox")); //poczekaj az pokaze sie w DOM i zwróci element

        assertTrue(checkbox.isDisplayed());
        assertFalse(checkbox.isSelected());
    }


    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
