package wiedza.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class WebElementsTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
//        driver.navigate().to("http://przyklady.javastart.pl/test/full_form.html");
    }

    @Test
    //wpisywanie kestu
    public void typingIntoWebElementTest() {
        WebElement useNameField = driver.findElement(By.id("username"));
        sleep();
        useNameField.sendKeys("Selenium Start");
        String typeUserNameValue = useNameField.getAttribute("value"); //pobierze nam tekst wpisany wcześniej do pola
        sleep();
        assertEquals(typeUserNameValue, "Selenium Start");
    }

    @Test
//    dodawanie pliku
    public void filePickingTest() {
        //Wstrzyknięcie pliku nie uda się, jeśli nie wskażemy naszym lokatorem tag-a HTMLowego typu input z atrybutem type=”file”
        sleep();
        WebElement uploadFilePicker = driver.findElement(By.id("upload_file"));
        uploadFilePicker.sendKeys("C:\\test.txt");
        sleep();
    }

    @Test
    //czyszczenie wartosci w z pola input
    public void typingAndClearingValueInsideWebElementTest() {
        WebElement useNameField = driver.findElement(By.id("username"));
        sleep();
        useNameField.sendKeys("Selenium Start");
        String typeUserNameValue = useNameField.getAttribute("value"); //pobierze nam tekst wpisany wcześniej do pola
        sleep();
        assertEquals(typeUserNameValue, "Selenium Start");

        useNameField.clear();
        sleep();
        String emptyUserNameField = useNameField.getAttribute("value");
        assertEquals(emptyUserNameField, "");
    }

    //kliknięcie w radio button
    @Test
    public void checkRadioButtonTest() {
        WebElement maleRadioButton = driver.findElement(By.cssSelector("input[value='male']"));
        WebElement femaleRadioButton = driver.findElement(By.cssSelector("input[value='female']"));

        sleep();
        maleRadioButton.click();
        sleep();
        assertTrue(maleRadioButton.isSelected()); //tak sprawdzimy czy przycisk jest zaznaczony

        sleep();
        femaleRadioButton.click();
        assertTrue(femaleRadioButton.isSelected()); //tak sprawdzimy czy przycisk jest zaznaczony
        assertFalse(maleRadioButton.isSelected()); //tu sprawdzimy czy radio mail zostało odznaczone
    }

    @Test
    //zaznaczenie chcekboksa
    public void checkboxButtonTest() {
        WebElement pizzaCheckbox = driver.findElement(By.cssSelector("input[value='pizza']"));
        WebElement spaghettiCheckbox = driver.findElement(By.cssSelector("input[value='spaghetti']"));
        WebElement hamburgerCheckbox = driver.findElement(By.cssSelector("input[value='hamburger']"));

        assertFalse(pizzaCheckbox.isSelected()); //potwierdzamy że nie jest zaznaczony
        assertFalse(spaghettiCheckbox.isSelected()); //potwierdzamy że nie jest zaznaczony
        assertFalse(hamburgerCheckbox.isSelected()); //potwierdzamy że nie jest zaznaczony

        sleep();
        pizzaCheckbox.click(); // zaznaczamy chcek box
        spaghettiCheckbox.click();
        hamburgerCheckbox.click();

        assertTrue(pizzaCheckbox.isSelected());//potwierdzamy że jest zaznaczony
        assertTrue(spaghettiCheckbox.isSelected());//potwierdzamy że jest zaznaczony
        assertTrue(hamburgerCheckbox.isSelected());//potwierdzamy że jest zaznaczony

        sleep();
        pizzaCheckbox.click();
        spaghettiCheckbox.click();
        hamburgerCheckbox.click();

        sleep();
        assertFalse(pizzaCheckbox.isSelected()); //potwierdzamy że nie jest zaznaczony
        assertFalse(spaghettiCheckbox.isSelected()); //potwierdzamy że nie jest zaznaczony
        assertFalse(hamburgerCheckbox.isSelected()); //potwierdzamy że nie jest zaznaczony
    }

    @Test
