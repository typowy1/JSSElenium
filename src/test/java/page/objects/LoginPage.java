package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

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


    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this); //metoda do inicjalizowania elementow
    }

    public void typeIntoUserNameField(String username) {
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void typeIntoPasswordField(String password) {
        WaitForElement.waitUntilElementIsVisible(passwordField);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickOnLoginButton() {
        WaitForElement.waitUntilElementIsClickable(loginButton);
        loginButton.click();
    }

    public String getWarningMessage() {
        WaitForElement.waitUntilElementIsVisible(messageLabel);
        return messageLabel.getText();
    }

    public boolean isLoginButtonDisplayed() {
        WaitForElement.waitUntilElementIsVisible(loginButton);
        boolean isDisplayed = loginButton.isDisplayed();
        return isDisplayed;
    }

    public void clickOnFishImageButton() {
        WaitForElement.waitUntilElementIsClickable(btnFishImage);
        btnFishImage.click();
    }

}
