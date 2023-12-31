package wiedza.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckBoxesTests {
    private WebDriver driver;


    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/checkboxes");
    }

    @Test
    public void checkboxesTest() {
        WebElement firstCheckbox = driver.findElement(By.xpath("//*[@type='checkbox'][1]")); //*[@id=\'checkboxes\']/input[1]
        WebElement secondCheckbox = driver.findElement(By.xpath("//*[@type='checkbox'][2]"));


        assertFalse(firstCheckbox.isSelected());
        assertTrue(secondCheckbox.isSelected());

        firstCheckbox.click();
        secondCheckbox.click();

        assertFalse(secondCheckbox.isSelected());
        assertTrue(firstCheckbox.isSelected());
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
