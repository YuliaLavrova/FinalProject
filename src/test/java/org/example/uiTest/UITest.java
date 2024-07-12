package org.example.uiTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.pages.*;
import org.example.utils.ScreenshotUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class ShoppingSite7745 extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(ShoppingSite7745.class);

    @Test
    public void tryToLoginWithIncorrectDataTest() {
        String phone = " ";
        String password = "111111Qe";
        String errorMessageExpected = "Извините, указанный номер телефона или пароль неверны. Попробуйте набрать снова.";
        HomePage homePage = new HomePage(driver);
        homePage.openUrl();
        LoginForm loginForm = homePage.openLoginForm();
        String errorMessage = loginForm.getErrorMessageWithIncorrectLogin(phone, password);
        ScreenshotUtil.saveScreenshot(driver);
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
        ScreenshotUtil.saveScreenshot(driver);
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
        ScreenshotUtil.saveScreenshot(driver);
        LOGGER.info("Error message appeared: " + errorMessage);
        Assert.assertEquals(errorMessage, errorMessageExpected);
    }

    @Test
    public void searchItemsTest() {
        String item = "FAIRY Сочный Лимон";
        boolean assertItem = false;
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.openUrl();
        List<String> list = catalogPage.getListOfItems(item);
        ScreenshotUtil.saveScreenshot(driver);
        LOGGER.info(item + " was typed into search text field");
        LOGGER.info(list.size() + " of items are in the list");
        Assert.assertTrue(list.size() > 0,  "There are no items found");
        List<String> errorList = new ArrayList<>();
        for (String textElement : list) {
            assertItem = false;
            if (textElement.contains(item)) {
                assertItem = true;
            }else{
                errorList.add(textElement);
            }
        }
//        for (String i:
//                list) {
//            String[] arr = i.split(" ");
//            assertItem = false;
//            for (String word :
//                    arr) {
//                if (word.equalsIgnoreCase(item)) {
//                    assertItem = true;
//                    break;
//                }
//            }
//        }
        Assert.assertTrue(assertItem, "There are extra items displayed: " +  errorList);
    }

    @Test
    public void addItemToCartTest() {
        String itemForSearch = "средство для мытья посуды fairy сочный лимон 0,9 л (4015400869443)";
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.openUrl();
        ProductPage productPage = catalogPage.searchParticularItem(itemForSearch);
        String nameOfItem = productPage.getNameOfProduct();
        LOGGER.info(nameOfItem + "is found");
        String price = productPage.getPriceOfProduct();
        LOGGER.info("The price of product is " + price);
        ScreenshotUtil.saveScreenshot(driver);
        productPage.addToCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.openUrl();
        ScreenshotUtil.saveScreenshot(driver);
        LOGGER.info(cartPage.getNameOfItemCart() + " is in the cart");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(cartPage.getNameOfItemCart(), itemForSearch.toLowerCase());
        softAssert.assertEquals(cartPage.getNameOfItemCart(), nameOfItem.toLowerCase());
        softAssert.assertEquals(cartPage.getPriceOfItemCart(), price);
        softAssert.assertAll();
    }
}