//    dropDownListing select, zwrócenie opcji wyboru
    public void dropDownListingTest() {

        WebElement countryWebElement = driver.findElement(By.id("country"));
        Select countryDropDown = new Select(countryWebElement); //do obsługi kontrolki dropdown, list wyboru

        List<WebElement> options = countryDropDown.getOptions(); // pobierze nam wszystkie dostepne opcje

//        options.stream().forEach(e -> System.out.println(e.getText())); //wyświeltlamy wszystkie dostępne opcje
//        List<String> nameOfOptions = options.stream()// tworzymy liste stringów z listy wyciągniętymi opcjami
//                .map(WebElement::getText)
//                .collect(Collectors.toList());

        // lub tak

        List<String> nameOfOptions = new ArrayList<>(); // tworzymy liste stringów z listy wyciągniętymi opcjami
        for (WebElement option : options) {
            nameOfOptions.add(option.getText());// dodajemy do niej elementy
            System.out.println(option.getText());//wyświeltlamy wszystkie dostępne opcje
        }

        List<String> expectedNamesOfOptions = new ArrayList<>(); //tworzymy array list oczekiwanych wyników
        expectedNamesOfOptions.add("Germany");
        expectedNamesOfOptions.add("Poland");
        expectedNamesOfOptions.add("UK");

        assertEquals(nameOfOptions, expectedNamesOfOptions);
    }

    @Test //Wybranie opcji z dropdowna przy pomocy select
    public void selectingOptionsFromDropDownTest() {

//        najbezpieczniej uzywać metody  selectByValue() jesli niema to niechdeweloperzy dodadza
//        atrybut value jak nie moga to używamy selectByVisibleText()

        WebElement countryWebElement = driver.findElement(By.id("country"));
        Select countryDropDown = new Select(countryWebElement); //do obsługi kontrolki dropdown, list wyboru

        sleep();
        countryDropDown.selectByIndex(1); //po indeksie wybierzemy Poland sprawdzimy czy opcja została rzeczywiście wybrana

        sleep();
        //sprawdzimy czy opcja została rzeczywiście wybrana
        assertEquals(countryDropDown.getFirstSelectedOption().getText(), "Poland");

//        wybieramy po atrybucie value de_DE
        countryDropDown.selectByValue("de_DE");
        sleep();
        assertEquals(countryDropDown.getFirstSelectedOption().getText(), "Germany");

//        wybieramy po text selectByVisibleText()
        countryDropDown.selectByVisibleText("UK");
        sleep();
        assertEquals(countryDropDown.getFirstSelectedOption().getText(), "UK");
    }


//    isSelected() - używamy do pól typu: Checkbox, Radio button, drop down
//    isDisplayed() - wyświtlone
//    isEnabled() - dostępne

    //czy elementy te są wyświetlone oraz dostępne z ang. enabled.
    @Test
    public void checkIfElementsOnPageTest() {
        //Metoda isEnabled() zwraca fałsz tylko dla pól typu input z atrybutem disabled!
        // w takim wypadku stosujemy assercje assertFalse(passwordField.isEnabled());
        //należy ja stosować tylko do pól typu input

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement emailLabel = driver.findElement(By.cssSelector("span[class='help-block']"));

        //sprawdzamy jaki jest stan pól
        System.out.println("Is usernameField displayed: " + usernameField.isDisplayed());
        System.out.println("Is usernameField enabled: " + usernameField.isEnabled());

        System.out.println("Is passwordField displayed: " + passwordField.isDisplayed());
        System.out.println("Is passwordField enabled: " + passwordField.isEnabled());

        System.out.println("Is emailLabel displayed: " + emailLabel.isDisplayed());
        System.out.println("Is emailLabel enabled: " + emailLabel.isEnabled());

        assertTrue(usernameField.isDisplayed());
        assertTrue(passwordField.isDisplayed());
        assertTrue(emailLabel.isDisplayed());

        assertTrue(usernameField.isEnabled());
        assertFalse(passwordField.isEnabled());
        //assertTrue(emailLabel.isEnabled()); to nie jest inputem i nie mozemy zastosowac is enapled
    }


    //Actions

    //    clickAndHold()
//    contextClick()
//    doubleClick()
//    dragAndDrop()
//    keyDown()
//    keyUp()
//    release()
//    tick()
    @Test //najechanie myszką na jeden element klikniecie przytrzymanie potem na drugi
    public void hoverOverAndClickAndHoldTest() {
        driver.navigate().to("http://przyklady.javastart.pl/test/hover_mouse.html");

        WebElement smileyIcon = driver.findElement(By.id("smiley"));

        Actions action = new Actions(driver);//klasa do niestandardowych akcji

        action.moveToElement(smileyIcon).click().build().perform();

        sleep();

        Actions secondAction = new Actions(driver);
        WebElement smileyIcon2 = driver.findElement(By.id("smiley2"));

        secondAction.clickAndHold(smileyIcon2).build().perform();

        sleep();
//        Metoda build() – służy do zebrania wielu akcji, które chcemy wykonać i zrobienia z nich jednego bloku gotowego do wykonania.
//        Metoda perform() – służy do bezpośredniego wykonania pojedynczej akcji lub zbioru akcji (bloku).
//        Metodę build() stosujemy zawsze wtedy, kiedy mamy więcej niż jedną akcję. Metody nie musimy stosować, kiedy mamy tylko jedną akcję do wykonania.
//        Metodę perform() stosujemy zawsze, niezależnie od tego, czy mamy jedną czy wiele akcji.
    }


    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

    private void sleep() { // to nie wait, tylko po to zeby zwolnic test i zobczyc czy dziala
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
    }
}
