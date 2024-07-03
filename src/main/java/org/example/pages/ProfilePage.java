package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProfilePage {

    private WebDriver driver;

    @FindBy(xpath = "(//*[@class='profile-grid-item__title'])[2]")
    private WebElement nameOfUser;

    @FindBy(xpath = "((//*[@class='profile-grid-item__list'])[2]/div[2]")
    private WebElement phoneOfUser;

    @FindBy(xpath = "((//*[@class='profile-grid-item__list'])[2]/div[1]")
    private WebElement emailOfUser;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openUrl() {driver.get("https://7745.by/profile/common");}

    public String getName() {
        return nameOfUser.getText();
    }

    public String getPhoneNumber() {
        return phoneOfUser.getText();
    }

    public String getEmail() {

        return emailOfUser.getText();
    }
}
