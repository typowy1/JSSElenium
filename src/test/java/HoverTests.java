import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class HoverTests {

    private WebDriver driver;


    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/hovers");
    }

    @Test
    public void hoverTest() {
        WebElement firstUserAvatar = driver.findElement(By.xpath("//*[@class='figure'][1]/img")); //*[@id='content']/div/div[1]
        WebElement secondUserAvatar = driver.findElement(By.xpath("//*[@class='figure'][2]/img"));
        WebElement thirdUserAvatar = driver.findElement(By.xpath("//*[@class='figure'][3]/img"));

        Actions actions = new Actions(driver);
        actions.moveToElement(firstUserAvatar).perform();

        WebElement firstUserCaption = driver.findElement(By.xpath("//*[@class='figure'][1]/div/h5")); //div[1]/div/h5
        WebElement secondUserCaption = driver.findElement(By.xpath("//*[@class='figure'][2]/div/h5"));
        WebElement thirdUserCaption = driver.findElement(By.xpath("//*[@class='figure'][3]/div/h5"));

        Assert.assertEquals(firstUserCaption.getText(), "name: user1");
        Assert.assertEquals(secondUserCaption.getText(), "");
        Assert.assertEquals(thirdUserCaption.getText(), "");

        actions.moveToElement(secondUserAvatar).perform();

        Assert.assertEquals(firstUserCaption.getText(), "");
        Assert.assertEquals(secondUserCaption.getText(), "name: user2");
        Assert.assertEquals(thirdUserCaption.getText(), "");

        actions.moveToElement(thirdUserAvatar).perform();

        Assert.assertEquals(firstUserCaption.getText(), "");
        Assert.assertEquals(secondUserCaption.getText(), "");
        Assert.assertEquals(thirdUserCaption.getText(), "name: user3");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
