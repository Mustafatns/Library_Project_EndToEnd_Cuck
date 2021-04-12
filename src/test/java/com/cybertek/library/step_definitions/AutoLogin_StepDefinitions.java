package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.Dashboard_Page;
import com.cybertek.library.pages.Login_Page;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import com.cybertek.library.utilities.Library_API_BASETEST;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class AutoLogin_StepDefinitions {



    @Given("the user is on login page")
    public void the_user_is_on_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }


    @When("the user logs in with {string} and {string} sees {string}")
    public void the_user_logs_in_with_and_sees(String username, String password, String page) {
        Login_Page loginPage = new Login_Page();
        Dashboard_Page dashboardPage = new Dashboard_Page();

        loginPage.emailInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.signInButton.click();

        BrowserUtils.waitForVisibility(dashboardPage.dashTitle,1);
        String actualTitle = dashboardPage.dashTitle.getText();
        assertThat(actualTitle, is(equalTo(page)));

        Driver.closeDriver();
    }


    @When("the user logs in with {string} and {string} gets status code {int}")
    public void the_user_logs_in_with_and_gets_status_code(String usernameArg, String passwordArg, Integer statusCodeArg) {
        Driver.closeDriver();

        RestAssured.baseURI = "http://library1.cybertekschool.com";
        RestAssured.basePath = "/rest/v1";

        String myToken =
                given()

                        .contentType(ContentType.URLENC)
                        .formParam("email", usernameArg)
                        .formParam("password", passwordArg).
                when()
                        .post("/login")
                        .path("token");

        given()
                .log().uri()
                .header("x-library-token", myToken).
        when()
                .get("/dashboard_stats").
        then()
                .statusCode(statusCodeArg)

        ;


    }
}
