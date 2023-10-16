package tests;

import org.testng.annotations.Test;
import page.objects.*;

import static org.testng.Assert.*;

public class ShoppingCartTest extends TestBase {

    @Test
    public void asNotLoggedInUserIShallNotProceedToCheckout(){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnEnterStoreLink();

        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.clickOnFishLink();

        FishListPage fishListPage = new FishListPage(driver);
        fishListPage.clickOnAngelFishId();

        AngelFishPage angelFishPage = new AngelFishPage(driver);
        angelFishPage.clickToAddToCartSmallAngelFish();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickOnProceedToCheckoutButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.isLoginButtonDisplayed();

        assertTrue(loginPage.isLoginButtonDisplayed());
        assertEquals(loginPage.getWarningMessage(),
                "You must sign on before attempting to check out. Please sign on and try checking out again.");

    }
}
