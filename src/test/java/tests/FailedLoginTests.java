package tests;

import org.testng.annotations.Test;
import page.objects.LandingPage;
import page.objects.LoginPage;
import page.objects.TopMenuPage;

import static org.testng.Assert.assertEquals;

public class FailedLoginTests extends TestBase {

    @Test
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnEnterStoreLink();
        //Kliknięcie w link "Enter the Store"

        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.clickOnSignInLink();
        //Kliknięcie w link "Sign In"

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoUserNameField("NotExistingLogin");
        //Wpisanie w polu Username wartośći "NotExistingLogin"

        loginPage.typeIntoPasswordField("NotProperPassword");
        //Wpisanie w polu Password wartości "NotProperPassword"

        loginPage.clickOnLoginButton();
        //Kliknięcie w przycisk Login

        assertEquals(loginPage.getWarningMessage(), "Invalid username or password. Signon failed.");
        //Sprawdzenie czy na stronie pojawił się komunikat "Invalid username or password. Signon failed."
        // przez sprawdzenie jaki tekssignOnButton t wyświetli się w elemencie
    }
}
