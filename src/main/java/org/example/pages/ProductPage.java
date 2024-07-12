package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    private WebDriver driver;

    @FindBy(xpath = "//button[@class='btn btn-orange btn-buy ']")
    private WebElement addToCartBtn;

    @FindBy(css = ".product__title.js-prod-title")
    private WebElement product;

    @FindBy(xpath = "//span[@class='product__price-value']")
    private WebElement priceOfProduct;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getNameOfProduct() {
        return product.getText();
    }

    public void addToCart() {
        addToCartBtn.click();
    }

    public String getPriceOfProduct() {
        String[] str = priceOfProduct.getText().split(" ");
        String price  = str[0];
        return price;
    }
}
