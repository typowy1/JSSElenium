package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class ShoppingCartPage {
    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "a.Button[href*='newOrderForm=']")//a[href$='newOrderForm='] $ kończy się ciągiem znaków newOrderForm=.
    WebElement proceedToCheckoutButton;

    public ShoppingCartPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this); //metoda do inicjalizowania elementow
    }

    public void clickOnProceedToCheckoutButton() {
        WaitForElement.waitUntilElementIsClickable(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        logger.info("Clicked on proceedToCheckoutButton");
    }
}
