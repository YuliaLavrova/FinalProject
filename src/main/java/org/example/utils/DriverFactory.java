package org.example.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    protected static WebDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(DriverFactory.class);

    public static WebDriver createDriver(){
        String browser = System.getProperty("browser");
        if (browser == null)
            browser = "chrome";
        LOGGER.info("Browser: " + browser);
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("Webdriver.chromedriver", "C:\\chromedriver");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("Webdriver.gecko.driver", "C:\\geckodriver");
            driver = new FirefoxDriver();
        }
        return driver;
    }


//    public static WebDriver createDriver() {
//        URL url;
//        String browser = System.getProperty("browser");
//        if (browser == null)
//            browser = "firefox";
//        try {
//            url = new URL("http://localhost:4444");
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
//        if (browser.equals("chrome")) {
//            ChromeOptions chromeOptions = new ChromeOptions();
//            driver = new RemoteWebDriver(url,chromeOptions);
//        } else if(browser.equals("firefox")) {
//            FirefoxOptions firefoxOptions = new FirefoxOptions();
//            driver = new RemoteWebDriver(url, firefoxOptions);
//        }
//        LOGGER.info("Driver: " + driver);
//        return driver;
//    }
}
