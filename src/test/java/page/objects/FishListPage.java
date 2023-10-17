package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class FishListPage {
    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "a[href*='SW-01']") //tr:nth-child(2) nth-child(2) oznacza, że chcemy wyszukać element, który jest
    // drugim z kolei bezpośrednim dzieckiem swojego rodzica a lub  a[href$='FI-SW-01']
    WebElement angelFishId;


    public FishListPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this); //metoda do inicjalizowania elementow
    }

    public void clickOnAngelFishId() {
        WaitForElement.waitUntilElementIsClickable(angelFishId);
        angelFishId.click();
        logger.info("Clicked on angelFishId");
    }
}

