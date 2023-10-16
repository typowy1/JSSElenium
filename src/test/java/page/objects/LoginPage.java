package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(name = "username")
    WebElement usernameField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(name = "signon")
    WebElement loginButton;

    @FindBy(css = "#Content ul[class='messages'] li")
    WebElement messageLabel;

    @FindBy(css = "area[alt='Fish']")
    private WebElement btnFishImage;

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //metoda do inicjalizowania elementow
    }

    public void typeIntoUserNameField(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void typeIntoPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public String getWarningMessage() {
        return messageLabel.getText();
    }

    public boolean isLoginButtonDisplayed() {
        boolean isDisplayed = loginButton.isDisplayed();
        return isDisplayed;
    }

    public void clickOnFishImageButton() {
        btnFishImage.click();
    }

}
