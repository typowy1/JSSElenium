package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPage {
    private Logger logger = LogManager.getRootLogger();

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

    public LoginPage typeIntoUserNameField(String username) {
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.clear();
        usernameField.sendKeys(username);
        logger.info("Typed into User Name Field {}", username);
        return this;
    }

    public LoginPage typeIntoPasswordField(String password) {
        WaitForElement.waitUntilElementIsVisible(passwordField);
        passwordField.clear();
        passwordField.sendKeys(password);
        logger.info("Typed into Password Field {}", password);
        return this;
    }

    public FooterPage clickOnLoginButton() {
        WaitForElement.waitUntilElementIsClickable(loginButton);
        loginButton.click();
        logger.info("Clicked on Login Button");
        return new FooterPage();
    }

    public String getWarningMessage() {
        WaitForElement.waitUntilElementIsVisible(messageLabel);
        String warningText = messageLabel.getText();
        logger.info("Returned warning message was: {}", warningText);
        return warningText;
    }

    public boolean isLoginButtonDisplayed() {
        WaitForElement.waitUntilElementIsVisible(loginButton);
        boolean isDisplayed = loginButton.isDisplayed();
        logger.info("Returning status of login button: {}", isDisplayed);
        return isDisplayed;
    }

    public void clickOnFishImageButton() {
        WaitForElement.waitUntilElementIsClickable(btnFishImage);
        btnFishImage.click();
        logger.info("Clicked on btnFishImage");
    }

}
