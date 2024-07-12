package org.example.apiTest;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNull;

public class APITest extends BaseAPITest{

    private static final Logger LOGGER = LogManager.getLogger(APITest.class);

    @Test
    public void incorrectLoginTest() {
        List<String> errorMessageExpected = new ArrayList<>();
        errorMessageExpected.add("Извините, указанный номер телефона или пароль неверны. Попробуйте набрать снова.");
        Map<String,String> formParams = new HashMap<>();
        formParams.put("prefix","375");
        formParams.put("login","(678");
        formParams.put("password","123");
        formParams.put("remember","on");
        formParams.put("target","");
        formParams.put("looking_page","Nzc0NS5ieS8=");
        Response response = given().log().all().formParams(formParams)
                .cookie(cookie)
                .header("x-csrf-token", token)
                .when().post("/login")
                .then().log().all().extract().response();
        assertEquals(200, response.statusCode());
        List<String> errorMessage = response.jsonPath().getList("errors.login");
        LOGGER.info("Error message in case of incorrect credentials: " + errorMessage);
        assertEquals(errorMessage, errorMessageExpected);
    }

    @Test
    public void searchTest() {
        String id = "467283";
        given().header("x-csrf-token", token)
                .cookie(cookie)
                .when().get("/site-search-get-item?contentType=4&id=" + id)
                .then().log().all().statusCode(200)
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("json/jsonschema.json"));
    }

    @Test
    public void addToCartTest() {
        Integer id = 831060;
        List<Integer> idList = new ArrayList<>();
        idList.add(id);
        LOGGER.info("ProductId of item: " + idList);
        Map<String, String> formParams = new HashMap<>();
        formParams.put("id", String.valueOf(id));
        formParams.put("quantity", "2");
        Response response = given().header("x-csrf-token", token)
                .cookie(cookie)
                .formParams(formParams)
                .when().post("cart/item/add")
                .then().log().all().statusCode(200)
                .extract().response();
        List<Integer> productId = response.jsonPath().getList("ordered.prodId");
        LOGGER.info("ProductId of item added to cart is: " + productId);
        assertEquals(idList, productId);
    }

    @Test(dependsOnMethods = "addToCartTest")
    public void deleteItemFromCartTest() {
        String id = "831060";
        Response response = given().header("x-csrf-token", token)
                .cookie(cookie)
                .formParams("id", id)
                .when().post("cart/item/delete")
                .then().log().all().statusCode(200)
                .extract().response();
        String productId = response.jsonPath().getString("prodId");
        LOGGER.info("ProductId after item has been deleted is: " + productId);
        assertNull(productId);
    }
}
