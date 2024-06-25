package org.example.apiTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class LoginAPITEst {

    @BeforeMethod
    public void url() {
        RestAssured.baseURI = "https://7745.by";
    }

    @Test
    public void getTest() {
        given().
                auth().basic("login", "password")
                .when().get("/login")
                .then().log().all().statusCode(200);
    }

    @Test
    public void postTest() {
        Response response = given().log().all().contentType(ContentType.JSON).body("111")
                .when().post("/register")
                .then().log().all().extract().response();
        assertEquals(response.statusCode(), 419);
    }
}
