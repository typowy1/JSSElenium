package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    @FindBy(css = "a.Button[href*='newOrderForm=']")//a[href$='newOrderForm='] $ kończy się ciągiem znaków newOrderForm=.
    WebElement proceedToCheckoutButton;

    private WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //metoda do inicjalizowania elementow
    }

    public void clickOnProceedToCheckoutButton(){
        proceedToCheckoutButton.click();
    }
}
