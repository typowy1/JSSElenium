package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenuPage {
    @FindBy(css = "#MenuContent a[href*='signonForm']")
    WebElement signOnLink;

    @FindBy(css = "a[href*='FISH'] img")
    WebElement fishLink;

    private WebDriver driver;

    public TopMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnSignInLink() {
        signOnLink.click();
    }

    public void clickOnFishLink() {
        fishLink.click();
    }
}
