package tests;

import org.testng.annotations.Test;
import page.objects.FooterPage;
import page.objects.LandingPage;
import page.objects.LoginPage;
import page.objects.TopMenuPage;

import static org.testng.AssertJUnit.assertTrue;

public class PositiveLoginTests extends TestBase {

    @Test
    public void asUserLoginUsingValidLoginAndPassword() {
// zastosowany Fluent Interface

//  Dla metod w Page Objectach, które powodują przejście na inną stronę zwracamy obiekt strony na którą przechodzimy
//  Dla metod w Page Objectach, które nie powodują przejścia na inną stronę zwracamy aktualny obiekt strony, stosując słowo kluczowe this

        LandingPage landingPage = new LandingPage();
        landingPage
                .clickOnEnterStoreLink()
                .clickOnSignInLink()
                .typeIntoUserNameField("j2ee")
                .typeIntoPasswordField("j2ee")
                .clickOnLoginButton()
                .isBannerAfterLoginDisplayed();
    }
}
