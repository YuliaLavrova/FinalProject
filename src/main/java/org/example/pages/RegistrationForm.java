package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationForm {

    private WebDriver driver;

    @FindBy(id = "logon-link")
    private WebElement logInBtn;

    @FindBy(xpath = "(//*[text()='Зарегистрироваться'])[2]")
    private WebElement registrationFirstBtn;

    @FindBy(id = "customer_registration_name_")
    private WebElement nameTextArea;

    @FindBy(id = "customer_registration_phone_")
    private WebElement phoneRegistrationTextArea;

    @FindBy(id = "customer_registration_email_")
    private WebElement emailTextArea;

    @FindBy(xpath = "(//*[@name='accepted_offer'])[2]")
    private WebElement agreeCheckbox;

    @FindBy(xpath = "(//*[@value='Зарегистрироваться'])[2]")
    private WebElement registrationSecondBtn;

    @FindBy(css = ".messages.error")
    private WebElement errorMessage;

    @FindBy(id = "pass-first_")
    private WebElement passwordTextArea;

    @FindBy(id = "pass-last_")
    private WebElement confirmPasswordTextArea;

    @FindBy(xpath = "(//*[@class='messages error'])[1]")
    private WebElement errorMessageConfirmPassword;

    public RegistrationForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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

    public String getErrorMessageWithConfirmPassword(String password) {
        passwordTextArea.sendKeys(password);
        String incorrectPassword = password.replace(password.charAt(0), '0');
        confirmPasswordTextArea.sendKeys(incorrectPassword);
        registrationSecondBtn.click();
        String errorMessage = errorMessageConfirmPassword.getText();
        return errorMessage;
    }


}
