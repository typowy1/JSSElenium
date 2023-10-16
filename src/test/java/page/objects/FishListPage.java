package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FishListPage {

    @FindBy(css = "a[href*='SW-01']") //tr:nth-child(2) nth-child(2) oznacza, że chcemy wyszukać element, który jest
    // drugim z kolei bezpośrednim dzieckiem swojego rodzica a lub  a[href$='FI-SW-01']
    WebElement angelFishId;

    private WebDriver driver;

    public FishListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //metoda do inicjalizowania elementow
    }

    public void clickOnAngelFishId() {
        angelFishId.click();
    }
}

