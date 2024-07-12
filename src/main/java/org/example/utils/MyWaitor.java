package org.example.utils;

import org.checkerframework.checker.index.qual.EnsuresLTLengthOf;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MyWaitor {

    public static WebElement waitElement(WebElement element, WebDriver driver) {
        WebElement webElement = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
        return webElement;
    }

    public static List<WebElement> waitElements(List<WebElement> elements, WebDriver driver) {
        List<WebElement> webElements = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElements(elements));
        return webElements;
    }
}
