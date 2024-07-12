package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='product-item__title']/a")
    private WebElement itemInCart;

    @FindBy(css = ".product-item__price--main")
    private WebElement priceOfItemInCart;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openUrl() {driver.get("https://7745.by/cart");}

    public String getNameOfItemCart() {
        return itemInCart.getText().toLowerCase();
    }

    public String getPriceOfItemCart() {
        String[] str = priceOfItemInCart.getText().split(" ");
        String price  = str[0];
        return price;
    }
}
