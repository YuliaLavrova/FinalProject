package org.example.pages;

import org.example.utils.MyWaitor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginForm {

    private WebDriver driver;

    @FindBy(id = "logon-link")
    private WebElement logInBtn;

    @FindBy(xpath = "(//*[@value='Войти'])[2]")
    private WebElement logInSecondBtn;

    @FindBy(xpath = "(//*[@id='login-modal-input-login'])[2]")
    private WebElement phoneLoginTextArea;

    @FindBy(xpath = "(//*[@id='password'])[2]")
    private WebElement passwordLoginTextArea;

    @FindBy(css = ".messages.error")
    private WebElement errorMessage;

    public LoginForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String phone, String password) {
        phoneLoginTextArea.sendKeys(phone);
        passwordLoginTextArea.sendKeys(password);
    }

    public String getErrorMessageWithIncorrectLogin(String phone, String password) {
        login(phone, password);
        logInSecondBtn.click();
        return errorMessage.getText();
    }

}
