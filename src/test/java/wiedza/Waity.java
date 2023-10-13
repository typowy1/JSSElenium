package wiedza;

public class Waity {

//    Implicit Wait – niejawne czekanie
//    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//Wywołanie metody implicitWait() jest wywołaniem globalnym. Działa on globalnie na wszystkie metody findElement() oraz findElements()

//    Explicit Wait – jawne czekanie (Klasa FluentWait oraz WebDriverWait)
//Explicit Wait a raczej interfejs Wait posiada dwie implementacje:
//
//    FluentWait
//    WebDriverWait (dziedziczy po klasie FluentWait)
//Klasa ExpectedConditions
//
//    Jest to klasa służąca, do sprawdzenia czy dany WebElement, spełnia oczekiwany warunek z ang. „Expected Condition”. Jaki to może być warunek? Wszystko zależy od użytej przez nas metody. Klasa posiada aktualnie ponad 50 różnych metod, do których, najważniejsze z nich to:
//
//    elementToBeClickable() – sprawdza czy element jest widoczny (visible) oraz dostępny (enabled)
//    elementToBeSelected() – sprawdza czy element można zaznaczyć
//    invisibilityOf() – sprawdza czy element będzie niewidoczny (zniknie)
//    presenceOfElementLocated() – sprawdza czy element jest dostępny w DOM
//    textToBePresentInElement() – sprawdza, że WebElement posiada zadany przez nas tekst
//    visibilityOf() - Czy podany element jest widoczny
//    visibilityOfElementLocated() – sprawdza, czy element jest dostępny w DOM oraz widoczny
//
//    Strategia używania tylko Explicit Wait:
//
//    Czeka na konkretny WebElement oraz jego stan
//    Możliwość czekania na konkretne zdarzenie np. element posiada tekst lub konkretny atrybut HTMLowy
//    Możliwość tworzenia „własnych zdarzeń”, na które czekamy
//    Możliwość dostosowania czekania z krótszym lub dłuższym czasem i interwałem
//    Możliwość ignorowania wyjątków
//
//    Podsumowując jasno możemy stwierdzić, że używanie strategii Explicit Wait będzie dla nas lepsze. Dzięki większym możliwościom jakie daje nam klasa FluentWait.


}
