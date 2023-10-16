package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AngelFishPage {
    @FindBy(css = "a.Button[href$='EST-2']")// a.Button[href*='EST-2']
    WebElement smallAngelFishAddToCartLink;

    private WebDriver driver;

    public AngelFishPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //metoda do inicjalizowania elementow
    }

    public void clickToAddToCartSmallAngelFish(){
        smallAngelFishAddToCartLink.click();
    }
}
