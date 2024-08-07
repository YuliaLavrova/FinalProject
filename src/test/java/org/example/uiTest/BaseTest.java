package org.example.uiTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.listeners.TestListener;
import org.example.pages.HomePage;
import org.example.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;

    private static final Logger LOGGER = LogManager.getLogger(BaseTest.class);

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createDriver();
        LOGGER.info("browser: " + driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }
}
