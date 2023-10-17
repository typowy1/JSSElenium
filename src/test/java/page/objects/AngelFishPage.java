package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class AngelFishPage {
    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "a.Button[href$='EST-2']")// a.Button[href*='EST-2']
    WebElement smallAngelFishAddToCartLink;


    public AngelFishPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this); //metoda do inicjalizowania elementow
    }

    public void clickToAddToCartSmallAngelFish() {
        WaitForElement.waitUntilElementIsClickable(smallAngelFishAddToCartLink);
        smallAngelFishAddToCartLink.click();
        logger.info("Clicked on angelFishId");
    }
}
