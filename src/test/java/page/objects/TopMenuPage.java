package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class TopMenuPage {
    @FindBy(css = "#MenuContent a[href*='signonForm']")
    WebElement signOnLink;

    @FindBy(css = "a[href*='FISH'] img")
    WebElement fishLink;


    public TopMenuPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnSignInLink() {
        WaitForElement.waitUntilElementIsClickable(signOnLink);
        signOnLink.click();
    }

    public void clickOnFishLink() {
        WaitForElement.waitUntilElementIsVisible(fishLink);
        fishLink.click();
    }
}
