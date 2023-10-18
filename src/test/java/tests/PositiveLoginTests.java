package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.FooterPage;
import page.objects.LandingPage;
import page.objects.LoginPage;
import page.objects.TopMenuPage;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.AssertJUnit.assertTrue;

public class PositiveLoginTests extends TestBase {

    @Test
    public void asUserLoginUsingValidLoginAndPassword() {

        LandingPage landingPage = new LandingPage();
        landingPage.clickOnEnterStoreLink();

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickOnSignInLink();

        //można użyć relatywnego linku strony który przekiruje nas bezpośrednio do strony logowania,
        // wtedy kod powyżej nie potrzebny
//        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoUserNameField("j2ee");
        loginPage.typeIntoPasswordField("j2ee");
        loginPage.clickOnLoginButton();
        FooterPage footerPage = new FooterPage();

        assertTrue(footerPage.isBannerAfterLoginDisplayed());
    }
}
