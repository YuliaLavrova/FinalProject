package org.example.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    protected static WebDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(DriverManager.class);
    public static WebDriver createDriver(){
        String browser = System.getProperty("browser");
        LOGGER.info("Browser: " + browser);
        if (browser == null)
            browser = "chrome";
        LOGGER.info("Browser: " + browser);
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("Webdriver.chromedriver", "C://chromedriver");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C://geckodriver");
            driver = new FirefoxDriver();
        }
        LOGGER.info("Driver: " + driver);
        return driver;
    }
}
