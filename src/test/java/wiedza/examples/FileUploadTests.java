package wiedza.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/upload");
    }

    @Test
    public void fileUploadTest() {
        WebElement uploadFileField = driver.findElement(By.id("file-upload"));
        uploadFileField.sendKeys("C:/testfile.txt");

        WebElement submitField = driver.findElement(By.id("file-submit"));
        submitField.click();

        WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));
        assertEquals(uploadedFile.getText(), "testfile.txt");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

    private void sleep() { // to nie wait, tylko po to zeby zwolnic test i zobczyc czy dziala
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
    }
}
