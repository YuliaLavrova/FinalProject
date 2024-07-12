package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    @FindBy(id = "logon-link")
    private WebElement logInBtn;

    @FindBy(id = "(//*[@value='Войти'])[2]")
    private WebElement logInSecondBtn;

    @FindBy(xpath = "(//*[text()='Зарегистрироваться'])[2]")
    private WebElement registrationFirstBtn;

    @FindBy(id = "customer_registration_name_")
    private WebElement nameTextArea;

    @FindBy(id = "customer_registration_phone_")
    private WebElement phoneRegistrationTextArea;

    @FindBy(xpath = "(//*[@id='login-modal-input-login'])[2]")
    private WebElement phoneLoginTextArea;

    @FindBy(xpath = "(//*[@id='password'])[2]")
    private WebElement passwordLoginTextArea;

    @FindBy(id = "customer_registration_email_")
    private WebElement emailTextArea;

    @FindBy(xpath = "(//*[@name='accepted_offer'])[2]")
    private WebElement agreeCheckbox;

    @FindBy(xpath = "(//*[@value='Зарегистрироваться'])[2]")
    private WebElement registrationSecondBtn;

    @FindBy(css = ".messages.error")
    private WebElement errorMessage;

    @FindBy(css = ".messages.error")
    private WebElement openCartBtn;

    @FindBy(id = "pass-first_")
    private WebElement passwordTextArea;

    @FindBy(id = "pass-last_")
    private WebElement confirmPasswordTextArea;

    @FindBy(xpath = "(//*[@class='messages error'])[1]")
    private WebElement errorMessageConfirmPassword;

    @FindBy(id = "search")
    private WebElement searchTextArea;

    @FindBy(css = ".btn.btn-search")
    private WebElement searchBtn;

    @FindBy(css = ".btn.btn-orange.js-accept-cookies")
    private static WebElement acceptCookieBtn;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openUrl() {driver.get("https://7745.by/");}

    public RegistrationForm openRegistrationForm() {
        logInBtn.click();
        registrationFirstBtn.click();
        return new RegistrationForm(driver);
    }

    public LoginForm openLoginForm() {
        logInBtn.click();
        return new LoginForm(driver);
    }

    public CartPage openCart() {
        openCartBtn.click();
        return new CartPage(driver);
    }

    public CatalogPage searchItem(String itemName) {
        searchTextArea.sendKeys(itemName);
        searchBtn.click();
        return new CatalogPage(driver);
    }

    public void acceptCookie() {
        acceptCookieBtn.click();
    }

}
