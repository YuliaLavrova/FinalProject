package org.example.uiTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ShoppingSite7745 {

    @FindBy(xpath = "//input[@value='Зарегистрироваться']")
    private WebElement RegistrationBtn;

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("Webdriver.chromedriver", "C://chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://7745.by/");
    }

    @Test
    public void tryToRegisterWithIncorrectEmailTest() {
        driver.findElement(By.id("logon-link")).click();
        driver.findElement(By.xpath("//button[text()='Зарегистрироваться']")).click();
        driver.findElement(By.id("customer_registration_name_")).sendKeys("Ivanov");
        driver.findElement(By.id("customer_registration_phone_")).sendKeys("888999");
        driver.findElement(By.id("customer_registration_email_")).sendKeys("a");
        driver.findElement(By.id("accepted_offer-8313")).click();
        RegistrationBtn.click();
        driver.findElement(By.cssSelector(".recaptcha-checkbox-border")).click();
        RegistrationBtn.click();
        WebElement text = driver.findElement(By.cssSelector(".messages.error"));
        Assert.assertEquals(text.getText(), "Необходимо указать корректный адрес электронной почты.");
    }

    @AfterTest
    public void closeSession() {
        driver.quit();
    }
}
