package com.cybertek.library.utilities;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class Library_API_BASETEST {

    public static String libraryToken;
    @BeforeAll
    public static void init(){

        RestAssured.baseURI = "http://library1.cybertekschool.com";
        RestAssured.basePath = "/rest/v1";

        libraryToken = getToken("librarian69@library","KNPXrm3S");

    }

    @AfterAll
    public static void cleanUp(){
        RestAssured.reset();
    }

    @Test
    public void test(){

        given()
                .header("x-library-token",libraryToken).
        when()
                .get("/dashboard_stats").
        then()
                .log().all()
                .statusCode(200);


    }



    public static String getToken(String username, String password) {
        return given()
                .contentType(ContentType.URLENC)
                .formParam("email", username)
                .formParam("password", password).
                        when()
                .post("/login")
                .path("token");

    }



}
