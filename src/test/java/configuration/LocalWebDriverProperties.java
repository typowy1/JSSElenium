package configuration;

import driver.browser.BrowserType;

public class LocalWebDriverProperties {
    //    można to napisać prościej, java start rest assured lub szkoła testowania backendu 2(tu najprostrza)

//    klasa będzie dostarczała właściwości związanych z ścieżkami do plików *.exe oraz przeglądarki, na której ma być uruchomiony test

// Metody zwracają właściwości dla poszczególnych kluczy, analogicznie jak w przypadku AppProperties

    public static BrowserType getLocalBrowser() {
        return BrowserType.valueOf(ConfigurationProperties.getProperties().getProperty("local.browser"));
    }

    public static String getChromeWebDriverLocation() {
        return ConfigurationProperties.getProperties().getProperty("chrome.driver.location");
    }

    public static String getFirefoxWebDriverLocation() {
        return ConfigurationProperties.getProperties().getProperty("firefox.driver.location");
    }

    public static String getInternetExplorerWebDriverLocation() {
        return ConfigurationProperties.getProperties().getProperty("ie.driver.location");
    }
}

