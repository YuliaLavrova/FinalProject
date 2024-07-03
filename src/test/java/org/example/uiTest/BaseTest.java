package org.example.uiTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.listeners.TestListener;
import org.example.utils.DriverManager;
import org.example.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;

    private static final Logger LOGGER = LogManager.getLogger(BaseTest.class);

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.createDriver();
        LOGGER.info("browser: " + driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ScreenshotUtil.saveScreenshot(driver);
    }

    @AfterTest
    public void closeSession() {
        driver.quit();
    }

}
