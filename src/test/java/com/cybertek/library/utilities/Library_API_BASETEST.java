package com.cybertek.library.utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.http.ContentType;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class Library_API_BASETEST {

//    public static String libraryToken;
    @Before
    public static void init(){

        RestAssured.baseURI = "http://library1.cybertekschool.com";
        RestAssured.basePath = "/rest/v1";

//        libraryToken = getToken("librarian69@library","KNPXrm3S");

    }

    @After
    public static void cleanUp(){
        RestAssured.reset();
    }

    public static String getToken(String username, String password) {
        String myToken =
         given()
                .contentType(ContentType.URLENC)
                .formParam("email", username)
                .formParam("password", password).
                        when()
                .post("/login")
                .path("token");

        return myToken;
    }



}
