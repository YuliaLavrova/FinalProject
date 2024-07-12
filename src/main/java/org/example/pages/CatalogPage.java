package org.example.pages;

import org.example.utils.MyWaitor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CatalogPage {

    private WebDriver driver;

    @FindBy(id = "search")
    private WebElement searchTextArea;

    @FindBy(css = ".btn.btn-search")
    private WebElement searchBtn;

    @FindBy(css = ".item-block_name.item-block_name--tile")
    private WebElement itemFromCatalog;

    @FindBy(xpath = "//*[@class='item-block_name item-block_name--tile']")
    private List<WebElement> itemsFromCatalog;

    @FindBy(className = ".btn.btn-orange.btn-buy.js-show-spinner")
    private WebElement addToCartBtn;

    @FindBy(className = ".btn.btn-orange.btn-buy.js-show-spinner")
    private List<WebElement> addToCartAllBtn;

    @FindBy(css = ".item-block_main-price>span")
    private WebElement priceOfItemFromCatalog;

    @FindBy(css = ".btn.btn-orange.js-accept-cookies")
    private static WebElement acceptCookieBtn;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void openUrl()  {driver.get("https://7745.by/catalog");}

    public List<String> getListOfItems(){
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,300);");
        List<WebElement> items = new ArrayList<>(itemsFromCatalog);
        return itemsFromCatalog.stream().map(x->x.getText()).toList();
    }

    public ProductPage searchParticularItem(String itemName){
        searchTextArea.sendKeys(itemName);
        searchBtn.click();
        return new ProductPage(driver);
    }

    public List<WebElement> getItemsFromCatalog() {
        return itemsFromCatalog;
    }
}
