package org.example.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CatalogPage {

    private WebDriver driver;

    @FindBy(id = "search")
    private WebElement searchTextArea;

    @FindBy(css = ".btn.btn-search")
    private WebElement searchBtn;

    @FindBy(className = ".item-block_name.item-block_name--tile")
    private List<WebElement> itemsFromCatalog;

    @FindBy(className = ".btn.btn-orange.btn-buy.js-show-spinner")
    private WebElement addToCartBtn;

    @FindBy(className = ".btn.btn-orange.btn-buy.js-show-spinner")
    private List<WebElement> addToCartAllBtn;

    @FindBy(css = ".item-block_main-price>span")
    private WebElement priceOfItemFromCatalog;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void openUrl()  {driver.get("https://7745.by/catalog");}

    public void searchAnyItem(String itemName){
        searchTextArea.sendKeys(itemName);
        searchBtn.click();
    }
    public List<String> getListOfItems(String itemName){
        searchAnyItem(itemName);
        return itemsFromCatalog.stream().map(x->x.getText()).toList();
    }

    public String getNameOfItemCatalog(int index) {
        return itemsFromCatalog.get(index).getText();
    }
    public void clickAddToCartBtn(int index) {
        ((JavascriptExecutor)driver).executeScript("arguments[index].click();", addToCartAllBtn.get(index));
    }

    public String getPriceOfItemCatalog() {
        return priceOfItemFromCatalog.getText();
    }
}
