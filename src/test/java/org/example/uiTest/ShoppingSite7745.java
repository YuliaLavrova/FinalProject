package org.example.uiTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.pages.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ShoppingSite7745 extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(ShoppingSite7745.class);

    @Test
    public void tryToLoginWithIncorrectData() {
        String phone = " ";
        String password = "111111Qe";
        String errorMessageExpected = "Извините, указанный номер телефона или пароль неверны. Попробуйте набрать снова.";
        HomePage homePage = new HomePage(driver);
        homePage.openUrl();
        LoginForm loginForm = homePage.openLoginForm();
        String errorMessage = loginForm.getErrorMessageWithIncorrectLogin(phone, password);
        LOGGER.info("The next error message displayed: " + errorMessage);
        Assert.assertEquals(errorMessage, errorMessageExpected);
    }

    @Test
    public void tryToRegisterWithIncorrectPassword() {
        String name = "Petrov Peter";
        String phone = "292356672";
        String email = "it@mail.ru";
        String password = "111111Qe";
        String errorMessageExpected = "Подтверждение пароля не совпадает с введённым паролем, попробуйте снова.";
        HomePage homePage = new HomePage(driver);
        homePage.openUrl();
        RegistrationForm registrationForm = homePage.openRegistrationForm();
        registrationForm.fillRegistrationForm(name, phone, email);
        String errorMessage = registrationForm.getErrorMessageWithConfirmPassword(password);
        LOGGER.info(password + " was entered as password");
        LOGGER.info("The next error message displayed: " + errorMessage);
        Assert.assertEquals(errorMessage, errorMessageExpected);
    }

    @DataProvider(name = "email")
    public Object[][] createData() {
        return new Object[][]{
                {"Ivanov", "2356671", "a"},
                {"Peter", "2345677", "1@"},
                {"Helen", "2145677", "@com"},
                {"Kate", "2125677", "q@com."}
        };
    }

    @Test(dataProvider = "email")
    public void tryToRegisterWithIncorrectEmailTest(String name, String phone, String email) {
        String errorMessageExpected = "Необходимо указать корректный адрес электронной почты.";
        HomePage homePage = new HomePage(driver);
        homePage.openUrl();
        RegistrationForm registrationForm = homePage.openRegistrationForm();
        String errorMessage = registrationForm.getErrorMessageWithIncorrectEmail(name, phone, email);
        LOGGER.info(email + " was typed into Email text field");
        LOGGER.info("Error message appeared: " + errorMessage);
        Assert.assertEquals(errorMessage, errorMessageExpected);
    }

    @Test
    public void searchItemsTest() {
        String item = "Палатка";
        boolean assertItem = false;
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.openUrl();
        List<String> list = catalogPage.getListOfItems(item);
        LOGGER.info(item + " was typed into search text field");
        for (String textElement : list) {
            assertItem = false;
            if (textElement.contains(item)) {
                assertItem = true;
            }
        }
//        for (String i:
//             list) {
//            String[] arr = i.split(" ");
//            assertItem = false;
//            for (String word:
//                 arr) {
//                if(word.equals(item)) {
//                    assertItem = true;
//                    break;
//                }
//            }
        Assert.assertTrue(assertItem, "There are extra items displayed");
    }

    @Test
    public void addItemToCartTest() {
        int index = 3;
        String itemForSearch = "палатка";
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.openUrl();
        catalogPage.searchAnyItem(itemForSearch);
        List<String> list = catalogPage.getListOfItems(itemForSearch);
        String itemInCatalog = list.get(index);
        LOGGER.info(itemInCatalog + " was added to the cart");
        catalogPage.clickAddToCartBtn(index);
        CartPage cartPage = new CartPage(driver);
        cartPage.openUrl();
        LOGGER.info(cartPage.getNameOfItemCart() + " is in the cart");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(cartPage.getNameOfItemCart(), itemInCatalog.toLowerCase());
        softAssert.assertEquals(cartPage.getPriceOfItemCart(), catalogPage.getPriceOfItemCatalog());
        softAssert.assertAll();
    }
}
