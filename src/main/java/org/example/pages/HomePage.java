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

    public void login(String phone, String password) {
        logInBtn.click();
        phoneLoginTextArea.sendKeys(phone);
        passwordLoginTextArea.sendKeys(password);
    }

    public void fillRegistrationForm(String name, String phone, String email) {
        nameTextArea.sendKeys(name);
        phoneRegistrationTextArea.sendKeys(phone);
        emailTextArea.sendKeys(email);
        agreeCheckbox.click();
    }
    public String getErrorMessageWithIncorrectEmail(String name, String phone, String email ) {
        fillRegistrationForm(name, phone, email);
        registrationSecondBtn.click();
        return errorMessage.getText();
    }

    public String getErrorMessageWithIncorrectLogin(String phone, String password) {
        login(phone, password);
        logInSecondBtn.click();
        return errorMessage.getText();
    }

    public String getErrorMessageWithConfirmPassword(String password) {
        passwordTextArea.sendKeys(password);
        String incorrectPassword = password.replace(password.charAt(0), '0');
        confirmPasswordTextArea.sendKeys(incorrectPassword);
        registrationSecondBtn.click();
        String errorMessage = errorMessageConfirmPassword.getText();
        return errorMessage;
    }

    public ProfilePage loginProfile(String name, String phone, String email)  {
        fillRegistrationForm(name, phone, email);
        return new ProfilePage(driver);
    }

    public CartPage openCart() {
        openCartBtn.click();
        return new CartPage(driver);
    }
}
