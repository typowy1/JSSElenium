package tests;

import org.testng.annotations.Test;
import page.objects.*;

import static org.testng.Assert.*;

public class ShoppingCartTest extends TestBase {

    @Test
    public void asNotLoggedInUserIShallNotProceedToCheckout(){
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnEnterStoreLink();

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickOnFishLink();

        FishListPage fishListPage = new FishListPage();
        fishListPage.clickOnAngelFishId();

        AngelFishPage angelFishPage = new AngelFishPage();
        angelFishPage.clickToAddToCartSmallAngelFish();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.clickOnProceedToCheckoutButton();

        LoginPage loginPage = new LoginPage();
        loginPage.isLoginButtonDisplayed();

        assertTrue(loginPage.isLoginButtonDisplayed());
        assertEquals(loginPage.getWarningMessage(),
                "You must sign on before attempting to check out. Please sign on and try checking out again.");

    }
}
